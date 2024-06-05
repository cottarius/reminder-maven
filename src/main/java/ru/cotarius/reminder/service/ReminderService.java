package ru.cotarius.reminder.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cotarius.reminder.entity.Reminder;
import ru.cotarius.reminder.repository.ReminderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final TelegramBotService telegramBot;
    private final MyEmailService myEmailService;
    private final PasswordEncoder passwordEncoder;

    public List<Reminder> findByUserId(Long userId, String keyword) {
        if (keyword != null) {
            return reminderRepository.search(keyword);
        }
        return reminderRepository.findByUserId(userId);
    }

    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public void delete( Reminder reminder) {
        reminderRepository.delete(reminder);
    }

    public void update(long id, Reminder reminder) {
        Reminder myReminder = reminderRepository.findById(id);
        myReminder.setId(id);
        myReminder.setTitle(reminder.getTitle());
        myReminder.setDescription(reminder.getDescription());
        myReminder.setRemind(reminder.getRemind());
        myReminder.setReminded(false);
        reminderRepository.save(myReminder);
    }

    public Reminder findById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void checkAndSendReminder() {
        LocalDateTime now = LocalDateTime.now();
        List<Reminder> dueReminders = reminderRepository.findByRemindBefore(now);
        for (Reminder reminder : dueReminders) {
            if (!reminder.isReminded()) {
                String message = String.format("Напоминание: %s\n%s",
                        reminder.getTitle(),
                        reminder.getDescription());
                telegramBot.sendMessage(message, reminder.getUser().getTelegramId());
                myEmailService.sendSimpleEmail(reminder.getUser().getEmail(),
                        reminder.getTitle(),
                        reminder.getDescription());
                reminder.setReminded(true);
            }
        }
    }
}

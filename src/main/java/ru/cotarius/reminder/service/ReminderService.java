package ru.cotarius.reminder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cotarius.reminder.entity.Reminder;
import ru.cotarius.reminder.repository.ReminderRepository;
import ru.cotarius.reminder.telegram.TelegramSender;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final TelegramSender telegramSender;

    public List<Reminder> findByUserId(Long userId) {
        return reminderRepository.findByUserId(userId);
    }

    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public void delete(Reminder reminder) {
        reminderRepository.delete(reminder);
    }

    public void update(long id, Reminder reminder) {
        Reminder myReminder = reminderRepository.findById(id);
        myReminder.setTitle(reminder.getTitle());
        myReminder.setDescription(reminder.getDescription());
        myReminder.setRemind(reminder.getRemind());
        reminderRepository.save(myReminder);
    }

    public Reminder findByTitle(String title) {
        return reminderRepository.findReminderByTitle(title);
    }

    public Reminder findByDescription(String description) {
        return reminderRepository.findReminderByDescription(description);
    }

    public List<Reminder> findAll() {
        return reminderRepository.findAll();
    }

    public Reminder findById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    public void sendTelegramMessage(Long userId, Reminder reminder) {

    }

//    public Reminder findByDate(LocalDate date) {
//        return reminderRepository.findReminderByDate(date);
//    }
//
//    public Reminder findByTime(LocalTime time) {
//        return reminderRepository.findReminderByTime(time);
//    }
}

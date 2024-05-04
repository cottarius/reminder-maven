package ru.cotarius.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.cotarius.reminder.entity.Reminder;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    Reminder findReminderByTitle(String title);
    Reminder findReminderByDescription(String description);
    List<Reminder> findByUserId(Long userId);
    Reminder findById(long id);
    List<Reminder> findByRemindBefore(LocalDateTime dueDate);
//    Reminder findReminderByDate(LocalDate date);
//    Reminder findReminderByTime(LocalTime time);
}

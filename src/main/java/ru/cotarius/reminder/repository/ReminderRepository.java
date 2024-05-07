package ru.cotarius.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cotarius.reminder.entity.Reminder;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    List<Reminder> findByUserId(Long userId);

    Reminder findById(long id);

    List<Reminder> findByRemindBefore(LocalDateTime dueDate);

    @Query("select r from Reminder r where r.title like %?1%"
            + " or r.description like %?1%"
            + " or concat(r.remind, '') like %?1%")
    List<Reminder> search(String keyword);

}

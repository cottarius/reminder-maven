package ru.cotarius.reminder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cotarius.reminder.entity.Reminder;
import ru.cotarius.reminder.entity.User;
import ru.cotarius.reminder.service.ReminderService;
import ru.cotarius.reminder.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReminderController {
    private final ReminderService reminderService;
    private final UserService userService;

    @GetMapping("/reminds/{id}")
    public String deleteReminder(@PathVariable Long id, Model model) {
        Reminder reminder = reminderService.findById(id);
        reminderService.delete(reminder);
        return "redirect:/reminds";
    }

    @GetMapping("/reminds")
    public String getReminds(Principal principal, Model model, @Param("keyword") String keyword) {
        User user = userService.findByUsername(principal.getName());
        List<Reminder> reminds = reminderService.findByUserId(user.getId(), keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("reminds", reminds);
        model.addAttribute("user", user);
        return "reminds";
    }

    @GetMapping("/reminds/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model){
        Reminder reminder = reminderService.findById(id);
        model.addAttribute("reminder", reminder);
        return "edit-remind";
    }

    @PostMapping("/reminds/{id}")
    public String updateReminder(@PathVariable long id,
                                 @ModelAttribute Reminder reminder,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            reminder.setId(id);
            return "edit-remind";
        }
        reminderService.update(id, reminder);
        return "redirect:/reminds";
    }

    @GetMapping("/reminds/new")
    public String newRemindForm(Model model) {
        Reminder reminder = new Reminder();
        model.addAttribute("reminder", reminder);
        return "new_remind";
    }

    @PostMapping(value = "/reminds")
    public String saveRemind(@ModelAttribute("reminder") Reminder reminder, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        reminder.setUser(user);
        reminderService.save(reminder);
        return "redirect:/reminds";
    }
}

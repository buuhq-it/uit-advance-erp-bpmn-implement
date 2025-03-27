package uit.advancecrm.group17.bpmn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/user/dashboard")
    @PreAuthorize("hasRole('USER')")
    public String userDashboard(Model model) {
        model.addAttribute("message", "Welcome to the User Dashboard!");
        return "user-dashboard";
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard(Model model) {
        model.addAttribute("message", "Welcome to the Admin Dashboard!");
        return "admin-dashboard";
    }

    @GetMapping("/user/profile")
    @PreAuthorize("hasRole('USER')")
    public String userProfile(Model model) {
        model.addAttribute("message", "This is your user profile.");
        return "user-profile";
    }

    @GetMapping("/admin/manage")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminManage(Model model) {
        model.addAttribute("message", "Manage the system here.");
        return "admin-manage";
    }


    @GetMapping("/shared/content")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String sharedContent(Model model) {
        model.addAttribute("message", "This content is accessible to both USER and ADMIN roles.");
        return "shared-content";
    }

    @GetMapping("/advanced/manage")
    @PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
    public String advancedManage(Model model) {
        model.addAttribute("message", "This is for users who are both USER and ADMIN.");
        return "advanced-manage";
    }

    @GetMapping("/restricted/report")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('USER') and authentication.name == 'specialuser')")
    public String restrictedReport(Model model) {
        model.addAttribute("message", "Accessible to ADMIN or a specific USER named 'specialuser'.");
        return "restricted-report";
    }

    @GetMapping("/multi-role/task")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'GUEST')")
    public String multiRoleTask(Model model) {
        model.addAttribute("message", "Accessible to USER, ADMIN, or GUEST roles.");
        return "multi-role-task";
    }
}

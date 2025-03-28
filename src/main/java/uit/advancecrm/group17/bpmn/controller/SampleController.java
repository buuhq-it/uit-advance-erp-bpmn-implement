package uit.advancecrm.group17.bpmn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
    // Trang dành cho ADMIN
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("hasAuthority('ADMIN')")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping("/admin")
    public String adminPage() {
        return "sample/admin";  // Render trang admin.html
    }

    // Trang dành cho USER
//    @PreAuthorize("hasRole('ROLE_USER')")
    @Secured({ "ROLE_USER" })
    @GetMapping("/user")
    public String userPage() {
        return "sample/user";  // Render trang user.html
    }

    // Trang chung cho tất cả mọi người
    @GetMapping("/")
    public String homePage() {
        return "sample/home";  // Render trang home.html
    }
}

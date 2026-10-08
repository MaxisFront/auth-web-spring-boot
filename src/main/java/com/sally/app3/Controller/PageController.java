package com.sally.app3.Controller;

import com.sally.app3.Model.User;
import com.sally.app3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String returnIndex() {
        return "forward:/index.html";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("nombre") String username,
                               @RequestParam("contrasena") String password,
                               Model model) {
        User user = userRepository.findByNombre(username);

        if (user != null && user.getContrasena().equals(password)) {
            return "redirect:/src/views/admin.html";
        } else {
            return "redirect:/?error=true";
        }
    }

}

package fi.eriran.criminalapi.main.rest;

import fi.eriran.criminalapi.main.pojo.user.ChangePassword;
import fi.eriran.criminalapi.main.pojo.user.NewUser;
import fi.eriran.criminalapi.main.pojo.user.User;
import fi.eriran.criminalapi.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody NewUser newUser) {
        return userService.create(newUser);
    }

    @PatchMapping(path = "/{id}")
    public User changePassword(@PathVariable Integer userId, @RequestBody String newPassword) {
        return userService.changePassword(new ChangePassword(userId, newPassword));
    }
}
package ru.kurtukov.spingbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kurtukov.spingbootdemo.profile.SystemProfile;

public class ProfileController {
    @RestController
    @RequestMapping("/")
    public class ProfileController {
        private SystemProfile profile;

        public ProfileController(SystemProfile profile) {
            this.profile = profile;
        }

        public String getProfile() {
            return profile.getProfile();
        }
    }
}

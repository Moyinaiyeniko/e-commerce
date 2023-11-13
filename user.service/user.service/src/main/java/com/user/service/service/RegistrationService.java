package com.user.service.service;

import com.user.service.dto.RegistrationRequest;
import com.user.service.entity.AppUser;
import com.user.service.enums.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.
//                test(request.email());
//
//        if (!isValidEmail) {
//            throw new IllegalStateException("email not valid");
//        }

        String token = appUserService.signUpUser(
                new AppUser(
                        request.firstName(),
                        request.lastName(),
                        request.email(),
                        request.password(),
                        AppUserRole.USER

                )
        );
        return token;
    }

}

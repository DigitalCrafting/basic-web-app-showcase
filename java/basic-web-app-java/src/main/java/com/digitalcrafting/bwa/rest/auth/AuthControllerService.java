package com.digitalcrafting.bwa.rest.auth;

import com.digitalcrafting.base.services.ControllerService;
import com.digitalcrafting.base.command.CommandDispatcher;
import com.digitalcrafting.bwa.BwaApplication;
import com.digitalcrafting.bwa.commands.auth.CreateUserCommand;
import com.digitalcrafting.bwa.commands.auth.CreateUserCommandResult;
import com.digitalcrafting.bwa.commands.auth.VerifyUserCommand;
import com.digitalcrafting.bwa.commands.auth.VerifyUserCommandResult;
import com.digitalcrafting.bwa.objects.enums.LoginStatusEnum;
import com.digitalcrafting.bwa.objects.enums.SessionContext;
import com.digitalcrafting.bwa.objects.enums.SignUpStatusEnum;
import com.digitalcrafting.bwa.rest.auth.objects.LoginRequest;
import com.digitalcrafting.bwa.rest.auth.objects.SignUpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ControllerService
class AuthControllerService {
    private final Logger logger = LogManager.getLogger(BwaApplication.class.getName());
    private static final String HASH_ALG = "SHA-256";

    private final CommandDispatcher commandDispatcher;
    private final SessionContext sessionContext;

    public AuthControllerService(CommandDispatcher commandDispatcher, SessionContext sessionContext) {
        this.commandDispatcher = commandDispatcher;
        this.sessionContext = sessionContext;
    }

    LoginStatusEnum isLoggedIn() {
        return sessionContext.isUserLoggedIn() ? LoginStatusEnum.LOGGED_IN : LoginStatusEnum.LOGGED_OUT;
    }

    LoginStatusEnum login(LoginRequest request) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALG);
            String passHash = new String(messageDigest.digest(request.getPassword().getBytes()));

            VerifyUserCommandResult result = commandDispatcher.dispatch(new VerifyUserCommand(
                    request.getUsername(),
                    passHash
            ));

            if (LoginStatusEnum.LOGGED_IN.equals(result.getLoginStatus())) {
                sessionContext.setUserLoggedIn(true);
                sessionContext.setUsername(request.getUsername());
            }

            return result.getLoginStatus();
        } catch (NoSuchAlgorithmException e) {
            logger.info("Logging user with username: " + request.getUsername() + " failed", e);
            return LoginStatusEnum.LOGIN_FAILED;
        }
    }

    SignUpStatusEnum signUp(SignUpRequest request) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALG);
            String passHash = new String(messageDigest.digest(request.getPassword().getBytes()));

            CreateUserCommandResult result = commandDispatcher.dispatch(new CreateUserCommand(
                    request.getUsername(),
                    passHash,
                    request.getFirstName(),
                    request.getLastName()
            ));

            return result.getStatus();
        } catch (NoSuchAlgorithmException e) {
            logger.info("Creating user with username: " + request.getUsername() + " failed", e);
            return SignUpStatusEnum.CREATION_FAILED;
        }
    }
}

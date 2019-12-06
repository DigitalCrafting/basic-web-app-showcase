package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.CommandExecutor;
import com.digitalcrafting.bwa.data.entity.StringPrimaryKey;
import com.digitalcrafting.bwa.data.entity.UserEntity;
import com.digitalcrafting.bwa.data.entitymanagers.UsersEntityManager;
import com.digitalcrafting.bwa.objects.enums.LoginStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class VerifyUserCommandExecutor implements CommandExecutor<VerifyUserCommand, VerifyUserCommandResult> {

    private final UsersEntityManager usersEntityManager;

    public VerifyUserCommandExecutor(UsersEntityManager usersEntityManager) {
        this.usersEntityManager = usersEntityManager;
    }

    @Override
    public VerifyUserCommandResult execute(VerifyUserCommand command) {
        UserEntity userEntity = usersEntityManager.getByPrimaryKey(new StringPrimaryKey(command.getUsername()));

        if (userEntity == null) {
            return new VerifyUserCommandResult(LoginStatusEnum.NOT_EXISTS);
        } else {
            String dbPassword = userEntity.getPasswordHash();
            if (dbPassword != null && dbPassword.equals(command.getPassword())) {
                return new VerifyUserCommandResult(LoginStatusEnum.LOGGED_IN);
            }
            return new VerifyUserCommandResult(LoginStatusEnum.LOGIN_FAILED);
        }
    }
}

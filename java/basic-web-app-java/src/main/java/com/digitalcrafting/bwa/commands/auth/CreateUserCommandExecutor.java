package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.CommandExecutor;
import com.digitalcrafting.bwa.data.entity.StringPrimaryKey;
import com.digitalcrafting.bwa.data.entity.UserEntity;
import com.digitalcrafting.bwa.data.entitymanagers.UsersEntityManager;
import com.digitalcrafting.bwa.objects.enums.SignUpStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandExecutor implements CommandExecutor<CreateUserCommand, CreateUserCommandResult> {

    private final UsersEntityManager usersEntityManager;

    public CreateUserCommandExecutor(UsersEntityManager usersEntityManager) {
        this.usersEntityManager = usersEntityManager;
    }

    @Override
    public CreateUserCommandResult execute(CreateUserCommand command) {
        if (usersEntityManager.getByPrimaryKey(new StringPrimaryKey(command.getUsername())) != null) {
            return new CreateUserCommandResult(SignUpStatusEnum.ALREADY_EXISTS);
        } else {
            UserEntity entity = convert(command);
            usersEntityManager.insert(entity);
            return new CreateUserCommandResult(SignUpStatusEnum.CREATED);
        }
    }

    private static UserEntity convert(CreateUserCommand createUserCommand) {
        UserEntity entity = new UserEntity();

        entity.setPrimaryKey(new StringPrimaryKey(createUserCommand.getUsername()));
        entity.setPasswordHash(createUserCommand.getPasswordHash());
        entity.setFirstName(createUserCommand.getFirstName());
        entity.setLastName(createUserCommand.getLastName());

        return entity;
    }
}

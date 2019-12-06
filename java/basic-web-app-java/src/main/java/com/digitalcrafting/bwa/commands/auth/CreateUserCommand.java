package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserCommand extends Command<CreateUserCommandResult> {
    private final String username;
    private final String passwordHash;
    private final String firstName;
    private final String lastName;
}

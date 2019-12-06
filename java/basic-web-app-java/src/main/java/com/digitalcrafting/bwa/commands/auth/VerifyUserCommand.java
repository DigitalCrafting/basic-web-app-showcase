package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VerifyUserCommand extends Command<VerifyUserCommandResult> {
    private final String username;
    private final String password;
}

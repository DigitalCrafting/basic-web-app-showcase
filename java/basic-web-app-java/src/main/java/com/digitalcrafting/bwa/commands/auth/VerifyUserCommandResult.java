package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.CommandResult;
import com.digitalcrafting.bwa.objects.enums.LoginStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VerifyUserCommandResult extends CommandResult {
    private final LoginStatusEnum loginStatus;
}

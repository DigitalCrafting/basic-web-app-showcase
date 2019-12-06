package com.digitalcrafting.bwa.commands.auth;

import com.digitalcrafting.base.command.CommandResult;
import com.digitalcrafting.bwa.objects.enums.SignUpStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserCommandResult extends CommandResult {
    private final SignUpStatusEnum status;
}

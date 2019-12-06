package com.digitalcrafting.base.command;

public interface CommandExecutor<C extends Command, R extends CommandResult> {
    R execute(C command);
}

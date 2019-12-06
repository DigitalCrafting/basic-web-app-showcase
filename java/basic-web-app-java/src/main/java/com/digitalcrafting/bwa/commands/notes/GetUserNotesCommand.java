package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetUserNotesCommand extends Command<GetUserNotesCommandResult> {
    private final String username;
}

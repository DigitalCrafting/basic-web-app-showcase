package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.Command;
import com.digitalcrafting.base.command.CommandVoidResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteUserNoteCommand extends Command<CommandVoidResult> {
    private final int noteId;
    private final String username;
}

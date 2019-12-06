package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.Command;
import com.digitalcrafting.base.command.CommandVoidResult;
import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateNoteCommand extends Command<CommandVoidResult> {
    private final NoteModel noteModel;
}

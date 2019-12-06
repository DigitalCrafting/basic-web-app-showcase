package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.CommandResult;
import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetUserNotesCommandResult extends CommandResult {
    private final List<NoteModel> notesList;
}

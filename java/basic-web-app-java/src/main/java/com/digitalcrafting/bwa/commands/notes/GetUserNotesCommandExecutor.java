package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.CommandExecutor;
import com.digitalcrafting.bwa.data.entity.NoteEntity;
import com.digitalcrafting.bwa.data.entitymanagers.NotesEntityManager;
import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUserNotesCommandExecutor implements CommandExecutor<GetUserNotesCommand, GetUserNotesCommandResult> {

    private final NotesEntityManager entityManager;

    public GetUserNotesCommandExecutor(NotesEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public GetUserNotesCommandResult execute(GetUserNotesCommand command) {
        List<NoteEntity> entityList = entityManager.getUserNotes(command.getUsername());
        return new GetUserNotesCommandResult(convert(entityList));
    }

    private static List<NoteModel> convert(List<NoteEntity> entityList) {
        if (entityList != null && !entityList.isEmpty()) {
            return entityList.stream()
                    .map(GetUserNotesCommandExecutor::convert)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    private static NoteModel convert(NoteEntity entity) {
        return new NoteModel(
                entity.getPrimaryKey().getNoteId(),
                entity.getPrimaryKey().getUsername(),
                entity.getNoteText()
        );
    }
}

package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.CommandExecutor;
import com.digitalcrafting.base.command.CommandVoidResult;
import com.digitalcrafting.bwa.data.entity.NoteEntity;
import com.digitalcrafting.bwa.data.entity.NotePrimaryKey;
import com.digitalcrafting.bwa.data.entitymanagers.NotesEntityManager;
import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import org.springframework.stereotype.Service;

@Service
public class CreateNoteCommandExecutor implements CommandExecutor<CreateNoteCommand, CommandVoidResult> {

    private final NotesEntityManager entityManager;

    public CreateNoteCommandExecutor(NotesEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CommandVoidResult execute(CreateNoteCommand command) {
        NoteEntity entity = convert(command.getNoteModel());
        entityManager.insert(entity);
        return new CommandVoidResult();
    }

    private static NoteEntity convert(NoteModel noteModel) {
        NoteEntity entity = new NoteEntity();
        NotePrimaryKey pk = new NotePrimaryKey();
        pk.setUsername(noteModel.getUsername());
        entity.setPrimaryKey(pk);
        entity.setNoteText(noteModel.getNoteText());
        return entity;
    }
}

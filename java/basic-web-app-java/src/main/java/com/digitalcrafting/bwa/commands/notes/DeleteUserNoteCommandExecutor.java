package com.digitalcrafting.bwa.commands.notes;

import com.digitalcrafting.base.command.CommandExecutor;
import com.digitalcrafting.base.command.CommandVoidResult;
import com.digitalcrafting.bwa.data.entity.NotePrimaryKey;
import com.digitalcrafting.bwa.data.entitymanagers.NotesEntityManager;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserNoteCommandExecutor implements CommandExecutor<DeleteUserNoteCommand, CommandVoidResult> {

    private final NotesEntityManager entityManager;

    public DeleteUserNoteCommandExecutor(NotesEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CommandVoidResult execute(DeleteUserNoteCommand command) {
        NotePrimaryKey pk = new NotePrimaryKey(
                command.getNoteId(),
                command.getUsername()
        );

        if (entityManager.getByPrimaryKey(pk) != null) {
            entityManager.delete(pk);
        }

        return new CommandVoidResult();
    }
}

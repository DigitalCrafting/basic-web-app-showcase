package com.digitalcrafting.bwa.rest.notes;

import com.digitalcrafting.base.command.CommandDispatcher;
import com.digitalcrafting.base.services.ControllerService;
import com.digitalcrafting.bwa.BwaApplication;
import com.digitalcrafting.bwa.commands.notes.CreateNoteCommand;
import com.digitalcrafting.bwa.commands.notes.DeleteUserNoteCommand;
import com.digitalcrafting.bwa.commands.notes.GetUserNotesCommand;
import com.digitalcrafting.bwa.commands.notes.GetUserNotesCommandResult;
import com.digitalcrafting.bwa.objects.enums.SessionContext;
import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@ControllerService
public class NotesControllerService {
    private final Logger logger = LogManager.getLogger(BwaApplication.class.getName());

    private final CommandDispatcher commandDispatcher;
    private final SessionContext sessionContext;

    public NotesControllerService(CommandDispatcher commandDispatcher, SessionContext sessionContext) {
        this.commandDispatcher = commandDispatcher;
        this.sessionContext = sessionContext;
    }

    public List<NoteModel> getNotes() {
        // TODO move check to aspect
        String username = sessionContext.getUsername();
        if (sessionContext.isUserLoggedIn() && Strings.isNullOrEmpty(username)) {
            throw new SecurityException();
        }

        GetUserNotesCommandResult result = commandDispatcher.dispatch(new GetUserNotesCommand(username));

        return result.getNotesList();
    }

    public void createNote(String noteText) {
        // TODO move check to aspect
        String username = sessionContext.getUsername();
        if (sessionContext.isUserLoggedIn() && Strings.isNullOrEmpty(username)) {
            throw new SecurityException();
        }

        NoteModel noteModel = new NoteModel();
        noteModel.setNoteText(noteText);
        noteModel.setUsername(username);

        commandDispatcher.dispatch(new CreateNoteCommand(noteModel));
        logger.info("Created note for user: " + username);
    }

    public void deleteNote(int noteId) {
        // TODO move check to aspect
        String username = sessionContext.getUsername();
        if (sessionContext.isUserLoggedIn() && Strings.isNullOrEmpty(username)) {
            throw new SecurityException();
        }

        commandDispatcher.dispatch(new DeleteUserNoteCommand(noteId, username));
        logger.info("Deleted note with id: " + noteId + " for user: " + username);
    }
}

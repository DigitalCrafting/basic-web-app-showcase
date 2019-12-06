package com.digitalcrafting.bwa.rest.notes;

import com.digitalcrafting.bwa.rest.notes.objects.NoteModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesControllerService service;

    public NotesController(NotesControllerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<NoteModel>> getNotes() {
        return ResponseEntity.ok(service.getNotes());
    }

    @PutMapping("/")
    public void createNote(@RequestBody String noteText) {
        service.createNote(noteText);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable("noteId") int noteId) {
        service.deleteNote(noteId);
    }
}

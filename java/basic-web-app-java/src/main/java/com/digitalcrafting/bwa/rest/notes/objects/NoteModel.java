package com.digitalcrafting.bwa.rest.notes.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteModel {
    private int noteId;
    private String username;
    private String noteText;
}

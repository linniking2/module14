package org.dev.module14;
import org.dev.module14.Note;
import org.dev.module14.NoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteApplication implements CommandLineRunner {

    private final NoteService noteService;

    public NoteApplication(NoteService noteService) {
        this.noteService = noteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(NoteApplication.class, args);
        SpringApplication.run(TestController.class, args);
        SpringApplication.run(TestThymeleafController.class, args);
        SpringApplication.run(NoteController.class, args);
    }

    @Override
    public void run(String... args) {

        Note note1 = noteService.add(new Note(null, "Note 1", "Content of note 1"));
        Note note2 = noteService.add(new Note(null, "Note 2", "Content of note 2"));


        System.out.println("All Notes:");
        noteService.listAll().forEach(System.out::println);


        note1.setTitle("Updated Note 1");
        note1.setContent("Updated content of note 1");
        noteService.update(note1);


        System.out.println("Note with ID 1: " + noteService.getById(1L));


        noteService.deleteById(2L);


        System.out.println("Remaining Notes:");
        noteService.listAll().forEach(System.out::println);
    }
}
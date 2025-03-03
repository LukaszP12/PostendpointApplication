package com.example.postendpoint;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Log4j2
public class ShawnController {

    List<String> songs = new ArrayList<>();

    @PostMapping(path = "/shawn/songs")
    public ResponseEntity<ResponseBodyShawn> postSmth(@RequestBody RequestBodyShawn requestBodyShawn) {
        String songName = requestBodyShawn.songName();
        songs.add(songName);
        return ResponseEntity.ok(new ResponseBodyShawn("Added new Song!", List.of(songName)));
    }

    @GetMapping(path = "/shawn/songs")
    public ResponseEntity<ResponseBodyShawn> getAllSongs() {
        System.out.println(songs);
        return ResponseEntity.ok(new ResponseBodyShawn("songs", Collections.emptyList()));
    }

    @DeleteMapping(path = "/shawn/songs/{id}")
    public ResponseEntity<String> deleteShawn(@PathVariable int id) {
        songs.remove(id);
        return ResponseEntity.ok("You deleted shawn song with id: " + id);
    }

}

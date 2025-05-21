package com.example.football_booking.controller;

import com.example.football_booking.model.Stadium;
import com.example.football_booking.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

    @Autowired // Tự động inject StadiumService
    private StadiumService stadiumService;

    // Endpoint để lấy tất cả sân bóng
    @GetMapping
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        List<Stadium> stadiums = stadiumService.getAllStadiums();
        return new ResponseEntity<>(stadiums, HttpStatus.OK);
    }

    // Endpoint để lấy sân bóng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Stadium>> getStadiumById(@PathVariable Long id) {
        Optional<Stadium> stadium = stadiumService.getStadiumById(id);
        if (stadium.isPresent()) {
            return new ResponseEntity<>(stadium, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium) {
        Stadium createdStadium = stadiumService.createStadium(stadium);
        return new ResponseEntity<>(createdStadium, HttpStatus.CREATED);
    }

    // Endpoint để cập nhật thông tin sân bóng
    @PutMapping("/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Long id, @RequestBody Stadium stadium) {
        Stadium updatedStadium = stadiumService.updateStadium(id, stadium);
        if (updatedStadium != null) {
            return new ResponseEntity<>(updatedStadium, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint để xóa sân bóng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long id) {
        stadiumService.deleteStadium(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

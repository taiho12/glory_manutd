package com.example.football_booking.repository;

import com.example.football_booking.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Đánh dấu đây là một Spring Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
   
}

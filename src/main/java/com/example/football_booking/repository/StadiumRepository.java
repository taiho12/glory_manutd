package com.example.football_booking.repository;

import com.example.football_booking.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Đánh dấu đây là một Spring Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    // JpaRepository cung cấp các phương thức CRUD cơ bản (save, findById, findAll, delete, v.v.)
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh tại đây nếu cần.
}

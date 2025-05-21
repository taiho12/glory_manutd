package com.example.football_booking.repository;

import com.example.football_booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository // Đánh dấu đây là một Spring Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository cung cấp các phương thức CRUD cơ bản (save, findById, findAll, delete, v.v.)
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh tại đây nếu cần.
    // Ví dụ: Tìm người dùng theo email
    Optional<User> findByEmail(String email);
}

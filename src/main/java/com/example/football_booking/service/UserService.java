package com.example.football_booking.service;

import com.example.football_booking.model.User;
import com.example.football_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Import này cần thiết để mã hóa mật khẩu
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Đánh dấu đây là một Spring Service
public class UserService {

    @Autowired // Tự động inject UserRepository
    private UserRepository userRepository;

    @Autowired // Tự động inject PasswordEncoder từ SecurityConfig
    private PasswordEncoder passwordEncoder;

    // Phương thức để lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Phương thức để lấy người dùng theo ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Phương thức để tạo người dùng mới
    public User createUser(User user) {
        // Mã hóa mật khẩu trước khi lưu vào database để bảo mật
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Phương thức để cập nhật thông tin người dùng
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            // Cẩn thận: Không cập nhật mật khẩu ở đây trực tiếp.
            // Nếu muốn đổi mật khẩu, cần có một phương thức riêng biệt
            // để xử lý việc mã hóa mật khẩu mới.
            return userRepository.save(existingUser);
        } else {
            return null; // Hoặc bạn có thể throw một ngoại lệ (Exception)
        }
    }

    // Phương thức để xóa người dùng
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Phương thức tìm người dùng theo email (để kiểm tra đăng nhập hoặc email trùng lặp)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Bạn có thể thêm các phương thức khác liên quan đến logic người dùng tại đây,
    // ví dụ: xác thực đăng nhập, đổi mật khẩu, v.v.
}

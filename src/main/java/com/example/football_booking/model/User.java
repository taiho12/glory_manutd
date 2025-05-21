package com.example.football_booking.model;

import jakarta.persistence.*;

@Entity // Đánh dấu đây là một JPA Entity, ánh xạ với một bảng trong cơ sở dữ liệu
@Table(name = "users") // Tên bảng trong cơ sở dữ liệu
public class User {

    @Id // Đánh dấu đây là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị cho khóa chính
    private Long id;

    private String name;
    private String email;
    private String password; // Mật khẩu (nên được mã hóa trước khi lưu vào database)
    private String phone;
    private String role; // Vai trò của người dùng, ví dụ: "customer", "admin"

    // Constructors (Bạn có thể thêm constructors nếu cần)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

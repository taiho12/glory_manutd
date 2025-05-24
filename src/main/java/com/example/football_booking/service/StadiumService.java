package com.example.football_booking.service;

import com.example.football_booking.model.Stadium;
import com.example.football_booking.repository.StadiumRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    // Tự động inject StadiumRepository
    private final StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    // Phương thức để lấy tất cả sân bóng
    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    // Phương thức để lấy sân bóng theo ID
    public Optional<Stadium> getStadiumById(Long id) {
        return stadiumRepository.findById(id);
    }

    // Phương thức để tạo sân bóng mới
    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    // Phương thức để cập nhật thông tin sân bóng
    public Stadium updateStadium(Long id, Stadium stadium) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            Stadium existingStadium = stadiumOptional.get();
            existingStadium.setName(stadium.getName());
            existingStadium.setAddress(stadium.getAddress());
            existingStadium.setType(stadium.getType());
            existingStadium.setSize(stadium.getSize());
            existingStadium.setFacilities(stadium.getFacilities());
            existingStadium.setPricePerHour(stadium.getPricePerHour());
            existingStadium.setOpeningTime(stadium.getOpeningTime());
            existingStadium.setClosingTime(stadium.getClosingTime());
            return stadiumRepository.save(existingStadium);
        } else {
            return null;
        }
    }

    // Phương thức để xóa sân bóng
    public void deleteStadium(Long id) {
        stadiumRepository.deleteById(id);
    }

}

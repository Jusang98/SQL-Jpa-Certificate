package com.nhnacademy.jdbc.board.repository;


import com.nhnacademy.jdbc.board.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByResidentSerialNumber(Long residentSerialNumber);

    @Transactional
    @Modifying
    @Query("update Resident r set r.name = :name where r.residentSerialNumber = :residentSerialNumber")
    int updateResidentName(@Param("residentSerialNumber") Long residentSerialNumber, @Param("name") String name);
}

package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.ResidentRegisterRequest;
import com.nhnacademy.jdbc.board.entity.Resident;

import java.util.List;

public interface ResidentService {
    List<Resident> getResidents();

    Resident getResident(Long residentSerialNumber);

    Resident createResident(ResidentRegisterRequest residentRegisterRequest);

    int updateResidentName(Long residentSerialNumber, String name);

}

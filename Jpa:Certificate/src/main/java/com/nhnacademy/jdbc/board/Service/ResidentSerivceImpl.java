package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.ResidentRegisterRequest;
import com.nhnacademy.jdbc.board.entity.Resident;
import com.nhnacademy.jdbc.board.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ResidentSerivceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentSerivceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public List<Resident> getResidents() {
        return residentRepository.findAll();
    }

    @Override
    public Resident getResident(Long residentSerialNumber) {
        return residentRepository.findById(residentSerialNumber).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Resident createResident(ResidentRegisterRequest rq) {
        Resident resident = new Resident();
        resident.setResidentSerialNumber(rq.getResidentSerialNumber());
        resident.setResidentRegistrationNumber(rq.getResidentRegistrationNumber());
        resident.setName(rq.getName());
        resident.setBirthDate(rq.getBirthDate());
        resident.setDeathDate(rq.getDeathDate());
        resident.setGenderCode(rq.getGenderCode());
        resident.setBirthPlaceCode(rq.getBirthPlaceCode());
        resident.setDeathPlaceCode(rq.getDeathPlaceCode());
        resident.setRegistrationBaseAddress(rq.getRegistrationBaseAddress());

        return residentRepository.save(resident);
    }

    @Override
    public int updateResidentName(Long residentSerialNumber, String name) {
        return residentRepository.updateResidentName(residentSerialNumber, name);
    }

}

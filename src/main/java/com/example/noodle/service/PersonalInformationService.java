package com.example.noodle.service;

import com.example.noodle.model.PersonalInformation;
import com.example.noodle.model.User;
import com.example.noodle.repo.PersonalInformationRepository;
import com.example.noodle.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    PersonalInformationRepository informationRepository;

    public List<PersonalInformation> findAll(){
        return informationRepository.findAll();
    }

    public PersonalInformation saveInfo(PersonalInformation information) {

        return informationRepository.save(information);
    }

    public List <PersonalInformation> findById(Long id) {
        return informationRepository.findInfoById(id);
    }


}

package com.example.noodle.repo;

import com.example.noodle.model.PersonalInformation;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long > {
    @Query("SELECT e FROM PersonalInformation e WHERE e.studentId = :id")
    public List<PersonalInformation> findInfoById(@Param("id") long id);
    @Override
    PersonalInformation save (PersonalInformation personalInformation);
}

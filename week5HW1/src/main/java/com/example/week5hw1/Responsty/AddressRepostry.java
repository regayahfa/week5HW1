package com.example.week5hw1.Responsty;

import com.example.week5hw1.MODEL.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepostry  extends JpaRepository<Address,Integer> {

    Address findAllByAreaAndTeacher(Integer id);
}

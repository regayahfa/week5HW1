package com.example.week5hw1.Controller;

import com.example.week5hw1.MODEL.Address;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Servies.AddressSirveis;
import com.example.week5hw1.Servies.TeacherServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressSirveis addressSirveis;
    @GetMapping("/get")
    public ResponseEntity getAllByAreaAndTeacher(){
        List<Address>address=addressSirveis.getAllByAreaAndTeacher();
        return ResponseEntity.status(200).body(address);
    }
    @PostMapping("/add")
    public ResponseEntity addAdress(@Valid @RequestBody Address address){
        addressSirveis.addAdress(address);
        return ResponseEntity.status(200).body("Adress added");
    }
    @PutMapping("/update")
    public ResponseEntity updateAdress(@Valid @RequestBody Address address, @PathVariable Integer id){
        addressSirveis.updateAddress(address,id);
        return ResponseEntity.status(200).body("adress updated");
    }
    public ResponseEntity deleteAdress(@PathVariable Integer id){
        addressSirveis.deleteAddress(id);
        return ResponseEntity.status(200).body("Adress deleted");
    }



}

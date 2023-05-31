package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.DTO.AddressDTO;
import com.example.week5hw1.DTO.TeacherDTO;
import com.example.week5hw1.MODEL.Address;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Responsty.AddressRepostry;
import com.example.week5hw1.Responsty.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressSirveis {

    private  final AddressRepostry addressRepostry;
    private final TeacherRepostry teacherRepostry;

    public List<Address> getAll(){
        return addressRepostry.findAll();
    }
    public void addAdress(AddressDTO dto){
        Teacher teacher = teacherRepostry.findTeacherById(dto.getTeacher_id());
        if (teacher == null)
            throw new ApiException("Teacher not found");
        Address address = new Address(null,dto.getArea(),dto.getStreet(),dto.getBuildingNumber(),teacher);
        addressRepostry.save(address);
    }
    public void updateAddress(Address address,Integer id){
        Address address1=addressRepostry.getAddressById(id);
        if (address1==null){
            throw new ApiException("Address not found");
        }
        address1.setArea(address.getArea());
        address1.setBuildingNumber(address.getBuildingNumber());

        addressRepostry.save(address1);
    }
    public void deleteAddress(Integer id){
        Address address=addressRepostry.getAddressById(id);
   if (address==null){
throw new ApiException("address not found");
   }
   addressRepostry.delete(address);

    }
}

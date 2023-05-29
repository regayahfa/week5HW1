package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.MODEL.Address;
import com.example.week5hw1.Responsty.AddressRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressSirveis {
    private  final AddressRepostry addressRepostry;

    public List<Address>getAllByAreaAndTeacher(){
        return addressRepostry.findAll();
    }
    public void addAdress(Address address){
        addressRepostry.save(address);
    }
    public void updateAddress(Address address,Integer id){
        Address address1=addressRepostry.findAllByAreaAndTeacher(id);
        if (address1==null){
            throw new ApiException("Address not found");
        }
        address1.setArea(address.getArea());
        address1.setBuildingNumber(address.getBuildingNumber());

        addressRepostry.save(address1);
    }
    public void deleteAddress(Integer id){
        Address address=addressRepostry.findAllByAreaAndTeacher(id);
   if (address==null){
throw new ApiException("address not found");
   }
   addressRepostry.delete(address);

    }
}

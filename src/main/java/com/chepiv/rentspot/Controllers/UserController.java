package com.chepiv.rentspot.Controllers;

import com.chepiv.rentspot.DAO.LandlordRepository;
import com.chepiv.rentspot.domain_core.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chepiv on 22.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@Controller
public class UserController {

    @Autowired
    LandlordRepository landlordRepository;

    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String surname,String email, String password) {
        String userId = "";
        try {
            Landlord landlord = new Landlord(name,surname,email,"888-888-888",password);
            landlordRepository.save(landlord);
            userId = String.valueOf(landlord.getName());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with name = " + userId;
    }
}

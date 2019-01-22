package com.chepiv.rentspot.Controllers;

import com.chepiv.rentspot.DAO.LandlordRepository;
import com.chepiv.rentspot.DAO.OfferRepository;
import com.chepiv.rentspot.domain_core.Landlord;
import com.chepiv.rentspot.domain_core.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;


@Controller
public class OfferController {
    // inject via application.properties

    @Autowired
    OfferRepository offerRepository;
    @Autowired
    LandlordRepository landlordRepository;

    @GetMapping({"/", ""})
    public String welcome() {
        return "offersList";
    }

    @GetMapping("/addOffer")
    public String addOffer(Offer offer){
        return "addOffer";
    }

    @PostMapping("/persistOffer")
    public String persistOffer(@Valid Offer offer, BindingResult result, Model model){
        if (result.hasErrors()){
            return "addOffer";
        }
        offer.setDate(new Date());
        Optional<Landlord> landlord = landlordRepository.findById(1L);
        offer.setLandlord(landlord.get());
        offerRepository.save(offer);
        model.addAttribute("offers",offerRepository.findAll());
        return "offersList";

    }
}

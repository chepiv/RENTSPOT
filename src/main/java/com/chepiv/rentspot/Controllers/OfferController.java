package com.chepiv.rentspot.Controllers;

import com.chepiv.rentspot.DAO.LandlordRepository;
import com.chepiv.rentspot.DAO.OfferRepository;
import com.chepiv.rentspot.DAO.ParameterRepository;
import com.chepiv.rentspot.domain_core.Landlord;
import com.chepiv.rentspot.domain_core.Offer;
import com.chepiv.rentspot.domain_core.Parameter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class OfferController {
    // inject via application.properties

    @Autowired
    OfferRepository offerRepository;
    @Autowired
    LandlordRepository landlordRepository;
    @Autowired
    ParameterRepository parameterRepository;


    @RequestMapping({"/", ""})
    public String welcome(Model model) {
        model.addAttribute("offers",offerRepository.findAll());
        return "offersList";
    }

    @RequestMapping("/addOffer")
    public String addOffer(Offer offer){
        return "addOffer";
    }

    @RequestMapping("/persistOffer")
    public String persistOffer(@Valid Offer offer,BindingResult result, Model model){
        if (result.hasErrors()){
            return "addOffer";
        }
        offer.setDate(new Date());
        Optional<Landlord> landlord = landlordRepository.findById(1L);
        offer.setLandlord(landlord.get());
        if (!offer.getCsvParam().equals("") && offer.getCsvParam()!=null) {
            offer.setParameters(convertCsvToParamList(offer.getCsvParam()));
        }
        offerRepository.save(offer);
        model.addAttribute("offers",offerRepository.findAll());
        return "offersList";

    }

    private List<Parameter> convertCsvToParamList(String csvParams){
        List<String> stringList = Arrays.asList(csvParams.split("\\s*,\\s*"));

        List<Long> paramIds = stringList.stream().map(Long::parseLong).collect(Collectors.toList());

        return Lists.newArrayList(parameterRepository.findAllById(paramIds));
    }
}

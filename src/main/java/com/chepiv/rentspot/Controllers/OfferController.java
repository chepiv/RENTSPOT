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


    /**
     * @param model gets Model to access it from HTML
     * @param offer Serializable object
     * HOME PAGE OF APP
     * @return HTML view
     */
    @RequestMapping({"/", ""})
    public String welcome(Model model,Offer offer) {
        model.addAttribute("offer",offer);
        model.addAttribute("offers", offerRepository.findAll());
        return "offersList";
    }

    /**
     * @param offer Serializavle object accessed from HTML
     * @return HTML VIEW
     */
    @RequestMapping("/addOffer")
    public String addOffer(Offer offer) {
        return "addOffer";
    }

    /**
     * @param offer
     * @param result
     * Marking of offer via setting db value to 1
     * @return HTML view
     */
    @RequestMapping(value = "/reserveOffer")
    public String reserveOffer(Offer offer, BindingResult result,Model model) {
        if (result.hasErrors()){
            return "offersList";
        }
//        model.addAttribute("offer",new Offer());
        Long reservatedId = offer.getReserveId();
        Optional<Offer> offerRes = offerRepository.findById(reservatedId);
        if (offerRes.isPresent()) {
            offerRes.get().setMarked(true);
            offerRepository.save(offerRes.get());
        }
        model.addAttribute("offers", offerRepository.findAll());
        return "offersList";
    }

    /**
     * @param offer
     * @param result
     * @param model
     * Persisting created via GUI object to DB
     * @return HTML view
     */
    @RequestMapping("/persistOffer")
    public String persistOffer(@Valid Offer offer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addOffer";
        }
        offer.setDate(new Date());
        Optional<Landlord> landlord = landlordRepository.findById(1L);
        offer.setLandlord(landlord.get());
        if (!offer.getCsvParam().equals("") && offer.getCsvParam() != null) {
            offer.setParameters(convertCsvToParamList(offer.getCsvParam()));
        }
        offerRepository.save(offer);
        model.addAttribute("offers", offerRepository.findAll());
        return "offersList";

    }

    /**
     * @param csvParams Parameters ids in csv form
     * Converting ids to List of Parameters
     * @return List of Parameters
     */
    private List<Parameter> convertCsvToParamList(String csvParams) {
        List<String> stringList = Arrays.asList(csvParams.split("\\s*,\\s*"));

        List<Long> paramIds = stringList.stream().map(Long::parseLong).collect(Collectors.toList());

        return Lists.newArrayList(parameterRepository.findAllById(paramIds));
    }
}

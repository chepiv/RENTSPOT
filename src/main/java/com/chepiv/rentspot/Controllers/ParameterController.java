package com.chepiv.rentspot.Controllers;

import com.chepiv.rentspot.DAO.ParameterRepository;
import com.chepiv.rentspot.domain_core.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by chepiv on 22.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@Controller
public class ParameterController {

    @Autowired
    ParameterRepository parameterRepository;

    /**
     * @param parameter
     * @return HTML view
     */
    @RequestMapping("/addParam")
    public String addParam(Parameter parameter){
        return "addParam";
    }

    /**
     * @param model
     * @return HTML view with list of parameters
     */
    @RequestMapping("/paramList")
    public String getParamList(Model model){
        model.addAttribute("parameters",parameterRepository.findAll());
        return "paramList";
    }

    /**
     * @param parameter
     * @param bindingResult
     * Storing created from GUI parameters to DB
     * @return HTML view
     */
    @RequestMapping("/persistParam")
    public String persistParam(@Valid Parameter parameter, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addParam";
        }
        parameterRepository.save(parameter);

        return "addParam";
    }
}

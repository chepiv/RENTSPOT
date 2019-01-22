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

    @RequestMapping("/addParam")
    public String addParam(Parameter parameter){
        return "addParam";
    }

    @RequestMapping("/paramList")
    public String getParamList(Model model){
        model.addAttribute("parameters",parameterRepository.findAll());
        return "paramList";
    }

    @RequestMapping("/persistParam")
    public String persistParam(@Valid Parameter parameter, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addParam";
        }
        parameterRepository.save(parameter);

        return "addParam";
    }
}

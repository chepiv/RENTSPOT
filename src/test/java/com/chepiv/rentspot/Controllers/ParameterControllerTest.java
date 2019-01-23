package com.chepiv.rentspot.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by chepiv on 23.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParameterControllerTest {

    @Autowired
    ParameterController parameterController;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void httpGetOnAddParam_shoulReturnOkAndAddParamHtml() throws Exception {
        this.mockMvc.perform(get("/addParam"))
                .andExpect(status().isOk())
                .andExpect(view().name("addParam"));
    }

    @Test
    public void httpGetOnParamList_shouldReturnOkAndParamListHtml() throws Exception{
        this.mockMvc.perform(get("/paramList"))
                .andExpect(status().isOk())
                .andExpect(view().name("paramList"));
    }

}
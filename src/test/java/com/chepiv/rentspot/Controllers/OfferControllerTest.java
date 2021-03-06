package com.chepiv.rentspot.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
public class OfferControllerTest {

    @Autowired OfferController offerController;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void httpGetOnDefault_shoulReturnOkAndOfferListHtml() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("offersList"));
    }

    @Test
    public void httpGetOnAddOffer_shouldReturnOkAndAddOfferHtml() throws Exception{
        this.mockMvc.perform(get("/addOffer"))
                .andExpect(status().isOk())
                .andExpect(view().name("addOffer"));
    }

}
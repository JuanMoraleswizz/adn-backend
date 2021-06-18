package com.ceiba.orden.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.servicio.testdatabuilder.ComandoOrdenTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorOrden.class)
public class ComandoControladorOrdenTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoOrden orden = new ComandoOrdenTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/orden")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orden)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }


    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/orden/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

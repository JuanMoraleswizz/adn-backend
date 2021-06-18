package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.servicio.testdatabuilder.ComandoPersonaTestDataBuilder;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.controlador.ComandoControladorProducto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;
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
@WebMvcTest(ComandoControladorPersona.class)
public class ComandoControladorPersonaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/persona/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/persona/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

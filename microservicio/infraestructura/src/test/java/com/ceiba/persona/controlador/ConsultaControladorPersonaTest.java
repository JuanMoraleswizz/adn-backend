package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.producto.controlador.ConsultaControladorProducto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorPersona.class)
public class ConsultaControladorPersonaTest {
    @Autowired
    private MockMvc mocMvc;
    private  final String identificacion = "1038125422";
    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/persona")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }
    @Test
    public void listarPorIdentificacion() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/persona/{identificacion}",identificacion)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}

package com.ceiba.producto.controlador;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.ceiba.ApplicationMock;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorProducto.class)
public class ConsultaControladorProductoTest {

    @Autowired
    private MockMvc mocMvc;
    private static final String codigo = "test";

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/productos/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("producto1")))
                .andExpect(jsonPath("$[0].codigo", is("test")));


    }

    @Test
    public void listarPorCodigo() throws Exception {
        mocMvc.perform(get("/productos/{codigo}", codigo)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("producto1")))
                .andExpect(jsonPath("$[0].codigo", is("test")));
    }

}

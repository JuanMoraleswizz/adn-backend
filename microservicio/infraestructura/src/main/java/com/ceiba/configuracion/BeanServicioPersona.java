package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import com.ceiba.usuario.servicio.persona.ServicioCrearPersona;
import com.ceiba.usuario.servicio.persona.ServicioEliminarPersona;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import com.ceiba.usuario.servicio.producto.ServicioEliminarProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPersona {

    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona){
        return new ServicioCrearPersona(repositorioPersona);
    }
    @Bean
    public ServicioActualizarPersona servicioActualizarPersona(RepositorioPersona repositorioPersona){
        return new ServicioActualizarPersona(repositorioPersona);
    }

    @Bean
    public ServicioEliminarPersona servicioEliminarPersona(RepositorioPersona repositorioPersona){
        return  new ServicioEliminarPersona(repositorioPersona);
    }
}

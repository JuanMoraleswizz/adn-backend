package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import com.ceiba.usuario.servicio.producto.ServicioEliminarProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProducto {

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto){
        return new ServicioCrearProducto(repositorioProducto);
    }
    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto){
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto){
        return  new ServicioEliminarProducto(repositorioProducto);
    }
}

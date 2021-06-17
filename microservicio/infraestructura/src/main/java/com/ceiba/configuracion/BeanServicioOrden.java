package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrdenDetalle;
import com.ceiba.usuario.servicio.orden.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioOrden {
    @Bean
    public ServicioCrearOrden servicioCrearOrden(RepositorioOrden repositorioOrden){
        return new ServicioCrearOrden(repositorioOrden);
    }
    @Bean
    public ServicioCrearOrdenDetalle servicioCrearOrdenDetalle(RepositorioOrdenDetalle repositorioOrdenDetalle){
        return new ServicioCrearOrdenDetalle(repositorioOrdenDetalle);
    }
    @Bean
    public ServicioEliminarOrden servicioEliminarOrden(RepositorioOrden repositorioOrden){
        return  new ServicioEliminarOrden(repositorioOrden);
    }

    @Bean
    public ServicioEliminarOrdenDetalle servicioEliminarOrdenDetalle(RepositorioOrdenDetalle repositorioOrdenDetalle){
        return  new ServicioEliminarOrdenDetalle(repositorioOrdenDetalle);
    }

    @Bean
    public ServicioEliminarOrdenDetallePorOrden servicioEliminarOrdenPorOrden(RepositorioOrden repositorioOrden){
        return  new ServicioEliminarOrdenDetallePorOrden(repositorioOrden);
    }
}

package com.example.PersistanceApp.Empleados;


import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {
    private EmpleadosRepository empleadosRepository;
    private UsuariosService usuariosService;

    @Autowired
    public EmpleadosService (EmpleadosRepository empleadosRepository, UsuariosService usuariosService) {
        this.empleadosRepository = empleadosRepository;
        this.usuariosService= usuariosService;
    }

    public List<Empleados> getEmpleado(String mail){
        return empleadosRepository.findEmpleadoByMail(mail);}
    public List<Empleados> getEmpleado(){return empleadosRepository.findAll(); //devuelve lista
    }

    public void addNewEmpleado(Empleados empleados) {
        Optional<Empleados> empleadoByPasaporte = empleadosRepository.findEmpleadoByPasaporte(empleados.getPasaporte());
        Usuarios usuario = new Usuarios(empleados.getMail(),empleados.getContraseña(),empleados.getTipo());
        if(empleadoByPasaporte.isPresent()){
            try {
                throw new IllegalAccessException("Empleado ya ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        usuariosService.addNewUsuario(usuario);
        empleadosRepository.save(empleados);
    }
    public void deleteEmpleado(String pasaporte){
        boolean existe=empleadosRepository.existsById(pasaporte);
        if (!existe){
            throw new IllegalStateException("empleado con pasaporte"+ pasaporte + "no existe");
        }
        empleadosRepository.deleteById(pasaporte);
    }


}

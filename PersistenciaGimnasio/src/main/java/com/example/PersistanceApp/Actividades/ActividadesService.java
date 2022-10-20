package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadesService {
    private final ActividadesRepository actividadesRepository;

    @Autowired
    public ActividadesService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }

    public List<Actividades> getActividades(){return actividadesRepository.findAll(); //devuelve lista
    }

    public void addNewActividades(Actividades actividades) {
        System.out.println(actividades);
        Optional<Actividades> actividadesById = actividadesRepository.findActividadesByNombre(actividades.getNombre());
        if(actividadesById.isPresent()){
            try {
                throw new IllegalAccessException("Actividad ya ingresada");
            } catch (IllegalAccessException e) {

            }
        }

        actividadesRepository.save(actividades);
    }

}
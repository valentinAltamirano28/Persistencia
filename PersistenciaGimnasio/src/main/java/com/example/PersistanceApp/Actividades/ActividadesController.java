package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosService;
import com.example.PersistanceApp.Horario.HorarioKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/actividades")
public class ActividadesController {
    private final ActividadesService actividadesService;

    @Autowired
    public ActividadesController(ActividadesService actividadesService){
        this.actividadesService = actividadesService;
    }

    @GetMapping
    public List<Actividades> getActividades(){
        return actividadesService.getActividades();
    }

    @GetMapping("/cupos")
    public List<Actividades> getActividadesCupos(){return actividadesService.getActividadesCupos();}

    @GetMapping("/categ/{categoria}")
    public List<Actividades> getActividadesCancha(@PathVariable("categoria") String categoria){
        return actividadesService.getActividadesCateg(categoria);
    }

    @GetMapping("/mail/{mail}")
    public List<Actividades> getActividadesCentroMail(@PathVariable("mail") String mail){
        return actividadesService.getActividadesCentro(mail);
    }

    @GetMapping("/horario/{dia_semana}/{nombre}/{rut}")
    public List<HorarioKey> getActividadesHorario(@PathVariable("dia_semana") String dia_semana,@PathVariable("nombre") String nombre ,@PathVariable("rut") Long rut){
        return actividadesService.getActividadesHorario(dia_semana,nombre,rut);
    }

    @GetMapping("/centro/{mail}/{nombre}")
    public List<Actividades> getActividadesMailNombre(@PathVariable("mail") String mail,@PathVariable("nombre") String nombre){
        return actividadesService.getActividadMailNombre(mail, nombre);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Actividades> getActividadesNombres(@PathVariable("nombre") String nombre){
        return actividadesService.getActividadesNombre(nombre);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevaActividad(@RequestBody Actividades actividades){
        actividadesService.addNewActividades(actividades);
    }

    @PostMapping(path = "/update",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void updateActividades(@RequestBody Actividades actividades){
        actividadesService.updateActividad(actividades);
    }

    @DeleteMapping(path = "{actividadesKey}") //se eliminan asi cuando una depende del otro??
    public void deleteActividades(@PathVariable("actividadesKey") ActividadesKey actividadesKey  ){
        actividadesService.deleteActividad(actividadesKey);
    }



}

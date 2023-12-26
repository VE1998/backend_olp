package com.olpasa.controller;

import com.olpasa.exception.ModelNotFoundException;
import com.olpasa.model.Control_rff;
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.service.IControlRffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/controlRff")
public class ControlRffController {

    @Autowired
    private IControlRffService controlRffService;

    @GetMapping
    public ResponseEntity<List<Control_rff>> listar(){
        List<Control_rff> listarControlRFF = controlRffService.listar();
        return new ResponseEntity<List<Control_rff>>(listarControlRFF, HttpStatus.OK);
    }

    @GetMapping("/{id_control}")
    public ResponseEntity<Control_rff> leerPorId(@PathVariable("id_control") Integer id_control){
        Control_rff controlId = controlRffService.leerPorId(id_control);
        if(id_control == null) {
            throw new ModelNotFoundException("Id no Encontrado: "+ id_control);
        }
        return new ResponseEntity<Control_rff>(controlId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar (@RequestBody Control_rff controlRff) {
        Control_rff control_rff = controlRffService.registrar(controlRff);
        //localhost:8080/sector/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(controlRff.getId_control()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar (@RequestBody Control_rff controlRff) {
        controlRffService.modificar(controlRff);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

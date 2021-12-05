/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.controller;

import Reto2_web.model.Gadget;
import Reto2_web.service.GadgetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CarlosSacristan
 */
@RestController
@RequestMapping("api/gadget")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;
            
    @GetMapping("/all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Gadget> getGadgets(@PathVariable("id") int id) {
        return gadgetService.getMercader(id);
    }
    //Registrar usuario

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget gadget) {
        return gadgetService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return gadgetService.delete(id);
    } 
}

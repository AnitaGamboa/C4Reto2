/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.repository;

import Reto2_web.interfaces.GadgetInterface;
import Reto2_web.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CarlosSacristan
 */
@Repository
public class GadgetRepository {
    @Autowired
    private GadgetInterface gadgetInterface;

    public List<Gadget> getAll() {
        return gadgetInterface.findAll();
    }

    public Optional<Gadget> getMercader(int id) {
        return gadgetInterface.findById(id);
    }

    public Gadget create(Gadget gadget) {
        return gadgetInterface.save(gadget);
    }

    public void update(Gadget gadget) {
        gadgetInterface.save(gadget);
    }

    public void delete(Gadget gadget) {
        gadgetInterface.delete(gadget);
    }

    /* Optional<Gadgets> getGadgets(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

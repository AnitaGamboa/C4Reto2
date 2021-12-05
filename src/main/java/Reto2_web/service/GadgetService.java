/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.service;


import Reto2_web.model.Gadget;
import Reto2_web.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository GadgetRepository;

    public List<Gadget> getAll() {
        return GadgetRepository.getAll();
    }

   public Optional<Gadget> getMercader(int id){
        return GadgetRepository.getMercader(id);
    }

    public Gadget create(Gadget accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return GadgetRepository.create(accesory);
        }
    }

    public Gadget update(Gadget accesory) {

        if (accesory.getId() != null) {
            Optional<Gadget> accesoryDb = GadgetRepository.getMercader(accesory.getId());
            if (!accesoryDb.isPresent()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                           
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                GadgetRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }
      public boolean delete(int id){
        Boolean aBoolean = getMercader(id).map(accesory -> {
            GadgetRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

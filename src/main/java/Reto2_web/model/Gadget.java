/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CarlosSacristan
 */
@Document(collection = "gadget")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gadget {
  @Id
  private Integer id;
  //private String reference;
  private String brand;
  private String category;
  private String name;
  private String description;
  private double price;
  private boolean availability = true;
  private int quantity;
  private String photography;
}
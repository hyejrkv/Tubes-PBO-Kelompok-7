/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
/**
 *
 * @author Icha
 */


@Entity
@DiscriminatorValue("SALES") 
public class SalesDealer extends User {
    
}

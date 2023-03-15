/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.helper;

import java.util.Random;

public class RandomOrderId {

    public int RandomOrderId() {
        Random rand = new Random();
        int maxNumber = 100000;

        int randomNumber = rand.nextInt(maxNumber) + 1;
        return randomNumber;
    }

}

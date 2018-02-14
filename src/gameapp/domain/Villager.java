/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp.domain;

/**
 *
 * @author KOMP
 */
public class Villager extends Being{
    private int hp, dmg, speed;

    public Villager(int hp, int dmg, int speed, String name) {
        super(hp, dmg, speed, name);
    }
    
}

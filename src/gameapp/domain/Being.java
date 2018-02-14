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
public class Being {
        private int hp, dmg, speed;
        private String name;

    public Being(int hp, int dmg, int speed, String name) {
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public int getDmg() {
        return dmg;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
    
        public void attack(int dmg, Being being){
        being.hp = being.hp - dmg;
    }
}

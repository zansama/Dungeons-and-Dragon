package mygame;

public class Weapon {
   protected String name;
    protected int strenghtAttack;

    public Weapon(String name, int strenghtAttack) {
        this.name = name;
        this.strenghtAttack = strenghtAttack;
    }
    public String getWeaponName() {
        return name;
    }

    public int getWeaponStrenghtAttack() {
        return strenghtAttack;
    }

    public void setWeaponName(String name) {
        this.name = name;


    }
    public void SetWeaponStrenghtAttack(int strenghtAttack) {
        this.strenghtAttack = strenghtAttack;

    }
}
package mygame;

public class Warrior extends Personnage {
    Weapon weapon = new Weapon("Disaster", 10);
    String shield;



    public Warrior(String name, String image, int lifeLevel, int strenghtAttack) {
        super(name, image, lifeLevel, strenghtAttack);
        this.shield = "Sacred Shield";

    }
    public String toString() {
        String newLine = System.getProperty("line.separator");
        String res = super.toString();
        res += newLine + "Nom de l'arme : "+weapon.getWeaponName()+ newLine + "Force de l'arme : " + weapon.getWeaponStrenghtAttack()+ newLine + "Nom du bouclier : "+ shield;
        return res;
    }
}
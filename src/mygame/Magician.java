package mygame;

public class Magician extends Personnage {
    String philtre;
    Spell spell = new Spell("Fireball", 9);

    public Magician(String name, String image, int lifeLevel, int strenghtAttack) {
        super(name, image, lifeLevel, strenghtAttack);
        this.philtre = "Sacred Philtre";

    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        String res = super.toString();
        res += newLine + "Nom du sort : " + spell.getSpellName() + newLine + "Force du sort : " + spell.getSpellStrenghtAttack() + newLine + "Nom du philtre : " + philtre;
        return res;
    }
}
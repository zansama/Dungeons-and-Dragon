package mygame;

public class Spell {
    private String name;
    private int strenghtAttack;

    public Spell(String name, int strenghtAttack) {
        this.name = name;
        this.strenghtAttack = strenghtAttack;
    }

    public String getSpellName() {
        return name;
    }

    public int getSpellStrenghtAttack() {
        return strenghtAttack;
    }

    public void setSpellName(String name) {
        this.name = name;


    }

    public void SetSpellStrenghtAttack(int strenghtAttack) {
        this.strenghtAttack = strenghtAttack;

    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        return "Nom du sort : " + name + newLine + "Force du sort : " + strenghtAttack;

    }
}
package mygame;

abstract public class Personnage {
    protected String name;
    protected String image;
    protected int lifeLevel;
    protected int strenghtAttack;

    public Personnage() {
        this.name = "zan";
        this.image = "image de zan";
        this.lifeLevel = 5;
        this.strenghtAttack = 7;
    }

    public Personnage(String name) {
        this.name = name;
        this.image = "image de " + name;
        this.lifeLevel = 8;
        this.strenghtAttack = 6;

    }

    public Personnage(String name, String image, int lifeLevel, int strenghtAttack) {
        this.name = name;
        this.image = image;
        this.lifeLevel = lifeLevel;
        this.strenghtAttack = strenghtAttack;

    }

    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    // Getter
    public String getImage() {
        return image;
    }

    // Setter
    public void setImage(String newImage) {
        this.image = newImage;
    }

    // Getter
    public int getLifelevel() {
        return lifeLevel;
    }

    // Setter
    public void setLifeLevel(int newlifeLevel) {
        this.lifeLevel = newlifeLevel;
    }

    // Getter
    public int getStrenghtAttack() {
        return strenghtAttack;
    }

    // Setter
    public void setStrenghtAttack(int newStrenghtAttack) {
        this.strenghtAttack = newStrenghtAttack;
    }

    //toString
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return "Nom du personnage : " + name + newLine + "Image du personnage : " + image + newLine + "Force du personnage : " + strenghtAttack + newLine + "Vie du personnage : " + lifeLevel;
    }
}

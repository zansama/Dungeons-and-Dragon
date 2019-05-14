package mygame;

public class Case {
    String name;
    int numCase = 0;
    public Case(String name, int numCase){
        this.name = name;
        this.numCase = numCase;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public int getNumCase() {
        return numCase;
    }

    @Override
    public String toString() {
        return "Case numéros "+numCase+ ": " + name;
    }
}

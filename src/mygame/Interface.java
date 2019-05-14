package mygame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Interface {
    private String classChoice;
    private String updateChoice;
    private String name = "";
    private String image = "";
    private int lifeLevel;
    private int strenghtAttack;
    private int i = 0;
    private Boolean game = true;
    private ArrayList<Personnage> personnageList = new ArrayList<Personnage>();

    public void begin() {
        hello();
        do {
            menu();
            switch (classChoice) {
                case "magicien":
                    magician();
                    break;
                case "guerrier":
                    warrior();
                    break;
                case "liste":
                    list();
                    break;
                case "modifier":
                    updateMenu();
                    break;
                case "quitter":
                    quit();
                    break;
                default:
                    invalide();
                    break;
            }
        } while (game.equals(true));
    }

    private void hello() {
        try {
            System.out.println("****        ****    ****************    ****            ****             ****************");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****        ****    ****************    ****            ****             ****************");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****        ****    ****                ****            ****             ****        ****");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****************    ************        ****            ****             ****        ****");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****************    ************        ****            ****             ****        ****");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****        ****    ****                ****            ****             ****        ****");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****        ****    ****************    ************    ************     ****************");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("****        ****    ****************    ************    ************     ****************");
            System.out.println("      ");
        } catch (InterruptedException ex) {
            System.out.println("     ");
        }

    }

    private void menu() {
        Scanner choiceClasse = new Scanner(System.in);
        System.out.println("Menu : ");
        System.out.println(" Nouveau guerrier taper ->      << guerrier >>");
        System.out.println(" Nouveau Magicien taper ->      << magicien >>");
        System.out.println(" Liste des personnages taper -> << liste >>");
        System.out.println(" modifier/supprimez un personnages taper -> << modifier >>");
        System.out.println(" Quittez le jeu taper ->        << quittez >>");
        classChoice = choiceClasse.nextLine();

    }

    private void createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre nom :");
        name = sc.nextLine();
        System.out.println("Veuillez saisir votre image :");
        image = sc.nextLine();
        int maxLevel = 10;
        int minLevel = 5;
        int rangeLevel = maxLevel - minLevel + 1;
        lifeLevel = (int) (Math.random() * rangeLevel) + minLevel;
        strenghtAttack = (int) (Math.random() * rangeLevel) + minLevel;
    }

    private void magician() {
        createPersonnage();
        Personnage clement = new Magician(name, image, lifeLevel, strenghtAttack);
        personnageList.add(clement);
        System.out.println(personnageList.get(i));
        i++;
    }

    private void warrior() {
        createPersonnage();
        Personnage clement = new Warrior(name, image, lifeLevel, strenghtAttack);
        try {
            personnageList.add(clement);
            System.out.println(personnageList.get(i));
            i++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Aucun emplacement de sauvegarde disponible");
        }

    }

    private void list() {
        if (personnageList.isEmpty()) {
            System.out.println("Veuillez créer un personnage");
            menu();
        } else {
            int save = 0;
            for (Object personnage : personnageList) {
                System.out.println("n° de sauvegarde " + save + " " + personnage);
                save++;
            }
        }
    }

    private void updateMenu() {
        if (personnageList.isEmpty()) {
            System.out.println("Veuillez créer un personnage");
            menu();
        } else {
            list();
            System.out.println("Menu : ");
            System.out.println("Modifier un personnage ->      << modifier >>");
            System.out.println("supprimer un personnage ->      << supprimer >>");
            Scanner scan = new Scanner(System.in);
            updateChoice = scan.nextLine();
            anUpdate();

        }

    }

    private void updatePersonnage() {
        int persoUpdate;
        Scanner scan = new Scanner(System.in);
        System.out.println("saisissez le n° de sauvegarde du personnage à modifier : ");
        persoUpdate = scan.nextInt();
        System.out.println("vous avez choisie de modifier : ");
        System.out.println(personnageList.get(persoUpdate).toString());
        Scanner newSc = new Scanner(System.in);
        System.out.println("voulez-vous modifier le nom ? yes/no");
        if (newSc.nextLine().equals("yes")) {
            Scanner newName = new Scanner(System.in);
            System.out.println("nouveau nom : ");
            personnageList.get(persoUpdate).setName(newName.nextLine());
        }
        System.out.println("voulez-vous modifier l'image ? yes/no");
        if (newSc.nextLine().equals("yes")) {
            Scanner newImage = new Scanner(System.in);
            System.out.println("nouvelle image : ");
            personnageList.get(persoUpdate).setImage(newImage.nextLine());
        }
        Scanner newScInt = new Scanner(System.in);
        System.out.println("voulez-vous modifier la force d'attaque ? yes/no");
        if (newScInt.nextLine().equals("yes")) {
            System.out.println("nouvelle force d'attaque : ");
            personnageList.get(persoUpdate).setStrenghtAttack(newScInt.nextInt());
        }
        System.out.println("voulez-vous modifier le niveau de vie ? yes/no");
        if (newScInt.nextLine().equals("yes")) {
            System.out.println("nouveau niveau de vie : ");
            personnageList.get(persoUpdate).setLifeLevel(newScInt.nextInt());
        }
    }

    private void removePersonnage() {
        int persoRemove;
        Scanner newScInt = new Scanner(System.in);
        System.out.println("saisissez le n° de sauvegarde du personnage à supprimer : ");
        persoRemove = newScInt.nextInt();
        personnageList.remove(persoRemove);
    }

    private void invalide() {
        System.out.println("Choix invalide  ! choisissez guerrier ou magicien");
    }

    private void quit() {
        System.exit(1);
    }

    private void anUpdate() {
        switch (updateChoice) {
            case "modifier":
                updatePersonnage();
                break;
            case "supprimer":
                removePersonnage();
                break;
        }
    }

}

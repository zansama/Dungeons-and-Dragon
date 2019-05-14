package mygame;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
        String classChoice;
        String name = "";
        String image = "";
        int lifeLevel;
        int strenghtAttack;
        int i = 0;
        Personnage personnageList[] = new Personnage[10];

        do {
            Scanner choiceClasse = new Scanner(System.in);
            System.out.println("Menu : ");
            System.out.println(" Nouveau guerrier taper ->      << guerrier >>");
            System.out.println(" Nouveau Magicien taper ->      << magicien >>");
            System.out.println(" Liste des personnages taper -> << liste >>");
            System.out.println(" modifier/supprimez un personnages taper -> << modifier >>");
            System.out.println(" Quittez le jeu taper ->        << quittez >>");
            classChoice = choiceClasse.nextLine();
            Scanner sc = new Scanner(System.in);

            if (classChoice.equals("magicien") || classChoice.equals("guerrier")) {
                System.out.println("Veuillez saisir votre nom :");
                name = sc.nextLine();
                System.out.println("Veuillez saisir votre image :");
                image = sc.nextLine();
            }
            int maxLevel = 10;
            int minLevel = 5;
            int rangeLevel = maxLevel - minLevel + 1;
            lifeLevel = (int) (Math.random() * rangeLevel) + minLevel;
            strenghtAttack = (int) (Math.random() * rangeLevel) + minLevel;
            if (classChoice.equals("magicien")) {
                Personnage clement = new Magician(name, image, lifeLevel, strenghtAttack);
                personnageList[i] = clement;
                System.out.println(personnageList[i]);
                i++;
            } else if (classChoice.equals("guerrier")) {
                Personnage clement = new Warrior(name, image, lifeLevel, strenghtAttack);
                try {
                    personnageList[i] = clement;
                    System.out.println(personnageList[i]);
                    i++;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Aucun emplacement de sauvegarde disponible");
                }

            } else if (classChoice.equals("quittez")) {
                quit();
            } else if (classChoice.equals("liste")) {
                int save = 0;
                for (int j = 0; j < personnageList.length; j++) {
                    System.out.println("n° de sauvegarde " + save + " " + personnageList[j]);
                    save++;
                }
            } else if (classChoice.equals("modifier")) {
                int save = 0;
                for (int j = 0; j < personnageList.length; j++) {

                    System.out.println("n° de sauvegarde " + save + " " + personnageList[j]);
                    save++;
                }
                System.out.println("Menu : ");
                System.out.println("Modifier un personnage ->      << modifier >>");
                System.out.println("supprimer un personnage ->      << supprimer >>");
                Scanner scan = new Scanner(System.in);
                String updateChoice = scan.nextLine();
                if (updateChoice.equals("modifier")){
                int persoUpdate;
                System.out.println("saisissez le n° de sauvegarde du personnage à modifier : ");
                persoUpdate = sc.nextInt();
                System.out.println("vous avez choisie de modifier : ");
                System.out.println(personnageList[persoUpdate].toString());
                Scanner newSc = new Scanner(System.in);
                System.out.println("voulez-vous modifier le nom ? yes/no");
                if (newSc.nextLine().equals("yes")) {
                    Scanner newName = new Scanner(System.in);
                    System.out.println("nouveau nom : ");
                    personnageList[persoUpdate].setName(newName.nextLine());
                }
                System.out.println("voulez-vous modifier l'image ? yes/no");
                if (newSc.nextLine().equals("yes")) {
                    Scanner newImage = new Scanner(System.in);
                    System.out.println("nouvelle image : ");
                    personnageList[persoUpdate].setImage(newImage.nextLine());
                }
                Scanner newScInt = new Scanner(System.in);
                System.out.println("voulez-vous modifier la force d'attaque ? yes/no");
                if (newScInt.nextLine().equals("yes")) {
                    System.out.println("nouvelle force d'attaque : ");
                    personnageList[persoUpdate].setStrenghtAttack(sc.nextInt());
                }
                System.out.println("voulez-vous modifier le niveau de vie ? yes/no");
                if (newScInt.nextLine().equals("yes")) {
                    System.out.println("nouveau niveau de vie : ");
                    personnageList[persoUpdate].setLifeLevel(sc.nextInt());
                }
                }else if (updateChoice.equals("supprimer")){
                    int persoRemove;
                    System.out.println("saisissez le n° de sauvegarde du personnage à supprimer : ");
                    persoRemove = sc.nextInt();
                    personnageList[persoRemove] = null;

                }
            }else {
                invalide(); }
        } while (!classChoice.equals("magician") || !classChoice.equals("warrior"));
    }

    public static void invalide() {
        System.out.println("Choix invalide  ! choisissez warrior ou magician");

    }
    public static void quit() {
        System.exit(1);

    }
}

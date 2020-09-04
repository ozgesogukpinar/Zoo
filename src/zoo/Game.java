package zoo;

import java.lang.reflect.*;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        //get animal factory
        AnimalFactory sheepFactory = AnimalProducer.getFactory("SheepFactory");
        Animal femaleSheep = sheepFactory.getAnimal("FemaleSheep");
        Animal maleSheep = sheepFactory.getAnimal("MaleSheep");

        AnimalFactory cowFactory = AnimalProducer.getFactory("CowFactory");
        Animal cow = cowFactory.getAnimal("Cow");
        Animal bull = cowFactory.getAnimal("Bull");

        AnimalFactory chickenFactory = AnimalProducer.getFactory("ChickenFactory");
        Animal hen = chickenFactory.getAnimal("Hen");
        Animal rooster = chickenFactory.getAnimal("Rooster");

        AnimalFactory wolfFactory = AnimalProducer.getFactory("WolfFactory");
        Animal femaleWolf = wolfFactory.getAnimal("FemaleWolf");
        Animal maleWolf = wolfFactory.getAnimal("MaleWolf");

        AnimalFactory lionFactory = AnimalProducer.getFactory("LionFactory");
        Animal femaleLion = lionFactory.getAnimal("FemaleLion");
        Animal maleLion = lionFactory.getAnimal("MaleLion");

        AnimalFactory hunterFactory = AnimalProducer.getFactory("HunterFactory");
        Animal hunter = hunterFactory.getAnimal("Hunter");

        Object[][] farmLand = new Object[500][500];
        Random rnd = new Random();
        int row, column;
        //animals are distributed on the farm land
        for (int i = 1; i < 80; i++) {
            row = rnd.nextInt(500);
            column = rnd.nextInt(500);
            if (i <= 15 && farmLand[row][column] == null) {
                farmLand[row][column] = femaleSheep;
            } else if (i > 15 && i <= 30 && farmLand[row][column] == null) {
                farmLand[row][column] = maleSheep;
            } else if (i > 30 && i <= 35 && farmLand[row][column] == null) {
                farmLand[row][column] = cow;
            } else if (i > 35 && i <= 40 && farmLand[row][column] == null) {
                farmLand[row][column] = bull;
            } else if (i > 40 && i <= 50 && farmLand[row][column] == null) {
                farmLand[row][column] = hen;
            } else if (i > 50 && i <= 60 && farmLand[row][column] == null) {
                farmLand[row][column] = rooster;
            } else if (i > 60 && i <= 65 && farmLand[row][column] == null) {
                farmLand[row][column] = femaleWolf;
            } else if (i > 65 && i <= 70 && farmLand[row][column] == null) {
                farmLand[row][column] = maleWolf;
            } else if (i > 70 && i <= 74 && farmLand[row][column] == null) {
                farmLand[row][column] = femaleLion;
            } else if (i > 74 && i <= 78 && farmLand[row][column] == null) {
                farmLand[row][column] = maleLion;
            } else if (i == 79 && farmLand[row][column] == null) {
                farmLand[row][column] = hunter;
            } else {
                i--;
                continue;
            }
        }
        hunt(farmLand);
        born(farmLand);
        move(farmLand);
        animalCount(farmLand);
    }

    public static void move(Object farmLand[][]) {
        Random rnd = new Random();
        int stepCount = 0;
        while (stepCount <= 1000) {
            int directorSelector = rnd.nextInt(4) + 1; // 1 -> right, 2 -> left, 3 -> up, 4 -> down
            int row = rnd.nextInt(500), column = rnd.nextInt(500);
            if (farmLand[row][column] != null) {
                if (directorSelector == 1) {
                    Class c = farmLand[row][column].getClass();
                    try {
                        Method m = c.getDeclaredMethod("right", new Class[]{Integer.TYPE, Integer.TYPE});
                        int newColumn = (int) m.invoke(farmLand[row][column], new Object[]{row, column});
                        if (newColumn != -1 && farmLand[row][newColumn] == null) {
                            stepCount = stepCount + Math.abs(newColumn - column);
                            if (stepCount > 1000) {
                                break;
                            }
                            farmLand[row][newColumn] = farmLand[row][column];
                            farmLand[row][column] = null;
                            hunt(farmLand);
                            born(farmLand);
                        }
                    } catch (Exception e) {
                        row = rnd.nextInt(500);
                        column = rnd.nextInt(500);
                        continue;
                    }
                }
                if (directorSelector == 2) {
                    Class c = farmLand[row][column].getClass();
                    try {
                        Method m = c.getDeclaredMethod("left", new Class[]{Integer.TYPE, Integer.TYPE});
                        int newColumn = (int) m.invoke(farmLand[row][column], new Object[]{row, column});
                        if (newColumn != -1 && farmLand[row][newColumn] == null) {
                            stepCount = stepCount + Math.abs(column - newColumn);
                            if (stepCount > 1000) {
                                break;
                            }
                            farmLand[row][newColumn] = farmLand[row][column];
                            farmLand[row][column] = null;
                            hunt(farmLand);
                            born(farmLand);
                        }
                    } catch (Exception e) {
                        row = rnd.nextInt(500);
                        column = rnd.nextInt(500);
                        continue;
                    }
                }
                if (directorSelector == 3) {
                    Class c = farmLand[row][column].getClass();
                    try {
                        Method m = c.getDeclaredMethod("up", new Class[]{Integer.TYPE, Integer.TYPE});
                        int newRow = (int) m.invoke(farmLand[row][column], new Object[]{row, column});
                        if (newRow != -1 && farmLand[newRow][column] == null) {
                            stepCount = stepCount + Math.abs(row - newRow);
                            if (stepCount > 1000) {
                                break;
                            }
                            farmLand[newRow][column] = farmLand[row][column];
                            farmLand[row][column] = null;
                            hunt(farmLand);
                            born(farmLand);
                        }
                    } catch (Exception e) {
                        row = rnd.nextInt(500);
                        column = rnd.nextInt(500);
                        continue;
                    }
                }
                if (directorSelector == 4) {
                    Class c = farmLand[row][column].getClass();
                    try {
                        Method m = c.getDeclaredMethod("down", new Class[]{Integer.TYPE, Integer.TYPE});
                        int newRow = (int) m.invoke(farmLand[row][column], new Object[]{row, column});
                        if (newRow != -1 && farmLand[newRow][column] == null) {
                            stepCount = stepCount + Math.abs(newRow - row);
                            if (stepCount > 1000) {
                                break;
                            }
                            farmLand[newRow][column] = farmLand[row][column];
                            farmLand[row][column] = null;
                            hunt(farmLand);
                            born(farmLand);
                        }
                    } catch (Exception e) {
                        row = rnd.nextInt(500);
                        column = rnd.nextInt(500);
                        continue;
                    }
                }
            } else {
                row = rnd.nextInt(500);
                column = rnd.nextInt(500);
                continue;
            }
        }
    }

    public static void hunt(Object farmLand[][]) {
        Hunt huntObject = new Hunt();
        for (int i = 0; i < farmLand.length; i++) {
            for (int j = 0; j < farmLand.length; j++) {
                if (farmLand[i][j] != null) {
                    String classType = farmLand[i][j].getClass().getSuperclass().getSimpleName();
                    if (classType.equalsIgnoreCase("WolfFactory")) {
                        huntObject.hunterWolf(farmLand, i, j);
                    } else if (classType.equalsIgnoreCase("LionFactory")) {
                        huntObject.hunterLion(farmLand, i, j);
                    } else if (classType.equalsIgnoreCase("HuterFactory")) {
                        huntObject.hunter(farmLand, i, j);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static void born(Object farmLand[][]) {
        Random rnd = new Random();
        for (int i = 0; i < farmLand.length; i++) {
            for (int j = 0; j < farmLand.length; j++) {
                int row = rnd.nextInt(500);
                int column = rnd.nextInt(500);
                Class animal1, animal2;
                if (farmLand[i][j] != null) {
                    animal1 = farmLand[i][j].getClass();
                    if (j + 3 < farmLand.length && farmLand[i][j + 3] != null) {
                        animal2 = farmLand[i][j + 3].getClass();
                        if (animal1 != animal2 && animal1.getSuperclass() == animal2.getSuperclass()) {
                            if (farmLand[row][column] == null) {
                                int sex = rnd.nextInt(1);
                                if (sex == 0) {
                                    farmLand[row][column] = farmLand[i][j];
                                } else {
                                    farmLand[row][column] = farmLand[i][j + 3];
                                }
                            }
                        }
                    }
                    if (j - 3 >= 0 && farmLand[i][j - 3] != null) {
                        animal2 = farmLand[i][j - 3].getClass();
                        if (animal1 != animal2 && animal1.getSuperclass() == animal2.getSuperclass()) {
                            if (farmLand[row][column] == null) {
                                int sex = rnd.nextInt(1);
                                if (sex == 0) {
                                    farmLand[row][column] = farmLand[i][j];
                                } else {
                                    farmLand[row][column] = farmLand[i][j - 3];
                                }
                            }
                        }
                    }
                    if (i + 3 < farmLand.length && farmLand[i + 3][j] != null) {
                        animal2 = farmLand[i + 3][j].getClass();
                        if (animal1 != animal2 && animal1.getSuperclass() == animal2.getSuperclass()) {
                            if (farmLand[row][column] == null) {
                                int sex = rnd.nextInt(1);
                                if (sex == 0) {
                                    farmLand[row][column] = farmLand[i][j];
                                } else {
                                    farmLand[row][column] = farmLand[i + 3][j];
                                }
                            }
                        }
                    }
                    if (i - 3 >= 0 && farmLand[i - 3][j] != null) {
                        animal2 = farmLand[i - 3][j].getClass();
                        if (animal1 != animal2 && animal1.getSuperclass() == animal2.getSuperclass()) {
                            if (farmLand[row][column] == null) {
                                int sex = rnd.nextInt(1);
                                if (sex == 0) {
                                    farmLand[row][column] = farmLand[i][j];
                                } else {
                                    farmLand[row][column] = farmLand[i - 3][j];
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void animalCount(Object farmLand[][]) {
        int femaleSheep = 0, maleSheep = 0, cow = 0, bull = 0, femaleLion = 0, maleLion = 0, femaleWolf = 0, maleWolf = 0, hen = 0, rooster = 0;
        for (int i = 0; i < farmLand.length; i++) {
            for (int j = 0; j < farmLand.length; j++) {
                if (farmLand[i][j] != null) {
                    if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("FemaleSheep")) {
                        femaleSheep++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("MaleSheep")) {
                        maleSheep++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("Cow")) {
                        cow++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("Bull")) {
                        bull++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("FemaleLion")) {
                        femaleLion++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("MaleLion")) {
                        maleLion++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("FemaleWolf")) {
                        femaleWolf++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("MaleWolf")) {
                        maleWolf++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("Hen")) {
                        hen++;
                    } else if (farmLand[i][j].getClass().getSimpleName().equalsIgnoreCase("Rooster")) {
                        rooster++;
                    }
                }
            }
        }
        System.out.println("There are " + femaleSheep + " female sheep, " + maleSheep + " male sheep, " + cow + " cow, " + bull
                + " bull, " + femaleLion + " female lion, " + maleLion + " male lion, " + femaleWolf + " female wolf, " + maleWolf
                + " male wolf, " + hen + " hen, " + rooster + " rooster.");
    }

}

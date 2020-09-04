package zoo;

public class Hunt {

    public void hunterWolf(Object farmLand[][], int row, int column) {
        if (column + 4 < farmLand.length && farmLand[row][column + 4] != null) {
            String animalTypeOnRight = farmLand[row][column + 4].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnRight.equalsIgnoreCase("SheepFactory") || animalTypeOnRight.equalsIgnoreCase("ChickenFactory")) {
                farmLand[row][column + 4] = null;
            }
        }
        if (column - 4 >= 0 && farmLand[row][column - 4] != null) {
            String animalTypeOnLeft = farmLand[row][column - 4].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnLeft.equalsIgnoreCase("SheepFactory") || animalTypeOnLeft.equalsIgnoreCase("ChickenFactory")) {
                farmLand[row][column - 4] = null;
            }
        }
        if (row - 4 >= 0 && farmLand[row - 4][column] != null) {
            String animalTypeOnUp = farmLand[row - 4][column].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnUp.equalsIgnoreCase("SheepFactory") || animalTypeOnUp.equalsIgnoreCase("ChickenFactory")) {
                farmLand[row - 4][column] = null;
            }
        }
        if (row + 4 < farmLand.length && farmLand[row + 4][column] != null) {
            String animalTypeOnDown = farmLand[row + 4][column].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnDown.equalsIgnoreCase("SheepFactory") || animalTypeOnDown.equalsIgnoreCase("ChickenFactory")) {
                farmLand[row + 4][column] = null;
            }
        }
    }

    public void hunterLion(Object farmLand[][], int row, int column) {
        if (column + 5 < farmLand.length && farmLand[row][column + 5] != null) {
            String animalTypeOnRight = farmLand[row][column + 5].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnRight.equalsIgnoreCase("SheepFactory") || animalTypeOnRight.equalsIgnoreCase("CowFactory")) {
                farmLand[row][column + 5] = null;
            }
        }
        if (column - 5 >= 0 && farmLand[row][column - 5] != null) {
            String animalTypeOnLeft = farmLand[row][column - 5].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnLeft.equalsIgnoreCase("SheepFactory") || animalTypeOnLeft.equalsIgnoreCase("CowFactory")) {
                farmLand[row][column - 5] = null;
            }
        }
        if (row - 5 >= 0 && farmLand[row - 5][column] != null) {
            String animalTypeOnUp = farmLand[row - 5][column].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnUp.equalsIgnoreCase("SheepFactory") || animalTypeOnUp.equalsIgnoreCase("CowFactory")) {
                farmLand[row - 5][column] = null;
            }
        }
        if (row + 5 < farmLand.length && farmLand[row + 5][column] != null) {
            String animalTypeOnDown = farmLand[row + 5][column].getClass().getSuperclass().getSimpleName();
            if (animalTypeOnDown.equalsIgnoreCase("SheepFactory") || animalTypeOnDown.equalsIgnoreCase("CowFactory")) {
                farmLand[row + 5][column] = null;
            }
        }
    }

    public void hunter(Object farmLand[][], int row, int column) {
        if (column + 8 < farmLand.length && farmLand[row][column + 8] != null) {
            farmLand[row][column + 8] = null;
        }
        if (column - 8 >= 0 && farmLand[row][column - 8] != null) {
            farmLand[row][column - 8] = null;
        }
        if (row - 8 >= 0 && farmLand[row - 8][column] != null) {
            farmLand[row - 8][column] = null;
        }
        if (row + 8 < farmLand.length && farmLand[row + 8][column] != null) {
            farmLand[row + 8][column] = null;
        }
    }

}

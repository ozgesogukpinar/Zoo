package zoo;

public class MaleSheep extends SheepFactory implements Animal {

    @Override
    public int right(int row, int column) {
        if (column + 2 < 500) {
            return column + 2;
        }
        return -1;
    }

    @Override
    public int left(int row, int column) {
        if (column - 2 >= 0) {
            return column - 2;
        }
        return -1;
    }

    @Override
    public int up(int row, int column) {
        if (row - 2 >= 0) {
            return row - 2;
        }
        return -1;
    }

    @Override
    public int down(int row, int column) {
        if (row + 2 < 500) {
            return row + 2;
        }
        return -1;
    }
}
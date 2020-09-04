package zoo;

public class FemaleWolf extends WolfFactory implements Animal {

    @Override
    public int right(int row, int column) {
        if (column + 3 < 500) {
            return column + 3;
        }
        return -1;
    }

    @Override
    public int left(int row, int column) {
        if (column - 3 >= 0) {
            return column - 3;
        }
        return -1;
    }

    @Override
    public int up(int row, int column) {
        if (row - 3 >= 0) {
            return row - 3;
        }
        return -1;
    }

    @Override
    public int down(int row, int column) {
        if (row + 3 < 500) {
            return row + 3;
        }
        return -1;
    }
}

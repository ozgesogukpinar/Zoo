package zoo;

public class MaleLion extends LionFactory implements Animal {

    @Override
    public int right(int row, int column) {
        if (column + 4 < 500) {
            return column + 4;
        }
        return -1;
    }

    @Override
    public int left(int row, int column) {
        if (column - 4 >= 0) {
            return column - 4;
        }
        return -1;
    }

    @Override
    public int up(int row, int column) {
        if (row - 4 >= 0) {
            return row - 4;
        }
        return -1;
    }

    @Override
    public int down(int row, int column) {
        if (row + 4 < 500) {
            return row + 4;
        }
        return -1;
    }
}

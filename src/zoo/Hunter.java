package zoo;

public class Hunter extends HunterFactory implements Animal {

    @Override
    public int right(int row, int column) {
        if (column + 1 < 500) {
            return column + 1;
        }
        return -1;
    }

    @Override
    public int left(int row, int column) {
        if (column - 1 >= 0) {
            return column - 1;
        }
        return -1;
    }

    @Override
    public int up(int row, int column) {
        if (row - 1 >= 0) {
            return row - 1;
        }
        return -1;
    }

    @Override
    public int down(int row, int column) {
        if (row + 1 < 500) {
            return row + 1;
        }
        return -1;
    }

}

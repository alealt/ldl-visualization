package at.ac.tuwien.big.leveldesign.ui.model;

/**
 * Created by alexander on 19/05/16.
 */
public class CoordinateView {

    int column, row;

    public CoordinateView(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinateView that = (CoordinateView) o;

        if (column != that.column) return false;
        return row == that.row;

    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }

    @Override
    public String toString() {
        return "CoordinateView{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}

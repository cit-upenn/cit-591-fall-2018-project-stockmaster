import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.columns.Column;

import static sun.misc.MessageUtils.out;
import static tech.tablesaw.api.TextColumn.create;

public class Graph {

    public static void main(String[] args) {
        DoubleColumn column = DoubleColumn.create("test");
        double[] values = {1, 2, 3, 7, 9.44242, 11};
        NumberColumn column1 = DoubleColumn.create("my numbers", values);
        out(column1.print());
    }


}

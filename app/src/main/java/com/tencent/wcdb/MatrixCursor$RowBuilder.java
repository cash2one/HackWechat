package com.tencent.wcdb;

public class MatrixCursor$RowBuilder {
    private final int endIndex;
    private int index;
    final /* synthetic */ MatrixCursor this$0;

    MatrixCursor$RowBuilder(MatrixCursor matrixCursor, int i, int i2) {
        this.this$0 = matrixCursor;
        this.index = i;
        this.endIndex = i2;
    }

    public MatrixCursor$RowBuilder add(Object obj) {
        if (this.index == this.endIndex) {
            throw new CursorIndexOutOfBoundsException("No more columns left.");
        }
        Object[] access$000 = MatrixCursor.access$000(this.this$0);
        int i = this.index;
        this.index = i + 1;
        access$000[i] = obj;
        return this;
    }
}

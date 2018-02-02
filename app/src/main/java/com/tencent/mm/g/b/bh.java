package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class bh extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fXI = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gdA = "logContent".hashCode();
    private static final int gdz = "protocolNumber".hashCode();
    private boolean fNB = true;
    private boolean fXF = true;
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;
    private boolean gdx = true;
    private boolean gdy = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXI == hashCode) {
                    this.field_id = cursor.getString(i);
                    this.fXF = true;
                } else if (gdz == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i);
                } else if (gdA == hashCode) {
                    this.field_logContent = cursor.getString(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXF) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, this.field_id);
        }
        if (this.gdx) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.gdy) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

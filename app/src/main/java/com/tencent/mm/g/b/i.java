package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class i extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fPh = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int fPi = "dataType".hashCode();
    private static final int fPj = "size".hashCode();
    private boolean fPc = true;
    private boolean fPe = true;
    private boolean fPf = true;
    private boolean fPg = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fPc = true;
                } else if (fPh == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (fPi == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (fPj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.fPe) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.fPf) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.fPg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fUk = "card_id".hashCode();
    private static final int gmh = "retryCount".hashCode();
    private static final int goW = "state_flag".hashCode();
    private static final int goX = "update_time".hashCode();
    private static final int goY = "seq".hashCode();
    private boolean fTR = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;
    private boolean gmf = true;
    private boolean goT = true;
    private boolean goU = true;
    private boolean goV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fTR = true;
                } else if (goW == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (goX == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (goY == hashCode) {
                    this.field_seq = cursor.getLong(i);
                } else if (gmh == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fTR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.goT) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.goU) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.goV) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.gmf) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

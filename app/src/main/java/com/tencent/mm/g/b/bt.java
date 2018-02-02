package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fYy = "sort".hashCode();
    private static final int gga = "rankID".hashCode();
    private static final int ggb = "appusername".hashCode();
    private static final int ggg = "step".hashCode();
    private boolean fPs = true;
    private boolean fXY = true;
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;
    private boolean gfX = true;
    private boolean gfY = true;
    private boolean ggf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggb == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (gga == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ggg == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (fYy == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gfY) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.gfX) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.ggf) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.fXY) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

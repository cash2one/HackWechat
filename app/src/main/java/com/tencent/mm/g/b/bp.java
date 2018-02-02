package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int gfj = "championUrl".hashCode();
    private static final int gfk = "championMotto".hashCode();
    private boolean fPs = true;
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;
    private boolean gfh = true;
    private boolean gfi = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gfj == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (gfk == hashCode) {
                    this.field_championMotto = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.gfh) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.gfi) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int gck = "timestamp".hashCode();
    private static final int gga = "rankID".hashCode();
    private static final int ggb = "appusername".hashCode();
    private static final int ggc = "liketips".hashCode();
    private boolean fPs = true;
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;
    private boolean gca = true;
    private boolean gfX = true;
    private boolean gfY = true;
    private boolean gfZ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gga == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (ggb == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gck == hashCode) {
                    this.field_timestamp = cursor.getInt(i);
                } else if (ggc == hashCode) {
                    this.field_liketips = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gfX) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.gfY) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.gca) {
            contentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.gfZ) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

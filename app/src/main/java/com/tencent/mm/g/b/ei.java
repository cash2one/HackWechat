package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ei extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fPj = "size".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fRU = "msgType".hashCode();
    private static final int gbc = "path".hashCode();
    private static final int gwh = "msgSubType".hashCode();
    private static final int gwi = "msgtime".hashCode();
    private boolean fMO = true;
    private boolean fPg = true;
    private boolean fPs = true;
    private boolean fRG = true;
    public long field_msgId;
    public int field_msgSubType;
    public int field_msgType;
    public long field_msgtime;
    public String field_path;
    public long field_size;
    public String field_username;
    private boolean gaW = true;
    private boolean gwf = true;
    private boolean gwg = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fRU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (gwh == hashCode) {
                    this.field_msgSubType = cursor.getInt(i);
                } else if (gbc == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (fPj == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (gwi == hashCode) {
                    this.field_msgtime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fRG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.gwf) {
            contentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
        }
        if (this.gaW) {
            contentValues.put("path", this.field_path);
        }
        if (this.fPg) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.gwg) {
            contentValues.put("msgtime", Long.valueOf(this.field_msgtime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

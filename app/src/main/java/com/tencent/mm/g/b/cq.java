package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class cq extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int gms = "hit".hashCode();
    private static final int gmt = "hitTimeMS".hashCode();
    private boolean fNE = true;
    private boolean fOu = true;
    public String field_appId;
    public int field_hit;
    public long field_hitTimeMS;
    public int field_type;
    private boolean gmq = true;
    private boolean gmr = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gms == hashCode) {
                    this.field_hit = cursor.getInt(i);
                } else if (gmt == hashCode) {
                    this.field_hitTimeMS = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gmq) {
            contentValues.put("hit", Integer.valueOf(this.field_hit));
        }
        if (this.gmr) {
            contentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

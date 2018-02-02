package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gbg = "configId".hashCode();
    private static final int guO = "disable".hashCode();
    private static final int guP = "configUrl".hashCode();
    private static final int guQ = "configResources".hashCode();
    private static final int guR = "configCrc32".hashCode();
    private static final int guS = "isFromXml".hashCode();
    public long field_configCrc32;
    public String field_configId;
    public String field_configResources;
    public String field_configUrl;
    public boolean field_disable;
    public boolean field_isFromXml;
    private boolean gbf = true;
    private boolean guJ = true;
    private boolean guK = true;
    private boolean guL = true;
    private boolean guM = true;
    private boolean guN = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guO == hashCode) {
                    boolean z;
                    if (cursor.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.field_disable = z;
                } else if (gbg == hashCode) {
                    this.field_configId = cursor.getString(i);
                    this.gbf = true;
                } else if (guP == hashCode) {
                    this.field_configUrl = cursor.getString(i);
                } else if (guQ == hashCode) {
                    this.field_configResources = cursor.getString(i);
                } else if (guR == hashCode) {
                    this.field_configCrc32 = cursor.getLong(i);
                } else if (guS == hashCode) {
                    this.field_isFromXml = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.guJ) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.gbf) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.guK) {
            contentValues.put("configUrl", this.field_configUrl);
        }
        if (this.guL) {
            contentValues.put("configResources", this.field_configResources);
        }
        if (this.guM) {
            contentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
        }
        if (this.guN) {
            contentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cw extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int gnR = "productId".hashCode();
    private static final int gnS = "xmlContent".hashCode();
    private static final int gnT = "ScanTime".hashCode();
    private static final int gnU = "funcType".hashCode();
    private static final int gnV = "qrcodeUrl".hashCode();
    private boolean fOq = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;
    private boolean gnM = true;
    private boolean gnN = true;
    private boolean gnO = true;
    private boolean gnP = true;
    private boolean gnQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnR == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.gnM = true;
                } else if (gnS == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (gnT == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (gnU == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (gnV == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gnM) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.gnN) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.gnO) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.gnP) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.gnQ) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

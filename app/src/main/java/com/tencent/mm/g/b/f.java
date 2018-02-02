package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class f extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fOt = "ticket".hashCode();
    private boolean fNz = true;
    private boolean fOq = true;
    private boolean fOr = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xjA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.xjA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "ticket";
        aVar.xjA.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fOt == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fOr) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

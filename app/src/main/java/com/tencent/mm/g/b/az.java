package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public abstract class az extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int gbg = "configId".hashCode();
    private boolean fNb = true;
    public int field_configId;
    public String field_value;
    private boolean gbf = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "configId";
        aVar.xjA.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "configId";
        aVar.columns[1] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbg == hashCode) {
                    this.field_configId = cursor.getInt(i);
                    this.gbf = true;
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gbf) {
            contentValues.put("configId", Integer.valueOf(this.field_configId));
        }
        if (this.fNb) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

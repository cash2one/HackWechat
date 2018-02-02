package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public abstract class bc extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fUj = "time".hashCode();
    private static final int gbP = "tagContent".hashCode();
    private static final int gbQ = "subtype".hashCode();
    private static final int gbj = "localId".hashCode();
    private boolean fNE = true;
    private boolean fNJ = true;
    private boolean fTQ = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;
    private boolean gbN = true;
    private boolean gbO = true;
    private boolean gbh = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xjA.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "localId";
        aVar.columns[1] = "content";
        aVar.xjA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "tagContent";
        aVar.xjA.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "time";
        aVar.xjA.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "subtype";
        aVar.xjA.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbj == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gbh = true;
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gbP == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (fUj == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gbQ == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gbh) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gbN) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.fTQ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gbO) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

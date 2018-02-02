package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class ba extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fUj = "time".hashCode();
    private static final int gbj = "localId".hashCode();
    private static final int gbk = "modItem".hashCode();
    private boolean fNE = true;
    private boolean fOq = true;
    private boolean fTQ = true;
    public long field_localId;
    public uu field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;
    private boolean gbh = true;
    private boolean gbi = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xjA.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "modItem";
        aVar.xjA.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.columns[2] = "time";
        aVar.xjA.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.xjA.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
        aVar.columns[5] = "rowid";
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
                } else if (gbk == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (uu) new uu().aF(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (fUj == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
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
        if (this.gbh) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.gbi && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.fTQ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
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

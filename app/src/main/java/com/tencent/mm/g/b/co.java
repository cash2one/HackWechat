package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public abstract class co extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gcI = DownloadInfo.FILENAME.hashCode();
    private static final int gkN = "musicId".hashCode();
    private static final int gmm = "musicUrl".hashCode();
    private static final int gmn = "indexBitData".hashCode();
    private static final int gmo = "fileCacheComplete".hashCode();
    private static final int gmp = "pieceFileMIMEType".hashCode();
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;
    private boolean gcp = true;
    private boolean gkg = true;
    private boolean gmi = true;
    private boolean gmj = true;
    private boolean gmk = true;
    private boolean gml = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.xjA.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "musicId";
        aVar.columns[1] = "musicUrl";
        aVar.xjA.put("musicUrl", "TEXT");
        stringBuilder.append(" musicUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.FILENAME;
        aVar.xjA.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "indexBitData";
        aVar.xjA.put("indexBitData", "BLOB");
        stringBuilder.append(" indexBitData BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileCacheComplete";
        aVar.xjA.put("fileCacheComplete", "INTEGER");
        stringBuilder.append(" fileCacheComplete INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "pieceFileMIMEType";
        aVar.xjA.put("pieceFileMIMEType", "TEXT");
        stringBuilder.append(" pieceFileMIMEType TEXT");
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
                if (gkN == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gkg = true;
                } else if (gmm == hashCode) {
                    this.field_musicUrl = cursor.getString(i);
                } else if (gcI == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gmn == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i);
                } else if (gmo == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i);
                } else if (gmp == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gkg) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.gmi) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.gcp) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gmj) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.gmk) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.gml) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

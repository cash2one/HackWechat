package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class db extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int gbj = "localId".hashCode();
    private static final int gcI = DownloadInfo.FILENAME.hashCode();
    private static final int gpe = "fileNameHash".hashCode();
    private static final int gpf = "fileMd5".hashCode();
    private static final int gpg = "fileLength".hashCode();
    private static final int gph = "fileStatus".hashCode();
    private static final int gpi = "fileDuration".hashCode();
    private boolean fNB = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;
    private boolean gbh = true;
    private boolean gcp = true;
    private boolean goZ = true;
    private boolean gpa = true;
    private boolean gpb = true;
    private boolean gpc = true;
    private boolean gpd = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbj == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gbh = true;
                } else if (gcI == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gpe == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (gpf == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (gpg == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (gph == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (gpi == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gbh) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.gcp) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.goZ) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.gpa) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.gpb) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.gpc) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.gpd) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

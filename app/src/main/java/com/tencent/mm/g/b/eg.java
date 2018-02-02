package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class eg extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fPB = "version".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fPj = "size".hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int gcF = "downloadUrl".hashCode();
    private static final int gcJ = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gvA = "pkgId".hashCode();
    private static final int gvB = "rid".hashCode();
    private static final int gvC = "mimeType".hashCode();
    private static final int gvD = "downloadNetType".hashCode();
    private static final int gvE = "completeDownload".hashCode();
    private static final int gvF = "autoDownloadCount".hashCode();
    private static final int gvG = "fileDownloadCount".hashCode();
    private boolean fNB = true;
    private boolean fPc = true;
    private boolean fPg = true;
    private boolean fPu = true;
    private boolean fYL = true;
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;
    private boolean gcm = true;
    private boolean gcq = true;
    private boolean gvt = true;
    private boolean gvu = true;
    private boolean gvv = true;
    private boolean gvw = true;
    private boolean gvx = true;
    private boolean gvy = true;
    private boolean gvz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fPc = true;
                } else if (gvA == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gcJ == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gvB == hashCode) {
                    this.field_rid = cursor.getString(i);
                } else if (gvC == hashCode) {
                    this.field_mimeType = cursor.getString(i);
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gcF == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (fPj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gvD == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (gvE == hashCode) {
                    this.field_completeDownload = cursor.getInt(i) != 0;
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gvF == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (gvG == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gvt) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.fPu) {
            contentValues.put("version", this.field_version);
        }
        if (this.gcq) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gvu) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.gvv) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gcm) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.fPg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.gvw) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.gvx) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gvy) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.gvz) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

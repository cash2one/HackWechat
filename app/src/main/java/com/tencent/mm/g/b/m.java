package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class m extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fNo = "endTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPB = "version".hashCode();
    private static final int fPC = "versionMd5".hashCode();
    private static final int fPD = "versionState".hashCode();
    private static final int fPE = "pkgPath".hashCode();
    private static final int fPF = "resourceCount".hashCode();
    private static final int fPG = "debugType".hashCode();
    private static final int fPH = "downloadURL".hashCode();
    private boolean fNB = true;
    private boolean fNf = true;
    private boolean fNg = true;
    private boolean fOu = true;
    private boolean fPA = true;
    private boolean fPu = true;
    private boolean fPv = true;
    private boolean fPw = true;
    private boolean fPx = true;
    private boolean fPy = true;
    private boolean fPz = true;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public int field_resourceCount;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (fPC == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (fPD == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (fPE == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fPF == hashCode) {
                    this.field_resourceCount = cursor.getInt(i);
                } else if (fPG == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (fPH == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (fNn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fNo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
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
        if (this.fPu) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.fPv) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.fPw) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.fPx) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fPy) {
            contentValues.put("resourceCount", Integer.valueOf(this.field_resourceCount));
        }
        if (this.fPz) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.fPA) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.fNf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fNg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

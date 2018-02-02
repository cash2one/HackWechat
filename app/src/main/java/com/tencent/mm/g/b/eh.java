package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eh extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPB = "version".hashCode();
    private static final int fPE = "pkgPath".hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int gcF = "downloadUrl".hashCode();
    private static final int guO = "disable".hashCode();
    private static final int gvA = "pkgId".hashCode();
    private static final int gvD = "downloadNetType".hashCode();
    private static final int gvF = "autoDownloadCount".hashCode();
    private static final int gvT = "disableWvCache".hashCode();
    private static final int gvU = "clearPkgTime".hashCode();
    private static final int gvV = "checkIntervalTime".hashCode();
    private static final int gvW = "packMethod".hashCode();
    private static final int gvX = "pkgSize".hashCode();
    private static final int gvY = "nextCheckTime".hashCode();
    private static final int gvZ = "charset".hashCode();
    private static final int gvl = "domain".hashCode();
    private static final int gvo = "accessTime".hashCode();
    private static final int gwa = "bigPackageReady".hashCode();
    private static final int gwb = "preloadFilesReady".hashCode();
    private static final int gwc = "preloadFilesAtomic".hashCode();
    private static final int gwd = "totalDownloadCount".hashCode();
    private static final int gwe = "packageDownloadCount".hashCode();
    private boolean fNB = true;
    private boolean fOu = true;
    private boolean fPu = true;
    private boolean fPx = true;
    private boolean fYL = true;
    public long field_accessTime;
    public String field_appId;
    public int field_autoDownloadCount;
    public boolean field_bigPackageReady;
    public String field_charset;
    public long field_checkIntervalTime;
    public long field_clearPkgTime;
    public long field_createTime;
    public boolean field_disable;
    public boolean field_disableWvCache;
    public String field_domain;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public String field_md5;
    public long field_nextCheckTime;
    public int field_packMethod;
    public int field_packageDownloadCount;
    public String field_pkgId;
    public String field_pkgPath;
    public int field_pkgSize;
    public boolean field_preloadFilesAtomic;
    public boolean field_preloadFilesReady;
    public int field_totalDownloadCount;
    public String field_version;
    private boolean gcm = true;
    private boolean guJ = true;
    private boolean gvH = true;
    private boolean gvI = true;
    private boolean gvJ = true;
    private boolean gvK = true;
    private boolean gvL = true;
    private boolean gvM = true;
    private boolean gvN = true;
    private boolean gvO = true;
    private boolean gvP = true;
    private boolean gvQ = true;
    private boolean gvR = true;
    private boolean gvS = true;
    private boolean gve = true;
    private boolean gvh = true;
    private boolean gvt = true;
    private boolean gvw = true;
    private boolean gvy = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvA == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                    this.gvt = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (fPE == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (gvT == hashCode) {
                    this.field_disableWvCache = cursor.getInt(i) != 0;
                } else if (gvU == hashCode) {
                    this.field_clearPkgTime = cursor.getLong(i);
                } else if (gvV == hashCode) {
                    this.field_checkIntervalTime = cursor.getLong(i);
                } else if (gvW == hashCode) {
                    this.field_packMethod = cursor.getInt(i);
                } else if (gvl == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gcF == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gvX == hashCode) {
                    this.field_pkgSize = cursor.getInt(i);
                } else if (gvD == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (gvY == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gvo == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (gvZ == hashCode) {
                    this.field_charset = cursor.getString(i);
                } else if (gwa == hashCode) {
                    this.field_bigPackageReady = cursor.getInt(i) != 0;
                } else if (gwb == hashCode) {
                    this.field_preloadFilesReady = cursor.getInt(i) != 0;
                } else if (gwc == hashCode) {
                    this.field_preloadFilesAtomic = cursor.getInt(i) != 0;
                } else if (gvF == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (guO == hashCode) {
                    this.field_disable = cursor.getInt(i) != 0;
                } else if (gwd == hashCode) {
                    this.field_totalDownloadCount = cursor.getInt(i);
                } else if (gwe == hashCode) {
                    this.field_packageDownloadCount = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gvt) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPu) {
            contentValues.put("version", this.field_version);
        }
        if (this.fPx) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.gvH) {
            contentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
        }
        if (this.gvI) {
            contentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
        }
        if (this.gvJ) {
            contentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
        }
        if (this.gvK) {
            contentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
        }
        if (this.gve) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gcm) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.gvL) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.gvw) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.gvM) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gvh) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.field_charset == null) {
            this.field_charset = "UTF-8";
        }
        if (this.gvN) {
            contentValues.put("charset", this.field_charset);
        }
        if (this.gvO) {
            contentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
        }
        if (this.gvP) {
            contentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
        }
        if (this.gvQ) {
            contentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
        }
        if (this.gvy) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.guJ) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.gvR) {
            contentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
        }
        if (this.gvS) {
            contentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

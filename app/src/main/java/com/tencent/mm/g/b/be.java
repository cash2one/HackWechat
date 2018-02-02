package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class be extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fQl = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int gcE = "downloadId".hashCode();
    private static final int gcF = "downloadUrl".hashCode();
    private static final int gcG = DownloadInfo.SECONDARYURL.hashCode();
    private static final int gcH = "fileSize".hashCode();
    private static final int gcI = DownloadInfo.FILENAME.hashCode();
    private static final int gcJ = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gcK = "fileType".hashCode();
    private static final int gcL = "autoInstall".hashCode();
    private static final int gcM = "showNotification".hashCode();
    private static final int gcN = "sysDownloadId".hashCode();
    private static final int gcO = "downloaderType".hashCode();
    private static final int gcP = "downloadUrlHashCode".hashCode();
    private static final int gcQ = "downloadedSize".hashCode();
    private static final int gcR = "totalSize".hashCode();
    private static final int gcS = "autoDownload".hashCode();
    private static final int gcT = DownloadInfoColumns.CHANNELID.hashCode();
    private static final int gcU = "errCode".hashCode();
    private static final int gcV = "startSize".hashCode();
    private static final int gcW = "startState".hashCode();
    private boolean fMW = true;
    private boolean fNf = true;
    private boolean fOq = true;
    private boolean fOu = true;
    private boolean fPO = true;
    private boolean fYL = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public String field_md5;
    public String field_packageName;
    public int field_scene;
    public String field_secondaryUrl;
    public boolean field_showNotification;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;
    private boolean gcA = true;
    private boolean gcB = true;
    private boolean gcC = true;
    private boolean gcD = true;
    private boolean gcl = true;
    private boolean gcm = true;
    private boolean gcn = true;
    private boolean gco = true;
    private boolean gcp = true;
    private boolean gcq = true;
    private boolean gcr = true;
    private boolean gcs = true;
    private boolean gct = true;
    private boolean gcu = true;
    private boolean gcv = true;
    private boolean gcw = true;
    private boolean gcx = true;
    private boolean gcy = true;
    private boolean gcz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcE == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.gcl = true;
                } else if (gcF == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gcG == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i);
                } else if (gcH == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gcI == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gcJ == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gcK == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (gcM == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (gcN == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (gcO == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gcP == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (fQl == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (gcQ == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (gcR == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (gcS == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (gcT == hashCode) {
                    this.field_channelId = cursor.getString(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gcU == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (fNn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gcV == hashCode) {
                    this.field_startSize = cursor.getLong(i);
                } else if (gcW == hashCode) {
                    this.field_startState = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gcl) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.gcm) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.gcn) {
            contentValues.put(DownloadInfo.SECONDARYURL, this.field_secondaryUrl);
        }
        if (this.gco) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.gcp) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.gcq) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gcr) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gcs) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.gct) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.gcu) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.gcv) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gcw) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.fPO) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.gcx) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.gcy) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.gcz) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.gcA) {
            contentValues.put(DownloadInfoColumns.CHANNELID, this.field_channelId);
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.gcB) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.fNf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gcC) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.gcD) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

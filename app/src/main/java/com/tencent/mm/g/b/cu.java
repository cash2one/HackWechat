package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class cu extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOo = "subType".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int gcH = "fileSize".hashCode();
    private static final int gcJ = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gek = "expireTime".hashCode();
    private static final int gnA = "fileCompress".hashCode();
    private static final int gnB = "fileEncrypt".hashCode();
    private static final int gnC = "encryptKey".hashCode();
    private static final int gnD = "keyVersion".hashCode();
    private static final int gnE = "EID".hashCode();
    private static final int gnF = "needRetry".hashCode();
    private static final int gnG = "wvCacheType".hashCode();
    private static final int gnH = "packageId".hashCode();
    private static final int gni = "urlKey_hashcode".hashCode();
    private static final int gnj = "urlKey".hashCode();
    private static final int gnk = "fileVersion".hashCode();
    private static final int gnl = "networkType".hashCode();
    private static final int gnm = "maxRetryTimes".hashCode();
    private static final int gnn = "retryTimes".hashCode();
    private static final int gno = "contentLength".hashCode();
    private static final int gnp = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int gnq = "groupId1".hashCode();
    private static final int gnr = "groupId2".hashCode();
    private static final int gns = DownloadInfo.PRIORITY.hashCode();
    private static final int gnt = "fileUpdated".hashCode();
    private static final int gnu = "deleted".hashCode();
    private static final int gnv = "resType".hashCode();
    private static final int gnw = "reportId".hashCode();
    private static final int gnx = "sampleId".hashCode();
    private static final int gny = "eccSignature".hashCode();
    private static final int gnz = "originalMd5".hashCode();
    private boolean fMW = true;
    private boolean fNS = true;
    private boolean fOu = true;
    private boolean fTW = true;
    private boolean fYL = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;
    private boolean gco = true;
    private boolean gcq = true;
    private boolean geb = true;
    private boolean gmI = true;
    private boolean gmJ = true;
    private boolean gmK = true;
    private boolean gmL = true;
    private boolean gmM = true;
    private boolean gmN = true;
    private boolean gmO = true;
    private boolean gmP = true;
    private boolean gmQ = true;
    private boolean gmR = true;
    private boolean gmS = true;
    private boolean gmT = true;
    private boolean gmU = true;
    private boolean gmV = true;
    private boolean gmW = true;
    private boolean gmX = true;
    private boolean gmY = true;
    private boolean gmZ = true;
    private boolean gna = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean gnd = true;
    private boolean gne = true;
    private boolean gnf = true;
    private boolean gng = true;
    private boolean gnh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gni == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.gmI = true;
                } else if (gnj == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gnk == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (gnl == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (gnm == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (gnn == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (gcJ == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gno == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (gnp == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (gek == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gnq == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (gnr == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (gns == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (gnt == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (gnu == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (gnv == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (fOo == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (gnw == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (gnx == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (gny == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (gnz == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (gnA == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (gnB == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (gnC == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (gnD == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (gnE == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (gcH == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gnF == hashCode) {
                    this.field_needRetry = cursor.getInt(i) != 0;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gnG == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (gnH == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gmI) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.gmJ) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gmK) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.gmL) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.gmM) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.gmN) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.gcq) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gmO) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.gmP) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.geb) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gmQ) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.gmR) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.gmS) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.gmT) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.gmU) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.gmV) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.fNS) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.gmW) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.gmX) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.gmY) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.gmZ) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.gna) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.gnb) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.gnc) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.gnd) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.gne) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.gco) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.gnf) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gng) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.gnh) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class g extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOM = "sdkVer".hashCode();
    private static final int fON = "mediaSvrId".hashCode();
    private static final int fOO = "mediaId".hashCode();
    private static final int fOP = "clientAppDataId".hashCode();
    private static final int fOQ = "totalLen".hashCode();
    private static final int fOR = "offset".hashCode();
    private static final int fOS = "isUpload".hashCode();
    private static final int fOT = "lastModifyTime".hashCode();
    private static final int fOU = "fileFullPath".hashCode();
    private static final int fOV = "fullXml".hashCode();
    private static final int fOW = "msgInfoId".hashCode();
    private static final int fOX = "netTimes".hashCode();
    private static final int fOY = "isUseCdn".hashCode();
    private static final int fOZ = "signature".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fPa = "fakeAeskey".hashCode();
    private static final int fPb = "fakeSignature".hashCode();
    private boolean fMW = true;
    private boolean fNB = true;
    private boolean fNE = true;
    private boolean fOA = true;
    private boolean fOB = true;
    private boolean fOC = true;
    private boolean fOD = true;
    private boolean fOE = true;
    private boolean fOF = true;
    private boolean fOG = true;
    private boolean fOH = true;
    private boolean fOI = true;
    private boolean fOJ = true;
    private boolean fOK = true;
    private boolean fOu = true;
    private boolean fOv = true;
    private boolean fOw = true;
    private boolean fOx = true;
    private boolean fOy = true;
    private boolean fOz = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fOM == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (fON == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (fOO == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (fOP == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (fOQ == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (fOR == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (fOS == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fOT == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (fOU == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_fullXml = cursor.getString(i);
                } else if (fOW == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (fOX == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (fOY == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (fOZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (fPb == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
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
        if (this.fOv) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.fOw) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.fOx) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fOy) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Long.valueOf(this.field_type));
        }
        if (this.fOz) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.fOA) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Long.valueOf(this.field_status));
        }
        if (this.fOB) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fOC) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.fOD) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.fOE) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.fOF) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.fOG) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.fOH) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.fOI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fOJ) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.fOK) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

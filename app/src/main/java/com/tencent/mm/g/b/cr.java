package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class cr extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOO = "mediaId".hashCode();
    private static final int fOQ = "totalLen".hashCode();
    private static final int fOR = "offset".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fZB = "cdnUrl".hashCode();
    private static final int gaZ = "dataId".hashCode();
    private static final int gbF = "toUser".hashCode();
    private static final int gbb = "cdnKey".hashCode();
    private static final int gbc = "path".hashCode();
    private static final int gbj = "localId".hashCode();
    private static final int gcK = "fileType".hashCode();
    private static final int gcU = "errCode".hashCode();
    private static final int gmw = "recordLocalId".hashCode();
    private static final int gmx = "isThumb".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fOA = true;
    private boolean fOx = true;
    private boolean fOz = true;
    private boolean fZc = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public int field_type;
    private boolean gaT = true;
    private boolean gaV = true;
    private boolean gaW = true;
    private boolean gbh = true;
    private boolean gbr = true;
    private boolean gcB = true;
    private boolean gcr = true;
    private boolean gmu = true;
    private boolean gmv = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbj == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gbh = true;
                } else if (gmw == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (gbF == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (fOO == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (gbc == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (fZB == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gbb == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (fOQ == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (gmx == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (fOR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcK == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gcU == hashCode) {
                    this.field_errCode = cursor.getInt(i);
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
        if (this.gmu) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.gbr) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gaT) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.fOx) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.gaW) {
            contentValues.put("path", this.field_path);
        }
        if (this.fZc) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.gaV) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.fOz) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.gmv) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.fOA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcr) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gcB) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

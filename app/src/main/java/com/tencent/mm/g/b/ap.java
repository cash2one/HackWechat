package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ap extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fPj = "size".hashCode();
    private static final int fRh = "source".hashCode();
    private static final int fYD = "idx".hashCode();
    private static final int fYz = "lastUseTime".hashCode();
    private static final int fZA = "thumbUrl".hashCode();
    private static final int fZB = "cdnUrl".hashCode();
    private static final int fZC = "encrypturl".hashCode();
    private static final int fZD = "aeskey".hashCode();
    private static final int fZE = "width".hashCode();
    private static final int fZF = "height".hashCode();
    private static final int fZG = "externUrl".hashCode();
    private static final int fZH = "externMd5".hashCode();
    private static final int fZI = "activityid".hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int fZl = "svrid".hashCode();
    private static final int fZm = "catalog".hashCode();
    private static final int fZn = "start".hashCode();
    private static final int fZo = "state".hashCode();
    private static final int fZp = "name".hashCode();
    private static final int fZq = "reserved1".hashCode();
    private static final int fZr = "reserved2".hashCode();
    private static final int fZs = "reserved3".hashCode();
    private static final int fZt = "reserved4".hashCode();
    private static final int fZu = "app_id".hashCode();
    private static final int fZv = "groupId".hashCode();
    private static final int fZw = "framesInfo".hashCode();
    private static final int fZx = "temp".hashCode();
    private static final int fZy = "needupload".hashCode();
    private static final int fZz = "designerID".hashCode();
    private boolean fNE = true;
    private boolean fNJ = true;
    private boolean fPg = true;
    private boolean fRd = true;
    private boolean fXZ = true;
    private boolean fYL = true;
    private boolean fYM = true;
    private boolean fYN = true;
    private boolean fYO = true;
    private boolean fYP = true;
    private boolean fYQ = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    private boolean fYU = true;
    private boolean fYV = true;
    private boolean fYW = true;
    private boolean fYX = true;
    private boolean fYY = true;
    private boolean fYZ = true;
    private boolean fYd = true;
    private boolean fZa = true;
    private boolean fZb = true;
    private boolean fZc = true;
    private boolean fZd = true;
    private boolean fZe = true;
    private boolean fZf = true;
    private boolean fZg = true;
    private boolean fZh = true;
    private boolean fZi = true;
    private boolean fZj = true;
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_externMd5;
    public String field_externUrl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public long field_lastUseTime;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public int field_type;
    public int field_width;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.fYL = true;
                } else if (fZl == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (fZm == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fPj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (fZn == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (fZo == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (fZp == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fZq == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (fZr == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (fZs == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (fZt == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (fZu == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (fZv == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (fYz == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (fZw == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (fYD == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (fZx == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (fRh == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (fZy == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (fZz == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (fZA == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (fZB == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (fZC == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (fZD == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (fZE == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (fZF == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (fZG == hashCode) {
                    this.field_externUrl = cursor.getString(i);
                } else if (fZH == hashCode) {
                    this.field_externMd5 = cursor.getString(i);
                } else if (fZI == hashCode) {
                    this.field_activityid = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fYM) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.fYN) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fPg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.fYO) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.fYP) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fYQ) {
            contentValues.put("name", this.field_name);
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.fYR) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.fYS) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.fYT) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.fYU) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.fYV) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.fYW) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fXZ) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.fYX) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.fYd) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fYY) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.fRd) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.fYZ) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.fZa) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.fZb) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.fZc) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.fZd) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.fZe) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.fZf) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.fZg) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.fZh) {
            contentValues.put("externUrl", this.field_externUrl);
        }
        if (this.fZi) {
            contentValues.put("externMd5", this.field_externMd5);
        }
        if (this.fZj) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }

    public void reset() {
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public abstract class ay extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOQ = "totalLen".hashCode();
    private static final int fOR = "offset".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fPi = "dataType".hashCode();
    private static final int fQm = "modifyTime".hashCode();
    private static final int fZB = "cdnUrl".hashCode();
    private static final int gaZ = "dataId".hashCode();
    private static final int gba = "favLocalId".hashCode();
    private static final int gbb = "cdnKey".hashCode();
    private static final int gbc = "path".hashCode();
    private static final int gbd = "extFlag".hashCode();
    private static final int gbe = "attrFlag".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fOA = true;
    private boolean fOz = true;
    private boolean fPP = true;
    private boolean fPf = true;
    private boolean fZc = true;
    public long field_attrFlag;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;
    private boolean gaT = true;
    private boolean gaU = true;
    private boolean gaV = true;
    private boolean gaW = true;
    private boolean gaX = true;
    private boolean gaY = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "dataId";
        aVar.xjA.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "dataId";
        aVar.columns[1] = "favLocalId";
        aVar.xjA.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "cdnUrl";
        aVar.xjA.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "cdnKey";
        aVar.xjA.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "totalLen";
        aVar.xjA.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "offset";
        aVar.xjA.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "path";
        aVar.xjA.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "dataType";
        aVar.xjA.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.xjA.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "extFlag";
        aVar.xjA.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrFlag";
        aVar.xjA.put("attrFlag", "LONG default '0' ");
        stringBuilder.append(" attrFlag LONG default '0' ");
        aVar.columns[13] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaZ == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.gaT = true;
                } else if (gba == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fZB == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gbb == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (fOQ == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (fOR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gbc == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (fPi == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (fQm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gbd == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (gbe == hashCode) {
                    this.field_attrFlag = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gaT) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.gaU) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
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
        if (this.fOA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gaW) {
            contentValues.put("path", this.field_path);
        }
        if (this.fPf) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.fPP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gaX) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.gaY) {
            contentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

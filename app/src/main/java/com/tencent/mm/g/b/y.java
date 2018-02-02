package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class y extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fSp = "bitFlag".hashCode();
    private static final int fTA = "attrSyncVersion".hashCode();
    private static final int fTB = "incrementUpdateTime".hashCode();
    private static final int fTo = "brandList".hashCode();
    private static final int fTp = "brandListVersion".hashCode();
    private static final int fTq = "brandListContent".hashCode();
    private static final int fTr = "brandFlag".hashCode();
    private static final int fTs = "extInfo".hashCode();
    private static final int fTt = "brandInfo".hashCode();
    private static final int fTu = "brandIconURL".hashCode();
    private static final int fTv = "hadAlert".hashCode();
    private static final int fTw = "acceptType".hashCode();
    private static final int fTx = "enterpriseFather".hashCode();
    private static final int fTy = "kfWorkerId".hashCode();
    private static final int fTz = "specialType".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fOu = true;
    private boolean fPn = true;
    private boolean fPs = true;
    private boolean fSd = true;
    private boolean fTa = true;
    private boolean fTb = true;
    private boolean fTc = true;
    private boolean fTd = true;
    private boolean fTe = true;
    private boolean fTf = true;
    private boolean fTg = true;
    private boolean fTh = true;
    private boolean fTi = true;
    private boolean fTj = true;
    private boolean fTk = true;
    private boolean fTl = true;
    private boolean fTm = true;
    private boolean fTn = true;
    public int field_acceptType;
    public String field_appId;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fTo == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (fTp == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (fTq == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (fTr == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (fTs == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (fTt == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (fTu == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fTv == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (fTw == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fTx == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (fTy == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (fTz == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (fTA == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (fTB == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (fSp == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.fTa) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.fTb) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.fTc) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.fTd) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.fTe) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.fTf) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.fTg) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.fTh) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.fTi) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fTj) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.fTk) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.fTl) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.fTm) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.fTn) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.fSd) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

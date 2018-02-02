package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cz extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fUk = "card_id".hashCode();
    private static final int fUl = "card_tp_id".hashCode();
    private static final int fZu = "app_id".hashCode();
    private static final int gbA = "updateSeq".hashCode();
    private static final int goG = "from_username".hashCode();
    private static final int goH = "consumer".hashCode();
    private static final int goI = "share_time".hashCode();
    private static final int goJ = "local_updateTime".hashCode();
    private static final int goK = "begin_time".hashCode();
    private static final int goL = "end_time".hashCode();
    private static final int goM = "block_mask".hashCode();
    private static final int goN = "dataInfoData".hashCode();
    private static final int goO = "cardTpInfoData".hashCode();
    private static final int goP = "shareInfoData".hashCode();
    private static final int goQ = "shopInfoData".hashCode();
    private static final int goR = "categoryType".hashCode();
    private static final int goS = "itemIndex".hashCode();
    private boolean fMW = true;
    private boolean fPn = true;
    private boolean fTR = true;
    private boolean fTS = true;
    private boolean fYV = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gbm = true;
    private boolean goA = true;
    private boolean goB = true;
    private boolean goC = true;
    private boolean goD = true;
    private boolean goE = true;
    private boolean goF = true;
    private boolean got = true;
    private boolean gou = true;
    private boolean gov = true;
    private boolean gow = true;
    private boolean gox = true;
    private boolean goy = true;
    private boolean goz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fTR = true;
                } else if (fUl == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (goG == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (goH == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (fZu == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (goI == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (goJ == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (goK == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (goL == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (gbA == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (goM == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (goN == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (goO == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (goP == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (goQ == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (goR == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (goS == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fTR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fTS) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.got) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.gou) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.fYV) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gov) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.gow) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gox) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.goy) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.gbm) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.goz) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
        }
        if (this.goA) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.goB) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.goC) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.goD) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.goE) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.goF) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

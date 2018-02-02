package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dm extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fUh = "card_type".hashCode();
    private static final int fUk = "card_id".hashCode();
    private static final int fUl = "card_tp_id".hashCode();
    private static final int gbA = "updateSeq".hashCode();
    private static final int goG = "from_username".hashCode();
    private static final int goJ = "local_updateTime".hashCode();
    private static final int goK = "begin_time".hashCode();
    private static final int goL = "end_time".hashCode();
    private static final int goM = "block_mask".hashCode();
    private static final int goN = "dataInfoData".hashCode();
    private static final int goO = "cardTpInfoData".hashCode();
    private static final int goP = "shareInfoData".hashCode();
    private static final int goQ = "shopInfoData".hashCode();
    private static final int gqU = "delete_state_flag".hashCode();
    private static final int gqV = "create_time".hashCode();
    private static final int gqW = "stickyIndex".hashCode();
    private static final int gqX = "stickyEndTime".hashCode();
    private static final int gqY = "stickyAnnouncement".hashCode();
    private static final int gqZ = "label_wording".hashCode();
    private static final int gra = "is_dynamic".hashCode();
    private boolean fMW = true;
    private boolean fPn = true;
    private boolean fTO = true;
    private boolean fTR = true;
    private boolean fTS = true;
    public long field_begin_time;
    public String field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public long field_create_time;
    public byte[] field_dataInfoData;
    public int field_delete_state_flag;
    public long field_end_time;
    public String field_from_username;
    public boolean field_is_dynamic;
    public String field_label_wording;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public byte[] field_shopInfoData;
    public int field_status;
    public String field_stickyAnnouncement;
    public int field_stickyEndTime;
    public int field_stickyIndex;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gbm = true;
    private boolean goA = true;
    private boolean goB = true;
    private boolean goC = true;
    private boolean goD = true;
    private boolean got = true;
    private boolean gow = true;
    private boolean gox = true;
    private boolean goy = true;
    private boolean goz = true;
    private boolean gqN = true;
    private boolean gqO = true;
    private boolean gqP = true;
    private boolean gqQ = true;
    private boolean gqR = true;
    private boolean gqS = true;
    private boolean gqT = true;

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
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gqU == hashCode) {
                    this.field_delete_state_flag = cursor.getInt(i);
                } else if (goJ == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gbA == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (gqV == hashCode) {
                    this.field_create_time = cursor.getLong(i);
                } else if (goK == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (goL == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (goM == hashCode) {
                    this.field_block_mask = cursor.getString(i);
                } else if (goN == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (goO == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (goP == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (goQ == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (gqW == hashCode) {
                    this.field_stickyIndex = cursor.getInt(i);
                } else if (gqX == hashCode) {
                    this.field_stickyEndTime = cursor.getInt(i);
                } else if (gqY == hashCode) {
                    this.field_stickyAnnouncement = cursor.getString(i);
                } else if (fUh == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (gqZ == hashCode) {
                    this.field_label_wording = cursor.getString(i);
                } else if (gra == hashCode) {
                    this.field_is_dynamic = cursor.getInt(i) != 0;
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
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gqN) {
            contentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
        }
        if (this.gow) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gbm) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.gqO) {
            contentValues.put("create_time", Long.valueOf(this.field_create_time));
        }
        if (this.gox) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.goy) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.goz) {
            contentValues.put("block_mask", this.field_block_mask);
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
        if (this.gqP) {
            contentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
        }
        if (this.gqQ) {
            contentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
        }
        if (this.gqR) {
            contentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
        }
        if (this.fTO) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.gqS) {
            contentValues.put("label_wording", this.field_label_wording);
        }
        if (this.gqT) {
            contentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

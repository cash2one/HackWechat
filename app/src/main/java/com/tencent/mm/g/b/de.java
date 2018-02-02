package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable$Columns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class de extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int gax = "talker".hashCode();
    private static final int gem = "isRead".hashCode();
    private static final int gpF = "snsID".hashCode();
    private static final int gpG = "parentID".hashCode();
    private static final int gpH = "curActionBuf".hashCode();
    private static final int gpI = "refActionBuf".hashCode();
    private static final int gpJ = "commentSvrID".hashCode();
    private static final int gpK = ClientInfoTable$Columns.CLIENTID.hashCode();
    private static final int gpL = "commentflag".hashCode();
    private static final int gpM = "isSilence".hashCode();
    private boolean fNB = true;
    private boolean fNE = true;
    private boolean fRF = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;
    private boolean gah = true;
    private boolean ged = true;
    private boolean gpA = true;
    private boolean gpB = true;
    private boolean gpC = true;
    private boolean gpD = true;
    private boolean gpE = true;
    private boolean gpx = true;
    private boolean gpy = true;
    private boolean gpz = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpF == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (gpG == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (gem == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (gax == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (gpH == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (gpI == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (gpJ == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (gpK == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (gpL == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (gpM == hashCode) {
                    this.field_isSilence = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gpx) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.gpy) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.ged) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.fNB) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.gah) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fRF) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.gpz) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.gpA) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.gpB) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.gpC) {
            contentValues.put(ClientInfoTable$Columns.CLIENTID, this.field_clientId);
        }
        if (this.gpD) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.gpE) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

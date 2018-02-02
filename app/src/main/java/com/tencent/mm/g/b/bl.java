package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bl extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fNx = "rawXML".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fRU = "msgType".hashCode();
    private static final int gei = "mergerId".hashCode();
    private static final int gej = "gameMsgId".hashCode();
    private static final int gek = "expireTime".hashCode();
    private static final int gel = "showInMsgList".hashCode();
    private static final int gem = "isRead".hashCode();
    private static final int gen = "label".hashCode();
    private static final int geo = "isHidden".hashCode();
    private static final int gep = "weight".hashCode();
    private static final int geq = "receiveTime".hashCode();
    private boolean fMO = true;
    private boolean fNB = true;
    private boolean fNt = true;
    private boolean fOu = true;
    private boolean fRG = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public long field_receiveTime;
    public boolean field_showInMsgList;
    public String field_weight;
    private boolean gdZ = true;
    private boolean gea = true;
    private boolean geb = true;
    private boolean gec = true;
    private boolean ged = true;
    private boolean gee = true;
    private boolean gef = true;
    private boolean geg = true;
    private boolean geh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fMO = true;
                } else if (gei == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (gej == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (fRU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gek == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gel == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (gem == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (gen == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (geo == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (gep == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (fNx == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (geq == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gdZ) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.gea) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.fRG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.geb) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gec) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.ged) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.gee) {
            contentValues.put("label", this.field_label);
        }
        if (this.gef) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.geg) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fNt) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.geh) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bn extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fZq = "reserved1".hashCode();
    private static final int fZr = "reserved2".hashCode();
    private static final int fZs = "reserved3".hashCode();
    private static final int fZt = "reserved4".hashCode();
    private static final int geB = "originSvrId".hashCode();
    private static final int geC = "newMsgId".hashCode();
    private static final int geD = "fromUserName".hashCode();
    private static final int geE = "toUserName".hashCode();
    private static final int geF = "msgSource".hashCode();
    private static final int geG = "msgSeq".hashCode();
    private boolean fNB = true;
    private boolean fNJ = true;
    private boolean fRi = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    private boolean fYU = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;
    private boolean geA = true;
    private boolean gev = true;
    private boolean gew = true;
    private boolean gex = true;
    private boolean gey = true;
    private boolean gez = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (geB == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.gev = true;
                } else if (geC == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (geD == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (geE == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (geF == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (geG == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fZq == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (fZr == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (fZs == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (fZt == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gev) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.gew) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.gex) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.gey) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.gez) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.geA) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fYR) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fYS) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.fYT) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.fYU) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

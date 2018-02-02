package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class t extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fRI = "bizChatId".hashCode();
    private static final int fRJ = "brandUserName".hashCode();
    private static final int fRK = "unReadCount".hashCode();
    private static final int fRL = "newUnReadCount".hashCode();
    private static final int fRM = "lastMsgID".hashCode();
    private static final int fRN = "lastMsgTime".hashCode();
    private static final int fRO = "digest".hashCode();
    private static final int fRP = "digestUser".hashCode();
    private static final int fRQ = "atCount".hashCode();
    private static final int fRR = "editingMsg".hashCode();
    private static final int fRS = "chatType".hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int fRU = "msgType".hashCode();
    private static final int fRV = "msgCount".hashCode();
    private static final int fRk = "flag".hashCode();
    private boolean fMW = true;
    private boolean fNJ = true;
    private boolean fRA = true;
    private boolean fRB = true;
    private boolean fRC = true;
    private boolean fRD = true;
    private boolean fRE = true;
    private boolean fRF = true;
    private boolean fRG = true;
    private boolean fRH = true;
    private boolean fRi = true;
    private boolean fRu = true;
    private boolean fRv = true;
    private boolean fRw = true;
    private boolean fRx = true;
    private boolean fRy = true;
    private boolean fRz = true;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRI == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.fRu = true;
                } else if (fRJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fRK == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (fRL == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (fRM == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (fRN == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fRO == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (fRP == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (fRQ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (fRR == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (fRS == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (fRU == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (fRV == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fRu) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.fRv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fRw) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fRx) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.fRy) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.fRz) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fRA) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fRB) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fRC) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fRD) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fRE) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fRF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fRG) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.fRH) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.fRi) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

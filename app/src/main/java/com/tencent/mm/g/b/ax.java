package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ax extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int gaQ = "msgContent".hashCode();
    private static final int gaR = "svrId".hashCode();
    private static final int gaS = "chatroomName".hashCode();
    private static final int gax = "talker".hashCode();
    private static final int gay = "encryptTalker".hashCode();
    private boolean fNB = true;
    private boolean fNE = true;
    private boolean fRF = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;
    private boolean gaN = true;
    private boolean gaO = true;
    private boolean gaP = true;
    private boolean gah = true;
    private boolean gai = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaQ == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gax == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (gay == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (gaR == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gaS == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.gaN) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.fRF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.gah) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.gai) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.gaO) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.gaP) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

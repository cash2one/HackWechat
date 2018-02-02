package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    public static final String[] fMK = new String[0];
    private static final int fMP = "payMsgId".hashCode();
    private static final int fMQ = "insertmsg".hashCode();
    private static final int fMR = "chatroom".hashCode();
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private boolean fML = true;
    private boolean fMM = true;
    private boolean fMN = true;
    private boolean fMO = true;
    public String field_chatroom;
    public boolean field_insertmsg;
    public long field_msgId;
    public String field_payMsgId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMP == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.fML = true;
                } else if (fMQ == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (fMR == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fML) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.fMM) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.fMN) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

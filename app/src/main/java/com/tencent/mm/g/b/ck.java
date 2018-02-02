package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ck extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int glT = "reqkey".hashCode();
    private static final int glU = "ack_key".hashCode();
    private static final int glV = "receive_time".hashCode();
    private boolean fMW = true;
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;
    private boolean glQ = true;
    private boolean glR = true;
    private boolean glS = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glT == hashCode) {
                    this.field_reqkey = cursor.getString(i);
                    this.glQ = true;
                } else if (glU == hashCode) {
                    this.field_ack_key = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (glV == hashCode) {
                    this.field_receive_time = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.glQ) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.glR) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.glS) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class b extends c {
    public static final String[] fMK = new String[0];
    private static final int fMQ = "insertmsg".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fMX = "billNo".hashCode();
    private static final int fMY = "localMsgId".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private boolean fMM = true;
    private boolean fMU = true;
    private boolean fMV = true;
    private boolean fMW = true;
    public String field_billNo;
    public boolean field_insertmsg;
    public long field_localMsgId;
    public int field_status;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMX == hashCode) {
                    this.field_billNo = cursor.getString(i);
                    this.fMU = true;
                } else if (fMQ == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (fMY == hashCode) {
                    this.field_localMsgId = cursor.getLong(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMU) {
            contentValues.put("billNo", this.field_billNo);
        }
        if (this.fMM) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.fMV) {
            contentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

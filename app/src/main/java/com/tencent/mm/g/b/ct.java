package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ct extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int fXy = "transferId".hashCode();
    private static final int gmG = "locaMsgId".hashCode();
    private static final int gmH = "receiveStatus".hashCode();
    private boolean fRF = true;
    private boolean fXx = true;
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_transferId;
    private boolean gmE = true;
    private boolean gmF = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXy == hashCode) {
                    this.field_transferId = cursor.getString(i);
                    this.fXx = true;
                } else if (gmG == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i);
                } else if (gmH == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXx) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.gmE) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.gmF) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.fRF) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

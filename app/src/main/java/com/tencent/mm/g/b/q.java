package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class q extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRp = "deviceId".hashCode();
    private static final int fRq = "sessionName".hashCode();
    private static final int fRr = "moveTime".hashCode();
    private boolean fRm = true;
    private boolean fRn = true;
    private boolean fRo = true;
    public String field_deviceId;
    public em field_moveTime;
    public String field_sessionName;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRp == hashCode) {
                    this.field_deviceId = cursor.getString(i);
                } else if (fRq == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (fRr == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (em) new em().aF(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.fRm) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fRn) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.fRo && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

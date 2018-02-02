package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dc extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int gcI = DownloadInfo.FILENAME.hashCode();
    private static final int gpq = "cnValue".hashCode();
    private static final int gpr = "qqValue".hashCode();
    private static final int gps = "twValue".hashCode();
    private static final int gpt = "enValue".hashCode();
    private static final int gpu = "thValue".hashCode();
    private static final int gpv = "eggIndex".hashCode();
    private static final int gpw = "position".hashCode();
    private boolean fPc = true;
    private boolean fRi = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;
    private boolean gcp = true;
    private boolean gpj = true;
    private boolean gpk = true;
    private boolean gpl = true;
    private boolean gpm = true;
    private boolean gpn = true;
    private boolean gpo = true;
    private boolean gpp = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fPc = true;
                } else if (gpq == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (gpr == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (gps == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (gpt == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (gpu == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (gcI == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gpv == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (gpw == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gpj) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.gpk) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.gpl) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.gpm) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.gpn) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.gcp) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gpo) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.gpp) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

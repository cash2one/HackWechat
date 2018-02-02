package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class by extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int ggK = "phonenumber".hashCode();
    private static final int ggL = "calltime".hashCode();
    private static final int ggM = FFmpegMetadataRetriever.METADATA_KEY_DURATION.hashCode();
    private static final int ggN = "addressId".hashCode();
    private static final int ggO = "phoneType".hashCode();
    private boolean fMW = true;
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;
    private boolean ggF = true;
    private boolean ggG = true;
    private boolean ggH = true;
    private boolean ggI = true;
    private boolean ggJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggK == hashCode) {
                    this.field_phonenumber = cursor.getString(i);
                } else if (ggL == hashCode) {
                    this.field_calltime = cursor.getLong(i);
                } else if (ggM == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggN == hashCode) {
                    this.field_addressId = cursor.getLong(i);
                } else if (ggO == hashCode) {
                    this.field_phoneType = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.ggF) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.ggG) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.ggH) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(this.field_duration));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ggI) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.ggJ) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

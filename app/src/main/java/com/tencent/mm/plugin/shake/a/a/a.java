package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class a extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fZO = "desc".hashCode();
    private static final int fZl = "svrid".hashCode();
    private static final int fZq = "reserved1".hashCode();
    private static final int fZr = "reserved2".hashCode();
    private static final int fZs = "reserved3".hashCode();
    private static final int gbQ = "subtype".hashCode();
    private static final int gce = "tag".hashCode();
    private static final int ggW = "createtime".hashCode();
    private static final int qnr = "thumburl".hashCode();
    private static final int qns = "reservedBuf".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fRb = true;
    private boolean fYM = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    private boolean fZK = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean gbO = true;
    private boolean gbU = true;
    private boolean ggR = true;
    private boolean qnp = true;
    private boolean qnq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZl == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.fYM = true;
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gbQ == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (ggW == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gce == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fZO == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (qnr == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (fZq == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (fZr == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (fZs == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (qns == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fYM) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gbO) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.ggR) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gbU) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fZK) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.qnp) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.fYR) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.fYS) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.fYT) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.qnq) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

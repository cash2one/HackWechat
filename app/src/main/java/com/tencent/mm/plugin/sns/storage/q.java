package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public final class q {
    long hVE;
    private int hvp;
    public int offset;
    public int roJ;
    private long rpn;
    public int rpo;
    public String rpp;
    private int rpq;
    private long rpr;
    public String rps;
    public byte[] rpt;
    public int type;
    private String userName;

    public final ContentValues byL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.rpn));
        contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.hVE));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.rpo));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.hvp));
        contentValues.put("tmp_path", this.rpp);
        contentValues.put("nums", Integer.valueOf(this.rpq));
        contentValues.put("try_times", Long.valueOf(this.rpr));
        contentValues.put("StrId", this.rps);
        contentValues.put("upload_buf", this.rpt);
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.roJ = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.rpn = j;
        this.rps = i.eq(j);
        this.type = cursor.getInt(2);
        this.hVE = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.rpo = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.hvp = cursor.getInt(7);
        this.rpp = cursor.getString(8);
        this.rpq = cursor.getInt(9);
        this.rpr = cursor.getLong(10);
        this.rps = cursor.getString(11);
        this.rpt = cursor.getBlob(12);
    }

    public final void byM() {
        this.hvp |= 4;
    }

    public final void byN() {
        this.hvp &= -5;
    }
}

package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class p {
    public String clientId = "";
    public String fDC = "";
    public int fDt = -1;
    public long fFo = 0;
    public String fileName = "";
    int gjE = 0;
    String gjF = "";
    int hEK = 0;
    public int hUp = 0;
    public int hVB = 0;
    public long hVE = 0;
    public long hVF = 0;
    public int hVI = 0;
    int hVJ = 0;
    public String hVz = "";
    int hWC = 0;
    String hWv = "";
    public int hXC = 0;
    long hXD = 0;
    int hXE = 0;
    public int hlp = 0;
    public int status = 0;

    public final boolean UG() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean UH() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("FileName", this.fileName);
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("User", this.fDC);
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.fFo));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.hUp));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.hVB));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.hlp));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.hVE));
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.hVF));
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.hXC));
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.hVI));
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("Human", this.hVz);
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hVJ));
        }
        if ((this.fDt & 16384) != 0) {
            contentValues.put("reserved2", this.hWv);
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("MsgSource", this.gjF);
        }
        if ((this.fDt & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.gjE));
        }
        if ((this.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.hEK));
        }
        if ((this.fDt & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.hXD));
        }
        if ((this.fDt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("checksum", Integer.valueOf(this.hXE));
        }
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.fDC = cursor.getString(1);
        this.fFo = cursor.getLong(2);
        this.hUp = cursor.getInt(3);
        this.hVB = cursor.getInt(4);
        this.hlp = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.hVE = cursor.getLong(7);
        this.hVF = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.hXC = cursor.getInt(10);
        this.hVI = cursor.getInt(11);
        this.hVz = cursor.getString(12);
        this.hVJ = cursor.getInt(13);
        this.hWv = cursor.getString(14);
        this.gjF = cursor.getString(15);
        this.gjE = cursor.getInt(16);
        this.hEK = cursor.getInt(17);
        this.hXD = cursor.getLong(18);
        this.hXE = cursor.getInt(19);
    }
}

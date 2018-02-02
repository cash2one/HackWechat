package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;

public abstract class bi extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fPB = "version".hashCode();
    private static final int gdN = "cgi".hashCode();
    private static final int gdO = "cmdid".hashCode();
    private static final int gdP = "functionmsgid".hashCode();
    private static final int gdQ = "preVersion".hashCode();
    private static final int gdR = "retryinterval".hashCode();
    private static final int gdS = "reportid".hashCode();
    private static final int gdT = "successkey".hashCode();
    private static final int gdU = "failkey".hashCode();
    private static final int gdV = "finalfailkey".hashCode();
    private static final int gdW = "custombuff".hashCode();
    private static final int gdX = "addMsg".hashCode();
    private static final int gdY = "needShow".hashCode();
    private boolean fMW = true;
    private boolean fPu = true;
    public bw field_addMsg;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;
    private boolean gdB = true;
    private boolean gdC = true;
    private boolean gdD = true;
    private boolean gdE = true;
    private boolean gdF = true;
    private boolean gdG = true;
    private boolean gdH = true;
    private boolean gdI = true;
    private boolean gdJ = true;
    private boolean gdK = true;
    private boolean gdL = true;
    private boolean gdM = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdN == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (gdO == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (gdP == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.gdD = true;
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (gdQ == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (gdR == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (gdS == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (gdT == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (gdU == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (gdV == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (gdW == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (gdX == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (bw) new bw().aF(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gdY == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gdB) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.gdC) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.gdD) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.fPu) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.gdE) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.gdF) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.gdG) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.gdH) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.gdI) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.gdJ) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.gdK) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.gdL && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gdM) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ca extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fOt = "ticket".hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fZl = "svrid".hashCode();
    private static final int gax = "talker".hashCode();
    private static final int ggW = "createtime".hashCode();
    private static final int ggX = "sayhiuser".hashCode();
    private static final int ggY = "sayhicontent".hashCode();
    private static final int ggZ = "imgpath".hashCode();
    private static final int gha = "sayhiencryptuser".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fNJ = true;
    private boolean fOq = true;
    private boolean fOr = true;
    private boolean fRF = true;
    private boolean fRi = true;
    private boolean fYM = true;
    public String field_content;
    public long field_createtime;
    public int field_flag;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiencryptuser;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public String field_ticket;
    public int field_type;
    private boolean gah = true;
    private boolean ggR = true;
    private boolean ggS = true;
    private boolean ggT = true;
    private boolean ggU = true;
    private boolean ggV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZl == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.fYM = true;
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ggW == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gax == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ggX == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (ggY == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (ggZ == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gha == hashCode) {
                    this.field_sayhiencryptuser = cursor.getString(i);
                } else if (fOt == hashCode) {
                    this.field_ticket = cursor.getString(i);
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
        if (this.fYM) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.ggR) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gah) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.ggS) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.ggT) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.ggU) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.fRF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.ggV) {
            contentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
        }
        if (this.fOr) {
            contentValues.put("ticket", this.field_ticket);
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

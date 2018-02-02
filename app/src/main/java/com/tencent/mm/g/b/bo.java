package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bo extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fTI = "nickname".hashCode();
    private static final int geU = "googleid".hashCode();
    private static final int geV = "googlename".hashCode();
    private static final int geW = "googlephotourl".hashCode();
    private static final int geX = "googlegmail".hashCode();
    private static final int geY = "nicknameqp".hashCode();
    private static final int geZ = "usernamepy".hashCode();
    private static final int gfa = "small_url".hashCode();
    private static final int gfb = "big_url".hashCode();
    private static final int gfc = "ret".hashCode();
    private static final int gfd = "googleitemid".hashCode();
    private static final int gfe = "googlecgistatus".hashCode();
    private static final int gff = "contecttype".hashCode();
    private static final int gfg = "googlenamepy".hashCode();
    private boolean fMW = true;
    private boolean fPs = true;
    private boolean fTE = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;
    private boolean geH = true;
    private boolean geI = true;
    private boolean geJ = true;
    private boolean geK = true;
    private boolean geL = true;
    private boolean geM = true;
    private boolean geN = true;
    private boolean geO = true;
    private boolean geP = true;
    private boolean geQ = true;
    private boolean geR = true;
    private boolean geS = true;
    private boolean geT = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (geU == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (geV == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (geW == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (geX == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fTI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (geY == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (geZ == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (gfa == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (gfb == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (gfc == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gfd == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.geQ = true;
                } else if (gfe == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (gff == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (gfg == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.geH) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.geI) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.geJ) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.geK) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fTE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.geL) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.geM) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.geN) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.geO) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.geP) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.geQ) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.geR) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.geS) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.geT) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

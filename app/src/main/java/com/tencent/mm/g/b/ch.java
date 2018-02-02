package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ch extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int gjW = "wxGroupId".hashCode();
    private static final int gka = "inviteUserName".hashCode();
    private static final int gke = "memberUuid".hashCode();
    private static final int gkf = "memberId".hashCode();
    private boolean fMW = true;
    private boolean fNB = true;
    private boolean fNz = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;
    private boolean gjQ = true;
    private boolean gjU = true;
    private boolean gkc = true;
    private boolean gkd = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gke == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (gjW == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (gka == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gkf == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gkc) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.gjQ) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gjU) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.gkd) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cg extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fZo = "state".hashCode();
    private static final int fZv = "groupId".hashCode();
    private static final int gjW = "wxGroupId".hashCode();
    private static final int gjX = "roomId".hashCode();
    private static final int gjY = "roomKey".hashCode();
    private static final int gjZ = "routeId".hashCode();
    private static final int gka = "inviteUserName".hashCode();
    private static final int gkb = "memberCount".hashCode();
    private boolean fNB = true;
    private boolean fYP = true;
    private boolean fYW = true;
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;
    private boolean gjQ = true;
    private boolean gjR = true;
    private boolean gjS = true;
    private boolean gjT = true;
    private boolean gjU = true;
    private boolean gjV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gjW == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.gjQ = true;
                } else if (fZv == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (gjX == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (gjY == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (gjZ == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (gka == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gkb == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fZo == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gjQ) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.fYW) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.gjR) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.gjS) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.gjT) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.gjU) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.gjV) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fYP) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fVi = "chatroomname".hashCode();
    private static final int fVj = "addtime".hashCode();
    private static final int fVk = "memberlist".hashCode();
    private static final int fVl = "displayname".hashCode();
    private static final int fVm = "chatroomnick".hashCode();
    private static final int fVn = "roomflag".hashCode();
    private static final int fVo = "roomowner".hashCode();
    private static final int fVp = "roomdata".hashCode();
    private static final int fVq = "isShowname".hashCode();
    private static final int fVr = "selfDisplayName".hashCode();
    private static final int fVs = "style".hashCode();
    private static final int fVt = "chatroomdataflag".hashCode();
    private static final int fVu = "modifytime".hashCode();
    private static final int fVv = "chatroomnotice".hashCode();
    private static final int fVw = "chatroomVersion".hashCode();
    private static final int fVx = "chatroomnoticeEditor".hashCode();
    private static final int fVy = "chatroomnoticePublishTime".hashCode();
    private static final int fVz = "chatroomLocalVersion".hashCode();
    private boolean fUQ = true;
    private boolean fUR = true;
    private boolean fUS = true;
    private boolean fUT = true;
    private boolean fUU = true;
    private boolean fUV = true;
    private boolean fUW = true;
    private boolean fUX = true;
    private boolean fUY = true;
    private boolean fUZ = true;
    private boolean fVa = true;
    private boolean fVb = true;
    private boolean fVc = true;
    private boolean fVd = true;
    private boolean fVe = true;
    private boolean fVf = true;
    private boolean fVg = true;
    private boolean fVh = true;
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVi == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.fUQ = true;
                } else if (fVj == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (fVk == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (fVl == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (fVm == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (fVn == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (fVo == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (fVp == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (fVq == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (fVr == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (fVs == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (fVt == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (fVu == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (fVv == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (fVw == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (fVx == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (fVy == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (fVz == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.fUQ) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.fUR) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.fUS) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.fUT) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.fUU) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.fUV) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.fUW) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.fUX) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.fUY) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.fUZ) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.fVa) {
            contentValues.put("style", Integer.valueOf(this.field_style));
        }
        if (this.fVb) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.fVc) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.fVd) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.fVe) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.fVf) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.fVg) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.fVh) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aq extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fYH = "lang".hashCode();
    private static final int fZN = "md5_lang".hashCode();
    private static final int fZO = "desc".hashCode();
    private static final int fZP = "click_flag".hashCode();
    private static final int fZQ = "download_flag".hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int fZv = "groupId".hashCode();
    private boolean fYL = true;
    private boolean fYW = true;
    private boolean fYh = true;
    private boolean fZJ = true;
    private boolean fZK = true;
    private boolean fZL = true;
    private boolean fZM = true;
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZN == hashCode) {
                    this.field_md5_lang = cursor.getString(i);
                    this.fZJ = true;
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (fYH == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (fZO == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (fZv == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (fZP == hashCode) {
                    this.field_click_flag = cursor.getInt(i);
                } else if (fZQ == hashCode) {
                    this.field_download_flag = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fZJ) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fYh) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.fZK) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.fYW) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fZL) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.fZM) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

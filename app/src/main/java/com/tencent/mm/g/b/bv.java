package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int ggr = "wechatUsername".hashCode();
    private static final int ggs = "systemAddressBookUsername".hashCode();
    private static final int ggt = "contactId".hashCode();
    private static final int ggu = "sortKey".hashCode();
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;
    private boolean ggn = true;
    private boolean ggo = true;
    private boolean ggp = true;
    private boolean ggq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggr == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (ggs == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (ggt == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (ggu == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.ggn) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.ggo) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.ggp) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.ggq) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

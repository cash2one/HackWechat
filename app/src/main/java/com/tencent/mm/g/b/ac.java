package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fUG = "lower_bound".hashCode();
    private static final int fUH = "need_insert_show_timestamp".hashCode();
    private static final int fUI = "show_timestamp_encrypt_key".hashCode();
    private static final int fUJ = "expire_time_interval".hashCode();
    private static final int fUK = "show_expire_interval".hashCode();
    private static final int fUL = "fetch_time".hashCode();
    private static final int fUk = "card_id".hashCode();
    private boolean fTR = true;
    private boolean fUA = true;
    private boolean fUB = true;
    private boolean fUC = true;
    private boolean fUD = true;
    private boolean fUE = true;
    private boolean fUF = true;
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fTR = true;
                } else if (fUG == hashCode) {
                    this.field_lower_bound = cursor.getInt(i);
                } else if (fUH == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i) != 0;
                } else if (fUI == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i);
                } else if (fUJ == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i);
                } else if (fUK == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i);
                } else if (fUL == hashCode) {
                    this.field_fetch_time = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fTR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fUA) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.fUB) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.fUC) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.fUD) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.fUE) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.fUF) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

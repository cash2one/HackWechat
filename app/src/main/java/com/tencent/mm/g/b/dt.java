package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gtk = "wallet_region".hashCode();
    private static final int gtl = "function_list".hashCode();
    private static final int gtm = "new_list".hashCode();
    private static final int gtn = "banner_list".hashCode();
    private static final int gto = "type_name_list".hashCode();
    public String field_banner_list;
    public String field_function_list;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;
    private boolean gtf = true;
    private boolean gtg = true;
    private boolean gth = true;
    private boolean gti = true;
    private boolean gtj = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtk == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.gtf = true;
                } else if (gtl == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (gtm == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (gtn == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (gto == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gtf) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.gtg) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.gth) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.gti) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.gtj) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

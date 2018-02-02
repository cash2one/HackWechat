package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gtA = "wallet_tpa_country_mask".hashCode();
    private static final int gtv = "wallet_tpa_country".hashCode();
    private static final int gtw = "wallet_type".hashCode();
    private static final int gtx = "wallet_name".hashCode();
    private static final int gty = "wallet_selected".hashCode();
    private static final int gtz = "wallet_balance".hashCode();
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;
    private boolean gtp = true;
    private boolean gtq = true;
    private boolean gtr = true;
    private boolean gts = true;
    private boolean gtt = true;
    private boolean gtu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtv == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.gtp = true;
                } else if (gtw == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (gtx == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (gty == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (gtz == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (gtA == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gtp) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.gtq) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.gtr) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.gts) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.gtt) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.gtu) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

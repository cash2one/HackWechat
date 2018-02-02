package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class an extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPh = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fXI = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int fXJ = "cacheKey".hashCode();
    private static final int fXK = "interval".hashCode();
    private boolean fOu = true;
    private boolean fPe = true;
    private boolean fPn = true;
    private boolean fXF = true;
    private boolean fXG = true;
    private boolean fXH = true;
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXI == hashCode) {
                    this.field_id = cursor.getString(i);
                } else if (fXJ == hashCode) {
                    this.field_cacheKey = cursor.getString(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPh == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (fXK == hashCode) {
                    this.field_interval = cursor.getInt(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXF) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, this.field_id);
        }
        if (this.fXG) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPe) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.fXH) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

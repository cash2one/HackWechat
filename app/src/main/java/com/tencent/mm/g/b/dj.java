package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;

public abstract class dj extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fXI = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gck = "timestamp".hashCode();
    private static final int ggg = "step".hashCode();
    private static final int gqC = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    private boolean fXF = true;
    public String field_date;
    public int field_id;
    public int field_step;
    public long field_timestamp;
    private boolean gca = true;
    private boolean ggf = true;
    private boolean gqB = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXI == hashCode) {
                    this.field_id = cursor.getInt(i);
                    this.fXF = true;
                } else if (gqC == hashCode) {
                    this.field_date = cursor.getString(i);
                } else if (ggg == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (gck == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXF) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.gqB) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.ggf) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.gca) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

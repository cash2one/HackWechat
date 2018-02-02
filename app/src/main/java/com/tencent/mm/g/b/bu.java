package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bu extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int gga = "rankID".hashCode();
    private static final int ggb = "appusername".hashCode();
    private static final int gge = "score".hashCode();
    private static final int ggk = "ranknum".hashCode();
    private static final int ggl = "likecount".hashCode();
    private static final int ggm = "selfLikeState".hashCode();
    private boolean fPs = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;
    private boolean gfX = true;
    private boolean gfY = true;
    private boolean ggd = true;
    private boolean ggh = true;
    private boolean ggi = true;
    private boolean ggj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gga == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (ggb == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ggk == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (gge == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (ggl == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (ggm == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gfX) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.gfY) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.ggh) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.ggd) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.ggi) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.ggj) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

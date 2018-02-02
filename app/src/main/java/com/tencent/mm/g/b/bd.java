package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class bd extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gcb = "featureId".hashCode();
    private static final int gcc = "titlePY".hashCode();
    private static final int gcd = "titleShortPY".hashCode();
    private static final int gce = "tag".hashCode();
    private static final int gcf = "actionType".hashCode();
    private static final int gcg = "helpUrl".hashCode();
    private static final int gch = "updateUrl".hashCode();
    private static final int gci = "androidUrl".hashCode();
    private static final int gcj = "iconPath".hashCode();
    private static final int gck = "timestamp".hashCode();
    private boolean fRb = true;
    private boolean fTW = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;
    private boolean gbR = true;
    private boolean gbS = true;
    private boolean gbT = true;
    private boolean gbU = true;
    private boolean gbV = true;
    private boolean gbW = true;
    private boolean gbX = true;
    private boolean gbY = true;
    private boolean gbZ = true;
    private boolean gca = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcb == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.gbR = true;
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gcc == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (gcd == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (gce == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gcg == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (gch == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (gci == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (gcj == hashCode) {
                    this.field_iconPath = cursor.getString(i);
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
        if (this.gbR) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.gbS) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.gbT) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.gbU) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.gbV) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gbW) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.gbX) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.gbY) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.gbZ) {
            contentValues.put("iconPath", this.field_iconPath);
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

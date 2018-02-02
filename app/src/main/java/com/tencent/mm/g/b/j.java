package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fPo = "recordId".hashCode();
    private static final int fPp = "brandId".hashCode();
    private static final int fPq = "versionType".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private boolean fOq = true;
    private boolean fPk = true;
    private boolean fPl = true;
    private boolean fPm = true;
    private boolean fPn = true;
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public long field_updateTime;
    public int field_versionType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPo == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.fPk = true;
                } else if (fPp == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (fPq == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPk) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.fPl) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.fPm) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

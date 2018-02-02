package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class cl extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fQl = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int glZ = "sceneFlag".hashCode();
    private static final int gma = "msgTypeFlag".hashCode();
    private static final int gmb = "msgState".hashCode();
    private boolean fMW = true;
    private boolean fOu = true;
    private boolean fPO = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;
    private boolean glW = true;
    private boolean glX = true;
    private boolean glY = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.fOu = true;
                } else if (fQl == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (glZ == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (gma == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (gmb == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPO) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.glW) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.glX) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.glY) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

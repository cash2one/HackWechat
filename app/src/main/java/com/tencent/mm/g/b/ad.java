package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public abstract class ad extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fUO = "code_id".hashCode();
    private static final int fUP = TMQQDownloaderOpenSDKConst.UINTYPE_CODE.hashCode();
    private static final int fUk = "card_id".hashCode();
    private boolean fMW = true;
    private boolean fTR = true;
    private boolean fUM = true;
    private boolean fUN = true;
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUO == hashCode) {
                    this.field_code_id = cursor.getString(i);
                } else if (fUk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (fUP == hashCode) {
                    this.field_code = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fUM) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.fTR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fUN) {
            contentValues.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.field_code);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

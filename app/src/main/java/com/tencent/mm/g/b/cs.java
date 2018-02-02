package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;

public abstract class cs extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fZO = "desc".hashCode();
    private static final int gbF = "toUser".hashCode();
    private static final int gbj = "localId".hashCode();
    private static final int gmB = "oriMsgId".hashCode();
    private static final int gmC = "dataProto".hashCode();
    private static final int gmD = "favFrom".hashCode();
    private boolean fMO = true;
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fRb = true;
    private boolean fZK = true;
    public ve field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;
    private boolean gbh = true;
    private boolean gbr = true;
    private boolean gmA = true;
    private boolean gmy = true;
    private boolean gmz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbj == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gbh = true;
                } else if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (gmB == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i);
                } else if (gbF == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fZO == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gmC == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (ve) new ve().aF(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
                    }
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gmD == hashCode) {
                    this.field_favFrom = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gbh) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gmy) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.gbr) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fZK) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.gmz && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
            }
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gmA) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

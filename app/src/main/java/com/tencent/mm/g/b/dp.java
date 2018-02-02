package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dp extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOR = "offset".hashCode();
    private static final int fZq = "reserved1".hashCode();
    private static final int fZr = "reserved2".hashCode();
    private static final int ggW = "createtime".hashCode();
    private static final int grA = "nettimes".hashCode();
    private static final int grp = FFmpegMetadataRetriever.METADATA_KEY_FILENAME.hashCode();
    private static final int grq = "user".hashCode();
    private static final int grr = "msgid".hashCode();
    private static final int grs = "filenowsize".hashCode();
    private static final int grt = "totallen".hashCode();
    private static final int gru = "lastmodifytime".hashCode();
    private static final int grv = "clientid".hashCode();
    private static final int grw = "voicelenght".hashCode();
    private static final int grx = "msglocalid".hashCode();
    private static final int gry = "human".hashCode();
    private static final int grz = "voiceformat".hashCode();
    private boolean fMW = true;
    private boolean fOA = true;
    private boolean fYR = true;
    private boolean fYS = true;
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;
    private boolean ggR = true;
    private boolean grd = true;
    private boolean gre = true;
    private boolean grf = true;
    private boolean grg = true;
    private boolean grh = true;
    private boolean gri = true;
    private boolean grj = true;
    private boolean grk = true;
    private boolean grl = true;
    private boolean grm = true;
    private boolean grn = true;
    private boolean gro = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (grp == hashCode) {
                    this.field_filename = cursor.getString(i);
                } else if (grq == hashCode) {
                    this.field_user = cursor.getString(i);
                } else if (grr == hashCode) {
                    this.field_msgid = cursor.getLong(i);
                } else if (fOR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (grs == hashCode) {
                    this.field_filenowsize = cursor.getInt(i);
                } else if (grt == hashCode) {
                    this.field_totallen = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggW == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gru == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i);
                } else if (grv == hashCode) {
                    this.field_clientid = cursor.getString(i);
                } else if (grw == hashCode) {
                    this.field_voicelenght = cursor.getInt(i);
                } else if (grx == hashCode) {
                    this.field_msglocalid = cursor.getInt(i);
                } else if (gry == hashCode) {
                    this.field_human = cursor.getString(i);
                } else if (grz == hashCode) {
                    this.field_voiceformat = cursor.getInt(i);
                } else if (grA == hashCode) {
                    this.field_nettimes = cursor.getInt(i);
                } else if (fZq == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (fZr == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.grd) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, this.field_filename);
        }
        if (this.gre) {
            contentValues.put("user", this.field_user);
        }
        if (this.grf) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.fOA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.grg) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.grh) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ggR) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gri) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.grj) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.grk) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.grl) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.grm) {
            contentValues.put("human", this.field_human);
        }
        if (this.grn) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.gro) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.fYR) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fYS) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

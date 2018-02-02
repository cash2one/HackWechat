package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cj extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fTs = "extInfo".hashCode();
    private static final int glF = "tipId".hashCode();
    private static final int glG = "tipVersion".hashCode();
    private static final int glH = "tipkey".hashCode();
    private static final int glI = "tipType".hashCode();
    private static final int glJ = "isExit".hashCode();
    private static final int glK = "hadRead".hashCode();
    private static final int glL = "isReject".hashCode();
    private static final int glM = "beginShowTime".hashCode();
    private static final int glN = "disappearTime".hashCode();
    private static final int glO = "overdueTime".hashCode();
    private static final int glP = "tipsShowInfo".hashCode();
    private boolean fTe = true;
    public long field_beginShowTime;
    public long field_disappearTime;
    public String field_extInfo;
    public boolean field_hadRead;
    public boolean field_isExit;
    public boolean field_isReject;
    public long field_overdueTime;
    public int field_tipId;
    public int field_tipType;
    public int field_tipVersion;
    public String field_tipkey;
    public bnw field_tipsShowInfo;
    private boolean glA = true;
    private boolean glB = true;
    private boolean glC = true;
    private boolean glD = true;
    private boolean glE = true;
    private boolean glu = true;
    private boolean glv = true;
    private boolean glw = true;
    private boolean glx = true;
    private boolean gly = true;
    private boolean glz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glF == hashCode) {
                    this.field_tipId = cursor.getInt(i);
                    this.glu = true;
                } else if (glG == hashCode) {
                    this.field_tipVersion = cursor.getInt(i);
                } else if (glH == hashCode) {
                    this.field_tipkey = cursor.getString(i);
                } else if (glI == hashCode) {
                    this.field_tipType = cursor.getInt(i);
                } else if (glJ == hashCode) {
                    this.field_isExit = cursor.getInt(i) != 0;
                } else if (glK == hashCode) {
                    this.field_hadRead = cursor.getInt(i) != 0;
                } else if (glL == hashCode) {
                    this.field_isReject = cursor.getInt(i) != 0;
                } else if (glM == hashCode) {
                    this.field_beginShowTime = cursor.getLong(i);
                } else if (glN == hashCode) {
                    this.field_disappearTime = cursor.getLong(i);
                } else if (glO == hashCode) {
                    this.field_overdueTime = cursor.getLong(i);
                } else if (glP == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tipsShowInfo = (bnw) new bnw().aF(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
                    }
                } else if (fTs == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.glu) {
            contentValues.put("tipId", Integer.valueOf(this.field_tipId));
        }
        if (this.glv) {
            contentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
        }
        if (this.glw) {
            contentValues.put("tipkey", this.field_tipkey);
        }
        if (this.glx) {
            contentValues.put("tipType", Integer.valueOf(this.field_tipType));
        }
        if (this.gly) {
            contentValues.put("isExit", Boolean.valueOf(this.field_isExit));
        }
        if (this.glz) {
            contentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
        }
        if (this.glA) {
            contentValues.put("isReject", Boolean.valueOf(this.field_isReject));
        }
        if (this.glB) {
            contentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
        }
        if (this.glC) {
            contentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
        }
        if (this.glD) {
            contentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
        }
        if (this.glE && this.field_tipsShowInfo != null) {
            try {
                contentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
            }
        }
        if (this.fTe) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

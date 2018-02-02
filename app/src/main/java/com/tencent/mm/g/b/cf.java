package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class cf extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fRI = "bizChatId".hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int gax = "talker".hashCode();
    private static final int geG = "msgSeq".hashCode();
    private static final int gfI = "lvbuffer".hashCode();
    private static final int gjA = "transBrandWording".hashCode();
    private static final int gjB = "bizClientMsgId".hashCode();
    private static final int gjC = "bizChatUserId".hashCode();
    private static final int gju = "msgSvrId".hashCode();
    private static final int gjv = "isShowTimer".hashCode();
    private static final int gjw = "imgPath".hashCode();
    private static final int gjx = "reserved".hashCode();
    private static final int gjy = "talkerId".hashCode();
    private static final int gjz = "transContent".hashCode();
    private String fGG;
    private boolean fMO = false;
    private boolean fMW = false;
    private boolean fNB = false;
    private boolean fNE = false;
    private boolean fNJ = false;
    private boolean fRF = false;
    private boolean fRi = false;
    private boolean fRu = false;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    private int field_type;
    private boolean gah = false;
    private boolean geA = false;
    public boolean gfw = false;
    public String gjD;
    public int gjE;
    public String gjF;
    public int gjG;
    public int gjH;
    public int gjI;
    public int gjJ;
    public int gjK;
    public int gjL;
    public String gjM;
    public String gjN;
    public String gjO;
    public int gjP;
    private boolean gjl = false;
    public boolean gjm = false;
    private boolean gjn = false;
    private boolean gjo = false;
    public boolean gjp = false;
    private boolean gjq = false;
    private boolean gjr = false;
    private boolean gjs = false;
    public boolean gjt = false;

    public final void ao(long j) {
        this.field_msgId = j;
        this.fMO = true;
    }

    public final long vZ() {
        return this.field_msgId;
    }

    public final void ap(long j) {
        this.field_msgSvrId = j;
        this.gjl = true;
    }

    public final long wa() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.fNE = true;
    }

    public int getType() {
        return this.field_type;
    }

    public void eQ(int i) {
        this.field_status = i;
        this.fMW = true;
    }

    public final void eR(int i) {
        this.field_isSend = i;
        this.fRF = true;
    }

    public final int wb() {
        return this.field_isSend;
    }

    public final void aq(long j) {
        this.field_createTime = j;
        this.fNB = true;
    }

    public final long wc() {
        return this.field_createTime;
    }

    public final void dS(String str) {
        this.field_talker = str;
        this.gah = true;
    }

    public final String wd() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.fNJ = true;
    }

    public final String we() {
        return this.field_content;
    }

    public final void dT(String str) {
        this.field_imgPath = str;
        this.gjn = true;
    }

    public final void dU(String str) {
        this.field_reserved = str;
        this.gjo = true;
    }

    public final void A(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.gfw = true;
    }

    public final void dV(String str) {
        this.field_transContent = str;
        this.gjq = true;
    }

    public final void dW(String str) {
        this.field_bizClientMsgId = str;
        this.gjs = true;
    }

    public final void ar(long j) {
        this.field_bizChatId = j;
        this.fRu = true;
    }

    public final void as(long j) {
        this.field_msgSeq = j;
        this.geA = true;
    }

    public final void fa(int i) {
        this.field_flag = i;
        this.fRi = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fMO = true;
                } else if (gju == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gjv == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gax == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gjw == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (gjx == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (gfI == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (gjy == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (gjz == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (gjA == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (gjB == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (fRI == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (gjC == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (geG == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int br = uVar.br(this.field_lvbuffer);
                    if (br != 0) {
                        x.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + br);
                        return;
                    }
                    if (!uVar.ceW()) {
                        this.gjD = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gjE = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjF = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gjG = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjH = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjI = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjJ = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjK = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjL = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gjM = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gjN = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gjO = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gjP = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.fGG = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public ContentValues vI() {
        try {
            if (this.gfw) {
                u uVar = new u();
                uVar.ceX();
                uVar.UV(this.gjD);
                uVar.Dd(this.gjE);
                uVar.UV(this.gjF);
                uVar.Dd(this.gjG);
                uVar.Dd(this.gjH);
                uVar.Dd(this.gjI);
                uVar.Dd(this.gjJ);
                uVar.Dd(this.gjK);
                uVar.Dd(this.gjL);
                uVar.UV(this.gjM);
                uVar.UV(this.gjN);
                uVar.UV(this.gjO);
                uVar.Dd(this.gjP);
                uVar.UV(this.fGG);
                this.field_lvbuffer = uVar.ceY();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gjl) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fRF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.gjm) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gah) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gjn) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.gjo) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gfw) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.gjp) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.gjq) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.gjr) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.gjs) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.fRu) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.gjt) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.geA) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }

    public final void dX(String str) {
        this.gjD = str;
        this.gfw = true;
    }

    public final void fb(int i) {
        this.gjE = i;
        this.gfw = true;
    }

    public final void dY(String str) {
        this.gjF = str;
        this.gfw = true;
    }

    public final void fc(int i) {
        this.gjG = i;
        this.gfw = true;
    }

    public final void fd(int i) {
        this.gjH = i;
        this.gfw = true;
    }

    public final void fe(int i) {
        this.gjL = i;
        this.gfw = true;
    }

    public final void dZ(String str) {
        this.gjN = str;
        this.gfw = true;
    }

    public final void ea(String str) {
        this.gjO = str;
        this.gfw = true;
    }

    public final void ff(int i) {
        this.gjP = i;
        this.gfw = true;
    }
}

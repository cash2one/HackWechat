package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class aj extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fRK = "unReadCount".hashCode();
    private static final int fRO = "digest".hashCode();
    private static final int fRP = "digestUser".hashCode();
    private static final int fRQ = "atCount".hashCode();
    private static final int fRR = "editingMsg".hashCode();
    private static final int fRT = "isSend".hashCode();
    private static final int fRU = "msgType".hashCode();
    private static final int fRV = "msgCount".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fXk = "chatmode".hashCode();
    private static final int fXl = "conversationTime".hashCode();
    private static final int fXm = "customNotify".hashCode();
    private static final int fXn = "showTips".hashCode();
    private static final int fXo = "hasTrunc".hashCode();
    private static final int fXp = "parentRef".hashCode();
    private static final int fXq = "attrflag".hashCode();
    private static final int fXr = "sightTime".hashCode();
    private static final int fXs = "unReadMuteCount".hashCode();
    private static final int fXt = "lastSeq".hashCode();
    private static final int fXu = "UnDeliverCount".hashCode();
    private static final int fXv = "UnReadInvite".hashCode();
    private static final int fXw = "firstUnDeliverSeq".hashCode();
    private boolean fMW = false;
    private boolean fNJ = false;
    private boolean fPs = false;
    private boolean fRA = false;
    private boolean fRB = false;
    private boolean fRC = false;
    private boolean fRD = false;
    private boolean fRF = false;
    private boolean fRG = false;
    private boolean fRH = false;
    private boolean fRi = false;
    private boolean fRw = false;
    private boolean fWX = false;
    private boolean fWY = false;
    private boolean fWZ = false;
    public boolean fXa = false;
    private boolean fXb = false;
    private boolean fXc = false;
    private boolean fXd = false;
    public boolean fXe = false;
    private boolean fXf = false;
    private boolean fXg = false;
    private boolean fXh = false;
    private boolean fXi = false;
    private boolean fXj = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;

    public final void eN(int i) {
        this.field_msgCount = i;
        this.fRH = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.fPs = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void eO(int i) {
        this.field_unReadCount = i;
        this.fRw = true;
    }

    public final int vU() {
        return this.field_unReadCount;
    }

    public final void eP(int i) {
        this.field_chatmode = i;
        this.fWX = true;
    }

    public final void eQ(int i) {
        this.field_status = i;
        this.fMW = true;
    }

    public final void eR(int i) {
        this.field_isSend = i;
        this.fRF = true;
    }

    public final void aj(long j) {
        this.field_conversationTime = j;
        this.fWY = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.fNJ = true;
    }

    public final void dE(String str) {
        this.field_msgType = str;
        this.fRG = true;
    }

    public final void ak(long j) {
        this.field_flag = j;
        this.fRi = true;
    }

    public final void dF(String str) {
        this.field_digest = str;
        this.fRA = true;
    }

    public final void dG(String str) {
        this.field_digestUser = str;
        this.fRB = true;
    }

    public final void eS(int i) {
        this.field_hasTrunc = i;
        this.fXb = true;
    }

    public final void dH(String str) {
        this.field_parentRef = str;
        this.fXc = true;
    }

    public final void eT(int i) {
        this.field_attrflag = i;
        this.fXd = true;
    }

    public final void dI(String str) {
        this.field_editingMsg = str;
        this.fRD = true;
    }

    public final void eU(int i) {
        this.field_atCount = i;
        this.fRC = true;
    }

    public final void eV(int i) {
        this.field_unReadMuteCount = i;
        this.fXf = true;
    }

    public final int vV() {
        return this.field_unReadMuteCount;
    }

    public final void al(long j) {
        this.field_lastSeq = j;
        this.fXg = true;
    }

    public final long vW() {
        return this.field_lastSeq;
    }

    public final void eW(int i) {
        this.field_UnDeliverCount = i;
        this.fXh = true;
    }

    public final int vX() {
        return this.field_UnDeliverCount;
    }

    public final void eX(int i) {
        this.field_UnReadInvite = i;
        this.fXi = true;
    }

    public final void am(long j) {
        this.field_firstUnDeliverSeq = j;
        this.fXj = true;
    }

    public final long vY() {
        return this.field_firstUnDeliverSeq;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRV == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (fRK == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (fXk == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fRT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (fXl == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fRU == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (fXm == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (fXn == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fRO == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (fRP == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (fXo == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (fXp == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (fXq == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (fRR == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (fRQ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (fXr == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (fXs == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (fXt == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (fXu == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (fXv == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (fXw == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fRH) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fRw) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fWX) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fRF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fWY) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fRG) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.fWZ) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.fXa) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.fRi) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fRA) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fRB) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fXb) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.fXc) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.fXd) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.fRD) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fRC) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fXe) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.fXf) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.fXg) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.fXh) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.fXi) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.fXj) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}

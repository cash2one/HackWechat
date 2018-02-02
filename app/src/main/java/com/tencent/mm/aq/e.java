package com.tencent.mm.aq;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class e {
    int cOY;
    public int fDt = -2;
    public long fFo;
    int gjK = 0;
    public String hAa = "";
    int hAb = 1;
    private boolean hAc;
    private boolean hAd;
    private boolean hAe;
    private boolean hAf;
    private boolean hAg;
    private boolean hAh;
    private boolean hAi;
    private boolean hAj;
    private boolean hAk;
    private boolean hAl;
    private boolean hAm;
    private boolean hAn;
    boolean hAo;
    private boolean hAp;
    boolean hAq;
    private boolean hAr;
    private boolean hAs;
    private boolean hAt;
    private boolean hAu;
    public int hlp;
    public long hzP;
    public String hzQ = "";
    public String hzR = "";
    public String hzS = "";
    public int hzT;
    int hzU;
    private String hzV = "";
    int hzW;
    public long hzX;
    int hzY;
    public int hzZ = 0;
    public int offset;
    public int status;

    public final void lf(String str) {
        this.hzV = str;
        this.hAs = true;
    }

    public final void eQ(int i) {
        this.status = i;
        this.hAl = true;
    }

    public final void hJ(int i) {
        this.hzY = i;
        this.hAm = true;
    }

    public final void hK(int i) {
        this.hzW = i;
        this.hAj = true;
    }

    public final void bf(long j) {
        this.hzX = j;
        this.hAk = true;
    }

    public final void bg(long j) {
        this.hzP = j;
        this.hAc = true;
    }

    public final void ap(long j) {
        if (this.fFo != j) {
            this.hAd = true;
        }
        this.fFo = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        if (this.offset != i) {
            this.hAe = true;
        }
        this.offset = i;
        x.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.hzX), Integer.valueOf(this.hlp));
        if (i >= this.hlp) {
            i2 = 1;
        }
        hO(i2);
    }

    public final void hL(int i) {
        this.hlp = i;
        this.hAf = true;
    }

    public final void lg(String str) {
        this.hzQ = str;
        this.hAg = true;
    }

    public final void lh(String str) {
        this.hzR = str;
        this.hAh = true;
    }

    public final void li(String str) {
        this.hzS = str;
        this.hAi = true;
    }

    public final void hM(int i) {
        this.hzZ = i;
        this.hAn = true;
    }

    public final void hN(int i) {
        this.hzU = i;
        this.hAu = true;
    }

    public final boolean Pd() {
        return this.hlp != 0 && this.hlp == this.offset;
    }

    public final boolean Pe() {
        return this.hzZ > 0;
    }

    public final void lj(String str) {
        if ((this.hAa == null && str != null) || !(this.hAa == null || this.hAa.equals(str))) {
            this.hAp = true;
        }
        this.hAa = str;
    }

    public final void b(Cursor cursor) {
        this.hzP = (long) cursor.getInt(0);
        this.fFo = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.hlp = cursor.getInt(3);
        this.hzQ = cursor.getString(4);
        this.hzS = cursor.getString(5);
        this.hzW = cursor.getInt(6);
        this.hzX = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.hzY = cursor.getInt(9);
        this.hzZ = cursor.getInt(10);
        this.cOY = cursor.getInt(11);
        this.hAa = cursor.getString(12);
        this.gjK = cursor.getInt(14);
        this.hAb = cursor.getInt(15);
        this.hzV = cursor.getString(16);
        this.hzT = cursor.getInt(17);
        this.hzR = cursor.getString(18);
        this.hzU = cursor.getInt(19);
    }

    public final void hO(int i) {
        if (this.hAb != i) {
            this.hAr = true;
        }
        this.hAb = i;
    }

    public final void hP(int i) {
        this.hzT = i;
        this.hAt = true;
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.hAc) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Long.valueOf(this.hzP));
        }
        if (this.hAd) {
            contentValues.put("msgSvrId", Long.valueOf(this.fFo));
        }
        if (this.hAe) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.hAf) {
            contentValues.put("totalLen", Integer.valueOf(this.hlp));
        }
        if (this.hAg) {
            contentValues.put("bigImgPath", this.hzQ);
        }
        if (this.hAh) {
            contentValues.put("midImgPath", this.hzR);
        }
        if (this.hAi) {
            contentValues.put("thumbImgPath", this.hzS);
        }
        if (this.hAj) {
            contentValues.put("createtime", Integer.valueOf(this.hzW));
        }
        if (this.hAk) {
            contentValues.put("msglocalid", Long.valueOf(this.hzX));
        }
        if (this.hAl) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if (this.hAm) {
            contentValues.put("nettimes", Integer.valueOf(this.hzY));
        }
        if (this.hAn) {
            contentValues.put("reserved1", Integer.valueOf(this.hzZ));
        }
        if (this.hAo) {
            contentValues.put("reserved2", Integer.valueOf(this.cOY));
        }
        if (this.hAp) {
            contentValues.put("reserved3", this.hAa);
        }
        if (this.hAq) {
            contentValues.put("hashdthumb", Integer.valueOf(this.gjK));
        }
        if (this.hAr) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.hlp ? 0 : 1));
        }
        if (this.hAs) {
            contentValues.put("origImgMD5", this.hzV);
        }
        if (this.hAt) {
            contentValues.put("compressType", Integer.valueOf(this.hzT));
        }
        if (this.hAu) {
            contentValues.put("forwardType", Integer.valueOf(this.hzU));
        }
        return contentValues;
    }

    public final void Pf() {
        this.hAc = false;
        this.hAd = false;
        this.hAe = false;
        this.hAf = false;
        this.hAg = false;
        this.hAh = false;
        this.hAi = false;
        this.hAj = false;
        this.hAk = false;
        this.hAl = false;
        this.hAm = false;
        this.hAn = false;
        this.hAo = false;
        this.hAp = false;
        this.hAq = false;
        this.hAr = false;
        this.hAs = false;
        this.hAt = false;
        this.hAu = false;
    }
}

package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    String bgo = "";
    public int fDt = -1;
    String fWi = "";
    private String fqR = "";
    String gJo = "";
    public String hls = "";
    public int hlv = 0;
    int hvA = 0;
    String hvB = "";
    public String hvC = "";
    String hvD = "";
    int hvE = -1;
    String hvF = "";
    long hvG = -1;
    int hvH = -1;
    String hvI = "";
    String hvJ = "";
    String hvK = "";
    long hvL = 0;
    String hvi = "";
    long hvj = 0;
    String hvk = "";
    String hvl = "";
    String hvm = "";
    String hvn = "";
    String hvo = "";
    public int hvp = 0;
    public byte[] hvq;
    public int hvr;
    public String hvs = "";
    public int hvt = 0;
    public String hvu = "";
    public String hvv = "";
    public String hvw = "";
    int hvx = 0;
    public String hvy = "";
    int hvz = 0;
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        kQ(cursor.getString(1));
        this.hvi = cursor.getString(2);
        this.hvj = cursor.getLong(3);
        this.gJo = cursor.getString(4);
        this.hvk = cursor.getString(5);
        this.hvl = cursor.getString(6);
        this.username = cursor.getString(7);
        this.bgo = cursor.getString(8);
        this.hvm = cursor.getString(9);
        this.hvn = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.hvo = cursor.getString(12);
        this.fWi = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.hvp = cursor.getInt(17);
        this.hls = cursor.getString(15);
        this.hlv = cursor.getInt(18);
        this.hvq = cursor.getBlob(19);
        if (!bh.bw(this.hvq)) {
            byte[] bArr = this.hvq;
            try {
                u uVar = new u();
                i = uVar.br(bArr);
                if (i != 0) {
                    x.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
                } else {
                    this.hvs = uVar.getString();
                    this.hvt = uVar.getInt();
                    this.hvu = uVar.getString();
                    this.hvv = uVar.getString();
                    this.hvw = uVar.getString();
                    this.hvx = uVar.getInt();
                    this.hvy = uVar.getString();
                    this.hvz = uVar.getInt();
                    this.hvA = uVar.getInt();
                    this.hvB = uVar.getString();
                    this.hvC = uVar.getString();
                    this.hvD = uVar.getString();
                    this.hvE = uVar.getInt();
                    this.hvF = uVar.getString();
                    this.hvG = uVar.getLong();
                    this.hvH = uVar.getInt();
                    this.hvI = uVar.getString();
                    this.hvJ = uVar.getString();
                    this.hvK = uVar.getString();
                    this.hvL = uVar.getLong();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            }
        }
        this.hvr = cursor.getInt(20);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("md5", Nr());
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("peopleid", Ns());
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.hvj));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("realname", Nt());
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("realnamepyinitial", Nu());
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("realnamequanpin", Nv());
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("nickname", Nw());
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamepyinitial", Nx());
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamequanpin", Ny());
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.type));
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("moblie", Nz());
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("email", NA());
        }
        if ((this.fDt & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(65536));
            } else {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(i));
            }
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved1", this.hls);
        }
        if ((this.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hvp));
        }
        if ((this.fDt & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        if ((this.fDt & SQLiteGlobal.journalSizeLimit) != 0) {
            this.hvq = Nq();
            contentValues.put("lvbuf", this.hvq);
        }
        if ((this.fDt & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.hvr));
        }
        return contentValues;
    }

    private byte[] Nq() {
        try {
            u uVar = new u();
            uVar.ceX();
            uVar.UV(this.hvs);
            uVar.Dd(this.hvt);
            uVar.UV(this.hvu);
            uVar.UV(this.hvv);
            uVar.UV(this.hvw);
            uVar.Dd(this.hvx);
            uVar.UV(this.hvy);
            uVar.Dd(this.hvz);
            uVar.Dd(this.hvA);
            uVar.UV(this.hvB);
            uVar.UV(this.hvC);
            uVar.UV(this.hvD);
            uVar.Dd(this.hvE);
            uVar.UV(this.hvF);
            uVar.fF(this.hvG);
            uVar.Dd(this.hvH);
            uVar.UV(this.hvI);
            uVar.UV(this.hvJ);
            uVar.UV(this.hvK);
            uVar.fF(this.hvL);
            return uVar.ceY();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            return null;
        }
    }

    public static int kP(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str.substring(0, 8), 16);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", new Object[]{str});
        }
        return (int) j;
    }

    public final void kQ(String str) {
        this.fqR = str;
        this.id = kP(str);
    }

    public final String Nr() {
        return this.fqR == null ? "" : this.fqR;
    }

    public final String Ns() {
        return this.hvi == null ? "" : this.hvi;
    }

    public final String Nt() {
        return this.gJo == null ? "" : this.gJo;
    }

    public final String Nu() {
        return this.hvk == null ? "" : this.hvk;
    }

    public final String Nv() {
        return this.hvl == null ? "" : this.hvl;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Nw() {
        return this.bgo == null ? "" : this.bgo;
    }

    public final String Nx() {
        return this.hvm == null ? "" : this.hvm;
    }

    public final String Ny() {
        return this.hvn == null ? "" : this.hvn;
    }

    public final String Nz() {
        return this.hvo == null ? "" : this.hvo;
    }

    public final String NA() {
        return this.fWi == null ? "" : this.fWi;
    }

    public final void NB() {
        this.hvp |= 1;
    }

    public final boolean NC() {
        return (this.hvp & 1) == 0;
    }

    public final int Ad() {
        int i = 32;
        if (!bh.ov(Nu())) {
            i = Nu().charAt(0);
        } else if (!bh.ov(Nv())) {
            i = Nv().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }
}

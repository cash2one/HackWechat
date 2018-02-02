package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.ayc;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String fGJ;
    public String fIy;
    public String fpL;
    public int jir;
    public LinkedList<ayc> klN = new LinkedList();
    public int lOr;
    public String lOs;
    public int nDA;
    public int nDB;
    public int nDC;
    public int nDD;
    public String nDE;
    public int nDF;
    public int nDG;
    public int nDH;
    public int nDI;
    public boolean nDJ = false;
    public boolean nDK = false;
    public boolean nDL = false;
    public boolean nDM = true;
    public int nDN = 0;
    public int nDO;
    public int nDP;
    public int nDQ;
    public b nDR;
    public int nDS;
    public int nDT;
    public b nDU;
    public LinkedList<ayc> nDV = new LinkedList();
    public int nDW = 999;
    public LinkedList<d> nDX = new LinkedList();
    public String nDY;
    public String nDZ;
    public int nDx;
    public long nDy;
    public long nDz;
    public String nEa;
    public int nEb;
    public boolean nEc = false;

    public final int aTO() {
        if (this.nDX == null || this.nDX.size() <= 0) {
            return this.nDG;
        }
        return ((d) this.nDX.get(0)).nDG;
    }

    public final int aTP() {
        if (this.nDX == null || this.nDX.size() <= 0) {
            return this.jir;
        }
        return ((d) this.nDX.get(0)).gPs;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.nDx), Long.valueOf(this.nDy), Long.valueOf(this.nDz), Integer.valueOf(this.nDA), Integer.valueOf(this.nDF), Integer.valueOf(this.nDG), Integer.valueOf(this.nDH), Integer.valueOf(this.jir), this.lOs, Integer.valueOf(this.lOr), Integer.valueOf(this.nDD)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.fGJ, this.nDZ}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.klN.iterator();
        while (it.hasNext()) {
            ayc com_tencent_mm_protocal_c_ayc = (ayc) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{com_tencent_mm_protocal_c_ayc.wvP, Integer.valueOf(com_tencent_mm_protocal_c_ayc.wFo)}));
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        if (this.nDX == null || this.nDX.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.nDX.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}

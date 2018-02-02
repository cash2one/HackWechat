package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;

public final class h {
    long beginTime = 0;
    public int skR;
    public int skS;
    public int skT;
    public int skU;
    byte skV;
    byte skW;
    byte skX;
    byte skY;
    byte skZ;
    long slA;
    byte sla;
    byte slb;
    int slc;
    public int sld;
    public int sle;
    public int slf;
    public int slg;
    public int slh;
    public int sli;
    public int slj;
    int slk;
    int sll;
    int slm;
    int sln;
    int slo;
    int slp;
    int slq;
    int slr;
    public long sls;
    long slt;
    long slu;
    long slv;
    long slw;
    public long slx;
    long sly;
    long slz;

    public h() {
        reset();
        bGG();
    }

    public final void bGF() {
        if (this.slx == 0) {
            this.sln = 0;
        } else {
            this.sln = (int) (System.currentTimeMillis() - this.slx);
        }
        a.et("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        a.et("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.sln);
    }

    public final void reset() {
        this.beginTime = 0;
        this.skR = 0;
        this.skS = 0;
        this.skT = 0;
        this.skU = 0;
        this.skV = (byte) 0;
        this.skW = (byte) 0;
        this.skX = (byte) 0;
        this.skY = (byte) 0;
        this.skZ = (byte) 0;
        this.sla = (byte) 0;
        this.slb = (byte) 0;
        this.slc = 0;
    }

    public final void bGG() {
        this.sls = 0;
        this.slw = 0;
        this.slx = 0;
        this.sly = 0;
        this.slz = 0;
        this.slA = 0;
        this.slt = 0;
        this.slu = 0;
        this.slv = 0;
        this.sld = 0;
        this.sle = 0;
        this.slf = 0;
        this.slg = 0;
        this.slh = 0;
        this.sli = 0;
        this.slj = 0;
        this.slk = 0;
        this.sll = 0;
        this.slm = 0;
        this.sln = 0;
        this.slo = 0;
        this.slp = 0;
        this.slq = 0;
        this.slr = 0;
    }

    public final String bGH() {
        return "," + this.slb;
    }
}

package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.avf;

public final class f {
    public double bhC;
    public double bhD;
    public String hKZ;
    public String mName;
    public String nXA;
    public String nXB;
    public String nXC;
    public String nXD;
    public String nXE;
    public String nXF;
    public String nXG;
    public String nXH;
    public Addr nXI;
    public String nXJ;
    public int nXK = -1;
    public String nXy;
    public String nXz;
    public int type;

    public f(avf com_tencent_mm_protocal_c_avf, String str) {
        this.mName = com_tencent_mm_protocal_c_avf.nfp;
        this.nXy = com_tencent_mm_protocal_c_avf.wCR;
        this.bhD = com_tencent_mm_protocal_c_avf.vNO;
        this.bhC = com_tencent_mm_protocal_c_avf.vNP;
        this.nXz = com_tencent_mm_protocal_c_avf.wCS;
        this.nXA = com_tencent_mm_protocal_c_avf.oPA;
        this.nXB = com_tencent_mm_protocal_c_avf.wCT;
        this.nXC = com_tencent_mm_protocal_c_avf.hvu;
        this.nXD = com_tencent_mm_protocal_c_avf.hvv;
        this.nXE = com_tencent_mm_protocal_c_avf.vYy;
        this.nXF = com_tencent_mm_protocal_c_avf.vYz;
        this.nXG = com_tencent_mm_protocal_c_avf.wCU;
        this.nXJ = str;
        this.nXI = new Addr();
        this.nXI.hxu = this.nXy;
        this.nXI.hxw = this.nXD;
        this.nXI.hxx = this.nXD;
        this.nXI.hxy = this.nXE;
        this.nXI.hxA = this.nXG;
        this.nXI.hxD = this.mName;
        this.nXI.hxv = this.nXC;
        this.nXI.hxG = (float) com_tencent_mm_protocal_c_avf.vNO;
        this.nXI.hxF = (float) com_tencent_mm_protocal_c_avf.vNP;
        this.type = 0;
    }
}

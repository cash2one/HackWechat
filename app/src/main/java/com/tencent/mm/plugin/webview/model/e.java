package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public int trT;
    public int trU;
    public int trV;
    public final List<ano> trW;
    public int trX;
    public long trY;

    private e() {
        this.trT = 20480;
        this.trU = 30720;
        this.trV = 51200;
        this.trW = new LinkedList();
        this.trX = 0;
        this.trY = 0;
    }

    public static void co(List<ali> list) {
        if (!bh.cA(list)) {
            for (ali com_tencent_mm_protocal_c_ali : list) {
                f.bRD().trR.r(Integer.valueOf(com_tencent_mm_protocal_c_ali.wsx), Long.valueOf(bh.Wo() + ((long) com_tencent_mm_protocal_c_ali.wsy)));
            }
            f.bRD().bQz();
        }
    }
}

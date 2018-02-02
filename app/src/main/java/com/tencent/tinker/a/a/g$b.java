package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public class g$b implements Comparable<g$b> {
    public int AeM;
    public int AeN;
    public int AeO;

    public final /* synthetic */ int compareTo(Object obj) {
        g$b com_tencent_tinker_a_a_g_b = (g$b) obj;
        int fJ = c.fJ(this.AeM, com_tencent_tinker_a_a_g_b.AeM);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.AeN, com_tencent_tinker_a_a_g_b.AeN);
        return fJ == 0 ? c.fJ(this.AeO, com_tencent_tinker_a_a_g_b.AeO) : fJ;
    }

    public g$b(int i, int i2, int i3) {
        this.AeM = i;
        this.AeN = i2;
        this.AeO = i3;
    }
}

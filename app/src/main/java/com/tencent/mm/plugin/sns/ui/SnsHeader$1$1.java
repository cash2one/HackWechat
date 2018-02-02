package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsHeader.1;
import com.tencent.mm.ui.base.h.c;

class SnsHeader$1$1 implements c {
    final /* synthetic */ long rBM;
    final /* synthetic */ 1 rBN;

    SnsHeader$1$1(1 1, long j) {
        this.rBN = 1;
        this.rBM = j;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                if (!SnsHeader.g(this.rBN.rBL)) {
                    SnsHeader.a(this.rBN.rBL, this.rBM);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

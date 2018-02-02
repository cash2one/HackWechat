package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.task.c;

public final class g {
    int aIt;
    private int irA = 0;
    boolean irB;
    boolean irC;
    long[] irx;
    int iry;
    int irz;
    int mType;

    public final void o(int i, long j) {
        if (i == 0) {
            this.irx = new long[13];
            this.irA = c.akn() ? 1 : 0;
        }
        if (i < this.irx.length && this.irx[i] == 0) {
            this.irx[i] = j;
        }
    }

    final void e(String str, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[13];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.aIt);
        objArr[2] = Integer.valueOf(this.mType);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = "";
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.irx[i2]);
        objArr[7] = Integer.valueOf(this.iry);
        objArr[8] = Integer.valueOf(this.irA);
        objArr[9] = Integer.valueOf(this.irz);
        if (this.irB) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[10] = Integer.valueOf(i4);
        if (!this.irC) {
            i5 = 0;
        }
        objArr[11] = Integer.valueOf(i5);
        objArr[12] = Integer.valueOf(i3);
        gVar.h(13886, objArr);
    }
}

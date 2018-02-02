package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a$a {
    final /* synthetic */ i nQX;

    i$1(i iVar) {
        this.nQX = iVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (!(this.nQX.nQT == -1000.0d || this.nQX.nQU == -1000.0d)) {
            this.nQX.nQW = f.a(this.nQX.nQU, this.nQX.nQT, (double) f, (double) f2, i, d);
        }
        this.nQX.nQT = (double) f2;
        this.nQX.nQU = (double) f;
        if (this.nQX.nQS == 900.0d || this.nQX.nQR == 900.0d) {
            i iVar = this.nQX;
            i iVar2 = this.nQX;
            double i2 = f.i((double) f2, (double) f);
            iVar2.nQR = i2;
            iVar.nQS = i2;
        } else {
            this.nQX.nQS = this.nQX.nQR;
            this.nQX.nQR = f.i((double) f2, (double) f);
        }
        x.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[]{Double.valueOf(this.nQX.nQR), Double.valueOf(this.nQX.nQS), Boolean.valueOf(this.nQX.nQW)});
        return true;
    }
}

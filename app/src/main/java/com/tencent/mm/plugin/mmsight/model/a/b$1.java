package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ a otX;
    final /* synthetic */ b otY;

    b$1(b bVar, a aVar) {
        this.otY = bVar;
        this.otX = aVar;
    }

    public final void run() {
        b bVar = this.otY;
        x.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[]{Integer.valueOf(bVar.otR), Integer.valueOf(bVar.otS), Integer.valueOf(bVar.nUr), Integer.valueOf(bVar.mvv), Integer.valueOf(bVar.otP)});
        if (bVar.otT == 21 || bVar.otT == 2130706688) {
            SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.otM, bVar.otN, bVar.otR, bVar.otS, bVar.nUr, bVar.mvv, 1, bVar.fFy, bVar.otU, bVar.otW, bVar.otV);
        } else if (bVar.otT == 19) {
            SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.otM, bVar.otN, bVar.otR, bVar.otS, bVar.nUr, bVar.mvv, 2, bVar.fFy, bVar.otU, bVar.otW, bVar.otV);
        }
        x.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[]{Long.valueOf(bh.bA(bVar.otQ)), Integer.valueOf(bVar.otM.length), Integer.valueOf(bVar.otN.length), Integer.valueOf(bVar.otP)});
        this.otX.a(this.otY);
        j.ouM.D(this.otY.otM);
    }
}

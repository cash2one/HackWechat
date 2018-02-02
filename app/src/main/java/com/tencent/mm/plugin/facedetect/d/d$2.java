package com.tencent.mm.plugin.facedetect.d;

import android.os.CountDownTimer;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends CountDownTimer {
    final /* synthetic */ d mii;

    d$2(d dVar) {
        this.mii = dVar;
        super(Long.MAX_VALUE, 1000);
    }

    public final void onTick(long j) {
        x.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
        if (this.mii.kMn) {
            x.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
            cancel();
        } else if (this.mii.mhV) {
            x.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
        } else {
            x.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", new Object[]{Integer.valueOf(this.mii.mhQ), Integer.valueOf(this.mii.mhO[this.mii.mhP].length() - 1), Integer.valueOf(this.mii.mhP), Integer.valueOf(this.mii.mhO.length - 1)});
            if (this.mii.mhQ < this.mii.mhO[this.mii.mhP].length() - 1) {
                d dVar = this.mii;
                dVar.mhQ++;
                this.mii.mif.sendEmptyMessage(0);
                return;
            }
            x.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
            ag.h(this.mii.mih, 1500);
            this.mii.kMn = true;
            cancel();
            this.mii.kMn = true;
        }
    }

    public final void onFinish() {
        x.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
    }
}

package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.plugin.mmsight.segment.c$a;
import com.tencent.mm.plugin.mmsight.ui.a.10;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class a$7 implements c$a {
    final /* synthetic */ a oBU;

    a$7(a aVar) {
        this.oBU = aVar;
    }

    public final void gF(boolean z) {
        if (z) {
            x.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
            ag.y(new 1(this));
        } else if (this.oBU.oBC != null) {
            this.oBU.oBE = this.oBU.oBC.hOr;
            x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", new Object[]{Integer.valueOf(this.oBU.oBE)});
            try {
                if (this.oBU.oxz != null) {
                    this.oBU.oBF = Math.round(((float) this.oBU.oBE) * this.oBU.oBC.baZ());
                    this.oBU.oBG = Math.round(((float) this.oBU.oBE) * this.oBU.oBC.bba());
                    if (this.oBU.oBG <= 0) {
                        if (this.oBU.oBE <= 10500) {
                            this.oBU.oBG = this.oBU.oBE;
                        } else {
                            this.oBU.oBG = 10000;
                        }
                    }
                    x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", new Object[]{Integer.valueOf(this.oBU.oBF), Integer.valueOf(this.oBU.oBG), Integer.valueOf(this.oBU.oBE)});
                }
                a aVar = this.oBU;
                aVar.oBH = new ak(Looper.getMainLooper(), new 10(aVar), true);
                aVar.oBH.J(20, 20);
            } catch (Exception e) {
            }
        }
    }
}

package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$7 implements OnTouchListener {
    final /* synthetic */ k nUL;

    k$7(k kVar) {
        this.nUL = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nUL.nUA = true;
                this.nUL.nUv.setVisibility(0);
                this.nUL.nUu.reset();
                VolumeMeter volumeMeter = this.nUL.nUu;
                if (!volumeMeter.nVn) {
                    volumeMeter.huK = true;
                    volumeMeter.aWm();
                }
                this.nUL.nUt.setPressed(true);
                if (this.nUL.nUA) {
                    ar.b(ac.getContext(), R.l.eQT, new 1(this));
                    this.nUL.nUB = 1;
                    x.i("MicroMsg.TalkMgr", "micBtn pressed down");
                    this.nUL.nUD = bh.Wq();
                    this.nUL.nUH.bEP();
                    this.nUL.aVZ();
                    break;
                }
                break;
            case 1:
            case 3:
                this.nUL.nUt.setPressed(false);
                this.nUL.nUv.setVisibility(8);
                this.nUL.nUu.reset();
                this.nUL.nUu.huK = false;
                if (this.nUL.nUA) {
                    this.nUL.nUA = false;
                    if (this.nUL.nUB == 5) {
                        x.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                        this.nUL.nUE.TG();
                        this.nUL.nUF.TG();
                    }
                    this.nUL.nUB = 0;
                    this.nUL.nUJ.TG();
                    this.nUL.nUH.bEQ();
                    ar.H(ac.getContext(), R.l.eQV);
                    this.nUL.aVZ();
                    if (this.nUL.nUI != null) {
                        this.nUL.nUI.aVV();
                        break;
                    }
                }
                break;
            case 2:
                if (this.nUL.nUA) {
                    break;
                }
                break;
        }
        return false;
    }
}

package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements Runnable {
    final /* synthetic */ k pXV;

    k$2(k kVar) {
        this.pXV = kVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - k.a(this.pXV) > 30000) {
            x.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
            this.pXV.pXp.hG(true);
            this.pXV.jCQ.setVisibility(8);
            k.b(this.pXV).setText(R.l.eHF);
            k.b(this.pXV).setVisibility(0);
            if (k.c(this.pXV) == null) {
                k.a(this.pXV, new OnTouchListener(this) {
                    final /* synthetic */ k$2 pXW;

                    {
                        this.pXW = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.pXW.pXV.pXp.hG(false);
                        this.pXW.pXV.jCQ.setVisibility(0);
                        this.pXW.pXV.jCQ.setText(p.dV(p.qbh, this.pXW.pXV.pXp.getContext().getString(R.l.eHH)));
                        k.b(this.pXW.pXV).setVisibility(8);
                        k.a(this.pXW.pXV, System.currentTimeMillis());
                        return false;
                    }
                });
            }
            k.d(this.pXV).setOnTouchListener(k.c(this.pXV));
        }
    }
}

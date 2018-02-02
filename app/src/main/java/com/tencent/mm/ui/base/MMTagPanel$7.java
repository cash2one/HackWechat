package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMTagPanel.c;
import com.tencent.mm.ui.tools.h;

class MMTagPanel$7 implements OnTouchListener {
    final /* synthetic */ MMTagPanel ydR;
    final /* synthetic */ c ydS;

    MMTagPanel$7(MMTagPanel mMTagPanel, c cVar) {
        this.ydR = mMTagPanel;
        this.ydS = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (MMTagPanel.g(this.ydR)) {
            String cpC = this.ydR.cpC();
            if (!bh.ov(cpC)) {
                if (this.ydS != null && h.ZY(cpC) > this.ydS.ydY) {
                    int ZZ = this.ydS.ydY - h.ZZ(cpC);
                    if (ZZ <= cpC.length()) {
                        cpC = cpC.substring(0, ZZ);
                    }
                }
                this.ydR.bi(cpC, true);
                if (MMTagPanel.e(this.ydR) != null) {
                    MMTagPanel.e(this.ydR).yM(cpC);
                }
                this.ydR.cpD();
            }
        }
        return false;
    }
}

package com.tencent.mm.ui.chatting.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class u$13 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ u yAV;
    final /* synthetic */ long yBa;

    u$13(u uVar, int i, long j) {
        this.yAV = uVar;
        this.kI = i;
        this.yBa = j;
    }

    public final void run() {
        int firstVisiblePosition = this.kI - this.yAV.fhr.csx().getFirstVisiblePosition();
        View childAt = this.yAV.fhr.csx().getChildAt(firstVisiblePosition);
        View childAt2 = this.yAV.fhr.csx().getChildAt(firstVisiblePosition + this.yAV.fhr.csx().getHeaderViewsCount());
        ar.Hg();
        au dH = c.Fa().dH(this.yBa);
        View view = null;
        if (childAt != null) {
            if (dH.cje() || dH.cjh()) {
                view = childAt.findViewById(R.h.bTI);
            } else if (dH.cji()) {
                view = childAt.findViewById(R.h.image);
            } else if (dH.cjm()) {
                view = childAt.findViewById(R.h.bTo);
            }
            if (view == null && childAt2 != null) {
                if (dH.cje() || dH.cjh()) {
                    view = childAt2.findViewById(R.h.bTI);
                } else if (dH.cji()) {
                    view = childAt2.findViewById(R.h.image);
                }
            }
            if (view != null) {
                a.b(this.yAV.fhr.csq().getContext(), view);
            }
        }
    }
}

package com.tencent.mm.ui.fts.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.w.a.g;

class FTSEditTextView$6 implements OnClickListener {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$6(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final void onClick(View view) {
        int i = -1;
        if (view.getId() == g.gWr) {
            i = 0;
        } else if (view.getId() == g.gWs) {
            i = 1;
        } else if (view.getId() == g.gWt) {
            i = 2;
        }
        if (FTSEditTextView.h(this.zdZ) != null && i >= 0) {
            FTSEditTextView$a h = FTSEditTextView.h(this.zdZ);
            FTSEditTextView.b(this.zdZ).get(i);
            h.bqa();
        }
    }
}

package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ag.a.l;
import com.tencent.mm.z.ar;

class BizChatSearchUI$1 implements OnScrollListener {
    boolean kFO = false;
    final /* synthetic */ BizChatSearchUI ynV;

    BizChatSearchUI$1(BizChatSearchUI bizChatSearchUI) {
        this.ynV = bizChatSearchUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.kFO && BizChatSearchUI.a(this.ynV).yoj) {
            BizChatSearchUI$a a = BizChatSearchUI.a(this.ynV);
            if (a.cqL() && !a.yol) {
                a.yol = true;
                ar.CG().a(new l(a.kGH, a.ldh, a.yop), 0);
                a.cqN();
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            this.kFO = true;
        } else {
            this.kFO = false;
        }
    }
}

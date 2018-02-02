package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

class MainSightForwardContainerView$6 implements a {
    final /* synthetic */ MainSightForwardContainerView qwN;
    final /* synthetic */ List qwP;

    MainSightForwardContainerView$6(MainSightForwardContainerView mainSightForwardContainerView, List list) {
        this.qwN = mainSightForwardContainerView;
        this.qwP = list;
    }

    public final void onError(int i) {
        if (this.qwP.size() <= 1 || -1 == i) {
            h.bu(this.qwN.getContext(), this.qwN.getContext().getString(R.l.eKc));
        }
    }
}

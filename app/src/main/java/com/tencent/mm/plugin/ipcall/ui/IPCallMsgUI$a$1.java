package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;

class IPCallMsgUI$a$1 implements d {
    final /* synthetic */ a nKN;

    IPCallMsgUI$a$1(a aVar) {
        this.nKN = aVar;
    }

    public final void a(MMSlideDelView mMSlideDelView, boolean z) {
        if (z) {
            nKM.add(mMSlideDelView);
        } else {
            nKM.remove(mMSlideDelView);
        }
    }

    public final boolean aUx() {
        return nKM.size() > 0;
    }

    public final void aUy() {
        for (MMSlideDelView mMSlideDelView : nKM) {
            if (mMSlideDelView != null) {
                mMSlideDelView.cpB();
            }
        }
        nKM.clear();
    }

    public final void aUz() {
        for (MMSlideDelView mMSlideDelView : nKM) {
            if (mMSlideDelView != null) {
                mMSlideDelView.cpA();
            }
        }
        nKM.clear();
    }
}

package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMSlideDelView.d;

class MMSlideDelView$1 implements d {
    MMSlideDelView$1() {
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

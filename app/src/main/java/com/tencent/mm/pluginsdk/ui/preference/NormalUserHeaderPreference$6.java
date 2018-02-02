package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;

class NormalUserHeaderPreference$6 implements Runnable {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$6(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final void run() {
        int i = 0;
        NormalUserHeaderPreference.f(this.vtY);
        NormalUserHeaderPreference.g(this.vtY);
        NormalUserHeaderPreference.h(this.vtY);
        if (NormalUserHeaderPreference.i(this.vtY) != null) {
            boolean z;
            FMessageListView i2 = NormalUserHeaderPreference.i(this.vtY);
            if (a.fZ(NormalUserHeaderPreference.b(this.vtY).field_type)) {
                z = false;
            } else {
                z = true;
            }
            int childCount = i2.getChildCount();
            x.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
            if (childCount <= 2) {
                x.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + childCount);
                return;
            }
            if (i2.vtg != null) {
                i2.vtg.setVisibility(z ? 0 : 8);
            }
            if (i2.vth != null) {
                a aVar = i2.vth;
                if (!z) {
                    i = 8;
                }
                aVar.setVisibility(i);
            }
        }
    }
}

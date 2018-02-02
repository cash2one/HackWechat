package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;

class MMBaseSelectContactUI$4 implements OnScrollListener {
    final /* synthetic */ MMBaseSelectContactUI yTk;

    MMBaseSelectContactUI$4(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.yTk = mMBaseSelectContactUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            this.yTk.aWs();
            this.yTk.cwg();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!(this.yTk.WU() || MMBaseSelectContactUI.d(this.yTk) == null)) {
            View childAt = MMBaseSelectContactUI.e(this.yTk).getChildAt(MMBaseSelectContactUI.e(this.yTk).getFirstVisiblePosition());
            if (childAt == null || childAt.getTop() != 0) {
                MMBaseSelectContactUI.f(this.yTk).setVisibility(0);
            } else {
                MMBaseSelectContactUI.f(this.yTk).setVisibility(8);
            }
        }
        if (i >= 2) {
            g.Dk();
            if (!bh.c((Boolean) g.Dj().CU().get(12296, null))) {
                g.Dk();
                g.Dj().CU().set(12296, Boolean.valueOf(true));
                if (MMBaseSelectContactUI.g(this.yTk) != null) {
                    MMBaseSelectContactUI.g(this.yTk).dismiss();
                }
                MMBaseSelectContactUI.a(this.yTk, u.a(this.yTk, this.yTk.getString(h.qfG), 4000));
            }
        }
    }
}

package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class MMTagPanel$8 implements OnClickListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$8(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final void onClick(View view) {
        if (((Integer) view.getTag()).intValue() == 0) {
            this.ydR.a((TextView) view, true, false);
            if (MMTagPanel.e(this.ydR) != null) {
                view.post(new 1(this, view));
            }
        } else if (!MMTagPanel.f(this.ydR) || MMTagPanel.c(this.ydR)) {
            this.ydR.a((TextView) view, false, false);
            if (MMTagPanel.e(this.ydR) != null) {
                view.post(new 2(this, view));
            }
        } else if (MMTagPanel.d(this.ydR) == null) {
            MMTagPanel.a(this.ydR, MMTagPanel.a(this.ydR, ((TextView) view).getText().toString()));
            if (MMTagPanel.d(this.ydR) != null) {
                this.ydR.a(MMTagPanel.d(this.ydR).yed, false, true);
            }
        } else if (MMTagPanel.d(this.ydR).yed == view) {
            MMTagPanel.a(this.ydR, null);
            this.ydR.a((TextView) view, false, false);
            if (MMTagPanel.e(this.ydR) != null) {
                view.post(new 3(this, view));
            }
        } else {
            this.ydR.cpJ();
            MMTagPanel.a(this.ydR, MMTagPanel.a(this.ydR, ((TextView) view).getText().toString()));
            this.ydR.a(MMTagPanel.d(this.ydR).yed, false, true);
        }
    }
}

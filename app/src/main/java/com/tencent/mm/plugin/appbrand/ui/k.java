package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.appbrand.compat.n.a;
import com.tencent.mm.ui.MMActivity;

final class k {
    static void a(MMActivity mMActivity) {
        if (mMActivity != null && mMActivity.getSupportActionBar() != null) {
            mMActivity.cmS();
            View findViewById = mMActivity.getSupportActionBar().getCustomView().findViewById(a.bIV);
            if (findViewById != null && findViewById.getLayoutParams() != null && (findViewById.getLayoutParams() instanceof MarginLayoutParams)) {
                ((MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = 0;
                findViewById.requestLayout();
            }
        }
    }
}

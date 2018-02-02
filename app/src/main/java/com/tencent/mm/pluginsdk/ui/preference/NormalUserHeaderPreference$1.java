package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class NormalUserHeaderPreference$1 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$1(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        d.y(NormalUserHeaderPreference.a(this.vtY), "bottle", ".ui.BottlePersonalInfoUI");
    }
}

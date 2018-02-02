package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class NearLifeCreatePoiUI$3 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$3(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        this.oRe.findViewById(R.h.cTn).setVisibility(8);
        this.oRe.findViewById(R.h.cth).setVisibility(0);
        this.oRe.findViewById(R.h.ctj).setVisibility(0);
    }
}

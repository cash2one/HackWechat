package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.6;
import com.tencent.mm.plugin.location.ui.l.7;
import com.tencent.mm.ui.base.h;

class g$7 implements OnClickListener {
    final /* synthetic */ g nYb;

    g$7(g gVar) {
        this.nYb = gVar;
    }

    public final void onClick(View view) {
        l lVar = this.nYb.nXQ;
        h.a(lVar.mContext, lVar.mResources.getString(R.l.etm), "", lVar.mResources.getString(R.l.dEK), lVar.mResources.getString(R.l.dEn), new 6(lVar), new 7(lVar));
    }
}

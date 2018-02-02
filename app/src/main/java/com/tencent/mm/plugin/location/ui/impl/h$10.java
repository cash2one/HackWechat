package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class h$10 implements OnClickListener {
    final /* synthetic */ h nYk;

    h$10(h hVar) {
        this.nYk = hVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.TrackMapUI", "newpoi my position ", new Object[]{this.nYk.nXM});
        this.nYk.nXO.a(this.nYk.nVU.nTd);
    }
}

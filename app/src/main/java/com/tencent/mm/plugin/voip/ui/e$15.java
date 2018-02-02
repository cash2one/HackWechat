package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$15 implements OnClickListener {
    final /* synthetic */ e srL;

    e$15(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        e.d(this.srL);
    }
}

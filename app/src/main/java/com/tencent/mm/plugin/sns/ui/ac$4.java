package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.sns.ui.ac.3;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class ac$4 implements OnClickListener {
    final /* synthetic */ ac ruu;

    ac$4(ac acVar) {
        this.ruu = acVar;
    }

    public final void onClick(View view) {
        if (b.Qq()) {
            this.ruu.bzF();
            return;
        }
        ac acVar = this.ruu;
        if (acVar.rtF == null) {
            x.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
        } else {
            new af(acVar.fmM.getMainLooper()).post(new 3(acVar));
        }
    }
}

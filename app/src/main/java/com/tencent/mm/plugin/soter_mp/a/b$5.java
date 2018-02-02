package com.tencent.mm.plugin.soter_mp.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements OnClickListener {
    final /* synthetic */ b rTf;

    b$5(b bVar) {
        this.rTf = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
        this.rTf.mzB.nV(true);
        this.rTf.bCZ();
    }
}

package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.c.b;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter_mp.a.b.7;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a;

class b$4 implements b {
    final /* synthetic */ b rTf;

    b$4(b bVar) {
        this.rTf = bVar;
    }

    public final void aKB() {
        x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        this.rTf.rSW = true;
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), charSequence});
    }

    public final void aKC() {
        x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        this.rTf.rSW = false;
        this.rTf.mzB = null;
        b bVar = this.rTf;
        bVar.jCB.removeCallbacks(bVar.rTe);
        bVar.rSY.setImageResource(R.k.dyE);
        bVar.jCB.setTextColor(bVar.jCB.getResources().getColor(R.e.btT));
        bVar.jCB.setText(bVar.jCB.getResources().getString(R.l.eQb));
    }

    public final void onAuthenticationFailed() {
        x.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b bVar = this.rTf;
        CharSequence string = ac.getContext().getString(R.l.ePZ);
        if (bVar.rTc == null) {
            bVar.rTc = a.fA(bVar.rSY.getContext());
        }
        if (bVar.rTd == null) {
            bVar.rTd = a.fA(bVar.rSY.getContext());
        }
        bVar.rTc.setAnimationListener(new 7(bVar, string));
        bVar.jCB.startAnimation(bVar.rTc);
        bVar.rSY.startAnimation(bVar.rTd);
        ag.h(new 1(this), 500);
    }

    public final void aKD() {
        x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        this.rTf.mzB = null;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        x.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
    }
}

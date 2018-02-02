package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.x;

public class e$a implements Runnable {
    final /* synthetic */ e srL;

    public final void run() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
        this.srL.jKT.post(new 1(this, e.A(this.srL)));
    }
}

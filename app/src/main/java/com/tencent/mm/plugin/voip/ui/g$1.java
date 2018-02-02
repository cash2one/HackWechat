package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog.a;

class g$1 implements a {
    final /* synthetic */ a ssw;
    final /* synthetic */ g ssx;
    final /* synthetic */ Intent val$intent;

    g$1(g gVar, a aVar, Intent intent) {
        this.ssx = gVar;
        this.ssw = aVar;
        this.val$intent = intent;
    }

    public final void a(VoipWarningDialog voipWarningDialog) {
        voipWarningDialog.finish();
        if (this.ssw.aTc()) {
            g.a(this.ssx, this.val$intent);
        }
    }

    public final void b(VoipWarningDialog voipWarningDialog) {
        voipWarningDialog.finish();
    }
}

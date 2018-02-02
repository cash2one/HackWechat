package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.sdk.platformtools.x;

class SnsSightUploadSayFooter$5 implements ChatFooterPanel$a {
    final /* synthetic */ SnsSightUploadSayFooter rGD;

    SnsSightUploadSayFooter$5(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.rGD = snsSightUploadSayFooter;
    }

    public final void aXU() {
    }

    public final void gw(boolean z) {
    }

    public final void amZ() {
        SnsSightUploadSayFooter.b(this.rGD).ztO.sendKeyEvent(new KeyEvent(0, 67));
        SnsSightUploadSayFooter.b(this.rGD).ztO.sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            SnsSightUploadSayFooter.b(this.rGD).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
        }
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsUploadSayFooter$4 implements a {
    final /* synthetic */ SnsUploadSayFooter rLG;

    SnsUploadSayFooter$4(SnsUploadSayFooter snsUploadSayFooter) {
        this.rLG = snsUploadSayFooter;
    }

    public final void aXU() {
    }

    public final void gw(boolean z) {
    }

    public final void amZ() {
        SnsUploadSayFooter.c(this.rLG).ztO.sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(this.rLG).ztO.sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            SnsUploadSayFooter.c(this.rLG).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
        }
    }
}

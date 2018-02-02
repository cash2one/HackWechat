package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentFooter$5 implements a {
    final /* synthetic */ SnsCommentFooter rBl;

    SnsCommentFooter$5(SnsCommentFooter snsCommentFooter) {
        this.rBl = snsCommentFooter;
    }

    public final void aXU() {
    }

    public final void gw(boolean z) {
    }

    public final void amZ() {
        if (SnsCommentFooter.a(this.rBl) != null && SnsCommentFooter.a(this.rBl).ztO != null) {
            SnsCommentFooter.a(this.rBl).ztO.sendKeyEvent(new KeyEvent(0, 67));
            SnsCommentFooter.a(this.rBl).ztO.sendKeyEvent(new KeyEvent(1, 67));
        }
    }

    public final void append(String str) {
        try {
            SnsCommentFooter.a(this.rBl).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
        }
    }
}

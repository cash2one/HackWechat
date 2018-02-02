package com.tencent.mm.plugin.clean.ui.newui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class b$4 extends af {
    final /* synthetic */ b lhJ;

    b$4(b bVar) {
        this.lhJ = bVar;
    }

    public final void handleMessage(Message message) {
        if (!b.b(this.lhJ)) {
            this.lhJ.notifyDataSetChanged();
        }
    }
}

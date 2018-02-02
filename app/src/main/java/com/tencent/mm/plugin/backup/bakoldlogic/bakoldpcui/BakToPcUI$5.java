package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class BakToPcUI$5 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ BakToPcUI ksc;

    BakToPcUI$5(BakToPcUI bakToPcUI, int i) {
        this.ksc = bakToPcUI;
        this.fma = i;
    }

    public final void run() {
        x.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(this.fma)});
        if (this.fma == -1) {
            x.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
            Intent intent = new Intent();
            intent.putExtra("title", this.ksc.getString(R.l.dJe));
            intent.putExtra("rawUrl", this.ksc.getString(R.l.dIB, new Object[]{w.cfi()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(this.ksc, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        BakToPcUI.e(this.ksc);
    }
}

package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ alr tGA;
    final /* synthetic */ c tGB;
    final /* synthetic */ l tGz;

    c$1(c cVar, l lVar, int i, alr com_tencent_mm_protocal_c_alr) {
        this.tGB = cVar;
        this.tGz = lVar;
        this.fmb = i;
        this.tGA = com_tencent_mm_protocal_c_alr;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        this.tGB.a(this.tGz, this.fmb, this.tGA);
    }
}

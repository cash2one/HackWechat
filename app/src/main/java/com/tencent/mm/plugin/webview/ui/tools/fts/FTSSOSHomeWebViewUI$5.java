package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a.2;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import com.tencent.mm.sdk.platformtools.ag;

class FTSSOSHomeWebViewUI$5 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$5(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        c cVar = (c) view.getTag();
        if (cVar.type == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("history", cVar.content);
            try {
                FTSSOSHomeWebViewUI.y(this.tDo).h(5, bundle);
            } catch (RemoteException e) {
            }
            ag.y(new 2(FTSSOSHomeWebViewUI.z(this.tDo), cVar));
        } else if (cVar.type == 2) {
            FTSSOSHomeWebViewUI.z(this.tDo).clear();
            this.tDo.bTy().t(cVar.content, null);
            FTSSOSHomeWebViewUI.a(this.tDo, cVar, 2);
            FTSSOSHomeWebViewUI.e(this.tDo, 2);
            FTSSOSHomeWebViewUI.A(this.tDo);
        }
    }
}

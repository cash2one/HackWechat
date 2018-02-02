package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;

class FTSSOSHomeWebViewUI$6 implements OnItemClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$6(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c AS = FTSSOSHomeWebViewUI.z(this.tDo).AS(i);
        this.tDo.bTy().t(AS.content, null);
        if (AS.type == 2) {
            FTSSOSHomeWebViewUI.a(this.tDo, AS, 1);
            FTSSOSHomeWebViewUI.e(this.tDo, 1);
        }
        this.tDo.akL();
    }
}

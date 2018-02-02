package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$c extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b tDB;

    private FTSSOSHomeWebViewUI$b$c(FTSSOSHomeWebViewUI.b bVar) {
        this.tDB = bVar;
    }

    public final void enter() {
        super.enter();
        this.tDB.tDo.tCf.setPadding(FTSSOSHomeWebViewUI.M(this.tDB.tDo), 0, 0, 0);
        this.tDB.tDo.bTy().cxd();
        this.tDB.tDo.qgW.setVisibility(0);
        this.tDB.tDo.oNG.setVisibility(8);
        FTSSOSHomeWebViewUI.N(this.tDB.tDo).setVisibility(0);
        FTSSOSHomeWebViewUI.b(this.tDB.tDo).setVisibility(0);
        FTSSOSHomeWebViewUI.c(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.q(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.P(this.tDB.tDo).setVisibility(8);
        this.tDB.tDo.bTy().cxc();
        FTSSOSHomeWebViewUI.Q(this.tDB.tDo).setVisibility(0);
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 0:
                if (this.tDB.tDo.bTC().length() > 0) {
                    this.tDB.tDo.bTy().cxd();
                    this.tDB.tDo.bTy().yig.clearFocus();
                    FTSSOSHomeWebViewUI.z(this.tDB.tDo).clear();
                    this.tDB.b(this.tDB.tDz);
                    break;
                }
                break;
            case 2:
                if (!this.tDB.tDo.tCZ) {
                    FTSSOSHomeWebViewUI.T(this.tDB.tDo);
                    FTSSOSHomeWebViewUI.P(this.tDB.tDo).setVisibility(8);
                    FTSSOSHomeWebViewUI.d(this.tDB.tDo, 0);
                    FTSSOSHomeWebViewUI.U(this.tDB.tDo).AV(a.b.tEE);
                    FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEE);
                    break;
                }
                this.tDB.tDo.finish();
                break;
            case 5:
                if (this.tDB.tDo.bTy().yig.hasFocus()) {
                    this.tDB.b(this.tDB.tDy);
                    break;
                }
                break;
            case 9:
                this.tDB.b(this.tDB.tDx);
                break;
            case 10:
                if (this.tDB.tDo.bTC().length() > 0) {
                    this.tDB.b(this.tDB.tDz);
                    break;
                }
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchWithFocusNoResultState";
    }
}

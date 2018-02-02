package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$d extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b tDB;

    private FTSSOSHomeWebViewUI$b$d(FTSSOSHomeWebViewUI.b bVar) {
        this.tDB = bVar;
    }

    public final void enter() {
        super.enter();
        FTSSOSHomeWebViewUI.L(this.tDB.tDo).setVisibility(0);
        this.tDB.tDo.tCf.setPadding(0, 0, 0, 0);
        FTSSOSHomeWebViewUI.P(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.i(this.tDB.tDo);
        this.tDB.tDo.bTy().cxc();
        FTSSOSHomeWebViewUI.b(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.c(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.q(this.tDB.tDo).setVisibility(8);
        FTSSOSHomeWebViewUI.Q(this.tDB.tDo).setVisibility(0);
        if (!this.tDB.tDo.bTy().yig.hasFocus()) {
            this.tDB.tDo.bTy().cxa();
            this.tDB.tDo.showVKB();
        }
        if (d.fM(23) && !h.zj()) {
            FTSSOSHomeWebViewUI.i(this.tDB.tDo, this.tDB.tDo.getResources().getColor(R.e.white));
        }
        if (!TextUtils.isEmpty(this.tDB.tDo.bTE())) {
            this.tDB.tDo.bTy().zdP.setVisibility(0);
        }
    }

    public final void exit() {
        super.exit();
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 0:
            case 11:
                if (this.tDB.tDo.bTC().length() > 0) {
                    this.tDB.b(this.tDB.tDz);
                    break;
                }
                break;
            case 2:
                if (!this.tDB.tDo.tCZ) {
                    FTSSOSHomeWebViewUI.T(this.tDB.tDo);
                    FTSSOSHomeWebViewUI.P(this.tDB.tDo).setVisibility(8);
                    FTSSOSHomeWebViewUI.d(this.tDB.tDo, 0);
                    FTSSOSHomeWebViewUI.I(this.tDB.tDo).AV(a.b.tEE);
                    FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEE);
                    break;
                }
                this.tDB.tDo.finish();
                break;
            case 3:
            case 4:
                this.tDB.b(this.tDB.tDx);
                break;
            case 5:
                if (!this.tDB.tDo.bTy().yig.hasFocus()) {
                    this.tDB.b(this.tDB.tDA);
                    break;
                }
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchWithFocusState";
    }
}

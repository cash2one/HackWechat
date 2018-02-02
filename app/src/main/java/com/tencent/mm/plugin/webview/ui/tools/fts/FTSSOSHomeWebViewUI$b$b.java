package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$b extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b tDB;

    private FTSSOSHomeWebViewUI$b$b(FTSSOSHomeWebViewUI.b bVar) {
        this.tDB = bVar;
    }

    public final void enter() {
        super.enter();
        FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEF);
        this.tDB.tDo.tCf.setBackgroundResource(R.e.white);
        this.tDB.tDo.tCg.yig.clearFocus();
        this.tDB.tDo.tCG.setVisibility(0);
        this.tDB.tDo.tCf.setPadding(this.tDB.tDo.tCV, 0, 0, 0);
        this.tDB.tDo.bTy().cxd();
        this.tDB.tDo.qgW.setVisibility(0);
        this.tDB.tDo.oNG.setVisibility(8);
        this.tDB.tDo.tCR.setVisibility(0);
        this.tDB.tDo.tCH.clear();
        this.tDB.tDo.qlf.setVisibility(0);
        this.tDB.tDo.qcQ.setVisibility(8);
        this.tDB.tDo.tCM.setVisibility(8);
        if (!this.tDB.tDo.tCW) {
            this.tDB.tDo.tCO.setVisibility(0);
        }
        this.tDB.tDo.bTy().jCP.setVisibility(8);
        this.tDB.tDo.qvO.setVisibility(0);
        if (d.fM(23) && !h.zj()) {
            this.tDB.tDo.T(this.tDB.tDo.getResources().getColor(R.e.white), true);
        }
        this.tDB.tDo.titleView.setAlpha(0.0f);
        this.tDB.tDo.tCS.setVisibility(0);
        this.tDB.tDo.oNG.setAlpha(1.0f);
        this.tDB.tDo.tCf.setPadding(a.fromDPToPix(this.tDB.tDo.mController.xIM, 64) - ((int) this.tDB.tDo.mController.xIM.getResources().getDimension(R.f.byc)), 0, 0, 0);
        LayoutParams layoutParams = (LayoutParams) this.tDB.tDo.tCf.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (this.tDB.tDo.tCZ) {
            layoutParams.topMargin = 0;
        }
        layoutParams.width = -1;
        this.tDB.tDo.tCf.setLayoutParams(layoutParams);
        this.tDB.tDo.tCf.setY(0.0f);
        this.tDB.tDo.tCf.setX(0.0f);
        if (this.tDB.tDo.tCZ) {
            this.tDB.tDo.tCf.setTranslationX(0.0f);
            this.tDB.tDo.tCf.setTranslationY(0.0f);
        }
        if (this.tDB.tDo.tCZ && this.tDB.tDo.tDa) {
            this.tDB.tDo.tCf.setVisibility(8);
            this.tDB.tDo.titleView.setAlpha(1.0f);
            this.tDB.tDo.qlf.setVisibility(0);
            this.tDB.tDo.titleView.setVisibility(0);
            this.tDB.tDo.titleView.setText(R.l.eWt);
        }
    }

    public final void exit() {
        super.exit();
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 2:
                if (!this.tDB.tDo.tCZ) {
                    FTSSOSHomeWebViewUI.T(this.tDB.tDo);
                    this.tDB.tDo.tCO.setVisibility(8);
                    this.tDB.tDo.AQ(0);
                    this.tDB.tDo.tCI.AV(a.b.tEE);
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
                if (this.tDB.tDo.bTy().yig.hasFocus()) {
                    this.tDB.b(this.tDB.tDy);
                    break;
                }
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchNoFocusState";
    }
}

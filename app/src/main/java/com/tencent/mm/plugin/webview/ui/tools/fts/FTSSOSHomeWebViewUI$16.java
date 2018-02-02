package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.bc.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

class FTSSOSHomeWebViewUI$16 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$16(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        FTSSOSHomeWebViewUI.i(this.tDo);
        if (this.tDo.tCl) {
            FTSSOSHomeWebViewUI.a(this.tDo).Dh(1);
            String charSequence = ((TextView) view).getText().toString();
            int a = b.a((JSONObject) view.getTag(), charSequence, this.tDo);
            if (a != 0) {
                FTSSOSHomeWebViewUI.a(this.tDo, charSequence);
            } else {
                FTSSOSHomeWebViewUI.a(this.tDo, "");
            }
            if (!(this.tDo.tCA == a || this.tDo.bTy().rGZ.isEmpty())) {
                String bTC = this.tDo.bTC();
                this.tDo.bTy().clearText();
                this.tDo.bTy().t(bTC, null);
                this.tDo.bTy().cxd();
            }
            this.tDo.tCA = a;
            this.tDo.bTt();
            FTSSOSHomeWebViewUI.d(this.tDo, a);
            try {
                FTSSOSHomeWebViewUI.e(this.tDo, 0);
                Bundle bundle = new Bundle();
                bundle.putInt(DownloadSettingTable$Columns.TYPE, a);
                bundle.putBoolean("isHomePage", a == 0);
                if (this.tDo.aRr() != 20 || FTSSOSHomeWebViewUI.a(this.tDo).bTP()) {
                    this.tDo.tCz = this.tDo.aRr();
                    bundle.putInt("scene", this.tDo.aRr());
                } else if (a != 0) {
                    this.tDo.tCz = 22;
                    bundle.putInt("scene", 22);
                } else {
                    this.tDo.tCz = 20;
                    bundle.putInt("scene", 20);
                }
                FTSSOSHomeWebViewUI.n(this.tDo).post(new 1(this, a, FTSSOSHomeWebViewUI.j(this.tDo).o(4, bundle)));
            } catch (Exception e) {
            }
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.47;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.48;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

class WebViewUI$43 implements a {
    final /* synthetic */ WebViewUI tAv;
    final /* synthetic */ WebViewKeyboardLinearLayout tBo;

    WebViewUI$43(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout) {
        this.tAv = webViewUI;
        this.tBo = webViewKeyboardLinearLayout;
    }

    public final void qI(int i) {
        x.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + i);
        WebViewUI.a(this.tAv, this.tBo, i);
        if (i == -3) {
            int i2 = this.tBo.txF;
            if (i2 > 0) {
                this.tAv.bSy();
                WebViewUI.b(this.tAv, i2);
            }
            WebViewUI.c(this.tAv, i2);
            if (this.tAv.ptK.isX5Kernel || VERSION.SDK_INT >= 19) {
                WebViewUI.a(this.tAv).post(new 1(this, i2));
            }
            if (WebViewUI.at(this.tAv) != null && WebViewUI.at(this.tAv).getVisibility() == 0) {
                WebViewUI.at(this.tAv).bUV();
            }
        } else {
            WebViewUI.c(this.tAv, 0);
            WebViewUI.b(this.tAv, 0);
        }
        WebViewUI webViewUI = this.tAv;
        if (i == -3 && webViewUI.tyU != null) {
            boolean z;
            if ((webViewUI.juR.bSt().vAL & 1) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + z);
            if (!(!z || webViewUI.tyU.getVisibility() == 0 || webViewUI.tyA.isShown())) {
                if (webViewUI.tyV == null) {
                    webViewUI.tyV = new ak(Looper.getMainLooper(), new 47(webViewUI), false);
                }
                webViewUI.tyV.J(4000, 4000);
                View view = webViewUI.tyU;
                ((ImageView) view.findViewById(R.h.ctd)).setImageResource(R.k.dzs);
                TextView textView = (TextView) view.findViewById(R.h.cte);
                textView.setTextSize(14.0f);
                textView.setText(R.l.eXY);
                ((ImageButton) view.findViewById(R.h.ctc)).setOnClickListener(new 48(webViewUI));
                webViewUI.tyU.setVisibility(0);
                g.pQN.k(13125, webViewUI.bSL());
            }
        }
        this.tAv.tAu = i;
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$64 implements OnClickListener {
    final /* synthetic */ CheckBox smw;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$64(WebViewUI webViewUI, CheckBox checkBox) {
        this.tAv = webViewUI;
        this.smw = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.smw != null && this.smw.isChecked()) {
            try {
                if (this.tAv.juQ.aOD()) {
                    this.tAv.juQ.el(327792, 1);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
            }
        }
        this.tAv.tzO = true;
        WebViewUI.aS(this.tAv);
        g.tyi.close();
        this.tAv.finish();
    }
}

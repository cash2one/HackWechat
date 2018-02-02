package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.81;

class g$81$1 implements OnClickListener {
    final /* synthetic */ 81 tJh;

    g$81$1(81 81) {
        this.tJh = 81;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.y(g.i(this.tJh.tIj), "setting", ".ui.setting.SettingsAboutSystemUI");
        g.a(this.tJh.tIj, this.tJh.tIg, "nfcCheckState:nfc_wechat_setting_off", null);
    }
}

package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int tFb = 4;
    private int tFc = 5;
    final a tFd = new 1(this);
    final a tFe = new 2(this);

    protected final boolean BU(String str) {
        return true;
    }

    protected final void Pn(String str) {
        x.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[]{str});
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra("action");
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra("app_name") == null) {
                string = getString(R.l.dDO);
            } else {
                string = getString(R.l.dTZ, new Object[]{r1});
            }
            String string2 = getString(R.l.dUg);
            if (stringExtra.equals("action_create")) {
                e.a(this.mController, getString(R.l.dXL), string, string2, this.tFd, this.tFe);
            } else if (stringExtra.equals("action_join")) {
                e.a(this.mController, getString(R.l.esq), string, string2, this.tFd, this.tFe);
            }
        }
    }
}

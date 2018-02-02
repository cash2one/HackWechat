package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private int orJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.mZp = false;
        this.orJ = this.screenOrientation;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        x.d("MicroMsg.H5GameWebViewUI", "url = " + stringExtra);
        if (!this.tyD.equals(stringExtra)) {
            if (stringExtra.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
                this.tyD = stringExtra;
            }
            if (this.fIG.equals(stringExtra)) {
                this.screenOrientation = this.orJ;
                getIntent().putExtra("show_full_screen", booleanExtra);
                bSI();
                return;
            }
            this.fIG = stringExtra;
            this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
            this.tzd.mXT = this.fIG;
            if (this.juR == null) {
                this.juR = new e(this, this.ptK);
            } else {
                this.juR.b(stringExtra, null, null);
            }
            this.ptK.loadUrl("about:blank");
            super.j(this.fIG, false, -1);
        }
    }

    public void onResume() {
        afg();
        super.onResume();
    }

    protected final boolean bSB() {
        return false;
    }
}

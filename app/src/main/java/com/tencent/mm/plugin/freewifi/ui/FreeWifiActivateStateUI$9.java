package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateStateUI$9 implements Runnable {
    final /* synthetic */ FreeWifiActivateStateUI mGy;
    final /* synthetic */ c mGz;

    FreeWifiActivateStateUI$9(FreeWifiActivateStateUI freeWifiActivateStateUI, c cVar) {
        this.mGy = freeWifiActivateStateUI;
        this.mGz = cVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mGz.field_showUrl + "&lang=" + w.d(this.mGy.getSharedPreferences(ac.cfs(), 0)));
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        d.b(this.mGy, "webview", ".ui.tools.WebViewUI", intent);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        this.mGy.finish();
    }
}

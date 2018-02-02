package com.tencent.mm.sandbox.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.h;

final class d$a implements h {
    final /* synthetic */ d xcW;

    private d$a(d dVar) {
        this.xcW = dVar;
    }

    public final void ly(int i) {
        x.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
        j.eB(5, i);
        if (i != 110) {
            if (i == 100) {
                g.pQN.a(64, 64, 4, 3, 1, 1, false);
            } else {
                g.pQN.a(64, 3, 1, false);
            }
        }
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("tbs_download_finished", true);
            edit.apply();
        }
    }

    public final void lz(int i) {
        x.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
        j.eB(6, i);
        if (i == 200 || i == 220) {
            g.pQN.a(64, 64, 7, 6, 1, 1, false);
            d.a(this.xcW);
            return;
        }
        g.pQN.a(64, 6, 1, false);
    }

    public final void kO(int i) {
    }
}

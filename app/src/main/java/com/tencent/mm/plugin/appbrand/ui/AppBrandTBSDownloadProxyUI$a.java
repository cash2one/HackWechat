package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.h;

final class AppBrandTBSDownloadProxyUI$a implements h {
    final /* synthetic */ AppBrandTBSDownloadProxyUI jME;

    private AppBrandTBSDownloadProxyUI$a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.jME = appBrandTBSDownloadProxyUI;
    }

    public final void ly(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
        j.eB(5, i);
        if (i == 100 || i == 120 || i == 122) {
            g.pQN.a(366, 4, 1, false);
        } else {
            g.pQN.a(366, 5, 1, false);
        }
        SharedPreferences sharedPreferences;
        if (i != 110) {
            if (i == 100 || i == 120 || i == 122) {
                g.pQN.a(64, 64, 4, 3, 1, 1, false);
            } else {
                AppBrandTBSDownloadProxyUI.d(this.jME);
                d.a(AppBrandTBSDownloadProxyUI.e(this.jME));
                g.pQN.a(64, 3, 1, false);
                this.jME.setResult(0, new Intent());
                this.jME.finish();
            }
            sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
                return;
            }
            return;
        }
        sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
            edit = sharedPreferences.edit();
            edit.putBoolean("tbs_download_finished", true);
            edit.apply();
        }
        AppBrandTBSDownloadProxyUI.d(this.jME);
        d.a(AppBrandTBSDownloadProxyUI.e(this.jME));
        this.jME.setResult(0, new Intent());
        this.jME.finish();
    }

    public final void lz(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
        if (this.jME.tipDialog != null) {
            this.jME.tipDialog.dismiss();
            this.jME.tipDialog = null;
        }
        j.eB(6, i);
        if (i == 200 || i == 220) {
            g.pQN.a(64, 64, 7, 6, 1, 1, false);
            g.pQN.a(366, 6, 1, false);
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(e.h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            this.jME.sendBroadcast(intent);
            AppBrandTBSDownloadProxyUI.d(this.jME);
            d.a(AppBrandTBSDownloadProxyUI.e(this.jME));
            this.jME.setResult(-1, new Intent());
            this.jME.finish();
            return;
        }
        g.pQN.a(64, 6, 1, false);
        g.pQN.a(366, 7, 1, false);
        AppBrandTBSDownloadProxyUI.d(this.jME);
        d.a(AppBrandTBSDownloadProxyUI.e(this.jME));
        this.jME.setResult(0, new Intent());
        this.jME.finish();
    }

    public final void kO(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[]{Integer.valueOf(i)});
        if (this.jME.tipDialog != null) {
            ag.y(new 1(this, i));
        }
    }
}

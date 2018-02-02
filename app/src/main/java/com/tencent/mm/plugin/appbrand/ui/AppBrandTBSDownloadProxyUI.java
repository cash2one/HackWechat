package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.e$h;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;

@a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean jMD = false;
    private a jMB = null;
    private Runnable jMC;
    private Handler mHandler;
    r tipDialog;

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (!appBrandTBSDownloadProxyUI.isFinishing() && !appBrandTBSDownloadProxyUI.xIq) {
            OnClickListener 6 = new 6(appBrandTBSDownloadProxyUI);
            if (DebuggerShell.acg()) {
                6.onClick(null, 0);
                return;
            }
            OnClickListener 7 = new 7(appBrandTBSDownloadProxyUI);
            i.a aVar = new i.a(appBrandTBSDownloadProxyUI.mController.xIM);
            aVar.YG(appBrandTBSDownloadProxyUI.mController.xIM.getString(j.iBy));
            aVar.mi(false);
            aVar.EC(j.iBx).a(6);
            aVar.ED(j.iBw).b(7);
            aVar.akx().show();
            x.a.kR(true);
            g.pQN.a(366, 1, 1, false);
        }
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (appBrandTBSDownloadProxyUI.jMB == null) {
            appBrandTBSDownloadProxyUI.jMB = new a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        d.a(appBrandTBSDownloadProxyUI.jMB);
        com.tencent.mm.pluginsdk.ui.tools.j.pY(3);
        f.t(ac.getContext(), true);
    }

    static {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "TRACE_ORDER:AppBrandTBSDownloadProxyUI.java");
        com.tencent.xweb.r.a(ac.getContext(), new 1(), null, null);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = h.a(this.mController.xIM, null, true, null);
        this.tipDialog.setOnCancelListener(new 5(this));
        j.a(getWindow());
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        sendBroadcast(intent);
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = d.getTBSInstalling();
        boolean cEs = f.cEs();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[]{Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling)});
        if (isDownloading || tBSInstalling) {
            if (cEs) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (jMD) {
                    setResult(0, new Intent());
                    finish();
                    return;
                }
                if (this.jMB == null) {
                    this.jMB = new a(this, (byte) 0);
                }
                d.a(this.jMB);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                Context context = this.mController.xIM;
                this.mController.xIM.getString(j.dGO);
                this.tipDialog = h.a(context, this.mController.xIM.getString(j.iBz), true, null);
                if (this.tipDialog.getWindow() != null) {
                    LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new 2(this));
                akP();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            f.stopDownload();
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        f.a(this.mController.xIM, false, true, new 3(this));
    }

    private void akP() {
        this.mHandler = new Handler();
        this.jMC = new 4(this);
        this.mHandler.postDelayed(this.jMC, 20000);
    }

    protected final void onDestroy() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.jMC == null)) {
            this.mHandler.removeCallbacks(this.jMC);
        }
        super.onDestroy();
    }
}

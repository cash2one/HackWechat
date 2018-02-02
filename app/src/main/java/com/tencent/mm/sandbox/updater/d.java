package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.bl.a;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.f;

public final class d implements a {
    private Intent intent;
    private Notification sbc;
    private a xcS;
    private int xcT;
    private boolean xcU;
    private boolean xcV;

    static /* synthetic */ void a(d dVar) {
        if (dVar.xcU) {
            String by = bh.by(ac.getContext());
            x.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", new Object[]{by});
            if (bh.ov(by) || !by.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ac.getContext().sendBroadcast(intent);
                Context context = ac.getContext();
                android.support.v4.app.z.d dVar2 = new android.support.v4.app.z.d(context);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                dVar2.U(a.bXV());
                dVar2.a(context.getString(R.l.eXb));
                dVar2.b(context.getString(R.l.eXa));
                dVar2.c(2, false);
                dVar2.n(true);
                dVar2.sa = PendingIntent.getActivity(ac.getContext(), 0, new Intent(), 0);
                dVar.sbc = dVar2.build();
                notificationManager.notify(dVar.xcT, dVar.sbc);
                intent = new Intent();
                intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                ac.getContext().sendBroadcast(intent);
            }
        }
    }

    static {
        r.a(ac.getContext(), new 1());
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.downloader.f.a.aAk());
    }

    public static d cep() {
        return b.xcX;
    }

    private d() {
        this.xcS = null;
        this.intent = new Intent();
        this.sbc = null;
        this.xcT = 999;
        this.xcU = false;
        this.xcV = false;
    }

    public final void lv(boolean z) {
        if (this.xcS == null) {
            x.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            return;
        }
        Context context = ac.getContext();
        boolean isDownloading = f.isDownloading();
        boolean A = f.A(context, this.xcU | this.xcV);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean cEs = f.cEs();
        x.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isDownloading), Boolean.valueOf(A), Boolean.valueOf(booleanExtra)});
        if ((z || booleanExtra) && !isDownloading && A) {
            ceq();
            j.pY(3);
        } else if (!z && !booleanExtra && isDownloading && !cEs) {
            f.stopDownload();
            j.pY(4);
        }
    }

    private void ceq() {
        f.gI(ac.getContext());
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[]{Boolean.valueOf(this.xcV), Boolean.valueOf(this.xcU)});
            if (this.xcV || this.xcU) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
    }

    public final boolean af(Intent intent) {
        this.intent = intent;
        this.xcU = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.xcV = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        x.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[]{Boolean.valueOf(this.xcU), Boolean.valueOf(this.xcV)});
        if (f.isDownloading()) {
            x.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            return true;
        }
        Context context = ac.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        x.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[]{Integer.valueOf(tbsCoreVersion), Boolean.valueOf(f.A(context, this.xcU | this.xcV)), Boolean.valueOf(an.isWifi(context)), Boolean.valueOf(this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false))});
        if ((!an.isWifi(context) && !r5) || !r4) {
            return false;
        }
        if (this.xcS == null) {
            this.xcS = new a(this, (byte) 0);
            com.tencent.xweb.x5.sdk.d.a(this.xcS);
            j.pY(2);
        }
        ceq();
        j.pY(3);
        return true;
    }

    public final boolean isBusy() {
        x.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[]{Boolean.valueOf(f.isDownloading()), Boolean.valueOf(com.tencent.xweb.x5.sdk.d.getTBSInstalling())});
        if (f.isDownloading() || r3) {
            return true;
        }
        return false;
    }

    public final void onDestroy() {
        x.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    }
}

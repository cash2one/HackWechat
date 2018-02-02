package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static BroadcastReceiver nbm = null;
    private static boolean nbn = false;
    private static int nbo = -1;
    private static af nbp = new 1(Looper.getMainLooper());

    private static class b extends BroadcastReceiver {
        private b() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!ar.Hj() || ar.Cs()) {
                x.e("MicroMsg.GameAutoDownloader", "acc has not ready");
                return;
            }
            int netType = an.getNetType(ac.getContext());
            if (netType != e.nbo) {
                e.nbo = netType;
                x.i("MicroMsg.GameAutoDownloader", "onNetStateChange, netState = " + netType);
                LinkedList aQu = SubCoreGameCenter.aRd().aQu();
                if (!bh.cA(aQu)) {
                    e.M(aQu);
                    Iterator it;
                    t tVar;
                    if (netType == 0) {
                        it = aQu.iterator();
                        while (it.hasNext()) {
                            tVar = (t) it.next();
                            tVar.aQm();
                            e.a(tVar, false);
                        }
                        return;
                    }
                    it = aQu.iterator();
                    while (it.hasNext()) {
                        tVar = (t) it.next();
                        tVar.aQm();
                        e.e(tVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ void M(LinkedList linkedList) {
        Object linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.field_expireTime <= System.currentTimeMillis() / 1000) {
                x.i("MicroMsg.GameAutoDownloader", "expireTime expireTime = %d, currentTime = %d, appid = %s", new Object[]{Long.valueOf(tVar.field_expireTime), Long.valueOf(System.currentTimeMillis() / 1000), tVar.field_appId});
                FileDownloadTaskInfo xI = f.aAd().xI(tVar.field_appId);
                if (xI != null) {
                    x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(xI.id), Integer.valueOf(xI.status)});
                    if (xI.id > 0) {
                        Message message = new Message();
                        message.what = 2;
                        a aVar = new a((byte) 0);
                        aVar.fmZ = xI.id;
                        aVar.nbq = tVar;
                        message.obj = aVar;
                        nbp.sendMessageDelayed(message, 2000);
                    }
                    SubCoreGameCenter.aRd().a(tVar, new String[0]);
                    linkedList2.add(tVar);
                } else {
                    return;
                }
            }
        }
        if (!bh.cA(linkedList2)) {
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                linkedList.remove((t) it2.next());
            }
        }
    }

    static /* synthetic */ void e(t tVar) {
        FileDownloadTaskInfo xI = f.aAd().xI(tVar.field_appId);
        if (xI != null) {
            x.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask, downloadId = %d, status = %d", new Object[]{Long.valueOf(xI.id), Integer.valueOf(xI.status)});
            if (xI.status == 1) {
                boolean bZ = f.aAd().bZ(xI.id);
                if (!bZ) {
                    f.aAd().bX(xI.id);
                }
                x.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask ret = " + bZ);
            }
        }
    }

    public static void aPU() {
        if (nbm == null) {
            nbm = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ac.getContext().registerReceiver(nbm, intentFilter);
            nbn = true;
        } catch (Exception e) {
            x.e("MicroMsg.GameAutoDownloader", e.getMessage());
            nbn = false;
        }
    }

    public static void aPV() {
        if (nbm != null) {
            try {
                ac.getContext().unregisterReceiver(nbm);
            } catch (Exception e) {
                x.e("MicroMsg.GameAutoDownloader", e.getMessage());
            }
        }
        nbm = null;
        nbn = false;
    }

    public static void a(t tVar) {
        tVar.aQm();
        if (tVar.ncw == 0) {
            int i = 0;
        } else {
            boolean z = true;
        }
        if (i == 0) {
            FileDownloadTaskInfo xI = f.aAd().xI(tVar.field_appId);
            x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(xI.id), Integer.valueOf(xI.status)});
            if (xI.id > 0) {
                f.aAd().bX(xI.id);
            }
            SubCoreGameCenter.aRd().a(tVar, new String[0]);
            return;
        }
        a(tVar, true);
    }

    private static void b(t tVar) {
        if (!ar.Hj()) {
            x.e("MicroMsg.GameAutoDownloader", "MMCore is not ready");
        } else if (ar.Cs()) {
            x.e("MicroMsg.GameAutoDownloader", "MMCore.isHold() = " + ar.Cs());
        } else {
            boolean z;
            int i = tVar.ncg;
            ar.Hg();
            if (!c.isSDCardAvailable()) {
                x.e("MicroMsg.GameAutoDownloader", "sdCard is not available");
                z = false;
            } else if (com.tencent.mm.compatible.util.f.aC((long) i)) {
                z = true;
            } else {
                x.e("MicroMsg.GameAutoDownloader", "sdCard have not enough space, need size = " + i);
                z = false;
            }
            if (!z) {
                return;
            }
            if (bh.ov(tVar.nce) || bh.ov(tVar.ncf) || bh.ov(tVar.field_appId)) {
                x.e("MicroMsg.GameAutoDownloader", "mAppDownloadURL = %s, mAppMD5 = %s, appId = %s", new Object[]{tVar.nce, tVar.ncf, tVar.field_appId});
                return;
            }
            com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(tVar.field_appId, true);
            if (aZ == null) {
                x.e("MicroMsg.GameAutoDownloader", "appInfo = null");
                return;
            }
            x.i("MicroMsg.GameAutoDownloader", "startDownloadTask, appid = %s, url = %s, md5 = %s", new Object[]{tVar.field_appId, tVar.nce, tVar.ncf});
            g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
            com_tencent_mm_plugin_downloader_model_g_a.xL(tVar.nce);
            com_tencent_mm_plugin_downloader_model_g_a.setAppId(tVar.field_appId);
            com_tencent_mm_plugin_downloader_model_g_a.cu(aZ.field_packageName);
            com_tencent_mm_plugin_downloader_model_g_a.xN(g.a(ac.getContext(), aZ, null));
            com_tencent_mm_plugin_downloader_model_g_a.xO(tVar.ncf);
            com_tencent_mm_plugin_downloader_model_g_a.ep(false);
            com_tencent_mm_plugin_downloader_model_g_a.eq(false);
            com_tencent_mm_plugin_downloader_model_g_a.ox(1);
            com_tencent_mm_plugin_downloader_model_g_a.er(true);
            long a = f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
            x.i("MicroMsg.GameAutoDownloader", "startDownloadTask id = " + a);
            if (a > 0) {
                n.a(tVar.nce, tVar.ncf, 1999, tVar.field_appId, null, null);
            }
        }
    }

    private static void a(t tVar, boolean z) {
        if (bh.ov(tVar.field_appId)) {
            x.e("MicroMsg.GameAutoDownloader", "appid = " + tVar.field_appId);
            return;
        }
        x.i("MicroMsg.GameAutoDownloader", "addDownloadTask, appid = %s, initDownload = %s", new Object[]{tVar.field_appId, Boolean.valueOf(z)});
        FileDownloadTaskInfo xI = f.aAd().xI(tVar.field_appId);
        if (xI == null) {
            return;
        }
        if (g.m(ac.getContext(), tVar.field_appId)) {
            SubCoreGameCenter.aRd().a(tVar, new String[0]);
            x.i("MicroMsg.GameAutoDownloader", "app is installed, appid = " + tVar.field_appId);
            return;
        }
        x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(xI.id), Integer.valueOf(xI.status)});
        switch (xI.status) {
            case 0:
            case 4:
            case 5:
                if (an.getNetType(ac.getContext()) == 0 && nbn) {
                    b(tVar);
                    return;
                }
                return;
            case 1:
                if (z && !xI.lsK) {
                    SubCoreGameCenter.aRd().a(tVar, new String[0]);
                    return;
                }
                return;
            case 2:
                if (!z || xI.lsK) {
                    Message message = new Message();
                    message.what = 1;
                    a aVar = new a((byte) 0);
                    aVar.fmZ = xI.id;
                    aVar.nbq = tVar;
                    message.obj = aVar;
                    nbp.sendMessageDelayed(message, 2000);
                    return;
                }
                SubCoreGameCenter.aRd().a(tVar, new String[0]);
                return;
            case 3:
                SubCoreGameCenter.aRd().a(tVar, new String[0]);
                return;
            default:
                return;
        }
    }
}

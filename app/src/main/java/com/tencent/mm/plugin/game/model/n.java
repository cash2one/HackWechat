package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class n implements o, ITMQQDownloaderOpenSDKListener {
    private static n nbK = null;
    private static BroadcastReceiver nbL = null;
    private static Set<b> nbM = Collections.synchronizedSet(new HashSet());
    private static HashMap<String, c> nbN = new HashMap();
    private static Map<Long, Long> nbO = new HashMap();

    private n() {
    }

    public static n aQg() {
        if (nbK == null) {
            nbK = new n();
        }
        return nbK;
    }

    public static void a(b bVar) {
        synchronized (nbM) {
            nbM.add(bVar);
        }
    }

    public static void b(b bVar) {
        synchronized (nbM) {
            nbM.remove(bVar);
            x.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[]{Integer.valueOf(nbM.size()), bVar});
        }
    }

    public static void aPU() {
        if (nbK == null) {
            nbK = new n();
        }
        if (nbL == null) {
            nbL = new a((byte) 0);
        }
        f.aAd();
        c.a(nbK);
        bj.aQY();
        bj.registerListener(nbK);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        ac.getContext().registerReceiver(nbL, intentFilter);
    }

    public static void aPV() {
        f.aAd();
        c.b(nbK);
        bj.aQY();
        bj.unregisterListener(nbK);
        ac.getContext().unregisterReceiver(nbL);
        nbK = null;
        nbM.clear();
        nbN.clear();
    }

    private void t(long j, int i) {
        a ce = e.ce(j);
        if (ce != null) {
            int i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 2;
                    break;
                case 5:
                    i2 = 8;
                    break;
                case 6:
                    break;
                case 7:
                    i2 = 7;
                    break;
            }
            if (!bh.ov(ce.field_appId)) {
                ap.a(ce.field_appId, ce.field_scene, i2, ce.field_downloadedSize - ce.field_startSize, ce.field_totalSize, ce.field_downloadUrl, ce.field_errCode, ce.field_downloaderType, ce.field_channelId, (System.currentTimeMillis() - ce.field_startTime) / 1000, ce.field_startState, ce.field_downloadId);
            }
            c cVar = (c) nbN.get(ce.field_downloadUrl);
            if (cVar == null) {
                x.e("MicroMsg.GameDownloadEventBus", "No report info found, abort reporting: %s", new Object[]{ce.field_downloadUrl});
            } else {
                if (bh.ov(cVar.fqf)) {
                    cVar.fqf = a(cVar);
                }
                ap.a(cVar.appId, cVar.scene, i2, cVar.fqR, ce.field_downloadUrl, cVar.nbS, cVar.fqf);
            }
            g(i, ce.field_appId, !ce.field_autoDownload);
        }
    }

    private void g(int i, String str, boolean z) {
        ag.y(new 1(this, i, str, z));
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        if (!bh.ov(str)) {
            nbN.put(str, new c(str2, i, str3, "", str4));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        if (!bh.ov(str)) {
            nbN.put(str, new c(str2, i, str3, str4, str5));
        }
    }

    public final void onTaskStarted(long j, String str) {
        nbO.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        t(j, 1);
    }

    public final void c(long j, String str, boolean z) {
        if (bh.ov(str) || !com.tencent.mm.a.e.bO(str)) {
            f.aAd().bX(j);
            return;
        }
        if (nbO.containsKey(Long.valueOf(j))) {
            long longValue = ((Long) nbO.get(Long.valueOf(j))).longValue();
            nbO.remove(Long.valueOf(j));
            longValue = (System.currentTimeMillis() - longValue) / 1000;
            a ce = e.ce(j);
            if (ce != null) {
                x.i("MicroMsg.GameDownloadEventBus", "appId = %s, downloadType = %d, costTime = %d", new Object[]{ce.field_appId, Integer.valueOf(ce.field_downloaderType), Long.valueOf(longValue)});
                ap.a(ac.getContext(), ce.field_appId, longValue, ce.field_downloaderType);
            }
        }
        t(j, 3);
        if (z) {
            a ce2 = e.ce(j);
            if (ce2 != null) {
                String str2 = ce2.field_appId;
                SubCoreGameCenter.aRg();
                z.b(str2, 5, 0, null, null);
            }
        }
    }

    public final void c(long j, int i, boolean z) {
        nbO.remove(Long.valueOf(j));
        t(j, 5);
        a ce = e.ce(j);
        if (ce != null) {
            String str = null;
            if (i == d.lrZ) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", ce.field_channelId);
                    jSONObject.put("DownloadSize", ce.field_downloadedSize);
                    str = ap.BY(jSONObject.toString());
                    x.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                }
            }
            a(ce.field_appId, i, z, str);
        }
    }

    public final void onTaskRemoved(long j) {
        int i = 0;
        nbO.remove(Long.valueOf(j));
        t(j, 4);
        a ce = e.ce(j);
        if (ce != null) {
            Context context = ac.getContext();
            CharSequence charSequence = ce.field_appId;
            SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
            String string = sharedPreferences.getString("download_app_id_time_map", "");
            if (!bh.ov(string) && string.contains(charSequence)) {
                String str = new String();
                String[] split = string.split(",");
                while (i < split.length) {
                    String str2 = split[i];
                    if (!str2.contains(charSequence)) {
                        str = i == split.length + -1 ? str + str2 : str + str2 + ",";
                    }
                    i++;
                }
                sharedPreferences.edit().putString("download_app_id_time_map", str).apply();
            }
        }
    }

    public final void onTaskPaused(long j) {
        nbO.remove(Long.valueOf(j));
        t(j, 2);
    }

    public final void ck(long j) {
        t(j, 6);
    }

    public final void k(long j, String str) {
        t(j, 7);
    }

    public final void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        int i3 = 2;
        x.i("MicroMsg.GameDownloadEventBus", "OnDownloadTaskStateChanged, status = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i2 == 0) {
            switch (i) {
                case 1:
                case 2:
                    i3 = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i3 = 3;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                g(i3, tMQQDownloaderOpenSDKParam.taskPackageName, true);
            }
        }
    }

    public final void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
    }

    public final void OnQQDownloaderInvalid() {
    }

    public final void OnServiceFree() {
    }

    private static String a(c cVar) {
        a xE = e.xE(cVar.appId);
        if (xE == null) {
            return null;
        }
        if (xE.field_downloaderType == 1) {
            return "downloader_type_system";
        }
        return "downloader_type_tmassistant";
    }

    public static void a(String str, int i, boolean z, String str2) {
        if (i == 710 || i == 711) {
            i = d.lsb;
        }
        x.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[]{str, Integer.valueOf(i)});
        if (z) {
            SubCoreGameCenter.aRg();
            z.b(str, 4, i, null, str2);
            return;
        }
        SubCoreGameCenter.aRg();
        z.b(str, 2, i, null, str2);
    }

    public static void cK(String str, String str2) {
        SubCoreGameCenter.aRg();
        z.b(str, 6, 0, null, str2);
    }
}

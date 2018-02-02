package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class n$a extends BroadcastReceiver {
    private n$a() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            x.i("MicroMsg.GameInstallationReceiver", action);
            if (bh.ov(action)) {
                x.e("MicroMsg.GameInstallationReceiver", "action is null or nill, ignore");
            } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                action = "";
                try {
                    action = intent.getDataString();
                } catch (Throwable e) {
                    x.e("MicroMsg.GameInstallationReceiver", "%s", bh.i(e));
                }
                x.i("MicroMsg.GameInstallationReceiver", "get added package name : %s", action);
                if (bh.ov(action)) {
                    x.e("MicroMsg.GameInstallationReceiver", "get installed broadcast, while the package name is null or nil");
                    return;
                }
                if (action.startsWith("package:")) {
                    action = action.substring(8);
                }
                if (!ar.Hj() || ar.Cs()) {
                    x.e("MicroMsg.GameInstallationReceiver", "no user login");
                } else if (ar.Hg() != null) {
                    a aVar;
                    b Fe = c.Fe();
                    if (bh.ov(action)) {
                        x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                        aVar = null;
                    } else {
                        Cursor rawQuery = Fe.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                        if (rawQuery == null) {
                            aVar = null;
                        } else {
                            a aVar2 = null;
                            if (rawQuery.moveToFirst()) {
                                aVar2 = new a();
                                aVar2.b(rawQuery);
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            aVar = aVar2;
                        }
                    }
                    if (aVar == null) {
                        x.e("MicroMsg.GameInstallationReceiver", "No AppInfo found for package: %s", action);
                        return;
                    }
                    if (e.bO(aVar.field_filePath)) {
                        com.tencent.mm.loader.stub.b.deleteFile(aVar.field_filePath);
                        com.tencent.mm.plugin.downloader.model.e.xG(aVar.field_appId);
                    }
                    if (!bh.ov(aVar.field_appId)) {
                        ap.a(aVar.field_appId, aVar.field_scene, 5, aVar.field_downloadedSize - aVar.field_startSize, aVar.field_totalSize, aVar.field_downloadUrl, 0, aVar.field_downloaderType, aVar.field_channelId, (System.currentTimeMillis() - aVar.field_startTime) / 1000, aVar.field_startState, aVar.field_downloadId);
                    }
                    n$c com_tencent_mm_plugin_game_model_n_c = (n$c) n.aQi().get(aVar.field_downloadUrl);
                    if (com_tencent_mm_plugin_game_model_n_c == null) {
                        x.e("MicroMsg.GameInstallationReceiver", "No ReportInfo found for url: %s", aVar.field_downloadUrl);
                        return;
                    }
                    if (bh.ov(com_tencent_mm_plugin_game_model_n_c.fqf)) {
                        com_tencent_mm_plugin_game_model_n_c.fqf = n.b(com_tencent_mm_plugin_game_model_n_c);
                    }
                    ap.a(com_tencent_mm_plugin_game_model_n_c.appId, com_tencent_mm_plugin_game_model_n_c.scene, 5, com_tencent_mm_plugin_game_model_n_c.fqR, aVar.field_downloadUrl, com_tencent_mm_plugin_game_model_n_c.nbS, com_tencent_mm_plugin_game_model_n_c.fqf);
                }
            }
        }
    }
}

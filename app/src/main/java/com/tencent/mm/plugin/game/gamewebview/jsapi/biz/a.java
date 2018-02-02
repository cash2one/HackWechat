package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.jsapi.a {
    public static final int CTRL_BYTE = 269;
    public static final String NAME = "addDownloadTaskStraight";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "invoke");
        Context aPh = dVar.aPh();
        String optString = jSONObject.optString("task_url");
        long optLong = jSONObject.optLong("task_size");
        if (bh.ov(optString)) {
            x.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "url is null");
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:fail", null));
        } else if (!an.isNetworkConnected(dVar.getContext())) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:fail_network_not_connected", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new 1(this, dVar));
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, network not ready");
        } else if (!f.ze()) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:fail_sdcard_not_ready", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new 2(this, dVar));
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
        } else if (optLong > 0 && !f.aC(optLong)) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:fail_has_not_enough_space", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new 3(this, dVar));
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, not enough space, require size = " + optLong);
        } else if (an.isWifi(aPh)) {
            b(dVar, jSONObject, i);
        } else {
            h.a(aPh, aPh.getString(R.l.eWB), aPh.getString(R.l.eWC), aPh.getString(R.l.eWw), aPh.getString(R.l.dEn), false, new 4(this, dVar, jSONObject, i), new 5(this, dVar, i), R.e.bui);
        }
    }

    void b(d dVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("task_name");
        String optString2 = jSONObject.optString("task_url");
        String optString3 = jSONObject.optString("alternative_url");
        long optLong = jSONObject.optLong("task_size");
        String optString4 = jSONObject.optString("file_md5");
        String optString5 = jSONObject.optString("extInfo");
        String optString6 = jSONObject.optString("fileType");
        String optString7 = jSONObject.optString("appid");
        String optString8 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        int optInt = jSONObject.optInt("scene", 1000);
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 1;
        doDownloadTask.mWn = optString;
        doDownloadTask.url = optString2;
        doDownloadTask.mWo = optString3;
        doDownloadTask.fqR = optString4;
        doDownloadTask.extInfo = optString5;
        doDownloadTask.mWp = optString6;
        doDownloadTask.appId = optString7;
        doDownloadTask.packageName = optString8;
        doDownloadTask.mWq = optLong;
        doDownloadTask.scene = optInt;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fmZ <= 0) {
            x.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, downloadId = " + doDownloadTask.fmZ);
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:fail", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("download_id", Long.valueOf(doDownloadTask.fmZ));
        dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("add_download_task:ok", hashMap));
    }
}

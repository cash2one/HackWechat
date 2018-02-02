package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_BYTE = 39;
    public static final String NAME = "cancelDownloadTask";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiCancelDownloadTask", "GameJsApiCancelDownloadTask");
        long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            x.e("MicroMsg.GameJsApiCancelDownloadTask", "fail, invalid downloadId = " + optLong);
            dVar.E(i, a.e("cancel_download_task:fail_invalid_downloadid", null));
            return;
        }
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 4;
        doDownloadTask.fmZ = optLong;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fpW) {
            dVar.E(i, a.e("cancel_download_task:ok", null));
        } else {
            dVar.E(i, a.e("cancel_download_task:fail", null));
        }
    }
}

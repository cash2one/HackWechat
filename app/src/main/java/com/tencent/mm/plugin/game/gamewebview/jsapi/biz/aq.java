package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_BYTE = 240;
    public static final String NAME = "resumeDownloadTask";
    private long fmZ;
    private int scene;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiResumeDownloadTask", "GameJsApiResumeDownloadTask");
        Context aPh = dVar.aPh();
        this.fmZ = jSONObject.optLong("download_id");
        this.scene = jSONObject.optInt("scene", 1000);
        if (this.fmZ <= 0) {
            x.e("MicroMsg.GameJsApiResumeDownloadTask", "fail, invalid downloadId = " + this.fmZ);
            dVar.E(i, a.e("resume_download_task:fail_invalid_downloadid", null));
        } else if (an.isWifi(aPh)) {
            b(dVar, i);
        } else {
            h.a(aPh, aPh.getString(R.l.eWB), aPh.getString(R.l.eWC), aPh.getString(R.l.eWw), aPh.getString(R.l.dEn), false, new OnClickListener(this) {
                final /* synthetic */ aq mXd;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mXd.b(dVar, i);
                    dialogInterface.dismiss();
                }
            }, new 2(this, dVar, i), R.e.bui);
        }
    }

    void b(d dVar, int i) {
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 3;
        doDownloadTask.fmZ = this.fmZ;
        doDownloadTask.scene = this.scene;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fpW) {
            dVar.E(i, a.e("resume_download_task:ok", null));
        } else {
            dVar.E(i, a.e("resume_download_task:fail", null));
        }
    }
}

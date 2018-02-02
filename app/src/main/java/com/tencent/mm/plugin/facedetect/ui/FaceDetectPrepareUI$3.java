package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$3 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ FaceDetectPrepareUI mjQ;

    FaceDetectPrepareUI$3(FaceDetectPrepareUI faceDetectPrepareUI, int i) {
        this.mjQ = faceDetectPrepareUI;
        this.fmb = i;
    }

    public final void onClick(View view) {
        if (bh.ov(FaceDetectPrepareUI.g(this.mjQ))) {
            x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
            return;
        }
        FaceDetectPrepareUI.h(this.mjQ);
        try {
            String str = "appid=%s;errcode=%d;identifyid=%s";
            Object[] objArr = new Object[3];
            objArr[0] = FaceDetectPrepareUI.i(this.mjQ) != null ? FaceDetectPrepareUI.i(this.mjQ) : "";
            objArr[1] = Integer.valueOf(this.fmb);
            objArr[2] = "";
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[]{FaceDetectPrepareUI.g(this.mjQ) + "?customInfo=" + p.encode(String.format(str, objArr), "UTF-8")});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            d.b(this.mjQ, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "alvinluo start feedback webview exception", new Object[0]);
        }
    }
}

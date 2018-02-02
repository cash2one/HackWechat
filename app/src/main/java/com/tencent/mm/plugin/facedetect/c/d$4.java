package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ Bundle mfM;
    final /* synthetic */ d mfO;
    final /* synthetic */ Context val$context;

    d$4(d dVar, Bundle bundle, int i, Context context) {
        this.mfO = dVar;
        this.mfM = bundle;
        this.fmb = i;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (bh.ov(this.mfO.mfN)) {
            x.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
            return;
        }
        if (!(this.mfO.mfy == null || this.mfO.mfy.get() == null)) {
            ((e) this.mfO.mfy.get()).aGq();
        }
        String str = null;
        if (this.mfM != null) {
            str = this.mfM.getString("verify_result");
        }
        try {
            String str2 = "appid=%s;errcode=%d;identifyid=%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.mfO.appId != null ? this.mfO.appId : "";
            objArr[1] = Integer.valueOf(this.fmb);
            if (str == null) {
                str = "";
            }
            objArr[2] = str;
            x.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[]{this.mfO.mfN + "?customInfo=" + p.encode(String.format(str2, objArr), "UTF-8")});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectMpController", e, "alvinluo start feedback webview exception", new Object[0]);
        }
    }
}

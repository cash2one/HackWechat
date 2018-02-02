package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements OnClickListener {
    final /* synthetic */ p jdJ;
    final /* synthetic */ f jhc;

    f$2(f fVar, p pVar) {
        this.jhc = fVar;
        this.jdJ = pVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
        String str = this.jdJ.mContext.getString(j.iyB) + w.cfi();
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(this.jdJ.mContext, "webview", ".ui.tools.WebViewUI", intent);
    }
}

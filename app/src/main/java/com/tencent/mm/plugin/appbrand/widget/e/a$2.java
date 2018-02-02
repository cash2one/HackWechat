package com.tencent.mm.plugin.appbrand.widget.e;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

class a$2 implements Runnable {
    final /* synthetic */ p jdJ;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ int jhi;
    final /* synthetic */ f jiC;
    final /* synthetic */ a kcu;
    final /* synthetic */ View zS;

    a$2(a aVar, p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        this.kcu = aVar;
        this.jdJ = pVar;
        this.jhi = i;
        this.zS = view;
        this.jel = jSONObject;
        this.jiC = fVar;
    }

    public final void run() {
        this.kcu.a(this.jdJ, this.jhi, this.zS, this.jel, a.anC(), this.jiC);
    }
}

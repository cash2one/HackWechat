package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class c extends b {
    private e jcq;
    private int jcs;
    WeakReference<p> mPageRef;

    abstract void r(JSONObject jSONObject);

    c() {
    }

    final void a(e eVar, p pVar, JSONObject jSONObject, int i) {
        this.jcq = eVar;
        this.mPageRef = new WeakReference(pVar);
        this.jcs = i;
        r(jSONObject);
    }

    protected final View agG() {
        return this.mPageRef == null ? null : ((p) this.mPageRef.get()).getContentView();
    }

    final void f(String str, Map<String, Object> map) {
        if (this.mPageRef != null && this.mPageRef.get() != null && this.jcq != null) {
            ((p) this.mPageRef.get()).E(this.jcs, this.jcq.e(str, map));
        }
    }
}

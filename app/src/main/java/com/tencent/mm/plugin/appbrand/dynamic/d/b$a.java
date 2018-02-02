package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

class b$a implements Runnable {
    String iTh;
    JSONObject iTi;
    b iTj;
    com.tencent.mm.u.b.b$a iTk;
    b iTl;
    String process;

    private b$a() {
    }

    public final void run() {
        synchronized (this.iTl) {
            this.iTl.o(this.iTj.rt("lastTime"), Long.valueOf(System.currentTimeMillis()));
        }
        Bundle bundle = new Bundle();
        bundle.putString("viewId", this.iTh);
        bundle.putString("jsApiInvokeData", this.iTi.toString());
        String h = d.h(this.iTi);
        Parcelable aR = c.aR(h, "after_jsapi_invoke");
        bundle.putString("__session_id", h);
        bundle.putParcelable("__cost_time_session", aR);
        f.a(this.process, bundle, b.b.class, new com.tencent.mm.ipcinvoker.c(this) {
            final /* synthetic */ b$a iTm;

            {
                this.iTm = r1;
            }

            public final void i(Bundle bundle) {
                this.iTm.iTk.aw(this.iTm.iTj.a(bundle.getBoolean("ret"), bundle.getString("reason", ""), null));
            }
        });
    }
}

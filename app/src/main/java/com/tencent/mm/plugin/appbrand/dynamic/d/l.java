package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.u.b.b;
import com.tencent.mm.z.u;
import org.json.JSONObject;

public final class l extends a {
    public l(int i) {
        super("setWidgetSize", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        u.b Cb = aVar.Cb();
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar3 = new com.tencent.mm.plugin.appbrand.dynamic.widget.a.a();
        aVar3.id = Cb.getString("__page_view_id", "");
        aVar3.width = jSONObject.optInt("width", Cb.getInt("__page_view_width", 0));
        aVar3.height = jSONObject.optInt("height", Cb.getInt("__page_view_height", 0));
        XIPCInvoker.a(Cb.getString("__process_name", ac.Br()), aVar3, a.class, new i<Bundle>(this) {
            final /* synthetic */ l iTx;

            public final /* synthetic */ void as(Object obj) {
                boolean z;
                String string;
                Bundle bundle = null;
                Bundle bundle2 = (Bundle) obj;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    string = bundle2.getString("reason");
                    bundle = bundle2.getBundle(SlookAirButtonFrequentContactAdapter.DATA);
                } else {
                    z = false;
                    string = null;
                }
                aVar2.aw(this.iTx.a(z, string, bundle));
            }
        });
    }
}

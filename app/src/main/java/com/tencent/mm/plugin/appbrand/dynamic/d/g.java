package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    private static class a implements f {
        String fIA;
        String id;

        private a() {
        }

        public final void e(Parcel parcel) {
            parcel.writeString(this.id);
            parcel.writeString(this.fIA);
        }

        public final void readFromParcel(Parcel parcel) {
            this.id = parcel.readString();
            this.fIA = parcel.readString();
        }
    }

    private static class b implements h<a, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            a aVar = (a) obj;
            Bundle bundle = new Bundle();
            View rn = e.acF().rn(aVar.id);
            if (rn instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rn).b(aVar.fIA, new 1(this, bundle, iVar));
                return;
            }
            x.i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            iVar.as(bundle);
        }
    }

    public g() {
        super(ai.NAME, 327);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, com.tencent.mm.u.b.b.a<JSONObject> aVar2) {
        com.tencent.mm.z.u.b Cb = aVar.Cb();
        a aVar3 = new a();
        aVar3.id = Cb.getString("__page_view_id", "");
        aVar3.fIA = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.a(Cb.getString("__process_name", ac.Br()), aVar3, b.class, new 1(this, aVar2));
    }
}

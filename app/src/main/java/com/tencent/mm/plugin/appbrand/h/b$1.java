package com.tencent.mm.plugin.appbrand.h;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$1 extends a {
    final /* synthetic */ String gBF;
    final /* synthetic */ String gIT;
    final /* synthetic */ long hAR;
    final /* synthetic */ int hLI;
    final /* synthetic */ int iGh;
    final /* synthetic */ String icx;
    final /* synthetic */ String jAY;
    final /* synthetic */ WeakReference jAZ;
    final /* synthetic */ String jBa;
    final /* synthetic */ b jBb;

    b$1(b bVar, String str, String str2, String str3, String str4, WeakReference weakReference, int i, long j, String str5, int i2) {
        this.jBb = bVar;
        this.icx = str;
        this.gIT = str2;
        this.gBF = str3;
        this.jAY = str4;
        this.jAZ = weakReference;
        this.hLI = i;
        this.hAR = j;
        this.jBa = str5;
        this.iGh = i2;
        super(1, null);
    }

    public final void bJ(View view) {
        x.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", this.icx, this.gIT, this.gBF, this.jAY);
        this.jAZ.get();
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", this.hLI);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(this.hAR));
        bundle.putString("stat_chat_talker_username", this.jAY);
        bundle.putString("stat_send_msg_user", this.jBa);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1088;
        appBrandStatObject.fnp = "";
        appBrandStatObject.fIs = c.f(appBrandStatObject.scene, bundle);
        appBrandStatObject.fIt = c.g(appBrandStatObject.scene, bundle);
        String str = "";
        if (this.gBF != null && this.gBF.length() > 0) {
            byte[] decode = Base64.decode(this.gBF, 2);
            if (decode != null) {
                str = new String(decode);
            }
        }
        ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(view.getContext(), this.gIT, null, this.iGh, 0, str, appBrandStatObject);
    }
}

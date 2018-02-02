package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.g.a.or;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;

class AppBrandProfileUI$5 implements a {
    final /* synthetic */ View jLA;
    final /* synthetic */ AppBrandProfileUI jLy;
    final /* synthetic */ t jLz;

    AppBrandProfileUI$5(AppBrandProfileUI appBrandProfileUI, t tVar, View view) {
        this.jLy = appBrandProfileUI;
        this.jLz = tVar;
        this.jLA = view;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            AppBrandProfileUI.a(this.jLy, 8, 2);
        } else if (i2 == -1) {
            String str;
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("Select_Conv_User");
            }
            if (str == null || str.length() == 0) {
                x.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                return;
            }
            x.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", new Object[]{str});
            String stringExtra = intent.getStringExtra("custom_send_text");
            String str2 = this.jLz.appId;
            u.GK().t(u.hz("wxapp_" + str2), true).o("prePublishId", "wxapp_" + str2);
            g.a aVar = new g.a();
            aVar.title = this.jLz.fpL;
            aVar.type = 33;
            aVar.hdx = AppBrandProfileUI.d(this.jLy);
            aVar.hdy = str2;
            aVar.hdz = 1;
            aVar.fGF = "wxapp_" + str2;
            aVar.thumburl = this.jLz.iPN;
            aVar.url = l.pr(str2);
            aVar.fGz = AppBrandProfileUI.d(this.jLy);
            aVar.fGA = this.jLz.fpL;
            for (String str3 : bh.F(str.split(","))) {
                int i3;
                ((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(aVar, str2, this.jLz.fpL, str3, null);
                if (!bh.ov(stringExtra)) {
                    b orVar = new or();
                    orVar.fGI.fGJ = str3;
                    orVar.fGI.content = stringExtra;
                    orVar.fGI.type = s.hp(str3);
                    orVar.fGI.flags = 0;
                    com.tencent.mm.sdk.b.a.xef.m(orVar);
                }
                if (str3.endsWith("@chatroom")) {
                    i3 = 9;
                } else {
                    i3 = 8;
                }
                AppBrandProfileUI.a(this.jLy, i3, bh.Wo());
            }
            h.bu(this.jLA.getContext(), this.jLA.getContext().getResources().getString(j.dGG));
        }
    }
}

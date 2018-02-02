package com.tencent.mm.ui.chatting;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.4;

class AppBrandServiceChattingUI$a$4$1 implements Runnable {
    final /* synthetic */ 4 ypY;

    AppBrandServiceChattingUI$a$4$1(4 4) {
        this.ypY = 4;
    }

    public final void run() {
        String str;
        String str2;
        String YB = b.YB(this.ypY.ypW.fAh.field_username);
        if (TextUtils.isEmpty(YB)) {
            YB = this.ypY.ypW.fAh.field_username;
            str = this.ypY.ypW.fAh.field_nickname;
            str2 = YB;
        } else {
            str = b.YC(YB);
            str2 = YB;
        }
        a.f(this.ypY.ypW).username = this.ypY.ypW.fAh.field_username;
        a.f(this.ypY.ypW).kfu = false;
        a.f(this.ypY.ypW).scene = a.b(this.ypY.ypW);
        a.f(this.ypY.ypW).xVB = a.g(this.ypY.ypW);
        if (a.b(this.ypY.ypW) == 2) {
            a.f(this.ypY.ypW).jLv = a.c(this.ypY.ypW);
            if (a.e(this.ypY.ypW)) {
                a.f(this.ypY.ypW).show(1);
                return;
            } else {
                a.f(this.ypY.ypW).show(2);
                return;
            }
        }
        WxaExposedParams.a aVar = new WxaExposedParams.a();
        if (TextUtils.isEmpty(str2)) {
            YB = null;
        } else {
            WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str2);
            if (qK == null || qK.abZ() == null) {
                x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
                YB = null;
            } else {
                YB = qK.field_appId;
            }
        }
        aVar.appId = YB;
        aVar.fqe = 4;
        aVar.username = str2;
        aVar.fpL = str;
        a.f(this.ypY.ypW).jLv = aVar.ace();
        a.f(this.ypY.ypW).appId = a.d(this.ypY.ypW);
        if (a.e(this.ypY.ypW)) {
            a.f(this.ypY.ypW).show(5);
        } else {
            a.f(this.ypY.ypW).show(6);
        }
    }
}

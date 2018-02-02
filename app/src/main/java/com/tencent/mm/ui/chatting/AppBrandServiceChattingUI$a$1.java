package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$b;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;

class AppBrandServiceChattingUI$a$1 implements d {
    final /* synthetic */ a ypW;

    AppBrandServiceChattingUI$a$1(a aVar) {
        this.ypW = aVar;
    }

    public final boolean ln(boolean z) {
        if (a.a(this.ypW) != null) {
            WxaAttributes$b.a aVar = (WxaAttributes$b.a) a.a(this.ypW).iPw.get(0);
            if (a.b(this.ypW) == 2 && a.c(this.ypW).username.equals(aVar.userName)) {
                x.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[]{aVar.userName, aVar.fnq});
                a.a(this.ypW, aVar.fnq);
            } else {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1080;
                ((c) g.h(c.class)).a(this.ypW.getContext(), aVar.userName, "", 0, aVar.version, aVar.fnq, appBrandStatObject, a.d(this.ypW));
            }
        } else {
            x.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
        }
        return true;
    }
}

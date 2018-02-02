package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.ky;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;

class AppBrandServiceChattingUI$a$3 extends c<ky> {
    final /* synthetic */ a ypW;

    AppBrandServiceChattingUI$a$3(a aVar) {
        this.ypW = aVar;
        this.xen = ky.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        ky kyVar = (ky) bVar;
        if (kyVar.fCh == null || kyVar.fCh.fnl == null) {
            x.e("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent event is empty");
            return false;
        }
        x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", new Object[]{this.ypW.fAh.field_username, kyVar.fCh.fnl, Integer.valueOf(kyVar.fCh.fCi)});
        if (!kyVar.fCh.fnl.equals(this.ypW.fAh.field_username)) {
            return true;
        }
        a aVar = this.ypW;
        if ((kyVar.fCh.fCi & 2) > 0) {
            z = true;
        }
        a.a(aVar, z);
        this.ypW.getContext().runOnUiThread(new 1(this));
        return true;
    }
}

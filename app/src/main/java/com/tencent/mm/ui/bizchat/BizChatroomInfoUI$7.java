package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class BizChatroomInfoUI$7 implements a {
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$7(BizChatroomInfoUI bizChatroomInfoUI) {
        this.yoK = bizChatroomInfoUI;
    }

    public final void od(int i) {
        BizChatroomInfoUI.a(this.yoK, i);
    }

    public final void oe(int i) {
        boolean z = true;
        j Fm = this.yoK.Fm(i);
        if (Fm == null || bh.ov(Fm.field_profileUrl)) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (Fm != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[]{Fm.field_profileUrl});
        y.Ml();
        h.a(Fm.field_userId, Fm.field_brandUserName, this.yoK);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Fm.field_profileUrl);
        intent.putExtra("useJs", true);
        d.b(this.yoK.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void axM() {
        if (BizChatroomInfoUI.b(this.yoK) != null) {
            BizChatroomInfoUI.b(this.yoK).caZ();
        }
    }

    public final void of(int i) {
        BizChatroomInfoUI.c(this.yoK);
    }
}

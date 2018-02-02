package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.z.ar;

class g$1 implements OnClickListener {
    final /* synthetic */ g zaL;

    g$1(g gVar) {
        this.zaL = gVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("k_username", this.zaL.zaI);
        int i = 39;
        if (this.zaL.ypn) {
            i = 36;
        }
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        if (this.zaL.voC.get() != null) {
            d.b((Context) this.zaL.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
        }
        ar.Hg().FG().il(this.zaL.zaI);
        ar.Hg().FG().il(this.zaL.zaJ);
    }
}

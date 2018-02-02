package com.tencent.mm.plugin.appbrand.share.a;

import android.view.View;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;

class a$2 implements f {
    final /* synthetic */ a jJk;
    final /* synthetic */ WxaShareMessagePage jJl;

    a$2(a aVar, WxaShareMessagePage wxaShareMessagePage) {
        this.jJk = aVar;
        this.jJl = wxaShareMessagePage;
    }

    public final void q(View view, int i) {
        switch (i) {
            case 0:
                this.jJl.jJq.setVisibility(0);
                this.jJl.jJo.setVisibility(4);
                this.jJl.jJp.setVisibility(4);
                this.jJl.jJq.cze();
                return;
            case 1:
                this.jJl.jJq.ajm();
                this.jJl.jJq.setVisibility(4);
                this.jJl.jJo.setVisibility(0);
                this.jJl.jJp.setVisibility(4);
                this.jJl.jJo.setImageResource(i.dyu);
                return;
            case 4:
                this.jJl.jJq.setVisibility(4);
                this.jJl.jJo.setVisibility(4);
                this.jJl.jJp.setVisibility(0);
                return;
            default:
                this.jJl.jJq.ajm();
                this.jJl.jJq.setVisibility(4);
                this.jJl.jJo.setVisibility(0);
                this.jJl.jJp.setVisibility(4);
                this.jJl.jJo.setImageResource(i.dvI);
                return;
        }
    }
}

package com.tencent.mm.ui.chatting;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements a {
    final /* synthetic */ o ysq;

    o$1(o oVar) {
        this.ysq = oVar;
    }

    public final void onError() {
        o.a(this.ysq).reset();
        o.b(this.ysq).TG();
        o.c(this.ysq).TG();
        ae.Vd("keep_app_silent");
        o.d(this.ysq).aJO();
        o.e(this.ysq).ysR.crd();
        x.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        o.f(this.ysq).enableOptionMenu(true);
        o.f(this.ysq).enableBackMenu(true);
        Toast.makeText(o.f(this.ysq).getContext(), o.f(this.ysq).getContext().getString(R.l.dSD), 0).show();
    }
}

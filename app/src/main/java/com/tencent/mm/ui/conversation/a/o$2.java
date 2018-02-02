package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class o$2 implements OnClickListener {
    final /* synthetic */ o zbD;

    o$2(o oVar) {
        this.zbD = oVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        this.zbD.setVisibility(8);
        a.xef.m(new rr());
        x.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
    }
}

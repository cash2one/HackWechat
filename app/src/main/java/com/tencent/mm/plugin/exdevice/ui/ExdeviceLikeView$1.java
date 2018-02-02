package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceLikeView$1 implements OnClickListener {
    final /* synthetic */ ExdeviceLikeView lUL;

    ExdeviceLikeView$1(ExdeviceLikeView exdeviceLikeView) {
        this.lUL = exdeviceLikeView;
    }

    public final void onClick(View view) {
        if (ExdeviceLikeView.a(this.lUL) == null || ExdeviceLikeView.a(this.lUL).aFa() || ExdeviceLikeView.b(this.lUL) != 0) {
            x.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
            return;
        }
        x.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
        this.lUL.pk(ExdeviceLikeView.pl(ExdeviceLikeView.b(this.lUL)));
        if (ExdeviceLikeView.b(this.lUL) == 1) {
            ExdeviceLikeView.c(this.lUL);
        }
        if (ExdeviceLikeView.a(this.lUL) != null) {
            ExdeviceLikeView.a(this.lUL).jl(ExdeviceLikeView.b(this.lUL));
        }
    }
}

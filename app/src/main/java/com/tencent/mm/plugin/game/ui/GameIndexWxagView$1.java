package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.c.ei;
import com.tencent.mm.plugin.game.model.ap;

class GameIndexWxagView$1 implements OnClickListener {
    final /* synthetic */ int nlX;
    final /* synthetic */ GameIndexWxagView nrn;

    GameIndexWxagView$1(GameIndexWxagView gameIndexWxagView, int i) {
        this.nrn = gameIndexWxagView;
        this.nlX = i;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof ei)) {
            ei eiVar = (ei) view.getTag();
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1079;
            ((c) g.h(c.class)).a(this.nrn.getContext(), eiVar.ksU, eiVar.ngo, eiVar.nky, 0, eiVar.nkx, appBrandStatObject);
            ap.a(this.nrn.getContext(), 10, 1025, 999, 30, eiVar.ngo, this.nlX, null);
        }
    }
}

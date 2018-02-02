package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.e;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.h;

class FavSelectUI$4 implements a {
    final /* synthetic */ b mti;
    final /* synthetic */ FavSelectUI mtu;

    FavSelectUI$4(FavSelectUI favSelectUI, b bVar) {
        this.mtu = favSelectUI;
        this.mti = bVar;
    }

    public final void a(boolean z, String str, int i) {
        this.mtu.aWs();
        if (z) {
            e.a(this.mtu.mController.xIM, FavSelectUI.b(this.mtu), str, this.mti.mqC, new 1(this, h.a(this.mtu.mController.xIM, this.mtu.getString(R.l.efz), false, null)));
        }
    }
}

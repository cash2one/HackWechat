package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ d lWt;
    final /* synthetic */ b lWu;

    b$1(b bVar, d dVar) {
        this.lWu = bVar;
        this.lWt = dVar;
    }

    public final void jl(int i) {
        x.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[]{Integer.valueOf(i)});
        if (b.a(this.lWu) != null) {
            b.a(this.lWu).bh(this.lWt.field_username, i);
        }
    }

    public final boolean aFa() {
        if (b.a(this.lWu) != null) {
            return b.a(this.lWu).zt(this.lWt.field_username);
        }
        return true;
    }
}

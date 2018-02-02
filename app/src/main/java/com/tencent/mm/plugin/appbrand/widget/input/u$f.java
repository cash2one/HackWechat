package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.u.b;

final class u$f implements b {
    private u$f() {
    }

    public final void k(u uVar) {
        if (uVar.isShown()) {
            u.a(uVar).setVisibility(0);
        }
        u.a(uVar).anx();
    }

    public final void l(u uVar) {
        if (j.bK(uVar)) {
            uVar.mb(8);
            u.f(uVar);
            return;
        }
        if (uVar.isShown()) {
            u.a(uVar).setVisibility(0);
        }
        if (u.g(uVar)) {
            AppBrandSmileyPanelBase a = u.a(uVar);
            if (a.Iv != null) {
                a.Iv.setVisibility(0);
                return;
            }
            return;
        }
        u.a(uVar).anx();
    }

    public final void c(u uVar, int i) {
        if (j.bK(uVar)) {
            uVar.mb(8);
        } else if (u.a(uVar) != null && i > 0) {
            u.b(uVar, i);
        }
    }

    public final void m(u uVar) {
        u.h(uVar).showVKB();
        u.i(uVar);
    }

    public final void n(u uVar) {
        u.h(uVar).aWs();
        u.j(uVar);
        uVar.lX(com.tencent.mm.compatible.util.j.aQ(u.h(uVar)));
    }
}

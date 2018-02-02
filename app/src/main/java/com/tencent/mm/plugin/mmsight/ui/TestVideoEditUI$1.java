package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.api.d;
import com.tencent.mm.api.l;
import com.tencent.mm.sdk.platformtools.x;

class TestVideoEditUI$1 implements l {
    final /* synthetic */ TestVideoEditUI oDv;

    TestVideoEditUI$1(TestVideoEditUI testVideoEditUI) {
        this.oDv = testVideoEditUI;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[]{dVar.name()});
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar.name(), Integer.valueOf(i)});
    }

    public final void aD(boolean z) {
        if (z) {
            this.oDv.showVKB();
        } else {
            this.oDv.df(TestVideoEditUI.a(this.oDv));
        }
    }
}

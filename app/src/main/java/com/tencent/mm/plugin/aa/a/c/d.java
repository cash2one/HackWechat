package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l iht = new l();
    e ihu = new e();

    protected final void onCreate() {
        super.onCreate();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        com.tencent.mm.ae.e WM = this.iht.WM();
        g.Dk();
        g.Di().gPJ.a(1624, WM);
        g.Dk();
        g.Di().gPJ.a(1655, WM);
        WM = this.ihu.WH();
        x.i("MicroMsg.AAOperationData", "init");
        g.Dk();
        g.Di().gPJ.a(1698, WM);
    }

    protected final void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        com.tencent.mm.ae.e WM = this.iht.WM();
        g.Dk();
        g.Di().gPJ.b(1624, WM);
        g.Dk();
        g.Di().gPJ.b(1655, WM);
        WM = this.ihu.WH();
        x.i("MicroMsg.AAOperationData", "uninit");
        g.Dk();
        g.Di().gPJ.b(1698, WM);
    }
}

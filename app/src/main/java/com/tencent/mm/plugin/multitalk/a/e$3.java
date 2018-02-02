package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.TimerTask;

class e$3 extends TimerTask {
    final /* synthetic */ e oGz;

    e$3(e eVar) {
        this.oGz = eVar;
    }

    public final void run() {
        if (this.oGz.bcw() >= 45000 && this.oGz.oGh != e.Talking) {
            ag.y(new 1(this));
        }
        if (this.oGz.oGh == e.Talking) {
            e eVar = this.oGz;
            eVar.oGk++;
            ag.y(new 2(this));
        }
    }
}

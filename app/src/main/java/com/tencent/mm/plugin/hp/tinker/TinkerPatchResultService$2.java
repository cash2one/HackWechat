package com.tencent.mm.plugin.hp.tinker;

import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.modelmulti.n.a;
import com.tencent.mm.sdk.platformtools.x;

class TinkerPatchResultService$2 implements a {
    final /* synthetic */ TinkerPatchResultService nBj;

    TinkerPatchResultService$2(TinkerPatchResultService tinkerPatchResultService) {
        this.nBj = tinkerPatchResultService;
    }

    public final void bO(boolean z) {
        if (!z) {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "app is background now, i can kill quietly", new Object[0]);
            x.cfl();
            BaseEvent.onDestroy();
            Process.killProcess(Process.myPid());
        }
    }
}

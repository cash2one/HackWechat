package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class UIEntryStub$1 implements a {
    final /* synthetic */ UIEntryStub kuR;

    UIEntryStub$1(UIEntryStub uIEntryStub) {
        this.kuR = uIEntryStub;
    }

    public final void a(e eVar) {
        if (eVar == null) {
            this.kuR.finish();
            return;
        }
        x.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(UIEntryStub.a(this.kuR)));
        if (!UIEntryStub.a(this.kuR)) {
            UIEntryStub.b(this.kuR);
            UIEntryStub.a(this.kuR, UIEntryStub.c(this.kuR).getExtras());
        }
    }
}

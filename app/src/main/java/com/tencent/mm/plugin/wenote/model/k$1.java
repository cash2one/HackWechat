package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ae.h.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k tRs;

    public k$1(k kVar) {
        this.tRs = kVar;
    }

    public final void onError() {
        x.e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
        k.a(this.tRs).TG();
    }
}

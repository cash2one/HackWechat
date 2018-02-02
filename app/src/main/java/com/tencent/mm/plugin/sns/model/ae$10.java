package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.e$a;
import com.tencent.mm.memory.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

class ae$10 extends e$a {
    final /* synthetic */ ae qWL;

    ae$10(ae aeVar, g gVar) {
        this.qWL = aeVar;
        gVar.getClass();
        super(gVar);
    }

    public final /* synthetic */ Comparable Ev() {
        return Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public final long Ew() {
        return 0;
    }

    public final int Ex() {
        return 5;
    }
}

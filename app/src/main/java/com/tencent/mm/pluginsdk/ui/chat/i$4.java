package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.ak.a;

class i$4 implements a {
    final /* synthetic */ i vry;

    i$4(i iVar) {
        this.vry = iVar;
    }

    public final boolean uF() {
        i iVar = this.vry;
        if (iVar.vru != null) {
            iVar.vru.dismiss();
        }
        return false;
    }
}

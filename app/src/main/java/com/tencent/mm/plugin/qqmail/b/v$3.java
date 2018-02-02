package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;

class v$3 implements v$c {
    final /* synthetic */ v ppT;

    v$3(v vVar) {
        this.ppT = vVar;
    }

    public final void bkp() {
        x.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
        this.ppT.va(90);
        v vVar = this.ppT;
        if (vVar.ppL != null && vVar.ppL.size() > 0) {
            vVar.ppL.clear();
        }
        this.ppT.bko();
    }
}

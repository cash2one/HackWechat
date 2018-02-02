package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements Runnable {
    final /* synthetic */ a lFm;
    final /* synthetic */ abz lFn;

    a$8(a aVar, abz com_tencent_mm_protocal_c_abz) {
        this.lFm = aVar;
        this.lFn = com_tencent_mm_protocal_c_abz;
    }

    public final void run() {
        int i = 0;
        if (this.lFn != null) {
            String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.lFn == null ? 0 : this.lFn.wkH);
            if (!(this.lFn == null || this.lFn.vHG == null)) {
                i = this.lFn.vHG.bke();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(this.lFm.aCq());
            x.d(str, str2, objArr);
            i.aBE().lwO.a(this.lFm.aCq(), this.lFn);
        }
    }
}

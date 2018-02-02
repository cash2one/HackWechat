package com.tencent.mm.ag.a;

import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.bh;

class e$2 implements Runnable {
    final /* synthetic */ String hqS;
    final /* synthetic */ String hqV;
    final /* synthetic */ String hqW;

    e$2(String str, String str2, String str3) {
        this.hqV = str;
        this.hqW = str2;
        this.hqS = str3;
    }

    public final void run() {
        c kl = y.Mh().kl(this.hqV);
        if (kl != null) {
            if (kl.field_chatVersion < bh.getInt(this.hqW, Integer.MAX_VALUE)) {
                kl.field_needToUpdate = true;
                y.Mh().b(kl);
            }
            if (kl.Mt()) {
                y.Ml().ah(kl.field_bizChatServId, this.hqS);
            } else {
                y.Ml().ai(kl.field_bizChatServId, this.hqS);
            }
        }
    }
}

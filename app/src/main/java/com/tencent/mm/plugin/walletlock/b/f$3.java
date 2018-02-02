package com.tencent.mm.plugin.walletlock.b;

import com.tencent.mm.g.a.rx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class f$3 extends c<rx> {
    final /* synthetic */ f thn;

    f$3(f fVar) {
        this.thn = fVar;
        this.xen = rx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        avl com_tencent_mm_protocal_c_avl = ((rx) bVar).fJG.fJH;
        g gVar = g.tho;
        g.bNE();
        if (e.b(com_tencent_mm_protocal_c_avl)) {
            x.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_avl.wDe.wJB), Boolean.valueOf(e.b(com_tencent_mm_protocal_c_avl)), Integer.valueOf(com_tencent_mm_protocal_c_avl.wDf), Integer.valueOf(com_tencent_mm_protocal_c_avl.wDd));
            d.a(com_tencent_mm_protocal_c_avl);
        } else {
            x.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
        }
        x.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", Boolean.valueOf(e.bNN()));
        g.Dj().CU().a(a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(r0));
        ((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).init();
        return false;
    }
}

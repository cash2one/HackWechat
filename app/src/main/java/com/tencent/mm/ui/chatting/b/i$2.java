package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.k.g;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;
import com.tenpay.android.wechat.PayuSecureEncrypt;

class i$2 implements a {
    final /* synthetic */ i yzL;

    public i$2(i iVar) {
        this.yzL = iVar;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            String str;
            String str2;
            i iVar = this.yzL;
            String ispId = eVar.getIspId();
            long j = !bh.ov(ispId) ? bh.getLong(ispId, 0) : 0;
            String str3 = "TypingTrigger";
            String str4 = "TypingInterval";
            if (j != 0) {
                str = str3 + "_ISP" + j;
                str2 = str4 + "_ISP" + j;
            } else {
                str2 = str4;
                str = str3;
            }
            str = bh.az(g.zY().getValue(str), PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
            str2 = bh.az(g.zY().getValue(str2), "15");
            iVar.yzJ = bh.getInt(str, 0);
            iVar.hXU = bh.getInt(str2, 0);
            x.i("MicroMsg.DirectScendImp", "ispId: %d, trigger:%d, interval:%d", new Object[]{Long.valueOf(j), Integer.valueOf(iVar.yzJ), Integer.valueOf(iVar.hXU)});
            if (!(iVar.yzJ == -1 || iVar.yzJ == -2 || iVar.yzJ > 0)) {
                iVar.yzJ = 10;
            }
            if (iVar.hXU <= 0) {
                iVar.hXU = 15;
            }
            eVar.setSignallingStrategy((long) (iVar.hXU * 1000), 20000);
        }
    }
}

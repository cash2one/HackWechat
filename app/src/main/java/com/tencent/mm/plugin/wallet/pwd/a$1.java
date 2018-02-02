package com.tencent.mm.plugin.wallet.pwd;

import android.content.Context;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.a.j.1;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$1 extends e {
    final /* synthetic */ a sGp;

    a$1(a aVar, MMActivity mMActivity, g gVar) {
        this.sGp = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof x)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[]{o.bLm().bMn().field_reset_passwd_flag, o.bLm().bMn().field_find_passwd_url});
            if ((o.bLq().bLX() == null ? 0 : o.bLq().bLX().size()) <= 0 && !bh.ov(r2.field_find_passwd_url)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ProcessManager", "hy: no bankcard and do not support add bank card to forget");
                Context context = this.zHU;
                h.a(context, true, context.getString(i.uTT), "", context.getString(i.dFU), context.getString(i.dEn), new 1(context), new j$2(true, context));
            }
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        return false;
    }
}

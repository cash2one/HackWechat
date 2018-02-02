package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class k$1 extends e {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ g sTS;
    final /* synthetic */ k sTT;

    k$1(k kVar, MMActivity mMActivity, g gVar, g gVar2, MMActivity mMActivity2) {
        this.sTT = kVar;
        this.sTS = gVar2;
        this.fgW = mMActivity2;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        if (objArr.length == 2) {
            p pVar = (p) objArr[1];
            pVar.token = k.a(this.sTT);
            x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
            this.sTS.a(new ab(pVar, k.b(this.sTT)), true, 1);
            return true;
        }
        x.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
        return false;
    }

    public final boolean q(Object... objArr) {
        x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
        this.sTS.a(new s(k.c(this.sTT), k.a(this.sTT), '\u0000'), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            if (kVar instanceof ab) {
                x.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
            }
            return false;
        } else if (kVar instanceof ab) {
            x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
            ab abVar = (ab) kVar;
            Bundle bundle = this.sTT.msB;
            bundle.putString("key_jsapi_token", abVar.sIP);
            this.sTT.b(this.fgW, bundle);
            return true;
        } else if (kVar instanceof s) {
            return true;
        } else {
            return false;
        }
    }

    public final CharSequence um(int i) {
        return String.format(this.fgW.getResources().getString(i.uXj), new Object[]{this.sTT.msB.getString("key_mobile")});
    }
}

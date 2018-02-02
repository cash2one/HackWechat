package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.wallet_index.c.h.6;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class h$1 extends c<gw> {
    final /* synthetic */ h tax;

    h$1(h hVar) {
        this.tax = hVar;
        this.xen = gw.class.getName().hashCode();
    }

    private boolean a(gw gwVar) {
        int i = 0;
        this.tax.tas = gwVar;
        String str = this.tax.tas.fxb.result;
        if (this.tax.tas.fxb.fxd != null) {
            this.tax.tar = this.tax.tas.fxb.fxd.getInt("pay_channel", 0);
        }
        switch (this.tax.tas.fxb.actionCode) {
            case 10:
            case 11:
                a.xef.b(this.tax);
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + str);
                if (str == null) {
                    return true;
                }
                if (str.startsWith("weixin://wxpay")) {
                    this.tax.taq = 4;
                    g.Dk();
                    g.Di().gPJ.a(233, this.tax);
                    k lVar = new l(str, this.tax.tas.fxb.username, 4, (int) System.currentTimeMillis(), new byte[0]);
                    g.Dk();
                    g.Di().gPJ.a(lVar, 0);
                    this.tax.tau = System.currentTimeMillis();
                } else {
                    this.tax.taq = 1;
                    h.a(this.tax, str, this.tax.tar);
                }
                return true;
            case 12:
                h hVar = this.tax;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + str);
                String[] split = str.replace("http://p.weixin.qq.com?", "").split("&");
                int length = split.length;
                String str2 = null;
                str = null;
                Object obj = null;
                while (i < length) {
                    String str3 = split[i];
                    if (str3.startsWith("errcode=")) {
                        obj = str3.replace("errcode=", "");
                    } else if (str3.startsWith("errmsg=")) {
                        str = str3.replace("errmsg=", "");
                    } else if (str3.startsWith("importkey=")) {
                        str2 = str3.replace("importkey=", "");
                    }
                    i++;
                }
                if (!"0".equals(obj) || bh.ov(str2)) {
                    if (bh.ov(str)) {
                        str = hVar.tas.fxb.context.getString(a$i.uXa);
                    }
                    h.a(hVar.tas.fxb.context, str, "", new 6(hVar));
                } else {
                    Context context = hVar.tas.fxb.context;
                    Intent intent = new Intent();
                    intent.putExtra("key_import_key", str2);
                    intent.putExtra("key_bind_scene", 2);
                    intent.putExtra("key_custom_bind_tips", null);
                    d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                    if (hVar.tas.fqI != null) {
                        hVar.tas.fxc.ret = 1;
                        hVar.tas.fqI.run();
                    }
                }
                return true;
            default:
                return false;
        }
    }
}

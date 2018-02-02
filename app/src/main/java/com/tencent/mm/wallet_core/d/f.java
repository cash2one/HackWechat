package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;

public final class f {
    public static boolean a(final WalletBaseUI walletBaseUI, k kVar, int i, int i2, String str) {
        boolean z = false;
        if (i == 1000) {
            String string;
            if (bh.ov(str)) {
                string = walletBaseUI.getString(a$i.uXa);
            } else {
                string = str;
            }
            c ag = a.ag(walletBaseUI);
            switch (i2) {
                case -100869:
                    h.a(walletBaseUI, walletBaseUI.getString(a$i.uRz), null, false, new 11(walletBaseUI, i2));
                    z = true;
                    break;
                case -100868:
                    h.a(walletBaseUI, walletBaseUI.getString(a$i.uRA), null, false, new 10(walletBaseUI, i2));
                    z = true;
                    break;
                case 401:
                    int i3;
                    if (kVar instanceof j) {
                        i3 = ((j) kVar).sOf;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.uRL), new 1(walletBaseUI));
                    } else {
                        h.a(walletBaseUI, false, string, "", walletBaseUI.getString(a$i.uRM), walletBaseUI.getString(a$i.dGw), new 4(walletBaseUI), new 5(walletBaseUI));
                    }
                    z = true;
                    break;
                case e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    if (ag != null) {
                        z = ag.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (ag != null) {
                        z = ag.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case 405:
                    if (kVar instanceof j) {
                        z = ((j) kVar).sOf;
                    }
                    if (z) {
                        h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.uRL), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (walletBaseUI.aYf()) {
                                    walletBaseUI.finish();
                                }
                            }
                        });
                    } else {
                        h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.uWk), walletBaseUI.getString(a$i.dEn), new 8(walletBaseUI), null);
                    }
                    z = true;
                    break;
                case JsApiPrivateAddContact.CTRL_INDEX /*407*/:
                    cBJ();
                    if (q.Gf()) {
                        b(walletBaseUI, i2, string);
                    } else {
                        h.a(walletBaseUI, string, null, false, new 6(walletBaseUI, i2));
                    }
                    z = true;
                    break;
                case 412:
                    h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.uXp), walletBaseUI.getString(a$i.dEn), new 9(walletBaseUI), null);
                    z = true;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX /*414*/:
                    cBJ();
                    b(walletBaseUI, i2, string);
                    z = true;
                    break;
            }
        }
        if (kVar instanceof com.tencent.mm.wallet_core.c.h) {
            ((com.tencent.mm.wallet_core.c.h) kVar).zHz = z;
        }
        return z;
    }

    private static void cBJ() {
        k bVar;
        if (q.Gf()) {
            bVar = new b();
        } else {
            bVar = new m();
        }
        g.Dk();
        g.Di().gPJ.a(bVar, 0);
    }

    private static void b(WalletBaseUI walletBaseUI, int i, String str) {
        h.a(walletBaseUI, false, str, "", walletBaseUI.getString(a$i.uRy), walletBaseUI.getString(a$i.dEn), new 2(walletBaseUI), new 3(walletBaseUI, i));
    }
}

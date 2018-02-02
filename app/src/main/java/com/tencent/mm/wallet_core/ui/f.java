package com.tencent.mm.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.m;

public final class f {
    private static String jcD = null;
    private static int lJY = 0;
    private static int lKk = 0;

    static /* synthetic */ void c(WalletBaseUI walletBaseUI) {
        if (lKk == 1000) {
            switch (lJY) {
                case 1:
                    if (!walletBaseUI.aYi()) {
                        walletBaseUI.uD(0);
                    }
                    walletBaseUI.uw(0);
                    break;
                case 3:
                    a.c(walletBaseUI.mController.xIM, walletBaseUI.vf, lJY);
                    break;
                default:
                    if (!walletBaseUI.aYf() && walletBaseUI.cBY() == 0) {
                        walletBaseUI.uw(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.m(walletBaseUI.mController.xIM, lJY);
        lKk = 0;
        lJY = 0;
        jcD = null;
    }

    public static void a(WalletBaseUI walletBaseUI, int i, int i2, String str, k kVar, boolean z) {
        boolean bhd;
        boolean z2;
        boolean z3 = true;
        if (bh.ov(str)) {
            str = walletBaseUI.getString(a$i.uXa);
        }
        if (kVar instanceof h) {
            bhd = ((h) kVar).bhd();
        } else {
            bhd = true;
        }
        if (kVar instanceof com.tencent.mm.wallet_core.c.f) {
            z2 = ((com.tencent.mm.wallet_core.c.f) kVar).fHt;
        } else {
            z2 = bhd;
        }
        x.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), kVar});
        if (!((kVar instanceof m) || (kVar instanceof b))) {
            if (kVar instanceof h) {
                h hVar = (h) kVar;
                Bundle bundle;
                if (hVar.zHs == null ? false : "1".equals(hVar.zHs.trim())) {
                    x.d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    bundle = walletBaseUI.vf;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", hVar.zHt);
                    bundle.putString("intent_wap_pay_jump_url", hVar.zHu);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                } else if ((kVar instanceof l) && ((l) kVar).sFA) {
                    x.i("MicroMsg.WalletDispatcher", "delay order pay end");
                    bundle = walletBaseUI.vf;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", hVar.zHt);
                    bundle.putString("intent_wap_pay_jump_url", hVar.zHu);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                }
                if (z2 && com.tencent.mm.wallet_core.d.f.a(walletBaseUI, kVar, i, i2, str)) {
                    bhd = false;
                } else {
                    bhd = true;
                }
                if (!bhd) {
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.cCc() == null || !walletBaseUI.cCd().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, (h) kVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        x.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        lKk = i;
                        lJY = i2;
                        jcD = str;
                        x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if ((walletBaseUI.cCc() == null || !walletBaseUI.cCd().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, kVar) && z2) {
                if (i == 0 && i2 == 0) {
                    x.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    lKk = i;
                    lJY = i2;
                    jcD = str;
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            x.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[]{Boolean.valueOf(z2)});
            if (lJY != 0) {
                x.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lJY);
                if (kVar instanceof h) {
                    String cBp = ((h) kVar).cBp();
                    if (!bh.ov(cBp)) {
                        x.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xIM, jcD, null, walletBaseUI.getResources().getString(a$i.uRv), walletBaseUI.getResources().getString(a$i.dFU), true, new 2(walletBaseUI, cBp), new 3(walletBaseUI));
                        cCa();
                        e.HF(4);
                        if (z3) {
                            x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                            com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xIM, jcD, null, false, new 1(walletBaseUI));
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                    com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xIM, jcD, null, false, new 1(walletBaseUI));
                }
            } else if (!walletBaseUI.aYi()) {
                walletBaseUI.uD(0);
            }
        }
    }

    public static void cCa() {
        lKk = 0;
        lJY = 0;
        jcD = null;
    }
}

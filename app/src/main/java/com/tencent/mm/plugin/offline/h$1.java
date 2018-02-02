package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.g.6;

class h$1 extends e {
    final /* synthetic */ h oVH;

    h$1(h hVar, MMActivity mMActivity, g gVar) {
        this.oVH = hVar;
        super(mMActivity, gVar);
    }

    public final /* synthetic */ CharSequence um(int i) {
        switch (i) {
            case 0:
                return this.zHU.getString(i.uQW);
            case 1:
                return this.zHU.getString(i.uQV);
            default:
                return "";
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                x.i("MicroMsg.OfflineProcess", "Offline is Create ");
                bgV();
                h.a(this.oVH).putBoolean("is_offline_create", true);
            } else if (kVar instanceof n) {
                x.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                g gVar = this.zHV;
                if (gVar.ilS == null || !(gVar.ilS == null || gVar.ilS.isShowing())) {
                    if (gVar.ilS != null) {
                        gVar.ilS.dismiss();
                    }
                    if (gVar.mContext == null) {
                        x.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                    } else {
                        gVar.ilS = com.tencent.mm.wallet_core.ui.g.a(gVar.mContext, false, new 6(gVar));
                    }
                }
                b suVar = new su();
                suVar.fKE.scene = 8;
                suVar.fKF.fKz = new 1(this);
                a.xef.m(suVar);
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.i) {
                com.tencent.mm.plugin.offline.a.i iVar = (com.tencent.mm.plugin.offline.a.i) kVar;
                if ("1".equals(iVar.oWz)) {
                    Activity activity = this.zHU;
                    String str2 = iVar.fAf;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key_authen", new Authen());
                    bundle.putString("key_pwd1", h.j(this.oVH).getString("key_pwd1"));
                    bundle.putString("key_mobile", str2);
                    bundle.putInt("verify_scene", 1);
                    bundle.putInt("offline_add_fee", h.k(this.oVH).getInt("offline_chg_fee", 0));
                    com.tencent.mm.wallet_core.a.a(activity, l.class, bundle);
                    this.oVH.a(activity, 0, h.l(this.oVH));
                } else {
                    h.c(this.oVH).putBoolean("back_to_coin_purse_ui", true);
                    bgV();
                }
            } else if (kVar instanceof p) {
                com.tencent.mm.plugin.offline.c.a.GT("");
                k.bgX();
                k.bgY().oXc = null;
                this.oVH.a(this.zHU, 0, h.d(this.oVH));
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.k)) {
            return false;
        } else {
            x.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
            com.tencent.mm.plugin.offline.a.k kVar2 = (com.tencent.mm.plugin.offline.a.k) kVar;
            if (i2 != JsApiBatchGetContact.CTRL_INDEX) {
                return false;
            }
            Context context = this.zHU;
            String str3 = str;
            h.a(context, str3, "", context.getString(i.uUs), context.getString(i.dEn), new 2(this, context, kVar2.oWN), new 3(this, context));
            return true;
        }
    }

    public final boolean k(Object... objArr) {
        String str = (String) objArr[0];
        h.e(this.oVH).putString("key_pwd1", str);
        Bankcard bhK = com.tencent.mm.plugin.offline.c.a.bhK();
        if (bhK == null) {
            x.e("MicroMsg.OfflineProcess", "no support bank car for offline");
            bhK = com.tencent.mm.plugin.offline.c.a.bhL();
        }
        if (bhK == null) {
            x.e("MicroMsg.OfflineProcess", "no any bank car for offline");
            return false;
        }
        String string = h.f(this.oVH).getString("oper");
        if (!com.tencent.mm.plugin.offline.c.a.bhH()) {
            x.i("MicroMsg.OfflineProcess", "Offline is not Create ");
            this.zHV.a(new com.tencent.mm.plugin.offline.a.k(bhK, (String) objArr[0], h.g(this.oVH).getInt("offline_chg_fee", 0)), true, 1);
        } else if (string != null) {
            x.i("MicroMsg.OfflineProcess", "oper == " + string);
            if (string.equals("create")) {
                this.zHV.a(new com.tencent.mm.plugin.offline.a.k(bhK, (String) objArr[0], h.h(this.oVH).getInt("offline_chg_fee", 0)), true, 1);
            } else if (string.equals("clr")) {
                this.zHV.a(new com.tencent.mm.plugin.offline.a.i(bhK, str, "clr", 0, ""), true, 1);
            } else if (string.equals("changeto")) {
                this.zHV.a(new com.tencent.mm.plugin.offline.a.i(bhK, str, "changeto", h.i(this.oVH).getInt("offline_chg_fee"), ""), true, 1);
            } else if (!string.equals("freeze")) {
                return false;
            } else {
                this.zHV.a(new p(str), true, 1);
            }
        }
        return true;
    }

    private void bgV() {
        this.zHV.a(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.oZq), false, 1);
    }
}

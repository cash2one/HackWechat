package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String oWp;
    private Orders sEs;
    protected b.a sUI = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (boa()) {
            this.sEs = bMF();
            this.oWp = this.vf.getString("key_trans_id");
            int i = this.vf.getInt("key_pay_type", -1);
            x.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[]{this.oWp});
            if (this.oWp != null) {
                if (i == -1) {
                    No(this.oWp);
                } else {
                    cr(this.oWp, i);
                }
            } else if (this.sEs != null) {
                d(this.sEs);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sEs != null && !bh.ov(this.sEs.username)) {
            ak.a.hfL.hK(this.sEs.username);
        }
    }

    protected boolean boa() {
        return true;
    }

    public Orders bMF() {
        return (Orders) this.vf.getParcelable("key_orders");
    }

    protected int getLayoutId() {
        return g.uEl;
    }

    public void No(String str) {
        l(new y(str));
    }

    protected void cr(String str, int i) {
        l(new y(str, i));
    }

    private void d(Orders orders) {
        x.k("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[]{Integer.valueOf(orders.sOg)});
        if (orders.sOg == 1) {
            cCc().c(this, WalletOrderInfoNewUI.class, this.vf);
        } else {
            cCc().c(this, WalletOrderInfoOldUI.class, this.vf);
        }
        finish();
    }

    protected void K(com.tencent.mm.storage.x xVar) {
        if (xVar != null && ((int) xVar.gJd) != 0) {
            String AP = xVar.AP();
            x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + AP + " username: " + xVar.field_username);
            if (this.sEs.sNW != null && this.sEs.sNW.size() > 0) {
                for (Commodity commodity : this.sEs.sNW) {
                    commodity.paA = AP;
                }
            }
        }
    }

    protected static String d(String str, String str2, String str3, String str4, String str5) {
        try {
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                return str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
            } else if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                return str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                return str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
            return str;
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof y) || i != 0 || i2 != 0) {
            return false;
        }
        this.sEs = ((y) kVar).sIO;
        if (this.sEs != null) {
            if (!(this.sEs.sNW == null || this.sEs.sNW.size() == 0)) {
                Commodity commodity = (Commodity) this.sEs.sNW.get(0);
                this.oWp = commodity.fuI;
                x.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.l.a WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(commodity.paA);
                if (WO == null || ((int) WO.gJd) == 0) {
                    ak.a.hfL.a(commodity.paA, "", this.sUI);
                } else {
                    K(WO);
                }
            }
            d(this.sEs);
        } else {
            x.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
            com.tencent.mm.ui.base.h.a(this.mController.xIM, i.uTp, 0, new 2(this));
        }
        return true;
    }
}

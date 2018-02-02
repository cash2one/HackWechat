package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderDetailInfoUI$1 implements OnClickListener {
    final /* synthetic */ MallOrderDetailInfoUI pcg;

    MallOrderDetailInfoUI$1(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        this.pcg = mallOrderDetailInfoUI;
    }

    public final void onClick(View view) {
        if (view.getId() == f.usn) {
            if (this.pcg.pbg.oZW != null) {
                c.at(this.pcg, this.pcg.pbg.oZW.nfg);
                MallOrderDetailInfoUI.a(this.pcg, this.pcg.pbg.oZW.pae);
            }
        } else if (view.getId() == f.usB || view.getId() == f.usA) {
            if (this.pcg.pbg.oZX != null && this.pcg.pbg.oZX.size() > 0) {
                boolean z;
                if (TextUtils.isEmpty(((ProductSectionItem) this.pcg.pbg.oZX.get(0)).jumpUrl)) {
                    z = false;
                } else {
                    z = c.at(this.pcg, ((ProductSectionItem) this.pcg.pbg.oZX.get(0)).jumpUrl);
                }
                if (!z) {
                    c.au(this.pcg, ((ProductSectionItem) this.pcg.pbg.oZX.get(0)).pbO);
                }
                MallOrderDetailInfoUI.a(this.pcg, ((ProductSectionItem) this.pcg.pbg.oZX.get(0)).name);
            }
        } else if (view.getId() == f.usz) {
            Bundle bundle = this.pcg.vf;
            bundle.putParcelableArrayList("order_product_list", this.pcg.pbg.oZX);
            bundle.putInt("key_enter_id", 0);
            bundle.putString("key_trans_id", MallOrderDetailInfoUI.a(this.pcg));
            bundle.putString("appname", this.pcg.pbg.fvL);
            a.j(this.pcg, new Bundle());
            MallOrderDetailInfoUI.a(this.pcg, this.pcg.getResources().getString(a$i.uLp));
        } else if (view.getId() == f.usI) {
            String string = this.pcg.vf.getString("key_trans_id");
            Bundle bundle2 = this.pcg.vf;
            bundle2.putString("key_trans_id", string);
            bundle2.putInt("key_enter_id", 1);
            if (this.pcg.pbg != null) {
                bundle2.putParcelable("transaction_data", this.pcg.pbg.oZV);
            }
            a.j(this.pcg, bundle2);
            MallOrderDetailInfoUI.a(this.pcg, this.pcg.getResources().getString(a$i.uLo));
        } else if (view.getId() == f.usj) {
            MallOrderDetailInfoUI.b(this.pcg);
        } else if (view.getId() == f.ukR) {
            if (this.pcg.pbg != null && this.pcg.pbg.pac != null) {
                this.pcg.pbR = this.pcg.pbg.pac;
                MallOrderDetailInfoUI.c(this.pcg);
                MallOrderDetailInfoUI.a(this.pcg, this.pcg.getResources().getString(a$i.uLn));
            }
        } else if (view.getId() == f.uAM) {
            e.T(this.pcg, this.pcg.pbg.fvL);
            MallOrderDetailInfoUI.a(this.pcg, this.pcg.getResources().getString(a$i.uLt));
        }
    }
}

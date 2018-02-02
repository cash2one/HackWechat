package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f jKn;
    private int pcE;
    private MallTransactionObject pcF = null;
    private c pcG;

    public void onCreate(Bundle bundle) {
        String string;
        String str = null;
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c ag = a.ag(this);
        if (ag != null && (ag instanceof com.tencent.mm.plugin.order.a.a)) {
            string = biK().getString("key_trans_id");
            str = biK().getString("bill_id");
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            string = getIntent().getStringExtra("trans_id");
            str = getIntent().getStringExtra("bill_id");
        } else {
            string = null;
        }
        if (bh.ov(string)) {
            x.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            h.a(this.mController.xIM, a$i.uTp, 0, new 1(this));
        }
        this.pcE = biK().getInt("key_pay_type");
        initView();
        cCh().a(new com.tencent.mm.plugin.order.model.h(string, str), true, 1);
    }

    protected final void initView() {
        setMMTitle(a$i.uLm);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallOrderTransactionInfoUI pcH;

            {
                this.pcH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pcH.finish();
                return false;
            }
        });
        this.jKn = this.yjd;
        this.pcG = new c(this);
        this.pcG.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pcG != null) {
            this.pcG.release();
        }
    }

    protected final int getLayoutId() {
        return a$g.uDg;
    }

    public final int XB() {
        return l.vaq;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) kVar).pbg;
            if (mallOrderDetailObject != null) {
                List list;
                this.pcF = mallOrderDetailObject.oZV;
                this.jKn.removeAll();
                Context context = this.mController.xIM;
                f fVar = this.jKn;
                MallTransactionObject mallTransactionObject = this.pcF;
                Object[] objArr = new Object[]{this.pcG};
                if (mallTransactionObject == null) {
                    list = null;
                } else {
                    com.tencent.mm.plugin.order.model.a.a bVar;
                    switch (mallTransactionObject.pak) {
                        case 21:
                            bVar = new b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).pcG = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    list = bVar.a(context, fVar, mallTransactionObject);
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.jKn.a((Preference) list.get(i3));
                    }
                }
                this.jKn.notifyDataSetChanged();
            }
        }
        return true;
    }

    private Bundle biK() {
        Bundle af = a.af(this);
        if (af == null) {
            return new Bundle();
        }
        return af;
    }
}

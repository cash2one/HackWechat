package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.f;
import java.util.ArrayList;

public final class a extends f {
    public final /* synthetic */ Object getItem(int i) {
        return zc(i);
    }

    public a(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        super(context, arrayList, i, orders);
    }

    public final int getCount() {
        return (this.szk == null || this.szk.size() == 0) ? 1 : this.szk.size();
    }

    public final Bankcard zc(int i) {
        if (this.szk != null && this.szk.size() != 0) {
            return (Bankcard) this.szk.get(i);
        }
        if (i != getCount() - 1) {
            return (Bankcard) this.szk.get(i);
        }
        return null;
    }
}

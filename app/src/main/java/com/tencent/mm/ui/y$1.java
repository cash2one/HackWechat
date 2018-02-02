package com.tencent.mm.ui;

import com.tencent.mm.s.a$a;
import com.tencent.mm.storage.w.a;

class y$1 implements a$a {
    final /* synthetic */ y xKX;

    y$1(y yVar) {
        this.xKX = yVar;
    }

    public final void ge(int i) {
        if (i == 262145 || i == 266260 || i == 262157 || i == 266267 || i == 262158) {
            y.a(this.xKX);
            y.b(this.xKX);
        } else if (i == 262147) {
            y.c(this.xKX);
        } else if (i == 262156) {
            y.d(this.xKX);
        } else if (i == 262152) {
            y.e(this.xKX);
        }
        y.f(this.xKX).notifyDataSetChanged();
    }

    public final void gf(int i) {
    }

    public final void b(a aVar) {
        if (aVar == a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
            y.e(this.xKX);
        } else if (aVar == a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
            y.e(this.xKX);
        } else if (aVar == a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC) {
            y.d(this.xKX);
        } else if (aVar == a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
            y.a(this.xKX);
        }
        y.f(this.xKX).notifyDataSetChanged();
    }
}

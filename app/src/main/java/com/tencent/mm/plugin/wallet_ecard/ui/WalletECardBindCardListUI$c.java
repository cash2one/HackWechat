package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.b;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.d;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ey;

class WalletECardBindCardListUI$c extends BaseAdapter {
    final /* synthetic */ WalletECardBindCardListUI sZK;
    public final int sZL;
    public final int sZM;

    private WalletECardBindCardListUI$c(WalletECardBindCardListUI walletECardBindCardListUI) {
        this.sZK = walletECardBindCardListUI;
        this.sZL = 0;
        this.sZM = 1;
    }

    public final int getCount() {
        return WalletECardBindCardListUI.b(this.sZK).size() + 1;
    }

    public final Object getItem(int i) {
        if (i < WalletECardBindCardListUI.b(this.sZK).size()) {
            return WalletECardBindCardListUI.b(this.sZK).get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (i >= WalletECardBindCardListUI.b(this.sZK).size()) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean isEnabled(int i) {
        ey eyVar = (ey) getItem(i);
        if (eyVar == null) {
            return super.isEnabled(i);
        }
        if (eyVar.vKL) {
            return false;
        }
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.sZK.mController.xIM).inflate(g.uBK, viewGroup, false);
                view.setTag(new a(this.sZK, view));
            }
            ((a) view.getTag()).jVy.setText(i.uIV);
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.sZK.mController.xIM).inflate(g.uBJ, viewGroup, false);
                view.setTag(new d(this.sZK, view));
            }
            ((b) view.getTag()).a(view, (ey) getItem(i));
        }
        return view;
    }
}

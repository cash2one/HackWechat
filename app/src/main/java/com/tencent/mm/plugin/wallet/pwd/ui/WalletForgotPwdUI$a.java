package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.List;

public class WalletForgotPwdUI$a extends BaseAdapter {
    private Context context;
    List<Bankcard> hiv = new ArrayList();
    final /* synthetic */ WalletForgotPwdUI sGW;

    public final /* synthetic */ Object getItem(int i) {
        return zc(i);
    }

    public WalletForgotPwdUI$a(WalletForgotPwdUI walletForgotPwdUI, Context context) {
        this.sGW = walletForgotPwdUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (WalletFormView) View.inflate(this.context, g.uEu, null);
        } else {
            WalletFormView walletFormView = (WalletFormView) view;
        }
        final Bankcard zc = zc(i);
        if (zc != null) {
            view.setText(((Bankcard) this.hiv.get(i)).field_desc);
        }
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI$a sGX;

            public final void onClick(View view) {
                WalletForgotPwdUI.a(this.sGX.sGW, zc);
                WalletForgotPwdUI.a(this.sGX.sGW, false);
                WalletForgotPwdUI.a(this.sGX.sGW);
            }
        });
        return view;
    }

    public final int getCount() {
        return this.hiv.size();
    }

    private Bankcard zc(int i) {
        if (i < 0 || i > this.hiv.size() - 1) {
            return null;
        }
        return (Bankcard) this.hiv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}

package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class b extends m {
    private b tcZ;
    private int tda = 0;
    private boolean tdb = false;
    private a tdc;

    static class AnonymousClass1 extends b {
        final /* synthetic */ a tdd;

        AnonymousClass1(Context context, int i, a aVar) {
            this.tdd = aVar;
            super(context);
        }

        public final int bMM() {
            int i = 3;
            if (this.tdd.tdf != null && this.tdd.tdf.field_bankcardClientType == 1) {
                x.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.tdd.tdf).sQS;
            }
            if (i != 4) {
                return g.uDm;
            }
            x.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
            return g.uDl;
        }
    }

    public b(Context context) {
        super(context);
    }

    protected final void cd(Context context) {
        dJ(context);
        super.dK(context);
        if (this.sVJ != null) {
            this.sVJ.setVisibility(8);
        }
    }

    protected final void dK(Context context) {
        super.dK(context);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        String aM;
        List bMo;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        boolean z2;
        a a = com.tencent.mm.plugin.wallet_core.ui.b.sRa.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.sMV))) {
                    aM = a.aM(favorPayInfo.sMT, false);
                    a.a aVar = (a.a) a.aL(aM, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.sQX == null || bh.ov(aVar.sQX.sDE)) {
                        favorPayInfo.sMT = aM;
                    } else {
                        favorPayInfo.sMT = aVar.sQX.sDE;
                    }
                }
            } else if (orders.sNX != null) {
                favorPayInfo = a.Nl(a.Nm(orders.sNX.sDq));
            }
            bMo = a.bMo();
        } else {
            x.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            bMo = null;
        }
        Commodity commodity = (Commodity) orders.sNW.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (bh.ov(commodity.pao)) {
            str = "";
        } else {
            str = commodity.pao + "\n";
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.sNW.get(0)).desc).toString();
        if (a == null || favorPayInfo == null) {
            str2 = null;
            str3 = null;
            charSequence = null;
            z2 = false;
        } else {
            h Ni = a.Ni(favorPayInfo.sMT);
            if (Ni != null && Ni.sDF > 0.0d) {
                String d = e.d(orders.pNX, orders.paz);
                String d2 = e.d(Ni.sDp, orders.paz);
                aM = context.getString(i.uUN, new Object[]{e.t(Ni.sDF)});
                str3 = d2;
                str2 = d;
                z2 = true;
                charSequence = aM;
            } else if (bMo == null || bMo.size() <= 0) {
                charSequence = null;
                str2 = null;
                str3 = e.d(orders.pNX, orders.paz);
                z2 = false;
            } else {
                z2 = true;
                str2 = null;
                str3 = null;
                Object string = context.getString(i.uVr);
            }
        }
        if (bankcard == null) {
            str = "";
        } else {
            str = bankcard.field_desc;
        }
        Dialog bVar2 = new b(context);
        bVar2.sVI = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.bMN();
        bVar2.a(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.Np(stringBuilder2);
        bVar2.Nq(str3);
        bVar2.Ns(str2);
        bVar2.a(str, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence)) {
            bVar2.sVt.setVisibility(8);
        } else {
            bVar2.sVt.setVisibility(0);
            bVar2.sVt.setText(charSequence);
        }
        bVar2.tdb = z;
        bVar2.sVu.zJB = -10;
        bVar2.tcZ = bVar;
        bVar2.show();
        com.tencent.mm.ui.base.h.a(context, bVar2);
        return bVar2;
    }

    protected final void bMO() {
        if (this.sVF != null) {
            this.sVF.onClick(this, 0);
        }
        dismiss();
        if (this.tcZ == null) {
            return;
        }
        if (!this.tdb) {
            this.tcZ.a(this.sVu.getText(), "", this.sEQ);
        } else if (this.tda == 0) {
            Context context = getContext();
            a aVar = new a(this, this.sVu.getText(), this.sVI, this.sEQ, this.sVG, this.Gj, this.sVE, this.tcZ);
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                Dialog anonymousClass1 = new AnonymousClass1(context, j.uYC, aVar);
                anonymousClass1.tda = 1;
                anonymousClass1.tdb = true;
                anonymousClass1.tdc = aVar;
                if (anonymousClass1.tdc != null) {
                    anonymousClass1.bMN();
                    anonymousClass1.a(anonymousClass1.tdc.tdj);
                    anonymousClass1.setOnCancelListener(anonymousClass1.tdc.tdj);
                    anonymousClass1.setCancelable(true);
                    anonymousClass1.Nq(anonymousClass1.tdc.tdf == null ? "" : anonymousClass1.tdc.tdf.field_desc);
                    anonymousClass1.jP(false);
                    anonymousClass1.sVE = anonymousClass1.tdc.sVE;
                    anonymousClass1.tcZ = anonymousClass1.tdc.tdi;
                    anonymousClass1.sVu.zJB = 30;
                    anonymousClass1.show();
                    com.tencent.mm.ui.base.h.a(context, anonymousClass1);
                }
            }
        } else if (this.tda == 1) {
            this.tcZ.a(this.tdc.tde, this.sVu.getText(), this.tdc.tdg);
        } else {
            x.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        }
    }
}

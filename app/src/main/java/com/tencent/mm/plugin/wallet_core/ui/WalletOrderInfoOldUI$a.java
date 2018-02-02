package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.util.List;

public class WalletOrderInfoOldUI$a extends BaseAdapter {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    public WalletOrderInfoOldUI$a(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return zq(i);
    }

    public final int getCount() {
        return this.sUK.sTV != null ? this.sUK.sTV.size() : 0;
    }

    private Commodity zq(int i) {
        return (Commodity) this.sUK.sTV.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.sUK, g.uFv, null);
            a aVar2 = new a(this);
            aVar2.sUN = (TextView) view.findViewById(f.uzh);
            aVar2.iir = (TextView) view.findViewById(f.uzl);
            aVar2.sUQ = (TextView) view.findViewById(f.uzD);
            aVar2.sUO = (TextView) view.findViewById(f.uzI);
            aVar2.sUP = (TextView) view.findViewById(f.uzw);
            aVar2.sUP.getPaint().setFlags(16);
            aVar2.sUR = (TextView) view.findViewById(f.uzJ);
            aVar2.sUS = (TextView) view.findViewById(f.uzk);
            aVar2.sUT = (TextView) view.findViewById(f.uzg);
            aVar2.sUV = (MaxListView) view.findViewById(f.uzy);
            aVar2.sUW = view.findViewById(f.uzo);
            aVar2.sUU = view.findViewById(f.uzB);
            aVar2.sUY = (TextView) view.findViewById(f.uzK);
            aVar2.sUX = (TextView) view.findViewById(f.uzL);
            aVar2.sUZ = (TextView) view.findViewById(f.uzM);
            aVar2.sVa = (TextView) view.findViewById(f.uzN);
            aVar2.sVc = (ViewGroup) view.findViewById(f.uzF);
            aVar2.sRH = (CdnImageView) view.findViewById(f.uwZ);
            aVar2.sRI = (TextView) view.findViewById(f.uwV);
            aVar2.sRJ = (TextView) view.findViewById(f.uxa);
            aVar2.sVb = view.findViewById(f.uzC);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Commodity zq = zq(i);
        if (!(zq == null || aVar == null)) {
            CharSequence string;
            WalletOrderInfoOldUI.a(this.sUK, zq.fuI);
            aVar.sUO.setText(e.d(zq.ljg, zq.paz));
            if (zq.sOk < 0.0d || zq.ljg >= zq.sOk) {
                aVar.sUP.setVisibility(8);
            } else {
                aVar.sUP.setText(e.d(zq.sOk, zq.paz));
                aVar.sUP.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) aVar.sUW;
            List list = zq.sOn;
            linearLayout.removeAllViews();
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                    View textView = new TextView(this.sUK.mController.xIM);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = this.sUK.mController.xIM.getResources().getDimensionPixelOffset(d.buo);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextAppearance(this.sUK.mController.xIM, j.uYz);
                    if (discountInfo.sOz > 0.0d) {
                        textView.setText(discountInfo.pKc + e.d(discountInfo.sOz / 100.0d, this.sUK.sEs.paz));
                    } else {
                        textView.setText(discountInfo.pKc);
                    }
                    linearLayout.addView(textView);
                    textView.setTextColor(this.sUK.getResources().getColor(c.uby));
                }
            }
            if (linearLayout.getChildCount() > 0) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
            TextView textView2 = aVar.sUN;
            Context context = this.sUK;
            if (q.Gf()) {
                string = context.getString(i.uTA);
            } else {
                string = context.getString(i.uTz);
            }
            textView2.setText(string);
            aVar.sUQ.setText(zq.pao);
            aVar.iir.setText(zq.desc);
            aVar.iir.setTag(zq.desc);
            aVar.iir.setOnLongClickListener(WalletOrderInfoOldUI.a(this.sUK));
            aVar.iir.setBackgroundResource(a.e.udU);
            aVar.sUR.setText(zq.fuI);
            aVar.sUR.setTag(zq.fuI);
            aVar.sUR.setOnLongClickListener(WalletOrderInfoOldUI.a(this.sUK));
            aVar.sUR.setBackgroundResource(a.e.udU);
            aVar.sUS.setText(e.HD(zq.pav));
            aVar.sUT.setText(zq.pax);
            string = zq.sOo;
            if (aVar.sUZ != null) {
                if (bh.ov(string)) {
                    aVar.sVa.setVisibility(8);
                    aVar.sUZ.setVisibility(8);
                } else {
                    aVar.sUZ.setText(string);
                    aVar.sUZ.setVisibility(0);
                    aVar.sVa.setVisibility(0);
                }
            }
            string = zq.sOq;
            if (aVar.sUY != null) {
                if (bh.ov(string)) {
                    aVar.sUX.setVisibility(8);
                    aVar.sUY.setVisibility(8);
                } else {
                    aVar.sUY.setText(string);
                    aVar.sUY.setVisibility(0);
                    aVar.sUX.setVisibility(0);
                }
            }
            if (zq.sOs.size() > 0) {
                Promotions promotions = (Promotions) zq.sOs.get(0);
                com.tencent.mm.plugin.report.service.g.pQN.h(13033, new Object[]{Integer.valueOf(1), promotions.paA, promotions.url, promotions.name, WalletOrderInfoOldUI.b(this.sUK)});
                this.sUK.sUE = new WalletOrderInfoOldUI.c(this.sUK, zq.sOs);
                aVar.sUV.setAdapter(this.sUK.sUE);
                aVar.sUV.setOnItemClickListener(new 1(this));
                this.sUK.sUE.notifyDataSetChanged();
                aVar.sUV.setVisibility(0);
                aVar.sUU.setVisibility(0);
            } else {
                aVar.sUV.setVisibility(8);
                aVar.sVc.setVisibility(8);
                aVar.sUU.setVisibility(8);
            }
            if (zq.sOr == null || bh.ov(zq.sOr.sAb)) {
                aVar.sVc.setVisibility(8);
                aVar.sVb.setVisibility(8);
            } else {
                aVar.sRH.setUrl(zq.sOr.sNA);
                aVar.sRI.setText(zq.sOr.sNB);
                aVar.sRJ.setText(zq.sOr.sNz);
                aVar.sVc.setOnClickListener(new 2(this, zq));
                aVar.sVb.setVisibility(0);
            }
        }
        return view;
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

class WalletOrderInfoOldUI$c extends BaseAdapter {
    protected List<Promotions> sOs;
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    public final /* synthetic */ Object getItem(int i) {
        return zr(i);
    }

    public WalletOrderInfoOldUI$c(WalletOrderInfoOldUI walletOrderInfoOldUI, List<Promotions> list) {
        this.sUK = walletOrderInfoOldUI;
        this.sOs = null;
        this.sOs = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Promotions promotions = (Promotions) list.get(i);
            if (promotions != null && (!bh.ov(promotions.paA) || promotions.sOB == 2 || promotions.sOB == 1)) {
                this.sOs.add(list.get(i));
            }
        }
    }

    public final int getCount() {
        return this.sOs != null ? this.sOs.size() : 0;
    }

    public final Promotions zr(int i) {
        return (Promotions) this.sOs.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        String fg;
        a aVar;
        Promotions zr = zr(i);
        if (bh.ov(zr.paA) && zr.sIr > 0) {
            fg = this.sUK.fg(zr.sIr);
            g gVar = g.pQN;
            Object[] objArr = new Object[6];
            objArr[0] = WalletOrderInfoOldUI.b(this.sUK);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(zr.sOB);
            if ("-1".equals(fg)) {
                fg = Integer.valueOf(5);
            }
            objArr[3] = fg;
            objArr[4] = Long.valueOf(zr.sIr);
            objArr[5] = Long.valueOf(zr.sNw);
            gVar.h(13471, objArr);
        }
        a aVar2;
        View inflate;
        View view2;
        if (view == null) {
            aVar2 = new a(this);
            aVar2.type = zr.type;
            if (zr.type == Orders.sOj) {
                if (zr.sOA == 1) {
                    inflate = View.inflate(this.sUK, a.g.uFw, null);
                    aVar2.sVd = (CdnImageView) inflate.findViewById(f.uzt);
                    aVar2.ihS = (TextView) inflate.findViewById(f.uzG);
                    aVar2.sVe = (TextView) inflate.findViewById(f.uzj);
                    aVar2.inw = (TextView) inflate.findViewById(f.uzv);
                    if (!TextUtils.isEmpty(zr.url)) {
                        this.sUK.sUD.put(zr.url, aVar2.sVe);
                    }
                    inflate.setTag(aVar2);
                    view2 = inflate;
                } else {
                    inflate = View.inflate(this.sUK, a.g.uFx, null);
                    aVar2.sVd = (CdnImageView) inflate.findViewById(f.uzt);
                    aVar2.sVe = (TextView) inflate.findViewById(f.uzj);
                    aVar2.inw = (TextView) inflate.findViewById(f.uzv);
                    aVar2.ihS = (TextView) inflate.findViewById(f.uzG);
                    if (!TextUtils.isEmpty(zr.url)) {
                        this.sUK.sUD.put(zr.url, aVar2.sVe);
                    }
                    inflate.setTag(aVar2);
                    view2 = inflate;
                }
                aVar2.sOA = zr.sOA;
                view = view2;
                aVar = aVar2;
            } else {
                view = View.inflate(this.sUK, a.g.uFy, null);
                aVar2.sVd = (CdnImageView) view.findViewById(f.uzt);
                aVar2.sVe = (TextView) view.findViewById(f.uzj);
                aVar2.inw = (TextView) view.findViewById(f.uzv);
                aVar2.sVf = (CheckBox) view.findViewById(f.uex);
                if (!TextUtils.isEmpty(zr.url)) {
                    this.sUK.sUD.put(zr.url, aVar2.sVe);
                }
                view.setTag(aVar2);
                aVar = aVar2;
            }
        } else {
            a aVar3 = (a) view.getTag();
            Object obj = null;
            if (zr.type == aVar3.type && (zr.type != Orders.sOj || zr.sOA == aVar3.sOA)) {
                obj = 1;
            }
            if (obj == null) {
                aVar2 = new a(this);
                aVar2.type = zr.type;
                if (zr.type == Orders.sOj) {
                    if (zr.sOA == 1) {
                        inflate = View.inflate(this.sUK, a.g.uFw, null);
                        aVar2.sVd = (CdnImageView) inflate.findViewById(f.uzt);
                        aVar2.ihS = (TextView) inflate.findViewById(f.uzG);
                        aVar2.sVe = (TextView) inflate.findViewById(f.uzj);
                        aVar2.inw = (TextView) inflate.findViewById(f.uzv);
                        if (!TextUtils.isEmpty(zr.url)) {
                            this.sUK.sUD.put(zr.url, aVar2.sVe);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(this.sUK, a.g.uFx, null);
                        aVar2.sVd = (CdnImageView) inflate.findViewById(f.uzt);
                        aVar2.sVe = (TextView) inflate.findViewById(f.uzj);
                        aVar2.inw = (TextView) inflate.findViewById(f.uzv);
                        aVar2.ihS = (TextView) inflate.findViewById(f.uzG);
                        if (!TextUtils.isEmpty(zr.url)) {
                            this.sUK.sUD.put(zr.url, aVar2.sVe);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.sOA = zr.sOA;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(this.sUK, a.g.uFy, null);
                    aVar2.sVd = (CdnImageView) view.findViewById(f.uzt);
                    aVar2.sVe = (TextView) view.findViewById(f.uzj);
                    aVar2.inw = (TextView) view.findViewById(f.uzv);
                    aVar2.sVf = (CheckBox) view.findViewById(f.uex);
                    if (!TextUtils.isEmpty(zr.url)) {
                        this.sUK.sUD.put(zr.url, aVar2.sVe);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                aVar = aVar3;
            }
        }
        if (zr != null) {
            WalletOrderInfoOldUI$b walletOrderInfoOldUI$b = (WalletOrderInfoOldUI$b) WalletOrderInfoOldUI.c(this.sUK).get(zr.sIr);
            x.i("MicroMsg.WalletOrderInfoOldUI", "try get result " + walletOrderInfoOldUI$b);
            if (walletOrderInfoOldUI$b != null) {
                aVar.sVd.setUrl(walletOrderInfoOldUI$b.fDI);
                aVar.inw.setText(walletOrderInfoOldUI$b.fyY);
                aVar.sVe.setText(walletOrderInfoOldUI$b.sUr);
            } else {
                aVar.sVd.setUrl(zr.peY);
                aVar.inw.setText(zr.name);
                aVar.sVe.setText(zr.sNx);
            }
            if (bh.ov(zr.paA)) {
                aVar.sVe.setVisibility(0);
                if (aVar.sVf != null) {
                    aVar.sVf.setVisibility(8);
                }
            } else {
                aVar.sVe.setVisibility(8);
                if (aVar.sVf != null) {
                    aVar.sVf.setVisibility(0);
                    if (this.sUK.sTU.contains(zr.paA)) {
                        aVar.sVf.setChecked(true);
                    } else {
                        aVar.sVf.setChecked(false);
                    }
                }
            }
            if (aVar.ihS != null && walletOrderInfoOldUI$b != null && !bh.ov(walletOrderInfoOldUI$b.title)) {
                aVar.ihS.setText(walletOrderInfoOldUI$b.title);
            } else if (aVar.ihS != null && !bh.ov(zr.title)) {
                aVar.ihS.setText(zr.title);
            } else if (aVar.ihS != null) {
                aVar.ihS.setVisibility(8);
            }
            if (!(bh.ov(this.sUK.sRB) || aVar.sVe == null)) {
                aVar.sVe.setClickable(this.sUK.foC);
                aVar.sVe.setEnabled(this.sUK.foC);
                aVar.sVe.setOnClickListener(null);
                if (this.sUK.foD) {
                    aVar.sVe.setVisibility(8);
                }
            }
            fg = this.sUK.fg(zr.sIr);
            if (fg.equals("0")) {
                aVar.sVe.setBackgroundColor(this.sUK.getResources().getColor(c.transparent));
                aVar.sVe.setTextColor(this.sUK.getResources().getColor(c.bui));
            } else if (fg.equals("-1") || fg.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                aVar.sVe.setBackgroundDrawable(this.sUK.getResources().getDrawable(e.ucy));
                aVar.sVe.setTextColor(this.sUK.getResources().getColor(c.bui));
            } else if (fg.equals("4") || fg.equals("2") || fg.equals("1")) {
                aVar.sVe.setBackgroundColor(this.sUK.getResources().getColor(c.transparent));
                aVar.sVe.setTextColor(this.sUK.getResources().getColor(c.bsO));
            } else {
                x.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
            }
        }
        if (aVar.sVe != null) {
            int b = b.b(this.sUK.mController.xIM, 15.0f);
            int b2 = b.b(this.sUK.mController.xIM, 5.0f);
            aVar.sVe.setPadding(b, b2, b, b2);
        }
        return view;
    }
}

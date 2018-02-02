package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    private final Context mContext;
    private int mCount = 0;
    private ArrayList<Bankcard> sBR;
    private int sBS;
    com.tencent.mm.plugin.wallet_core.e.a sBT;
    List<String> sBU;

    public /* synthetic */ Object getItem(int i) {
        return zc(i);
    }

    public a(Context context, ArrayList<Bankcard> arrayList) {
        this.mContext = context;
        this.sBR = arrayList;
        this.sBS = 0;
        this.sBT = new com.tencent.mm.plugin.wallet_core.e.a();
        this.sBT.b(this.mContext, this.sBR);
        bJD();
    }

    public final void R(ArrayList<Bankcard> arrayList) {
        this.sBR = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.sBT.b(this.mContext, this.sBR);
        }
        bJD();
    }

    private void bJD() {
        g.Dk();
        this.sBU = bh.F(((String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xwi, "")).split(","));
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard zc(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return (Bankcard) this.sBR.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        Bankcard zc = zc(i);
        if (zc == null) {
            return 4;
        }
        if (zc.field_bankcardState == 9) {
            if (zc.field_wxcreditState == 0) {
                return 2;
            }
            return 3;
        } else if (zc.bKO() && "CITIC_CREDIT".equals(zc.field_bankcardType)) {
            return 5;
        } else {
            if (!zc.bKS() || q.Gf()) {
                return 1;
            }
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 6;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Bankcard zc = zc(i);
        if (zc == null) {
            return view;
        }
        boolean z;
        int itemViewType = getItemViewType(i);
        if (this.sBU == null || this.sBU.isEmpty() || zc == null) {
            z = false;
        } else {
            for (String equals : this.sBU) {
                if (equals.equals(zc.field_bindSerial)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        x.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[]{Integer.valueOf(i), zc.field_card_bottom_wording, Boolean.valueOf(z)});
        int i2;
        a aVar;
        switch (itemViewType) {
            case 0:
                return b.a(this.mContext, view, zc, com.tencent.mm.plugin.wxpay.a.g.uEw, this.sBT, z);
            case 1:
                return b.a(this.mContext, view, zc, com.tencent.mm.plugin.wxpay.a.g.uEA, this.sBT, z);
            case 2:
                i2 = com.tencent.mm.plugin.wxpay.a.g.uEC;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    a aVar2 = new a(this);
                    aVar2.sCa = (ImageView) view.findViewById(f.ueZ);
                    aVar2.sBW = (TextView) view.findViewById(f.ufa);
                    aVar2.sCd = (TextView) view.findViewById(f.urO);
                    aVar2.sCe = (ImageView) view.findViewById(f.ufk);
                    aVar2.sCf = (ImageView) view.findViewById(f.ufl);
                    aVar2.sCg = (ImageView) view.findViewById(f.ufm);
                    view.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.sBW.setText(this.mContext.getString(i.uRV, new Object[]{zc.field_bankName}));
                if (b.a(zc)) {
                    aVar.sCd.setVisibility(0);
                    return view;
                }
                aVar.sCd.setVisibility(8);
                return view;
            case 3:
                i2 = com.tencent.mm.plugin.wxpay.a.g.uEE;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    a aVar3 = new a(this);
                    aVar3.sCa = (ImageView) view.findViewById(f.ueZ);
                    aVar3.sBW = (TextView) view.findViewById(f.ufa);
                    aVar3.sCb = (TextView) view.findViewById(f.ufi);
                    aVar3.sCe = (ImageView) view.findViewById(f.ufk);
                    aVar3.sCf = (ImageView) view.findViewById(f.ufl);
                    aVar3.sCg = (ImageView) view.findViewById(f.ufm);
                    view.setTag(aVar3);
                    aVar = aVar3;
                } else {
                    aVar = (a) view.getTag();
                }
                switch (zc.field_wxcreditState) {
                    case 1:
                        aVar.sCb.setBackgroundResource(a$e.udM);
                        aVar.sCb.setVisibility(0);
                        break;
                    case 3:
                        aVar.sCb.setBackgroundResource(a$e.udH);
                        aVar.sCb.setVisibility(0);
                        break;
                    default:
                        aVar.sCb.setVisibility(8);
                        break;
                }
                aVar.sBW.setText(zc.field_bankName);
                this.sBT.a(this.mContext, zc, aVar.sCa);
                return view;
            case 4:
                return View.inflate(this.mContext, com.tencent.mm.plugin.wxpay.a.g.uEx, null);
            case 5:
                return b.a(this.mContext, view, zc, com.tencent.mm.plugin.wxpay.a.g.uED, this.sBT, z);
            default:
                return view;
        }
    }
}

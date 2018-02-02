package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class WalletBankcardIdUI$a extends BaseAdapter {
    private LayoutInflater DF = null;
    private Context mContext = null;
    List<q> sRp = new LinkedList();

    public WalletBankcardIdUI$a(Context context, List<q> list) {
        this.DF = LayoutInflater.from(context);
        this.sRp = list;
        this.mContext = context;
    }

    public final int getCount() {
        if (this.sRp == null) {
            return 0;
        }
        return this.sRp.size();
    }

    public final Object getItem(int i) {
        return this.sRp.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(g.uEF, viewGroup, false);
            aVar = new a(this);
            aVar.sRq = (ImageView) view.findViewById(f.uyc);
            aVar.pHJ = (TextView) view.findViewById(f.uyb);
            aVar.sRr = (TextView) view.findViewById(f.uye);
            aVar.sRs = (TextView) view.findViewById(f.uyd);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        q qVar = (q) getItem(i);
        if (bh.ov(qVar.pax)) {
            aVar.pHJ.setVisibility(8);
        } else {
            aVar.pHJ.setText(qVar.pax);
            aVar.pHJ.setVisibility(0);
        }
        if (bh.ov(qVar.sEd)) {
            aVar.sRr.setVisibility(8);
        } else {
            aVar.sRr.setText(qVar.sEd);
            aVar.sRr.setVisibility(0);
        }
        if (bh.ov(qVar.sDl)) {
            aVar.sRs.setVisibility(8);
        } else {
            aVar.sRs.setText(qVar.sDl);
            aVar.sRs.setVisibility(0);
        }
        String str = qVar.sEj;
        x.v("Micromsg.WalletInputCardIDUI", "bankType:" + qVar.sEi + ", logurl:" + str);
        aVar.sRq.setImageBitmap(null);
        if (!bh.ov(str)) {
            a aVar2 = new a();
            o.PB();
            aVar2.hDW = null;
            aVar2.hDD = e.bnF;
            aVar2.hDC = b.Hu(str);
            aVar2.hDA = true;
            aVar2.hDX = true;
            o.PA().a(str, aVar.sRq, aVar2.PK());
        }
        return view;
    }
}

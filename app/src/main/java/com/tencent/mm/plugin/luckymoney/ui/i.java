package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private LayoutInflater DF;
    private Context mContext;
    private List<m> ogJ = new LinkedList();
    String okb;
    boolean okc;
    OnClickListener okd;
    int oke = 1;
    b okf = null;

    public final /* synthetic */ Object getItem(int i) {
        return sl(i);
    }

    public i(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final void bd(List<m> list) {
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.ogJ = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.ogJ.size();
    }

    private m sl(int i) {
        return (m) this.ogJ.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.DF.inflate(g.uCG, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.ltB = view.findViewById(f.cIu);
            cVar2.lkk = (ImageView) view.findViewById(f.upw);
            cVar2.nqD = (TextView) view.findViewById(f.upz);
            cVar2.oid = (TextView) view.findViewById(f.upA);
            cVar2.ogw = (TextView) view.findViewById(f.upu);
            cVar2.okh = (TextView) view.findViewById(f.upv);
            cVar2.oki = (TextView) view.findViewById(f.upB);
            cVar2.okj = (ImageView) view.findViewById(f.upx);
            cVar2.okk = (TextView) view.findViewById(f.upy);
            if (this.okf != null) {
                this.okf.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        m sl = sl(i);
        n.a(cVar.lkk, sl.ocE, sl.userName);
        if (bh.ou(sl.obV).equals(this.okb) && this.okc) {
            cVar.oki.setOnClickListener(this.okd);
            cVar.oki.setVisibility(0);
            cVar.okh.setVisibility(8);
            cVar.oid.setVisibility(8);
        } else {
            if (bh.ov(sl.ocF)) {
                cVar.okh.setVisibility(8);
            } else {
                n.a(this.mContext, cVar.okh, sl.ocF);
                cVar.okh.setVisibility(0);
            }
            cVar.oid.setText(n.i(this.mContext, bh.getLong(sl.ocr, 0) * 1000));
            cVar.oid.setVisibility(0);
            cVar.oki.setVisibility(8);
        }
        n.a(this.mContext, cVar.nqD, sl.ocD);
        cVar.ogw.setText(this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.upj, new Object[]{e.t(((double) sl.ocq) / 100.0d)}));
        if (bh.ov(sl.ocG)) {
            cVar.okj.setVisibility(8);
            cVar.okk.setVisibility(8);
        } else {
            cVar.okk.setText(sl.ocG);
            if (this.oke == 2) {
                cVar.okj.setImageResource(a.e.ucX);
            } else {
                cVar.okj.setImageResource(a.e.ucK);
            }
            cVar.okj.setVisibility(0);
            cVar.okk.setVisibility(0);
        }
        return view;
    }
}

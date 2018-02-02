package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<TransferRecordParcel> pHB;
    private List<TransferRecordParcel> pHC = new ArrayList();
    private List<Pair<Integer, Integer>> pHD = new ArrayList();
    private Filter pHE;

    public c(Context context, List<TransferRecordParcel> list) {
        this.mContext = context;
        this.pHB = list;
    }

    public final int getCount() {
        return this.pHC.size();
    }

    public final Object getItem(int i) {
        return this.pHC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a$g.uBe, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.pHH = (CdnImageView) view.findViewById(f.ugH);
            bVar.pHI = (TextView) view.findViewById(f.ugJ);
            bVar.pHJ = (TextView) view.findViewById(f.ugI);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
        Pair pair = (Pair) this.pHD.get(i);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
        CharSequence spannableString = new SpannableString(transferRecordParcel.pHM);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        bVar2.pHH.setUrl(transferRecordParcel.pHq);
        bVar2.pHI.setText(spannableString);
        bVar2.pHJ.setText(this.mContext.getString(a$i.uHU, new Object[]{transferRecordParcel.nBM, transferRecordParcel.pHL}));
        return view;
    }

    public final Filter getFilter() {
        if (this.pHE == null) {
            this.pHE = new a(this, (byte) 0);
        }
        return this.pHE;
    }
}

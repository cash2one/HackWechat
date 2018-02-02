package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;

public final class b extends a {
    com.tencent.mm.plugin.nearlife.b.a oQw;
    private com.tencent.mm.plugin.nearlife.b.a oQx = new com.tencent.mm.plugin.nearlife.b.a("", new aof());
    String oQy;
    private HashMap<String, Integer> oQz = new HashMap();

    class a {
        TextView iXX;
        TextView ihS;
        TextView nLn;
        String oPt;
        com.tencent.mm.plugin.nearlife.b.a oQA;
        LinearLayout oQB;
        ImageView oQC;
        final /* synthetic */ b oQD;
        int position;
        int type;

        a(b bVar) {
            this.oQD = bVar;
        }
    }

    public b(Context context, OnClickListener onClickListener, String str, boolean z) {
        super(context, onClickListener, str, z);
        this.oQx.fon = context.getString(R.l.ewU);
        this.oQz.put(this.oQx.oPt, Integer.valueOf(2));
        if (!z) {
            a(this.oQx, 0);
            notifyDataSetChanged();
        }
    }

    public final com.tencent.mm.plugin.nearlife.b.a dA(String str, String str2) {
        if (this.oQw == null) {
            this.oQw = new com.tencent.mm.plugin.nearlife.b.a("", new aof());
            this.oQw.oPt = "City";
            this.oQz.put(this.oQw.oPt, Integer.valueOf(1));
            a(this.oQw, 1);
        }
        this.oQw.fon = str;
        this.oQw.hKZ = str2;
        notifyDataSetChanged();
        return this.oQw;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, R.i.doG, null);
            aVar.ihS = (TextView) view.findViewById(R.h.csQ);
            aVar.nLn = (TextView) view.findViewById(R.h.csP);
            aVar.iXX = (TextView) view.findViewById(R.h.csO);
            aVar.oQB = (LinearLayout) view.findViewById(R.h.cIx);
            aVar.oQC = (ImageView) view.findViewById(R.h.cKS);
            aVar.oQB.setOnClickListener(this.mtg);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.nearlife.b.a tS = tS(i);
        if (this.oQz.containsKey(tS.oPt)) {
            intValue = ((Integer) this.oQz.get(tS.oPt)).intValue();
        } else {
            intValue = 0;
        }
        aVar.oQC.setVisibility(8);
        aVar.type = intValue;
        aVar.oQA = tS;
        if (!bh.ov(this.oQy) && this.oQy.equals(tS.oPt)) {
            aVar.oQC.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.ihS.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.iXX.setVisibility(0);
                break;
            case 1:
                aVar.ihS.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.iXX.setVisibility(8);
                break;
            case 2:
                aVar.iXX.setVisibility(8);
                aVar.ihS.setTextColor(this.mContext.getResources().getColor(R.e.btR));
                if (bh.ov(this.oQy)) {
                    aVar.oQC.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.oPt = tS.oPt;
        if (this.oPK) {
            aVar.ihS.setText(DQ(tS.fon));
            aVar.iXX.setText(DQ(bj(tS.oPy)));
        } else {
            aVar.ihS.setText(tS.fon);
            aVar.iXX.setText(bj(tS.oPy));
        }
        aVar.nLn.setVisibility(8);
        return view;
    }

    private Spannable DQ(String str) {
        return com.tencent.mm.bc.b.a(str, this.oPG);
    }
}

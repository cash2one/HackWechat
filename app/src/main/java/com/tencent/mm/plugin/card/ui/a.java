package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.oq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    List<CardInfo> kOM = new ArrayList();
    HashMap<String, Integer> kPK = new HashMap();
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return nP(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kOM.size();
    }

    public final CardInfo nP(int i) {
        return (CardInfo) this.kOM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b nP = nP(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dbG, null);
            aVar = new a(this);
            aVar.kPA = (RelativeLayout) view.findViewById(R.h.bQj);
            aVar.kPL = (LinearLayout) view.findViewById(R.h.bSp);
            aVar.kPB = (ImageView) view.findViewById(R.h.bQY);
            aVar.kPC = (TextView) view.findViewById(R.h.bPP);
            aVar.kPD = (TextView) view.findViewById(R.h.bRx);
            aVar.kPE = (TextView) view.findViewById(R.h.subtitle);
            aVar.kPG = (TextView) view.findViewById(R.h.bRy);
            aVar.kPM = (ImageView) view.findViewById(R.h.bRq);
            aVar.kPN = (TextView) view.findViewById(R.h.bQk);
            aVar.kPO = (TextView) view.findViewById(R.h.bSc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (nP.atn()) {
            aVar.kPB.setVisibility(0);
            aVar.kPD.setVisibility(0);
            aVar.kPE.setVisibility(0);
            aVar.kPG.setVisibility(8);
            aVar.kPC.setVisibility(0);
            aVar.kPC.setText(nP.atB().kLa);
            if (!nP.atk()) {
                aVar.kPD.setText(nP.atB().title);
            } else if (nP.atB().vRI != null && nP.atB().vRI.size() == 1) {
                aVar.kPD.setText(((oq) nP.atB().vRI.get(0)).title);
            } else if (nP.atB().vRI != null && nP.atB().vRI.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((oq) nP.atB().vRI.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((oq) nP.atB().vRI.get(1)).title);
                aVar.kPD.setText(stringBuilder.toString());
            }
            if (nP.atB().vSh == 1) {
                aVar.kPM.setVisibility(0);
            } else {
                aVar.kPM.setVisibility(8);
            }
            long j = ((CardInfo) nP).field_begin_time;
            if (nP.getEndTime() > 0 && j > 0) {
                aVar.kPE.setText(this.mContext.getString(R.l.dPP, new Object[]{l.bp(j) + "  -  " + l.bp(nP.getEndTime())}));
                aVar.kPE.setVisibility(0);
            } else if (nP.getEndTime() > 0) {
                aVar.kPE.setText(this.mContext.getString(R.l.dPO, new Object[]{l.bp(nP.getEndTime())}));
                aVar.kPE.setVisibility(0);
            } else {
                aVar.kPE.setText("");
                aVar.kPE.setVisibility(8);
            }
            m.a(aVar.kPB, nP.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bDT, true);
            if (nP.atB().vSf == 1) {
                aVar.kPB.setAlpha(255);
                aVar.kPO.setVisibility(8);
                aVar.kPD.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                aVar.kPE.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
            } else {
                aVar.kPO.setText(nP.atB().vSg);
                aVar.kPB.setAlpha(90);
                aVar.kPO.setVisibility(0);
                aVar.kPD.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                aVar.kPE.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
            }
            int intValue = ((Integer) this.kPK.get(nP.atG())).intValue();
            if (intValue == 1) {
                aVar.kPN.setText("");
                aVar.kPN.setVisibility(8);
            } else {
                aVar.kPN.setText("x" + intValue);
                aVar.kPN.setVisibility(0);
            }
        } else {
            aVar.kPB.setVisibility(8);
            aVar.kPD.setVisibility(8);
            aVar.kPC.setVisibility(8);
            aVar.kPE.setVisibility(8);
            aVar.kPO.setVisibility(8);
            aVar.kPN.setVisibility(8);
            aVar.kPG.setVisibility(0);
            aVar.kPA.setBackgroundColor(this.mContext.getResources().getColor(R.e.brO));
            aVar.kPG.setText(this.mContext.getResources().getString(R.l.dOR));
        }
        return view;
    }
}

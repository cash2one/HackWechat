package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.common.c.g;
import java.util.LinkedList;

public final class l implements c {
    private BaseAdapter kPo;
    private int kPs;
    protected LinkedList<CardTagTextView> kPw = new LinkedList();
    private int kVB;
    int kVC;
    int kVD;
    private Context mContext;

    public l(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kPo = baseAdapter;
        this.kVB = this.mContext.getResources().getDimensionPixelSize(R.f.bvV);
        this.kPs = this.mContext.getResources().getDimensionPixelSize(R.f.bvB);
        this.kVC = this.mContext.getResources().getDimensionPixelOffset(R.f.bwp);
        this.kVD = this.mContext.getResources().getDimensionPixelOffset(R.f.bwq);
    }

    public final void release() {
        this.mContext = null;
        this.kPo = null;
        if (this.kPw != null) {
            this.kPw.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        View inflate;
        a aVar;
        if (view == null) {
            TextView textView;
            if (bVar.atF().equals("PRIVATE_TICKET_TITLE")) {
                inflate = View.inflate(this.mContext, R.i.dcl, null);
                textView = (TextView) inflate.findViewById(R.h.bRg);
                if (textView != null) {
                    textView.setText(this.mContext.getString(R.l.dPL));
                }
            } else if (bVar.atF().equals("PRIVATE_INVOICE_TITLE")) {
                inflate = View.inflate(this.mContext, R.i.dcl, null);
                textView = (TextView) inflate.findViewById(R.h.bRg);
                if (textView != null) {
                    textView.setText(this.mContext.getString(R.l.dOs));
                }
            } else {
                inflate = View.inflate(this.mContext, R.i.dcj, null);
            }
            a aVar2 = new a(this);
            aVar2.kPA = (RelativeLayout) inflate.findViewById(R.h.bQj);
            aVar2.kPB = (ImageView) inflate.findViewById(R.h.bQY);
            aVar2.kUN = inflate.findViewById(R.h.bSr);
            aVar2.kUO = (ImageView) inflate.findViewById(R.h.bSq);
            aVar2.kPC = (TextView) inflate.findViewById(R.h.bPP);
            aVar2.kPD = (TextView) inflate.findViewById(R.h.bRx);
            aVar2.kPG = (TextView) inflate.findViewById(R.h.bRy);
            aVar2.kVE = (ImageView) inflate.findViewById(R.h.bPD);
            aVar2.kVG = (ImageView) inflate.findViewById(R.h.bPK);
            aVar2.kVH = (ImageView) inflate.findViewById(R.h.bPM);
            aVar2.kVI = (ImageView) inflate.findViewById(R.h.bPL);
            aVar2.kVF = (LinearLayout) inflate.findViewById(R.h.bRQ);
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.kPD != null) {
            aVar.kPD.setTextSize(0, this.mContext.getResources().getDimension(R.f.buu));
        }
        if (this.kPo.getItem(i) instanceof CardInfo) {
            CharSequence a;
            boolean z;
            CardInfo cardInfo = (CardInfo) this.kPo.getItem(i);
            if (cardInfo.field_stickyIndex % 10 != 0) {
                if (cardInfo.field_stickyIndex > 0) {
                    a = j.a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                    z = true;
                }
                z = false;
                a = null;
            } else {
                if (!g.AA(cardInfo.field_label_wording)) {
                    Object obj = cardInfo.field_label_wording;
                    z = true;
                }
                z = false;
                a = null;
            }
            if (z) {
                for (int i2 = 0; i2 < aVar.kVF.getChildCount(); i2++) {
                    this.kPw.add((CardTagTextView) aVar.kVF.getChildAt(i2));
                }
                aVar.kVF.removeAllViews();
                aVar.kVF.setVisibility(0);
                if (this.kPw.size() == 0) {
                    inflate = new CardTagTextView(this.mContext);
                } else {
                    CardTagTextView cardTagTextView = (CardTagTextView) this.kPw.removeFirst();
                }
                inflate.setPadding(this.kPs, this.kVB, this.kPs, this.kVB);
                inflate.setGravity(17);
                inflate.setMinWidth(this.mContext.getResources().getDimensionPixelSize(R.f.bws));
                inflate.setMinHeight(this.mContext.getResources().getDimensionPixelSize(R.f.bwr));
                if (cardInfo.ati()) {
                    inflate.setTextColor(a.c(this.mContext, R.e.white));
                    inflate.fillColor = a.c(this.mContext, R.e.brP);
                } else {
                    inflate.setTextColor(a.c(this.mContext, R.e.btd));
                    inflate.fillColor = 0;
                }
                inflate.setText(a);
                inflate.setTextSize(1, 10.0f);
                aVar.kVF.addView(inflate);
            } else {
                aVar.kVF.setVisibility(8);
            }
        }
        if (bVar.atn()) {
            aVar.kPB.setVisibility(0);
            aVar.kPD.setVisibility(0);
            aVar.kPG.setVisibility(8);
            aVar.kPC.setVisibility(0);
            aVar.kPC.setText(bVar.atB().kLa);
            aVar.kPD.setText(bVar.atB().title);
            if (bVar.atk()) {
                aVar.kUN.setVisibility(0);
                aVar.kPB.setVisibility(4);
                ImageView imageView = aVar.kUO;
                if (TextUtils.isEmpty(bVar.atB().vRQ)) {
                    m.a(imageView, R.g.bAv, com.tencent.mm.plugin.card.b.l.wO(bVar.atB().hbM));
                } else {
                    m.a(this.mContext, imageView, bVar.atB().vRQ, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bAv, com.tencent.mm.plugin.card.b.l.wO(bVar.atB().hbM));
                }
            } else {
                aVar.kUN.setVisibility(8);
                aVar.kPB.setVisibility(0);
                m.a(aVar.kPB, bVar.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bDT, true);
            }
            if (bVar.ati()) {
                if (bh.ov(bVar.atC().vRp)) {
                    aVar.kPA.setBackgroundDrawable(com.tencent.mm.plugin.card.b.l.ch(com.tencent.mm.plugin.card.b.l.wO(bVar.atB().hbM), this.kVC));
                    aVar.kVG.setVisibility(8);
                    aVar.kVH.setVisibility(8);
                    aVar.kVI.setVisibility(0);
                } else {
                    aVar.kPA.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAq));
                    aVar.kVG.setVisibility(0);
                    aVar.kVH.setVisibility(0);
                    ImageView imageView2 = aVar.kVG;
                    String str = bVar.atC().vRp;
                    com.tencent.mm.aq.a.a.c.a aVar3 = new com.tencent.mm.aq.a.a.c.a();
                    aVar3.hDD = e.bnF;
                    o.PB();
                    aVar3.hDW = null;
                    aVar3.hDC = com.tencent.mm.plugin.card.model.m.wk(str);
                    aVar3.hDA = true;
                    aVar3.hEa = true;
                    aVar3.hDy = true;
                    aVar3.hDP = R.g.bAq;
                    aVar3.hDH = a.aa(this.mContext, R.f.bwq);
                    aVar3.hDG = a.eA(this.mContext);
                    o.PA().a(str, imageView2, aVar3.PK());
                    imageView2.setImageMatrix(new Matrix());
                    aVar.kVI.setVisibility(8);
                }
                aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.white));
                aVar.kPD.setTextColor(this.mContext.getResources().getColor(R.e.white));
            } else {
                aVar.kVI.setVisibility(8);
                aVar.kVG.setVisibility(8);
                aVar.kVH.setVisibility(8);
                aVar.kPA.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAq));
                aVar.kPD.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
            }
        } else {
            aVar.kPB.setVisibility(8);
            aVar.kPD.setVisibility(8);
            aVar.kPC.setVisibility(8);
            aVar.kVF.setVisibility(8);
            aVar.kPG.setVisibility(0);
            aVar.kPA.setBackgroundDrawable(com.tencent.mm.plugin.card.b.l.ch(this.mContext.getResources().getColor(R.e.brO), this.kVC));
            aVar.kPG.setText(this.mContext.getResources().getString(R.l.dOR));
        }
        int i3 = bVar.atB().kJO;
        LayoutParams layoutParams;
        if (i != this.kPo.getCount() - 1 || aVar.kPA == null) {
            layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.kPA.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
            if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.bvz)) {
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvz);
                aVar.kPA.setLayoutParams(layoutParams);
            }
        }
        return view;
    }

    public final void u(View view, int i) {
        ((a) view.getTag()).kVE.setImageResource(i);
    }

    public final void v(View view, int i) {
        ((a) view.getTag()).kVE.setVisibility(i);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        a aVar = (a) view.getTag();
        aVar.kVE.setTag(Integer.valueOf(i));
        aVar.kVE.setOnClickListener(onClickListener);
    }
}

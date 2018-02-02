package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bjv;

public final class bh {
    Context mContext;
    int qPd = -1;
    private av qZU;
    FrameLayout qZp;
    SnsCommentShowAbLayout rMK = null;
    LinearLayout rzB;
    LinearLayout rzC;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View rML;
        final /* synthetic */ bh rMM;
        final /* synthetic */ View zS;

        AnonymousClass1(bh bhVar, View view, View view2) {
            this.rMM = bhVar;
            this.zS = view;
            this.rML = view2;
        }

        public final void run() {
            bh.a(this.rMM, this.zS, this.rML);
        }
    }

    static /* synthetic */ void a(bh bhVar, View view, View view2) {
        c cVar = (c) view.getTag();
        m Lm = ae.bvv().Lm(cVar.frH);
        if (Lm != null) {
            b iu = b.iu(740);
            bjv n = ai.n(Lm);
            iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(Lm.field_userName).ix(n == null ? 0 : n.wMY).ix(n == null ? 0 : n.wNb);
            iu.Sx();
        }
        view2.setVisibility(0);
        view2.startAnimation(bhVar.qZU.rzz);
        bhVar.rzB = (LinearLayout) view2.findViewById(f.qAL);
        bhVar.rzB.setOnClickListener(bhVar.qZU.qZo.rPv);
        bhVar.rzB.setOnTouchListener(bhVar.qZU.rsO);
        bhVar.rzC = (LinearLayout) view2.findViewById(f.qBd);
        bhVar.rzC.setOnClickListener(bhVar.qZU.qZo.rPw);
        bhVar.rzC.setOnTouchListener(bhVar.qZU.rsO);
        bhVar.rzC.setTag(cVar);
        bhVar.rzB.setTag(cVar);
        ImageView imageView = (ImageView) bhVar.rzC.findViewById(f.qBc);
        ImageView imageView2 = (ImageView) bhVar.rzB.findViewById(f.qAD);
        TextView textView = (TextView) bhVar.rzC.findViewById(f.qBe);
        TextView textView2 = (TextView) bhVar.rzB.findViewById(f.qAM);
        if (u.LI(cVar.fzW)) {
            bhVar.rzB.setEnabled(false);
            bhVar.rzC.setEnabled(false);
            textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyy));
            if (cVar.kTK == 11) {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qIF);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qII);
            } else {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qIH);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qIJ);
            }
            textView.setText(bhVar.mContext.getString(j.qLx));
            textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyy));
        } else {
            bhVar.rzB.setEnabled(true);
            if (cVar.kTK == 11) {
                imageView.setImageResource(e.qzl);
                imageView2.setImageResource(e.qzm);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
            } else {
                imageView.setImageResource(e.qzd);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
            }
            bhVar.rzC.setEnabled(true);
            if (cVar.rNE == 0) {
                textView.setText(bhVar.mContext.getString(j.qLx));
            } else {
                textView.setText(bhVar.mContext.getString(j.qKX));
            }
        }
        if (cVar.kTK == 11) {
            bhVar.rzC.setBackgroundResource(e.qzn);
            bhVar.rzB.setBackgroundResource(e.qzo);
        }
    }

    public bh(Context context, av avVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.qZU = avVar;
        this.qZp = frameLayout;
    }

    final void cJ(View view) {
        view.clearAnimation();
        view.startAnimation(this.qZU.rzA);
        this.qZU.rzA.setAnimationListener(new 2(this, view));
    }

    public final boolean bzr() {
        if (this.rMK == null) {
            return false;
        }
        this.qZp.removeView(this.rMK);
        this.rMK = null;
        return true;
    }
}

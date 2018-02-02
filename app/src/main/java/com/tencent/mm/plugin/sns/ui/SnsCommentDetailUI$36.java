package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$36 implements OnClickListener {
    final /* synthetic */ TextView rAG;
    final /* synthetic */ TextView rAH;
    final /* synthetic */ ImageView rAI;
    final /* synthetic */ ImageView rAJ;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$36(SnsCommentDetailUI snsCommentDetailUI, m mVar, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
        this.rAG = textView;
        this.rAH = textView2;
        this.rAI = imageView;
        this.rAJ = imageView2;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.B(this.rAr).getVisibility());
        SnsCommentDetailUI.D(this.rAr);
        bnp bxV = this.rrO.bxV();
        if (bxV != null && bxV.wQo.vYc == 21 && !com.tencent.mm.plugin.sns.lucky.a.m.JU(this.rrO.byq())) {
            a.e(this.rAr.mController.xIM, this.rAr.rAn.xy(0));
        } else if (SnsCommentDetailUI.B(this.rAr).getVisibility() == 0) {
            SnsCommentDetailUI.f(this.rAr);
        } else {
            SnsCommentDetailUI.B(this.rAr).setVisibility(0);
            SnsCommentDetailUI.B(this.rAr).startAnimation(SnsCommentDetailUI.E(this.rAr));
            if (SnsCommentDetailUI.y(this.rAr) == 11) {
                SnsCommentDetailUI.F(this.rAr).findViewById(f.qAz).setBackgroundResource(e.qzc);
            }
            if (u.LH(SnsCommentDetailUI.n(this.rAr))) {
                this.rAr.rzB.setEnabled(true);
                this.rAI.setImageResource(e.qzd);
                this.rAr.rzC.setEnabled(true);
                this.rAG.setTextColor(this.rAr.getResources().getColor(c.white));
                this.rAH.setTextColor(this.rAr.getResources().getColor(c.white));
                m Ll = h.Ll(SnsCommentDetailUI.n(this.rAr));
                if (SnsCommentDetailUI.y(this.rAr) == 11) {
                    this.rAI.setImageResource(e.qzl);
                    this.rAJ.setImageResource(e.qzm);
                    this.rAG.setTextColor(this.rAr.getResources().getColor(c.qyz));
                    this.rAH.setTextColor(this.rAr.getResources().getColor(c.qyz));
                } else {
                    this.rAI.setImageResource(e.qzd);
                    this.rAG.setTextColor(this.rAr.getResources().getColor(c.white));
                    this.rAH.setTextColor(this.rAr.getResources().getColor(c.white));
                }
                if (Ll.field_likeFlag == 0) {
                    this.rAG.setText(this.rAr.getString(j.qLx));
                    return;
                } else {
                    this.rAG.setText(this.rAr.getString(j.qKX));
                    return;
                }
            }
            this.rAr.rzB.setEnabled(false);
            this.rAr.rzC.setEnabled(false);
            this.rAG.setText(this.rAr.getString(j.qLx));
            this.rAG.setTextColor(this.rAr.getResources().getColor(c.qyy));
            this.rAH.setTextColor(this.rAr.getResources().getColor(c.qyy));
            if (SnsCommentDetailUI.y(this.rAr) == 11) {
                this.rAI.setImageResource(i.qIF);
            } else {
                this.rAI.setImageResource(i.qIH);
            }
        }
    }
}

package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View lCk = null;
    private TextView qSh;
    private LinearLayout qSi;
    private LinearLayout qSj;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        init();
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), g.qGy, this);
        this.lCk = inflate.findViewById(f.qBi);
        this.qSh = (TextView) inflate.findViewById(f.qAR);
        this.qSi = (LinearLayout) inflate.findViewById(f.qAS);
        b.b(getContext(), 2.0f);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(e.qzO);
        linearLayout.setLayoutParams(layoutParams);
        this.qSj = linearLayout;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.lCk != null) {
            this.lCk.setVisibility(i);
        }
    }

    public final void a(m mVar, com.tencent.mm.plugin.sns.ui.b.b bVar) {
        bjv n = ai.n(mVar);
        bkk com_tencent_mm_protocal_c_bkk = n.wNo;
        if (com_tencent_mm_protocal_c_bkk == null || com_tencent_mm_protocal_c_bkk.wNR.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        double b = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
        this.qSh.setText(getContext().getString(j.qLC, new Object[]{Integer.valueOf(n.wNo.wNQ), bh.t(b / 100.0d)}));
        this.lCk.setTag(mVar);
        this.lCk.setOnClickListener(bVar.rPB);
        LinkedList linkedList = com_tencent_mm_protocal_c_bkk.wNR;
        boolean isEmpty = com_tencent_mm_protocal_c_bkk.wNR.isEmpty();
        int b2 = b.b(getContext(), 32.0f);
        int b3 = b.b(getContext(), 6.0f);
        int b4 = b.b(getContext(), 10.0f);
        int b5 = b.b(getContext(), 17.0f);
        if (this.qSi != null) {
            int i;
            LinearLayout linearLayout;
            x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(d.bvJ)));
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.qSi.getParent() != null) {
                    this.qSi.setVisibility(8);
                }
                this.qSi.removeAllViews();
                this.qSi.setVisibility(8);
                linearLayout = this.qSi;
                i = 8;
            } else {
                this.qSi.getParent();
                this.qSi.removeAllViews();
                this.qSi.setVisibility(0);
                this.qSi.setPadding(0, b3, 0, b3);
                View imageView = new ImageView(getContext());
                imageView.setImageResource(i.qIM);
                imageView.setPadding(b4, b5, b4, 0);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.qSi.addView(imageView);
                b4 = a.fromDPToPix(getContext(), SnsCommentDetailUI.rzS);
                i = ((int) (f - ((float) b4))) / (b3 + b2);
                if (((int) (f - ((float) b4))) % (b3 + b2) > b2) {
                    i++;
                }
                x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i));
                View iVar = new com.tencent.mm.plugin.sns.ui.i(getContext());
                iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                iVar.rrq = i;
                for (b4 = 0; b4 < linkedList.size(); b4++) {
                    bjr com_tencent_mm_protocal_c_bjr = (bjr) linkedList.get(b4);
                    View touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(e.qze);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
                    layoutParams2.setMargins(0, b3, b3, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(com_tencent_mm_protocal_c_bjr.vIy);
                    com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_bjr.vIy, true);
                    touchImageView.setOnClickListener(bVar.rPq);
                    iVar.addView(touchImageView);
                }
                this.qSi.addView(iVar);
                linearLayout = this.qSj;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}

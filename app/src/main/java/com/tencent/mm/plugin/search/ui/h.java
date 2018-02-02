package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class h extends LinearLayout implements OnClickListener {
    String fDj = null;
    String iRN = null;
    private TextView ihS = null;
    List<bdh> qcA = null;
    private List<View> qcy = new LinkedList();
    b qcz = null;

    static /* synthetic */ void a(h hVar) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        hVar.setOrientation(1);
        hVar.setGravity(16);
        hVar.setVisibility(8);
        try {
            dimensionPixelSize = hVar.getResources().getDimensionPixelSize(R.f.buW);
            dimensionPixelSize2 = hVar.getResources().getDimensionPixelSize(R.f.buV);
        } catch (Exception e) {
            dimensionPixelSize = a.fromDPToPix(hVar.getContext(), 48);
            dimensionPixelSize2 = a.fromDPToPix(hVar.getContext(), 13);
        }
        hVar.setMinimumHeight(dimensionPixelSize);
        LayoutParams layoutParams = (LayoutParams) hVar.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        hVar.setLayoutParams(layoutParams);
    }

    public h(Context context) {
        super(context);
        post(new 1(this));
    }

    public final void onClick(View view) {
        if (this.qcz != null && view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            this.qcz.a(aVar.qcC, this.iRN, aVar.position);
        }
    }

    public final boolean a(bbz com_tencent_mm_protocal_c_bbz, String str, String str2) {
        if (com_tencent_mm_protocal_c_bbz == null || com_tencent_mm_protocal_c_bbz.vIx == null) {
            x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
            return false;
        }
        List<bdh> list = com_tencent_mm_protocal_c_bbz.vIx;
        List linkedList = new LinkedList();
        for (bdh com_tencent_mm_protocal_c_bdh : list) {
            if (!bh.ov(com_tencent_mm_protocal_c_bdh.wJs)) {
                linkedList.add(com_tencent_mm_protocal_c_bdh);
            }
        }
        if (linkedList.size() <= 0) {
            x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
            return false;
        }
        int i;
        this.fDj = str2;
        this.iRN = str;
        this.qcA = com_tencent_mm_protocal_c_bbz.vIx;
        if (this.ihS == null) {
            this.ihS = new TextView(new ContextThemeWrapper(getContext(), R.m.eYP));
            this.ihS.setTextSize(15.0f);
            this.ihS.setPadding(0, a.fromDPToPix(getContext(), 10), 0, a.fromDPToPix(getContext(), 2));
            addView(this.ihS);
        }
        if (bh.ov(com_tencent_mm_protocal_c_bbz.fon)) {
            this.ihS.setText(R.l.eIX);
        } else {
            this.ihS.setText(com_tencent_mm_protocal_c_bbz.fon);
        }
        int size = ((linkedList.size() + 1) / 2) - this.qcy.size();
        for (i = 0; i < size; i++) {
            View inflate = View.inflate(getContext(), R.i.dja, null);
            addView(inflate);
            this.qcy.add(inflate);
            inflate.findViewById(R.h.ctI).setOnClickListener(this);
            inflate.findViewById(R.h.ctJ).setOnClickListener(this);
        }
        int i2 = 0;
        for (View view : this.qcy) {
            if (i2 < linkedList.size()) {
                int i3 = i2;
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5;
                    a aVar = i3 < linkedList.size() ? new a(this, (bdh) linkedList.get(i3), i3 + 1) : null;
                    i = i3 % 2;
                    switch (i) {
                        case 0:
                            i = R.h.ctG;
                            i5 = R.h.ctI;
                            break;
                        case 1:
                            i = R.h.ctH;
                            i5 = R.h.ctJ;
                            break;
                        default:
                            x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configItemLinearLayout wrong Index:" + i);
                            break;
                    }
                    if (aVar == null) {
                        view.findViewById(i).setVisibility(8);
                    } else {
                        view.findViewById(i).setVisibility(0);
                        TextView textView = (TextView) view.findViewById(i5);
                        textView.setText(aVar.qcC.wJs);
                        textView.setTag(aVar);
                    }
                    i3++;
                }
                view.setVisibility(0);
                i2 = i3;
            } else {
                view.setVisibility(8);
            }
        }
        requestLayout();
        return true;
    }
}

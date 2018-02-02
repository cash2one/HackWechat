package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

class m$d extends a {
    public static final int yKD = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), bp.CTRL_INDEX);
    public static final int yKE = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 172);
    static c yKF;
    protected ThreeDotsLoadingView jPG;
    protected ImageView tpk;
    protected ImageView yIQ;
    protected ImageView yIT;
    protected ImageView yIU;
    protected TextView yIW;
    protected ChattingItemFooter yIX;
    protected ImageView yIY;
    protected LinearLayout yIZ;
    protected ViewGroup yJa;
    protected TextView yJb;
    protected LinearLayout yJc;
    ImageView yJk;
    protected TextView yJo;
    protected ImageView yJp;
    protected TextView yJq;
    protected TextView yJr;
    protected LinearLayout yJs;
    protected TextView yJv;
    protected ViewGroup yKG;
    protected View yKH;

    m$d() {
    }

    static {
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDP = R.k.dvG;
        com_tencent_mm_aq_a_a_c_a.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20)).hDy = true;
        yKF = com_tencent_mm_aq_a_a_c_a.PK();
    }

    public final m$d s(View view, boolean z) {
        super.ds(view);
        this.yIQ = (ImageView) view.findViewById(R.h.bTm);
        this.yIT = (ImageView) this.mUL.findViewById(R.h.bTM);
        this.yIU = (ImageView) this.mUL.findViewById(R.h.bVe);
        this.yIW = (TextView) view.findViewById(R.h.bSZ);
        this.yIY = (ImageView) view.findViewById(R.h.bTg);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yIX = (ChattingItemFooter) view.findViewById(R.h.ciX);
        this.yIZ = (LinearLayout) view.findViewById(R.h.bKD);
        this.yJa = (ViewGroup) view.findViewById(R.h.cub);
        this.yJb = (TextView) view.findViewById(R.h.ctZ);
        this.yJc = (LinearLayout) view.findViewById(R.h.bTs);
        this.yIy = view.findViewById(R.h.bTD);
        if (!z) {
            this.yJk = (ImageView) this.mUL.findViewById(R.h.bVd);
            this.psA = (ProgressBar) this.mUL.findViewById(R.h.cTZ);
        }
        this.yJs = (LinearLayout) view.findViewById(R.h.bSS);
        this.jPG = (ThreeDotsLoadingView) view.findViewById(R.h.ctD);
        this.tpk = (ImageView) view.findViewById(R.h.bZs);
        this.yJv = (TextView) view.findViewById(R.h.bSV);
        this.yJo = (TextView) view.findViewById(R.h.bSU);
        this.yJp = (ImageView) view.findViewById(R.h.bSW);
        this.yJq = (TextView) view.findViewById(R.h.bSY);
        this.yJr = (TextView) view.findViewById(R.h.bSX);
        this.yKG = (ViewGroup) view.findViewById(R.h.bZw);
        return this;
    }
}

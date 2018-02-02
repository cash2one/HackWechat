package com.tencent.mm.ui.chatting;

import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public final class w {
    private LinearLayout lHZ;
    private OnClickListener pGO = new 1(this);
    private ChatFooterCustom yrZ;
    private FrameLayout yvo;

    public w(ChatFooterCustom chatFooterCustom) {
        this.yrZ = chatFooterCustom;
    }

    public final void cpo() {
        x.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.yrZ.findViewById(R.h.bUb).setVisibility(8);
        this.yrZ.findViewById(R.h.bTW).setVisibility(8);
        this.lHZ = (LinearLayout) this.yrZ.findViewById(R.h.bTX);
        this.lHZ.setWeightSum(1.0f);
        this.yvo = (FrameLayout) this.lHZ.getChildAt(0);
        this.yvo.setVisibility(0);
        this.yvo.setOnClickListener(this.pGO);
        ((TextView) this.yvo.getChildAt(0).findViewById(R.h.bTZ)).setText(R.l.edM);
        this.yvo.getChildAt(0).findViewById(R.h.bTY).setVisibility(8);
        this.yvo.getChildAt(1).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.lHZ.getChildAt(i).setVisibility(8);
        }
    }
}

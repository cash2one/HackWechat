package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class y extends i {
    private b kIK;
    private View kXi;
    private MMActivity kaY;

    public final void initView() {
        this.kaY = this.kWz.avL();
    }

    public final void update() {
        this.kIK = this.kWz.avI();
        if (this.kXi == null) {
            this.kXi = ((ViewStub) findViewById(R.h.bSd)).inflate();
        }
        if (this.kIK.atk()) {
            this.kXi.setBackgroundDrawable(l.z(this.kaY, this.kaY.getResources().getColor(R.e.brK)));
        }
        TextView textView = (TextView) this.kXi.findViewById(R.h.bSe);
        if (this.kIK.atC() == null) {
            x.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.kaY.getResources().getColor(R.e.bsF));
        if (TextUtils.isEmpty(this.kIK.atB().vSg)) {
            m.b(textView, this.kIK.atC().status);
        } else {
            textView.setText(this.kIK.atB().vSg);
        }
    }

    public final void awW() {
        if (this.kXi != null) {
            this.kXi.setVisibility(8);
        }
    }
}

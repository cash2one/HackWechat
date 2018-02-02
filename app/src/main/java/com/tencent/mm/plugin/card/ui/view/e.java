package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i {
    private View kWr;

    public final void initView() {
    }

    public final void update() {
        b avI = this.kWz.avI();
        ki kiVar = avI.atB().vRW;
        if (kiVar != null) {
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + kiVar.qox);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + kiVar.text);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + kiVar.vRv);
        }
        if (kiVar != null && !TextUtils.isEmpty(kiVar.text) && avI.atz()) {
            if (this.kWr == null) {
                this.kWr = ((ViewStub) findViewById(R.h.bPE)).inflate();
            }
            ((TextView) this.kWr.findViewById(R.h.cEg)).setText(kiVar.text);
            this.kWr.setOnClickListener(this.kWz.avM());
        } else if (this.kWr != null) {
            this.kWr.setVisibility(8);
        }
    }

    public final void awW() {
        if (this.kWr != null) {
            this.kWr.setVisibility(8);
        }
    }
}

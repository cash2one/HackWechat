package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.c.qz;

public final class k extends i {
    private View kWA;

    public final void initView() {
    }

    public final void update() {
        if (this.kWA == null) {
            this.kWA = ((ViewStub) findViewById(R.h.bQs)).inflate();
        }
        this.kWA.setOnClickListener(this.kWz.avM());
        qz qzVar = this.kWz.avI().atB().vSa;
        if (TextUtils.isEmpty(qzVar.peD)) {
            findViewById(R.h.bQo).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.bQn)).setText(qzVar.peD);
            findViewById(R.h.bQo).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.h.bQr);
        if (qzVar.vZa == null || qzVar.vZa.size() <= 0 || TextUtils.isEmpty((CharSequence) qzVar.vZa.get(0))) {
            imageView.setVisibility(8);
            return;
        }
        String str = (String) qzVar.vZa.get(0);
        imageView.setVisibility(0);
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDD = e.bnF;
        o.PB();
        com_tencent_mm_aq_a_a_c_a.hDW = null;
        com_tencent_mm_aq_a_a_c_a.hDC = m.wk(str);
        com_tencent_mm_aq_a_a_c_a.hDA = true;
        com_tencent_mm_aq_a_a_c_a.hDY = false;
        com_tencent_mm_aq_a_a_c_a.hDy = true;
        o.PA().a(str, imageView, com_tencent_mm_aq_a_a_c_a.PK());
    }

    public final void awW() {
        if (this.kWA != null) {
            this.kWA.setVisibility(8);
        }
    }
}

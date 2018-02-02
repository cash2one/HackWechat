package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View kWm;
    private TextView kWn;

    public final void initView() {
    }

    public final void update() {
        if (this.kWm == null) {
            this.kWm = ((ViewStub) findViewById(R.h.bPB)).inflate();
            this.kWn = (TextView) this.kWm.findViewById(R.h.bPC);
        }
        this.kWm.setVisibility(0);
        this.kWm.setOnClickListener(this.kWz.avM());
        b avI = this.kWz.avI();
        if (TextUtils.isEmpty(avI.atB().vSa.vZb)) {
            this.kWn.setText(getString(R.l.dOI));
        } else {
            this.kWn.setText(avI.atB().vSa.vZb);
        }
    }

    public final void awW() {
        if (this.kWm != null) {
            this.kWm.setVisibility(8);
        }
    }
}

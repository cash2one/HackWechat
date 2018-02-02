package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.at.a;
import com.tencent.mm.ui.ac;

class at$e extends a {
    View rFD;
    TextView rFE;
    MaskLinearLayout rFK;
    final /* synthetic */ at rFj;
    MaskImageView rFv;
    TextView riU;

    at$e(at atVar) {
        this.rFj = atVar;
        super(atVar);
    }

    public final void init() {
        super.init();
        this.rFv.setVisibility(8);
        this.riU.setVisibility(8);
        this.rFE.setVisibility(8);
        this.rFD.setVisibility(8);
        if (ac.eu(at.a(this.rFj)) > 1.0f) {
            this.riU.setMaxLines(2);
        }
    }
}

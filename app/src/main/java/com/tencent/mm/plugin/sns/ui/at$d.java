package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.widget.QFadeImageView;

class at$d extends at$a {
    TextView rFA;
    TextView rFB;
    TextView rFC;
    View rFD;
    TextView rFE;
    TextView rFF;
    TextView rFG;
    TextView rFH;
    TextView rFI;
    TextView rFJ;
    MaskLinearLayout rFK;
    final /* synthetic */ at rFj;
    MaskImageView rFv;
    QFadeImageView rFw;
    QFadeImageView rFx;
    QFadeImageView rFy;
    TextView rFz;
    TextView riU;

    at$d(at atVar) {
        this.rFj = atVar;
        super(atVar);
    }

    public final void init() {
        super.init();
        this.rFv.setVisibility(8);
        this.rFx.setVisibility(8);
        this.rFy.setVisibility(8);
        this.riU.setVisibility(8);
        this.rFz.setVisibility(8);
        this.rFA.setVisibility(8);
        this.rFB.setVisibility(8);
        this.rFC.setVisibility(8);
        this.rFD.setVisibility(8);
        this.rFw.setVisibility(8);
        this.rFE.setVisibility(8);
        this.rFF.setVisibility(8);
        this.rFG.setVisibility(8);
        this.rFH.setVisibility(8);
        this.rFI.setVisibility(8);
        this.rFJ.setVisibility(8);
        if (ac.eu(at.a(this.rFj)) > 1.0f) {
            this.riU.setMaxLines(2);
        }
    }
}

package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements c {
    public boolean fuf = false;
    private boolean isVisible = true;
    private String nQt;
    private double nQx = 1000000.0d;
    private double nQy = 1000000.0d;
    private String nSB = "";
    private boolean nTb = true;
    private View nTc;
    private d nTd;
    public String nTe;
    private TextView nTf;
    private TextView nTg;
    public ImageButton nTh;

    public f(d dVar, Context context) {
        View findViewById = ((Activity) context).findViewById(R.h.ctQ);
        this.nTf = (TextView) findViewById.findViewById(R.h.ctO);
        this.nTg = (TextView) findViewById.findViewById(R.h.ctP);
        this.nTh = (ImageButton) findViewById.findViewById(R.h.ctW);
        this.nTd = dVar;
        this.nTc = findViewById;
    }

    public final void setText(String str) {
        this.nQt = str;
        CharSequence charSequence = this.nQt;
        x.d("NewItemOverlay", "popView " + this.nTc.getWidth() + " " + this.nTc.getHeight());
        if (!(charSequence == null || charSequence.equals(""))) {
            this.nTg.setText(charSequence);
        }
        if (this.nTe == null || this.nTe.equals("")) {
            this.nTf.setText(R.l.esY);
        } else {
            this.nTf.setText(this.nTe);
        }
        if (this.nTb) {
            this.nTc.setVisibility(0);
            this.nTc.invalidate();
        }
    }

    public final String aVM() {
        return this.nSB;
    }
}

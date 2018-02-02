package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;

public class DialNumberButton extends RelativeLayout {
    TextView nGT;
    TextView nGU;
    private boolean nGV = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dfu, this);
        this.nGT = (TextView) findViewById(R.h.cbE);
        this.nGU = (TextView) findViewById(R.h.cbF);
        if (d.fM(16)) {
            this.nGT.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nGU.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final String aUj() {
        return this.nGT.getText().toString();
    }

    public final String aUk() {
        return this.nGU.getText().toString();
    }

    public final void gc(boolean z) {
        this.nGV = z;
        if (this.nGV) {
            if ("#".equals(this.nGT.getText()) || "*".equals(this.nGT.getText())) {
                this.nGT.setTextColor(getContext().getResources().getColor(R.e.brY));
            } else {
                this.nGT.setTextColor(getContext().getResources().getColor(R.e.bsa));
            }
            this.nGU.setTextColor(getContext().getResources().getColor(R.e.brY));
            setBackgroundDrawable(getResources().getDrawable(R.g.bBF));
            return;
        }
        if ("#".equals(this.nGT.getText()) || "*".equals(this.nGT.getText())) {
            this.nGT.setTextColor(getContext().getResources().getColor(R.e.brY));
        } else {
            this.nGT.setTextColor(getContext().getResources().getColor(R.e.brZ));
        }
        this.nGU.setTextColor(getContext().getResources().getColor(R.e.brY));
        setBackgroundDrawable(getResources().getDrawable(R.g.bBG));
    }
}

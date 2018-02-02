package com.tencent.mm.ui.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;

public class WelcomeSelectView extends WelcomeView {
    private Context context;
    private int mHeight = 800;
    private View oaU;
    private Button xSQ;
    private Button xSR;
    private TextView xSS;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cd(context);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        cd(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void cd(Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.i.duj, this);
        this.oaU = inflate.findViewById(R.h.cKU);
        this.xSQ = (Button) inflate.findViewById(R.h.cKT);
        this.xSR = (Button) inflate.findViewById(R.h.cLc);
        this.xSS = (TextView) inflate.findViewById(R.h.cZs);
        this.oaU.setVisibility(8);
        this.xSS.setVisibility(8);
        this.xSS.setText(w.g(context, R.c.bqS, R.l.dFv));
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.xSS.setOnClickListener(new 1(this));
        this.xSQ.setOnClickListener(new 2(this, context));
        this.xSR.setOnClickListener(new 3(this, context));
        String e = w.e(this.context.getSharedPreferences(ac.cfs(), 0));
        this.xSS.setText(w.g(this.context, R.c.bqS, R.l.dFv));
        if (e != null && e.equals("language_default")) {
            this.xSS.setText(this.context.getString(R.l.etz));
        }
        this.xSQ.setText(R.l.epA);
        this.xSR.setText(R.l.epz);
    }

    public final void cot() {
        dh(this.oaU);
        dh(this.xSS);
        this.oaU.setVisibility(0);
        this.xSS.setVisibility(0);
        ag.y(new 4(this));
    }
}

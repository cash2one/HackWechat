package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private View mPK;
    private int oHV = b.oHV;
    private int oIb = b.oIb;
    private LinearLayout oIn;
    public LinearLayout oIo;
    public LinearLayout oIp;
    private int oIq;
    private int oIr;
    private int oIs = (b.oHV + b.oHU);
    private int oIt = ((b.oHV * 2) + b.oHU);
    private int oIu = (b.oHV * 4);
    public int oIv;
    public int size = 0;

    public d(Activity activity) {
        this.context = activity.getBaseContext();
        int eA = a.eA(this.context) - (this.oIu * 2);
        this.oIq = (eA - (this.oIs * 10)) / 5;
        this.oIr = (eA - (this.oIt * 10)) / 5;
        eA = (this.oIr * 2) + (this.oHV * 12);
        this.mPK = activity.findViewById(R.h.cCk);
        this.mPK.getLayoutParams().height = eA;
        this.oIn = (LinearLayout) activity.findViewById(R.h.bLH);
        LayoutParams layoutParams = (LayoutParams) this.oIn.getLayoutParams();
        layoutParams.topMargin = this.oHV * 2;
        layoutParams.bottomMargin = this.oHV * 2;
        layoutParams.leftMargin = this.oIu;
        layoutParams.rightMargin = this.oIu;
        this.oIn.setLayoutParams(layoutParams);
        this.oIo = new LinearLayout(this.context);
        this.oIp = new LinearLayout(this.context);
        this.oIo.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.oIp.setLayoutParams(layoutParams2);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.oIp);
        relativeLayout.setLayoutParams(layoutParams2);
        this.oIn.addView(this.oIo);
        this.oIn.addView(relativeLayout);
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.mPK.setVisibility(0);
        } else {
            this.mPK.setVisibility(8);
        }
    }

    public final void FG(String str) {
        this.size++;
        View imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.a(imageView, str, 0.1f, false);
        if (this.size <= 5) {
            this.oIo.addView(imageView);
        } else {
            this.oIp.addView(imageView);
        }
        tk(this.size);
        tl(this.size);
    }

    public final void tk(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oIo.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.oIp.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.oIq;
            this.oIp.setVisibility(8);
            return;
        }
        layoutParams.height = this.oIr;
        layoutParams.topMargin = this.oHV * 2;
        layoutParams.bottomMargin = this.oHV * 2;
        this.oIp.setVisibility(0);
        layoutParams2.height = this.oIr;
        layoutParams2.topMargin = this.oHV * 2;
        layoutParams2.bottomMargin = this.oHV * 2;
    }

    public final void tl(int i) {
        int i2 = 0;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.oIo.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.oIo.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.oIq;
                layoutParams.height = this.oIq;
                layoutParams.rightMargin = this.oIs;
                layoutParams.leftMargin = this.oIs;
            }
            while (i2 < this.oIp.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.oIp.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.oIr;
                layoutParams.height = this.oIr;
                layoutParams.rightMargin = this.oIs;
                layoutParams.leftMargin = this.oIs;
                i2++;
            }
            return;
        }
        for (i3 = 0; i3 < this.oIo.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.oIo.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.oIr;
            layoutParams.height = this.oIr;
            layoutParams.rightMargin = this.oIt;
            layoutParams.leftMargin = this.oIt;
        }
        while (i2 < this.oIp.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.oIp.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.oIr;
            layoutParams.height = this.oIr;
            layoutParams.rightMargin = this.oIt;
            layoutParams.leftMargin = this.oIt;
            i2++;
        }
    }

    public final void onClick(View view) {
        this.oIv++;
    }
}

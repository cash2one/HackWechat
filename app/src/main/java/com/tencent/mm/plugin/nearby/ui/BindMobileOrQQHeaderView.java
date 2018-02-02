package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private ImageView jNs;
    private TextView oOh;
    private int oOi;
    private OnClickListener oOj;

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oOj = new 1(this);
        cd(context);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        this.oOj = new 1(this);
        this.oOi = a.oOm;
        cd(context);
    }

    private void cd(Context context) {
        View inflate = View.inflate(context, R.i.doI, this);
        this.oOh = (TextView) inflate.findViewById(R.h.czf);
        this.jNs = (ImageView) inflate.findViewById(R.h.cyN);
        switch (2.oOl[this.oOi - 1]) {
            case 1:
                setOnClickListener(this.oOj);
                this.jNs.setImageResource(R.k.dBp);
                return;
            case 2:
                setOnClickListener(this.oOj);
                this.jNs.setImageResource(R.k.dBq);
                return;
            default:
                return;
        }
    }
}

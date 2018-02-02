package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private ImageView jNs;
    private TextView oOh;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cd(context);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        cd(context);
    }

    private void cd(Context context) {
        View inflate = View.inflate(context, R.i.doI, this);
        this.oOh = (TextView) inflate.findViewById(R.h.czf);
        this.oOh.setSingleLine(false);
        this.jNs = (ImageView) inflate.findViewById(R.h.cyN);
        this.oOh.setText(R.l.dTG);
        this.jNs.setImageResource(R.k.dAj);
    }
}

package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View lWv;
    private TextView nIu;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        init();
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        rx(i);
    }

    private void init() {
        inflate(getContext(), R.i.dlT, this);
        this.lWv = findViewById(R.h.bXi);
        this.nIu = (TextView) findViewById(R.h.bXh);
    }

    public final void rx(int i) {
        this.nIu.setText(getContext().getResources().getQuantityString(R.j.dun, i, new Object[]{Integer.valueOf(i)}));
    }
}

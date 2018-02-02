package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView extends TextView {
    private int max = 0;
    private int rZf = -1;
    private int sXn = 0;
    private int sXo = 0;
    private boolean sXp = false;
    private final int sXq = 100;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

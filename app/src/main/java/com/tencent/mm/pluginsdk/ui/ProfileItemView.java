package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.x;

public abstract class ProfileItemView extends FrameLayout {
    public x lFr;

    public abstract int bjK();

    public abstract boolean bjL();

    public abstract void init();

    public ProfileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(bjK(), this);
        init();
    }

    public boolean L(x xVar) {
        this.lFr = xVar;
        return bjL();
    }
}

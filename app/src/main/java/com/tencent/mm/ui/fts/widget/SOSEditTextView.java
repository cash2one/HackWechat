package com.tencent.mm.ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;

public class SOSEditTextView extends FTSEditTextView {
    public View zew;

    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void cwY() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.i.dsN, this, true);
    }

    @SuppressLint({"WrongViewCast"})
    protected final void init() {
        super.init();
        this.zew = findViewById(R.h.cWj);
        this.yig.setOnFocusChangeListener(null);
    }

    public final void cxj() {
        this.yig.setOnFocusChangeListener(this.yaq);
    }

    public final void w(Drawable drawable) {
        this.jCP.setImageDrawable(drawable);
    }

    public final void Gy(int i) {
        if (this.zew != null) {
            this.zew.setVisibility(i);
        }
    }
}

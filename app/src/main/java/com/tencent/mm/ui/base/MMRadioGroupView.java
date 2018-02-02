package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.ui.base.MMRadioImageButton.a;

public class MMRadioGroupView extends LinearLayout {
    private int ycW = -1;
    private int ycX = -1;
    private a ycY = new a(this);
    private b ycZ = new b(this, (byte) 0);
    private MMRadioImageButton yda;
    private c ydb;

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnHierarchyChangeListener(this.ycZ);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.ycW != -1) {
            ae(this.ycW, true);
            this.ycW = this.ycW;
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.ycW != -1) {
                    ae(this.ycW, false);
                }
                this.ycW = mMRadioImageButton.getId();
                this.yda = mMRadioImageButton;
            }
        }
        super.addView(view, i, layoutParams);
    }

    private void ae(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.ydb != null) {
            this.ydb.EO(i);
        }
    }
}

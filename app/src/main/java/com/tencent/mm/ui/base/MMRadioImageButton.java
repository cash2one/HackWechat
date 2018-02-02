package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean ydd;
    private boolean yde;
    private boolean ydf;
    private a ydg;
    a ydh;

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yde = true;
    }

    public void toggle() {
        if (!this.yde) {
            if (this.ydg != null) {
                this.ydg.b(this);
            }
            if (this.ydh != null) {
                this.ydh.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.ydf);
        }
    }

    public boolean performClick() {
        toggle();
        return false;
    }

    public boolean isChecked() {
        return this.ydf;
    }

    public void setChecked(boolean z) {
        if (this.ydf != z) {
            this.ydf = z;
            setSelected(this.ydf);
            refreshDrawableState();
            if (!this.ydd) {
                this.ydd = true;
                if (this.ydg != null) {
                    this.ydg.a(this);
                }
                if (this.ydh != null) {
                    this.ydh.a(this);
                }
                this.ydd = false;
            }
        }
    }
}

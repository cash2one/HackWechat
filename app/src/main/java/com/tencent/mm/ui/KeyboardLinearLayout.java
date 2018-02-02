package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    public String TAG;
    private boolean mHasInit;
    private int mHeight;
    private boolean xGN;
    public a xGO;

    public interface a {
        void qI(int i);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
        this.mHasInit = false;
        this.mHeight = 0;
        this.xGN = false;
        this.TAG += getId();
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AE(i4);
    }

    public void AE(int i) {
        if (this.mHasInit) {
            this.mHeight = this.mHeight < i ? i : this.mHeight;
        } else {
            this.mHasInit = true;
            this.mHeight = i;
            x.i(this.TAG, "init height:%d", new Object[]{Integer.valueOf(this.mHeight)});
            if (this.xGO != null) {
                this.xGO.qI(-1);
            }
        }
        if (this.mHasInit && !this.xGN && this.mHeight - i > 100) {
            this.xGN = true;
            qI(-3);
            x.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
        if (this.mHasInit && this.xGN && this.mHeight - i <= 100) {
            this.xGN = false;
            qI(-2);
            x.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
    }

    public void qI(int i) {
        if (this.xGO != null) {
            this.xGO.qI(i);
        }
    }
}

package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.af;

public class MMCallBackScrollView extends ScrollView {
    private af mHandler = new 1(this);
    private int mState = 0;
    private int pmA;
    public a pmB;

    private void uW(int i) {
        if (this.pmB != null && this.mState != i) {
            this.mState = i;
            this.pmB.bp(i);
        }
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.pmA = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                uW(1);
                break;
        }
        return onTouchEvent;
    }
}

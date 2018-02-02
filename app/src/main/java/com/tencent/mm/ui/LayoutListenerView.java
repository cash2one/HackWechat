package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class LayoutListenerView extends FrameLayout {
    private String TAG = "MicroMsg.LayoutListenerView";
    a xHX;

    public interface a {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public LayoutListenerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.xHX != null) {
            this.xHX.onSizeChanged(i, i2, i3, i4);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        x.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        x.d(this.TAG, "jacks onPopulateAccessibilityEvent");
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        x.d(this.TAG, "jacks onInitializeAccessibilityEvent");
    }
}

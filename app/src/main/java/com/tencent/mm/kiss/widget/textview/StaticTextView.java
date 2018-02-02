package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;

public class StaticTextView extends View implements a {
    protected g gTP = new g(this, Ef());

    public StaticTextView(Context context) {
        super(context);
        this.gTP.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTP.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTP.init();
    }

    public final a Ee() {
        if (this.gTP == null) {
            return null;
        }
        return this.gTP.gTR;
    }

    public a Ef() {
        return new a();
    }

    public final void b(a aVar) {
        this.gTP.gTR = aVar;
    }

    public final void O(float f) {
        this.gTP.setTextSize(1, f);
    }

    public final void b(f fVar) {
        this.gTP.b(fVar);
    }

    public final void setTextColor(int i) {
        this.gTP.setTextColor(i);
    }

    public final void Eg() {
        this.gTP.setGravity(16);
    }

    public void setMaxLines(int i) {
        this.gTP.setMaxLines(i);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        this.gTP.setText(charSequence, z);
        setContentDescription(charSequence);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.gTP != null) {
            this.gTP.Ej();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.gTP != null) {
            this.gTP.Ej();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final CharSequence getText() {
        return this.gTP.getText();
    }

    public final float getTextSize() {
        return this.gTP.getTextSize();
    }

    public final Layout Eh() {
        return this.gTP.Eh();
    }

    public final f Ei() {
        if (this.gTP == null) {
            return null;
        }
        return this.gTP.Ei();
    }

    public final int getLineCount() {
        return this.gTP.getLineCount();
    }

    public final int getLineHeight() {
        return this.gTP.getLineHeight();
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.gTP != null) {
            this.gTP.gTX = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gTP.Eh() == null) {
            return false;
        }
        boolean v = this.gTP.v(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (v) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.gTP != null && this.gTP.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gTP != null) {
            this.gTP.onDraw(canvas);
        }
    }

    public final int DZ() {
        if (this.gTP == null) {
            return 0;
        }
        return this.gTP.gTU;
    }

    public final int Ea() {
        if (this.gTP == null) {
            return 0;
        }
        return this.gTP.gTV;
    }

    public void onMeasure(int i, int i2) {
        if (this.gTP == null) {
            super.onMeasure(i, i2);
            return;
        }
        Point aU = this.gTP.aU(i, i2);
        if (aU != null) {
            setMeasuredDimension(aU.x, aU.y);
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!bh.M(this.gTP.getText())) {
            accessibilityEvent.getText().add(this.gTP.getText());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!bh.M(this.gTP.getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(WXMediaMessage.TITLE_LENGTH_LIMIT);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.fM(18)) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && d.fM(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(WXMediaMessage.THUMB_LENGTH_LIMIT);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.fM(19)) {
            g gVar = this.gTP;
            if ((gVar.gTR != null ? gVar.gTR.maxLines : -1) > 1) {
                accessibilityNodeInfo.setMultiLine(true);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(this.gTP.getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(this.gTP.getText()));
            if (!bh.M(this.gTP.getText())) {
                accessibilityEvent.setItemCount(this.gTP.getText().length());
            }
        }
    }
}

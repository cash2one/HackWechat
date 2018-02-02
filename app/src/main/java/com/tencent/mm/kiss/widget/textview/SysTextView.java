package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean gUd = false;
    private static Field gUe = null;
    public g gTP = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setText(" ", BufferType.SPANNABLE);
        this.gTP.gTR = new a();
        this.gTP.gTR.textColor = super.getTextColors().getDefaultColor();
        this.gTP.gTR.gTD = super.getEllipsize();
        this.gTP.gTR.gravity = super.getGravity();
        this.gTP.gTR.gUh = super.getTextSize();
        if (!gUd) {
            try {
                if (gUe == null) {
                    Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                    gUe = declaredField;
                    declaredField.setAccessible(true);
                }
                if (gUe.getBoolean(this)) {
                    this.gTP.gTR.maxLines = 1;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
                gUd = true;
            }
        }
    }

    protected final f Ei() {
        if (this.gTP == null) {
            return null;
        }
        return this.gTP.Ei();
    }

    public final a Ee() {
        if (this.gTP == null) {
            return null;
        }
        return this.gTP.gTR;
    }

    public void setSingleLine(boolean z) {
        if (this.gTP != null) {
            this.gTP.setSingleLine(z);
        }
    }

    public void setLines(int i) {
        if (this.gTP != null) {
            this.gTP.setLines(i);
        }
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        q(charSequence);
    }

    public final void q(CharSequence charSequence) {
        if (this.gTP == null) {
            super.setText("");
        } else {
            this.gTP.setText(charSequence, false);
        }
    }

    public void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        if (this.gTP != null) {
            this.gTP.setTextSize(i, f);
        }
    }

    public void setTextColor(int i) {
        if (this.gTP != null) {
            this.gTP.setTextColor(i);
        }
    }

    public void setGravity(int i) {
        if (this.gTP != null) {
            this.gTP.setGravity(i);
        }
    }

    public void setMaxLines(int i) {
        if (this.gTP != null) {
            this.gTP.setMaxLines(i);
        }
    }

    public void setMinLines(int i) {
        if (this.gTP != null) {
            g gVar = this.gTP;
            if (gVar.gTR.minLines != i) {
                gVar.gTR.minLines = i;
                gVar.Ej();
                gVar.gUa.requestLayout();
                gVar.gUa.invalidate();
            }
        }
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

    public CharSequence getText() {
        if (this.gTP == null) {
            return null;
        }
        return this.gTP.getText();
    }

    public float getTextSize() {
        if (this.gTP == null) {
            return 0.0f;
        }
        return this.gTP.getTextSize();
    }

    public int getLineCount() {
        if (this.gTP == null) {
            return 0;
        }
        return this.gTP.getLineCount();
    }

    public int getLineHeight() {
        if (this.gTP == null) {
            return 0;
        }
        return this.gTP.getLineHeight();
    }

    public int getSelectionStart() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionStart(getText());
    }

    public int getSelectionEnd() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionEnd(getText());
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
        try {
            if (this.gTP != null) {
                this.gTP.onDraw(canvas);
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
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

    protected void onMeasure(int i, int i2) {
        try {
            Point aU = this.gTP.aU(i, i2);
            if (aU != null) {
                setMeasuredDimension(aU.x, aU.y);
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e2, "", new Object[0]);
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

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        try {
            super.onProvideStructure(viewStructure);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            return -1;
        }
    }
}

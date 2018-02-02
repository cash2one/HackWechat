package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.neattextview.textview.view.NeatTextView;

public class MMNeatTextView extends NeatTextView {
    public static boolean ztU = false;
    private static final String ztV = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, f.CTRL_INDEX);
    public boolean Ec = true;
    private GestureDetector jtw = new GestureDetector(getContext(), new 1(this));
    private OnLongClickListener ztW;
    public a ztX;
    public b ztY;

    static /* synthetic */ String aal(String str) {
        String replaceAll = str.replaceAll(ztV, "*");
        StringBuilder stringBuilder = new StringBuilder(replaceAll);
        stringBuilder.append('\n');
        stringBuilder.append('[');
        char[] toCharArray = replaceAll.toCharArray();
        for (char c : toCharArray) {
            if (c != '*') {
                stringBuilder.append("{\\u").append(String.format("%x", new Object[]{Integer.valueOf(toCharArray[r0])})).append("}");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public MMNeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final float cyL() {
        if (!ztU) {
            return super.cyL();
        }
        float measuredHeight = (float) getMeasuredHeight();
        x.i("MicroMsg.MMNeatTextView_changelcai", "text:%s [getVerticalOffset] offset:%s height:%s ,layout height:%s", new Object[]{this.mText, Float.valueOf(super.cyL()), Float.valueOf(measuredHeight), Float.valueOf(this.zKZ.cCv()[1])});
        return super.cyL();
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        x.d("MicroMsg.MMNeatTextView", "[isOpen] %s", new Object[]{Boolean.valueOf(false)});
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            int i = 1;
        } else {
            isTouchExplorationEnabled = false;
        }
        if (i != 0 || b.ceK()) {
            return this.mText;
        }
        return "";
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.Ec || (this.zwR && this.jtw != null)) {
            this.jtw.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean cyM() {
        return this.Ec;
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[onDraw] replaceContent:%s exception:%s", new Object[]{this.mText.toString().replaceAll(ztV, "*"), e});
            if (this.ztY != null) {
                this.ztY.a(e, r1, "onDraw");
                return;
            }
            throw e;
        }
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[onMeasure] replaceContent:%s exception:%s", new Object[]{this.mText.toString().replaceAll(ztV, "*"), e});
            if (this.ztY != null) {
                this.ztY.a(e, r1, "onMeasure");
                return;
            }
            throw e;
        }
    }

    public final void V(CharSequence charSequence) {
        try {
            super.V(charSequence);
            if (this.zwR && this.ztY != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[_setText] replaceContent:%s exception:%s", new Object[]{this.mText.toString().replaceAll(ztV, "*"), e});
            if (this.ztY != null) {
                this.ztY.a(e, r1, "_setText");
            } else {
                throw e;
            }
        }
        if (this.ztX != null) {
            a aVar = this.ztX;
            BufferType bufferType;
            if (charSequence instanceof Spannable) {
                bufferType = BufferType.SPANNABLE;
            } else {
                bufferType = BufferType.NORMAL;
            }
            aVar.T(charSequence);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.ztW = onLongClickListener;
        super.setOnLongClickListener(new 2(this));
    }
}

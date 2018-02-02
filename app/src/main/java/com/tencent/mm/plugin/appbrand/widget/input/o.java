package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.m.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.plugin.appbrand.widget.b.e;
import com.tencent.mm.plugin.appbrand.widget.g.a;
import com.tencent.mm.plugin.appbrand.widget.input.af.b;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends w {
    private a jUP;
    private final InputFilter jYa = new 4(this);
    private float jYb = 0.0f;
    float jYc = 1.2f;
    private float jYd = getTextSize();
    private boolean jYe = false;
    private MotionEvent jYf;
    private boolean jYg = false;
    final ac<o> jYh = new ac(this);
    private float jux;

    public o(Context context) {
        super(context);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new Factory(this) {
            final /* synthetic */ o jYi;

            {
                this.jYi = r1;
            }

            public final Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(this.jYi.jUP == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(this.jYi.jUP, 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        });
        super.a(new 2(this));
        super.setOnLongClickListener(new 3(this));
        this.jux = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        du(false);
        a(0.0f, false);
    }

    final Editable c(Editable editable) {
        Editable c = super.c(editable);
        if (!(this.jUP == null || TextUtils.isEmpty(c))) {
            c.setSpan(this.jUP, 0, c.length(), 18);
        }
        return c;
    }

    public final void du(boolean z) {
        this.jYe = z;
        setVerticalScrollBarEnabled(!this.jYe);
    }

    protected final void amJ() {
        if (!this.jYe) {
            return;
        }
        if (getMeasuredHeight() > getMaxHeight()) {
            setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
            setMeasuredDimension(getMeasuredWidth(), getMinHeight());
        }
    }

    public final void setGravity(int i) {
        super.setGravity(((i & -81) & -17) | 48);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        super.setInputType(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | i);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.jYa != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jYa;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    final void a(float f, boolean z) {
        if (f <= 0.0f) {
            f = (this.jYc * this.jYd) + this.jYb;
        }
        if (this.jUP == null || this.jUP.ad(f)) {
            this.jUP = new a(f);
            if (!z) {
                return;
            }
            if (hasFocus()) {
                invalidate();
                return;
            }
            anf();
            setText(getEditableText());
            ang();
        }
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        return super.getLineSpacingMultiplier();
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.jYd = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        a(0.0f, true);
    }

    public final int getLineHeight() {
        if (this.jUP != null) {
            return this.jUP.height;
        }
        return super.getLineHeight();
    }

    public final void setLineSpacing(float f, float f2) {
        this.jYb = f;
        this.jYc = f2;
        a(0.0f, true);
    }

    public final View getInputPanel() {
        return u.bY(this);
    }

    public final boolean amK() {
        return true;
    }

    public final boolean amL() {
        return false;
    }

    public final void amM() {
        af.cd(this).restartInput(this);
    }

    public final boolean ams() {
        if (!this.jYe) {
            anb();
            getMeasuredHeight();
        }
        return (isFocusable() || amO()) ? false : true;
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public final void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final boolean canScrollVertically(int i) {
        if (anb() <= getHeight()) {
            return false;
        }
        return super.canScrollVertically(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        float y;
        float x;
        if (!ams() || !(getParent() instanceof e)) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.jYf = MotionEvent.obtain(motionEvent);
                    this.jYg = true;
                    break;
                case 1:
                case 3:
                    this.jYg = false;
                    if (this.jYf != null) {
                        this.jYf.recycle();
                        this.jYf = null;
                    }
                    if (this.jYg) {
                        int a = b.a(this, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()));
                        if (a >= 0) {
                            setSelection(a);
                        }
                    }
                    if (getParent() == null) {
                        return true;
                    }
                    break;
                case 2:
                    if (this.jYg) {
                        float x2 = this.jYf.getX(this.jYf.getActionIndex());
                        y = this.jYf.getY(this.jYf.getActionIndex());
                        x = motionEvent.getX(motionEvent.getActionIndex());
                        float y2 = motionEvent.getY(motionEvent.getActionIndex());
                        if (Math.abs(x2 - x) > this.jux || Math.abs(y - y2) > this.jux) {
                            cancelLongPress();
                            setPressed(false);
                            this.jYg = false;
                            break;
                        }
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        } else if (motionEvent.getActionMasked() == 0 && !((e) getParent()).D(motionEvent)) {
            return false;
        } else {
            ac acVar = this.jYh;
            com.tencent.mm.plugin.appbrand.widget.b.b.a(acVar.TAG, "processTouchEvent", motionEvent);
            View view = acVar.jZo;
            int actionIndex = motionEvent.getActionIndex();
            x = motionEvent.getX(actionIndex);
            y = motionEvent.getY(actionIndex);
            if (motionEvent.getActionMasked() == 0 || acVar.jZr != null) {
                float f;
                boolean z;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        acVar.jZr = MotionEvent.obtain(motionEvent);
                        acVar.jZq = c.bI(view);
                        if (view != null) {
                            ViewParent parent = view.getParent();
                            while (parent != null && (parent instanceof ViewGroup)) {
                                if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                                    actionIndex = 1;
                                    view.removeCallbacks(acVar.jZt);
                                    if (actionIndex == 0) {
                                        view.postDelayed(acVar.jZt, (long) ViewConfiguration.getTapTimeout());
                                    } else {
                                        acVar.jZt.run();
                                    }
                                    actionIndex = 1;
                                    break;
                                }
                                parent = parent.getParent();
                            }
                        }
                        z = false;
                        view.removeCallbacks(acVar.jZt);
                        if (actionIndex == 0) {
                            acVar.jZt.run();
                        } else {
                            view.postDelayed(acVar.jZt, (long) ViewConfiguration.getTapTimeout());
                        }
                        actionIndex = 1;
                        break;
                    case 1:
                        x.v(acVar.TAG, "[apptouch] ACTION_UP, pointerDown %B", new Object[]{Boolean.valueOf(acVar.jZs)});
                        if (acVar.jZs && acVar.jZr != null) {
                            f bI = c.bI(acVar.jZo);
                            if (acVar.jZq == null || Math.abs(acVar.jZq.x - bI.x) > 1.0f || Math.abs(acVar.jZq.y - bI.y) > 1.0f) {
                                x.v(acVar.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
                            } else if (acVar.a(acVar.jZr, motionEvent)) {
                                ((z) view).r(x, y);
                            } else {
                                x.v(acVar.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
                            }
                        }
                        acVar.ani();
                        actionIndex = 0;
                        break;
                    case 2:
                        f = acVar.jZp;
                        if (x < (-f) || y < (-f) || x >= ((float) view.getWidth()) + f || y >= ((float) view.getHeight()) + f) {
                            z = false;
                        } else {
                            actionIndex = 1;
                        }
                        if (actionIndex != 0 && acVar.a(acVar.jZr, motionEvent)) {
                            actionIndex = 1;
                            break;
                        }
                        acVar.jZs = false;
                        view.removeCallbacks(acVar.jZt);
                        view.removeCallbacks(acVar.jZu);
                        actionIndex = 0;
                        break;
                        break;
                    case 3:
                        acVar.ani();
                        actionIndex = 0;
                        break;
                    default:
                        actionIndex = 0;
                        break;
                }
                TextView textView = acVar.jZo;
                CharSequence text = acVar.jZo.getText();
                if (textView.canScrollVertically(-1) || textView.canScrollVertically(1)) {
                    ae.a[] aVarArr;
                    int scaledTouchSlop;
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            aVarArr = (ae.a[]) text.getSpans(0, text.length(), ae.a.class);
                            for (Object removeSpan : aVarArr) {
                                text.removeSpan(removeSpan);
                            }
                            text.setSpan(new ae.a(motionEvent.getX(), motionEvent.getY(), textView.getScrollX(), textView.getScrollY()), 0, 0, 17);
                            break;
                        case 1:
                        case 3:
                            aVarArr = ae.e(textView);
                            if (aVarArr == null || aVarArr.length <= 0 || !aVarArr[0].jZG) {
                                i = 0;
                                break;
                            }
                        case 2:
                            aVarArr = (ae.a[]) text.getSpans(0, text.length(), ae.a.class);
                            if (aVarArr.length > 0) {
                                if (!aVarArr[0].jZF) {
                                    scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                                    if (Math.abs(motionEvent.getX() - aVarArr[0].abo) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - aVarArr[0].abp) >= ((float) scaledTouchSlop)) {
                                        aVarArr[0].jZF = true;
                                    }
                                }
                                if (aVarArr[0].jZF) {
                                    aVarArr[0].jZG = true;
                                    boolean z2 = ((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(text, 1) != 1 && MetaKeyKeyListener.getMetaState(text, 2048) == 0) ? false : true;
                                    if (z2) {
                                        f = motionEvent.getX() - aVarArr[0].abo;
                                        x = motionEvent.getY() - aVarArr[0].abp;
                                    } else {
                                        f = aVarArr[0].abo - motionEvent.getX();
                                        x = aVarArr[0].abp - motionEvent.getY();
                                    }
                                    aVarArr[0].abo = motionEvent.getX();
                                    aVarArr[0].abp = motionEvent.getY();
                                    if (aVarArr[0].jZI) {
                                        aVarArr[0].jZI = false;
                                        aVarArr[0].jZF = false;
                                    } else {
                                        int scrollX = ((int) f) + textView.getScrollX();
                                        scaledTouchSlop = ((int) x) + textView.getScrollY();
                                        int totalPaddingTop = textView.getTotalPaddingTop() + textView.getTotalPaddingBottom();
                                        Layout layout = textView.getLayout();
                                        totalPaddingTop = Math.max(Math.min(scaledTouchSlop, layout.getHeight() - (textView.getHeight() - totalPaddingTop)), 0);
                                        int scrollX2 = textView.getScrollX();
                                        int scrollY = textView.getScrollY();
                                        int width = textView.getWidth() - (textView.getTotalPaddingLeft() + textView.getTotalPaddingRight());
                                        scaledTouchSlop = layout.getLineForVertical(totalPaddingTop);
                                        Alignment paragraphAlignment = layout.getParagraphAlignment(scaledTouchSlop);
                                        if (layout.getParagraphDirection(scaledTouchSlop) > 0) {
                                            scaledTouchSlop = 1;
                                        } else {
                                            z2 = false;
                                        }
                                        int i2 = width + 0;
                                        scaledTouchSlop = i2 < width ? paragraphAlignment == Alignment.ALIGN_CENTER ? 0 - ((width - i2) / 2) : ((scaledTouchSlop == 0 || paragraphAlignment != Alignment.ALIGN_OPPOSITE) && !(scaledTouchSlop == 0 && paragraphAlignment == Alignment.ALIGN_NORMAL)) ? 0 : 0 - (width - i2) : Math.max(Math.min(scrollX, 0), 0);
                                        textView.scrollTo(scaledTouchSlop, totalPaddingTop);
                                        if (scrollX2 != textView.getScrollX() || scrollY != textView.getScrollY()) {
                                            textView.cancelLongPress();
                                            aVarArr[0].jZH = true;
                                            break;
                                        } else if (!aVarArr[0].jZH) {
                                            ae.e(textView);
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
                i = 0;
                boolean z3 = actionIndex | i;
                com.tencent.mm.plugin.appbrand.widget.b.b.a(acVar.TAG, "[textscroll] handled | " + z3, motionEvent);
                return z3;
            }
            x.v(acVar.TAG, "[textscroll] no pointer down before, just return");
            acVar.ani();
            return false;
        }
    }

    public final void r(float f, float f2) {
        if (isEnabled()) {
            if (ams()) {
                int a = b.a(this, f, f2);
                if (a >= 0) {
                    setSelection(a);
                }
            }
            super.performClick();
        }
    }

    public final boolean performHapticFeedback(int i, int i2) {
        return super.performHapticFeedback(i, i2);
    }
}

package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.layout.NeatLayout;
import com.tencent.smtt.sdk.WebView;

public class NeatTextView extends View implements a {
    private static final LruCache<a, com.tencent.neattextview.textview.layout.b> zLn = new LruCache(500);
    private static final HandlerThread zLo;
    private static Handler zLp;
    private static final LruCache<String, Boolean> zwX = new LruCache(500);
    private int KD = 0;
    private ColorStateList ek;
    public TextPaint gu;
    private int iX = Integer.MAX_VALUE;
    private CharSequence kV;
    public CharSequence mText;
    private int nxD = Integer.MAX_VALUE;
    private int vqO = Integer.MAX_VALUE;
    private int yfE;
    private TruncateAt yfH;
    private float yfN = 0.0f;
    public com.tencent.neattextview.textview.layout.b zKZ;
    public TextView zLq;
    private ColorStateList zLr;
    private ColorStateList zLs;
    private int zLt;
    private b zLu;
    private boolean zLv = true;
    public b zLw;
    private boolean zLx = true;
    private d zLy;
    public boolean zwR;
    private int zxD = 8388659;
    private int zxw = 0;

    public interface b {
        boolean dF(View view);
    }

    public interface c extends OnTouchListener {
    }

    static final class d implements Runnable {
        static TextPaint gTB = new TextPaint();
        volatile boolean hik = false;
        String text;
        float[] zLD;

        d(String str, TextPaint textPaint) {
            gTB.set(textPaint);
            this.text = str;
        }

        public final float[] cCq() {
            return this.hik ? this.zLD : null;
        }

        public final void run() {
            this.zLD = new float[this.text.length()];
            gTB.getTextWidths(this.text, this.zLD);
            this.hik = true;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("PreMeasuredThread", -8);
        zLo = handlerThread;
        handlerThread.start();
        Looper looper = zLo.getLooper();
        if (looper != null) {
            zLp = new Handler(looper);
        }
    }

    public NeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public NeatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.zLu = new b(getContext(), this);
        TextView textView = new TextView(context);
        textView.setClickable(true);
        textView.setFocusable(true);
        this.zLq = textView;
        this.gu = this.zLq.getPaint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.faL, i, 0);
        int i2 = WebView.NIGHT_MODE_COLOR;
        int i3 = -7829368;
        int i4 = -16776961;
        int i5 = -1;
        int i6 = 0;
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            CharSequence charSequence = null;
            i6 = -1;
            i5 = -16776961;
            i4 = -7829368;
            i3 = WebView.NIGHT_MODE_COLOR;
            i2 = 15;
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == a.zJV) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, 15);
                } else if (index == a.zJW) {
                    i3 = obtainStyledAttributes.getColor(index, WebView.NIGHT_MODE_COLOR);
                } else if (index == a.zKl) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        index = 1;
                    } else {
                        index = -1;
                    }
                    setMaxLines(index);
                } else if (index == a.zKi) {
                    index = obtainStyledAttributes.getInt(index, -1);
                    this.nxD = index;
                    this.zLq.setLines(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKa) {
                    index = obtainStyledAttributes.getInt(index, 16);
                    this.zLq.setGravity(index);
                    if ((8388615 & index) == 0) {
                        index |= 8388611;
                    }
                    if ((index & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                        index |= 48;
                    }
                    this.zxD = index;
                    if (index != this.zxD) {
                        invalidate();
                    }
                } else if (index == a.zKb) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.iX = index;
                    this.zLq.setMaxWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKm) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.yfN);
                    this.yfN = (float) index;
                    this.zLq.setLineSpacing((float) index, 1.0f);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKd) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.KD = index;
                    this.zLq.setMinWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKe) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.zxw = index;
                    this.zLq.setMinHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKc) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.vqO = index;
                    this.zLq.setMaxHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKh) {
                    setMaxLines(obtainStyledAttributes.getInt(index, -1));
                } else if (index == a.zKf) {
                    charSequence = obtainStyledAttributes.getString(index);
                } else if (index == a.zKk) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.iX = index;
                    this.zLq.setMaxWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKj) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.vqO = index;
                    this.zLq.setMaxHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == a.zKg) {
                    this.kV = TextUtils.stringOrSpannedString(obtainStyledAttributes.getText(index));
                    this.zLq.setHint(this.kV);
                    if (TextUtils.isEmpty(this.mText)) {
                        cCC();
                    }
                } else if (index == a.zJX) {
                    i4 = obtainStyledAttributes.getColor(index, -7829368);
                } else if (index == a.zJY) {
                    i5 = obtainStyledAttributes.getColor(index, -16776961);
                } else if (index == a.zJZ) {
                    i6 = obtainStyledAttributes.getInt(index, i6);
                } else if (index == a.zKn) {
                    this.zLx = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            this.ek = ColorStateList.valueOf(i3);
            this.zLq.setTextColor(i3);
            updateTextColors();
            ai((float) i2);
            this.zLs = ColorStateList.valueOf(i5);
            updateTextColors();
            this.zLr = ColorStateList.valueOf(i4);
            this.zLq.setHintTextColor(i4);
            updateTextColors();
            switch (i6) {
                case 1:
                    setEllipsize(TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TruncateAt.END);
                    break;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                V(charSequence);
            }
            this.zLq.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final com.tencent.neattextview.textview.layout.b cCz() {
        return this.zKZ;
    }

    public final b cCA() {
        return this.zLw;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zLu == null || !this.zLu.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onMeasure(int i, int i2) {
        if (TextUtils.isEmpty(this.mText) && TextUtils.isEmpty(this.kV)) {
            super.onMeasure(i, i2);
        } else if (this.zwR) {
            this.zLq.measure(i, i2);
            setMeasuredDimension(this.zLq.getMeasuredWidth(), this.zLq.getMeasuredHeight());
        } else {
            int i3;
            int i4;
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (size <= 0 && mode2 == 0) {
                size = getResources().getDisplayMetrics().widthPixels;
            }
            if (size2 <= 0 && mode2 == 0) {
                size2 = Integer.MAX_VALUE;
            }
            if (this.iX <= 0 || this.iX >= size) {
                i3 = size;
            } else {
                i3 = this.iX;
            }
            if (this.vqO <= 0 || this.vqO >= size2) {
                i4 = size2;
            } else {
                i4 = this.vqO;
            }
            size2 = (i3 - getPaddingLeft()) - getPaddingRight();
            size = (i4 - getPaddingTop()) - getPaddingBottom();
            a aVar = new a(this, this.mText, new int[]{size2, size}, this.gu.getTextSize(), this.gu.getFontMetricsInt());
            this.zKZ = (com.tencent.neattextview.textview.layout.b) zLn.get(aVar);
            if (this.zKZ == null) {
                if (!TextUtils.isEmpty(this.mText) || TextUtils.isEmpty(this.kV)) {
                    this.zKZ = new NeatLayout(this.mText, this.zLy == null ? null : this.zLy.cCq());
                } else {
                    this.zKZ = new NeatLayout(this.kV, this.zLy == null ? null : this.zLy.cCq());
                }
                this.zKZ.a(this.gu, (float) aVar.zLB[0], (float) aVar.zLB[1], this.yfN, this.nxD, this.yfH, this.zLx);
                zLn.put(aVar, this.zKZ);
            }
            float[] cCv = this.zKZ.cCv();
            if (mode != 1073741824) {
                i3 = (int) Math.min((cCv[0] + ((float) getPaddingLeft())) + ((float) getPaddingRight()), (float) this.iX);
            }
            if (mode2 != 1073741824) {
                i4 = (int) Math.min((cCv[1] + ((float) getPaddingTop())) + ((float) getPaddingBottom()), (float) this.vqO);
            }
            setMeasuredDimension(Math.max(i3, this.KD), Math.max(i4, this.zxw));
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.yfE;
        if (!(TextUtils.isEmpty(this.kV) || !TextUtils.isEmpty(this.mText) || this.zLr == null)) {
            i = this.zLt;
        }
        this.gu.setColor(i);
        this.gu.drawableState = getDrawableState();
        if (this.zwR) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            Layout layout = this.zLq.getLayout();
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
        } else if (this.zKZ != null) {
            this.zKZ.a(canvas, (float) getPaddingLeft(), cyL());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void V(CharSequence charSequence) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = "";
        }
        this.mText = charSequence;
        if (cyM()) {
            String charSequence2 = charSequence.toString();
            Boolean bool = (Boolean) zwX.get(charSequence2);
            boolean z2;
            if (bool == null) {
                z2 = !charSequence2.matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$");
                zwX.put(charSequence2, Boolean.valueOf(z2));
            } else {
                z2 = bool.booleanValue();
            }
        }
        z = true;
        this.zwR = z;
        if (this.zwR) {
            this.zLq.setLayoutParams(getLayoutParams());
            this.zLq.setText(charSequence);
            requestLayout();
            invalidate();
            return;
        }
        cCC();
    }

    public float cyL() {
        if ((this.zxD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 48 || this.zKZ == null) {
            return (float) getPaddingTop();
        }
        return (((float) getMeasuredHeight()) - this.zKZ.cCv()[1]) / 2.0f;
    }

    public final float cCB() {
        if ((this.zxD & 7) == 3 || this.zKZ == null) {
            return (float) getPaddingLeft();
        }
        return (((float) getMeasuredHeight()) - this.zKZ.cCv()[0]) / 2.0f;
    }

    private void setEllipsize(TruncateAt truncateAt) {
        if (this.yfH != truncateAt) {
            this.yfH = truncateAt;
            if (this.zKZ != null) {
                this.zKZ = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            this.zKZ = null;
        }
        super.setPadding(i, i2, i3, i4);
        this.zLq.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public boolean cyM() {
        return this.zLv;
    }

    private void setMaxLines(int i) {
        this.nxD = i;
        this.zLq.setMaxLines(i);
        requestLayout();
        invalidate();
    }

    private void cCC() {
        this.zKZ = null;
        if (zLp != null) {
            Handler handler;
            Runnable dVar;
            if (this.mText == null && this.kV != null) {
                handler = zLp;
                dVar = new d(this.kV.toString(), this.gu);
                this.zLy = dVar;
                handler.post(dVar);
            } else if (this.mText != null) {
                handler = zLp;
                dVar = new d(this.mText.toString(), this.gu);
                this.zLy = dVar;
                handler.post(dVar);
            } else {
                return;
            }
        }
        requestLayout();
        invalidate();
    }

    private void updateTextColors() {
        int colorForState = this.ek.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yfE) {
            this.yfE = colorForState;
            colorForState = 1;
        } else {
            colorForState = 0;
        }
        if (this.zLs != null) {
            int colorForState2 = this.zLs.getColorForState(getDrawableState(), 0);
            if (colorForState2 != this.gu.linkColor) {
                this.gu.linkColor = colorForState2;
                colorForState = 1;
            }
        }
        if (this.zLr != null) {
            int colorForState3 = this.zLr.getColorForState(getDrawableState(), 0);
            if (colorForState3 != this.zLt) {
                this.zLt = colorForState3;
                if (this.mText == null || this.mText.length() == 0) {
                    colorForState = 1;
                }
            }
        }
        if (colorForState != 0) {
            invalidate();
        }
    }

    public final void ai(float f) {
        if (f != this.gu.getTextSize()) {
            this.gu.setTextSize(f);
            if (this.zKZ != null) {
                cCC();
                requestLayout();
                invalidate();
            }
        }
    }
}

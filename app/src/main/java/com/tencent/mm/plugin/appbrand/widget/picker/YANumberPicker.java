package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.tencent.mm.plugin.appbrand.q$l;
import com.tencent.smtt.sdk.WebView;

public class YANumberPicker extends View {
    private int Sb = 2;
    private VelocityTracker ft;
    private q iK;
    private float iQL = 0.0f;
    private int kdA = -695533;
    private int kdB = 0;
    private int kdC = 0;
    private int kdD = 0;
    private int kdE = 0;
    private int kdF = 0;
    private int kdG = 0;
    private int kdH = 0;
    int kdI = 0;
    private int kdJ = 0;
    int kdK = -695533;
    private int kdL = 0;
    private int kdM = 0;
    private int kdN = 3;
    private int kdO = 0;
    private int kdP = 0;
    private int kdQ = -1;
    private int kdR = -1;
    int kdS = 0;
    int kdT = 0;
    private int kdU = 0;
    private int kdV = 0;
    private int kdW = 0;
    private int kdX = 0;
    private int kdY = 0;
    private int kdZ = 150;
    int kdy = -13421773;
    int kdz = -695533;
    private b keA;
    private int keB;
    private int keC;
    private int keD;
    private int keE;
    private float keF = 0.0f;
    private float keG = 0.0f;
    private boolean keH = false;
    private int keI;
    private int keJ;
    private int keK;
    private float keL;
    private float keM;
    private float keN;
    private int keO = 0;
    private int keP = 0;
    private int keQ = 0;
    private int keR = 0;
    private int keS = 0;
    private int kea = 8;
    private String keb;
    public String kec;
    private String ked;
    private String kee;
    private float kef = 1.0f;
    private float keg = 0.0f;
    private float keh = 0.0f;
    private float kei = 0.0f;
    private boolean kej = true;
    private boolean kek = true;
    private boolean kel = false;
    private boolean kem = true;
    private boolean ken = false;
    private boolean keo = false;
    private boolean kep = true;
    Paint keq = new Paint();
    private TextPaint ker = new TextPaint();
    private Paint kes = new Paint();
    private String[] ket;
    private CharSequence[] keu;
    private CharSequence[] kev;
    private Handler kew;
    private Handler kex;
    public a kez;
    private HandlerThread mHandlerThread;
    private boolean mHasInit = false;
    private int yi = 0;

    public interface b {
    }

    static /* synthetic */ void a(YANumberPicker yANumberPicker, int i, int i2, Object obj) {
        yANumberPicker.mp(0);
        if (i != i2 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && yANumberPicker.kez != null)) {
            yANumberPicker.kez.a(yANumberPicker, yANumberPicker.kdS + i2);
        }
        yANumberPicker.kdY = i2;
        if (yANumberPicker.ken) {
            yANumberPicker.ken = false;
            yANumberPicker.z(yANumberPicker.anQ() - yANumberPicker.kdQ, false);
            yANumberPicker.kek = false;
            yANumberPicker.postInvalidate();
        }
    }

    public YANumberPicker(Context context) {
        super(context);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        init(context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q$l.iCd);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == q$l.iCe) {
                    this.kdN = obtainStyledAttributes.getInt(index, 3);
                } else if (index == q$l.iCg) {
                    this.kdK = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == q$l.iCj) {
                    this.Sb = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == q$l.iCh) {
                    this.kdL = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == q$l.iCi) {
                    this.kdM = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == q$l.iCq) {
                    String[] strArr;
                    CharSequence[] textArray = obtainStyledAttributes.getTextArray(index);
                    if (textArray == null) {
                        strArr = null;
                    } else {
                        String[] strArr2 = new String[textArray.length];
                        for (index = 0; index < textArray.length; index++) {
                            strArr2[index] = textArray[index].toString();
                        }
                        strArr = strArr2;
                    }
                    this.ket = strArr;
                } else if (index == q$l.iCk) {
                    this.kdy = obtainStyledAttributes.getColor(index, -13421773);
                } else if (index == q$l.iCl) {
                    this.kdz = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == q$l.iCm) {
                    this.kdA = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == q$l.iCn) {
                    this.kdB = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 13.0f));
                } else if (index == q$l.iCo) {
                    this.kdC = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 15.0f));
                } else if (index == q$l.iCp) {
                    this.kdD = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 14.0f));
                } else if (index == q$l.iCr) {
                    this.kdQ = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == q$l.iCs) {
                    this.kdR = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == q$l.iCt) {
                    this.kek = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == q$l.iCf) {
                    this.kej = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == q$l.iCv) {
                    this.keb = obtainStyledAttributes.getString(index);
                } else if (index == q$l.iCF) {
                    this.kee = obtainStyledAttributes.getString(index);
                } else if (index == q$l.iCw) {
                    this.ked = obtainStyledAttributes.getString(index);
                } else if (index == q$l.iCx) {
                    this.kdG = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
                } else if (index == q$l.iCy) {
                    this.kdH = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
                } else if (index == q$l.iCA) {
                    this.kdI = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 2.0f));
                } else if (index == q$l.iCz) {
                    this.kdJ = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 5.0f));
                } else if (index == q$l.iCD) {
                    this.keu = obtainStyledAttributes.getTextArray(index);
                } else if (index == q$l.iCE) {
                    this.kev = obtainStyledAttributes.getTextArray(index);
                } else if (index == q$l.iCu) {
                    this.keo = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == q$l.iCB) {
                    this.kep = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == q$l.iCC) {
                    this.kec = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init(Context context) {
        this.iK = q.a(context, null);
        this.kdZ = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.kea = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.kdB == 0) {
            this.kdB = d(context, 13.0f);
        }
        if (this.kdC == 0) {
            this.kdC = d(context, 15.0f);
        }
        if (this.kdD == 0) {
            this.kdD = d(context, 14.0f);
        }
        if (this.kdG == 0) {
            this.kdG = e(context, 8.0f);
        }
        if (this.kdH == 0) {
            this.kdH = e(context, 8.0f);
        }
        this.keq.setColor(this.kdK);
        this.keq.setAntiAlias(true);
        this.keq.setStyle(Style.STROKE);
        this.keq.setStrokeWidth((float) this.Sb);
        this.ker.setColor(this.kdy);
        this.ker.setAntiAlias(true);
        this.ker.setTextAlign(Align.CENTER);
        this.kes.setColor(this.kdA);
        this.kes.setAntiAlias(true);
        this.kes.setTextAlign(Align.CENTER);
        this.kes.setTextSize((float) this.kdD);
        if (this.kdN % 2 == 0) {
            this.kdN++;
        }
        if (this.kdQ == -1 || this.kdR == -1) {
            if (this.ket == null) {
                this.ket = new String[1];
                this.ket[0] = "0";
            }
            anT();
            if (this.kdQ == -1) {
                this.kdQ = 0;
            }
            if (this.kdR == -1) {
                this.kdR = this.ket.length - 1;
            }
            g(this.kdQ, this.kdR, false);
        }
        anO();
    }

    private void anO() {
        this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread.start();
        this.kew = new 1(this, this.mHandlerThread.getLooper());
        this.kex = new 2(this);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        super.onMeasure(i, i2);
        dA(false);
        int mode = MeasureSpec.getMode(i);
        this.keR = mode;
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i3 = size;
        } else {
            i3 = Math.max(this.kdE, this.kdF) == 0 ? 0 : this.kdH;
            if (Math.max(this.kdE, this.kdF) != 0) {
                i4 = this.kdG;
            }
            i3 = Math.max(this.kdW, (((i3 + (i4 + Math.max(this.kdE, this.kdF))) + (this.kdJ * 2)) * 2) + Math.max(this.kdU, this.kdX)) + (getPaddingLeft() + getPaddingRight());
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(i3, size);
            }
        }
        mode = MeasureSpec.getMode(i2);
        this.keS = mode;
        i4 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (this.kdN * (this.kdV + (this.kdI * 2))) + (getPaddingTop() + getPaddingBottom());
            i4 = mode == Integer.MIN_VALUE ? Math.min(size, i4) : size;
        }
        setMeasuredDimension(i3, i4);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        super.onSizeChanged(i, i2, i3, i4);
        this.keI = i;
        this.keJ = i2;
        this.keK = this.keJ / this.kdN;
        this.keN = ((float) ((this.keI + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        int value = anP() > 1 ? this.mHasInit ? getValue() - this.kdS : this.kel ? this.keO + ((this.kdN - 1) / 2) : 0 : 0;
        if (this.kek && this.kem) {
            z = true;
        } else {
            z = false;
        }
        z(value, z);
        if (this.kdB > this.keK) {
            this.kdB = this.keK;
        }
        if (this.kdC > this.keK) {
            this.kdC = this.keK;
        }
        if (this.kes == null) {
            throw new IllegalArgumentException("mPaintHint should not be null.");
        }
        this.kes.setTextSize((float) this.kdD);
        this.kei = a(this.kes.getFontMetrics());
        this.kdE = a(this.keb, this.kes);
        if (this.ker == null) {
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        this.ker.setTextSize((float) this.kdC);
        this.keh = a(this.ker.getFontMetrics());
        this.ker.setTextSize((float) this.kdB);
        this.keg = a(this.ker.getFontMetrics());
        anR();
        this.kdO = this.kdN / 2;
        this.kdP = this.kdO + 1;
        this.keL = (float) ((this.kdO * this.keJ) / this.kdN);
        this.keM = (float) ((this.kdP * this.keJ) / this.kdN);
        if (this.kdL < 0) {
            this.kdL = 0;
        }
        if (this.kdM < 0) {
            this.kdM = 0;
        }
        if (this.kdL + this.kdM != 0 && getPaddingLeft() + this.kdL >= (this.keI - getPaddingRight()) - this.kdM) {
            value = (((getPaddingLeft() + this.kdL) + getPaddingRight()) + this.kdM) - this.keI;
            this.kdL = (int) (((float) this.kdL) - ((((float) value) * ((float) this.kdL)) / ((float) (this.kdL + this.kdM))));
            this.kdM = (int) (((float) this.kdM) - ((((float) value) * ((float) this.kdM)) / ((float) (this.kdL + this.kdM))));
        }
        this.mHasInit = true;
    }

    public void postInvalidate() {
        if (z.ak(this)) {
            super.postInvalidate();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHandlerThread == null || !this.mHandlerThread.isAlive()) {
            anO();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.keK != 0) {
            if (!this.iK.isFinished()) {
                this.iK.abortAnimation();
                this.keQ = this.iK.getCurrY();
                anS();
                if (this.keP != 0) {
                    if (this.keP < (-this.keK) / 2) {
                        this.keQ = (this.keQ + this.keK) + this.keP;
                    } else {
                        this.keQ += this.keP;
                    }
                    anS();
                }
                mp(0);
            }
            int mq = mq(this.keQ);
            if (mq != this.kdY && this.keo) {
                try {
                    if (this.kez != null) {
                        this.kez.a(this, this.kdS + mq);
                    }
                } catch (Exception e) {
                }
            }
            this.kdY = mq;
        }
    }

    private int anP() {
        return (this.kdR - this.kdQ) + 1;
    }

    public final void setDisplayedValues(String[] strArr) {
        boolean z = true;
        if (this.kew != null) {
            this.kew.removeMessages(1);
        }
        anU();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        } else if ((this.kdT - this.kdS) + 1 > strArr.length) {
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.kdT - this.kdS) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        } else {
            this.ket = strArr;
            anT();
            dA(true);
            this.kdY = this.kdQ + 0;
            if (!(this.kek && this.kem)) {
                z = false;
            }
            z(0, z);
            postInvalidate();
            this.kex.sendEmptyMessage(3);
        }
    }

    public final void setMaxValue(int i) {
        if (this.ket == null) {
            throw new NullPointerException("mDisplayedValues should not be null");
        } else if ((i - this.kdS) + 1 > this.ket.length) {
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.kdS) + 1) + " and mDisplayedValues.length is " + this.ket.length);
        } else {
            this.kdT = i;
            this.kdR = (this.kdT - this.kdS) + this.kdQ;
            g(this.kdQ, this.kdR, true);
            anR();
        }
    }

    public final void setValue(int i) {
        if (i < this.kdS) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i > this.kdT) {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        } else {
            int i2 = i - this.kdS;
            if (this.kdQ >= 0 && this.kdQ <= i2 && i2 <= this.kdR) {
                this.kdY = i2;
                int i3 = i2 - this.kdQ;
                boolean z = this.kek && this.kem;
                z(i3, z);
                postInvalidate();
            }
        }
    }

    public final int getValue() {
        return anQ() + this.kdS;
    }

    public final void setDividerHeight(int i) {
        if (i != this.Sb) {
            this.Sb = i;
            this.keq.setStrokeWidth((float) this.Sb);
            postInvalidate();
        }
    }

    private int anQ() {
        if (this.keP == 0) {
            return mq(this.keQ);
        }
        if (this.keP < (-this.keK) / 2) {
            return mq((this.keQ + this.keK) + this.keP);
        }
        return mq(this.keQ + this.keP);
    }

    private void g(int i, int i2, boolean z) {
        if (i > i2) {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        } else if (this.ket == null) {
            throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
        } else if (i < 0) {
            throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
        } else if (i > this.ket.length - 1) {
            throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.ket.length - 1) + " minShowIndex is " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
        } else if (i2 > this.ket.length - 1) {
            throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.ket.length - 1) + " maxShowIndex is " + i2);
        } else {
            this.kdQ = i;
            this.kdR = i2;
            if (z) {
                boolean z2;
                this.kdY = this.kdQ + 0;
                if (this.kek && this.kem) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z(0, z2);
                postInvalidate();
            }
        }
    }

    private void mp(int i) {
        if (this.yi != i) {
            this.yi = i;
        }
    }

    private int mq(int i) {
        boolean z = false;
        if (this.keK == 0) {
            return 0;
        }
        int i2 = (i / this.keK) + (this.kdN / 2);
        int anP = anP();
        if (this.kek && this.kem) {
            z = true;
        }
        int h = h(i2, anP, z);
        if (h >= 0 && h < anP()) {
            return h + this.kdQ;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + h + " getOneRecycleSize() : " + anP() + " mWrapSelectorWheel : " + this.kek);
    }

    private static int h(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    private void anR() {
        this.keD = 0;
        this.keE = (-this.kdN) * this.keK;
        if (this.ket != null) {
            this.keD = ((anP() - (this.kdN / 2)) - 1) * this.keK;
            this.keE = (-(this.kdN / 2)) * this.keK;
        }
    }

    private int mr(int i) {
        if (this.kek && this.kem) {
            return i;
        }
        if (i < this.keE) {
            return this.keE;
        }
        if (i > this.keD) {
            return this.keD;
        }
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.keK != 0) {
            if (this.ft == null) {
                this.ft = VelocityTracker.obtain();
            }
            this.ft.addMovement(motionEvent);
            this.keG = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.keH = true;
                    this.kew.removeMessages(1);
                    anU();
                    this.iQL = this.keG;
                    this.keF = (float) this.keQ;
                    mp(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    int yVelocity;
                    if (!this.keH) {
                        VelocityTracker velocityTracker = this.ft;
                        velocityTracker.computeCurrentVelocity(1000);
                        yVelocity = (int) (velocityTracker.getYVelocity() * this.kef);
                        if (Math.abs(yVelocity) > this.kdZ) {
                            this.iK.b(this.keQ, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, mr(Integer.MIN_VALUE), mr(Integer.MAX_VALUE));
                            invalidate();
                            mp(2);
                        }
                        this.kew.sendMessageDelayed(b(1, 0, 0, null), 0);
                        if (this.ft != null) {
                            this.ft.clear();
                            this.ft.recycle();
                            this.ft = null;
                            break;
                        }
                    }
                    float y = motionEvent.getY();
                    yVelocity = 0;
                    while (yVelocity < this.kdN) {
                        if (((float) (this.keK * yVelocity)) <= y && y < ((float) (this.keK * (yVelocity + 1)))) {
                            if (yVelocity >= 0 && yVelocity < this.kdN) {
                                int anQ;
                                int i;
                                int i2;
                                yVelocity -= this.kdN / 2;
                                if (!(this.kek && this.kem)) {
                                    anQ = anQ();
                                    if (anQ + yVelocity > this.kdR) {
                                        yVelocity = this.kdR - anQ;
                                    } else if (anQ + yVelocity < this.kdQ) {
                                        yVelocity = this.kdQ - anQ;
                                    }
                                }
                                if (this.keP < (-this.keK) / 2) {
                                    anQ = this.keK + this.keP;
                                    i = (int) ((((float) (this.keK + this.keP)) * 300.0f) / ((float) this.keK));
                                    i = yVelocity < 0 ? (-i) - (yVelocity * 300) : i + (yVelocity * 300);
                                } else {
                                    anQ = this.keP;
                                    i = (int) ((((float) (-this.keP)) * 300.0f) / ((float) this.keK));
                                    i = yVelocity < 0 ? i - (yVelocity * 300) : i + (yVelocity * 300);
                                }
                                int i3 = anQ + (yVelocity * this.keK);
                                if (i < 300) {
                                    i2 = 300;
                                } else {
                                    i2 = i;
                                }
                                if (i2 > 600) {
                                    i2 = 600;
                                }
                                this.iK.startScroll(0, this.keQ, 0, i3, i2);
                                this.kew.sendMessageDelayed(b(1, 0, 0, null), (long) (i2 / 4));
                                postInvalidate();
                                break;
                            }
                        }
                        yVelocity++;
                    }
                    break;
                    break;
                case 2:
                    float f = this.iQL - this.keG;
                    if (!this.keH || ((float) (-this.kea)) >= f || f >= ((float) this.kea)) {
                        this.keH = false;
                        this.keQ = mr((int) (f + this.keF));
                        anS();
                        invalidate();
                    }
                    mp(1);
                    break;
                case 3:
                    this.keF = (float) this.keQ;
                    anU();
                    this.kew.sendMessageDelayed(b(1, 0, 0, null), 0);
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private static float a(FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private void z(int i, boolean z) {
        this.keO = i - ((this.kdN - 1) / 2);
        this.keO = h(this.keO, anP(), z);
        if (this.keK == 0) {
            this.kel = true;
            return;
        }
        this.keQ = this.keO * this.keK;
        this.keB = this.keO + (this.kdN / 2);
        this.keB %= anP();
        if (this.keB < 0) {
            this.keB += anP();
        }
        this.keC = this.keB;
        anS();
    }

    public void computeScroll() {
        if (this.keK != 0 && this.iK.computeScrollOffset()) {
            this.keQ = this.iK.getCurrY();
            anS();
            postInvalidate();
        }
    }

    private void anS() {
        this.keO = (int) Math.floor((double) (((float) this.keQ) / ((float) this.keK)));
        this.keP = -(this.keQ - (this.keO * this.keK));
        if (this.keA != null) {
            if ((-this.keP) > this.keK / 2) {
                this.keC = (this.keO + 1) + (this.kdN / 2);
            } else {
                this.keC = this.keO + (this.kdN / 2);
            }
            this.keC %= anP();
            if (this.keC < 0) {
                this.keC += anP();
            }
            this.keB = this.keC;
        }
    }

    private void dA(boolean z) {
        float textSize = this.ker.getTextSize();
        this.ker.setTextSize((float) this.kdC);
        this.kdU = a(this.ket, this.ker);
        this.kdW = a(this.keu, this.ker);
        this.kdX = a(this.kev, this.ker);
        this.ker.setTextSize((float) this.kdD);
        this.kdF = a(this.kee, this.ker);
        this.ker.setTextSize(textSize);
        textSize = this.ker.getTextSize();
        this.ker.setTextSize((float) this.kdC);
        this.kdV = (int) (((double) (this.ker.getFontMetrics().bottom - this.ker.getFontMetrics().top)) + 0.5d);
        this.ker.setTextSize(textSize);
        if (!z) {
            return;
        }
        if (this.keR == Integer.MIN_VALUE || this.keS == Integer.MIN_VALUE) {
            this.kex.sendEmptyMessage(3);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 0.0f;
        for (int i = 0; i < this.kdN + 1; i++) {
            float f2;
            float f3;
            float f4 = (float) (this.keP + (this.keK * i));
            int i2 = this.keO + i;
            int anP = anP();
            boolean z = this.kek && this.kem;
            int h = h(i2, anP, z);
            if (i == this.kdN / 2) {
                f2 = ((float) (this.keK + this.keP)) / ((float) this.keK);
                anP = a(f2, this.kdy, this.kdz);
                f = (float) this.kdB;
                f3 = ((((float) this.kdC) - f) * f2) + f;
                f = this.keg;
                float f5 = f + ((this.keh - f) * f2);
                f = f2;
                f2 = f5;
            } else if (i == (this.kdN / 2) + 1) {
                anP = a(1.0f - f, this.kdy, this.kdz);
                f3 = (float) this.kdB;
                f3 += (1.0f - f) * (((float) this.kdC) - f3);
                f2 = 1.0f - f;
                float f6 = this.keg;
                f2 = (f2 * (this.keh - f6)) + f6;
            } else {
                anP = this.kdy;
                f3 = (float) this.kdB;
                f2 = this.keg;
            }
            this.ker.setColor(anP);
            this.ker.setTextSize(f3);
            if (h >= 0 && h < anP()) {
                CharSequence ellipsize;
                CharSequence charSequence = this.ket[this.kdQ + h];
                if (this.kec != null) {
                    TruncateAt truncateAt;
                    TextPaint textPaint = this.ker;
                    f6 = (float) (getWidth() - (this.kdJ * 2));
                    String str = this.kec;
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case -1074341483:
                            if (str.equals("middle")) {
                                i2 = 1;
                                break;
                            }
                            break;
                        case 100571:
                            if (str.equals("end")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            truncateAt = TruncateAt.START;
                            break;
                        case 1:
                            truncateAt = TruncateAt.MIDDLE;
                            break;
                        case 2:
                            truncateAt = TruncateAt.END;
                            break;
                        default:
                            throw new IllegalArgumentException("Illegal text ellipsize type.");
                    }
                    ellipsize = TextUtils.ellipsize(charSequence, textPaint, f6, truncateAt);
                } else {
                    ellipsize = charSequence;
                }
                canvas.drawText(ellipsize.toString(), this.keN, f2 + (f4 + ((float) (this.keK / 2))), this.ker);
            } else if (!TextUtils.isEmpty(this.ked)) {
                canvas.drawText(this.ked, this.keN, f2 + (f4 + ((float) (this.keK / 2))), this.ker);
            }
        }
        if (this.kej) {
            canvas.drawLine((float) (getPaddingLeft() + this.kdL), this.keL, (float) ((this.keI - getPaddingRight()) - this.kdM), this.keL, this.keq);
            canvas.drawLine((float) (getPaddingLeft() + this.kdL), this.keM, (float) ((this.keI - getPaddingRight()) - this.kdM), this.keM, this.keq);
        }
        if (!TextUtils.isEmpty(this.keb)) {
            canvas.drawText(this.keb, (this.keN + ((float) ((this.kdU + this.kdE) / 2))) + ((float) this.kdG), ((this.keL + this.keM) / 2.0f) + this.kei, this.kes);
        }
    }

    private static int a(CharSequence[] charSequenceArr, Paint paint) {
        int i = 0;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                if (charSequence != null) {
                    i = Math.max(a(charSequence, paint), i);
                }
            }
        }
        return i;
    }

    private static int a(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    private void anT() {
        this.kem = this.ket.length > this.kdN;
    }

    private void anU() {
        if (this.iK != null && !this.iK.isFinished()) {
            this.iK.startScroll(0, this.iK.getCurrY(), 0, 0, 1);
            this.iK.abortAnimation();
            postInvalidate();
        }
    }

    public final void anV() {
        anU();
        if (this.kew != null) {
            this.kew.sendMessageDelayed(b(1, 0, 0, null), 0);
        }
    }

    private static Message b(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private static int d(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    private static int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private static int a(float f, int i, int i2) {
        int i3 = (i & WebView.NIGHT_MODE_COLOR) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        int i6 = (i & 255) >>> 0;
        return (((((int) ((((float) (((WebView.NIGHT_MODE_COLOR & i2) >>> 24) - i3)) * f) + ((float) i3))) << 24) | (((int) ((((float) (((16711680 & i2) >>> 16) - i4)) * f) + ((float) i4))) << 16)) | (((int) ((((float) (((65280 & i2) >>> 8) - i5)) * f) + ((float) i5))) << 8)) | ((int) ((((float) (((i2 & 255) >>> 0) - i6)) * f) + ((float) i6)));
    }
}

package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class MallFormView extends LinearLayout implements OnFocusChangeListener {
    private TextView jJn;
    private int pEA;
    private String pEB;
    private int pEC;
    private int pED;
    private int pEE;
    private boolean pEF;
    private boolean pEG;
    private boolean pEH;
    private int pEI;
    private int pEJ;
    private int pEK;
    public boolean pEL;
    private TextView pEg;
    public EditText pEh;
    public WalletIconImageView pEi;
    public TextView pEj;
    public a pEk;
    private OnFocusChangeListener pEl;
    private OnClickListener pEm;
    private a pEn;
    b pEo;
    private int pEp;
    private String pEq;
    private int pEr;
    private String pEs;
    private int pEt;
    private int pEu;
    private int pEv;
    private String pEw;
    private int pEx;
    private String pEy;
    private int pEz;

    public MallFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.jJn = null;
        this.pEg = null;
        this.pEh = null;
        this.pEi = null;
        this.pEj = null;
        this.pEk = null;
        this.pEl = null;
        this.pEm = null;
        this.pEn = null;
        this.pEo = null;
        this.pEp = -1;
        this.pEq = "";
        this.pEr = 0;
        this.pEs = "";
        this.pEt = 8;
        this.pEu = -1;
        this.pEv = 4;
        this.pEw = "";
        this.pEx = 8;
        this.pEy = "";
        this.pEz = 19;
        this.pEA = a$c.btv;
        this.pEB = "";
        this.pEC = Integer.MAX_VALUE;
        this.pED = 1;
        this.pEE = a$e.bDJ;
        this.pEF = true;
        this.pEG = false;
        this.pEH = true;
        this.pEI = 1;
        this.pEJ = 5;
        this.pEK = a$c.uaK;
        this.pEL = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.uZc, i, 0);
        this.pEp = obtainStyledAttributes.getResourceId(k.uZf, this.pEp);
        int resourceId = obtainStyledAttributes.getResourceId(k.uZg, 0);
        if (resourceId != 0) {
            this.pEq = context.getString(resourceId);
        }
        this.pEu = obtainStyledAttributes.getResourceId(k.uZh, this.pEu);
        resourceId = obtainStyledAttributes.getResourceId(k.uZi, 0);
        if (resourceId != 0) {
            this.pEw = context.getString(resourceId);
        }
        this.pEv = obtainStyledAttributes.getInteger(k.uZj, this.pEv);
        this.pEr = obtainStyledAttributes.getInteger(k.uZk, this.pEr);
        this.pEx = obtainStyledAttributes.getInteger(k.uZl, this.pEx);
        this.pEt = obtainStyledAttributes.getInteger(k.uZm, this.pEt);
        resourceId = obtainStyledAttributes.getResourceId(k.uZn, 0);
        if (resourceId != 0) {
            this.pEs = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.uZo, 0);
        if (resourceId != 0) {
            this.pEy = context.getString(resourceId);
        }
        this.pEz = obtainStyledAttributes.getInteger(k.uZp, this.pEz);
        this.pEA = obtainStyledAttributes.getColor(k.uZq, this.pEA);
        resourceId = obtainStyledAttributes.getResourceId(k.uZr, 0);
        if (resourceId != 0) {
            this.pEB = context.getString(resourceId);
        }
        this.pEC = obtainStyledAttributes.getInteger(k.uZs, this.pEC);
        this.pED = obtainStyledAttributes.getInteger(k.uZt, this.pED);
        this.pEE = obtainStyledAttributes.getResourceId(k.uZu, this.pEE);
        this.pEF = obtainStyledAttributes.getBoolean(k.uZv, this.pEF);
        this.pEG = obtainStyledAttributes.getBoolean(k.uZw, this.pEG);
        this.pEH = obtainStyledAttributes.getBoolean(k.uZv, this.pEH);
        this.pEI = obtainStyledAttributes.getInteger(k.uZd, this.pEI);
        this.pEJ = obtainStyledAttributes.getInteger(k.uZe, this.pEJ);
        this.pEK = obtainStyledAttributes.getInteger(k.uZx, this.pEK);
        obtainStyledAttributes.recycle();
        if (this.pEp > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        inflate(context, this.pEp, this);
        this.jJn = (TextView) findViewById(f.urB);
        this.pEg = (TextView) findViewById(f.uqv);
        this.pEh = (EditText) findViewById(f.upQ);
        this.pEi = (WalletIconImageView) findViewById(f.upZ);
        this.pEj = (TextView) findViewById(f.urA);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void bmI() {
        if (this.pEi != null && !bh.ov(getText()) && this.pEh != null && this.pEh.isEnabled() && this.pEh.isClickable() && this.pEh.isFocusable() && this.pEh.isFocused()) {
            this.pEi.o(new 2(this));
        } else if (this.pEi != null) {
            this.pEi.ccS();
        } else {
            x.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (this.jJn != null) {
            this.jJn.setText(this.pEq);
            this.jJn.setVisibility(this.pEr);
        }
        if (this.pEg != null) {
            this.pEg.setText(this.pEs);
            this.pEg.setVisibility(this.pEt);
        }
        if (this.pEi != null) {
            this.pEi.setImageResource(this.pEu);
            this.pEi.setVisibility(this.pEv);
        }
        if (this.pEj != null) {
            this.pEj.setText(this.pEw);
            this.pEj.setVisibility(this.pEx);
        }
        getContext();
        if (this.pEh != null) {
            int length;
            this.pEh.setHint(this.pEy);
            this.pEh.setGravity(this.pEz);
            this.pEh.setTextColor(this.pEA);
            CharSequence charSequence = this.pEB;
            if (this.pEh != null) {
                this.pEh.setText(charSequence);
                EditText editText = this.pEh;
                if (this.pEh != null) {
                    length = this.pEh.getText().length();
                } else {
                    length = 0;
                }
                editText.setSelection(length);
            }
            this.pEh.setBackgroundResource(this.pEE);
            this.pEh.setEnabled(this.pEF);
            this.pEh.setFocusable(this.pEH);
            this.pEh.setClickable(this.pEG);
            this.pEh.setHintTextColor(this.pEK);
            length = this.pEJ;
            if (this.pEh != null) {
                this.pEh.setImeOptions(length);
            }
            length = this.pEI;
            if (this.pEh != null) {
                this.pEh.setInputType(length);
            }
            this.pEh.addTextChangedListener(new 1(this));
            this.pEh.setOnFocusChangeListener(this);
        }
        bmI();
        if (this.pEh != null) {
            if (this.pEI == 2) {
                this.pEh.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView pEN;

                    {
                        this.pEN = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.pEI == 4) {
                this.pEh.setKeyListener(new 4(this));
            } else if (this.pEI == FileUtils.S_IWUSR) {
                this.pEh.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.pEh.setKeyListener(new 5(this));
                this.pEh.setRawInputType(18);
            } else if (this.pEI == 3) {
                this.pEh.setKeyListener(new 6(this));
            } else {
                this.pEh.setInputType(this.pEI);
            }
            if (this.pEC != -1) {
                this.pEh.setFilters(new InputFilter[]{new LengthFilter(this.pEC)});
            }
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        if (this.pEn == null || !this.pEn.bmF()) {
            super.onMeasure(i, i2);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.pEn != null && this.pEn.bmG()) {
            return true;
        }
        if (this.pEh != null && a(this.pEh, motionEvent) && !this.pEh.isClickable()) {
            x.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!a(this.pEi, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            x.d("MicroMsg.WalletFormView", "hy: click on info iv");
            this.pEi.performClick();
            return true;
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect;
        if (view != null) {
            rect = new Rect();
            view.getHitRect(rect);
            if (view == this.pEi) {
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
            }
        } else {
            rect = null;
        }
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return false;
    }

    public final void bmJ() {
        x.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[]{Boolean.valueOf(this.pEL)});
        if (this.pEL) {
            this.pEh.clearFocus();
        } else {
            this.pEL = true;
        }
    }

    public final String getText() {
        if (this.pEh != null) {
            String obj = this.pEh.getText().toString();
            if (this.pEo == null || !this.pEo.bmH()) {
                return obj;
            }
            return this.pEo.Ii(obj);
        }
        x.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pEl = onFocusChangeListener;
    }

    public final boolean XO() {
        if (this.pEh != null) {
            int length = this.pEh.getText() == null ? 0 : this.pEh.getText().length();
            if (length > this.pEC || length < this.pED) {
                return false;
            }
            return this.pEo != null ? this.pEo.a(this) : true;
        } else {
            x.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            return true;
        }
    }

    public final void bmK() {
        if (this.pEh != null) {
            this.pEh.setText("");
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.pEl != null) {
            this.pEl.onFocusChange(this, z);
        }
        if (XO()) {
            if (this.jJn != null) {
                this.jJn.setEnabled(true);
            }
        } else if (this.jJn != null) {
            this.jJn.setEnabled(false);
        }
        bmI();
    }
}

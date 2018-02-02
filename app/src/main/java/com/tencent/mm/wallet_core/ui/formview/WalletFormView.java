package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    public TextView jJn;
    private int pEA;
    private String pEB;
    public int pEC;
    private int pED;
    private int pEE;
    private boolean pEF;
    private boolean pEG;
    private boolean pEH;
    private int pEI;
    private int pEJ;
    private int pEK;
    public TextView pEg;
    public WalletIconImageView pEi;
    public TextView pEj;
    private OnFocusChangeListener pEl;
    private OnClickListener pEm;
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
    public TenpaySecureEditText zJG;
    public a zJH;
    public a zJI;
    public b zJJ;
    private int zJK;
    public int zJL;
    private int zJM;
    @Deprecated
    private int zJN;
    private int zJO;

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.jJn = null;
        this.pEg = null;
        this.zJG = null;
        this.pEi = null;
        this.pEj = null;
        this.zJH = null;
        this.pEl = null;
        this.pEm = null;
        this.zJI = null;
        this.zJJ = null;
        this.pEp = -1;
        this.zJK = this.pEp;
        this.zJL = 100;
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
        this.pEA = c.btv;
        this.pEB = "";
        this.zJM = 0;
        this.pEC = Integer.MAX_VALUE;
        this.pED = 1;
        this.pEE = e.bDJ;
        this.pEF = true;
        this.pEG = false;
        this.pEH = true;
        this.pEI = 1;
        this.pEJ = 5;
        this.pEK = c.uaK;
        this.zJN = 0;
        this.zJO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$k.uZH, i, 0);
        this.pEp = obtainStyledAttributes.getResourceId(a$k.uZL, this.pEp);
        int resourceId = obtainStyledAttributes.getResourceId(a$k.uZN, 0);
        if (resourceId != 0) {
            this.pEq = context.getString(resourceId);
        }
        this.pEu = obtainStyledAttributes.getResourceId(a$k.uZO, this.pEu);
        resourceId = obtainStyledAttributes.getResourceId(a$k.uZP, 0);
        if (resourceId != 0) {
            this.pEw = context.getString(resourceId);
        }
        this.pEv = obtainStyledAttributes.getInteger(a$k.uZQ, this.pEv);
        this.pEr = obtainStyledAttributes.getInteger(a$k.uZR, this.pEr);
        this.pEx = obtainStyledAttributes.getInteger(a$k.uZS, this.pEx);
        this.pEt = obtainStyledAttributes.getInteger(a$k.uZT, this.pEt);
        resourceId = obtainStyledAttributes.getResourceId(a$k.uZU, 0);
        if (resourceId != 0) {
            this.pEs = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(a$k.uZV, 0);
        if (resourceId != 0) {
            this.pEy = context.getString(resourceId);
        }
        this.pEz = obtainStyledAttributes.getInteger(a$k.uZW, this.pEz);
        this.pEA = obtainStyledAttributes.getColor(a$k.uZX, this.pEA);
        resourceId = obtainStyledAttributes.getResourceId(a$k.uZY, 0);
        if (resourceId != 0) {
            this.pEB = context.getString(resourceId);
        }
        this.zJM = obtainStyledAttributes.getInt(a$k.uZZ, this.zJM);
        this.pEC = obtainStyledAttributes.getInteger(a$k.vaa, this.pEC);
        this.pED = obtainStyledAttributes.getInteger(a$k.vab, this.pED);
        this.pEE = obtainStyledAttributes.getResourceId(a$k.vac, this.pEE);
        this.pEF = obtainStyledAttributes.getBoolean(a$k.vad, this.pEF);
        this.pEG = obtainStyledAttributes.getBoolean(a$k.vae, this.pEG);
        this.pEH = obtainStyledAttributes.getBoolean(a$k.vad, this.pEH);
        this.pEI = obtainStyledAttributes.getInteger(a$k.uZI, this.pEI);
        this.pEJ = obtainStyledAttributes.getInteger(a$k.uZJ, this.pEJ);
        this.zJL = obtainStyledAttributes.getInteger(a$k.vag, this.zJL);
        this.pEK = obtainStyledAttributes.getInteger(a$k.vaf, this.pEK);
        this.zJK = obtainStyledAttributes.getResourceId(a$k.uZM, this.zJK);
        this.zJN = obtainStyledAttributes.getInteger(a$k.vah, 0);
        this.zJO = obtainStyledAttributes.getInteger(a$k.uZK, -1);
        if (this.zJN == 1 && this.zJO == -1) {
            this.zJO = 4;
        }
        obtainStyledAttributes.recycle();
        if (this.pEp > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (bh.ov(this.pEq) || this.pEq.length() <= 6) {
            inflate(context, this.pEp, this);
        } else {
            inflate(context, this.zJK, this);
        }
        this.jJn = (TextView) findViewById(f.uAj);
        this.pEg = (TextView) findViewById(f.uzU);
        this.zJG = (TenpaySecureEditText) findViewById(f.uyz);
        this.pEi = (WalletIconImageView) findViewById(f.uyV);
        this.pEj = (TextView) findViewById(f.uAi);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void xv(String str) {
        this.pEq = str;
        cCn();
    }

    public final void aaI(String str) {
        if (this.zJG == null) {
            return;
        }
        if (this.zJJ == null || !this.zJJ.d(this, str)) {
            this.zJG.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
    }

    public final String cCl() {
        String ou = bh.ou(this.zJG.getText().toString());
        if (this.zJJ != null && this.zJJ.bmH()) {
            ou = this.zJJ.e(this, ou);
        }
        return ab.UZ(ou);
    }

    public final void setImeOptions(int i) {
        if (this.zJG != null) {
            this.zJG.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.zJG != null) {
            this.zJG.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.zJG == null) {
            return;
        }
        if (this.zJJ == null || !this.zJJ.c(this, str)) {
            this.zJG.setText(str);
            this.zJG.setSelection(getInputLength());
        }
    }

    @SuppressLint({"ResourceType"})
    public final void HH(int i) {
        this.pEA = i;
        if (this.zJG != null) {
            this.zJG.setTextColor(getResources().getColor(this.pEA));
        }
    }

    public final void HI(int i) {
        if (this.zJG != null) {
            this.zJG.setTextColor(i);
        }
    }

    private void bmI() {
        if (this.pEi != null && !bh.ov(getText()) && this.zJG != null && this.zJG.isEnabled() && this.zJG.isClickable() && this.zJG.isFocusable() && this.zJG.isFocused()) {
            this.pEi.o(new 2(this));
        } else if (this.pEi != null) {
            this.pEi.ccS();
        } else {
            x.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final boolean cCm() {
        return this.zJG != null ? this.zJG.isFocusable() : false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        cCn();
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
        Context context = getContext();
        if (this.zJG != null) {
            if (this.zJO >= 0) {
                this.zJG.setTypeface(Typeface.createFromAsset(context.getAssets(), com.tencent.mm.wallet_core.ui.e.HC(this.zJO)));
            }
            this.zJG.setHint(this.pEy);
            this.zJG.setGravity(this.pEz);
            this.zJG.setTextColor(this.pEA);
            setText(this.pEB);
            b.a(this.zJG, this.zJM);
            this.zJG.setBackgroundResource(this.pEE);
            this.zJG.setEnabled(this.pEF);
            this.zJG.setFocusable(this.pEH);
            this.zJG.setClickable(this.pEG);
            this.zJG.setHintTextColor(this.pEK);
            setImeOptions(this.pEJ);
            setInputType(this.pEI);
            this.zJG.addTextChangedListener(new 1(this));
            this.zJG.setOnFocusChangeListener(this);
        }
        bmI();
        if (this.zJG != null) {
            if (this.pEI == 2) {
                this.zJG.setKeyListener(new 3(this));
            } else if (this.pEI == 4) {
                this.zJG.setKeyListener(new 4(this));
            } else if (this.pEI == FileUtils.S_IWUSR) {
                this.zJG.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.zJG.setKeyListener(new 5(this));
                this.zJG.setRawInputType(18);
            } else if (this.pEI == 3) {
                this.zJG.setKeyListener(new 6(this));
            } else {
                this.zJG.setInputType(this.pEI);
            }
            if (this.pEC != -1) {
                this.zJG.setFilters(new InputFilter[]{new LengthFilter(this.pEC)});
            }
        }
        if (this.zJI != null) {
            this.zJI.bJs();
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.zJG != null) {
            this.zJG.setHint(charSequence);
        }
    }

    public final void nK(boolean z) {
        if (this.zJG != null) {
            this.zJG.setEnabled(z);
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.zJG.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zJI != null && this.zJI.a(this, motionEvent)) {
            return true;
        }
        if (this.zJG != null && a(this.zJG, motionEvent) && !this.zJG.isClickable()) {
            x.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!a(this.pEi, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            x.d("MicroMsg.WalletFormView", "hy: click on info iv");
            bmI();
            this.pEi.performClick();
            return true;
        }
    }

    final boolean a(View view, MotionEvent motionEvent) {
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

    private void cCn() {
        if (this.jJn != null) {
            this.jJn.setText(this.pEq);
            this.jJn.setVisibility(this.pEr);
        }
    }

    public final void setSelection(int i) {
        if (this.zJG != null) {
            this.zJG.setSelection(i);
        }
    }

    public final String getText() {
        if (this.zJG != null) {
            String a = c.a.a(this.zJL, this.zJG);
            if (this.zJJ == null || !this.zJJ.bmH()) {
                return a;
            }
            return this.zJJ.e(this, a);
        }
        x.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.zJG != null) {
            return this.zJG.getKeyListener();
        }
        x.w("MicroMsg.WalletFormView", "hy: no content et");
        return null;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void r(OnClickListener onClickListener) {
        this.pEm = onClickListener;
        if (this.pEi != null) {
            this.pEi.setOnClickListener(this.pEm);
        }
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pEl = onFocusChangeListener;
    }

    public final void a(TextWatcher textWatcher) {
        if (this.zJG != null) {
            this.zJG.addTextChangedListener(textWatcher);
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.zJG != null) {
            this.zJG.setKeyListener(keyListener);
        }
    }

    public final boolean XO() {
        if (this.zJG != null) {
            int inputLength = this.zJG.getInputLength();
            if (inputLength > this.pEC || inputLength < this.pED) {
                return false;
            }
            if (this.zJJ != null) {
                return this.zJJ.h(this);
            }
            return true;
        }
        x.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        return true;
    }

    public final void bmK() {
        if (this.zJG != null) {
            this.zJG.ClearInput();
        }
    }

    public final void bmJ() {
        if (this.zJG != null) {
            this.zJG.clearFocus();
        }
    }

    public final boolean dQ(View view) {
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            return true;
        } else if (bh.ov(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jJn == null) {
                return false;
            }
            this.jJn.setEnabled(true);
            return false;
        } else if (XO()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jJn != null) {
                this.jJn.setEnabled(true);
            }
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.jJn == null) {
                return false;
            }
            this.jJn.setEnabled(false);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.zJG != null) {
            this.zJG.setFilters(inputFilterArr);
        }
    }

    private int getInputLength() {
        return this.zJG != null ? this.zJG.getInputLength() : 0;
    }

    public final void cCo() {
        if (this.zJG != null) {
            this.zJG.setFocusable(true);
            this.zJG.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.zJG, 0);
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.pEl != null) {
            this.pEl.onFocusChange(this, z);
        }
        if (this.zJH != null) {
            this.zJH.hx(XO());
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

package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int yao;
    private int[] yap;
    public EditText yas;
    public EditText yat;
    private String yau;
    private String yav;
    private final int yax;
    private a yay;

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.yao = -1;
        this.yau = "";
        this.yav = "";
        this.yax = 13;
        this.yay = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fag, i, 0);
        this.yao = obtainStyledAttributes.getResourceId(m.gZb, -1);
        obtainStyledAttributes.recycle();
        v.fv(context).inflate(h.gXx, this);
        this.mContext = context;
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.yas = (EditText) findViewById(g.bZb);
        this.yat = (EditText) findViewById(g.gVT);
        if (this.yas == null || this.yat == null) {
            x.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[]{this.yas, this.yat});
        } else if (this.yao != -1) {
            this.yat.setHint(this.yao);
        }
        if (this.yas != null && this.yat != null) {
            if (this.yas.hasFocus() || this.yat.hasFocus()) {
                mk(true);
            } else {
                mk(false);
            }
            OnFocusChangeListener 1 = new 1(this);
            this.yas.setOnFocusChangeListener(1);
            this.yat.setOnFocusChangeListener(1);
            this.yat.addTextChangedListener(new c(this.yat, null, 20));
            this.yat.addTextChangedListener(new 2(this));
            this.yas.addTextChangedListener(new 3(this));
        }
    }

    public final void mk(boolean z) {
        dl(this.yas);
        if (z) {
            this.yas.setBackgroundResource(f.bDf);
        } else {
            this.yas.setBackgroundResource(f.bDg);
        }
        dm(this.yas);
        dl(this.yat);
        if (z) {
            this.yat.setBackgroundResource(f.bDf);
        } else {
            this.yat.setBackgroundResource(f.bDg);
        }
        dm(this.yat);
    }

    private void dl(View view) {
        this.yap = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
    }

    private void dm(View view) {
        if (this.yap != null) {
            view.setPadding(this.yap[0], this.yap[1], this.yap[2], this.yap[3]);
        }
    }

    public final String getCountryCode() {
        if (this.yas != null) {
            return this.yas.getText().toString().trim();
        }
        return "";
    }
}

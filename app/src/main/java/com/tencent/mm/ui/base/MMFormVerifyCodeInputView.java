package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.k;
import com.tencent.mm.w.a.m;

public class MMFormVerifyCodeInputView extends LinearLayout {
    private ak hLQ;
    private TextView iiq;
    private int layout;
    private Context mContext;
    public EditText pqM;
    private int vcM;
    private Button xQR;
    private TextView yaA;
    private int yaB;
    private int yaC;
    private int yaD;
    public OnClickListener yaE;
    private int yao;
    private int[] yap;
    private OnFocusChangeListener yaq;

    static /* synthetic */ void c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        if (mMFormVerifyCodeInputView.yap != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.yap[0], mMFormVerifyCodeInputView.yap[1], mMFormVerifyCodeInputView.yap[2], mMFormVerifyCodeInputView.yap[3]);
        }
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vcM = -1;
        this.yao = -1;
        this.yaB = -1;
        this.layout = -1;
        this.yaC = 60;
        this.yaD = this.yaC;
        this.yaq = null;
        this.yaE = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fag, i, 0);
        this.yao = obtainStyledAttributes.getResourceId(m.gZb, -1);
        this.vcM = obtainStyledAttributes.getResourceId(m.gZa, -1);
        this.yaB = obtainStyledAttributes.getResourceId(m.gZc, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.gYZ, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.iiq = (TextView) findViewById(g.title);
        this.pqM = (EditText) findViewById(g.cdj);
        this.yaA = (TextView) findViewById(g.gWz);
        this.xQR = (Button) findViewById(g.gWk);
        if (this.iiq == null || this.pqM == null || this.yaA == null || this.xQR == null) {
            x.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[]{this.iiq, this.pqM, this.yaA, this.xQR});
        } else {
            if (this.vcM != -1) {
                this.iiq.setText(this.vcM);
            }
            if (this.yao != -1) {
                this.pqM.setHint(this.yao);
            }
            if (this.yaB != -1) {
                this.xQR.setText(this.yaB);
            }
        }
        if (this.pqM != null) {
            this.pqM.setOnFocusChangeListener(new 1(this));
        }
        if (this.xQR != null) {
            this.xQR.setOnClickListener(new 2(this));
        }
    }

    public final void coZ() {
        this.xQR.setVisibility(8);
        this.yaA.setVisibility(0);
        this.yaA.setText(getContext().getString(k.gYF, new Object[]{Integer.valueOf(this.yaC)}));
        if (this.hLQ != null) {
            this.hLQ.TG();
            this.hLQ.J(1000, 1000);
        } else if (getContext() != null) {
            this.hLQ = new ak(getContext().getMainLooper(), new 3(this), true);
            this.hLQ.J(1000, 1000);
        } else if (this.hLQ != null) {
            this.hLQ.TG();
        }
    }

    public final void reset() {
        if (this.hLQ != null) {
            this.hLQ.TG();
        }
        this.pqM.setText("");
        this.yaA.setVisibility(8);
        this.yaD = this.yaC;
        this.xQR.setVisibility(0);
    }

    public final void cpa() {
        if (this.pqM != null) {
            this.pqM.setInputType(3);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (this.pqM != null) {
            this.pqM.addTextChangedListener(textWatcher);
            return;
        }
        x.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[]{textWatcher, this.pqM});
    }

    public final Editable getText() {
        if (this.pqM != null) {
            return this.pqM.getText();
        }
        x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        return null;
    }
}

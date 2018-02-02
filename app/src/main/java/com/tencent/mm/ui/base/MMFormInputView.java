package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MMFormInputView extends LinearLayout {
    private TextView iiq;
    private int layout;
    private Context mContext;
    public EditText pqM;
    private int vcM;
    private int yao;
    private int[] yap;
    public OnFocusChangeListener yaq;

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        if (mMFormInputView.yap != null) {
            mMFormInputView.setPadding(mMFormInputView.yap[0], mMFormInputView.yap[1], mMFormInputView.yap[2], mMFormInputView.yap[3]);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vcM = -1;
        this.yao = -1;
        this.layout = -1;
        this.yaq = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fag, i, 0);
        this.yao = obtainStyledAttributes.getResourceId(m.gZb, -1);
        this.vcM = obtainStyledAttributes.getResourceId(m.gZa, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.gYZ, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.iiq = (TextView) findViewById(g.title);
        this.pqM = (EditText) findViewById(g.cdj);
        if (this.iiq == null || this.pqM == null) {
            x.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.iiq, this.pqM);
        } else {
            if (this.vcM != -1) {
                this.iiq.setText(this.vcM);
            }
            if (this.yao != -1) {
                this.pqM.setHint(this.yao);
            }
        }
        if (this.pqM != null) {
            this.pqM.setOnFocusChangeListener(new 1(this));
        }
    }

    public final void setText(String str) {
        if (this.pqM != null) {
            this.pqM.setText(str);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void setInputType(int i) {
        if (this.pqM != null) {
            this.pqM.setInputType(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == null || this.pqM == null) {
            x.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.pqM);
            return;
        }
        this.pqM.addTextChangedListener(textWatcher);
    }

    public final Editable getText() {
        if (this.pqM != null) {
            return this.pqM.getText();
        }
        x.e("MicroMsg.MMFormInputView", "contentET is null!");
        return null;
    }
}

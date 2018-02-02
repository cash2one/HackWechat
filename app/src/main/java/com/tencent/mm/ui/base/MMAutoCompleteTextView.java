package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.w.a.f;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable vkn = getResources().getDrawable(f.bDo);
    public a xZt;

    private class a implements TextWatcher {
        final /* synthetic */ MMAutoCompleteTextView xZu;
        private String xZv;

        public a(MMAutoCompleteTextView mMAutoCompleteTextView, String str) {
            this.xZu = mMAutoCompleteTextView;
            this.xZv = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().endsWith(this.xZv)) {
                this.xZu.showDropDown();
            }
        }
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vkn.setBounds(0, 0, this.vkn.getIntrinsicWidth(), this.vkn.getIntrinsicHeight());
        cae();
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        setOnFocusChangeListener(new 3(this));
    }

    private void cae() {
        if (getText().toString().equals("") || !isFocused()) {
            cag();
        } else {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vkn, getCompoundDrawables()[3]);
        }
    }

    private void cag() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
}

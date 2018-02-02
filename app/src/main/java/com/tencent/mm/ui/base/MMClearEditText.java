package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;

public class MMClearEditText extends EditText {
    public String kbH = "";
    private OnFocusChangeListener pEl = null;
    public OnTouchListener sqw = new 3(this);
    int tTT = 0;
    public boolean vkm = false;
    final Drawable vkn = getResources().getDrawable(f.bDo);
    private boolean xZK = false;

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        coW();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        coW();
    }

    private void coW() {
        this.vkn.setBounds(0, 0, this.vkn.getIntrinsicWidth(), this.vkn.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vkn.getIntrinsicWidth()), Integer.valueOf(this.vkn.getIntrinsicHeight()));
        cae();
        setHeight(this.vkn.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.bvL) * 5));
        setOnTouchListener(this.sqw);
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMClearEditText xZL;

            {
                this.xZL = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.xZL.cae();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new 2(this));
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.tTT = 0;
            String obj = getText().toString();
            try {
                Sf(obj);
            } catch (IndexOutOfBoundsException e) {
                x.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.tTT));
                if (this.tTT < 3) {
                    this.tTT++;
                    Sf(" " + obj);
                } else {
                    x.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void Sf(String str) {
        int selectionStart = getSelectionStart();
        setText(b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pEl = onFocusChangeListener;
    }

    private void cae() {
        if (getText().toString().equals("") || !isFocused()) {
            cag();
        } else if (!this.xZK) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vkn, getCompoundDrawables()[3]);
        }
    }

    private void cag() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            if (!this.vkm) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

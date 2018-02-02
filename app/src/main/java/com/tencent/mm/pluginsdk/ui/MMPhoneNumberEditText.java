package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.R;
import com.tencent.mm.bx.g;
import com.tencent.mm.sdk.platformtools.x;

public class MMPhoneNumberEditText extends EditText {
    public String kbH = "";
    private OnFocusChangeListener pEl = null;
    int tTT = 0;
    public boolean vkm = false;
    public Drawable vkn;
    a vko;
    public boolean vkp;
    private boolean vkq = false;

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.vkn = getResources().getDrawable(R.g.bDo);
        this.vkn.setBounds(0, 0, this.vkn.getIntrinsicWidth(), this.vkn.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[]{Integer.valueOf(this.vkn.getIntrinsicWidth()), Integer.valueOf(this.vkn.getIntrinsicHeight())});
        cae();
        setHeight(this.vkn.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.f.bvL) * 5));
        clearFocus();
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        super.setOnFocusChangeListener(new 3(this));
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.tTT = 0;
            String obj = getText().toString();
            try {
                Sf(obj);
            } catch (IndexOutOfBoundsException e) {
                x.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[]{Integer.valueOf(this.tTT)});
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
        setText(g.chg().a(getContext(), str, getTextSize()));
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
        if (getText().toString().equals("")) {
            cag();
        } else {
            caf();
        }
    }

    final void caf() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vkn, getCompoundDrawables()[3]);
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

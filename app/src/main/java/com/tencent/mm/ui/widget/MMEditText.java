package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.PasterEditText;

public class MMEditText extends PasterEditText {
    int tTT = 0;
    public InputConnection ztO;
    public a ztP;

    public interface a {
        void aXC();
    }

    public interface b {
        void bot();
    }

    public static class c implements TextWatcher {
        private final int asN;
        private EditText pqM;
        private TextView ztQ;
        public b ztR = null;
        private boolean ztS = false;

        public c(EditText editText, TextView textView, int i) {
            this.pqM = editText;
            this.ztQ = textView;
            this.asN = i;
        }

        public final void afterTextChanged(Editable editable) {
            int i;
            int i2 = 0;
            String obj = editable.toString();
            CharSequence charSequence = "";
            int i3 = 0;
            for (i = 0; i < obj.length(); i++) {
                if (bh.n(obj.charAt(i))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.asN) {
                    break;
                }
                charSequence = charSequence + obj.charAt(i);
            }
            if (i3 > this.asN) {
                try {
                    this.pqM.setText(charSequence);
                    if (this.ztS) {
                        this.pqM.setSelection(0);
                    } else {
                        this.pqM.setSelection(this.pqM.getText().toString().length());
                    }
                    this.ztS = false;
                } catch (Exception e) {
                    this.ztS = true;
                    x.e("MicroMsg.MMEditText", "error " + e.getMessage());
                    this.pqM.setText(charSequence);
                    this.pqM.setSelection(0);
                }
            }
            i = this.asN - i3;
            if (i >= 0) {
                i2 = i;
            }
            if (this.ztQ != null) {
                this.ztQ.setText((i2 / 2));
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.ztR != null) {
                this.ztR.bot();
            }
        }
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.ztO = super.onCreateInputConnection(editorInfo);
        return this.ztO;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aak(String str) {
        int q = com.tencent.mm.ui.e.c.b.q(getContext(), getText().toString(), getSelectionStart());
        int q2 = com.tencent.mm.ui.e.c.b.q(getContext(), getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        setText(com.tencent.mm.ui.e.c.b.c(getContext(), stringBuffer.substring(0, q) + str + stringBuffer.substring(q2, stringBuffer.length()), getTextSize()));
        setSelection(q + str.length());
    }

    public boolean requestFocus(int i, Rect rect) {
        return super.requestFocus(i, rect);
    }

    public void setSelection(int i) {
        super.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem;
        try {
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        } catch (IndexOutOfBoundsException e) {
            x.e("MicroMsg.MMEditText", "!!MMEditText IndexOutOfBoundsException %s", e);
            onTextContextMenuItem = false;
        } catch (NullPointerException e2) {
            x.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
        if (i == 16908322) {
            this.tTT = 0;
            String obj = getText().toString();
            try {
                Sf(obj);
            } catch (IndexOutOfBoundsException e3) {
                x.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.tTT));
                if (this.tTT < 3) {
                    this.tTT++;
                    Sf(" " + obj);
                } else {
                    throw e3;
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void Sf(String str) {
        int selectionStart = getSelectionStart();
        setText(com.tencent.mm.ui.e.c.b.c(getContext(), str, getTextSize()));
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

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        String str = "MicroMsg.MMEditText";
        String str2 = "on onKeyPreIme, listener null ? %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.ztP == null);
        x.v(str, str2, objArr);
        if (this.ztP != null && i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                x.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                x.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    x.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.ztP.aXC();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager == null) {
                        return true;
                    }
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}

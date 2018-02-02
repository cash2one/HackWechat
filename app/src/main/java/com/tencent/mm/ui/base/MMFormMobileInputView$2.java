package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class MMFormMobileInputView$2 implements TextWatcher {
    private ao nHl = new ao();
    final /* synthetic */ MMFormMobileInputView yaz;

    MMFormMobileInputView$2(MMFormMobileInputView mMFormMobileInputView) {
        this.yaz = mMFormMobileInputView;
    }

    public final void afterTextChanged(Editable editable) {
        int selectionEnd = MMFormMobileInputView.b(this.yaz).getSelectionEnd();
        String obj = MMFormMobileInputView.b(this.yaz).getText().toString();
        String substring = MMFormMobileInputView.b(this.yaz).getText().toString().substring(0, selectionEnd);
        if (obj != null && !obj.equals(MMFormMobileInputView.c(this.yaz))) {
            String obj2 = MMFormMobileInputView.a(this.yaz).getText().toString();
            MMFormMobileInputView.a(this.yaz, ao.formatNumber(obj2.replace("+", ""), obj));
            MMFormMobileInputView.b(this.yaz, ao.formatNumber(obj2.replace("+", ""), substring));
            if (!obj.equals(MMFormMobileInputView.c(this.yaz))) {
                MMFormMobileInputView.b(this.yaz).setText(MMFormMobileInputView.c(this.yaz));
                int length = MMFormMobileInputView.b(this.yaz).getText().toString().length();
                if (substring != null) {
                    try {
                        MMFormMobileInputView.b(this.yaz, ao.formatNumber(obj2.replace("+", ""), substring));
                        if (obj.length() > 13 && selectionEnd <= length) {
                            MMFormMobileInputView.b(this.yaz).setSelection(substring.toString().length());
                            return;
                        } else if (selectionEnd > length || MMFormMobileInputView.d(this.yaz).toString().length() > length) {
                            MMFormMobileInputView.b(this.yaz).setSelection(length - Math.abs(obj.length() - selectionEnd));
                            return;
                        } else {
                            MMFormMobileInputView.b(this.yaz).setSelection(MMFormMobileInputView.d(this.yaz).toString().length());
                            return;
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                        return;
                    }
                }
                MMFormMobileInputView.b(this.yaz).setSelection(0);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}

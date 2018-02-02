package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class TextInputLayout$1 implements TextWatcher {
    final /* synthetic */ TextInputLayout lo;

    TextInputLayout$1(TextInputLayout textInputLayout) {
        this.lo = textInputLayout;
    }

    public final void afterTextChanged(Editable editable) {
        TextInputLayout.a(this.lo);
        if (TextInputLayout.b(this.lo)) {
            TextInputLayout.a(this.lo, editable.length());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}

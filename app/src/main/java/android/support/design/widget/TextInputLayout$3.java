package android.support.design.widget;

import android.support.v4.view.an;
import android.view.View;

class TextInputLayout$3 extends an {
    final /* synthetic */ TextInputLayout lo;
    final /* synthetic */ CharSequence lp;

    TextInputLayout$3(TextInputLayout textInputLayout, CharSequence charSequence) {
        this.lo = textInputLayout;
        this.lp = charSequence;
    }

    public final void q(View view) {
        TextInputLayout.c(this.lo).setText(this.lp);
        view.setVisibility(4);
    }
}

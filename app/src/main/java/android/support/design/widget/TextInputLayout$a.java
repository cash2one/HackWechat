package android.support.design.widget;

import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class TextInputLayout$a extends a {
    final /* synthetic */ TextInputLayout lo;

    private TextInputLayout$a(TextInputLayout textInputLayout) {
        this.lo = textInputLayout;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        CharSequence charSequence = TextInputLayout.d(this.lo).mText;
        if (!TextUtils.isEmpty(charSequence)) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(TextInputLayout.class.getSimpleName());
        CharSequence charSequence = TextInputLayout.d(this.lo).mText;
        if (!TextUtils.isEmpty(charSequence)) {
            bVar.setText(charSequence);
        }
        if (TextInputLayout.e(this.lo) != null) {
            b.zW.f(bVar.zX, TextInputLayout.e(this.lo));
        }
        charSequence = TextInputLayout.c(this.lo) != null ? TextInputLayout.c(this.lo).getText() : null;
        if (!TextUtils.isEmpty(charSequence)) {
            b.zW.j(bVar.zX, true);
            b.zW.a(bVar.zX, charSequence);
        }
    }
}

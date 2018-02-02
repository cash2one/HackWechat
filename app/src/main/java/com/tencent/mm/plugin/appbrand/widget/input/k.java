package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

final class k extends PasswordTransformationMethod {
    k() {
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }
}

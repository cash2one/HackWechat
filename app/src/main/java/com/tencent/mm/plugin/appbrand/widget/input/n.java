package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;

public final class n extends c {
    private n(WeakReference<EditText> weakReference) {
        super(weakReference);
    }

    public static n a(EditText editText) {
        return new n(new WeakReference(editText));
    }

    protected final h bU(int i, int i2) {
        return new b(this, i, i2);
    }
}

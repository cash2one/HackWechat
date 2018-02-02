package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.sdk.platformtools.af;

public final class x {
    final af jKT;
    public b jZh;
    final Runnable jZi = new 1(this);
    private final EditText kT;

    public x(EditText editText) {
        this.kT = editText;
        this.jKT = new af(Looper.getMainLooper());
    }

    public final Editable c(Editable editable) {
        editable.setSpan(new 2(this), 0, editable.length(), 18);
        editable.setSpan(new 3(this), 0, editable.length(), 18);
        return editable;
    }
}

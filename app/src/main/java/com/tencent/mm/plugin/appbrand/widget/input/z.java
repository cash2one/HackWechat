package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public interface z {
    void a(OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(b bVar);

    void addTextChangedListener(TextWatcher textWatcher);

    boolean amK();

    boolean amL();

    boolean amO();

    b ana();

    void anc();

    void and();

    void ane();

    void b(OnFocusChangeListener onFocusChangeListener);

    void destroy();

    void dy(boolean z);

    Context getContext();

    int getInputId();

    View getInputPanel();

    CharSequence getText();

    View getView();

    void mc(int i);

    int me(int i);

    void r(float f, float f2);

    void r(p pVar);

    void s(p pVar);
}

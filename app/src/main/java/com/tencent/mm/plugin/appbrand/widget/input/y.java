package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.p;

public interface y<Input extends EditText & z> {
    boolean adjustPositionOnFocused();

    View getInputPanel();

    int getInputPanelMarginBottom();

    Input getWidget();

    boolean hideKeyboard();

    boolean isAttachedTo(p pVar);

    void ky(int i);

    boolean removeSelf();

    boolean showKeyboard(int i, int i2);

    void updateValue(String str, Integer num);
}

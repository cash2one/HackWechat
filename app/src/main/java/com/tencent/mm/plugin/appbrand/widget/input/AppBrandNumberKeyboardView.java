package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mm.ui.a.c;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class AppBrandNumberKeyboardView extends MyKeyboardWindow {
    AppBrandNumberKeyboardView(Context context) {
        super(context);
        init();
    }

    public AppBrandNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (VERSION.SDK_INT >= 14) {
            setAccessibilityDelegate(new c());
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setInputEditText(null);
    }
}

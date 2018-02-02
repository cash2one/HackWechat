package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.appbrand.q.f;

public final class e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    e(Context context) {
        super(context, null, 0);
        this.mContext = context;
        this.inJ.setInputMethodMode(2);
        this.inJ.setBackgroundDrawable(context.getResources().getDrawable(f.abc_popup_background_mtrl_mult));
        this.Tf = true;
        this.inJ.setFocusable(false);
        this.SR = false;
        this.SS = true;
        this.inJ.setAnimationStyle(a.isk);
    }

    public final void show() {
        super.show();
    }
}

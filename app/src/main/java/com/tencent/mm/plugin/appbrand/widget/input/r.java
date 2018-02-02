package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import com.tencent.wcdb.FileUtils;

final class r extends p {
    public r(Context context) {
        super(context);
    }

    public final View getInputPanel() {
        return u.bY(this);
    }

    public final void dv(boolean z) {
        anf();
        int inputType = getInputType() | 1;
        if (z) {
            inputType |= FileUtils.S_IWUSR;
        } else {
            inputType &= -129;
        }
        setInputType(inputType);
        super.dv(z);
        ang();
    }

    public final void amM() {
        af.cd(this).restartInput(this);
    }
}

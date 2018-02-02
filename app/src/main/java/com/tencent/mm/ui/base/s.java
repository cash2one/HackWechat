package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;

public class s extends ProgressDialog {
    public s(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.ui.base.h;

class OpenFileChooserUI$6$1 implements Runnable {
    final /* synthetic */ 6 twV;

    OpenFileChooserUI$6$1(6 6) {
        this.twV = 6;
    }

    public final void run() {
        if (this.twV.twU.mSF == 7 && this.twV.twU.mTg == 2) {
            h.a(this.twV.twU, this.twV.twU.getString(R.l.eWQ), this.twV.twU.getString(R.l.dGO), this.twV.twU.getString(R.l.dFs), false, new 1(this));
            return;
        }
        Toast.makeText(this.twV.twU, this.twV.twU.getString(R.l.eSY), 0).show();
        this.twV.twU.setResult(1);
        this.twV.twU.finish();
    }
}

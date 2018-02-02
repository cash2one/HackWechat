package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.R;
import com.tencent.mm.bc.g;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        return getString(R.l.dGz);
    }

    protected final void akN() {
        super.akN();
        g.io(this.scene);
    }

    protected void onResume() {
        super.onResume();
        g.QY();
    }

    protected void onPause() {
        super.onPause();
        g.QZ();
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Ra();
        g.Rb();
    }
}

package com.tencent.xweb.xwalk;

import android.webkit.WebView.FindListener;
import org.xwalk.core.XWalkFindListener;

public class e$f extends XWalkFindListener {
    FindListener ArE;

    public e$f(FindListener findListener) {
        this.ArE = findListener;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (this.ArE != null) {
            this.ArE.onFindResultReceived(i, i2, z);
        }
    }
}

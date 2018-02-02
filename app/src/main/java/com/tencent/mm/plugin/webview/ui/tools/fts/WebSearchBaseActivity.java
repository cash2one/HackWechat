package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public abstract class WebSearchBaseActivity extends CustomStatusBarMMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cmV();
        nR(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.bug));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.bug)));
        }
        setBackBtn(new 1(this));
    }

    protected final int getStatusBarColor() {
        return getResources().getColor(R.e.bug);
    }
}

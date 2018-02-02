package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.splash.d.b;
import com.tencent.mm.splash.e;
import com.tencent.mm.ui.MMActivity;

public class WeChatSplashActivity extends SplashActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MMActivity.initLanguage(getBaseContext());
        setContentView(b.xlw);
        e.chy();
    }

    public Resources getResources() {
        if (getAssets() == null || ac.getResources() == null) {
            return super.getResources();
        }
        return ac.getResources();
    }
}

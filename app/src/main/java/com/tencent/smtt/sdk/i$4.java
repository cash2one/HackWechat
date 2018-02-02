package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebChromeClient.a;

class i$4 extends a {
    final /* synthetic */ i zWw;
    final /* synthetic */ FileChooserParams zWx;

    i$4(i iVar, FileChooserParams fileChooserParams) {
        this.zWw = iVar;
        this.zWx = fileChooserParams;
    }

    public final Intent createIntent() {
        return this.zWx.createIntent();
    }

    public final String[] getAcceptTypes() {
        return this.zWx.getAcceptTypes();
    }

    public final String getFilenameHint() {
        return this.zWx.getFilenameHint();
    }

    public final int getMode() {
        return this.zWx.getMode();
    }

    public final CharSequence getTitle() {
        return this.zWx.getTitle();
    }

    public final boolean isCaptureEnabled() {
        return this.zWx.isCaptureEnabled();
    }
}

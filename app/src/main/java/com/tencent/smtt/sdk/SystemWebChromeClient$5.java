package com.tencent.smtt.sdk;

import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;

class SystemWebChromeClient$5 extends WebChromeClient$a {
    final /* synthetic */ SystemWebChromeClient this$0;
    final /* synthetic */ FileChooserParams val$SystemfileChooserParams;

    SystemWebChromeClient$5(SystemWebChromeClient systemWebChromeClient, FileChooserParams fileChooserParams) {
        this.this$0 = systemWebChromeClient;
        this.val$SystemfileChooserParams = fileChooserParams;
    }

    public Intent createIntent() {
        return this.val$SystemfileChooserParams.createIntent();
    }

    public String[] getAcceptTypes() {
        return this.val$SystemfileChooserParams.getAcceptTypes();
    }

    public String getFilenameHint() {
        return this.val$SystemfileChooserParams.getFilenameHint();
    }

    public int getMode() {
        return this.val$SystemfileChooserParams.getMode();
    }

    public CharSequence getTitle() {
        return this.val$SystemfileChooserParams.getTitle();
    }

    public boolean isCaptureEnabled() {
        return this.val$SystemfileChooserParams.isCaptureEnabled();
    }
}

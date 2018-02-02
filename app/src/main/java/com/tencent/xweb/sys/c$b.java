package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.xweb.j.a;

public class c$b extends a {
    public FileChooserParams Ard;

    public c$b(FileChooserParams fileChooserParams) {
        this.Ard = fileChooserParams;
    }

    @TargetApi(21)
    public final int getMode() {
        if (this.Ard != null) {
            return this.Ard.getMode();
        }
        return 0;
    }

    @TargetApi(21)
    public final String[] getAcceptTypes() {
        if (this.Ard != null) {
            return this.Ard.getAcceptTypes();
        }
        return new String[0];
    }

    @TargetApi(21)
    public final boolean isCaptureEnabled() {
        if (this.Ard != null) {
            return this.Ard.isCaptureEnabled();
        }
        return false;
    }
}

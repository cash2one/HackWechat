package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.smtt.utils.TbsLog;

public abstract class WebChromeClient$a {
    public static final int MODE_OPEN = 0;
    public static final int MODE_OPEN_FOLDER = 2;
    public static final int MODE_OPEN_MULTIPLE = 1;
    public static final int MODE_SAVE = 3;

    public static Uri[] parseResult(int i, Intent intent) {
        try {
            af cFg = af.cFg();
            if (cFg == null || !cFg.cFh()) {
                return VERSION.SDK_INT >= 21 ? FileChooserParams.parseResult(i, intent) : null;
            }
            Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(i), intent});
            return invokeStaticMethod == null ? null : (Uri[]) invokeStaticMethod;
        } catch (Exception e) {
            TbsLog.i("WebChromeClient", "parseResult:" + e.toString());
            return null;
        }
    }

    public abstract Intent createIntent();

    public abstract String[] getAcceptTypes();

    public abstract String getFilenameHint();

    public abstract int getMode();

    public abstract CharSequence getTitle();

    public abstract boolean isCaptureEnabled();
}

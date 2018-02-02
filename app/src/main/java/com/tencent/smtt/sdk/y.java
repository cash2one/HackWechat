package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;

final class y {
    private static y zYS = null;
    Context tI;
    z zYT = null;

    private y(Context context) {
        this.tI = context.getApplicationContext();
        this.zYT = new z(this.tI);
    }

    public static synchronized y hv(Context context) {
        y yVar;
        synchronized (y.class) {
            if (zYS == null) {
                zYS = new y(context);
            }
            yVar = zYS;
        }
        return yVar;
    }

    final void n(Activity activity, int i) {
        z zVar = this.zYT;
        if (!(i != 3 || zVar.cFa() || zVar.zYW == null)) {
            zVar.zYW.pause();
        }
        if (i == 4) {
            zVar.mContext = null;
            if (!(zVar.cFa() || zVar.zYW == null)) {
                zVar.zYW.stopPlayback();
                zVar.zYW = null;
            }
        }
        if (i == 2 && !zVar.cFa()) {
            zVar.mContext = activity;
            if (!(zVar.cFa() || zVar.zYW == null)) {
                if (zVar.zYW.getParent() == null) {
                    Window window = activity.getWindow();
                    FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                    window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    window.addFlags(FileUtils.S_IWUSR);
                    frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    MediaController mediaController = new MediaController(activity);
                    mediaController.setMediaPlayer(zVar.zYW);
                    zVar.zYW.setMediaController(mediaController);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayout.addView(zVar.zYW, layoutParams);
                }
                if (VERSION.SDK_INT >= 8) {
                    zVar.zYW.start();
                }
            }
        }
        if (zVar.cFa()) {
            zVar.zYV.a(zVar.zYU, activity, i);
        }
    }
}

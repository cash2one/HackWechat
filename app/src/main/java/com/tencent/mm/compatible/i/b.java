package com.tencent.mm.compatible.i;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static boolean b(Activity activity, int i) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        a.a(8, new 1(intent));
        try {
            activity.startActivityForResult(intent, 4372);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TakeVideoUtil", e, "", new Object[0]);
            return false;
        }
    }
}

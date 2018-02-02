package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    private static int vyx = -1;

    public static void a(View view, VideoSightView videoSightView) {
        if (view == null || videoSightView == null) {
            x.e("VideoSightHelper", "null view object " + view + "," + videoSightView);
        } else if (view.getVisibility() == 0) {
            videoSightView.addOnLayoutChangeListener(new 1(view));
        }
    }
}

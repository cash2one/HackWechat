package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;

public final class d {
    public static String fGF;
    public static int fMy;
    public static String tFK;

    public d(Intent intent) {
        if (intent != null) {
            fGF = bh.ou(intent.getStringExtra("KPublisherId"));
            tFK = bh.ou(intent.getStringExtra("geta8key_username"));
            fMy = bh.e(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        }
    }
}

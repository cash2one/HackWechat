package com.tencent.mm.ui.e.a;

import android.widget.ImageView;

public final class a {
    private static b zbE = null;

    public static void a(b bVar) {
        zbE = bVar;
    }

    public static void a(ImageView imageView, String str) {
        if (zbE != null) {
            zbE.a(imageView, str);
        }
    }
}

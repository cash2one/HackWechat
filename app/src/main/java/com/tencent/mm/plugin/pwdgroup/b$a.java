package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.j.a;

public class b$a {
    static a plt;

    public static void a(ImageView imageView, String str) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            drawable = new b(str, (byte) 0);
        } else {
            drawable = (b) drawable;
        }
        drawable.qw(str);
        imageView.setImageDrawable(drawable);
    }
}

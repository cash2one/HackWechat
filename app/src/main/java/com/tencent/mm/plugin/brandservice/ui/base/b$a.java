package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;

public class b$a {
    public static void a(ImageView imageView, String str, String str2) {
        Bitmap decodeResource = BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bzZ);
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            drawable = (decodeResource == null || decodeResource.isRecycled()) ? new b(str, str2, (byte) 0) : new b(str, str2, decodeResource, (byte) 0);
            imageView.setImageDrawable(drawable);
            return;
        }
        ((b) drawable).bM(str, str2);
    }
}

package com.tencent.mm.plugin.product.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import java.net.URL;

class HtmlTextView$2 implements ImageGetter {
    final /* synthetic */ HtmlTextView pfd;

    HtmlTextView$2(HtmlTextView htmlTextView) {
        this.pfd = htmlTextView;
    }

    public final Drawable getDrawable(String str) {
        try {
            Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
            if (createFromStream == null) {
                return createFromStream;
            }
            createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
            return createFromStream;
        } catch (Exception e) {
            return null;
        }
    }
}

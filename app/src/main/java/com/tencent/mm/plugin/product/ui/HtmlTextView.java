package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.kernel.g;

public class HtmlTextView extends TextView {
    ImageGetter peZ = new 2(this);
    TagHandler pfa = new 3(this);

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setText(String str) {
        g.Dm().a(new 1(this, str));
    }
}

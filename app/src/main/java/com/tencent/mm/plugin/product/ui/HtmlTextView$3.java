package com.tencent.mm.plugin.product.ui;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.style.StrikethroughSpan;
import org.xml.sax.XMLReader;

class HtmlTextView$3 implements TagHandler {
    final /* synthetic */ HtmlTextView pfd;

    HtmlTextView$3(HtmlTextView htmlTextView) {
        this.pfd = htmlTextView;
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        if (str.equalsIgnoreCase("strike") || str.equals("s")) {
            int length = editable.length();
            if (z) {
                editable.setSpan(new StrikethroughSpan(), length, length, 17);
                return;
            }
            Object a = a(editable, StrikethroughSpan.class);
            int spanStart = editable.getSpanStart(a);
            editable.removeSpan(a);
            if (spanStart != length) {
                editable.setSpan(new StrikethroughSpan(), spanStart, length, 33);
            }
        }
    }

    private static Object a(Editable editable, Class cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        for (int length = spans.length; length > 0; length--) {
            if (editable.getSpanFlags(spans[length - 1]) == 17) {
                return spans[length - 1];
            }
        }
        return null;
    }
}

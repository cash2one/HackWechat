package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.p;

public class HtmlTextView2 extends MMWebView {
    private p pfe = new 2(this);

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i) {
        super(ac.getContext(), attributeSet, i);
        initView();
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(ac.getContext(), attributeSet);
        initView();
    }

    private void initView() {
        setOnTouchListener(new 1(this));
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
    }
}

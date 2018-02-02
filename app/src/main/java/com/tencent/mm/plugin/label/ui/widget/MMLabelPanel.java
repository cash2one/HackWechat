package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;

public class MMLabelPanel extends MMTagPanel {
    public MMLabelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMLabelPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void aJB() {
        x.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
        if (this.wfh.size() <= 0) {
        }
    }
}

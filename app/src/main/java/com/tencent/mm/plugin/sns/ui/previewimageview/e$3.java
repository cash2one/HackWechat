package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements OnItemClickListener {
    final /* synthetic */ e rQz;

    e$3(e eVar) {
        this.rQz = eVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.rQz.rQs != null && view.getTag() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            x.i("DynamicGrid", "click " + intValue);
            if (intValue != Integer.MAX_VALUE) {
                this.rQz.rQs.xs(intValue);
            }
        }
    }
}

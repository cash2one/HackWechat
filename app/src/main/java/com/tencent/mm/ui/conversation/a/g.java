package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;

public final class g extends b {
    boolean ypn = false;
    String zaI = null;
    String zaJ = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        this.zaI = str;
        this.zaJ = str2;
        this.ypn = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.h.bUV);
            CharSequence W = ar.Hg().FG().W(this.zaI, "wording");
            CharSequence W2 = ar.Hg().FG().W(this.zaJ, "wording");
            if (!bh.ov(W)) {
                textView.setText(W);
            } else if (!bh.ov(W2)) {
                textView.setText(W2);
            }
            ((TextView) this.view.findViewById(R.h.bUU)).setOnClickListener(new 1(this));
            ((ImageView) this.view.findViewById(R.h.bUT)).setOnClickListener(new 2(this));
        }
    }

    public final int getLayoutId() {
        return R.i.dep;
    }

    public final void destroy() {
    }
}

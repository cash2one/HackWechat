package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.z.az;

public final class j extends b {
    LinearLayout zaQ = null;

    public j(Context context) {
        super(context);
        this.zaQ = new LinearLayout(context);
        this.zaQ.setVisibility(8);
        az.Hs().hgs = new 1(this, context);
        az.Hs().hgs.Hv();
    }

    public final boolean alg() {
        return this.zaQ != null && this.zaQ.getVisibility() == 0;
    }

    public final View getView() {
        return this.zaQ;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        az.Hs().hgs = null;
    }
}

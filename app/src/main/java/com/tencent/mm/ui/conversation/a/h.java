package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class h extends b {
    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.view.findViewById(R.h.cfP).setOnClickListener(new 1(this));
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
    }
}

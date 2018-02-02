package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;

public final class i extends b {
    int fWj;
    private c xFn;
    View zaN;

    public i(Context context) {
        super(context);
        this.zaN = View.inflate(context, R.i.dlL, null);
        if (this.zaN != null) {
            this.fWj = t.getInt(g.zY().getValue("InviteFriendsControlFlags"), 0);
            this.zaN.setVisibility(8);
            this.zaN.setPadding(0, -a.fromDPToPix(context, R.f.bvI), 0, 0);
            if ((this.fWj & 1) > 0) {
                this.zaN.setVisibility(0);
                this.zaN.setPadding(0, 0, 0, 0);
            }
            this.zaN.setOnClickListener(new 1(this, context));
            this.xFn = new 2(this);
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean alg() {
        com.tencent.mm.sdk.b.a.xef.b(this.xFn);
        return this.zaN != null && this.zaN.getVisibility() == 0;
    }

    public final void release() {
        com.tencent.mm.sdk.b.a.xef.c(this.xFn);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.zaN;
    }
}

package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.friend.f.b;

class f$b$1 implements OnClickListener {
    final /* synthetic */ f zdj;
    final /* synthetic */ b zdk;

    f$b$1(b bVar, f fVar) {
        this.zdk = bVar;
        this.zdj = fVar;
    }

    public final void onClick(View view) {
        if (f.b(this.zdk.zdh) != null) {
            f.b(this.zdk.zdh).i(this.zdk.wXW, this.zdk.hNv, this.zdk.status);
        }
    }
}

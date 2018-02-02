package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.friend.e.b;

class e$b$1 implements OnClickListener {
    final /* synthetic */ e zdd;
    final /* synthetic */ b zde;

    e$b$1(b bVar, e eVar) {
        this.zde = bVar;
        this.zdd = eVar;
    }

    public final void onClick(View view) {
        if (e.b(this.zde.zda) != null) {
            e.b(this.zde.zda).i(this.zde.wXW, this.zde.zdc, this.zde.status);
        }
    }
}

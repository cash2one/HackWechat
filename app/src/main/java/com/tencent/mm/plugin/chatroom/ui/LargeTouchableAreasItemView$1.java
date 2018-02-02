package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LargeTouchableAreasItemView$1 implements OnClickListener {
    final /* synthetic */ LargeTouchableAreasItemView lbd;

    LargeTouchableAreasItemView$1(LargeTouchableAreasItemView largeTouchableAreasItemView) {
        this.lbd = largeTouchableAreasItemView;
    }

    public final void onClick(View view) {
        this.lbd.ej(!LargeTouchableAreasItemView.a(this.lbd));
        if (LargeTouchableAreasItemView.b(this.lbd) != null) {
            LargeTouchableAreasItemView.b(this.lbd).ek(LargeTouchableAreasItemView.a(this.lbd));
        }
    }
}

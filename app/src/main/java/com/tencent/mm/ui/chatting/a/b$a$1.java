package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.a.b.a;

class b$a$1 implements OnClickListener {
    final /* synthetic */ a yyx;

    b$a$1(a aVar) {
        this.yyx = aVar;
    }

    public final void onClick(View view) {
        if (b.cte() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            b.cte().a(intValue, b.ctf().FD(intValue));
        }
    }
}

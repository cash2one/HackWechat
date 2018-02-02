package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.chatting.a.b.a;

class b$a$2 implements OnLongClickListener {
    final /* synthetic */ a yyx;

    b$a$2(a aVar) {
        this.yyx = aVar;
    }

    public final boolean onLongClick(View view) {
        if (b.cte() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            b.cte().a(view, intValue, b.ctf().FD(intValue));
        }
        return true;
    }
}

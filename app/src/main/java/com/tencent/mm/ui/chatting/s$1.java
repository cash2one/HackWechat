package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;

class s$1 implements OnClickListener {
    final /* synthetic */ s ytT;

    s$1(s sVar) {
        this.ytT = sVar;
    }

    public final void onClick(View view) {
        if (s.a(this.ytT).fW(((Long) view.getTag()).longValue())) {
            int size = s.a(this.ytT).ytp.size();
            s.b(this.ytT).yvY.ctV();
            s.c(this.ytT).cxX();
            s.d(this.ytT).setVisibility(0);
            s.d(this.ytT).Fu(size);
        }
    }
}

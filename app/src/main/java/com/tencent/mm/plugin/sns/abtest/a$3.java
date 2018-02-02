package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.m;

class a$3 implements OnClickListener {
    a$3() {
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof m) {
            a.a(view, view.getContext(), (m) view.getTag());
        }
    }
}

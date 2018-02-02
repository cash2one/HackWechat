package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.a.a.d;
import com.tencent.mm.ui.chatting.gallery.g.a;

class a$d$2 implements OnClickListener {
    final /* synthetic */ a yys;
    final /* synthetic */ d yyt;

    a$d$2(d dVar, a aVar) {
        this.yyt = dVar;
        this.yys = aVar;
    }

    public final void onClick(View view) {
        boolean z = !this.yyt.mSc.isChecked();
        if (a.cuF().yDd.size() < 9) {
            this.yyt.mSc.setChecked(z);
            if (z) {
                this.yyt.yyq.setVisibility(0);
            } else {
                this.yyt.yyq.setVisibility(8);
            }
        } else if (!z) {
            this.yyt.mSc.setChecked(false);
        }
        if (this.yyt.yyk.yyi != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.yyt.yyk.yyi.a(z, this.yyt.yyk.FC(intValue), intValue);
        }
    }
}

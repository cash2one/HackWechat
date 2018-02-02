package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;
import java.util.LinkedList;

class MallEditText$a$2 implements OnClickListener {
    final /* synthetic */ a pCE;

    MallEditText$a$2(a aVar) {
        this.pCE = aVar;
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.recharge.a.a.bmr().bt(null);
        this.pCE.pCy.b(null);
        MallEditText.d(this.pCE.pCy).bt(new LinkedList());
        MallEditText.d(this.pCE.pCy).notifyDataSetChanged();
    }
}

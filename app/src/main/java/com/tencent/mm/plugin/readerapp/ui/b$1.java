package com.tencent.mm.plugin.readerapp.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.ui.base.h;

class b$1 implements OnClickListener {
    final /* synthetic */ b pAI;

    b$1(b bVar) {
        this.pAI = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(new 1(this, h.a(this.pAI.context, this.pAI.context.getString(R.l.eBO), false, null)));
    }
}

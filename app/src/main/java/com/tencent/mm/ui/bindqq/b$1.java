package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindqq.b.3;
import com.tencent.mm.z.ar;

class b$1 implements OnClickListener {
    final /* synthetic */ EditText ymL;
    final /* synthetic */ b ymM;

    b$1(b bVar, EditText editText) {
        this.ymM = bVar;
        this.ymL = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ymM.pyk = null;
        b bVar = this.ymM;
        String trim = this.ymL.getText().toString().trim();
        bVar.EI();
        bVar.xPo = trim;
        Context context = bVar.context;
        bVar.context.getString(R.l.dGO);
        bVar.xPh = h.a(context, bVar.context.getString(R.l.eKe), true, new 3(bVar));
        ar.CG().a(new al(5, bVar.xPo, "", "", "", false, 1), 0);
    }
}

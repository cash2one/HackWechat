package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ar;

public abstract class r$d implements OnClickListener {
    public a yqa;

    public abstract void a(View view, a aVar, au auVar);

    public r$d(a aVar) {
        this.yqa = aVar;
    }

    public final void onClick(View view) {
        au auVar = ((ar) view.getTag()).fEJ;
        if (auVar != null) {
            a(view, this.yqa, auVar);
        }
    }
}

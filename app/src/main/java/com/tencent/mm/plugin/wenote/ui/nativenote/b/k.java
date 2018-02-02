package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends a {
    private WXRTEditText tYx;

    public k(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.tYx = (WXRTEditText) view.findViewById(R.h.cIC);
        if (!(kVar.tUp == 2 && this.tWs.tUq)) {
            this.tYx.setKeyListener(null);
            this.tYx.setFocusable(false);
            this.tYx.setClickable(true);
        }
        this.tYx.tTy = this;
        this.tYx.tTw = 0;
        this.tWs.o(this.tYx);
        this.tYx.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this));
    }

    public final void a(b bVar, int i, int i2) {
        this.tYx.tTJ = i;
        h hVar = (h) bVar;
        hVar.tRy = this.tYx;
        hVar.tRw = null;
        hVar.tRx = null;
        b Bt = c.bWp().Bt(i - 1);
        if (Bt != null && Bt.getType() == 1) {
            LayoutParams layoutParams = (LayoutParams) this.tYx.getLayoutParams();
            layoutParams.topMargin = 0;
            this.tYx.setLayoutParams(layoutParams);
        }
        Bt = c.bWp().Bt(i + 1);
        if (Bt != null && Bt.getType() == 1) {
            layoutParams = (LayoutParams) this.tYx.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.tYx.setLayoutParams(layoutParams);
        }
        if (this.tWs.tUp == 2 && this.tWs.tUq) {
            ag.y(new 2(this, hVar));
        } else {
            this.tYx.QR(hVar.content);
            i.i(this.tYx);
        }
        x.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + gd());
    }

    public final int bXO() {
        return 1;
    }
}

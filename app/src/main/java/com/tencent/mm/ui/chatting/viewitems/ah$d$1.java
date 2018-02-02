package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.viewitems.ah.d;
import com.tencent.mm.ui.widget.MMTextView.b;

class ah$d$1 implements b {
    final /* synthetic */ au heR;
    final /* synthetic */ a yII;
    final /* synthetic */ d yNS;

    ah$d$1(a aVar, au auVar, d dVar) {
        this.yII = aVar;
        this.heR = auVar;
        this.yNS = dVar;
    }

    public final boolean do(View view) {
        if (this.yII.yvJ.gf(this.heR.field_msgId) == d.a.yNW) {
            Context context = this.yII.getContext();
            CharSequence text = this.yNS.yNH.getText();
            Intent intent = new Intent(context, TextPreviewUI.class);
            intent.putExtra("key_chat_text", text);
            context.startActivity(intent);
            com.tencent.mm.ui.base.b.fF(context);
            cf cfVar = this.heR;
            com.tencent.mm.sdk.b.b fiVar = new fi();
            fiVar.fuz.fuA = 3;
            fiVar.fuz.scene = 1;
            fiVar.fuz.fileName = cfVar.field_imgPath;
            com.tencent.mm.sdk.b.a.xef.m(fiVar);
        }
        return true;
    }
}

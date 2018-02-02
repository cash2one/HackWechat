package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.g;
import java.util.Map;

final class q$a implements OnClickListener {
    final /* synthetic */ q yLH;

    private q$a(q qVar) {
        this.yLH = qVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof au) {
            au auVar = (au) view.getTag();
            if (auVar == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                return;
            }
            Map y = bi.y(auVar.field_content, "msg");
            if (y == null || y.size() == 0) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                return;
            }
            String ou = bh.ou((String) y.get(".msg.fromusername"));
            g gVar = new g(view.getContext(), g.ztp, false);
            gVar.rKC = new 1(this, view);
            gVar.rKD = new 2(this, view, auVar, ou);
            gVar.bUk();
            return;
        }
        x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
    }
}

package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class AllRemindMsgUI$c extends RecyclerView$t {
    View VU;
    ImageView hvY;
    TextView ihS;
    TextView qmh;
    TextView tEW;
    final /* synthetic */ AllRemindMsgUI xDG;

    static /* synthetic */ void a(Context context, String str, long j) {
        if (str == null) {
            x.e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        ar.Hg();
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(c.Fa().F(str, j).field_msgId));
        if (str.contains("@")) {
            ar.Hg();
            if (c.Fh().hD(str) == null) {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
                return;
            }
        }
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO == null || !a.fZ(WO.field_type)) {
            if (WO == null) {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
            } else {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
            }
            h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ifs.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), context);
    }

    public AllRemindMsgUI$c(AllRemindMsgUI allRemindMsgUI, View view) {
        this.xDG = allRemindMsgUI;
        super(view);
        this.VU = view;
        this.ihS = (TextView) view.findViewById(R.h.title);
        this.tEW = (TextView) view.findViewById(R.h.cRJ);
        this.qmh = (TextView) view.findViewById(R.h.cAl);
        this.hvY = (ImageView) view.findViewById(R.h.bLC);
        this.VU.setOnClickListener(new 1(this, allRemindMsgUI));
        this.VU.setOnTouchListener(new 2(this, allRemindMsgUI));
        this.VU.setOnLongClickListener(new 3(this, allRemindMsgUI));
    }
}

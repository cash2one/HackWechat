package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

public class r$c implements OnLongClickListener {
    private a yqa;

    public r$c(a aVar) {
        this.yqa = aVar;
    }

    public final boolean onLongClick(View view) {
        if (this.yqa.ywy) {
            ar arVar = (ar) view.getTag();
            int selectionStart = this.yqa.ywe.csB().okv.getSelectionStart();
            if (!arVar.userName.equals(q.FS())) {
                if (this.yqa.ywe.csB().vlJ) {
                    x.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                } else if (s.eV(this.yqa.crz()) || this.yqa.ywd.yyK) {
                    String gu;
                    g.pQN.h(10976, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                    com.tencent.mm.z.ar.Hg();
                    com.tencent.mm.storage.q hD = c.Fh().hD(arVar.chatroomName);
                    if (this.yqa.ywd.yyK) {
                        gu = this.yqa.gu(arVar.userName);
                    } else {
                        gu = AtSomeoneUI.a(hD, arVar.userName);
                        if (t.ov(gu)) {
                            gu = r.gs(arVar.userName);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(this.yqa.ywe.csB().cbs());
                    stringBuffer.insert(selectionStart, "@" + gu + ' ');
                    this.yqa.ywe.csB().p(stringBuffer.toString(), (selectionStart + gu.length()) + 2, true);
                    this.yqa.ywe.csB().ad(arVar.chatroomName, arVar.userName, gu);
                    this.yqa.ywy = false;
                    this.yqa.ywe.csB().aa(1, true);
                    view.postDelayed(new 1(this), 2000);
                } else if (s.gE(this.yqa.crz()) && !this.yqa.crz().contains("@")) {
                    String gs;
                    g.pQN.h(10976, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
                    if (!this.yqa.ywd.vnK || this.yqa.ywd.yyK) {
                        gs = r.gs(arVar.userName);
                    } else {
                        gs = this.yqa.gu(arVar.userName);
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(this.yqa.ywe.csB().cbs());
                    stringBuffer2.insert(selectionStart, gs);
                    this.yqa.ywe.csB().p(stringBuffer2.toString(), gs.length() + selectionStart, true);
                    this.yqa.ywy = false;
                    this.yqa.ywe.csB().aa(1, true);
                    view.postDelayed(new 2(this), 2000);
                }
            }
        } else {
            x.w("MicroMsg.ChattingListAvatarListener", "ChattingUI disable Touch NOW!!!");
        }
        return true;
    }
}

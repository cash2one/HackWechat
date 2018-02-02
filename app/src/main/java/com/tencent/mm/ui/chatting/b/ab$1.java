package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ah.d.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ab$1 implements Runnable {
    final /* synthetic */ ff tJg;
    final /* synthetic */ ab yCv;

    ab$1(ab abVar, ff ffVar) {
        this.yCv = abVar;
        this.tJg = ffVar;
    }

    public final void run() {
        if (this.tJg.fur.aow) {
            if (bh.ov(this.tJg.fur.content)) {
                if (this.tJg.fur.state == 2) {
                    x.i("MicroMsg.TransformImp", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[]{this.tJg.fuq.fus});
                    ab.a(this.yCv, ab.a(this.yCv).getString(R.l.dTf));
                }
                this.yCv.ge(Long.valueOf(this.tJg.fuq.fus).longValue());
                this.yCv.gi(Long.valueOf(this.tJg.fuq.fus).longValue());
                this.yCv.yCs = false;
                ab.b(this.yCv);
            } else {
                x.i("MicroMsg.TransformImp", "go VoiceTransTextAct isCompleted msgId:%s", new Object[]{this.tJg.fuq.fus});
                cf gh = this.yCv.gh(Long.valueOf(this.tJg.fuq.fus).longValue());
                if (gh != null) {
                    this.yCv.a(Long.valueOf(this.tJg.fuq.fus).longValue(), this.tJg.fur.content, a.yNW);
                    gh.cjB();
                    ar.Hg();
                    c.Fa().a(gh.field_msgId, gh);
                    this.yCv.gi(Long.valueOf(this.tJg.fuq.fus).longValue());
                    ab.b(this.yCv);
                }
                this.yCv.yCs = false;
            }
            this.yCv.cud();
            return;
        }
        if (!bh.ov(this.tJg.fur.content)) {
            this.yCv.a(Long.valueOf(this.tJg.fuq.fus).longValue(), this.tJg.fur.content, a.yNV);
            x.i("MicroMsg.TransformImp", "go VoiceTransTextAct refresh msgId:%s", new Object[]{this.tJg.fuq.fus});
        }
        ab.b(this.yCv);
    }
}

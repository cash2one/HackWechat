package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.t;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ChattingUI$a$2 implements g {
    final /* synthetic */ a ywR;

    ChattingUI$a$2(a aVar) {
        this.ywR = aVar;
    }

    public final boolean azn() {
        boolean z;
        int count;
        int count2;
        x.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData isChatroomChat[%b], talker[%s]", new Object[]{Boolean.valueOf(this.ywR.ysk), this.ywR.fAh.field_username});
        if (this.ywR.yvY.ysa || this.ywR.yvY.yAM || this.ywR.yvY.yAJ) {
            this.ywR.ysf.ytj = true;
        }
        w wVar = this.ywR.yvO;
        if (wVar.fhr.cse()) {
            au auVar = (au) wVar.fhr.csy().getItem(0);
            if (auVar == null || auVar.field_msgId == 0) {
                x.d("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData firstMsgInfo is null");
            } else {
                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.getType()), auVar.field_talker});
                ar.Hg();
                if ((c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_flag & 1) == 0) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault found in cache but db is not[%d, %d, %d, %d, %d, %d, %d, %s] notify", new Object[]{Integer.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_flag), Integer.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_isSend), Long.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_msgId), Long.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_msgSvrId), Long.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_msgSeq), Long.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_createTime), Integer.valueOf(c.Fa().G(auVar.field_talker, auVar.field_msgSeq).getType()), c.Fa().G(auVar.field_talker, auVar.field_msgSeq).field_talker});
                    wVar.fhr.csy().crK();
                } else if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault found");
                    wVar.fhr.csy().mF(true);
                    ar.Dm().F(new w$6(wVar, auVar));
                    z = true;
                    if (z) {
                        return false;
                    }
                    if (this.ywR.ysf.crM()) {
                        count = this.ywR.ysf.getCount();
                        this.ywR.ysf.Fv(18);
                        this.ywR.ysf.crL();
                        count2 = this.ywR.ysf.getCount();
                        x.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", new Object[]{this.ywR.fAh.field_username, Integer.valueOf(count2), Integer.valueOf(count)});
                        if (count2 > count) {
                            count = count2 - count;
                            this.ywR.ysf.Fw(count);
                            x.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(count + 1), Integer.valueOf(this.ywR.ywh.ctA() + a.g(this.ywR).ycr)});
                            t.a(a.c(this.ywR), count + 1, this.ywR.ywh.ctA() + a.g(this.ywR).ycr, false);
                        }
                        return true;
                    }
                    x.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(1), Integer.valueOf(a.g(this.ywR).ycr)});
                    t.a(a.c(this.ywR), 1, a.g(this.ywR).ycr, false);
                    a.g(this.ywR).mm(true);
                    return true;
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        if (this.ywR.ysf.crM()) {
            count = this.ywR.ysf.getCount();
            this.ywR.ysf.Fv(18);
            this.ywR.ysf.crL();
            count2 = this.ywR.ysf.getCount();
            x.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", new Object[]{this.ywR.fAh.field_username, Integer.valueOf(count2), Integer.valueOf(count)});
            if (count2 > count) {
                count = count2 - count;
                this.ywR.ysf.Fw(count);
                x.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(count + 1), Integer.valueOf(this.ywR.ywh.ctA() + a.g(this.ywR).ycr)});
                t.a(a.c(this.ywR), count + 1, this.ywR.ywh.ctA() + a.g(this.ywR).ycr, false);
            }
            return true;
        }
        x.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(1), Integer.valueOf(a.g(this.ywR).ycr)});
        t.a(a.c(this.ywR), 1, a.g(this.ywR).ycr, false);
        a.g(this.ywR).mm(true);
        return true;
    }
}

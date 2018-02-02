package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.aq.o;
import com.tencent.mm.ca.d;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.chatting.b.w.7;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ChattingUI$a$7 implements OnScrollListener {
    final /* synthetic */ a ywR;

    ChattingUI$a$7(a aVar) {
        this.ywR = aVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        x.d("MicroMsg.ChattingUI", "onScrollStateChanged mScrollState=%d, scrollState=%d", new Object[]{Integer.valueOf(a.b(this.ywR)), Integer.valueOf(i)});
        a.a(this.ywR, i);
        q qVar = this.ywR.ysf;
        a aVar = this.ywR;
        if (i == 0) {
            w wVar = aVar.yvO;
            View childAt = wVar.fhr.csx().getChildAt(wVar.fhr.csx().getFirstVisiblePosition());
            au auVar;
            if (childAt != null && childAt.getTop() == 0) {
                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange forceTopLoadData true");
                if (wVar.fhr.cse()) {
                    auVar = (au) wVar.fhr.csy().getItem(0);
                    if (!(auVar == null || auVar.field_msgId == 0)) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.getType()), auVar.field_talker});
                        if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                            wVar.fhr.csz().mm(false);
                        }
                    }
                }
            } else if (wVar.fhr.cse() && wVar.fhr.csx().getChildAt(wVar.fhr.csx().getChildCount() - 1) != null && wVar.fhr.csx().getLastVisiblePosition() == wVar.fhr.csx().getAdapter().getCount() - 1) {
                auVar = (au) wVar.fhr.csy().getItem(wVar.fhr.csy().getCount() - 1);
                if (auVar == null || auVar.field_msgId == 0) {
                    if (((auVar != null ? 1 : 0) & ((auVar.field_flag & 2) != 0 ? 1 : 0)) != 0) {
                        ar.Hg();
                        cf Ex = c.Fa().Ex(auVar.field_talker);
                        if (!(Ex == null || Ex.field_msgId == 0 || Ex.field_createTime <= auVar.field_createTime)) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[]{Integer.valueOf(Ex.field_flag), Integer.valueOf(Ex.field_isSend), Long.valueOf(Ex.field_msgId), Long.valueOf(Ex.field_msgSvrId), Long.valueOf(Ex.field_msgSeq), Long.valueOf(Ex.field_createTime), Integer.valueOf(Ex.getType()), Ex.field_talker});
                            wVar.fhr.csy().crK();
                        }
                    }
                } else {
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.getType()), auVar.field_talker});
                    if ((auVar.field_flag & 1) != 0 && (auVar.field_flag & 4) == 0) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange forceBottomLoadData not");
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault found");
                        wVar.fhr.csy().mF(true);
                        ar.Dm().F(new 7(wVar, auVar));
                    }
                }
            }
            childAt = aVar.ywp.getChildAt(aVar.ywp.getFirstVisiblePosition());
            if (childAt != null && childAt.getTop() == 0) {
                aVar.onH.mq(true);
            }
            aVar.yvN.ctR();
            b rtVar = new rt();
            rtVar.fJy.type = 5;
            rtVar.fJy.fJz = aVar.ywp.getFirstVisiblePosition();
            rtVar.fJy.fJA = aVar.ywp.getLastVisiblePosition();
            rtVar.fJy.fJB = aVar.ywp.getHeaderViewsCount();
            com.tencent.mm.sdk.b.a.xef.m(rtVar);
        }
        if (i == 2) {
            d.clq().de(ChattingUI.class.getName() + ".Listview", 4);
            aVar.yvN.TG();
        }
        o.PA().bp(i);
    }

    public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (a.j(this.ywR)) {
            if (a.c(this.ywR).getLastVisiblePosition() == i3 - 1) {
                a.k(this.ywR);
            }
        }
        w wVar = this.ywR.yvO;
        if (wVar.yBi && i3 - i == (wVar.yBk << 1)) {
            wVar.yBi = false;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr set dealHistoryGetMsg %b firstVisibleItem: %d, totalItemCount:%d mUnreadMessageBeforeCheckHistory:%d", new Object[]{Boolean.valueOf(wVar.yBi), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(wVar.yBk)});
        }
        if (a.l(this.ywR) > 0 && i3 - (i + 1) >= a.l(this.ywR) && a.m(this.ywR) != null && a.m(this.ywR).getVisibility() == 0) {
            x.i("MicroMsg.ChattingUI", "summerbadcr jacks onScroll dismissGoBackToHistory mUnreadMessage[%d] [%d,%d]", new Object[]{Integer.valueOf(a.l(this.ywR)), Integer.valueOf(i3), Integer.valueOf(i)});
            this.ywR.csU();
        }
    }
}

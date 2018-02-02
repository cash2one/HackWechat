package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.h.c;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements c, a {
    private Context context;
    private String lbu = "";
    private ViewGroup nTO;
    private View nTP;
    private h nTQ;
    private j nTR;
    private ArrayList<String> nTS;
    private String nTT = "";
    private boolean nTU = false;
    public a nTV;
    private d nTp;

    public i(Context context, ViewGroup viewGroup, View view, String str, d dVar) {
        this.nTO = viewGroup;
        this.nTP = view;
        this.context = context;
        this.nTS = new ArrayList();
        this.lbu = str;
        this.nTp = dVar;
        init();
    }

    private void init() {
        x.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[]{this.lbu});
        this.nTQ = new h(this.context, this.nTP, this.lbu);
        this.nTQ.nTG = this;
        this.nTR = new j(this.context, this.nTO, this.lbu);
        for (String add : l.aVv().DA(this.lbu)) {
            this.nTS.add(add);
        }
    }

    public final void F(ArrayList<String> arrayList) {
        x.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        this.nTQ.F(arrayList);
        j jVar = this.nTR;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (jVar.nTX.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = jVar.nTX.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (jVar.nUj) {
            jVar.nUj = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jVar.nTX.add((String) it2.next());
                }
            }
            jVar.gn(false);
            return;
        }
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            jVar.nTX.add(str);
            if (!bh.ov(r.gu(str))) {
                jVar.mHandler.removeMessages(3);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                jVar.mHandler.sendMessage(obtain);
                jVar.gn(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!bh.ov(str) && jVar.nTX.indexOf(str) != -1) {
                jVar.nTX.remove(jVar.nTX.indexOf(str));
                if (!bh.ov(r.gu(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    jVar.mHandler.sendMessage(obtain);
                    jVar.gn(true);
                }
            }
        }
    }

    public final void DJ(String str) {
        if (this.nTV != null) {
            this.nTV.DJ(str);
        }
    }

    public final void aVU() {
        x.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.nTU = true;
        String FS = q.FS();
        this.nTQ.aVQ();
        this.nTQ.DG(FS);
        j jVar = this.nTR;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        jVar.mHandler.removeMessages(6);
        jVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        View viewByItag = this.nTp.getViewByItag(FS);
        if (viewByItag instanceof TrackPoint) {
            viewByItag.bringToFront();
            this.nTp.invalidate();
        }
        this.nTT = FS;
    }

    public final void DK(String str) {
        x.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[]{str});
        if (!this.nTU) {
            this.nTT = str;
            h hVar = this.nTQ;
            String str2 = this.nTT;
            x.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[]{str2});
            if (bh.ov(str2)) {
                hVar.aVQ();
            } else {
                hVar.aVQ();
                hVar.DG(str2);
            }
            j jVar = this.nTR;
            str2 = this.nTT;
            x.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[]{str2});
            if (bh.ov(str2)) {
                jVar.nUo = false;
                jVar.mHandler.removeMessages(10);
                Message obtain = Message.obtain();
                obtain.what = 10;
                jVar.mHandler.sendMessage(obtain);
                jVar.gn(true);
            } else {
                if (!bh.ov(r.gu(str2))) {
                    jVar.nUo = true;
                    jVar.mHandler.removeMessages(5);
                    Message obtain2 = Message.obtain();
                    obtain2.what = 5;
                    obtain2.obj = str2;
                    jVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
                }
                jVar.gn(true);
            }
            View viewByItag = this.nTp.getViewByItag(this.nTT);
            if (viewByItag instanceof TrackPoint) {
                viewByItag.bringToFront();
                this.nTp.invalidate();
            }
        }
    }

    public final void aVV() {
        x.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        h hVar = this.nTQ;
        String FS = q.FS();
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[]{FS});
        if (hVar.nTE.DI(FS)) {
            hVar.nTE.DH(FS).aVT();
            hVar.nTE.notifyDataSetChanged();
            hVar.nTD.invalidate();
        }
        j jVar = this.nTR;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        jVar.mHandler.removeMessages(9);
        jVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        jVar.mHandler.sendMessage(obtain);
        this.nTT = "";
        this.nTU = false;
    }

    public final void aVW() {
        j jVar = this.nTR;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        jVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
    }

    public final void DL(String str) {
        j jVar = this.nTR;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[]{str});
        if (!bh.ov(str) && !bh.ov(r.gu(str))) {
            jVar.nUo = true;
            jVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
    }
}

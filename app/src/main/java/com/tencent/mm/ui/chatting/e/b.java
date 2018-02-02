package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.b.f;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b implements f, a {
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> jRt = null;
    protected String jRw;
    protected Context mContext;
    private boolean vzn = false;
    private long yDU = 0;
    protected com.tencent.mm.ui.chatting.c.b.b yHf;
    com.tencent.mm.ui.chatting.a.b yHg;
    private LinearLayoutManager yHh;
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> yHi = null;

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.chatting.h.a aVar) {
        com.tencent.mm.ui.chatting.c.b.b bVar = (com.tencent.mm.ui.chatting.c.b.b) aVar;
        this.yHf = bVar;
        bVar.a(this);
    }

    public final /* synthetic */ h fM(Context context) {
        if (this.yHh == null) {
            this.yHh = new LinearLayoutManager();
        }
        return this.yHh;
    }

    public b(Context context) {
        this.mContext = context;
        this.jRt = new ArrayList();
    }

    public final void onDetach() {
        this.yHf.a(null);
        this.yHf = null;
        if (this.yHg != null) {
            com.tencent.mm.ui.chatting.a.b.yyu = null;
            com.tencent.mm.ui.chatting.a.b.yyv = null;
        }
    }

    public final g cuq() {
        return new 1(this);
    }

    public final com.tencent.mm.ui.chatting.a.b.b FD(int i) {
        if (this.jRt == null || this.jRt.size() <= i) {
            return null;
        }
        return (com.tencent.mm.ui.chatting.a.b.b) this.jRt.get(i);
    }

    public final RecyclerView.a Zm(String str) {
        this.jRw = str;
        this.yHg = new com.tencent.mm.ui.chatting.a.b(this.mContext, this);
        com.tencent.mm.ui.chatting.a.b.yyu = cus();
        return this.yHg;
    }

    public final int getCount() {
        if (this.jRt == null) {
            return 0;
        }
        return this.jRt.size();
    }

    public final p.a cut() {
        return new 2(this);
    }

    protected static String g(au auVar, boolean z) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return q.FS();
        }
        if (z) {
            str = ba.hP(auVar.field_content);
        }
        if (bh.ov(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    public final void d(int i, au auVar) {
        x.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.a(219, 19, 1, true);
                boolean endsWith = this.jRw.toLowerCase().endsWith("@chatroom");
                List arrayList = new ArrayList(1);
                arrayList.add(auVar);
                j.a(this.mContext, arrayList, endsWith, this.jRw, new 3(this));
                return;
            case 1:
                com.tencent.mm.sdk.b.b cfVar = new cf();
                List arrayList2 = new ArrayList(1);
                arrayList2.add(auVar);
                if (com.tencent.mm.pluginsdk.model.h.a(this.mContext, cfVar, this.jRw, arrayList2, false, false)) {
                    cfVar.fqp.fqw = 45;
                    cfVar.fqp.activity = (Activity) this.mContext;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    if (cfVar.fqq.ret != -2 && cfVar.fqq.ret <= 0 && cfVar.fqq.ret <= 0) {
                        if (14 != cfVar.fqp.type) {
                            x.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
                            return;
                        } else if (cfVar.fqp.fqs == null) {
                            x.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.g.pQN.h(11142, new Object[]{Integer.valueOf(cfVar.fqp.fqs.wfk), Integer.valueOf(cfVar.fqp.fqs.wfl), Integer.valueOf(cfVar.fqp.fqs.wfm), Integer.valueOf(cfVar.fqp.fqs.wfn), Integer.valueOf(cfVar.fqp.fqs.wfo), Integer.valueOf(cfVar.fqp.fqs.wfp), Integer.valueOf(cfVar.fqp.fqs.wfq), Integer.valueOf(cfVar.fqp.fqs.wfr), Integer.valueOf(cfVar.fqp.fqs.wfs), Integer.valueOf(cfVar.fqp.fqs.wft), Integer.valueOf(cfVar.fqp.fqs.wfu), Integer.valueOf(cfVar.fqp.fqs.wfv), Integer.valueOf(cfVar.fqp.fqs.wfw), Integer.valueOf(cfVar.fqp.fqs.wfx), Integer.valueOf(cfVar.fqp.fqs.wfy)});
                            return;
                        }
                    }
                    return;
                }
                x.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
                return;
            case 2:
                com.tencent.mm.plugin.report.service.g.pQN.h(11627, new Object[]{Integer.valueOf(5)});
                Set treeSet = new TreeSet();
                treeSet.add(Long.valueOf(auVar.field_msgId));
                com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.dTV), "", this.mContext.getString(R.l.dYt), this.mContext.getString(R.l.dEn), new 4(this, treeSet, auVar), null);
                return;
            default:
                return;
        }
    }

    protected final boolean cvr() {
        long j = this.yDU + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yDU = currentTimeMillis;
        if (j < currentTimeMillis) {
            ar.Hg();
            this.vzn = c.isSDCardAvailable();
        }
        return this.vzn;
    }
}

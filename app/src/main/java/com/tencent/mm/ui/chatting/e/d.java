package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Date;
import java.util.LinkedList;

public final class d extends b {
    int jRy = -1;
    int yHq = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean yHb = true;
        final /* synthetic */ d yHr;

        AnonymousClass1(d dVar, boolean z) {
            this.yHr = dVar;
        }

        public final void run() {
            Object linkedList = new LinkedList();
            ar.Hg();
            Cursor by = c.Fa().by(this.yHr.jRw, this.yHr.jRy);
            if (by == null) {
                x.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
                return;
            }
            q hD;
            if (s.eV(this.yHr.jRw)) {
                ar.Hg();
                hD = c.Fh().hD(this.yHr.jRw);
            } else {
                hD = null;
            }
            long j = 0;
            while (by.moveToNext()) {
                try {
                    cf auVar = new au();
                    auVar.b(by);
                    String str = auVar.field_content;
                    if (str != null) {
                        a fT = a.fT(str);
                        if ((6 == fT.type ? 1 : null) != null) {
                            long b = com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new b.c(auVar.field_createTime));
                                d dVar = this.yHr;
                                dVar.yHq++;
                            }
                            String g = b.g(auVar, s.eV(this.yHr.jRw));
                            af WO = ((h) g.h(h.class)).EY().WO(g);
                            String str2 = "";
                            if (hD != null) {
                                str2 = hD.gu(g);
                            }
                            int Rr = com.tencent.mm.pluginsdk.model.c.Rr(fT.hbc);
                            a aVar = new a(this.yHr, auVar.field_createTime, fT.type, fT.title, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2);
                            aVar.iconRes = Rr;
                            aVar.desc = bh.bx((long) fT.hbb);
                            linkedList.add(aVar);
                            j = b;
                        }
                    }
                } finally {
                    by.close();
                }
            }
            this.yHr.jRt.addAll(linkedList);
            this.yHr.yHi = this.yHr.jRt;
            linkedList.clear();
            x.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[]{Integer.valueOf(this.yHr.jRt.size())});
            ag.y(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 yHs;

                {
                    this.yHs = r1;
                }

                public final void run() {
                    if (this.yHs.yHr.yHf != null) {
                        this.yHs.yHr.yHf.z(this.yHs.yHb, this.yHs.yHr.jRt.size());
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(d dVar, b.b bVar) {
        if (dVar.cvr()) {
            Intent intent = new Intent();
            intent.setClassName(dVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", bVar.fqm);
            dVar.mContext.startActivity(intent);
            return;
        }
        u.fI(dVar.mContext);
    }

    public d(Context context) {
        super(context);
    }

    public final int getType() {
        return 6;
    }

    public final void cur() {
        x.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.yHf.cuv();
        g.Dk();
        g.Dm().F(new AnonymousClass1(this, true));
    }

    public final String WW() {
        return this.mContext.getString(R.l.dDy);
    }

    public final String cuu() {
        return this.mContext.getString(R.l.dDy);
    }

    public final e cus() {
        return new 2(this);
    }

    public final t l(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dib, viewGroup, false));
    }

    public final void a(b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FD(i);
        if (bh.ov(aVar2.desc)) {
            bVar.iir.setVisibility(8);
        } else {
            bVar.iir.setVisibility(0);
            bVar.iir.setText(bh.az(aVar2.desc, ""));
        }
        bVar.jCP.setImageResource(aVar2.iconRes);
    }
}

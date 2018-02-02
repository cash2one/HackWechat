package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.l$a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a$c;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.g;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.gallery.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e implements a, s.a, com.tencent.mm.ui.chatting.c.a.a, b {
    static int count = 0;
    private ArrayList<c> jRt = null;
    private String jRw;
    private Context mContext;
    private af mHandler = new af(Looper.getMainLooper());
    private int mNk = 0;
    private com.tencent.mm.sdk.b.c yAr = new 9(this);
    private int yHq = 0;
    private com.tencent.mm.ui.chatting.c.a.b yHu;
    com.tencent.mm.ui.chatting.a.a yHv;
    private GridLayoutManager yHw;
    boolean yHx = false;
    private int yHy = 0;
    private boolean yHz = false;
    private long yyg;

    static /* synthetic */ void a(e eVar, long j, gl glVar) {
        int i = -1;
        for (c cVar : eVar.yHv.jNq) {
            i++;
            if (cVar.fEJ != null && cVar.fEJ.field_msgId == j) {
                break;
            }
        }
        i = -1;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eVar.fM(eVar.mContext);
        int eZ = gridLayoutManager.eZ();
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(eZ), Integer.valueOf(gridLayoutManager.fa())});
        if (i >= eZ && i <= r0) {
            View childAt = eVar.yHu.getChildAt(i - eZ);
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                glVar.fwz.foL = iArr[0];
                glVar.fwz.foM = iArr[1];
                glVar.fwz.foN = childAt.getWidth();
                glVar.fwz.foO = childAt.getHeight();
            }
        }
    }

    static /* synthetic */ void a(e eVar, au auVar) {
        r bq = i.bq(auVar);
        if (bq == null) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "[saveVideo] info == null");
            return;
        }
        o.TU().a(eVar, Looper.getMainLooper());
        if (bq.Ui()) {
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete online video");
            t.nJ(auVar.field_imgPath);
            return;
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete offline video");
        t.Z(auVar.field_imgPath, 10);
        t.nB(auVar.field_imgPath);
    }

    static /* synthetic */ void a(e eVar, final au auVar, com.tencent.mm.aq.e eVar2) {
        String str = "MicroMsg.MediaHistoryGalleryPresenter";
        String str2 = "[downloadImg] %s %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(auVar == null);
        objArr[1] = Boolean.valueOf(eVar2 == null);
        x.e(str, str2, objArr);
        if (auVar != null) {
            if (auVar.getType() == 268435505) {
                l.a(auVar, new l$a(eVar) {
                    final /* synthetic */ e yHA;

                    public final void ev(int i, int i2) {
                        if (i == i2) {
                            x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", new Object[]{Long.valueOf(auVar.field_msgId)});
                            this.yHA.yHy = this.yHA.yHy - 1;
                            if (!com.tencent.mm.ui.chatting.gallery.b.b(this.yHA.mContext, auVar, false)) {
                                this.yHA.yHz = true;
                            }
                            if (!this.yHA.cvs()) {
                                return;
                            }
                            if (this.yHA.yHz) {
                                this.yHA.mHandler.post(new 2(this));
                            } else {
                                this.yHA.mHandler.post(new 1(this));
                            }
                        }
                    }
                });
            } else if (eVar2 != null && com.tencent.mm.aq.o.Px().a(eVar2.hzP, auVar.field_msgId, 0, Integer.valueOf(-1), -1, eVar, 0) == -2) {
                x.w("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] this img has download! %s", new Object[]{eVar2.hzQ});
                eVar.yHy--;
                com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int b(e eVar, List list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (au auVar : list) {
            if (auVar.cjs()) {
                i++;
            } else if (com.tencent.mm.ui.chatting.gallery.b.aX(auVar)) {
                String c;
                r bq = i.bq(auVar);
                if (bq != null) {
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", new Object[]{Integer.valueOf(bq.status)});
                    c = c(auVar, bq);
                } else {
                    c = null;
                }
                r0 = (bq == null || bq.status == bc.CTRL_INDEX || !FileOp.bO(c)) ? i + 1 : i;
                i = r0;
            } else {
                com.tencent.mm.aq.e bl = d.bl(auVar);
                if (bl != null) {
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", new Object[]{Integer.valueOf(bl.status)});
                }
                if (auVar.getType() == 268435505) {
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] is appmsg! null?%s,exists:%s", new Object[]{Boolean.valueOf(bh.ov(com.tencent.mm.ui.chatting.gallery.b.bg(auVar))), Boolean.valueOf(new File(bh.az(com.tencent.mm.ui.chatting.gallery.b.bg(auVar), "")).exists())});
                } else {
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] null?%s,exists:%s", new Object[]{Boolean.valueOf(bh.ov(bl != null ? d.d(auVar, bl) : null)), Boolean.valueOf(new File(bh.az(bl != null ? d.d(auVar, bl) : null, "")).exists())});
                    if (bl != null) {
                        if (bl.status != -1) {
                        }
                    }
                }
                r0 = i + 1;
                i = r0;
            }
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] count:%s size:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(list.size())});
        return i;
    }

    static /* synthetic */ LinkedList c(e eVar, List list) {
        LinkedList linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aW(auVar)) {
                if (d.bl(auVar).Pd()) {
                    eVar.yHy--;
                    com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            } else if (auVar.getType() == 268435505) {
                if (bh.ov(com.tencent.mm.ui.chatting.gallery.b.bg(auVar)) || !new File(com.tencent.mm.ui.chatting.gallery.b.bg(auVar)).exists()) {
                    linkedList.add(auVar);
                } else {
                    eVar.yHy--;
                    com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
                }
            }
        }
        return linkedList;
    }

    static /* synthetic */ LinkedList d(e eVar, List list) {
        LinkedList linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aX(auVar)) {
                if (i.bq(auVar).Uj()) {
                    eVar.yHy--;
                    com.tencent.mm.ui.chatting.gallery.b.a(eVar.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            }
        }
        return linkedList;
    }

    public final /* synthetic */ void a(com.tencent.mm.ui.chatting.h.a aVar) {
        this.yHu = (com.tencent.mm.ui.chatting.c.a.b) aVar;
        this.yHu.a(this);
        this.yAr.ceO();
        g.a.cuF().a(this);
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a cug() {
        return this.yHv;
    }

    public e(Context context) {
        this.mContext = context;
        this.jRt = new ArrayList();
    }

    public final void onDetach() {
        this.yAr.dead();
        this.yHu.a(null);
        this.yHu = null;
        com.tencent.mm.aq.o.Px().a((a) this);
        o.TU().a(this);
        g.a.cuF().detach();
    }

    public final <T extends h> T fM(Context context) {
        if (this.yHw == null) {
            this.yHw = new GridLayoutManager(context, 4);
            this.yHw.RB = new 1(this);
        }
        return this.yHw;
    }

    public final RecyclerView.g fN(Context context) {
        return new 8(this, context);
    }

    public final RecyclerView.a as(String str, long j) {
        this.jRw = str;
        this.yyg = j;
        if (j == -1) {
            this.yHv = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jRt, str);
        } else {
            this.yHv = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jRt, str, j);
        }
        this.yHv.yyi = new 10(this);
        return this.yHv;
    }

    public final String WW() {
        return this.mContext.getString(R.l.dDC);
    }

    public final void FG(int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[]{Integer.valueOf(i)});
        List<au> list = g.a.cuF().yDd;
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.a(219, 19, 1, true);
                j.a(this.mContext, list, this.jRw.toLowerCase().endsWith("@chatroom"), this.jRw, new ac(this) {
                    final /* synthetic */ e yHA;

                    {
                        this.yHA = r1;
                    }

                    public final void crT() {
                    }

                    public final void a(ac.a aVar) {
                    }

                    public final void b(ac.a aVar) {
                    }

                    public final boolean crU() {
                        return true;
                    }
                });
                this.yHu.cuj();
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.a(219, 18, 1, true);
                cf cfVar = new cf();
                if (com.tencent.mm.pluginsdk.model.h.a(this.mContext, cfVar, this.jRw, list, false, false)) {
                    b(cfVar);
                    dp(list);
                } else if (list.size() > 1) {
                    com.tencent.mm.ui.base.h.a(this.mContext, cfVar.fqp.fqv >= 0 ? this.mContext.getString(R.l.efu) : this.mContext.getString(R.l.eft), "", cfVar.fqp.fqv >= 0 ? this.mContext.getString(R.l.dUc) : this.mContext.getString(R.l.eAd), this.mContext.getString(R.l.dUa), new 4(this, cfVar, list), null);
                } else {
                    com.tencent.mm.ui.base.h.h(this.mContext, cfVar.fqp.fqv, 0);
                }
                this.yHu.cuj();
                return;
            case 2:
                do(list);
                return;
            case 3:
                this.yHu.cum();
                final List arrayList = new ArrayList();
                for (au auVar : list) {
                    if (!(com.tencent.mm.ui.chatting.gallery.b.aY(auVar) || com.tencent.mm.ui.chatting.gallery.b.aZ(auVar))) {
                        arrayList.add(auVar);
                    }
                }
                if (arrayList.size() != list.size()) {
                    com.tencent.mm.ui.base.h.a(this.mContext, R.l.elu, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ e yHA;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.yHA.dn(arrayList);
                        }
                    }, null);
                    return;
                } else {
                    dn(arrayList);
                    return;
                }
            default:
                return;
        }
    }

    public final int cuh() {
        return g.a.cuF().yDd.size();
    }

    public final void cui() {
        this.yHv.yyj = true;
        g.a.cuF().yEF = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) fM(this.mContext);
        int eZ = gridLayoutManager.eZ();
        this.yHv.b(eZ, (gridLayoutManager.fa() - eZ) + 1, Integer.valueOf(0));
    }

    public final void cuj() {
        this.yHv.yyj = false;
        g.a.cuF().clear();
        g.a.cuF().yEF = false;
        this.yHv.UR.notifyChanged();
    }

    public final boolean cuk() {
        return g.a.cuF().yEF;
    }

    public final void onResume() {
        if (this.yHx && g.a.cuF().yEF) {
            this.yHu.FH(g.a.cuF().yDd.size());
            this.yHv.UR.notifyChanged();
        }
    }

    public final void cuD() {
        this.yHx = true;
    }

    public final void clear() {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
        x.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[]{Integer.valueOf(this.yHy), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str});
        if (this.yHu.cuo()) {
            this.yHy--;
            ar.Hg();
            if (!com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, com.tencent.mm.z.c.Fa().dH(j2), false)) {
                this.yHz = true;
            }
            if (!cvs()) {
                return;
            }
            if (this.yHz) {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e yHA;

                    {
                        this.yHA = r1;
                    }

                    public final void run() {
                        if (this.yHA.yHu != null) {
                            this.yHA.yHu.FI(R.l.elD);
                        }
                    }
                });
            } else {
                this.mHandler.post(new 11(this));
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void cul() {
        com.tencent.mm.aq.o.Px().a((a) this);
        o.TU().a(this);
        this.yHu.cul();
    }

    public final void a(s.a.a aVar) {
        if (this.yHu.cuo()) {
            r nF = t.nF(aVar.fileName);
            x.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[]{Integer.valueOf(this.yHy), aVar.hVY, aVar.fileName});
            if (nF == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                cul();
                this.yHu.FI(0);
            } else if (nF.Uj()) {
                this.yHy--;
                ar.Hg();
                com.tencent.mm.ui.chatting.gallery.b.a(this.mContext, com.tencent.mm.z.c.Fa().dH((long) nF.hVI), false);
            }
            if (!cvs()) {
                return;
            }
            if (this.yHz) {
                this.mHandler.post(new 13(this));
            } else {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e yHA;

                    {
                        this.yHA = r1;
                    }

                    public final void run() {
                        if (this.yHA.yHu != null) {
                            this.yHA.yHu.cun();
                        }
                    }
                });
            }
        }
    }

    private void dn(List<au> list) {
        com.tencent.mm.sdk.f.e.post(new 2(this, list), "handleSave");
    }

    private boolean cvs() {
        return this.yHy == 0;
    }

    private static String c(au auVar, r rVar) {
        String Uf;
        if (rVar.hVO == -1) {
            Uf = rVar.Uf();
            if (com.tencent.mm.a.e.bO(Uf)) {
                return Uf;
            }
            o.TU();
            return s.nt(auVar.field_imgPath);
        }
        o.TU();
        Uf = s.nt(auVar.field_imgPath);
        if (auVar.field_isSend != 1 || rVar.hVR == null || !rVar.hVR.wwP) {
            return Uf;
        }
        try {
            String mg = FileOp.mg(Uf);
            if (!mg.endsWith("/")) {
                mg = mg + "/";
            }
            mg = mg + com.tencent.mm.a.e.bR(Uf) + "_hd.mp4";
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[]{mg, Boolean.valueOf(FileOp.bO(mg))});
            if (!FileOp.bO(mg)) {
                mg = Uf;
            }
            return mg;
        } catch (Exception e) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[]{e.getMessage()});
            return Uf;
        }
    }

    private void do(List<au> list) {
        com.tencent.mm.plugin.report.service.g.pQN.h(11627, new Object[]{Integer.valueOf(5)});
        Set treeSet = new TreeSet();
        for (au auVar : list) {
            treeSet.add(Long.valueOf(auVar.field_msgId));
        }
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.dTV), "", this.mContext.getString(R.l.dYt), this.mContext.getString(R.l.dEn), new 5(this, treeSet, list), null);
    }

    private static void dp(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(a$c.Fav, com.tencent.mm.ui.chatting.a.d.ypg, a, 0);
        }
    }

    private void b(cf cfVar) {
        cfVar.fqp.fqw = 45;
        cfVar.fqp.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        if (cfVar.fqq.ret != -2 && cfVar.fqq.ret <= 0 && cfVar.fqq.ret <= 0) {
            if (14 != cfVar.fqp.type) {
                x.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
            } else if (cfVar.fqp.fqs == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(11142, new Object[]{Integer.valueOf(cfVar.fqp.fqs.wfk), Integer.valueOf(cfVar.fqp.fqs.wfl), Integer.valueOf(cfVar.fqp.fqs.wfm), Integer.valueOf(cfVar.fqp.fqs.wfn), Integer.valueOf(cfVar.fqp.fqs.wfo), Integer.valueOf(cfVar.fqp.fqs.wfp), Integer.valueOf(cfVar.fqp.fqs.wfq), Integer.valueOf(cfVar.fqp.fqs.wfr), Integer.valueOf(cfVar.fqp.fqs.wfs), Integer.valueOf(cfVar.fqp.fqs.wft), Integer.valueOf(cfVar.fqp.fqs.wfu), Integer.valueOf(cfVar.fqp.fqs.wfv), Integer.valueOf(cfVar.fqp.fqs.wfw), Integer.valueOf(cfVar.fqp.fqs.wfx), Integer.valueOf(cfVar.fqp.fqs.wfy)});
            }
        }
    }

    public final void y(boolean z, int i) {
        if (z || this.mNk + this.yHq != this.jRt.size()) {
            this.yHv.yyh = true;
            this.yHu.mR(z);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dm().F(new 7(this, z, i));
            return;
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[]{Integer.valueOf(this.mNk), Integer.valueOf(i)});
    }
}

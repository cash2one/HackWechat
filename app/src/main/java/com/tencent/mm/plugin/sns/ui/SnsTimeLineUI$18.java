package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.a.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.plugin.sns.ui.bb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.vending.g.g;
import java.util.LinkedList;
import java.util.List;

class SnsTimeLineUI$18 implements a {
    final /* synthetic */ SnsTimeLineUI rIN;
    private int rIR = 0;
    private int rIS = 0;

    SnsTimeLineUI$18(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void bBJ() {
        SnsTimeLineUI.k(this.rIN).rRV.b(SnsTimeLineUI.p(this.rIN), SnsTimeLineUI.i(this.rIN), false, SnsTimeLineUI.q(this.rIN));
        x.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
        if (SnsTimeLineUI.r(this.rIN) == null) {
            x.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
        } else if (SnsTimeLineUI.g(this.rIN) != null) {
            SnsTimeLineUI.r(this.rIN).removeCallbacks(SnsTimeLineUI.s(this.rIN));
            SnsTimeLineUI.r(this.rIN).postDelayed(SnsTimeLineUI.s(this.rIN), 3000);
        }
    }

    public final ListView bBK() {
        if (SnsTimeLineUI.g(this.rIN).nKG == null) {
            SnsTimeLineUI.g(this.rIN).nKG = (ListView) this.rIN.findViewById(f.qFg);
        }
        return SnsTimeLineUI.g(this.rIN).nKG;
    }

    public final MMPullDownView bBL() {
        return (MMPullDownView) this.rIN.findViewById(f.qFn);
    }

    public final int getType() {
        return 1;
    }

    public final void a(int i, List<Integer> list, List<Integer> list2) {
        int i2 = 1;
        if (i > 0) {
            m xo = ae.bvv().xo(i);
            if (xo != null) {
                if (xo.field_pravited > 0) {
                    Toast.makeText(this.rIN, j.qKY, 1).show();
                }
                if (xo.field_pravited == 1) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            c.a(SnsTimeLineUI.h(this.rIN).nKG);
        }
        if (SnsTimeLineUI.a(this.rIN) != null) {
            SnsTimeLineUI.a(this.rIN).rJv.notifyVendingDataChange();
        }
    }

    public final boolean bBM() {
        return SnsTimeLineUI.t(this.rIN);
    }

    public final void bBN() {
        this.rIN.bzr();
        if (SnsTimeLineUI.l(this.rIN) != null) {
            x.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
            SnsTimeLineUI.l(this.rIN).setVisibility(0);
        }
        SnsTimeLineUI.k(this.rIN).rRU.b(SnsTimeLineUI.p(this.rIN), SnsTimeLineUI.i(this.rIN), SnsTimeLineUI.j(this.rIN), SnsTimeLineUI.q(this.rIN));
    }

    public final void bBO() {
        this.rIN.bzr();
    }

    public final void xM(int i) {
        int firstVisiblePosition = SnsTimeLineUI.h(this.rIN).nKG.getFirstVisiblePosition();
        int lastVisiblePosition = SnsTimeLineUI.h(this.rIN).nKG.getLastVisiblePosition();
        if (firstVisiblePosition != this.rIR || lastVisiblePosition != this.rIS) {
            com.tencent.mm.plugin.sns.h.a.a aVar;
            this.rIR = firstVisiblePosition;
            this.rIS = lastVisiblePosition;
            x.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i)});
            if (i == 2) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.u(this.rIN));
                SnsTimeLineUI.c(this.rIN, HardCoderJNI.startPerformance(HardCoderJNI.hcSNSScrollEnable, HardCoderJNI.hcSNSScrollDelay, HardCoderJNI.hcSNSScrollCPU, HardCoderJNI.hcSNSScrollIO, HardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, HardCoderJNI.hcSNSScrollTimeout, 701, HardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
                x.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[]{Integer.valueOf(SnsTimeLineUI.u(this.rIN))});
            }
            com.tencent.mm.plugin.sns.h.a f = SnsTimeLineUI.f(this.rIN);
            av avVar = SnsTimeLineUI.a(this.rIN).rJu;
            firstVisiblePosition = com.tencent.mm.modelsns.c.hOQ;
            if (firstVisiblePosition == 2) {
                aVar = null;
            } else if (firstVisiblePosition != 4 || f.raY) {
                long nanoTime = System.nanoTime();
                com.tencent.mm.plugin.sns.h.a.a aVar2 = new com.tencent.mm.plugin.sns.h.a.a();
                aVar2.raZ = System.currentTimeMillis();
                aVar2.mScreenHeight = f.mScreenHeight;
                aVar2.mScreenWidth = f.mScreenWidth;
                lastVisiblePosition = f.raX.getTop();
                firstVisiblePosition = f.raX.getHeight();
                if (lastVisiblePosition < 0) {
                    firstVisiblePosition += lastVisiblePosition;
                }
                aVar2.rbb = firstVisiblePosition;
                lastVisiblePosition = f.inm.getFirstVisiblePosition() - 1;
                int lastVisiblePosition2 = f.inm.getLastVisiblePosition() - 1;
                aVar2.rba = lastVisiblePosition;
                aVar2.mTL = lastVisiblePosition2;
                int count = avVar.getCount();
                boolean z = false;
                if (f.inm.getChildAt(0) != null) {
                    z = f.inm.getChildAt(0) instanceof SnsHeader;
                }
                x.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[]{Integer.valueOf(lastVisiblePosition), Integer.valueOf(lastVisiblePosition2), Boolean.valueOf(z)});
                firstVisiblePosition = z ? 1 : 0;
                int childCount = f.inm.getChildCount();
                int i2 = lastVisiblePosition;
                while (i2 <= lastVisiblePosition2) {
                    if (i2 < count && i2 >= 0) {
                        if (firstVisiblePosition >= childCount) {
                            x.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(childCount)});
                        } else {
                            int left;
                            int height;
                            int width;
                            if (aVar2.rbc == null) {
                                aVar2.rbc = new LinkedList();
                            }
                            b bVar = new b();
                            aVar2.rbc.add(bVar);
                            View childAt = f.inm.getChildAt(firstVisiblePosition);
                            lastVisiblePosition = firstVisiblePosition + 1;
                            if (childAt != null) {
                                firstVisiblePosition = childAt.getTop();
                                left = childAt.getLeft();
                                height = childAt.getHeight();
                                width = childAt.getWidth();
                                m xt = avVar.xt(i2);
                                bVar.rbh = i.g(xt);
                                bVar.rbf = xt.field_type;
                                bVar.rbg = xt.xl(32);
                                bVar.rbd = firstVisiblePosition;
                                bVar.rbe = left;
                                bVar.keJ = height;
                                bVar.keI = width;
                            }
                            if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof a$c))) {
                                a$c com_tencent_mm_plugin_sns_ui_a_a_c = (a$c) childAt.getTag();
                                if (com_tencent_mm_plugin_sns_ui_a_a_c.rOj && com_tencent_mm_plugin_sns_ui_a_a_c.rqG != null) {
                                    int top = com_tencent_mm_plugin_sns_ui_a_a_c.rqG.getTop();
                                    left = com_tencent_mm_plugin_sns_ui_a_a_c.rqG.getLeft();
                                    height = com_tencent_mm_plugin_sns_ui_a_a_c.rOb.getHeight();
                                    width = com_tencent_mm_plugin_sns_ui_a_a_c.rOb.getWidth();
                                    int top2 = com_tencent_mm_plugin_sns_ui_a_a_c.rOc.getTop() + top;
                                    int left2 = com_tencent_mm_plugin_sns_ui_a_a_c.rOc.getLeft() + left;
                                    int height2 = com_tencent_mm_plugin_sns_ui_a_a_c.rOc.getHeight();
                                    int width2 = com_tencent_mm_plugin_sns_ui_a_a_c.rOc.getWidth();
                                    x.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[]{Integer.valueOf(com_tencent_mm_plugin_sns_ui_a_a_c.position), Integer.valueOf(i2), Integer.valueOf(lastVisiblePosition)});
                                    if (com_tencent_mm_plugin_sns_ui_a_a_c.qOc.wMY != 0) {
                                        bVar.rbj = com_tencent_mm_plugin_sns_ui_a_a_c.qOc.wMY;
                                        bVar.rbk = top;
                                        bVar.rbl = left;
                                        bVar.rbm = width;
                                        bVar.rbn = height;
                                    }
                                    if (com_tencent_mm_plugin_sns_ui_a_a_c.qOc.wNb != 0) {
                                        bVar.rbi = com_tencent_mm_plugin_sns_ui_a_a_c.qOc.wNb;
                                        bVar.rbp = left2;
                                        bVar.rbo = top2;
                                        bVar.rbq = width2;
                                        bVar.rbr = height2;
                                    }
                                }
                            }
                            firstVisiblePosition = lastVisiblePosition;
                        }
                    }
                    i2++;
                }
                x.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
                aVar = aVar2;
            } else {
                aVar = null;
            }
            g.czW().c(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                final /* synthetic */ SnsTimeLineUI$18 rIU;

                public final /* synthetic */ Object call(Object obj) {
                    Void voidR = (Void) obj;
                    if (aVar != null) {
                        com.tencent.mm.plugin.sns.h.a.a aVar = aVar;
                        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(HardCoderJNI.SCENE_DB);
                        iu.hOG = aVar.raZ;
                        iu.ix(aVar.mScreenWidth).ix(aVar.mScreenHeight);
                        iu.ix(aVar.rbb);
                        iu.ix(0);
                        iu.ix(aVar.rba);
                        iu.ix(aVar.mTL);
                        iu.Sx();
                        if (aVar.rbc != null) {
                            for (b bVar : aVar.rbc) {
                                com.tencent.mm.modelsns.b iu2 = com.tencent.mm.modelsns.b.iu(502);
                                iu2.hOG = aVar.raZ;
                                iu2.mB(bVar.rbh).ix(bVar.rbf).bU(bVar.rbg).ix(bVar.rbe).ix(bVar.rbd).ix(bVar.keI).ix(bVar.keJ);
                                iu2.Sx();
                                x.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", new Object[]{Integer.valueOf(bVar.rbd), Integer.valueOf(bVar.rbe), Integer.valueOf(bVar.keI), Integer.valueOf(bVar.keJ)});
                                x.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", new Object[]{Integer.valueOf(bVar.rbk), Integer.valueOf(bVar.rbl), Integer.valueOf(bVar.rbn), Integer.valueOf(bVar.rbm)});
                                x.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", new Object[]{Integer.valueOf(bVar.rbo), Integer.valueOf(bVar.rbp), Integer.valueOf(bVar.rbr), Integer.valueOf(bVar.rbq)});
                                if (bVar.rbj != 0) {
                                    iu2 = com.tencent.mm.modelsns.b.iu(503);
                                    iu2.hOG = aVar.raZ;
                                    iu2.mB(bVar.rbh).ix(bVar.rbf).bU(bVar.rbg).ix(bVar.rbj).ix(bVar.rbl).ix(bVar.rbk).ix(bVar.rbm).ix(bVar.rbn);
                                    iu2.Sx();
                                }
                                if (bVar.rbi != 0) {
                                    iu2 = com.tencent.mm.modelsns.b.iu(504);
                                    iu2.hOG = aVar.raZ;
                                    iu2.mB(bVar.rbh).ix(bVar.rbf).bU(bVar.rbg).ix(bVar.rbi).ix(bVar.rbp).ix(bVar.rbo).ix(bVar.rbq).ix(bVar.rbr);
                                    iu2.Sx();
                                }
                            }
                        }
                        iu = com.tencent.mm.modelsns.b.iu(506);
                        iu.hOG = aVar.raZ;
                        iu.Sx();
                    }
                    return voidR;
                }
            });
        }
    }

    public final void L(int i, boolean z) {
        if (SnsTimeLineUI.a(this.rIN) != null) {
            SnsTimeLineUI.a(this.rIN).rJv.notifyVendingDataChange();
        }
        if (!z) {
            this.rIN.DW().K(com.tencent.mm.plugin.sns.j.c.b.class);
        }
    }

    public final void iL(boolean z) {
        SnsTimeLineUI snsTimeLineUI = this.rIN;
        snsTimeLineUI.rIw = z;
        af aNT = ae.aNT();
        com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
        com.tencent.mm.plugin.sns.model.b bvq = ae.bvq();
        if (z) {
            if (bvs.qSB || bvq.qSB) {
                aNT.removeCallbacks(snsTimeLineUI.rIx);
                aNT.removeCallbacks(snsTimeLineUI.rIy);
                aNT.postDelayed(snsTimeLineUI.rIx, 0);
            }
        } else if (!bvs.qSB || !bvq.qSB) {
            aNT.removeCallbacks(snsTimeLineUI.rIx);
            aNT.removeCallbacks(snsTimeLineUI.rIy);
            aNT.postDelayed(snsTimeLineUI.rIy, 0);
        }
    }
}

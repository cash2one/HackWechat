package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.plugin.sns.ui.a.e;
import com.tencent.mm.plugin.sns.ui.a.f;
import com.tencent.mm.plugin.sns.ui.a.g;
import com.tencent.mm.plugin.sns.ui.a.h;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class av implements y {
    public l contextMenuHelper;
    public MMActivity fmM;
    protected af handler = new af();
    private ListView inm;
    c jeX;
    public i kGt;
    public b qZo;
    c rAb = new 2(this);
    c rAc = new c<qj>(this) {
        final /* synthetic */ av rHD;

        {
            this.rHD = r2;
            this.xen = qj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qj qjVar = (qj) bVar;
            if (qjVar instanceof qj) {
                if (qjVar.fHW.type == 1) {
                    av.a(this.rHD, qjVar.fHW.id);
                } else if (qjVar.fHW.type == 2) {
                    av.b(this.rHD, qjVar.fHW.id);
                }
            }
            return false;
        }
    };
    c rAd = new 3(this);
    public OnClickListener rHA;
    public HashMap<String, Boolean> rHB;
    private c rHC;
    protected x rHo;
    public j rHp;
    protected LinkedList<SnsCommentPreloadTextView> rHq = new LinkedList();
    public HashMap<Integer, WeakReference<View>> rHr = new HashMap();
    View rHs;
    public int rHt = -1;
    int rHu = 0;
    protected HashMap<Integer, View> rHv = new HashMap();
    public HashMap<String, String> rHw = new HashMap();
    private HashMap<Integer, a> rHx = new HashMap();
    private HashMap<Integer, a.c> rHy;
    public OnClickListener rHz;
    protected int requestType = 0;
    public OnTouchListener rsO;
    protected HashMap<String, Integer> rsb = new HashMap();
    protected ScaleAnimation rzA;
    public ar rzG;
    private int rzJ = 0;
    public k rzL;
    public bg rzO;
    boolean rzb = false;
    protected ScaleAnimation rzz;

    static /* synthetic */ void a(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateStart, id: %s", new Object[]{str});
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            String byq = Ll.byq();
            if (avVar.rsb.containsKey(byq) && ((Integer) avVar.rsb.get(byq)).equals(Integer.valueOf(1))) {
                avVar.rsb.put(byq, Integer.valueOf(2));
            }
            ao.ca(str, 2);
            avVar.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void b(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", new Object[]{str});
        ao.ca(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void c(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", new Object[]{str});
        ao.ca(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void d(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", new Object[]{str});
        ao.ca(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void e(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", new Object[]{str});
        ao.cb(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void f(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", new Object[]{str});
        ao.cb(str, 2);
        avVar.notifyDataSetChanged();
    }

    public final void bBx() {
        this.rsb.clear();
    }

    public final u bBy() {
        if (this.fmM instanceof u) {
            return (u) this.fmM;
        }
        return null;
    }

    public final SnsCommentPreloadTextView bBz() {
        if (this.rHq.size() == 0) {
            return new SnsCommentPreloadTextView(this.fmM);
        }
        return (SnsCommentPreloadTextView) this.rHq.removeFirst();
    }

    public final void a(SnsCommentPreloadTextView snsCommentPreloadTextView) {
        this.rHq.add(snsCommentPreloadTextView);
    }

    public final boolean bBA() {
        if (this.rHq != null) {
            this.rHq.clear();
        }
        if (this.rHy != null) {
            this.rHy.clear();
        }
        if (this.rHx != null) {
            this.rHx.clear();
        }
        com.tencent.mm.pluginsdk.ui.d.i.clearCache();
        com.tencent.mm.kiss.widget.textview.c.gTj.Eb();
        return true;
    }

    public final void notifyDataSetChanged() {
        this.rHo.notifyDataSetChanged();
    }

    public final void bBB() {
        this.rHo.bzt();
    }

    public av(MMActivity mMActivity, ListView listView, b bVar, j jVar, int i, x xVar) {
        this.rHx.put(Integer.valueOf(6), new f());
        this.rHx.put(Integer.valueOf(2), new e());
        this.rHx.put(Integer.valueOf(3), new e());
        this.rHx.put(Integer.valueOf(4), new e());
        this.rHx.put(Integer.valueOf(5), new e());
        this.rHx.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.c());
        this.rHx.put(Integer.valueOf(1), new d());
        this.rHx.put(Integer.valueOf(7), new d());
        this.rHx.put(Integer.valueOf(8), new d());
        this.rHx.put(Integer.valueOf(9), new h());
        this.rHx.put(Integer.valueOf(11), new com.tencent.mm.plugin.sns.ui.a.b());
        this.rHx.put(Integer.valueOf(10), new d());
        this.rHy = new HashMap();
        this.rHy.put(Integer.valueOf(6), new f.a());
        this.rHy.put(Integer.valueOf(2), new e.a());
        this.rHy.put(Integer.valueOf(3), new e.a());
        this.rHy.put(Integer.valueOf(4), new e.a());
        this.rHy.put(Integer.valueOf(5), new e.a());
        this.rHy.put(Integer.valueOf(0), new e.a());
        this.rHy.put(Integer.valueOf(1), new e.a());
        this.rHy.put(Integer.valueOf(7), new e.a());
        this.rHy.put(Integer.valueOf(8), new e.a());
        this.rHy.put(Integer.valueOf(9), new e.a());
        this.rHy.put(Integer.valueOf(10), new e.a());
        this.rHy.put(Integer.valueOf(12), new a.c());
        this.rHz = new 4(this);
        this.rHA = new 5(this);
        this.rsO = bh.cgx();
        this.rHB = new HashMap();
        this.rHC = new c();
        this.jeX = new 9(this);
        this.rHo = xVar;
        this.rHp = jVar;
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.inm = listView;
        ae.bvs();
        this.fmM = mMActivity;
        this.qZo = bVar;
        this.contextMenuHelper = new l(mMActivity);
        this.kGt = new i(mMActivity);
        this.rzG = new ar(mMActivity, (byte) 0);
        this.rzz = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rzz.setDuration(150);
        this.rzA = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rzA.setDuration(150);
        this.rzL = new k(mMActivity, 0, jVar.rrt);
        this.requestType = 10;
        this.rzO = new bg(mMActivity, new 6(this, xVar), 0, jVar.rrt);
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
    }

    public final void bBC() {
        int firstVisiblePosition = this.inm.getFirstVisiblePosition() - this.inm.getHeaderViewsCount();
        int lastVisiblePosition = this.inm.getLastVisiblePosition() - this.inm.getHeaderViewsCount();
        x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.rHo.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            m xt = xt(i);
            View view = (View) this.rHv.get(Integer.valueOf(i));
            if (view == null || xt == null || view.getTag() == null) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
            } else {
                a.c cVar = (a.c) view.getTag();
                x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + cVar.position);
                cVar.rON.a(cVar, i, xt);
            }
            i++;
        }
    }

    public final View i(int i, View view) {
        a.c cVar;
        a aVar;
        m xt = this.rHo.xt(i);
        bnp bxV = xt.bxV();
        int d = d(bxV);
        if (view == null) {
            a cVar2;
            switch (d) {
                case 0:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.c();
                    break;
                case 1:
                    cVar2 = new d();
                    break;
                case 2:
                    cVar2 = new e();
                    break;
                case 3:
                    cVar2 = new e();
                    break;
                case 4:
                    cVar2 = new e();
                    break;
                case 5:
                    cVar2 = new e();
                    break;
                case 6:
                    cVar2 = new f();
                    break;
                case 7:
                    cVar2 = new d();
                    break;
                case 8:
                    cVar2 = new d();
                    break;
                case 9:
                    cVar2 = new h();
                    break;
                case 10:
                    cVar2 = new d();
                    break;
                case 11:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.b();
                    break;
                case 12:
                    cVar2 = new g();
                    break;
                default:
                    cVar2 = new d();
                    break;
            }
            a.c aVar2 = new e.a();
            aVar2.rON = cVar2;
            aVar2.rOK = bxV;
            view = cVar2.a(this.fmM, aVar2, d, this, xt);
            cVar = aVar2;
            aVar = cVar2;
        } else {
            a.c cVar3 = (a.c) view.getTag();
            aVar = cVar3.rON;
            cVar = cVar3;
        }
        aVar.iO(this.rzb);
        String bxW = xt.bxW();
        ArrayList arrayList = new ArrayList();
        if (ao.bvY().size() > 0) {
            for (String str : ao.bvY().keySet()) {
                if (str.startsWith(bxW)) {
                    ao.b bVar = (ao.b) ao.bvY().get(str);
                    if (ao.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        aVar.rNB = arrayList;
        aVar.a(cVar, i, xt, bxV, d, this);
        if (ao.cc(xt.bxW(), 2)) {
            ao.b Kr = ao.Kr(xt.bxW());
            if (xt.field_snsId == 0) {
                Kr = new ao.b();
            }
            if (Kr.hik) {
                if (Kr.hlj) {
                    a.e(cVar);
                    ao.cb(Kr.id, 2);
                } else {
                    String str2 = Kr.result;
                    String str3 = Kr.hqd;
                    if (!(cVar == null || cVar.rNL == null)) {
                        cVar.rNL.a(Kr, 1, str2, str3, Kr.qXA);
                        cVar.rNL.setVisibility(0);
                    }
                }
            } else if (!(cVar == null || cVar.rNL == null)) {
                cVar.rNL.xP(1);
                cVar.rNL.setVisibility(0);
            }
        } else {
            a.e(cVar);
        }
        this.rHv.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getItemViewType(int i) {
        return d(this.rHo.xt(i).bxV());
    }

    public final x bBD() {
        return this.rHo;
    }

    protected static int d(bnp com_tencent_mm_protocal_c_bnp) {
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 1) {
            int size = com_tencent_mm_protocal_c_bnp.wQo.vYd.size();
            if (size <= 1) {
                return 2;
            }
            if (size <= 3) {
                return 3;
            }
            if (size <= 6) {
                return 4;
            }
            return 5;
        }
        switch (com_tencent_mm_protocal_c_bnp.wQo.vYc) {
            case 1:
            case 8:
                return 3;
            case 2:
                return 6;
            case 4:
                return 0;
            case 5:
                return 1;
            case 7:
                return 2;
            case 14:
                return 7;
            case 15:
                if (com_tencent_mm_protocal_c_bnp.wQv == 1) {
                    return 1;
                }
                return 9;
            case 21:
                return 11;
            case 27:
                return 12;
            default:
                return 1;
        }
    }

    public static String Mc(String str) {
        if (bh.ov(str)) {
            return str;
        }
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    protected static String e(bnp com_tencent_mm_protocal_c_bnp) {
        return com.tencent.mm.plugin.sns.c.a.ift.A(com_tencent_mm_protocal_c_bnp.wQo.nfX, "timeline");
    }

    public static String a(bnp com_tencent_mm_protocal_c_bnp, Context context) {
        return com.tencent.mm.plugin.sns.c.a.ift.f(context, com_tencent_mm_protocal_c_bnp.wQn.nGJ, "timeline");
    }

    public static String Md(String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + str);
        return com.tencent.mm.plugin.sns.c.a.ift.A(str, "timeline");
    }

    public final void E(Runnable runnable) {
        this.rHo.bzt();
        runnable.run();
    }

    public final void cI(View view) {
        if (view.getTag() instanceof a.c) {
            x.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.rHs != null && this.rHs.getVisibility() == 0) {
                this.rHs.startAnimation(this.rzA);
                this.rzA.setAnimationListener(new 8(this));
            }
        }
    }

    public final m xt(int i) {
        return this.rHo.xt(i);
    }

    public final int getCount() {
        return this.rHo.getCount();
    }

    public final boolean xu(int i) {
        if (i < this.inm.getFirstVisiblePosition() - 1 || i > this.inm.getLastVisiblePosition() - 1) {
            return false;
        }
        return true;
    }
}

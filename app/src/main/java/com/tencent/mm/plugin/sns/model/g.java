package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.ak.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements f {
    private static int qTj = 0;
    private Map<Integer, WeakReference<Object>> hAz = new HashMap();
    public boolean qSB = true;
    private long qSM = 0;
    private long qSN = 0;
    z<String, n> qSO;
    private ak<String, WeakReference<Bitmap>> qSP;
    private Map<String, LinkedList<WeakReference<c>>> qSQ = new HashMap();
    private ConcurrentHashMap<Integer, String> qSR = new ConcurrentHashMap();
    private LinkedList<b> qSS = new LinkedList();
    private boolean qST = false;
    private HashSet<c> qSU = new HashSet();
    public HashMap<String, Integer> qSV = new HashMap();
    private int qSW = 4;
    public y qSX;
    public long qSY = 0;
    public long qSZ = 0;
    private int qTa = 0;
    private int qTb = 0;
    private HashMap<Long, Integer> qTc = new HashMap();
    private HashMap<Integer, Boolean> qTd = new HashMap();
    private HashMap<Integer, Boolean> qTe = new HashMap();
    private int qTf = 0;
    private int qTg = 0;
    private HashMap<Long, Integer> qTh = new HashMap();
    protected Set<String> qTi = new HashSet();

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ g qTk;
        final /* synthetic */ int qTl = 0;
        final /* synthetic */ String qTm;
        final /* synthetic */ n qTn;

        AnonymousClass2(g gVar, int i, String str, n nVar) {
            this.qTk = gVar;
            this.qTm = str;
            this.qTn = nVar;
        }

        public final void run() {
            this.qTk.a(this.qTl + "-" + this.qTm, this.qTn);
        }
    }

    class AnonymousClass9 implements Runnable {
        final /* synthetic */ aqr qSH;
        final /* synthetic */ g qTk;

        AnonymousClass9(g gVar, aqr com_tencent_mm_protocal_c_aqr) {
            this.qTk = gVar;
            this.qSH = com_tencent_mm_protocal_c_aqr;
        }

        public final void run() {
            g.a(this.qTk, 1, this.qSH);
        }
    }

    public enum a {
        ;

        static {
            qTt = 1;
            qTu = 2;
            qTv = new int[]{qTt, qTu};
        }
    }

    static /* synthetic */ boolean a(g gVar, int i, aqr com_tencent_mm_protocal_c_aqr) {
        if (gVar.qSB) {
            String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
            String g = i == 4 ? i.g(com_tencent_mm_protocal_c_aqr) : i == 5 ? i.h(com_tencent_mm_protocal_c_aqr) : i == 0 ? i.f(com_tencent_mm_protocal_c_aqr) : i.e(com_tencent_mm_protocal_c_aqr);
            String e = i.e(com_tencent_mm_protocal_c_aqr);
            if (!c.KM(com_tencent_mm_protocal_c_aqr.nGJ)) {
                long Wq = bh.Wq();
                boolean bO = FileOp.bO(r + e);
                if (!bO) {
                    bO = FileOp.bO(r + i.l(com_tencent_mm_protocal_c_aqr));
                }
                if (!bO) {
                    FileOp.bO(r + i.m(com_tencent_mm_protocal_c_aqr));
                }
                Wq = bh.bA(Wq);
                if (Wq > 100) {
                    x.i("MicroMsg.LazyerImageLoader2", "fileexist check  endtime " + Wq + " " + Thread.currentThread().getName() + " " + e.bnD + " " + ae.bvJ() + " " + com_tencent_mm_protocal_c_aqr.nGJ);
                }
                if (bh.bA(gVar.qSM) > 60000) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11696, new Object[]{Integer.valueOf(1), Long.valueOf(Wq), Integer.valueOf(0), Thread.currentThread().getName(), ae.bvJ(), e.bnD});
                    gVar.qSM = bh.Wq();
                }
                if (FileOp.bO(r + e) || FileOp.bO(r + i.l(com_tencent_mm_protocal_c_aqr)) || FileOp.bO(r + i.m(com_tencent_mm_protocal_c_aqr))) {
                    ae.aNT().post(new 6(gVar, i, com_tencent_mm_protocal_c_aqr, r, g));
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        if (gVar.qSU == null || gVar.qSU.size() == 0) {
            return true;
        }
        for (Integer intValue : gVar.hAz.keySet()) {
            int intValue2 = intValue.intValue();
            if (((WeakReference) gVar.hAz.get(Integer.valueOf(intValue2))).get() == null) {
                Iterator it = gVar.qSU.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.code == intValue2) {
                        gVar.qSU.remove(cVar);
                        x.d("MicroMsg.LazyerImageLoader2", "remove code ok rCode: " + intValue2);
                        break;
                    }
                }
            }
        }
        Iterator it2 = gVar.qSU.iterator();
        while (it2.hasNext()) {
            cVar = (c) it2.next();
            if (str != null && str.equals(cVar.id)) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ int buL() {
        int i = qTj;
        qTj = i + 1;
        return i;
    }

    static /* synthetic */ int buN() {
        int i = qTj;
        qTj = i - 1;
        return i;
    }

    public final void start() {
        this.qSB = true;
        buK();
        b bvq = ae.bvq();
        bvq.qSB = true;
        bvq.OW();
    }

    public final void pause() {
        this.qSB = false;
        b bvq = ae.bvq();
        bvq.qSB = false;
        LinkedList linkedList = new LinkedList();
        Iterator it = bvq.gBH.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) it.next();
            if (fVar.requestType != 6) {
                bvq.qSE.remove(fVar.aAM);
                linkedList.add(fVar);
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            bvq.gBH.remove((com.tencent.mm.plugin.sns.data.f) it2.next());
        }
    }

    public g() {
        int i;
        x.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[]{Integer.valueOf(((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass())});
        if (((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            i = 10485760;
        } else {
            i = 5242880;
        }
        this.qSO = new 1(this, i);
        this.qSP = new ak(this.qSW, new 3(this));
    }

    public final void buJ() {
        if (this.qSO != null) {
            this.hAz.clear();
            this.qSP.qWZ.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.qSO.putCount() + ";");
            stringBuffer.append("missCount:" + this.qSO.missCount() + ";");
            stringBuffer.append("hitCount:" + this.qSO.hitCount() + ";");
            stringBuffer.append("createCount:" + this.qSO.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.qSO.evictionCount() + ";");
            x.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.qSO.trimToSize(-1);
        }
        this.qSP.bvS();
        System.gc();
    }

    public final Bitmap a(aqr com_tencent_mm_protocal_c_aqr, View view, int i, an anVar, boolean z) {
        return a(com_tencent_mm_protocal_c_aqr, view, i, true, anVar, z);
    }

    private boolean E(View view, int i) {
        if (view.hashCode() == i) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!E(viewGroup.getChildAt(childCount), i));
            return true;
        }
        return false;
    }

    public final void K(Activity activity) {
        x.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.hAz.size());
        List<Integer> linkedList = new LinkedList();
        Iterator it = this.qSU.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (E(activity.getWindow().getDecorView(), cVar.code)) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.hAz.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.qSU.iterator();
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.code == intValue2) {
                    this.qSU.remove(cVar);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.qSU.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.qTx == activity.hashCode()) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.hAz.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.qSU.iterator();
            while (it3.hasNext()) {
                cVar = (c) it3.next();
                if (cVar.code == intValue4) {
                    this.qSU.remove(cVar);
                    break;
                }
            }
        }
        this.qSP.bvS();
        x.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.hAz.size());
    }

    public final void cu(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
        }
    }

    public final Bitmap b(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return null;
        }
        String aD = i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ);
        String str = com_tencent_mm_protocal_c_aqr.nGJ;
        n JZ = JZ(aD);
        if (i.b(JZ)) {
            return JZ.EC();
        }
        str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
        str = str + i.e(com_tencent_mm_protocal_c_aqr);
        if (!FileOp.bO(str)) {
            return null;
        }
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_extend_pic")) {
            JZ = n.i(r.LD(str));
        } else {
            JZ = i.JM(str);
        }
        if (!i.b(JZ)) {
            return null;
        }
        a(aD, JZ);
        return JZ.EC();
    }

    public final String a(aqr com_tencent_mm_protocal_c_aqr) {
        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
        return r + i.e(com_tencent_mm_protocal_c_aqr);
    }

    public final void b(aqr com_tencent_mm_protocal_c_aqr, View view, int i, an anVar) {
        b(com_tencent_mm_protocal_c_aqr, view, -1, i, anVar);
    }

    public final void a(aqr com_tencent_mm_protocal_c_aqr, View view, int i, int i2, an anVar) {
        a(com_tencent_mm_protocal_c_aqr, view, -1, i, i2, anVar);
    }

    public final n JZ(String str) {
        n nVar = (n) this.qSO.get(str);
        if (nVar != null && !nVar.isRecycled()) {
            return nVar;
        }
        this.qSO.remove(str);
        return null;
    }

    public final void b(aqr com_tencent_mm_protocal_c_aqr, View view, int i, int i2, an anVar) {
        a(com_tencent_mm_protocal_c_aqr, view, i, i2, a.qTt, anVar);
    }

    public final void a(aqr com_tencent_mm_protocal_c_aqr, View view, int i, int i2, int i3, an anVar) {
        if (com_tencent_mm_protocal_c_aqr != null && com_tencent_mm_protocal_c_aqr.nGJ != null && !com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            view.setDrawingCacheEnabled(false);
            String aD = i.aD(0, com_tencent_mm_protocal_c_aqr.nGJ);
            a((Object) view, aD, i, i2, i3);
            String str = com_tencent_mm_protocal_c_aqr.nGJ;
            n JZ = JZ(aD);
            if (i.b(JZ)) {
                a((Object) view, aD, JZ);
                return;
            }
            if (i == -1) {
                cv(view);
            }
            if (!this.qTi.contains(aD)) {
                a(0, com_tencent_mm_protocal_c_aqr, anVar);
            }
        }
    }

    private static void a(Object obj, String str, n nVar) {
        long j = 0;
        if (obj != null) {
            if (nVar != null) {
                x.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[]{obj, str, nVar.EG()});
            }
            Drawable drawable;
            if (obj instanceof QFadeImageView) {
                long j2;
                QFadeImageView qFadeImageView = (QFadeImageView) obj;
                drawable = qFadeImageView.mDrawable;
                if (!bh.ov(qFadeImageView.aAM) && qFadeImageView.aAM.equals(str)) {
                    j = qFadeImageView.mUW;
                }
                if (drawable == null || !(drawable instanceof ah)) {
                    j2 = j;
                } else {
                    j2 = ((ah) drawable).mUW;
                }
                Drawable ahVar = new ah(str, nVar, j2);
                qFadeImageView.mUW = ahVar.mUW;
                qFadeImageView.aAM = str;
                qFadeImageView.setImageDrawable(ahVar);
                ahVar.invalidateSelf();
            } else if (obj instanceof QDisFadeImageView) {
                QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
                drawable = new com.tencent.mm.memory.a.a(str, nVar);
                qDisFadeImageView.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof ImageView) {
                ImageView imageView = (ImageView) obj;
                drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof ah)) {
                    drawable = new ah(str, nVar, 0);
                } else {
                    drawable = new ah(str, nVar, ((ah) drawable).mUW);
                }
                imageView.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                x.i("MicroMsg.LazyerImageLoader2", "update sight thumb " + str);
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.mDrawable;
                    if (drawable == null || !(drawable instanceof ah)) {
                        drawable = new ah(str, nVar, 0);
                    } else {
                        drawable = new ah(str, nVar, ((ah) drawable).mUW);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
        }
    }

    public static String r(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return null;
        }
        String str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.e(com_tencent_mm_protocal_c_aqr);
        if (FileOp.bO(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_aqr.wxE;
    }

    public static String s(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return null;
        }
        String str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.d(com_tencent_mm_protocal_c_aqr);
        if (FileOp.bO(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_aqr.nfX;
    }

    public final void a(aqr com_tencent_mm_protocal_c_aqr, View view, int i, an anVar) {
        c(com_tencent_mm_protocal_c_aqr, view, -1, i, anVar);
    }

    public final boolean a(m mVar, aqr com_tencent_mm_protocal_c_aqr, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, an anVar, boolean z) {
        return a(mVar, com_tencent_mm_protocal_c_aqr, aVar, -1, i, i2, anVar, z, false);
    }

    public final boolean a(m mVar, final aqr com_tencent_mm_protocal_c_aqr, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, int i3, an anVar, boolean z, boolean z2) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return false;
        }
        String aD = i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ);
        a((Object) aVar, aD, -1, i2);
        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
        String e = i.e(com_tencent_mm_protocal_c_aqr);
        if (!FileOp.bO(r + e)) {
            com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_aqr);
            eVar.qQR = 1;
            eVar.hKZ = com_tencent_mm_protocal_c_aqr.nGJ;
            ae.bvq().a(com_tencent_mm_protocal_c_aqr, com_tencent_mm_protocal_c_aqr.ktN == 6 ? 5 : 1, eVar, anVar);
        }
        String str = "";
        if (z) {
            if (!u(com_tencent_mm_protocal_c_aqr)) {
                str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                String j = i.j(com_tencent_mm_protocal_c_aqr);
                if (FileOp.bO(str + j)) {
                    str = str + j;
                } else if (FileOp.bO(str + i.p(com_tencent_mm_protocal_c_aqr)) && com_tencent_mm_protocal_c_aqr.nGJ != null && com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path")) {
                    str = str + i.p(com_tencent_mm_protocal_c_aqr);
                } else if (this.qSB) {
                    x.i("MicroMsg.LazyerImageLoader2", "push sight loader " + com_tencent_mm_protocal_c_aqr.nGJ + " url: " + com_tencent_mm_protocal_c_aqr.nfX);
                    if (!z) {
                        x.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
                    } else if (b(mVar, null) == 5) {
                        final an anVar2 = anVar;
                        ae.aNT().postDelayed(new Runnable(this) {
                            final /* synthetic */ g qTk;

                            public final void run() {
                                ae.bvq().a(com_tencent_mm_protocal_c_aqr, 4, null, anVar2);
                            }
                        }, 0);
                    }
                }
            }
            str = "";
        }
        x.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[]{aD, str, Boolean.valueOf(z)});
        if (bh.ov(str) || u(com_tencent_mm_protocal_c_aqr)) {
            x.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[]{str});
            aVar.aA(null, !this.qSB);
            str = com_tencent_mm_protocal_c_aqr.nGJ;
            n JZ = JZ(aD);
            x.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[]{Boolean.valueOf(i.b(JZ))});
            if (i.b(JZ)) {
                a((Object) aVar, aD, JZ);
                return true;
            }
            if ((aVar instanceof ImageView) || (aVar instanceof QFadeImageView)) {
                cv((View) aVar);
            } else if (aVar instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                aVar.aA(null, !this.qSB);
                aVar.cR(0);
                aVar.B(null);
            }
            if (this.qTi.contains(aD)) {
                return false;
            }
            a(1, com_tencent_mm_protocal_c_aqr, anVar);
            return false;
        }
        if (!str.equals(aVar.Ur())) {
            aVar.B(z2 ? BitmapFactory.decodeFile(r + e) : null);
        }
        aVar.aA(str, !this.qSB);
        aVar.cR(i3);
        return true;
    }

    public final void c(aqr com_tencent_mm_protocal_c_aqr, View view, int i, an anVar) {
        if (com_tencent_mm_protocal_c_aqr != null && com_tencent_mm_protocal_c_aqr.nGJ != null && !com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            String aD = i.aD(4, com_tencent_mm_protocal_c_aqr.nGJ);
            a((Object) view, aD, -1, i);
            String str = com_tencent_mm_protocal_c_aqr.nGJ;
            n JZ = JZ(aD);
            boolean b = i.b(JZ);
            x.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b);
            if (b) {
                a((Object) view, aD, JZ);
                return;
            }
            cv(view);
            if (!this.qTi.contains(aD)) {
                a(4, com_tencent_mm_protocal_c_aqr, anVar);
            }
        }
    }

    public final boolean c(aqr com_tencent_mm_protocal_c_aqr, View view, int i, int i2, an anVar) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return false;
        }
        String aD = i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ);
        a((Object) view, aD, i, i2);
        String str = com_tencent_mm_protocal_c_aqr.nGJ;
        n JZ = JZ(aD);
        boolean b = i.b(JZ);
        x.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b + aD);
        if (b) {
            a((Object) view, aD, JZ);
            return true;
        }
        if (i == -1) {
            cv(view);
        }
        if (this.qTi.contains(aD)) {
            return true;
        }
        a(1, com_tencent_mm_protocal_c_aqr, anVar);
        return false;
    }

    private static void cv(View view) {
        if (view instanceof QImageView) {
            ((QImageView) view).a(com.tencent.mm.ui.widget.QImageView.a.zwc);
            ((QImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.qyX);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.qyX);
        }
    }

    public final void a(Object obj, String str, int i, int i2) {
        a(obj, str, true, i, i2, -1, -1, a.qTt);
    }

    private void a(Object obj, String str, int i, int i2, int i3) {
        a(obj, str, true, i, i2, -1, -1, i3);
    }

    private void a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, int i5) {
        if (obj != null) {
            int hashCode = obj.hashCode();
            this.qSU.remove(new c(null, hashCode, 0, false));
            c cVar = new c(str, hashCode, i2, z);
            this.qSU.add(cVar);
            LinkedList linkedList = (LinkedList) this.qSQ.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.qSQ.put(str, linkedList);
            }
            linkedList.add(new WeakReference(cVar));
            String str2 = (String) ((View) obj).getTag(2130706432);
            if (str2 != null) {
                LinkedList linkedList2 = (LinkedList) this.qSQ.get(str2);
                if (linkedList2 != null) {
                    int i6 = 0;
                    while (i6 < linkedList2.size()) {
                        c cVar2 = (c) ((WeakReference) linkedList2.get(i6)).get();
                        if (cVar2 != null && cVar2.code == hashCode) {
                            break;
                        }
                        i6++;
                    }
                    i6 = -1;
                    if (i6 != -1) {
                        x.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[]{str2});
                        linkedList2.remove(i6);
                    }
                }
            }
            ((View) obj).setTag(2130706432, str);
            this.hAz.put(Integer.valueOf(hashCode), new WeakReference(obj));
            if (i != -1) {
                if (obj instanceof QFadeImageView) {
                    ((QFadeImageView) obj).setImageResource(i);
                } else if (obj instanceof ImageView) {
                    ((ImageView) obj).setImageDrawable(com.tencent.mm.bv.a.b(((ImageView) obj).getContext(), i));
                } else {
                    ((com.tencent.mm.plugin.sight.decode.a.a) obj).aA(null, !this.qSB);
                }
            }
            if (i5 == a.qTu && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
                l.bC((View) obj);
            } else if (str != null && str.startsWith(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                if ((obj instanceof ImageView) || (obj instanceof QFadeImageView)) {
                    l.k((View) obj, i3, i4);
                    x.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
                }
            }
        }
    }

    public final boolean cw(View view) {
        int hashCode = view.hashCode();
        Iterator it = this.qSU.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (hashCode == cVar.code) {
                this.qSU.remove(cVar);
                break;
            }
        }
        this.hAz.remove(Integer.valueOf(hashCode));
        return true;
    }

    private boolean buK() {
        if (this.qST) {
            x.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            return false;
        }
        ae.aNT().postDelayed(new 5(this), 0);
        return true;
    }

    private boolean a(final int i, final aqr com_tencent_mm_protocal_c_aqr, final an anVar) {
        if (!this.qSB) {
            return false;
        }
        ae.bvi().post(new Runnable(this) {
            final /* synthetic */ g qTk;

            public final void run() {
                if (!g.a(this.qTk, i, com_tencent_mm_protocal_c_aqr)) {
                    com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_aqr);
                    eVar.qQR = i;
                    eVar.hKZ = com_tencent_mm_protocal_c_aqr.nGJ;
                    ae.bvq().a(com_tencent_mm_protocal_c_aqr, com_tencent_mm_protocal_c_aqr.ktN == 6 ? 5 : 1, eVar, anVar);
                }
            }
        });
        return true;
    }

    public static boolean t(aqr com_tencent_mm_protocal_c_aqr) {
        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
        if (FileOp.bO(r + i.j(com_tencent_mm_protocal_c_aqr))) {
            return true;
        }
        if (FileOp.bO(r + i.p(com_tencent_mm_protocal_c_aqr)) && !bh.ov(com_tencent_mm_protocal_c_aqr.nGJ) && com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path")) {
            return true;
        }
        return false;
    }

    public final int k(m mVar) {
        return a(mVar, null);
    }

    public final int a(m mVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bh.bA(this.qSY) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            com.tencent.mm.modelcontrol.c.MR();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2, pInt3)) {
                this.qTa = 5;
            } else {
                this.qTa = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.qTb = pInt.value;
            this.qSY = bh.Wq();
        }
        if (this.qTb == 0 || mVar == null) {
            return this.qTa;
        }
        if (this.qTc.containsKey(Long.valueOf(mVar.field_snsId))) {
            return ((Integer) this.qTc.get(Long.valueOf(mVar.field_snsId))).intValue();
        }
        bkd com_tencent_mm_protocal_c_bkd = new bkd();
        try {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(mVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_bjv.wNn == null) {
                return this.qTa;
            }
            com_tencent_mm_protocal_c_bkd.aF(com_tencent_mm_protocal_c_bjv.wNn.wJD.oz);
            if (com_tencent_mm_protocal_c_bkd.wNC == null || com_tencent_mm_protocal_c_bkd.wNC.info == null) {
                return this.qTa;
            }
            String str = com_tencent_mm_protocal_c_bkd.wNC.info;
            int hashCode = str.hashCode();
            if (this.qTb == 1) {
                if (!this.qTe.containsKey(Integer.valueOf(hashCode))) {
                    this.qTe.put(Integer.valueOf(hashCode), Boolean.valueOf(bY(str, this.qTb)));
                }
                i = ((Boolean) this.qTe.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.qTd.containsKey(Integer.valueOf(hashCode))) {
                    this.qTd.put(Integer.valueOf(hashCode), Boolean.valueOf(bY(str, this.qTb)));
                }
                if (!((Boolean) this.qTd.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            x.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(mVar.field_snsId), Integer.valueOf(i)});
            this.qTc.put(Long.valueOf(mVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.qTa;
        }
    }

    public final int l(m mVar) {
        return b(mVar, null);
    }

    public final int b(m mVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bh.bA(this.qSZ) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            com.tencent.mm.modelcontrol.c.MR();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2)) {
                this.qTf = 5;
            } else {
                this.qTf = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
            }
            this.qTg = pInt.value;
            this.qSZ = bh.Wq();
        }
        if (this.qTg == 0 || mVar == null) {
            return this.qTf;
        }
        if (this.qTh.containsKey(Long.valueOf(mVar.field_snsId))) {
            return ((Integer) this.qTh.get(Long.valueOf(mVar.field_snsId))).intValue();
        }
        bkd com_tencent_mm_protocal_c_bkd = new bkd();
        try {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(mVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_bjv.wNn == null) {
                return this.qTf;
            }
            com_tencent_mm_protocal_c_bkd.aF(com_tencent_mm_protocal_c_bjv.wNn.wJD.oz);
            if (com_tencent_mm_protocal_c_bkd.wNC == null || com_tencent_mm_protocal_c_bkd.wNC.info == null) {
                return this.qTa;
            }
            String str = com_tencent_mm_protocal_c_bkd.wNC.info;
            int hashCode = str.hashCode();
            if (this.qTg == 1) {
                if (!this.qTe.containsKey(Integer.valueOf(hashCode))) {
                    this.qTe.put(Integer.valueOf(hashCode), Boolean.valueOf(bY(str, this.qTg)));
                }
                i = ((Boolean) this.qTe.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.qTd.containsKey(Integer.valueOf(hashCode))) {
                    this.qTd.put(Integer.valueOf(hashCode), Boolean.valueOf(bY(str, this.qTg)));
                }
                if (!((Boolean) this.qTd.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            x.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(mVar.field_snsId), Integer.valueOf(i)});
            this.qTh.put(Long.valueOf(mVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.qTf;
        }
    }

    private static boolean bY(String str, int i) {
        Map y = bi.y(str, "SightDownloadControl");
        if (y == null || y.isEmpty()) {
            return true;
        }
        return i == 1 ? bh.getInt((String) y.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1 : bh.getInt((String) y.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1;
    }

    public final boolean u(aqr com_tencent_mm_protocal_c_aqr) {
        if (!this.qSV.containsKey(com_tencent_mm_protocal_c_aqr.nGJ)) {
            return false;
        }
        if (((Integer) this.qSV.get(com_tencent_mm_protocal_c_aqr.nGJ)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean v(aqr com_tencent_mm_protocal_c_aqr) {
        if (this.qSV.containsKey(com_tencent_mm_protocal_c_aqr.nGJ)) {
            return ((Integer) this.qSV.get(com_tencent_mm_protocal_c_aqr.nGJ)).intValue() == 2;
        } else {
            return false;
        }
    }

    public final boolean w(aqr com_tencent_mm_protocal_c_aqr) {
        if (this.qSV.containsKey(com_tencent_mm_protocal_c_aqr.nGJ)) {
            return ((Integer) this.qSV.get(com_tencent_mm_protocal_c_aqr.nGJ)).intValue() == 3;
        } else {
            return false;
        }
    }

    public final boolean x(aqr com_tencent_mm_protocal_c_aqr) {
        if (this.qSV.containsKey(com_tencent_mm_protocal_c_aqr.nGJ)) {
            return ((Integer) this.qSV.get(com_tencent_mm_protocal_c_aqr.nGJ)).intValue() == 4;
        } else {
            return false;
        }
    }

    public final void y(aqr com_tencent_mm_protocal_c_aqr) {
        this.qSV.put(com_tencent_mm_protocal_c_aqr.nGJ, Integer.valueOf(1));
    }

    public final void z(aqr com_tencent_mm_protocal_c_aqr) {
        this.qSV.put(com_tencent_mm_protocal_c_aqr.nGJ, Integer.valueOf(2));
    }

    public final void A(aqr com_tencent_mm_protocal_c_aqr) {
        this.qSV.put(com_tencent_mm_protocal_c_aqr.nGJ, Integer.valueOf(3));
    }

    public final boolean dZ(String str, String str2) {
        if (this.qSV.containsKey(str) && 3 == ((Integer) this.qSV.get(str)).intValue()) {
            this.qSV.remove(str);
        }
        String aD = i.aD(1, str);
        LinkedList linkedList = (LinkedList) this.qSQ.get(aD);
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && cVar.qTy && aD != null && aD.equals(cVar.id)) {
                WeakReference weakReference = (WeakReference) this.hAz.get(Integer.valueOf(cVar.code));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        x.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[]{str, str2});
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.bsE() instanceof ak) {
                            ak akVar = (ak) aVar.bsE();
                            if (akVar == null) {
                                aVar.aA(str2, !this.qSB);
                            } else if (FileOp.bO(str2)) {
                                aVar.aA(str2, !this.qSB);
                                aVar.cR(akVar.position);
                                akVar.rxi.setVisibility(8);
                                akVar.rkR.setVisibility(8);
                                akVar.rkU.setVisibility(8);
                                if (this.qSV.containsKey(str) && 4 == ((Integer) this.qSV.get(str)).intValue()) {
                                    this.qSV.remove(str);
                                }
                            } else {
                                this.qSV.put(str, Integer.valueOf(4));
                                akVar.rxi.setVisibility(8);
                                akVar.rkR.setImageResource(com.tencent.mm.plugin.sns.i.e.bGf);
                                akVar.rkR.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(String str, n nVar, int i) {
        a(i + "-" + str, nVar);
        return true;
    }

    private boolean a(String str, n nVar) {
        if (!(nVar == null || str == null)) {
            this.qSO.put(str, nVar);
        }
        return true;
    }

    public final void Ka(String str) {
        b(str, null);
    }

    public final n Kb(String str) {
        if (this.qSO == null) {
            return null;
        }
        return (n) this.qSO.get("0-" + str);
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, an anVar) {
        if (!z && bh.ov(str)) {
            return null;
        }
        aqr a = com.tencent.mm.modelsns.e.a(str3, 2, str2, str2, 1, 1, "");
        i.aD(2, str3);
        Bitmap JL;
        if (str3.equals("")) {
            JL = i.JL(str);
            if (i.m(JL)) {
                return JL;
            }
            return null;
        } else if (i.m(null)) {
            return null;
        } else {
            JL = i.JL(am.r(ae.getAccSnsPath(), str3) + i.l(a));
            if (!i.m(JL)) {
                JL = i.JL(str);
            }
            if (JL == null && z && !bh.ov(str2)) {
                ae.bvq().a(a, 3, null, anVar);
            }
            if (i.m(JL)) {
                return JL;
            }
            return null;
        }
    }

    public final boolean B(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return false;
        }
        if (FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.f(com_tencent_mm_protocal_c_aqr)) || FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.e(com_tencent_mm_protocal_c_aqr))) {
            return true;
        }
        return i.b((n) this.qSO.get(i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ)));
    }

    public static boolean a(aqr com_tencent_mm_protocal_c_aqr, an anVar, boolean z) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return false;
        }
        String str;
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path")) {
            str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.m(com_tencent_mm_protocal_c_aqr);
        } else {
            str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.d(com_tencent_mm_protocal_c_aqr);
        }
        if (FileOp.bO(str)) {
            return true;
        }
        ae.bvq().a(com_tencent_mm_protocal_c_aqr, z ? 8 : 2, null, anVar);
        return false;
    }

    public static String C(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr == null) {
            return null;
        }
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_sns_pic")) {
            return ae.getAccSnsTmpPath() + com_tencent_mm_protocal_c_aqr.nGJ;
        }
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path")) {
            return am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.m(com_tencent_mm_protocal_c_aqr);
        }
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_extend_pic")) {
            return com_tencent_mm_protocal_c_aqr.nGJ.substring(19);
        }
        return am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.d(com_tencent_mm_protocal_c_aqr);
    }

    public final Bitmap a(aqr com_tencent_mm_protocal_c_aqr, View view, int i, boolean z, an anVar, boolean z2) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return null;
        }
        String aD = i.aD(3, com_tencent_mm_protocal_c_aqr.nGJ);
        String C = C(com_tencent_mm_protocal_c_aqr);
        int i2 = -1;
        int i3 = -1;
        try {
            Options UL = d.UL(C);
            i2 = UL.outWidth;
            i3 = UL.outHeight;
        } catch (Exception e) {
        }
        a(view, aD, false, -1, i, i2, i3, a.qTt);
        b bvq = ae.bvq();
        String str = com_tencent_mm_protocal_c_aqr.nGJ;
        Object obj = (bvq.qSD.containsKey(i.aE(2, str)) || bvq.qSD.containsKey(i.aE(8, str))) ? 1 : null;
        if (obj != null) {
            return null;
        }
        ak akVar = this.qSP;
        b bVar = (b) akVar.qWZ.get(aD);
        if (bVar == null) {
            obj = null;
        } else {
            ((b) akVar.qWZ.get(aD)).bvT();
            obj = bVar.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        x.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + aD + "  " + (weakReference == null));
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (i.m(bitmap)) {
            return bitmap;
        }
        Bitmap LD;
        if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_extend_pic")) {
            LD = r.LD(C);
        } else {
            LD = i.JL(C);
        }
        ak akVar2 = this.qSP;
        WeakReference weakReference2 = new WeakReference(LD);
        if (((b) akVar2.qWZ.get(aD)) == null) {
            akVar2.qWZ.put(aD, new b(akVar2, weakReference2));
            akVar2.bvS();
        } else {
            ((b) akVar2.qWZ.get(aD)).bvT();
            ((b) akVar2.qWZ.get(aD)).obj = weakReference2;
        }
        if (i.m(LD)) {
            return LD;
        }
        if (z) {
            ae.bvq().a(com_tencent_mm_protocal_c_aqr, z2 ? 8 : 2, null, anVar);
        }
        return null;
    }

    public final n a(aqr com_tencent_mm_protocal_c_aqr, ImageView imageView, int i, an anVar) {
        if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String aD = i.aD(0, com_tencent_mm_protocal_c_aqr.nGJ);
        a((Object) imageView, aD, -1, i);
        String str = com_tencent_mm_protocal_c_aqr.nGJ;
        n JZ = JZ(aD);
        if (i.b(JZ)) {
            return JZ;
        }
        a(0, com_tencent_mm_protocal_c_aqr, anVar);
        return null;
    }

    public final void a(View view, int i, int i2, int i3) {
        a(view, null, true, -1, i3, -1, -1, a.qTt);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.bv.a.b(view.getContext(), i2));
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.qyX);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.qyX);
        }
    }

    public final void a(List<aqr> list, View view, int i, int i2, a aVar) {
        a((List) list, view, i, i2, (an) aVar, false);
    }

    public final void a(List<aqr> list, View view, int i, int i2, a aVar, boolean z) {
        if (list != null && list.size() != 0) {
            String aD;
            n JZ;
            if (list.size() != 1) {
                aD = i.aD(0, i.bJ(list));
                a(view, aD, true, -1, i, -1, -1, i2);
                JZ = JZ(aD);
                boolean b = i.b(JZ);
                x.v("MicroMsg.LazyerImageLoader2", "set Sns GridList " + b);
                if (b) {
                    a((Object) view, aD, JZ);
                    return;
                }
                cv(view);
                if (!this.qTi.contains(aD)) {
                    WeakReference weakReference = new WeakReference(view);
                    ae.bvi().post(new 4(this, list, 0, aVar));
                }
            } else if (z) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) list.get(0);
                int i3 = a.qTu;
                if (com_tencent_mm_protocal_c_aqr != null && com_tencent_mm_protocal_c_aqr.nGJ != null && !com_tencent_mm_protocal_c_aqr.nGJ.equals("")) {
                    view.setDrawingCacheEnabled(false);
                    aD = i.aD(5, com_tencent_mm_protocal_c_aqr.nGJ);
                    a((Object) view, aD, -1, i, i3);
                    String str = com_tencent_mm_protocal_c_aqr.nGJ;
                    JZ = JZ(aD);
                    if (i.b(JZ)) {
                        a((Object) view, aD, JZ);
                        return;
                    }
                    cv(view);
                    if (!this.qTi.contains(aD)) {
                        a(5, com_tencent_mm_protocal_c_aqr, (an) aVar);
                    }
                }
            } else {
                b((aqr) list.get(0), view, i, aVar);
            }
        }
    }

    protected final void b(String str, n nVar) {
        if (!i.b(nVar)) {
            n nVar2 = (n) this.qSO.get(str);
            if (nVar2 == null || nVar2.isRecycled()) {
                this.qSO.remove(str);
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (i.b(nVar)) {
            if (!(this.qSO == null || nVar == null || str == null)) {
                this.qSO.put(str, nVar);
            }
            LinkedList linkedList = (LinkedList) this.qSQ.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((WeakReference) it.next()).get();
                    if (cVar != null && cVar.qTy && str != null && str.equals(cVar.id)) {
                        WeakReference weakReference = (WeakReference) this.hAz.get(Integer.valueOf(cVar.code));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.qSX != null && (qFadeImageView instanceof TagImageView)) {
                                        int i = ((TagImageView) qFadeImageView).position;
                                        if (!(i == -1 || this.qSX.xu(i))) {
                                        }
                                    }
                                }
                                if (!i.b(nVar) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(nVar == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(i.b(nVar));
                                    x.d(str2, str3, objArr);
                                } else {
                                    a(obj, str, nVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void bug() {
        buJ();
        this.qSY = 0;
        this.qSZ = 0;
        this.qSS.clear();
        this.qST = false;
    }
}

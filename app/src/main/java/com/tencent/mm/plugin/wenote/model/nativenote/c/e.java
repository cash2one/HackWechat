package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.c.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements a {
    public static boolean mHasInit = false;
    public static volatile e tUO = null;
    public af mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public boolean tUP = true;
    public int tUQ = 0;
    public int tUR = 0;
    public int tUS = 14;
    public int tUT = 0;
    public int tUU = 0;
    public int tUV = 0;
    public int tUW = 0;
    public int tUX = 0;
    public int tUY = 0;
    public int tUZ = 0;
    public int[] tVa = null;
    public int[] tVb = null;
    public int[] tVc = null;
    public int[] tVd = null;
    public PopupWindow tVe = null;
    public PopupWindow tVf = null;
    public PopupWindow tVg = null;
    public PopupWindow tVh = null;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a tVi = null;
    public d tVj = null;
    public b tVk = null;
    public ak tVl = null;
    public ak tVm = null;
    public TextView tVn = null;
    public TextView tVo = null;
    public TextView tVp = null;
    public TextView tVq = null;
    public TextView tVr = null;
    public TextView tVs = null;
    public TextView tVt = null;
    public TextView tVu = null;

    static /* synthetic */ boolean a(e eVar, ArrayList arrayList, String str) {
        int bXe = eVar.bXe();
        if (bXe == 0) {
            return false;
        }
        int i;
        b bVar;
        StringBuilder stringBuilder = new StringBuilder(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (bVar != null) {
                    if (bVar.getType() != 1) {
                        i++;
                    } else {
                        stringBuilder.append(((h) bVar).content);
                    }
                }
            }
        } else {
            i = 0;
        }
        int QV = c.QV(stringBuilder.toString());
        if (bXe == 2 || bXe == 3) {
            bXe = eVar.tVj.hlq;
            while (bXe <= eVar.tVj.endPos) {
                int c;
                bVar = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bXe);
                if (bVar != null) {
                    if (bVar.getType() == 1) {
                        c = (bXe == eVar.tVj.hlq && bXe == eVar.tVj.endPos) ? c.c(((h) bVar).content, eVar.tVj.startOffset, eVar.tVj.tUN, false) + 0 : bXe == eVar.tVj.hlq ? c.c(((h) bVar).content, eVar.tVj.startOffset, -1, true) + 0 : bXe == eVar.tVj.endPos ? c.c(((h) bVar).content, 0, eVar.tVj.tUN, false) + 0 : c.QV(((h) bVar).content) + 0;
                        int i2 = i;
                        i = QV - c;
                        c = i2;
                    } else if (bVar.getType() != 1) {
                        c = i - 1;
                        i = QV;
                    }
                    bXe++;
                    QV = i;
                    i = c;
                }
                c = i;
                i = QV;
                bXe++;
                QV = i;
                i = c;
            }
        }
        return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().eq(QV, i);
    }

    static /* synthetic */ boolean l(e eVar) {
        if (eVar.bXe() == 3) {
            for (int i = eVar.tVj.hlq; i <= eVar.tVj.endPos; i++) {
                b Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(i);
                if (Bt != null && Bt.getType() == 4 && ((k) Bt).tRH.booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private e() {
        mHasInit = false;
    }

    public static e bXf() {
        if (tUO == null) {
            synchronized (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.class) {
                if (tUO == null) {
                    tUO = new e();
                }
            }
        }
        return tUO;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.tUP;
    }

    private RecyclerView bxG() {
        if (this.tVi != null) {
            return this.tVi.bWi();
        }
        return null;
    }

    private int bXg() {
        if (this.tVi != null) {
            return this.tVi.bWf() + this.tVi.bWg();
        }
        return 0;
    }

    public final int bXe() {
        if (!mHasInit) {
            return 0;
        }
        if (this.tVj == null) {
            this.tVj = new d();
        }
        return this.tVj.bXe();
    }

    public final d bXh() {
        if (!mHasInit) {
            return new d();
        }
        if (this.tVj == null) {
            this.tVj = new d();
        }
        return new d(this.tVj.hlq, this.tVj.startOffset, this.tVj.endPos, this.tVj.tUN);
    }

    public final boolean t(int i, int i2, int i3, int i4) {
        if (!mHasInit) {
            return false;
        }
        boolean z;
        if (this.tVj == null) {
            this.tVj = new d(i, i2, i3, i4);
            z = true;
        } else if (this.tVj.hlq == i && this.tVj.startOffset == i2 && this.tVj.endPos == i3 && this.tVj.tUN == i4) {
            z = false;
        } else {
            this.tVj.set(i, i2, i3, i4);
            z = true;
        }
        if (z) {
            x.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.tVj.hlq), Integer.valueOf(this.tVj.startOffset), Integer.valueOf(this.tVj.endPos), Integer.valueOf(this.tVj.tUN));
        }
        return z;
    }

    public final int Bv(int i) {
        if (!mHasInit || this.tVj == null || bXe() == 0 || i < this.tVj.hlq || i > this.tVj.endPos) {
            return 0;
        }
        if (i == this.tVj.hlq && i == this.tVj.endPos) {
            return 1;
        }
        if (i > this.tVj.hlq && i < this.tVj.endPos) {
            return 2;
        }
        if (i == this.tVj.hlq && i < this.tVj.endPos) {
            return 4;
        }
        if (i <= this.tVj.hlq || i != this.tVj.endPos) {
            return 0;
        }
        return 3;
    }

    private void ac(int i, int i2, int i3) {
        if (mHasInit) {
            switch (i) {
                case 2:
                    if (this.tVb != null && this.tVb.length == 2) {
                        this.tVb[0] = i2;
                        this.tVb[1] = i3;
                        return;
                    }
                    return;
                case 3:
                    if (this.tVc != null && this.tVc.length == 2) {
                        this.tVc[0] = i2;
                        this.tVc[1] = i3;
                        return;
                    }
                    return;
                case 4:
                    if (this.tVd != null && this.tVd.length == 2) {
                        this.tVd[0] = i2;
                        this.tVd[1] = i3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean m(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void bXi() {
        if (this.tVi != null) {
            this.tVi.bWe();
        }
    }

    public final void bXj() {
        if (mHasInit) {
            t(-1, -1, -1, -1);
            g(true, 0);
            bXn();
            bXl();
        }
    }

    public final void N(boolean z, boolean z2) {
        if (mHasInit) {
            bXn();
            bXl();
            g(true, 50);
            kN(z);
            h(z2, 50);
        }
    }

    public final void g(final boolean z, long j) {
        if (mHasInit && this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ e tVw;

                public final void run() {
                    RecyclerView a = this.tVw.bxG();
                    if (a != null) {
                        for (int i = 0; i < a.getChildCount(); i++) {
                            View childAt = a.getChildAt(i);
                            c cW = f.cW(childAt);
                            if (cW != null) {
                                if (cW.tUK != null) {
                                    if (z) {
                                        cW.tUK.postInvalidate();
                                    }
                                } else if (!(cW.tUL == null || cW.tUM == null)) {
                                    this.tVw.a((LinearLayout) childAt.findViewById(R.h.cBU), (LinearLayout) childAt.findViewById(R.h.cBY), (LinearLayout) childAt.findViewById(R.h.cBW), cW.tUL.tTJ);
                                }
                            }
                        }
                    }
                }
            }, j);
        }
    }

    public final void a(View view, View view2, View view3, int i) {
        if (mHasInit && view != null && view2 != null && view3 != null && this.tVj != null) {
            switch (Bv(i)) {
                case 0:
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 1:
                    if (this.tVj.startOffset == this.tVj.tUN) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                    }
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 2:
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(0);
                    return;
                case 3:
                    if (this.tVj.tUN != 0) {
                        view.setVisibility(0);
                        view2.setVisibility(0);
                        view3.setVisibility(4);
                        return;
                    }
                    break;
                case 4:
                    if (this.tVj.startOffset == 0) {
                        view.setVisibility(0);
                        view2.setVisibility(4);
                        view3.setVisibility(0);
                        return;
                    }
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
            }
            view.setVisibility(8);
            view2.setVisibility(4);
            view3.setVisibility(4);
        }
    }

    public final boolean bXk() {
        return this.tVh != null && this.tVh.isShowing();
    }

    public final void bXl() {
        if (this.tVh != null) {
            this.tVh.dismiss();
        }
    }

    public final void h(final boolean z, long j) {
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ e tVw;

            public final void run() {
                this.tVw.kM(z);
            }
        }, 50);
    }

    public final void kM(boolean z) {
        if (mHasInit && this.tVh != null) {
            RecyclerView bxG = bxG();
            int bXe = bXe();
            if (bxG == null || bXe == 0 || ((bXe == 1 && !z) || (this.tVk != null && this.tVk.getType() == 1))) {
                bXl();
                return;
            }
            b Bt;
            boolean z2;
            boolean k;
            View view;
            int bWz;
            int bWA;
            b Bt2;
            boolean k2;
            View view2;
            boolean k3;
            View view3;
            boolean k4;
            View view4;
            boolean k5;
            View view5;
            int bXq;
            int i;
            int i2;
            int height;
            int height2;
            int height3;
            RecyclerView.h hVar;
            LinearLayoutManager linearLayoutManager;
            int eZ;
            int i3;
            boolean k6 = k(this.tVn, false);
            boolean k7 = k(this.tVo, false);
            View view6 = this.tVp;
            if (bXe() == 1) {
                Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(this.tVj.hlq);
                if (!(Bt == null || (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().size() <= 1 && Bt.getType() == 1 && bh.ov(((h) Bt).content)))) {
                    z2 = true;
                    k = k(view6, z2);
                    view = this.tVq;
                    bWz = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWz();
                    bWA = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWA();
                    Bt2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWz);
                    Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWA);
                    if (Bt2 != null || Bt == null) {
                        z2 = false;
                    } else {
                        if (this.tVj != null && this.tVj.hlq == bWz && this.tVj.startOffset == 0 && this.tVj.endPos == bWA) {
                            if (Bt.getType() == 1) {
                                Spanned QN = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(((h) Bt).content);
                                if (QN == null) {
                                    z2 = false;
                                } else if (this.tVj.tUN == QN.length()) {
                                    z2 = false;
                                }
                            } else if (Bt.getType() != 1 && this.tVj.tUN == 1) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    }
                    k2 = k(view, z2);
                    view2 = this.tVr;
                    if (this.tUP) {
                        z2 = false;
                    } else {
                        bXe = bXe();
                        z2 = (bXe != 0 || bXe == 1) ? false : this.tVi != null ? !this.tVi.bWh() : true;
                    }
                    k3 = k(view2, z2);
                    view3 = this.tVs;
                    bXe = bXe();
                    z2 = this.tUP && (bXe == 2 || bXe == 3);
                    k4 = k(view3, z2);
                    view4 = this.tVt;
                    bXe = bXe();
                    z2 = bXe != 2 || bXe == 3;
                    k5 = k(view4, z2);
                    view5 = this.tVu;
                    z2 = (this.tUP || bXe() == 0) ? false : f.dU(ac.getContext()) != 1;
                    z2 = k6 || k7 || k || k2 || k3 || k4 || k5 || k(view5, z2);
                    if (z2) {
                        bXl();
                    }
                    bWA = C(bxG);
                    bXq = bXq();
                    if (this.tVh != null || this.tVh.getContentView() == null) {
                        bXe = 0;
                        i = 0;
                    } else {
                        this.tVh.getContentView().measure(0, 0);
                        i = (this.tUT * 2) + this.tVh.getContentView().getMeasuredHeight();
                        bXe = this.tVh.getContentView().getMeasuredWidth() + (this.tUT * 2);
                    }
                    bWz = i != 0 ? this.tUV : i;
                    if (bXe != 0) {
                        i = this.tUW;
                    } else {
                        i = bXe;
                    }
                    if (this.tVe == null && this.tVe.isShowing() && m(this.tVb)) {
                        i2 = this.tVb[1] - bWz;
                        height = (this.tVb[1] + this.tVe.getHeight()) - this.tUX;
                        if (i2 >= bWA && i2 <= bXq) {
                            bXe = this.tVb[0];
                            height = i2;
                        } else if (height < bWA || height > bXq) {
                            bXe = -1000;
                            height = -1;
                        } else {
                            bXe = this.tVb[0];
                        }
                    } else {
                        if (this.tVf != null && this.tVf.isShowing() && m(this.tVc)) {
                            i2 = this.tVc[1] - bWz;
                            height2 = (this.tVc[1] + this.tVf.getHeight()) - this.tUX;
                            if (i2 < bWA && i2 <= bXq) {
                                bXe = this.tVc[0];
                                height2 = this.tVd[1] - bWz;
                                height3 = (this.tVd[1] + this.tVg.getHeight()) - this.tUX;
                                if (i2 != -1) {
                                    bXe = this.tVd[0];
                                    height = height3;
                                } else {
                                    if (height2 < bWA) {
                                    }
                                    bXe = this.tVd[0];
                                    height = height3;
                                }
                            } else if (height2 >= bWA && height2 <= bXq) {
                                bXe = this.tVc[0];
                                i2 = height2;
                                if (this.tVg != null && this.tVg.isShowing() && m(this.tVd)) {
                                    height2 = this.tVd[1] - bWz;
                                    height3 = (this.tVd[1] + this.tVg.getHeight()) - this.tUX;
                                    if (i2 != -1) {
                                        if (height2 < bWA && height2 <= bXq) {
                                            bXe = this.tVd[0];
                                            height = height2;
                                        } else if (height3 >= bWA && height3 <= bXq) {
                                            bXe = this.tVd[0];
                                            height = height3;
                                        }
                                    } else if (i2 + bWz > this.tVd[1] && height3 >= bWA && height3 <= bXq) {
                                        bXe = this.tVd[0];
                                        height = height3;
                                    }
                                }
                                height = i2;
                            }
                        }
                        bXe = -1000;
                        i2 = -1;
                        height2 = this.tVd[1] - bWz;
                        height3 = (this.tVd[1] + this.tVg.getHeight()) - this.tUX;
                        if (i2 != -1) {
                            if (height2 < bWA) {
                            }
                            bXe = this.tVd[0];
                            height = height3;
                        } else {
                            bXe = this.tVd[0];
                            height = height3;
                        }
                    }
                    if (height == -1) {
                        hVar = bxG.TV;
                        if (hVar != null && (hVar instanceof LinearLayoutManager)) {
                            linearLayoutManager = (LinearLayoutManager) hVar;
                            eZ = linearLayoutManager.eZ();
                            bXe = linearLayoutManager.fa();
                            if (this.tVj.hlq <= eZ && this.tVj.endPos >= bXe) {
                                height = 300;
                                bXe = -1000;
                            }
                        }
                        bXe = -1000;
                    }
                    if (height == -1) {
                        bXl();
                        return;
                    }
                    eZ = this.mScreenWidth / 3;
                    i3 = (this.mScreenWidth * 2) / 3;
                    if (bXe != -1000 || (bXe >= eZ && bXe <= i3)) {
                        d(bxG, (this.mScreenWidth - i) / 2, height);
                        return;
                    } else if (bXe < eZ) {
                        d(bxG, this.tUU, height);
                        return;
                    } else {
                        d(bxG, (this.mScreenWidth - i) - this.tUU, height);
                        return;
                    }
                }
            }
            z2 = false;
            k = k(view6, z2);
            view = this.tVq;
            bWz = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWz();
            bWA = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWA();
            Bt2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWz);
            Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWA);
            if (Bt2 != null) {
            }
            z2 = false;
            k2 = k(view, z2);
            view2 = this.tVr;
            if (this.tUP) {
                bXe = bXe();
                if (bXe != 0) {
                }
            } else {
                z2 = false;
            }
            k3 = k(view2, z2);
            view3 = this.tVs;
            bXe = bXe();
            if (!this.tUP) {
            }
            k4 = k(view3, z2);
            view4 = this.tVt;
            bXe = bXe();
            if (bXe != 2) {
            }
            k5 = k(view4, z2);
            view5 = this.tVu;
            if (this.tUP) {
            }
            if (!k6) {
            }
            if (z2) {
                bWA = C(bxG);
                bXq = bXq();
                if (this.tVh != null) {
                }
                bXe = 0;
                i = 0;
                if (i != 0) {
                }
                if (bXe != 0) {
                    i = bXe;
                } else {
                    i = this.tUW;
                }
                if (this.tVe == null) {
                }
                i2 = this.tVc[1] - bWz;
                height2 = (this.tVc[1] + this.tVf.getHeight()) - this.tUX;
                if (i2 < bWA) {
                }
                bXe = this.tVc[0];
                i2 = height2;
                height2 = this.tVd[1] - bWz;
                height3 = (this.tVd[1] + this.tVg.getHeight()) - this.tUX;
                if (i2 != -1) {
                    bXe = this.tVd[0];
                    height = height3;
                    if (height == -1) {
                        hVar = bxG.TV;
                        linearLayoutManager = (LinearLayoutManager) hVar;
                        eZ = linearLayoutManager.eZ();
                        bXe = linearLayoutManager.fa();
                        height = 300;
                        bXe = -1000;
                    }
                    if (height == -1) {
                        eZ = this.mScreenWidth / 3;
                        i3 = (this.mScreenWidth * 2) / 3;
                        if (bXe != -1000) {
                        }
                        d(bxG, (this.mScreenWidth - i) / 2, height);
                        return;
                    }
                    bXl();
                    return;
                }
                if (height2 < bWA) {
                }
                bXe = this.tVd[0];
                height = height3;
                if (height == -1) {
                    hVar = bxG.TV;
                    linearLayoutManager = (LinearLayoutManager) hVar;
                    eZ = linearLayoutManager.eZ();
                    bXe = linearLayoutManager.fa();
                    height = 300;
                    bXe = -1000;
                }
                if (height == -1) {
                    bXl();
                    return;
                }
                eZ = this.mScreenWidth / 3;
                i3 = (this.mScreenWidth * 2) / 3;
                if (bXe != -1000) {
                }
                d(bxG, (this.mScreenWidth - i) / 2, height);
                return;
            }
            bXl();
        }
    }

    public final boolean bXm() {
        return this.tVe != null && this.tVe.isShowing();
    }

    public final void bXn() {
        if (mHasInit) {
            Bw(2);
            Bw(3);
            Bw(4);
        }
    }

    private boolean Bw(int i) {
        boolean z = true;
        if (this.tVk != null && this.tVk.kTK == i && this.tVk.getType() == 1) {
            return false;
        }
        if (i == 2 && this.tVe != null) {
            this.tVe.dismiss();
            ac(2, -1, -1);
        } else if (i == 3 && this.tVf != null) {
            this.tVf.dismiss();
            ac(3, -1, -1);
        } else if (i != 4 || this.tVg == null) {
            z = false;
        } else {
            this.tVg.dismiss();
            ac(4, -1, -1);
        }
        return z;
    }

    public final void kN(boolean z) {
        if (mHasInit) {
            RecyclerView bxG = bxG();
            int bXe = bXe();
            if (bxG == null || bXe == 0 || (bXe == 1 && !z)) {
                bXn();
                return;
            }
            View g = f.g(bxG, this.tVj.hlq);
            View g2 = f.g(bxG, this.tVj.endPos);
            if (bXe == 1) {
                Bw(3);
                Bw(4);
                a(2, bxG, g, this.tVj.startOffset);
                return;
            }
            Bw(2);
            a(3, bxG, g, this.tVj.startOffset);
            a(4, bxG, g2, this.tVj.tUN);
        }
    }

    private void a(int i, RecyclerView recyclerView, View view, int i2) {
        if (mHasInit && recyclerView != null) {
            c cW = f.cW(view);
            if (cW == null) {
                Bw(i);
                return;
            }
            WXRTEditText wXRTEditText;
            if (cW.tUK != null) {
                wXRTEditText = cW.tUK;
            } else {
                if (!(cW.tUL == null || cW.tUM == null)) {
                    if (i2 == 0) {
                        i2 = 0;
                        wXRTEditText = cW.tUL;
                    } else if (i2 == 1) {
                        i2 = 0;
                        wXRTEditText = cW.tUM;
                    }
                }
                wXRTEditText = null;
            }
            if (wXRTEditText == null) {
                Bw(i);
                return;
            }
            Editable text = wXRTEditText.getText();
            if (text == null || i2 < 0 || i2 > text.length()) {
                Bw(i);
                return;
            }
            Layout layout = wXRTEditText.getLayout();
            if (layout == null) {
                Bw(i);
                return;
            }
            boolean a;
            float primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) wXRTEditText.getPaddingLeft());
            float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i2)) + wXRTEditText.getPaddingTop());
            if (wXRTEditText.tTw != 0) {
                lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.tUQ);
                if (i == 3) {
                    primaryHorizontal += (float) this.tUZ;
                } else if (i == 4) {
                    primaryHorizontal -= (float) this.tUZ;
                }
            }
            int[] iArr = new int[2];
            wXRTEditText.getLocationOnScreen(iArr);
            switch (i) {
                case 2:
                    a = a(2, recyclerView, this.tVe, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.tUY)), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 3:
                    a = a(3, recyclerView, this.tVf, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.tVf.getWidth())), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 4:
                    a = a(4, recyclerView, this.tVg, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                    break;
                default:
                    a = false;
                    break;
            }
            if (!a) {
                Bw(i);
            }
        }
    }

    private boolean a(int i, RecyclerView recyclerView, PopupWindow popupWindow, int i2, int i3) {
        if (!mHasInit || recyclerView == null || popupWindow == null || i3 < C(recyclerView) || i3 > this.mScreenHeight - bXg()) {
            return false;
        }
        if (popupWindow.isShowing()) {
            popupWindow.update(i2, i3, -1, -1, false);
            ac(i, i2, i3);
        } else {
            popupWindow.showAtLocation(recyclerView, 0, i2, i3);
            ac(i, i2, i3);
        }
        if (i == 2) {
            if (this.tVm == null) {
                this.tVm = new ak(new ak.a(this) {
                    final /* synthetic */ e tVw;

                    {
                        this.tVw = r1;
                    }

                    public final boolean uF() {
                        if (this.tVw.bXe() == 1 && this.tVw.Bw(2)) {
                            this.tVw.bXl();
                        }
                        return true;
                    }
                }, false);
            } else {
                this.tVm.TG();
            }
            this.tVm.J(3000, 0);
        }
        return true;
    }

    private boolean d(RecyclerView recyclerView, int i, int i2) {
        if (!mHasInit || recyclerView == null || this.tVh == null || i2 < C(recyclerView) || i2 > this.mScreenHeight - bXg()) {
            return false;
        }
        if (this.tVh.isShowing()) {
            this.tVh.update(i, i2, -1, -1, false);
        } else {
            this.tVh.showAtLocation(recyclerView, 0, i, i2);
        }
        return true;
    }

    public final void a(int i, MotionEvent motionEvent) {
        if (mHasInit && this.mHandler != null) {
            if (this.tVk == null || this.tVk.getType() != 1 || this.tVk.kTK == i) {
                switch (motionEvent.getAction()) {
                    case 0:
                        bXo();
                        if (!bXk()) {
                            kM(true);
                        }
                        this.tVk.a(i, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                        return;
                    case 1:
                    case 3:
                        bXo();
                        this.mHandler.postDelayed(new Runnable(this) {
                            final /* synthetic */ e tVw;

                            {
                                this.tVw = r1;
                            }

                            public final void run() {
                                this.tVw.kN(true);
                                this.tVw.kM(true);
                            }
                        }, 200);
                        return;
                    case 2:
                        if (this.tVk != null && this.tVk.getType() == 1) {
                            this.tVk.tUC = motionEvent.getRawX();
                            this.tVk.tUD = motionEvent.getRawY();
                            kO(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void kO(boolean z) {
        if (mHasInit && this.tVe != null && this.tVf != null && this.tVg != null && this.tVj != null) {
            RecyclerView bxG = bxG();
            if (bxG != null && this.tVk != null && this.tVk.getType() == 1) {
                int i = this.tVk.kTK;
                if (i == 2 || i == 3 || i == 4) {
                    int i2;
                    boolean z2;
                    float f = this.tVk.tUC - this.tVk.iQK;
                    float f2 = ((float) (this.tUQ / 2)) + (this.tVk.tUD - this.tVk.iQL);
                    if (i == 2) {
                        f += (float) (this.tVe.getWidth() / 2);
                    } else if (i == 3) {
                        f += (float) this.tVf.getWidth();
                    }
                    bxG.getLocationOnScreen(this.tVa);
                    View j = bxG.j(f - ((float) this.tVa[0]), f2 - ((float) this.tVa[1]));
                    c cW = f.cW(j);
                    WXRTEditText wXRTEditText = null;
                    if (cW == null) {
                        i2 = 2;
                    } else if (cW.tUK != null) {
                        wXRTEditText = cW.tUK;
                        int[] iArr = new int[2];
                        wXRTEditText.getLocationOnScreen(iArr);
                        i2 = ad(i, wXRTEditText.tTJ, wXRTEditText.getOffsetForPosition(f - ((float) iArr[0]), f2 - ((float) iArr[1])));
                    } else if (cW.tUL == null || cW.tUM == null) {
                        i2 = 0;
                    } else {
                        WXRTEditText wXRTEditText2;
                        int ad;
                        if (i == 3) {
                            wXRTEditText2 = cW.tUL;
                            ad = ad(i, wXRTEditText2.tTJ, 0);
                            if (ad == 2 || ad == 3) {
                                a(i, bxG, this.tVf, (int) (this.tVk.tUC - this.tVk.iQK), (int) (this.tVk.tUD - this.tVk.iQL));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else if (i == 4) {
                            wXRTEditText2 = cW.tUM;
                            ad = ad(i, wXRTEditText2.tTJ, 1);
                            if (ad == 2 || ad == 3) {
                                a(i, bxG, this.tVg, (int) (this.tVk.tUC - this.tVk.iQK), (int) (this.tVk.tUD - this.tVk.iQL));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else {
                            int[] iArr2 = new int[2];
                            j.getLocationOnScreen(iArr2);
                            if (f <= ((float) (iArr2[0] + (j.getWidth() / 2)))) {
                                wXRTEditText2 = cW.tUL;
                                ad = ad(i, wXRTEditText2.tTJ, 0);
                            } else {
                                wXRTEditText2 = cW.tUM;
                                ad = ad(i, wXRTEditText2.tTJ, 1);
                            }
                            if (ad == 2 || ad == 3) {
                                a(i, bxG, this.tVe, (int) (this.tVk.tUC - this.tVk.iQK), (int) (this.tVk.tUD - this.tVk.iQL));
                            }
                        }
                        i2 = ad;
                        wXRTEditText = wXRTEditText2;
                    }
                    switch (i2) {
                        case 1:
                            z2 = false;
                            break;
                        case 2:
                            z2 = true;
                            break;
                        case 3:
                            Editable text = wXRTEditText.getText();
                            int bXe = bXe();
                            if (this.tUP && text != null && bXe == 1) {
                                if (!wXRTEditText.hasFocus()) {
                                    wXRTEditText.requestFocus();
                                }
                                if (wXRTEditText.tTw == 1 || wXRTEditText.tTw == 2) {
                                    wXRTEditText.tTM = true;
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.tTM = false;
                                } else if (this.tVj.startOffset <= text.length()) {
                                    wXRTEditText.tTM = true;
                                    wXRTEditText.setSelection(this.tVj.startOffset);
                                    wXRTEditText.tTM = false;
                                }
                            } else if (this.tUP && text != null && bXe == 2 && wXRTEditText.hasFocus()) {
                                if (wXRTEditText.tTw == 1 || wXRTEditText.tTw == 2) {
                                    wXRTEditText.tTM = true;
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.tTM = false;
                                } else if (this.tVj.startOffset <= text.length() && this.tVj.tUN <= text.length()) {
                                    wXRTEditText.tTM = true;
                                    wXRTEditText.setSelection(this.tVj.startOffset, this.tVj.tUN);
                                    wXRTEditText.tTM = false;
                                }
                            }
                            if (bXe == 3 || bXe == 0) {
                                bXi();
                            }
                            bXl();
                            g(true, 0);
                            if (i == 4) {
                                i2 = this.tVj.tUN;
                            } else {
                                i2 = this.tVj.startOffset;
                            }
                            a(i, bxG, j, i2);
                            z2 = true;
                            break;
                        default:
                            return;
                    }
                    if (!z2) {
                        bXp();
                    } else if (!z) {
                    } else {
                        if (this.tVk.tUD >= ((float) C(bxG)) && this.tVk.tUD <= ((float) bXq())) {
                            return;
                        }
                        if (this.tVl == null || this.tVl.cfK()) {
                            bXp();
                            this.tVl.J(100, 100);
                        }
                    }
                }
            }
        }
    }

    private int ad(int i, int i2, int i3) {
        if (!mHasInit) {
            return 0;
        }
        boolean t;
        switch (i) {
            case 2:
                t = t(i2, i3, i2, i3);
                break;
            case 3:
                if (this.tVj != null && i2 <= this.tVj.endPos && (i2 != this.tVj.endPos || i3 < this.tVj.tUN)) {
                    t = t(i2, i3, this.tVj.endPos, this.tVj.tUN);
                    break;
                }
                return 1;
                break;
            case 4:
                if (this.tVj != null && i2 >= this.tVj.hlq && (i2 != this.tVj.hlq || i3 > this.tVj.startOffset)) {
                    t = t(this.tVj.hlq, this.tVj.startOffset, i2, i3);
                    break;
                }
                return 1;
            default:
                return 0;
        }
        if (t) {
            return 3;
        }
        return 2;
    }

    private void bXo() {
        if (this.tVk == null) {
            this.tVk = new b();
        } else {
            this.tVk.reset();
        }
    }

    private void bXp() {
        if (this.tVl == null) {
            this.tVl = new ak(new 9(this), true);
        } else {
            this.tVl.TG();
        }
    }

    private int C(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 150;
        }
        recyclerView.getLocationOnScreen(this.tVa);
        if (m(this.tVa)) {
            return this.tVa[1];
        }
        return 150;
    }

    private int bXq() {
        int i = 0;
        if (this.tVi != null) {
            i = this.tVi.bWf();
        }
        if (i == 0 && this.tVi != null) {
            i = this.tVi.bWg();
        }
        if (i == 0) {
            i = 150;
        }
        return this.mScreenHeight - i;
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            textView.setTextSize(1, (float) i);
        }
    }

    private void bXr() {
        if (this.tVi != null) {
            this.tVi.bWd();
        }
    }

    public final void bXs() {
        x.i("NoteSelectManager", "deleteSelectedData");
        if (mHasInit) {
            bXl();
            int bXe = bXe();
            if (bXe == 2) {
                a(true, null, "");
                return;
            } else if (bXe == 3) {
                b(true, null, "");
                return;
            } else {
                x.e("NoteSelectManager", "deleteSelectedData: not in select");
                bXr();
                return;
            }
        }
        x.e("NoteSelectManager", "deleteSelectedData: not init");
    }

    private SpannableStringBuilder a(boolean z, ArrayList<b> arrayList, String str) {
        int i = 2;
        d bXh = bXh();
        bXj();
        int bXe = bXh.bXe();
        if (bXe == 1 || bXe == 2) {
            b Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bXh.hlq);
            if (Bt == null) {
                x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                return null;
            }
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (Bt.getType() != 1) {
                if (bXe == 1 && z) {
                    ArrayList arrayList2;
                    if (bXh.startOffset == 0) {
                        i = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = arrayList;
                    } else if (bh.ov(str)) {
                        return spannableStringBuilder2;
                    } else {
                        arrayList2 = new ArrayList();
                        h hVar = new h();
                        hVar.content = str;
                        hVar.tRt = false;
                        hVar.tRv = -1;
                        arrayList2.add(hVar);
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(arrayList2, i, bXh.hlq, bXh.startOffset, bXh.tUN);
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().er(bXh.hlq - 1, (arrayList2.size() + bXh.hlq) + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((h) Bt, bXh.startOffset, bXh.tUN, false, z, str, true);
                if (this.tVi != null) {
                    this.tVi.Bm(bXh.hlq);
                }
                if (z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWy();
                }
            } else {
                spannableStringBuilder = a((h) Bt, bXh.startOffset, bXh.tUN, false, false, "", true);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(arrayList, 0, bXh.hlq, bXh.startOffset, bXh.tUN);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().er(bXh.hlq, (bXh.hlq + arrayList.size()) + 1);
            }
            return spannableStringBuilder;
        }
        x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        return null;
    }

    private ArrayList<b> b(boolean z, ArrayList<b> arrayList, String str) {
        d bXh = bXh();
        bXj();
        List arrayList2 = new ArrayList();
        if (bXh.bXe() != 3) {
            x.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            return null;
        }
        int i = bXh.hlq;
        int i2 = bXh.endPos;
        int i3 = i;
        while (i2 >= bXh.hlq) {
            b Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(i2);
            if (Bt != null) {
                h hVar;
                Object a;
                h hVar2;
                if (i2 == bXh.endPos && Bt.getType() == 1) {
                    hVar = (h) Bt;
                    a = a(hVar, 0, bXh.tUN, false, z, "", false);
                    if (!bh.M(a)) {
                        hVar2 = new h();
                        hVar2.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar2.tRv = -1;
                        hVar2.tRt = false;
                        arrayList2.add(hVar2);
                    }
                    if (z && bh.ov(hVar.content)) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().V(i2, true);
                    }
                    i = i3;
                    i2--;
                    i3 = i;
                } else if (i2 == bXh.hlq && Bt.getType() == 1) {
                    hVar = (h) Bt;
                    a = a(hVar, bXh.startOffset, 0, true, z, "", false);
                    if (!bh.M(a)) {
                        hVar2 = new h();
                        hVar2.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar2.tRv = -1;
                        hVar2.tRt = false;
                        arrayList2.add(hVar2);
                    }
                    if (z && bh.ov(hVar.content)) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().V(i2, true);
                        i = i3;
                        i2--;
                        i3 = i;
                    } else {
                        i = i3 + 1;
                        i2--;
                        i3 = i;
                    }
                } else {
                    arrayList2.add(c.c(Bt));
                    if (z) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().V(i2, true);
                    }
                }
            }
            i = i3;
            i2--;
            i3 = i;
        }
        if (z) {
            i = i3 - 1;
            int i4 = i3 + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                b hVar3 = new h();
                if (str == null) {
                    str = "";
                }
                hVar3.content = str;
                hVar3.tRt = false;
                hVar3.tRv = -1;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(i3, hVar3);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(i3, arrayList);
                i4 = arrayList.size() + i3;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().er(i, i4);
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private static SpannableStringBuilder a(h hVar, int i, int i2, boolean z, boolean z2, String str, boolean z3) {
        SpannableStringBuilder spannableStringBuilder = null;
        if (hVar == null) {
            x.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
        } else {
            Spanned QN = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(hVar.content);
            if (QN == null) {
                x.e("NoteSelectManager", "processTextDataItem: spannedText is null");
            } else {
                int length;
                if (z) {
                    length = QN.length();
                } else {
                    length = i2;
                }
                if (str == null) {
                    str = "";
                }
                if (i < 0 || i > QN.length() || length < 0 || length > QN.length() || i > length) {
                    x.e("NoteSelectManager", "processTextDataItem: incorrect offset");
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) QN.subSequence(0, i);
                    spannableStringBuilder = (SpannableStringBuilder) QN.subSequence(i, length);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) QN.subSequence(length, QN.length());
                    if (z2) {
                        length = spannableStringBuilder2.length();
                        if (!bh.ov(str)) {
                            Spanned QN2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(str);
                            if (QN2 != null) {
                                length += QN2.length();
                            }
                        }
                        hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder2) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        hVar.tRt = true;
                        hVar.tRv = length;
                    } else {
                        hVar.tRt = false;
                        hVar.tRv = -1;
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    private static boolean k(View view, boolean z) {
        if (view == null) {
            return false;
        }
        if (z) {
            view.setVisibility(0);
            return true;
        }
        view.setVisibility(8);
        return false;
    }
}

package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.l;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements c {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static k tUd = null;
    private static DisplayMetrics tUe;
    public static int tUf = -1;
    private static int tUh = -1;
    public int MP;
    public long fqk = -1;
    public int jNd;
    private transient ArrayList<WXRTEditText> tUb = new ArrayList();
    public a tUc;
    private int tUg;
    public long tUi = -1;
    private String tUj = "";
    public b tUk = null;
    private boolean tUl = false;
    public int tUm = -1;
    public String tUn = null;
    public long tUo = -1;
    public int tUp = 0;
    public boolean tUq = false;
    private OnKeyListener tUr = new 1(this);
    public final ak tUs = new ak(new 2(this), true);

    public k(a aVar) {
        this.tUc = aVar;
        tUd = this;
        this.MP = e.ci(aVar.bXI());
        this.jNd = e.eb(aVar.bXI());
        int[] aT = j.aT(aVar.bXI());
        mScreenHeight = aT[1];
        mScreenWidth = aT[0];
        tUe = aVar.bXI().getResources().getDisplayMetrics();
        this.tUg = ((mScreenHeight - this.MP) - this.jNd) - ((int) aq(8.0f));
        this.tUj = c.bWp().bWw();
        m.tVN = 0.0f;
    }

    public final void o(WXRTEditText wXRTEditText) {
        if (wXRTEditText.tTw == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.bv.a.aa(wXRTEditText.getContext(), R.f.bvK));
        }
        b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.tTm = this;
        wXRTEditText.QR(null);
        wXRTEditText.setOnKeyListener(this.tUr);
    }

    public final WXRTEditText bWY() {
        c bWp = c.bWp();
        ArrayList arrayList = this.tUb;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (bWp) {
                if (bWp.jRt == null) {
                } else {
                    Iterator it = bWp.jRt.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
                        if (bVar.tRy != null) {
                            arrayList.add(bVar.tRy);
                        } else if (!(bVar.tRw == null || bVar.tRx == null)) {
                            arrayList.add(bVar.tRw);
                            arrayList.add(bVar.tRx);
                        }
                    }
                }
            }
        }
        if (this.tUb == null) {
            return null;
        }
        Iterator it2 = this.tUb.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                return wXRTEditText;
            }
        }
        return null;
    }

    public final void f(boolean z, long j) {
        this.tUc.bXJ().f(z, j);
    }

    public final void bWj() {
        this.tUc.bXJ().bWj();
        bXa();
    }

    public final void Bq(int i) {
        this.tUc.bXJ().P(i, 0);
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        synchronized (this) {
            if (z) {
                bXa();
            }
            this.tUc.bXJ().a(wXRTEditText, z, i);
        }
    }

    public final void a(WXRTEditText wXRTEditText, int i, int i2) {
        if (this.tUp == 2 && this.tUq && wXRTEditText != null) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            this.tUc.bXJ().ep(i, i2);
            if (wXRTEditText.tTw == 0) {
                Iterator it = u.tWn.iterator();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                while (it.hasNext()) {
                    boolean z5;
                    t tVar = (t) it.next();
                    if (tVar.q(wXRTEditText)) {
                        if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b) {
                            z4 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c) {
                            z3 = true;
                        } else if (tVar instanceof l) {
                            z2 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.j) {
                            z5 = true;
                            z = z5;
                        }
                    }
                    z5 = z;
                    z = z5;
                }
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            this.tUk.kH(z4);
            this.tUk.kI(z3);
            this.tUk.kJ(z2);
            this.tUk.kK(z);
        }
    }

    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i) {
        String a = wXRTEditText.a(i.tTX);
        com.tencent.mm.plugin.wenote.model.a.b Bt;
        if (wXRTEditText.tTw == 0) {
            Bt = c.bWp().Bt(wXRTEditText.bWO());
            if (Bt != null && Bt.getType() == 1) {
                int QW = spannable == null ? 0 : com.tencent.mm.plugin.wenote.b.c.QW(spannable.toString());
                int QW2 = spannable2 == null ? 0 : com.tencent.mm.plugin.wenote.b.c.QW(spannable2.toString());
                if (c.bWp().eq(QW2 - QW, 0)) {
                    this.tUc.bXJ().bVZ();
                    this.tUc.bXJ().Bm(wXRTEditText.bWO());
                    return;
                }
                c.bWp().bWs();
                ((h) Bt).tRv = i;
                ((h) Bt).content = a;
                ((h) Bt).tRt = true;
                Bt.tRz = false;
                c bWp = c.bWp();
                bWp.tSH = (QW2 - QW) + bWp.tSH;
                return;
            }
            return;
        }
        wXRTEditText.setText("");
        if (!bh.ov(a)) {
            String str;
            Bt = new h();
            if (a.equals("<br/>")) {
                str = "";
            } else {
                str = a;
            }
            Bt.content = str;
            int a2 = c.bWp().a(Bt, wXRTEditText, true, false, false);
            c.bWp().er(a2 - 1, a2 + 1);
        }
    }

    public static k bWZ() {
        return tUd;
    }

    public final void bWl() {
        this.tUc.bXJ().bVX();
    }

    public final void b(WXRTEditText wXRTEditText) {
        this.tUc.bXJ().a(wXRTEditText);
    }

    public static float aq(float f) {
        return TypedValue.applyDimension(1, f, tUe);
    }

    private synchronized void aW(String str, boolean z) {
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 19;
        fvVar.fvq.fqr = c.bWp().QP(str);
        if (fvVar.fvq.fqr == null) {
            x.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
        } else {
            fvVar.fvq.title = str;
            fvVar.fvq.fqk = this.fqk;
            fvVar.fvq.fvx = z ? 1 : 0;
            fvVar.fvq.desc = "fav_update_note_storage";
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            if (z) {
                this.tUm = fvVar.fvq.fvt.getIntExtra("fav_note_item_status", -1);
                this.tUn = fvVar.fvq.fvt.getStringExtra("fav_note_xml");
                this.tUo = fvVar.fvq.fvt.getLongExtra("fav_note_item_updatetime", -1);
            }
        }
    }

    private void bXa() {
        if (this.tUi < 0 && this.fqk > 0) {
            this.tUs.J(60000, 60000);
            this.tUi = bh.Wq();
            this.tUj = c.bWp().bWw();
        }
    }

    public final void bXb() {
        if (this.fqk > 0 && this.tUi > 0) {
            String bWw = c.bWp().bWw();
            if (!bWw.equals(this.tUj)) {
                this.tUj = bWw;
                if (this.tUl) {
                    aW(this.tUj, false);
                    return;
                }
                this.tUl = true;
                aW(this.tUj, true);
            }
        }
    }

    public final WXRTEditText bXc() {
        WXRTEditText bWY = bWY();
        if (bWY != null || this.tUb.size() <= 0) {
            return bWY;
        }
        return (WXRTEditText) this.tUb.get(this.tUb.size() - 1);
    }

    public final <V, C extends g<V>> void b(t<V, C> tVar, V v) {
        WXRTEditText bWY = bWY();
        if (bWY == null) {
            return;
        }
        if (bWY.tTw == 0) {
            int i = bWY.bWN().Ww;
            int length = bWY.getText().length();
            if ((v instanceof Boolean) && ((Boolean) v).booleanValue() && i == length) {
                bWY.bWP();
                bWY.getText().append("\n");
                bWY.bWQ();
                bWY.setSelection(i);
            }
            bWY.a(tVar, v);
            return;
        }
        bWY.tTI = true;
        bWY.tRD = tVar.bXt();
        bWY.getText().append("\n");
    }

    public static void bXd() {
        if (tUd != null) {
            tUd.tUc.bXJ().kG(true);
        }
    }
}

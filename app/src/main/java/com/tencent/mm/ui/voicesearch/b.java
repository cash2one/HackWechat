package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends o<x> implements e {
    private Context context;
    private LinkedList<bek> hdX = new LinkedList();
    public com.tencent.mm.ui.applet.b hvU = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ b zqE;

        {
            this.zqE = r1;
        }

        public final Bitmap kX(String str) {
            return com.tencent.mm.ad.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b hvV = null;
    private ProgressDialog iln = null;
    private List<String> kiU = null;
    private int showType = 1;
    public String yPI;
    public String[] ynf;
    private x zqA = null;
    private boolean zqB = true;
    public boolean zqC = false;
    private boolean zqD = false;
    public String zqy;
    private boolean zqz = false;

    protected static class a {
        public CheckBox iis;
        public TextView kEZ;
        public MaskLayout ldx;
        public TextView nJd;
        public TextView yUR;
        public ProgressBar zqG;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ar.Hg();
        Object WJ = c.EY().WJ(x.k(cursor));
        if (WJ != null) {
            return WJ;
        }
        x xVar = new x();
        xVar.b(cursor);
        ar.Hg();
        c.EY().O(xVar);
        return xVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return oh(i);
    }

    public b(Context context, int i) {
        super(context, new x());
        this.context = context;
        this.showType = i;
        this.zqA = new x();
        this.zqA.setUsername("_find_more_public_contact_");
        this.zqA.Ap();
        this.yPI = "@micromsg.with.all.biz.qq.com";
    }

    public final void dr(List<String> list) {
        ac(new 5(this, list));
    }

    public final void ny(boolean z) {
        this.zqC = z;
        if (z) {
            this.zqA.Ap();
        }
    }

    public final void detach() {
        if (this.hvU != null) {
            this.hvU.detach();
            this.hvU = null;
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        if (this.showType == 2) {
            return 2;
        }
        return GQ(i) ? 1 : 0;
    }

    protected final int aRF() {
        int i = 0;
        if (!this.zqz) {
            return 0;
        }
        if (!this.zqA.isHidden()) {
            i = this.hdX.size();
        }
        return i + 1;
    }

    public final bek GP(int i) {
        try {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.hdX.size() + "  " + (i - aCQ()));
            return (bek) this.hdX.get((i - aCQ()) - 1);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
            return null;
        }
    }

    public final x oh(int i) {
        if (qY(i)) {
            return (x) aRG();
        }
        return (x) super.getItem(i);
    }

    public final void nz(boolean z) {
        ac(new 6(this, z));
    }

    public final void aag(String str) {
        ac(new 7(this, str));
    }

    public final boolean GQ(int i) {
        if (this.zqz) {
            int aCQ = aCQ();
            if (i == aCQ && i < aCQ + aRF()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        if (!GQ(i) || ((this.hdX != null && this.hdX.size() != 0) || this.zqB)) {
            return true;
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean qY = qY(i);
        boolean GQ = GQ(i);
        a aVar;
        a aVar2;
        String gP;
        if (this.zqz && qY) {
            if (view != null) {
                aVar = (a) view.getTag();
                if (GQ && aVar.zqG == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar2 = (a) view.getTag();
            } else if (GQ) {
                view = View.inflate(this.context, R.i.deJ, null);
                aVar2 = new a();
                aVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
                aVar2.zqG = (ProgressBar) view.findViewById(R.h.cJT);
                view.setTag(aVar2);
            } else {
                view = View.inflate(this.context, R.i.deO, null);
                aVar2 = new a();
                aVar2.nJd = (TextView) view.findViewById(R.h.bYz);
                aVar2.ldx = (MaskLayout) view.findViewById(R.h.bYx);
                aVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
                aVar2.iis = (CheckBox) view.findViewById(R.h.bYC);
                aVar2.yUR = (TextView) view.findViewById(R.h.bYv);
                view.setTag(aVar2);
            }
            if (GQ) {
                if (this.zqD) {
                    aVar2.zqG.setVisibility(0);
                } else {
                    aVar2.zqG.setVisibility(8);
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "refresh  " + this.zqB);
                if ((this.hdX == null || this.hdX.size() == 0) && !this.zqB) {
                    aVar2.kEZ.setText(this.context.getString(R.l.dDa));
                    aVar2.kEZ.setTextColor(this.context.getResources().getColor(R.e.btc));
                    return view;
                }
                aVar2.kEZ.setText(this.context.getString(R.l.dDb));
                aVar2.kEZ.setTextColor(com.tencent.mm.bv.a.Z(this.context, R.e.bth));
                return view;
            }
            if (this.hvV == null) {
                this.hvV = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ b zqE;

                    {
                        this.zqE = r1;
                    }

                    public final String hC(int i) {
                        if (i < 0) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                            return null;
                        }
                        bek GP = this.zqE.GP((this.zqE.aCQ() + i) + 1);
                        if (GP != null) {
                            return GP.vYI.wJF;
                        }
                        return null;
                    }

                    public final int NJ() {
                        return this.zqE.hdX == null ? 0 : this.zqE.hdX.size();
                    }
                };
            }
            if (this.hvU != null) {
                this.hvU.a((i - aCQ()) - 1, this.hvV);
            }
            bek GP = GP(i);
            aVar2.nJd.setVisibility(8);
            if (GP == null) {
                return view;
            }
            aVar2.yUR.setVisibility(8);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.ldx.view, GP.vYI.wJF);
            if (GP.wvf == 0) {
                aVar2.ldx.cpQ();
            } else if (com.tencent.mm.z.ak.a.hfN != null) {
                gP = com.tencent.mm.z.ak.a.hfN.gP(GP.wvf);
                if (gP != null) {
                    aVar2.ldx.d(m.kf(gP), com.tencent.mm.ui.base.MaskLayout.a.yfa);
                } else {
                    aVar2.ldx.cpQ();
                }
            } else {
                aVar2.ldx.cpQ();
            }
            try {
                aVar2.kEZ.setText(i.b(this.context, bh.ou(GP.wsB.wJF), aVar2.kEZ.getTextSize()));
                return view;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
                aVar2.kEZ.setText("");
                return view;
            }
        } else if (this.showType == 2) {
            if (view == null) {
                view = View.inflate(this.context, R.i.dtx, null);
                aVar2 = new a();
                aVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            af oh = oh(i);
            aVar.kEZ.setTextColor(com.tencent.mm.bv.a.Z(this.context, R.e.bth));
            try {
                aVar.kEZ.setText(i.b(this.context, this.context.getString(R.l.eTR, new Object[]{r.a(oh, oh.field_username)}), aVar.kEZ.getTextSize()));
            } catch (Exception e2) {
                aVar.kEZ.setText("");
            }
            aVar.kEZ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return view;
        } else {
            View view2;
            View inflate;
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                inflate = v.fv(this.context).inflate(R.i.deO, null);
                aVar2 = new a();
                aVar2.nJd = (TextView) inflate.findViewById(R.h.bYz);
                aVar2.ldx = (MaskLayout) inflate.findViewById(R.h.bYx);
                aVar2.kEZ = (TextView) inflate.findViewById(R.h.bYB);
                aVar2.iis = (CheckBox) inflate.findViewById(R.h.bYC);
                aVar2.yUR = (TextView) inflate.findViewById(R.h.bYv);
                inflate.setTag(aVar2);
            } else {
                inflate = view2;
                aVar2 = aVar;
            }
            af oh2 = oh(i);
            if (aVar2.nJd != null) {
                aVar2.nJd.setVisibility(8);
            }
            aVar2.kEZ.setTextColor(com.tencent.mm.bv.a.Z(this.context, !s.hn(oh2.field_username) ? R.e.bth : R.e.bti));
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.ldx.view, oh2.field_username);
            aVar2.yUR.setVisibility(8);
            if (oh2.field_verifyFlag == 0) {
                aVar2.ldx.cpQ();
            } else if (com.tencent.mm.z.ak.a.hfN != null) {
                gP = com.tencent.mm.z.ak.a.hfN.gP(oh2.field_verifyFlag);
                if (gP != null) {
                    aVar2.ldx.d(m.kf(gP), com.tencent.mm.ui.base.MaskLayout.a.yfa);
                } else {
                    aVar2.ldx.cpQ();
                }
            } else {
                aVar2.ldx.cpQ();
            }
            try {
                aVar2.kEZ.setText(i.b(this.context, r.a(oh2, oh2.field_username), aVar2.kEZ.getTextSize()));
            } catch (Exception e3) {
                aVar2.kEZ.setText("");
            }
            return inflate;
        }
    }

    public final void Xy() {
        ac(new 9(this));
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final void onResume() {
        ar.CG().a(106, this);
    }

    public final void onPause() {
        ar.CG().b(106, this);
    }

    public final void dD(List<String> list) {
        this.ynf = (String[]) list.toArray(new String[list.size()]);
        this.zqy = null;
        aUn();
        Xy();
    }

    public static String aah(String str) {
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        return trim;
    }

    public final void a(int i, int i2, String str, final k kVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() != 106) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SearchResultAdapter", "error type");
            return;
        }
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        this.zqD = false;
        if (com.tencent.mm.ui.t.a.a(this.context, i, i2, str, 7)) {
            this.zqB = false;
        } else if (i == 4 && i2 == -4) {
            ac(new 11(this));
        } else if (i == 0 && i2 == 0) {
            ac(new Runnable(this) {
                final /* synthetic */ b zqE;

                public final void run() {
                    bem So = ((ac) kVar).So();
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "count " + So.wkk);
                    if (So.wkk > 0) {
                        for (bek com_tencent_mm_protocal_c_bek : So.wkl) {
                            if (s.gM(com_tencent_mm_protocal_c_bek.wvf)) {
                                if (this.zqE.hdX == null) {
                                    this.zqE.hdX = new LinkedList();
                                }
                                this.zqE.hdX.add(com_tencent_mm_protocal_c_bek);
                            }
                        }
                    } else {
                        String a = n.a(So.vYI);
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "user " + a);
                        if (bh.ou(a).length() > 0) {
                            bek com_tencent_mm_protocal_c_bek2 = new bek();
                            com_tencent_mm_protocal_c_bek2.vYI = So.vYI;
                            com_tencent_mm_protocal_c_bek2.wvf = So.wvf;
                            com_tencent_mm_protocal_c_bek2.hvw = So.hvw;
                            com_tencent_mm_protocal_c_bek2.wsB = So.wsB;
                            com_tencent_mm_protocal_c_bek2.hvy = So.hvy;
                            com_tencent_mm_protocal_c_bek2.hvC = So.hvC;
                            com_tencent_mm_protocal_c_bek2.hvv = So.hvv;
                            com_tencent_mm_protocal_c_bek2.hvu = So.hvu;
                            com_tencent_mm_protocal_c_bek2.hvt = So.hvt;
                            com_tencent_mm_protocal_c_bek2.wvg = So.wvg;
                            com_tencent_mm_protocal_c_bek2.wvj = So.wvj;
                            com_tencent_mm_protocal_c_bek2.wvh = So.wvh;
                            com_tencent_mm_protocal_c_bek2.wvi = So.wvi;
                            com_tencent_mm_protocal_c_bek2.wvl = So.wvl;
                            com.tencent.mm.ad.n.Jz().f(a, n.a(So.vHb));
                            if (this.zqE.hdX == null) {
                                this.zqE.hdX = new LinkedList();
                            }
                            this.zqE.hdX.clear();
                            if (s.gM(com_tencent_mm_protocal_c_bek2.wvf)) {
                                this.zqE.hdX.add(com_tencent_mm_protocal_c_bek2);
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchResultAdapter", "count " + this.zqE.hdX.size());
                        }
                    }
                    this.zqE.zqB = false;
                }
            });
        } else {
            ac(new 2(this));
        }
    }

    public final void ac(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            return;
        }
        ag.y(new 4(this, runnable));
    }

    public final boolean aai(String str) {
        if (!(this.kiU == null || str == null)) {
            for (String equals : this.kiU) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.a.l;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bc.b;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.g;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BizChatSearchUI$a extends BaseAdapter implements e {
    public static int ynW = 3;
    private int Pb = 0;
    private Context context;
    private c hDn;
    String kGH;
    String ldh;
    private int scene;
    private int ynX;
    boolean ynY;
    boolean ynZ;
    private ArrayList<com.tencent.mm.ag.a.c> yoa = new ArrayList();
    private ArrayList<Object> yob = new ArrayList();
    private ArrayList<com.tencent.mm.ag.a.c> yoc = new ArrayList();
    private g yod;
    private ArrayList<g> yoe = new ArrayList();
    private g yof;
    private g yog;
    private ArrayList<g> yoh = new ArrayList();
    private g yoi;
    public boolean yoj = true;
    public boolean yok = false;
    public boolean yol = false;
    private boolean yom = true;
    private int yon = 0;
    public boolean yoo = false;
    int yop = 0;

    public final /* synthetic */ Object getItem(int i) {
        return Fl(i);
    }

    public BizChatSearchUI$a(Context context, String str, int i) {
        boolean z;
        boolean z2 = false;
        this.context = context;
        this.kGH = str;
        this.scene = i;
        if (this.scene == 1 || this.scene == 2) {
            z = true;
        } else {
            z = false;
        }
        this.ynY = z;
        if (this.scene == 1 || this.scene == 3) {
            z2 = true;
        }
        this.ynZ = z2;
        this.ynX = this.scene == 1 ? ynW : Integer.MAX_VALUE;
        a aVar = new a();
        aVar.hDD = com.tencent.mm.ag.a.e.bZ(this.kGH);
        aVar.hDA = true;
        aVar.hDX = true;
        aVar.hDP = R.k.bBB;
        this.hDn = aVar.PK();
        if (this.ynY) {
            ar.CG().a(1364, this);
        }
    }

    public final int getCount() {
        return this.Pb;
    }

    public final int getItemViewType(int i) {
        g Fl = Fl(i);
        if (Fl != null) {
            return Fl.kTK;
        }
        return g.yos;
    }

    public final int getViewTypeCount() {
        return g.yoy;
    }

    public final g Fl(int i) {
        int i2;
        if (i < this.yon) {
            if (i == 0) {
                if (this.yod == null) {
                    this.yod = new g(g.yox, Integer.valueOf(g.yoz));
                }
                return this.yod;
            } else if (i == this.yon - 1 && this.yok && cqK()) {
                if (this.yof == null) {
                    this.yof = new g();
                }
                this.yof.kTK = g.yow;
                this.yof.data = Integer.valueOf(g.yoz);
                return this.yof;
            } else if (i == this.yon - 1 && this.yoj && cqK()) {
                if (this.yof == null) {
                    this.yof = new g();
                }
                this.yof.kTK = g.yov;
                this.yof.data = Integer.valueOf(g.yoz);
                return this.yof;
            } else {
                i2 = i - 1;
                if (i2 >= 0 && i2 < this.yoe.size()) {
                    return (g) this.yoe.get(i2);
                }
            }
        } else if (i == this.yon) {
            if (this.yog == null) {
                this.yog = new g(g.yox, Integer.valueOf(g.yoA));
            }
            return this.yog;
        } else if (i == this.Pb - 1 && this.yom && cqK()) {
            if (this.yoi == null) {
                this.yoi = new g(g.yov, Integer.valueOf(g.yoA));
            }
            return this.yoi;
        } else {
            i2 = (i - this.yon) - 1;
            if (i2 >= 0 && i2 < this.yoh.size()) {
                return (g) this.yoh.get(i2);
            }
        }
        return new g();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        g Fl = Fl(i);
        String str;
        CharSequence a;
        if (Fl.kTK == g.yot || Fl.kTK == g.you) {
            CharSequence charSequence;
            String str2;
            boolean z2;
            CharSequence charSequence2;
            boolean z3;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.diO, viewGroup, false);
                view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
                BizChatSearchUI$f bizChatSearchUI$f = new BizChatSearchUI$f();
                bizChatSearchUI$f.iip = (ImageView) view.findViewById(R.h.bLL);
                bizChatSearchUI$f.iiq = (TextView) view.findViewById(R.h.cSu);
                bizChatSearchUI$f.iir = (TextView) view.findViewById(R.h.caS);
                bizChatSearchUI$f.contentView = view.findViewById(R.h.cJK);
                view.setTag(bizChatSearchUI$f);
            }
            BizChatSearchUI$f bizChatSearchUI$f2 = (BizChatSearchUI$f) view.getTag();
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (Fl.data instanceof com.tencent.mm.ag.a.c) {
                com.tencent.mm.ag.a.c cVar = (com.tencent.mm.ag.a.c) Fl.data;
                if (cVar != null) {
                    if (!cVar.Mt()) {
                        j ca = y.Mj().ca(cVar.field_bizChatServId);
                        if (ca != null) {
                            str4 = ca.field_userName;
                            str = ca.field_headImageUrl;
                        }
                    }
                    str4 = cVar.field_chatName;
                    str = cVar.field_headImageUrl;
                } else {
                    str = str4;
                    str4 = str3;
                }
                charSequence = str5;
                str2 = str;
                z2 = false;
                charSequence2 = str4;
                z3 = true;
            } else if (Fl.data instanceof hn) {
                hn hnVar = (hn) Fl.data;
                hq hqVar = hnVar.vNt;
                str2 = hqVar.kNz;
                str5 = hqVar.vNl;
                boolean equals = "userid".equals(hnVar.vNu);
                z3 = !equals;
                String str6 = hnVar.vNv;
                r1 = str2;
                str2 = str5;
                z2 = equals;
                r3 = str6;
            } else {
                str2 = str4;
                r1 = str3;
                r3 = str5;
                z3 = false;
                z2 = false;
            }
            if (z3) {
                a = a(this.context, b.a(charSequence2, this.ldh), d.b.mOG);
            } else {
                a = a(this.context, new SpannableString(charSequence2), d.b.mOG);
            }
            if (z2) {
                str = this.context.getString(R.l.dMB);
                SpannableString a2 = a(this.context, b.a(charSequence, this.ldh), d.b.mOG);
                charSequence2 = TextUtils.concat(new CharSequence[]{str, a2});
            } else {
                charSequence2 = "";
            }
            if (Fl.kTK == g.yot && i == this.yon - 1 && this.yon != this.Pb) {
                z = false;
            }
            o(bizChatSearchUI$f2.contentView, z);
            o.PA().a(str2, bizChatSearchUI$f2.iip, this.hDn);
            com.tencent.mm.plugin.fts.d.e.a(a, bizChatSearchUI$f2.iiq);
            com.tencent.mm.plugin.fts.d.e.a(charSequence2, bizChatSearchUI$f2.iir);
            return view;
        } else if (Fl.kTK == g.yox) {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.diX, viewGroup, false);
                BizChatSearchUI.b bVar = new BizChatSearchUI.b((byte) 0);
                bVar.lgs = (TextView) view.findViewById(R.h.cox);
                bVar.mPK = view.findViewById(R.h.cCk);
                bVar.contentView = view.findViewById(R.h.cJK);
                view.setTag(bVar);
            }
            BizChatSearchUI.b bVar2 = (BizChatSearchUI.b) view.getTag();
            str = ((Integer) Fl.data).intValue() == g.yoz ? this.context.getResources().getString(R.l.dMz) : ((Integer) Fl.data).intValue() == g.yoA ? this.context.getResources().getString(R.l.dMs) : "";
            com.tencent.mm.plugin.fts.d.e.a(str, bVar2.lgs);
            if (i == 0) {
                bVar2.mPK.setVisibility(8);
            } else {
                bVar2.mPK.setVisibility(0);
            }
            bVar2.contentView.setBackgroundResource(R.g.bDq);
            return view;
        } else if (Fl.kTK == g.yov) {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.djh, viewGroup, false);
                BizChatSearchUI.e eVar = new BizChatSearchUI.e((byte) 0);
                eVar.mPU = (TextView) view.findViewById(R.h.cRV);
                eVar.jCP = (ImageView) view.findViewById(R.h.coO);
                eVar.contentView = view.findViewById(R.h.cJK);
                view.setTag(eVar);
            }
            BizChatSearchUI.e eVar2 = (BizChatSearchUI.e) view.getTag();
            a = "";
            if (((Integer) Fl.data).intValue() == g.yoz) {
                a = this.context.getResources().getString(R.l.dMy);
            } else if (((Integer) Fl.data).intValue() == g.yoA) {
                Object string = this.context.getResources().getString(R.l.dMx);
            }
            if (((Integer) Fl.data).intValue() == g.yoz && this.yon != this.Pb) {
                z = false;
            }
            o(eVar2.contentView, z);
            eVar2.mPU.setText(a);
            eVar2.jCP.setImageResource(R.k.dyG);
            return view;
        } else if (Fl.kTK != g.yow) {
            return null;
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.diZ, viewGroup, false);
                BizChatSearchUI.d dVar = new BizChatSearchUI.d((byte) 0);
                dVar.mPU = (TextView) view.findViewById(R.h.cRV);
                dVar.contentView = view.findViewById(R.h.cJK);
                view.setTag(dVar);
            }
            BizChatSearchUI.d dVar2 = (BizChatSearchUI.d) view.getTag();
            if (((Integer) Fl.data).intValue() == g.yoz && this.yon != this.Pb) {
                z = false;
            }
            o(dVar2.contentView, z);
            dVar2.mPU.setText(this.context.getResources().getString(R.l.dMu));
            return view;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        if (this.ynY && kVar.getType() == 1364 && (kVar instanceof l)) {
            this.yol = false;
            l lVar = (l) kVar;
            ho hoVar = (lVar.gJQ == null || lVar.gJQ.hmg.hmo == null) ? null : (ho) lVar.gJQ.hmg.hmo;
            String str2 = hoVar.fod;
            String str3 = hoVar.vNq;
            if (!str2.equals(this.ldh) || !str3.equals(this.kGH) || this.yop != hoVar.offset) {
                return;
            }
            if (i == 0 && i2 == 0) {
                hp hpVar;
                if (lVar.gJQ == null || lVar.gJQ.hmh.hmo == null) {
                    hpVar = null;
                } else {
                    hpVar = (hp) lVar.gJQ.hmh.hmo;
                }
                if (hpVar == null || hpVar.vNw == null || hpVar.vNw.ret != 0) {
                    cqJ();
                    return;
                }
                List<hn> list = hpVar.vNx;
                boolean z = hpVar.vNy;
                if (str2.equals(this.ldh)) {
                    this.yok = false;
                    this.yop += list.size();
                    if (cqK()) {
                        if (this.yob.size() < this.yoa.size()) {
                            bl(str2, true);
                            return;
                        }
                    }
                    if (cqL()) {
                        this.yoj = z;
                    }
                    if (!cqM()) {
                        for (hn hnVar : list) {
                            hq hqVar = hnVar.vNt;
                            if (!bh.ov(hqVar.vNr)) {
                                Iterator it = this.yoa.iterator();
                                while (it.hasNext()) {
                                    if (hqVar.vNr.equals(((com.tencent.mm.ag.a.c) it.next()).field_bizChatServId)) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                                if (!z) {
                                    this.yob.add(hnVar);
                                }
                            }
                        }
                        mC(true);
                        return;
                    }
                    return;
                }
                return;
            }
            cqJ();
        }
    }

    private void cqJ() {
        if (cqL()) {
            this.yok = false;
            this.yoo = true;
            cqN();
        }
    }

    private boolean cqK() {
        return this.scene == 1;
    }

    final boolean cqL() {
        return this.scene == 2;
    }

    private boolean cqM() {
        return this.scene == 3;
    }

    private static SpannableString a(Context context, Spannable spannable, int i) {
        int i2 = 0;
        SpannableString c = i.c(context, spannable, i);
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        if (foregroundColorSpanArr != null) {
            int length = foregroundColorSpanArr.length;
            while (i2 < length) {
                Object obj = foregroundColorSpanArr[i2];
                c.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                i2++;
            }
        }
        return c;
    }

    private static void o(View view, boolean z) {
        if (z) {
            view.setBackgroundResource(R.g.bBx);
        } else {
            view.setBackgroundResource(R.g.bBy);
        }
    }

    final void bl(String str, boolean z) {
        com.tencent.mm.ag.a.b Mi = y.Mi();
        String str2 = this.kGH;
        List<com.tencent.mm.ag.a.c> arrayList = new ArrayList();
        if (!bh.ov(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizChatInfo.*");
            stringBuilder.append(" from BizChatConversation , BizChatInfo");
            stringBuilder.append(" where BizChatConversation.brandUserName").append(" = '").append(str2).append("'");
            stringBuilder.append(" and BizChatInfo.brandUserName").append(" = '").append(str2).append("'");
            stringBuilder.append(" and BizChatConversation.bizChatId");
            stringBuilder.append(" = BizChatInfo.bizChatLocalId");
            stringBuilder.append(" and BizChatInfo.chatName").append(" like '%").append(str).append("%'");
            stringBuilder.append(" order by BizChatConversation.flag").append(" desc");
            stringBuilder.append(" , BizChatConversation.lastMsgTime").append(" desc");
            x.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[]{stringBuilder.toString()});
            Cursor rawQuery = Mi.rawQuery(stringBuilder.toString(), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.ag.a.c cVar = new com.tencent.mm.ag.a.c();
                        cVar.b(rawQuery);
                        arrayList.add(cVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
        }
        aaS();
        for (com.tencent.mm.ag.a.c cVar2 : arrayList) {
            boolean Mt = cVar2.Mt();
            if (Mt && this.ynZ) {
                this.yoc.add(cVar2);
            } else if (!Mt && this.ynY) {
                this.yob.add(cVar2);
                this.yoa.add(cVar2);
            }
        }
        if (this.ynY) {
            boolean z2;
            if (this.yob.size() <= this.ynX) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.yok = z2;
        }
        mC(z);
    }

    final void YX(String str) {
        if (this.ynY) {
            ag.h(new 1(this, str), 200);
        }
    }

    final void aaS() {
        this.yop = 0;
        this.yob.clear();
        this.yoa.clear();
        this.yoc.clear();
    }

    final void mC(boolean z) {
        int i;
        int i2 = 1;
        this.yoe.clear();
        this.yoh.clear();
        for (i = 0; i < Math.min(this.ynX, this.yob.size()); i++) {
            this.yoe.add(new g(g.yot, this.yob.get(i)));
        }
        for (i = 0; i < Math.min(this.ynX, this.yoc.size()); i++) {
            this.yoh.add(new g(g.you, this.yoc.get(i)));
        }
        int size = this.yob.size();
        int size2 = this.yoc.size();
        if (this.scene != 2) {
            this.yoj = this.yob.size() > this.ynX;
        }
        this.yom = this.yoc.size() > this.ynX;
        if (size > 0 || this.yok) {
            size = Math.min(size, this.ynX) + 1;
            if (cqK()) {
                i = (this.yok || this.yoj) ? 1 : 0;
                i += size;
            } else {
                i = size;
            }
        } else {
            i = 0;
        }
        this.yon = i;
        if (size2 > 0) {
            i = (i + 1) + Math.min(size2, this.ynX);
            if (cqK()) {
                if (!this.yom) {
                    i2 = 0;
                }
                i += i2;
            }
        }
        this.Pb = i;
        if (z) {
            notifyDataSetChanged();
            cqN();
        }
    }

    final void cqN() {
        BizChatSearchUI bizChatSearchUI = (BizChatSearchUI) this.context;
        if (!cqK()) {
            if (bh.ov(this.ldh)) {
                bizChatSearchUI.ynT.setVisibility(0);
                bizChatSearchUI.ynT.setText("");
                bizChatSearchUI.ynS.setVisibility(8);
            } else if (cqL() && this.yok) {
                bizChatSearchUI.ynT.setVisibility(0);
                bizChatSearchUI.ynT.setText(R.l.dMu);
                bizChatSearchUI.ynS.setVisibility(8);
            } else if (cqL() && this.yoo) {
                bizChatSearchUI.ynT.setVisibility(0);
                bizChatSearchUI.ynT.setText(R.l.dMv);
                bizChatSearchUI.ynS.setVisibility(8);
            } else if (getCount() <= 0) {
                bizChatSearchUI.ynT.setVisibility(0);
                bizChatSearchUI.ynT.setText(f.a(bizChatSearchUI.getString(R.l.eIE), bizChatSearchUI.getString(R.l.eID), com.tencent.mm.plugin.fts.d.b.a.d(this.ldh, this.ldh)).mQk);
                bizChatSearchUI.ynS.setVisibility(8);
            } else {
                bizChatSearchUI.ynT.setVisibility(8);
                bizChatSearchUI.ynS.setVisibility(0);
            }
            if (!cqL()) {
                return;
            }
            if (this.yol) {
                bizChatSearchUI.Fk(1);
            } else if (this.yoj) {
                bizChatSearchUI.Fk(2);
            } else {
                bizChatSearchUI.Fk(0);
            }
        } else if (bh.ov(this.ldh)) {
            bizChatSearchUI.ynT.setVisibility(8);
            bizChatSearchUI.ynS.setVisibility(8);
        } else if (getCount() <= 0) {
            bizChatSearchUI.ynT.setVisibility(0);
            bizChatSearchUI.ynS.setVisibility(8);
        } else {
            bizChatSearchUI.ynT.setVisibility(8);
            bizChatSearchUI.ynS.setVisibility(0);
        }
    }
}

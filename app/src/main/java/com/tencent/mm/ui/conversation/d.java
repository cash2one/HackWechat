package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class d extends o<ae> implements b {
    private static long yWU = 2000;
    private String ilo;
    protected f kBC;
    protected MMSlideDelView$c kBD;
    protected e kBE;
    protected com.tencent.mm.ui.base.MMSlideDelView.d kBF = MMSlideDelView.cpx();
    protected List<String> kiU = null;
    private boolean nXt = false;
    boolean rsP = false;
    private boolean yWF = true;
    private f yWG;
    private com.tencent.mm.pluginsdk.ui.d yWH;
    private boolean yWI = false;
    private boolean yWJ = false;
    private boolean yWK = false;
    private boolean yWL = false;
    private c yWM;
    private c yWN = null;
    private b yWO = null;
    public String yWP = "";
    final e yWQ = new e(this);
    private final int yWR;
    private final int yWS;
    private a yWT;
    private boolean yWV = false;
    private ak yWW = new ak(ar.Dm().oAt.getLooper(), new 1(this), false);
    private float yno = -1.0f;
    protected float ynp = -1.0f;
    private float ynq = -1.0f;
    private ColorStateList[] ynr = new ColorStateList[5];
    HashMap<String, d> yns;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (this.nXt) {
            if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
                if (obj == null) {
                    obj = new ae();
                }
                obj.dF("");
                obj.dG("");
                obj.b(cursor);
                return obj;
            } else if (cursor.getString(0).equals("2")) {
                ar.Hg();
                af WJ = com.tencent.mm.z.c.EY().WJ(x.k(cursor));
                if (WJ == null) {
                    WJ = new x();
                    WJ.b(cursor);
                    ar.Hg();
                    com.tencent.mm.z.c.EY().O(WJ);
                }
                if (obj == null) {
                    obj = new ae();
                }
                obj.eQ(2);
                obj.aj(-1);
                obj.eR(1);
                obj.setContent(this.context.getString(R.l.ekm));
                obj.setUsername(WJ.field_username);
                obj.eO(0);
                obj.dE(Integer.toString(1));
                obj.dF("");
                obj.dG("");
                return obj;
            }
        }
        if (obj == null) {
            obj = new ae();
        }
        obj.dF("");
        obj.dG("");
        obj.b(cursor);
        return obj;
    }

    public d(Context context, a aVar) {
        super(context, new ae());
        this.xIi = aVar;
        this.ynr[0] = com.tencent.mm.bv.a.Z(context, R.e.bsO);
        this.ynr[1] = com.tencent.mm.bv.a.Z(context, R.e.btl);
        this.ynr[3] = com.tencent.mm.bv.a.Z(context, R.e.btv);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[4] = com.tencent.mm.bv.a.Z(context, R.e.btb);
        this.yns = new HashMap();
        if (com.tencent.mm.bv.a.ey(context)) {
            this.yWS = context.getResources().getDimensionPixelSize(R.f.buC);
            this.yWR = context.getResources().getDimensionPixelSize(R.f.buD);
        } else {
            this.yWS = context.getResources().getDimensionPixelSize(R.f.buB);
            this.yWR = context.getResources().getDimensionPixelSize(R.f.buE);
        }
        this.yno = (float) com.tencent.mm.bv.a.aa(context, R.f.bvK);
        this.ynp = (float) com.tencent.mm.bv.a.aa(context, R.f.bvs);
        this.ynq = (float) com.tencent.mm.bv.a.aa(context, R.f.bvW);
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.kBE = eVar;
    }

    public final void a(MMSlideDelView$c mMSlideDelView$c) {
        this.kBD = mMSlideDelView$c;
    }

    public void detach() {
    }

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.euA);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : n.c(this.context, aeVar.field_conversationTime, true);
    }

    protected final void Xz() {
        Xy();
    }

    public final void onPause() {
        if (this.kBF != null) {
            this.kBF.aUy();
        }
        this.yWI = false;
    }

    private void cwq() {
        if (this.yns != null) {
            for (Entry value : this.yns.entrySet()) {
                ((d) value.getValue()).yXa = null;
            }
        }
    }

    public final void onResume() {
        boolean z = true;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[]{Boolean.valueOf(this.yWI), Boolean.valueOf(this.yWK), Boolean.valueOf(this.yWJ), Boolean.valueOf(this.yWL)});
        this.yWI = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = m.a("MM/dd", time).toString();
        if (this.yWP.equals(charSequence)) {
            z = false;
        }
        this.yWP = charSequence;
        if (z) {
            cwq();
        }
        if (this.yWK && this.yWO != null) {
            this.yWK = false;
        }
        if (this.yWJ || this.yWL) {
            super.a(null, null);
            this.yWJ = false;
            this.yWL = false;
        }
    }

    public final void onDestroy() {
        this.yWW.TG();
        this.yWO = null;
        this.yWM = null;
        if (this.yns != null) {
            this.yns.clear();
            this.yns = null;
        }
        aUn();
        this.xIi = null;
        detach();
    }

    public void Xy() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[]{Boolean.valueOf(this.nXt)});
        if (this.nXt) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = ar.Hg().hez.a(s.hfk, this.kiU, this.ilo);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (this.kiU != null && this.kiU.size() > 0) {
                arrayList.addAll(this.kiU);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!string.endsWith("@chatroom")) {
                        arrayList2.add(string);
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "block user " + string);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = ar.Hg().heA.b(this.ilo, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            ar.Hg();
            setCursor(com.tencent.mm.z.c.Fd().a(s.hfk, this.kiU, com.tencent.mm.m.a.gJf, false));
        }
        if (!(this.yWG == null || this.ilo == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        g gVar;
        int i2;
        d dVar;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        e eVar = this.yWQ;
        eVar.talker = str;
        eVar.jLe = null;
        eVar.yXm = null;
        eVar.initialized = false;
        if (!t.ov(str)) {
            eVar.initialized = true;
        }
        this.yWT = new a(this, (byte) 0);
        if (view == null) {
            g gVar2 = new g();
            if (com.tencent.mm.bv.a.ey(this.context)) {
                inflate = View.inflate(this.context, R.i.dfc, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfb, null);
            }
            gVar2.iip = (ImageView) inflate.findViewById(R.h.bLL);
            com.tencent.mm.pluginsdk.ui.a.b.a(gVar2.iip, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.iip.getDrawable();
            if (this.yWH != null) {
                this.yWH.a(aVar);
            }
            gVar2.ynw = (NoMeasuredTextView) inflate.findViewById(R.h.cAn);
            gVar2.yXn = (NoMeasuredTextView) inflate.findViewById(R.h.cPc);
            gVar2.ynx = (NoMeasuredTextView) inflate.findViewById(R.h.cTR);
            gVar2.yny = (NoMeasuredTextView) inflate.findViewById(R.h.csx);
            gVar2.kBL = (TextView) inflate.findViewById(R.h.cRX);
            gVar2.kBL.setBackgroundResource(com.tencent.mm.ui.tools.s.gd(this.context));
            gVar2.ynz = (ImageView) inflate.findViewById(R.h.cpt);
            gVar2.ynB = inflate.findViewById(R.h.bLO);
            gVar2.ynA = (ImageView) inflate.findViewById(R.h.cQy);
            gVar2.yXo = (ImageView) inflate.findViewById(R.h.cua);
            inflate.setTag(gVar2);
            gVar2.yny.O(this.ynp);
            gVar2.ynx.O(this.ynq);
            gVar2.ynw.O(this.yno);
            gVar2.yXn.O(this.ynp);
            gVar2.yny.setTextColor(this.ynr[0]);
            gVar2.ynx.setTextColor(this.ynr[4]);
            gVar2.ynw.setTextColor(this.ynr[3]);
            gVar2.yXn.setTextColor(this.ynr[0]);
            gVar2.yny.ygb = true;
            gVar2.ynx.ygb = false;
            gVar2.ynw.ygb = true;
            gVar2.yXn.ygb = true;
            gVar2.ynx.Eg();
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            inflate = view;
        }
        d dVar2 = (d) this.yns.get(str);
        if (dVar2 == null) {
            String str2;
            d dVar3 = new d(this, (byte) 0);
            eVar = this.yWQ;
            if (eVar.initialized && eVar.jLe == null) {
                ar.Hg();
                eVar.jLe = com.tencent.mm.z.c.EY().WO(eVar.talker);
            }
            af afVar = eVar.jLe;
            if (afVar != null) {
                dVar3.yXe = afVar.fWx;
                dVar3.yXd = (int) afVar.gJd;
            } else {
                dVar3.yXe = -1;
                dVar3.yXd = -1;
            }
            dVar3.yXi = afVar != null;
            boolean z = afVar != null && afVar.AJ();
            dVar3.yXk = z;
            z = afVar != null && afVar.fWn == 0;
            dVar3.yXj = z;
            dVar3.tRV = s.eV(str);
            z = dVar3.tRV && dVar3.yXj && aeVar.field_unReadCount > 0;
            dVar3.yXh = z;
            dVar3.kTK = 0;
            if (vP(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !t.ov(aeVar.field_content)) {
                str2 = aeVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(":");
                    if (split != null && split.length > 3) {
                        str2 = split[1] + ":" + split[2] + ":" + split[3];
                    }
                }
                if (!new com.tencent.mm.modelvoice.n(str2).hVA) {
                    dVar3.kTK = 1;
                }
            }
            str2 = r.a(afVar, str, dVar3.tRV);
            if (dVar3.tRV && str2 == null) {
                dVar3.nickName = this.context.getString(R.l.dSN);
            } else {
                dVar3.nickName = i.b(this.context, r.a(afVar, str, dVar3.tRV), gVar.ynw.gu.getTextSize());
            }
            dVar3.yXa = h(aeVar);
            dVar3.yXb = a(aeVar, (int) gVar.yny.gu.getTextSize(), dVar3.yXh);
            dVar3.yXl = aeVar.field_attrflag;
            switch (aeVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.k.dze;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.k.dzd;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            dVar3.yXc = i2;
            dVar3.yXf = s.a(aeVar);
            ar.Hg();
            dVar3.ynt = com.tencent.mm.z.c.Fd().g(aeVar);
            z = afVar != null && afVar.AI();
            dVar3.yXg = z;
            dVar3.vfW = w.cfe();
            this.yns.put(str, dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        if (dVar.yXa == null) {
            dVar.yXa = h(aeVar);
        }
        if (dVar.yXh || s.hd(aeVar.field_parentRef)) {
            gVar.yny.setTextColor(this.ynr[0]);
        } else {
            gVar.yny.setTextColor(this.ynr[dVar.kTK]);
        }
        h.fu(gVar.yny.getWidth());
        h.fv((int) gVar.yny.gu.getTextSize());
        h.a(gVar.yny.gu);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.ynw.ET(R.g.bDb);
            gVar.ynw.mu(true);
        } else {
            gVar.ynw.mu(false);
        }
        i2 = dVar.yXc;
        if (i2 != -1) {
            gVar.yny.ES(i2);
            gVar.yny.mt(true);
        } else {
            gVar.yny.mt(false);
        }
        gVar.ynw.setText(dVar.nickName);
        gVar.yXn.setVisibility(8);
        LayoutParams layoutParams = gVar.ynx.getLayoutParams();
        if (dVar.yXa.length() > 9) {
            if (layoutParams.width != this.yWS) {
                layoutParams.width = this.yWS;
                gVar.ynx.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.yWR) {
            layoutParams.width = this.yWR;
            gVar.ynx.setLayoutParams(layoutParams);
        }
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[]{Integer.valueOf(layoutParams.width)});
        gVar.ynx.setText(dVar.yXa);
        gVar.yny.setText(dVar.yXb);
        if (dVar.tRV && dVar.yXj) {
            gVar.ynz.setVisibility(0);
        } else if (dVar.yXg) {
            gVar.ynz.setVisibility(0);
        } else {
            gVar.ynz.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(gVar.iip, str);
        if (this.yWF) {
            if (aeVar == null || gVar == null || dVar == null) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.kBL.setVisibility(4);
                gVar.ynB.setVisibility(4);
                if (s.hd(aeVar.field_username)) {
                    gVar.ynB.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.ynw.setTextColor(this.ynr[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.ynw;
                    ColorStateList colorStateList = (dVar.yXi && dVar.yXe == 1) ? this.ynr[2] : this.ynr[3];
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.yXi || dVar.yXd == 0) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (s.hd(aeVar.field_parentRef)) {
                        gVar.ynB.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.yXg && dVar.yXk) {
                        gVar.ynB.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.tRV && dVar.yXj) {
                        gVar.ynB.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i2 = aeVar.field_unReadCount;
                        if (i2 > 99) {
                            gVar.kBL.setText(R.l.eRP);
                            gVar.kBL.setVisibility(0);
                        } else if (i2 > 0) {
                            gVar.kBL.setText(aeVar.field_unReadCount);
                            gVar.kBL.setVisibility(0);
                        }
                        this.yWT.yWY = i2;
                    }
                }
            }
        }
        if (!dVar.yXf && dVar.ynt && ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.Fd().f(aeVar);
        }
        if (!dVar.ynt || aeVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
        } else {
            inflate.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
        }
        com.tencent.mm.bm.d.ccW();
        com.tencent.mm.sdk.b.b riVar = new ri();
        riVar.fJc.fJe = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(riVar.fJd.fJg))) {
            aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
            ar.Hg();
            com.tencent.mm.z.c.Fd().a(aeVar, aeVar.field_username);
        }
        if (q.a.vcp == null || !q.a.vcp.Mr(aeVar.field_username)) {
            gVar.ynA.setVisibility(8);
        } else {
            gVar.ynA.setVisibility(0);
            if (aeVar.field_username.equals(riVar.fJd.fJg)) {
                gVar.ynA.setImageResource(R.k.dBa);
            } else {
                gVar.ynA.setImageResource(R.k.dAZ);
            }
        }
        if (q.a.vcw == null || !q.a.vcw.DC(aeVar.field_username)) {
            gVar.yXo.setVisibility(8);
        } else {
            gVar.yXo.setVisibility(0);
        }
        this.yWT.content = String.valueOf(dVar.yXb);
        this.yWT.bgo = String.valueOf(dVar.nickName);
        this.yWT.yWZ = String.valueOf(dVar.yXa);
        a aVar2 = this.yWT;
        com.tencent.mm.ui.a.a.a.cnI().a(inflate, aVar2.bgo, aVar2.yWY, aVar2.yWZ, aVar2.content);
        a(str, gVar);
        a(aeVar, dVar.ynt, i, false);
        return inflate;
    }

    protected void a(String str, g gVar) {
    }

    protected void a(ae aeVar, boolean z, int i, boolean z2) {
    }

    private static int vP(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence a(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (t.ov(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.context, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aeVar.field_username;
            if (str2.equals("qqmail")) {
                ar.Hg();
                if (t.e((Integer) com.tencent.mm.z.c.CU().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eMu);
                }
            }
            if (str2.equals("tmessage")) {
                ar.Hg();
                bc EY = com.tencent.mm.z.c.Fg().EY("@t.qq.com");
                if (EY == null || !EY.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eMu);
                }
            }
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str2 = YW(aeVar.field_digest);
                str = "";
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str2 = YW(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return t.ov(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.context.getString(R.l.dEG);
                aeVar.dF(t.ov(str) ? str2 : str + ": " + str2);
            }
            if (!t.ov(aeVar.field_digest)) {
                if (t.ov(aeVar.field_digestUser)) {
                    str = aeVar.field_digest;
                } else {
                    str = (aeVar.field_isSend == 0 && s.eV(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gu(aeVar.field_digestUser);
                    try {
                        str = String.format(aeVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace('\n', ' ');
                if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                    if (!z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    } else if (aeVar.field_unReadCount > 1 && s.hd(aeVar.field_parentRef)) {
                        replace = this.context.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return i.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.eud));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(i.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.context);
            replace = str.replace('\n', ' ');
            if (aeVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.context.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
            return i.c(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.euh));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(i.c(this.context, aeVar.field_editingMsg, i));
        return replace;
    }

    private static String YW(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(str);
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[]{Boolean.valueOf(this.yWI), Boolean.valueOf(this.yWJ), str});
        if (!(t.ov(str) || this.yns == null)) {
            this.yns.remove(str);
        }
        if (this.yWI) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[]{Boolean.valueOf(this.yWV), Boolean.valueOf(this.yWW.cfK())});
            this.yWV = true;
            if (this.yWW.cfK()) {
                cwr();
                return;
            }
            return;
        }
        this.yWJ = true;
    }

    private void cwr() {
        ag.y(new 2(this));
    }
}

package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.by.a.a;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.f$a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.k;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class g extends f<String, ae> implements com.tencent.mm.sdk.e.m.b {
    protected MMSlideDelView.f kBC;
    protected c kBD;
    protected MMSlideDelView$d kBF;
    protected List<String> kiU;
    boolean nUw;
    private boolean nXt;
    boolean rsP;
    private boolean yWF;
    com.tencent.mm.pluginsdk.ui.d yWH;
    private boolean yWK;
    com.tencent.mm.sdk.b.c yWN;
    public String yWP;
    private final int yWR;
    private final int yWS;
    HashSet<String> yYA;
    boolean yYB;
    private boolean yYC;
    public String yYD;
    final e yYE;
    private float yYF;
    private a yYG;
    private long yYH;
    private boolean yYs;
    private ri yYt;
    b yYu;
    private HashSet<String> yYv;
    private boolean yYw;
    HashMap<String, Integer> yYx;
    private HashMap<String, Integer> yYy;
    boolean yYz;
    private float yno;
    private float ynp;
    private float ynq;
    private ColorStateList[] ynr;
    HashMap<String, d> yns;
    public boolean ywC;

    public interface b {
        void cwC();
    }

    private class d {
        public String gBL;
        public int kTK;
        public CharSequence nickName;
        public boolean tRV;
        public CharSequence yXa;
        public CharSequence yXb;
        public int yXc;
        public int yXd;
        public int yXe;
        public boolean yXf;
        public boolean yXg;
        public boolean yXh;
        public boolean yXi;
        public boolean yXj;
        public boolean yXk;
        final /* synthetic */ g yYI;
        public boolean ynt;

        private d(g gVar) {
            this.yYI = gVar;
        }
    }

    public final /* synthetic */ a ckX() {
        return new ae();
    }

    public g(Context context, f$a com_tencent_mm_ui_f_a) {
        super(context, (byte) 0);
        this.kiU = null;
        this.ynr = new ColorStateList[5];
        this.yWF = true;
        this.yYs = false;
        this.kBF = MMSlideDelView.cpx();
        this.yYt = null;
        this.nXt = false;
        this.yno = -1.0f;
        this.ynp = -1.0f;
        this.ynq = -1.0f;
        this.yWK = false;
        this.yWN = null;
        this.yYu = null;
        this.ywC = false;
        this.yYw = false;
        this.yYx = new HashMap();
        this.yYy = new HashMap();
        this.yYz = false;
        this.yYB = false;
        this.yYC = false;
        this.yWP = "";
        this.yYD = "";
        this.yYE = new e(this);
        this.rsP = false;
        this.yYF = -1.0f;
        this.yYH = 0;
        this.nUw = false;
        this.TAG = "MicroMsg.ConversationWithCacheAdapter";
        super.a(com_tencent_mm_ui_f_a);
        this.ynr[0] = com.tencent.mm.bv.a.Z(context, R.e.bsO);
        this.ynr[1] = com.tencent.mm.bv.a.Z(context, R.e.btl);
        this.ynr[3] = com.tencent.mm.bv.a.Z(context, R.e.btv);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[4] = com.tencent.mm.bv.a.Z(context, R.e.btb);
        if (com.tencent.mm.bv.a.ey(context)) {
            this.yWS = context.getResources().getDimensionPixelSize(R.f.buC);
            this.yWR = context.getResources().getDimensionPixelSize(R.f.buD);
        } else {
            this.yWS = context.getResources().getDimensionPixelSize(R.f.buB);
            this.yWR = context.getResources().getDimensionPixelSize(R.f.buE);
        }
        this.yns = new HashMap();
        this.yYv = new HashSet();
        this.yYA = new HashSet();
        this.yno = context.getResources().getDimension(R.f.bvK);
        this.ynp = context.getResources().getDimension(R.f.bvs);
        this.ynq = context.getResources().getDimension(R.f.bvW);
        this.kiU = new ArrayList();
        this.kiU.add("qmessage");
    }

    public final void a(MMSlideDelView.f fVar) {
        this.kBC = fVar;
    }

    public final void a(c cVar) {
        this.kBD = cVar;
    }

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.euA);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : n.c(this.context, aeVar.field_conversationTime, true);
    }

    public final void cvI() {
        boolean z = true;
        if (this.kiU == null) {
            this.kiU = new ArrayList();
        }
        this.kiU.clear();
        boolean z2 = (q.FW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        boolean Gj = q.Gj();
        if (!(z2 && Gj)) {
            z = false;
        }
        if (z != this.yYC) {
            if (z) {
                ar.Hg();
                a(5, (m) com.tencent.mm.z.c.Fd(), (Object) "floatbottle");
            } else {
                ar.Hg();
                a(2, (m) com.tencent.mm.z.c.Fd(), (Object) "floatbottle");
            }
            this.yYC = z;
        }
        if (this.yYC) {
            this.kiU.add("floatbottle");
        }
        this.kiU.add("qmessage");
    }

    public final void onPause() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.ywC);
        if (this.ywC) {
            this.ywC = false;
            super.pause();
            if (this.kBF != null) {
                this.kBF.aUy();
            }
        }
    }

    private void cwq() {
        if (this.yns != null) {
            for (Entry value : this.yns.entrySet()) {
                ((d) value.getValue()).yXa = null;
            }
        }
    }

    public final void onResume() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.ywC);
        if (!this.ywC) {
            boolean z;
            this.ywC = true;
            cvI();
            cwB();
            x.i(this.TAG, "newcursor resume syncNow ");
            this.xEr = true;
            lO(true);
            Time time = new Time();
            time.setToNow();
            String charSequence = com.tencent.mm.pluginsdk.h.m.a("MM/dd", time).toString();
            String cfi = w.cfi();
            if (this.yWP.equals(charSequence) && this.yYD.equals(cfi)) {
                z = false;
            } else {
                z = true;
            }
            this.yWP = charSequence;
            this.yYD = cfi;
            if (z) {
                cwq();
            }
            if (this.yWK && this.yYu != null) {
                this.yYu.cwC();
                this.yWK = false;
                super.p(null, 1);
            }
            this.yYt = new ri();
            this.yYt.fJc.fJe = true;
            com.tencent.mm.sdk.b.a.xef.m(this.yYt);
        }
    }

    public final void cwA() {
        super.p(null, 1);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        View view2;
        f fVar;
        this.yYG = new a(this, (byte) 0);
        ae aeVar = (ae) DC(i);
        String str = aeVar.field_username;
        this.yYE.dS(str);
        if (!this.yYx.containsKey(str)) {
            this.yYx.put(str, Integer.valueOf(i));
        } else if (i != ((Integer) this.yYx.get(str)).intValue()) {
            SparseArray[] clY = clY();
            HashMap ckO = this.xEs == null ? null : this.xEs.xCa.ckO();
            StringBuffer stringBuffer = new StringBuffer();
            for (SparseArray sparseArray : clY) {
                i2 = 0;
                while (i2 < sparseArray.size() && i2 < 50) {
                    stringBuffer.append("[");
                    stringBuffer.append(i2);
                    stringBuffer.append(",");
                    stringBuffer.append(sparseArray.keyAt(i2));
                    stringBuffer.append(",");
                    stringBuffer.append((String) sparseArray.valueAt(i2));
                    stringBuffer.append("]");
                    i2++;
                }
            }
            stringBuffer.append("\n");
            if (ckO != null) {
                i2 = 0;
                for (Entry entry : ckO.entrySet()) {
                    if (i2 >= 50) {
                        break;
                    }
                    i2++;
                    stringBuffer.append("[");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                    if (entry.getValue() != null) {
                        stringBuffer.append(((ae) entry.getValue()).field_username);
                    }
                    stringBuffer.append("]");
                }
                stringBuffer.append("\n");
            }
            String str2 = "MicroMsg.ConversationWithCacheAdapter";
            String str3 = "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d";
            Object[] objArr = new Object[5];
            objArr[0] = stringBuffer.toString();
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i);
            objArr[3] = this.yYx.toString();
            objArr[4] = Integer.valueOf(ckO != null ? ckO.size() : 0);
            x.i(str2, str3, objArr);
            if (!this.yYw) {
                e.qb(20);
                this.yYw = true;
            }
            if (System.currentTimeMillis() - this.yYH > 3600000) {
                super.p(null, 1);
                this.yYH = System.currentTimeMillis();
            }
        }
        if (view == null) {
            View a;
            f fVar2 = new f();
            if (com.tencent.mm.bv.a.ey(this.context)) {
                a = com.tencent.mm.kiss.a.b.DY().a((Activity) this.context, "R.layout.conversation_item_with_cache_large", R.i.dfe);
            } else if (com.tencent.mm.bv.a.ez(this.context)) {
                a = com.tencent.mm.kiss.a.b.DY().a((Activity) this.context, "R.layout.conversation_item_with_cache_small", R.i.dff);
            } else {
                a = com.tencent.mm.kiss.a.b.DY().a((Activity) this.context, "R.layout.conversation_item_with_cache", R.i.dfd);
            }
            fVar2.iip = (ImageView) a.findViewById(R.h.bLL);
            com.tencent.mm.pluginsdk.ui.a.b.a(fVar2.iip, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar2.iip.getDrawable();
            if (this.yWH != null) {
                this.yWH.a(aVar);
            }
            fVar2.ynw = (NoMeasuredTextView) a.findViewById(R.h.cAn);
            fVar2.ynx = (NoMeasuredTextView) a.findViewById(R.h.cTR);
            fVar2.yYR = (ImageView) a.findViewById(R.h.csy);
            fVar2.yny = (NoMeasuredTextView) a.findViewById(R.h.csx);
            fVar2.kBL = (TextView) a.findViewById(R.h.cRX);
            fVar2.ynz = (ImageView) a.findViewById(R.h.cpt);
            fVar2.ynB = a.findViewById(R.h.bLO);
            fVar2.ynA = (ImageView) a.findViewById(R.h.cQy);
            fVar2.yXo = (ImageView) a.findViewById(R.h.cua);
            fVar2.yYS = (ImageView) a.findViewById(R.h.cxU);
            fVar2.kBL.setBackgroundResource(s.gd(this.context));
            fVar2.yYT = new c(this);
            a.setTag(fVar2);
            fVar2.yny.O((float) com.tencent.mm.bv.a.aa(this.context, R.f.bvU));
            fVar2.ynx.O((float) com.tencent.mm.bv.a.aa(this.context, R.f.bvW));
            fVar2.ynw.O((float) com.tencent.mm.bv.a.aa(this.context, R.f.bvK));
            this.yYF = fVar2.ynw.gu.getTextSize();
            fVar2.yny.setTextColor(this.ynr[0]);
            fVar2.ynx.setTextColor(this.ynr[4]);
            fVar2.ynw.setTextColor(this.ynr[3]);
            fVar2.yny.ygb = true;
            fVar2.ynx.ygb = false;
            fVar2.ynw.ygb = true;
            fVar2.ynx.Eg();
            view2 = a;
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
            view2 = view;
        }
        d i3 = i(aeVar);
        if (i3.yXb == null) {
            i3.yXb = b(aeVar, (int) fVar.yny.gu.getTextSize(), i3.yXh);
        }
        if (i3.yXa == null) {
            i3.yXa = h(aeVar);
        }
        if (i3.yXh) {
            fVar.yny.setTextColor(this.ynr[0]);
        } else {
            fVar.yny.setTextColor(this.ynr[i3.kTK]);
        }
        h.fu(fVar.yny.getWidth());
        h.fv((int) fVar.yny.gu.getTextSize());
        h.a(fVar.yny.gu);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            fVar.ynw.ET(R.g.bDb);
            fVar.ynw.mu(true);
        } else {
            fVar.ynw.mu(false);
        }
        i2 = i3.yXc;
        if (i2 != -1) {
            fVar.yny.ES(i2);
            fVar.yny.mt(true);
            x.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[]{str, Integer.valueOf(i3.yXc)});
        } else {
            fVar.yny.mt(false);
            fVar.yny.invalidate();
        }
        fVar.ynw.setText(i3.nickName);
        LayoutParams layoutParams = fVar.ynx.getLayoutParams();
        if (i3.yXa.length() >= 9) {
            if (layoutParams.width != this.yWS) {
                layoutParams.width = this.yWS;
                fVar.ynx.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.yWR) {
            layoutParams.width = this.yWR;
            fVar.ynx.setLayoutParams(layoutParams);
        }
        fVar.ynx.setText(i3.yXa);
        fVar.yny.setText(i3.yXb);
        fVar.yYR.setVisibility(8);
        fVar.ynz.setVisibility(8);
        if (i3.tRV) {
            if (i3.yXj) {
                fVar.ynz.setVisibility(0);
            }
        } else if (i3.yXg) {
            fVar.ynz.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(fVar.iip, str);
        if (this.yWF) {
            if (aeVar == null || fVar == null || i3 == null) {
                x.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.kBL.setVisibility(4);
                fVar.ynB.setVisibility(4);
                ColorStateList colorStateList = (!com.tencent.mm.z.s.gB(aeVar.field_username) && i3.yXi && (i3.yXe == 1 || i3.yXe == 2 || i3.yXe == 3)) ? this.ynr[2] : this.ynr[3];
                fVar.ynw.setTextColor(colorStateList);
                if (!i3.yXi || i3.yXd == 0) {
                    x.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i2 = a(aeVar, i3);
                    if (i2 == 1) {
                        fVar.ynB.setVisibility(0);
                    } else if (i2 == 2) {
                        i2 = aeVar.field_unReadCount;
                        if (i2 > 99) {
                            fVar.kBL.setText(R.l.eRP);
                            fVar.kBL.setVisibility(0);
                        } else if (i2 > 0) {
                            fVar.kBL.setText(aeVar.field_unReadCount);
                            fVar.kBL.setVisibility(0);
                        }
                        this.yYG.yWY = i2;
                    }
                }
            }
        }
        if (!i3.yXf && i3.ynt && ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.Fd().f(aeVar);
        }
        if (!i3.ynt || aeVar.field_conversationTime == -1) {
            view2.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
        } else {
            view2.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
        }
        if (VERSION.SDK_INT >= 21) {
            view2.findViewById(R.h.bYX).setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ g yYI;

                {
                    this.yYI = r1;
                }

                @TargetApi(21)
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    view.findViewById(R.h.bYX).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
                    return false;
                }
            });
        }
        com.tencent.mm.bm.d.ccW();
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(this.yYt.fJd.fJg))) {
            aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
            ar.Hg();
            com.tencent.mm.z.c.Fd().a(aeVar, aeVar.field_username);
        }
        if (com.tencent.mm.pluginsdk.q.a.vcp == null || !com.tencent.mm.pluginsdk.q.a.vcp.Mr(aeVar.field_username)) {
            fVar.ynA.setVisibility(8);
        } else {
            fVar.ynA.setVisibility(0);
            if (aeVar.field_username.equals(this.yYt.fJd.fJg)) {
                fVar.ynA.setImageResource(R.k.dBa);
            } else {
                fVar.ynA.setImageResource(R.k.dAZ);
            }
        }
        if (com.tencent.mm.pluginsdk.q.a.vcw == null || !com.tencent.mm.pluginsdk.q.a.vcw.DC(aeVar.field_username)) {
            fVar.yXo.setVisibility(8);
        } else {
            fVar.yXo.setVisibility(0);
        }
        if (com.tencent.mm.z.s.eV(aeVar.field_username) && com.tencent.mm.pluginsdk.q.a.vcx != null && com.tencent.mm.pluginsdk.q.a.vcx.Ft(aeVar.field_username)) {
            if (com.tencent.mm.pluginsdk.q.a.vcx.bcv() && com.tencent.mm.pluginsdk.q.a.vcx.dp(aeVar.field_username, q.FS())) {
                fVar.yYS.setImageResource(R.k.dxu);
            } else {
                fVar.yYS.setImageResource(R.k.dxv);
            }
            fVar.yYS.setVisibility(0);
        } else {
            fVar.yYS.setVisibility(8);
        }
        this.yYG.content = String.valueOf(i3.yXb);
        this.yYG.bgo = i3.gBL;
        this.yYG.yWZ = String.valueOf(i3.yXa);
        a aVar2 = this.yYG;
        com.tencent.mm.ui.a.a.a.cnI().a(view2, aVar2.bgo, aVar2.yWY, aVar2.yWZ, aVar2.content);
        return view2;
    }

    final d i(ae aeVar) {
        boolean z = true;
        String str = aeVar.field_username;
        d dVar = (d) this.yns.get(str);
        if (dVar != null) {
            return dVar;
        }
        boolean z2;
        int i;
        d dVar2 = new d();
        this.yYE.dS(str);
        af cwD = this.yYE.cwD();
        if (cwD != null) {
            dVar2.yXe = cwD.fWx;
            dVar2.yXd = (int) cwD.gJd;
        } else {
            dVar2.yXe = -1;
            dVar2.yXd = -1;
        }
        if (cwD != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.yXi = z2;
        if (cwD == null || !cwD.AJ()) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.yXk = z2;
        if (cwD == null || cwD.fWn != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.yXj = z2;
        dVar2.tRV = com.tencent.mm.z.s.eV(str);
        if (dVar2.tRV && dVar2.yXj && aeVar.field_unReadCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.yXh = z2;
        dVar2.kTK = 0;
        if (vP(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !t.ov(aeVar.field_content)) {
            String str2 = aeVar.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || aeVar.gc(2097152) || aeVar.gc(8388608)) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new com.tencent.mm.modelvoice.n(str2).hVA) {
                dVar2.kTK = 1;
            }
        }
        dVar2.gBL = r.a(cwD, str, dVar2.tRV);
        a(dVar2);
        dVar2.yXa = h(aeVar);
        switch (aeVar.field_status) {
            case 0:
                i = -1;
                break;
            case 1:
            case 8:
                i = R.k.dze;
                break;
            case 2:
                i = -1;
                break;
            case 5:
                i = R.k.dzd;
                break;
            default:
                i = -1;
                break;
        }
        dVar2.yXc = i;
        dVar2.yXf = com.tencent.mm.z.s.a(aeVar);
        ar.Hg();
        dVar2.ynt = com.tencent.mm.z.c.Fd().g(aeVar);
        if (cwD == null || !cwD.AI()) {
            z = false;
        }
        dVar2.yXg = z;
        this.yns.put(str, dVar2);
        return dVar2;
    }

    private void a(d dVar) {
        if (dVar.tRV && dVar.gBL == null) {
            dVar.nickName = this.context.getString(R.l.dSN);
        } else {
            dVar.nickName = i.c(this.context, dVar.gBL, com.tencent.mm.bv.a.aa(this.context, R.f.bvK));
        }
    }

    static int a(ae aeVar, d dVar) {
        if (aeVar == null || aeVar.field_unReadCount <= 0) {
            if (aeVar == null || ((!aeVar.gc(8388608) && !aeVar.gc(2097152)) || aeVar == null || aeVar.field_unReadMuteCount <= 0)) {
                return 0;
            }
            return 1;
        } else if (com.tencent.mm.z.s.hd(aeVar.field_username)) {
            return 1;
        } else {
            if (com.tencent.mm.z.s.hi(aeVar.field_username)) {
                ar.Hg();
                if (!com.tencent.mm.z.c.CU().getBoolean(com.tencent.mm.storage.w.a.xsq, true)) {
                    return 1;
                }
            }
            if (com.tencent.mm.z.s.hm(aeVar.field_username)) {
                ar.Hg();
                if (!com.tencent.mm.z.c.CU().getBoolean(com.tencent.mm.storage.w.a.xsr, true)) {
                    return 1;
                }
            }
            if (dVar.yXg && dVar.yXk) {
                return 1;
            }
            if (dVar.tRV && dVar.yXj) {
                return 1;
            }
            return 2;
        }
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

    public final void clearCache() {
        if (this.yns != null) {
            this.yns.clear();
            this.yYB = true;
        }
    }

    private CharSequence b(ae aeVar, int i, boolean z) {
        CharSequence string;
        if (t.ov(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && (aeVar.field_unReadCount > 0 || aeVar.field_unReadMuteCount > 0))) {
            String gu;
            if (vP(aeVar.field_msgType) == 10000) {
                boolean hd = com.tencent.mm.z.s.hd(aeVar.field_username);
                if (!hd) {
                    hd = aeVar.gc(2097152);
                }
                if (!hd) {
                    hd = aeVar.gc(8388608);
                }
                if (!hd) {
                    hd = aeVar.gc(16777216);
                }
                if (!hd) {
                    hd = com.tencent.mm.z.s.hm(aeVar.field_username);
                }
                if (!hd) {
                    return new SpannableString(i.f(this.context, aeVar.field_content, i));
                }
            }
            if (vP(aeVar.field_msgType) == 49) {
                gu = r.gu(aeVar.field_digestUser);
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(aeVar.field_content);
                if (fT != null && fT.type == 40 && k.fX(aeVar.field_content).hea == 19) {
                    string = t.ov(gu) ? this.context.getString(R.l.dGs) : gu + ": " + this.context.getString(R.l.dGs);
                    aeVar.dF(string);
                    return string;
                }
            }
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.context, charSequence, (float) i));
            }
            int i2;
            String str = aeVar.field_username;
            if (str.equals("qqmail")) {
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
            if (str.equals("tmessage")) {
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
            if (aeVar.field_msgType != null && aeVar.field_msgType.equals("64")) {
                return aeVar.field_content;
            }
            CharSequence charSequence2;
            SpannableStringBuilder spannableStringBuilder;
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str = YW(aeVar.field_digest);
                gu = "";
                if (!t.ov(str)) {
                    return "[" + str + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    gu = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str = YW(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (!t.ov(str)) {
                        charSequence2 = "[" + str + "]";
                        if (t.ov(gu)) {
                            return i.c(this.context, gu, i);
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                        spannableStringBuilder2.append(i.c(this.context, gu, i));
                        spannableStringBuilder2.append(": ");
                        spannableStringBuilder2.append(charSequence2);
                        return spannableStringBuilder2;
                    }
                }
                str = this.context.getString(R.l.dEG);
                aeVar.dF(t.ov(gu) ? str : gu + ": " + str);
            }
            if (!t.ov(aeVar.field_digest)) {
                if (t.ov(aeVar.field_digestUser)) {
                    gu = aeVar.field_digest;
                } else {
                    gu = (aeVar.field_isSend == 0 && com.tencent.mm.z.s.eV(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gu(aeVar.field_digestUser);
                    try {
                        gu = String.format(aeVar.field_digest, new Object[]{gu});
                    } catch (Exception e) {
                    }
                }
                charSequence = gu.replace('\n', ' ');
                if (aeVar.field_UnReadInvite <= 0) {
                    spannableStringBuilder = new SpannableStringBuilder(aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE ? this.context.getString(R.l.eue, new Object[]{Integer.valueOf(aeVar.field_UnReadInvite)}) : this.context.getString(R.l.euc));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(i.c(this.context, charSequence, i));
                    return spannableStringBuilder;
                } else if (aeVar.field_atCount <= 0 && (aeVar.field_unReadCount > 0 || aeVar.field_unReadMuteCount > 0)) {
                    spannableStringBuilder = new SpannableStringBuilder(this.context.getString(aeVar.field_atCount < Downloads.RECV_BUFFER_SIZE ? R.l.eud : R.l.euf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(i.c(this.context, charSequence, i));
                    return spannableStringBuilder;
                } else if (aeVar.gc(16777216) || (aeVar.field_unReadCount <= 0 && aeVar.field_unReadMuteCount <= 0)) {
                    if (z || (aeVar.field_unReadCount <= 1 && aeVar.field_unReadMuteCount <= 0)) {
                        string = charSequence;
                    } else {
                        string = this.context.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), charSequence});
                    }
                    return i.c(this.context, string, i);
                } else {
                    charSequence2 = this.context.getString(R.l.dBS);
                    charSequence = charSequence.replace(charSequence2, "");
                    string = new SpannableStringBuilder(charSequence2);
                    string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                    string.append(i.c(this.context, charSequence, i));
                    return string;
                }
            }
            gu = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.context);
            charSequence = gu.replace('\n', ' ');
            if (aeVar.field_UnReadInvite <= 0) {
                if (aeVar.field_atCount <= 0) {
                }
                if (aeVar.gc(16777216)) {
                }
                if (z) {
                }
                string = charSequence;
                return i.c(this.context, string, i);
            }
            if (aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE) {
            }
            spannableStringBuilder = new SpannableStringBuilder(aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE ? this.context.getString(R.l.eue, new Object[]{Integer.valueOf(aeVar.field_UnReadInvite)}) : this.context.getString(R.l.euc));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(i.c(this.context, charSequence, i));
            return spannableStringBuilder;
        }
        string = new SpannableStringBuilder(this.context.getString(R.l.euh));
        string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
        string.append(" ").append(i.c(this.context, aeVar.field_editingMsg, i));
        return string;
    }

    private static String YW(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(str);
    }

    public final com.tencent.mm.by.a.d clX() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        ar.Hg();
        return (com.tencent.mm.by.a.d) com.tencent.mm.z.c.Fd().a(com.tencent.mm.z.s.hfk, this.kiU, com.tencent.mm.m.a.gJf, true);
    }

    public final ArrayList<ae> ah(ArrayList<String> arrayList) {
        x.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList<ae> arrayList2 = new ArrayList(arrayList.size());
        ar.Hg();
        Cursor a = com.tencent.mm.z.c.Fd().a(arrayList, com.tencent.mm.z.s.hfk, this.kiU, com.tencent.mm.m.a.gJf);
        while (a.moveToNext()) {
            ae aeVar = new ae();
            aeVar.b(a);
            arrayList2.add(aeVar);
        }
        a.close();
        return arrayList2;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.f.b<String, ae>> hashSet, SparseArray<String>[] sparseArrayArr) {
        if (sparseArrayArr != null && sparseArrayArr.length > 0) {
            com.tencent.mm.ui.f.b bVar;
            x.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[]{Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size())});
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it.next();
                if (!(bVar == null || bVar.xEF == 5 || arrayList.contains(bVar.object))) {
                    x.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) bVar.object));
                    arrayList.add(bVar.object);
                }
            }
            HashMap hashMap = new HashMap();
            ar.Hg();
            Cursor a = com.tencent.mm.z.c.Fd().a(arrayList, com.tencent.mm.z.s.hfk, this.kiU, com.tencent.mm.m.a.gJf);
            while (a.moveToNext()) {
                aj aeVar = new ae();
                aeVar.b(a);
                hashMap.put(aeVar.field_username, aeVar);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it2.next();
                if (bVar != null) {
                    if (bVar.xEF != 5) {
                        x.d("MicroMsg.ConversationWithCacheAdapter", "evnet name," + ((String) bVar.object) + "  event.newObj   ==" + (hashMap.get(bVar.object) == null));
                        bVar.xEG = hashMap.get(bVar.object);
                    } else {
                        bVar.xEG = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it3.next();
                if (bVar != null) {
                    a(bVar, sparseArrayArr[0], hashMap2);
                    if (bVar.xEF != 5) {
                        hashMap2.put(bVar.object, bVar.xEG);
                    }
                }
            }
        }
        return sparseArrayArr;
    }

    private ae c(String str, HashMap<String, ae> hashMap) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return (ae) ce(str);
        }
        return (ae) hashMap.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SparseArray<String> a(com.tencent.mm.ui.f.b<String, ae> bVar, SparseArray<String> sparseArray, HashMap<String, ae> hashMap) {
        String str = (String) bVar.object;
        int size = sparseArray.size();
        ae aeVar = (ae) bVar.xEG;
        int size2 = sparseArray.size();
        int i = 0;
        while (i < size2) {
            if (((String) sparseArray.get(i)).equals(str)) {
                break;
            }
            i++;
        }
        i = -1;
        x.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[]{str, Integer.valueOf(size), Integer.valueOf(i)});
        int i2;
        switch (bVar.xEF) {
            case 2:
                if (aeVar != null) {
                    if (i < 0) {
                        i = 0;
                        while (i < size && c((String) sparseArray.get(i), hashMap).field_flag > aeVar.field_flag) {
                            i++;
                        }
                        for (i2 = size; i2 > i; i2--) {
                            sparseArray.put(i2, sparseArray.get(i2 - 1));
                        }
                        sparseArray.put(i, str);
                        break;
                    }
                }
                x.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
                if (i >= 0) {
                    x.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[]{str});
                    while (i < size - 1) {
                        sparseArray.put(i, sparseArray.get(i + 1));
                        i++;
                    }
                    sparseArray.remove(size - 1);
                    break;
                }
                break;
            case 5:
                if (i >= 0) {
                    while (i < size - 1) {
                        sparseArray.put(i, sparseArray.get(i + 1));
                        i++;
                    }
                    sparseArray.remove(size - 1);
                    break;
                }
                break;
            default:
                if (i < 0) {
                    x.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
                    break;
                }
                aj c = c(str, hashMap);
                if (aeVar == null) {
                    x.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[]{str});
                    while (i < size - 1) {
                        sparseArray.put(i, sparseArray.get(i + 1));
                        i++;
                    }
                    sparseArray.remove(size - 1);
                    break;
                }
                long j = c.field_flag;
                long j2 = aeVar.field_flag;
                if (j != j2) {
                    int i3;
                    Object obj;
                    int i4;
                    boolean z;
                    if (j < j2) {
                        i3 = i - 1;
                        size = 0;
                        obj = 1;
                    } else {
                        i3 = size - 1;
                        size = i + 1;
                        obj = null;
                    }
                    for (i4 = size; i4 <= i3; i4++) {
                        if (c((String) sparseArray.get(i4), hashMap).field_flag <= aeVar.field_flag) {
                            z = true;
                            x.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[]{Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i), str});
                            if (z) {
                                if (obj == null) {
                                    while (i > i4) {
                                        sparseArray.put(i, sparseArray.get(i - 1));
                                        i--;
                                    }
                                    i2 = i4;
                                } else {
                                    i2 = i4 - 1;
                                    while (i < i2) {
                                        sparseArray.put(i, sparseArray.get(i + 1));
                                        i++;
                                    }
                                }
                                sparseArray.put(i2, str);
                                break;
                            }
                        }
                    }
                    z = false;
                    x.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[]{Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i), str});
                    if (z) {
                        if (obj == null) {
                            i2 = i4 - 1;
                            while (i < i2) {
                                sparseArray.put(i, sparseArray.get(i + 1));
                                i++;
                            }
                        } else {
                            while (i > i4) {
                                sparseArray.put(i, sparseArray.get(i - 1));
                                i--;
                            }
                            i2 = i4;
                        }
                        sparseArray.put(i2, str);
                    }
                }
                break;
        }
        return sparseArray;
    }

    public final void a(int i, m mVar, Object obj) {
        int i2 = 0;
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (mVar instanceof as) {
            x.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[]{Integer.valueOf(i), str});
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@micromsg.qq.com"))) {
                i2 = 1;
            }
            if (i2 == 0) {
                if (this.yns != null) {
                    if (!obj.equals("")) {
                        this.yYA.add(str);
                    } else if (i == 5) {
                        this.yYB = true;
                        super.p(null, 1);
                        return;
                    }
                }
                if (i == 3) {
                    i = 2;
                }
                super.p(str, i);
            }
        } else if (mVar instanceof com.tencent.mm.storage.ar) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[]{Integer.valueOf(i), obj, Boolean.valueOf(this.nUw)});
            if (!this.nUw) {
                this.yYz = true;
                if (i != 5 && i != 2 && this.yns != null && this.yns.containsKey(str) && this.yYv != null) {
                    this.yYv.add(str);
                }
            }
        }
    }

    private void cwB() {
        if (this.yns != null && this.yYv != null && !this.yYv.isEmpty()) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[]{Integer.valueOf(this.yYv.size())});
            Iterator it = this.yYv.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (!(str == null || str.equals("") || !this.yns.containsKey(str))) {
                    d dVar = (d) this.yns.get(str);
                    if (dVar != null) {
                        this.yYE.dS(str);
                        boolean eV = com.tencent.mm.z.s.eV(str);
                        af cwD = this.yYE.cwD();
                        if (cwD != null) {
                            String a = r.a(cwD, str, eV);
                            x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[]{a, dVar.gBL});
                            if (!(a == null || a.equals(dVar.gBL))) {
                                dVar.gBL = a;
                                a(dVar);
                                i = 1;
                            }
                            boolean AI = cwD.AI();
                            eV = cwD.fWn == 0;
                            if (!(dVar.yXg == AI && eV == dVar.yXj)) {
                                dVar.yXg = AI;
                                dVar.yXj = eV;
                                dVar.yXk = cwD.AJ();
                                x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[]{str});
                                i2 = 1;
                                i = i2;
                            }
                        }
                    }
                }
                i2 = i;
                i = i2;
            }
            if (i != 0) {
                notifyDataSetChanged();
            }
            this.yYv.clear();
        }
    }

    public final boolean ckP() {
        return super.ckP();
    }

    public final boolean ZG(String str) {
        return this.yns == null || !this.yns.containsKey(str);
    }

    public final void Gs(int i) {
        if (i >= 0 && i < getCount()) {
            ae aeVar = (ae) DC(i);
            if (aeVar != null) {
                com.tencent.mm.pluginsdk.ui.a.b.bZV().cm(aeVar.field_username);
            }
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.yYx.clear();
        x.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
}

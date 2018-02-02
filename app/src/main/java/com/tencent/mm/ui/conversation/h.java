package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map.Entry;

public final class h extends o<ae> implements b {
    private static long yWU = 2000;
    private String fCU;
    protected f kBC;
    protected c kBD;
    protected e kBE;
    protected d kBF = MMSlideDelView.cpx();
    private boolean yWI = false;
    private boolean yWJ = false;
    public String yWP = "";
    private final int yWR;
    private final int yWS;
    private boolean yWV = false;
    ak yWW = new ak(ar.Dm().oAt.getLooper(), new 1(this), false);
    private ColorStateList[] yYU = new ColorStateList[5];
    private float yno = -1.0f;
    private float ynp = -1.0f;
    private float ynq = -1.0f;
    HashMap<String, a> yns;

    private class a {
        public int kTK;
        public CharSequence nickName;
        public boolean vfW;
        public CharSequence yXa;
        public CharSequence yXb;
        public int yXc;
        public int yXd;
        public boolean yXg;
        public boolean yXi;
        public boolean yXk;
        public int yXl;
        final /* synthetic */ h yYV;
        public boolean yYW;
        public boolean ynt;

        private a(h hVar) {
            this.yYV = hVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (obj == null) {
            obj = new ae();
        }
        obj.dF("");
        obj.dG("");
        obj.b(cursor);
        return obj;
    }

    public h(Context context, String str, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xIi = aVar;
        this.fCU = str;
        this.yns = new HashMap();
        this.yYU[0] = com.tencent.mm.bv.a.Z(context, R.e.bsO);
        this.yYU[1] = com.tencent.mm.bv.a.Z(context, R.e.btl);
        this.yYU[3] = com.tencent.mm.bv.a.Z(context, R.e.btv);
        this.yYU[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.yYU[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.yYU[4] = com.tencent.mm.bv.a.Z(context, R.e.btb);
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
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(this);
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.kBE = eVar;
    }

    public final void a(c cVar) {
        this.kBD = cVar;
    }

    public final void onPause() {
        if (this.kBF != null) {
            this.kBF.aUy();
        }
        this.yWI = false;
    }

    public final void onResume() {
        boolean z = true;
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
        if (this.yWJ) {
            super.a(null, null);
            this.yWJ = false;
        }
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        aUn();
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fd().c(s.hfk, null, this.fCU));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bv.a.ey(this.context)) {
                inflate = View.inflate(this.context, R.i.dfc, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfb, null);
            }
            bVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
            bVar.yYX = (NoMeasuredTextView) inflate.findViewById(R.h.cAn);
            bVar.yYX.O(this.yno);
            bVar.yYX.setTextColor(this.yYU[3]);
            bVar.yYX.ygb = true;
            bVar.yYY = (NoMeasuredTextView) inflate.findViewById(R.h.cTR);
            bVar.yYY.O(this.ynq);
            bVar.yYY.setTextColor(this.yYU[4]);
            bVar.yYY.ygb = false;
            bVar.yYY.Eg();
            bVar.yYZ = (NoMeasuredTextView) inflate.findViewById(R.h.csx);
            bVar.yYZ.O(this.ynp);
            bVar.yYZ.setTextColor(this.yYU[0]);
            bVar.yYZ.ygb = true;
            bVar.yZa = (TextView) inflate.findViewById(R.h.cRX);
            bVar.yZa.setBackgroundResource(com.tencent.mm.ui.tools.s.gd(this.context));
            bVar.ynz = (ImageView) inflate.findViewById(R.h.cpt);
            bVar.ynB = inflate.findViewById(R.h.bLO);
            inflate.findViewById(R.h.cQy).setVisibility(8);
            inflate.findViewById(R.h.cua).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.yns.get(str);
        ar.Hg();
        com.tencent.mm.l.a WO = com.tencent.mm.z.c.EY().WO(str);
        if (aVar2 == null) {
            a aVar3 = new a();
            if (WO != null) {
                aVar3.yXd = (int) WO.gJd;
            } else {
                aVar3.yXd = -1;
            }
            aVar3.yXi = WO != null;
            boolean z = WO != null && WO.AJ();
            aVar3.yXk = z;
            z = WO != null && WO.AI();
            aVar3.yXg = z;
            aVar3.yYW = aeVar.field_unReadCount > 0;
            aVar3.kTK = 0;
            if (j(aeVar) == 34 && aeVar.field_isSend == 0 && !t.ov(aeVar.field_content) && !new n(aeVar.field_content).hVA) {
                aVar3.kTK = 1;
            }
            aVar3.nickName = i.b(this.context, r.a(WO, str, false), bVar.yYX.gu.getTextSize());
            aVar3.yXa = h(aeVar);
            int textSize = (int) bVar.yYZ.gu.getTextSize();
            z = aVar3.yXg && aVar3.yYW;
            aVar3.yXb = c(aeVar, textSize, z);
            aVar3.yXl = aeVar.field_attrflag;
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
            aVar3.yXc = i2;
            ar.Hg();
            aVar3.ynt = com.tencent.mm.z.c.Fd().g(aeVar);
            aVar3.vfW = w.cfe();
            this.yns.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.yXa == null) {
            aVar.yXa = h(aeVar);
        }
        if (aVar.yXg && aVar.yYW) {
            bVar.yYZ.setTextColor(this.yYU[0]);
        } else {
            bVar.yYZ.setTextColor(this.yYU[aVar.kTK]);
        }
        com.tencent.mm.booter.notification.a.h.fu(bVar.yYZ.getWidth());
        com.tencent.mm.booter.notification.a.h.fv((int) bVar.yYZ.gu.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(bVar.yYZ.gu);
        if (aVar.yXc != -1) {
            bVar.yYZ.ES(aVar.yXc);
            bVar.yYZ.mt(true);
        } else {
            bVar.yYZ.mt(false);
        }
        bVar.yYZ.setText(aVar.yXb);
        bVar.yYX.mu(false);
        bVar.yYX.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.yYY.getLayoutParams();
        if (aVar.yXa.length() > 9) {
            if (layoutParams.width != this.yWS) {
                layoutParams.width = this.yWS;
                bVar.yYY.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.yWR) {
            layoutParams.width = this.yWR;
            bVar.yYY.setLayoutParams(layoutParams);
        }
        bVar.yYY.setText(aVar.yXa);
        if (aVar.yXg) {
            bVar.ynz.setVisibility(0);
        } else {
            bVar.ynz.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.iip, str);
        bVar.yZa.setVisibility(4);
        bVar.ynB.setVisibility(4);
        if (aVar.yXi && aVar.yXd != 0) {
            i2 = aeVar.field_unReadCount;
            if (aVar.yXg) {
                View view2 = bVar.ynB;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.yZa.setText(R.l.eRP);
                bVar.yZa.setVisibility(0);
            } else if (i2 > 0) {
                bVar.yZa.setText(String.valueOf(i2));
                bVar.yZa.setVisibility(0);
            }
        }
        if (!aVar.ynt || aeVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
        } else {
            inflate.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
        }
        com.tencent.mm.ui.a.a.a.cnI().a(inflate, String.valueOf(aVar.nickName), aeVar.field_unReadCount, String.valueOf(aVar.yXa), String.valueOf(aVar.yXb));
        return inflate;
    }

    private static int j(ae aeVar) {
        int i = 1;
        String str = aeVar.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence c(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (t.ov(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.context, charSequence, (float) i));
            }
            String str;
            if (j(aeVar) == 47 || j(aeVar) == 1048625) {
                String YW = YW(aeVar.field_digest);
                str = "";
                if (YW != null) {
                    return "[" + YW + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    YW = YW(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (YW != null) {
                        YW = "[" + YW + "]";
                        return t.ov(str) ? YW : str + ": " + YW;
                    }
                }
                YW = this.context.getString(R.l.dEG);
                aeVar.dF(t.ov(str) ? YW : str + ": " + YW);
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
                    if (z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return i.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.eud));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(i.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, j(aeVar), this.context);
            replace = str.replace('\n', ' ');
            if (aeVar.field_atCount > 0) {
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

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.euA);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(this.context, aeVar.field_conversationTime, true);
    }

    private void cwq() {
        if (this.yns != null) {
            for (Entry value : this.yns.entrySet()) {
                ((a) value.getValue()).yXa = null;
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[]{Boolean.valueOf(this.yWI), Boolean.valueOf(this.yWJ), str});
        if (!(t.ov(str) || this.yns == null)) {
            this.yns.remove(str);
        }
        if (this.yWI) {
            x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[]{Boolean.valueOf(this.yWV), Boolean.valueOf(this.yWW.cfK())});
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

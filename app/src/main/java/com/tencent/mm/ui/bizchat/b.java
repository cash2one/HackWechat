package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;

public final class b extends o<com.tencent.mm.ag.a.a> implements com.tencent.mm.sdk.e.m.b {
    protected f kBC;
    protected MMSlideDelView$c kBD;
    protected e kBE;
    protected d kBF = MMSlideDelView.cpx();
    private final String kGH;
    private c lcT = null;
    private final MMFragmentActivity ynn;
    private float yno = -1.0f;
    private float ynp = -1.0f;
    private float ynq = -1.0f;
    private ColorStateList[] ynr = new ColorStateList[5];
    HashMap<String, a> yns;

    private class a {
        String htK;
        public boolean kTc;
        String mHp;
        public boolean ynt;
        public com.tencent.mm.ag.a.a ynu;
        final /* synthetic */ b ynv;

        private a(b bVar) {
            this.ynv = bVar;
            this.htK = null;
            this.mHp = null;
        }
    }

    public static class b {
        public ImageView iip;
        public TextView kBL;
        public ImageView ynA;
        public View ynB;
        public NoMeasuredTextView ynw;
        public NoMeasuredTextView ynx;
        public NoMeasuredTextView yny;
        public ImageView ynz;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.ag.a.a) obj;
        if (obj == null) {
            obj = new com.tencent.mm.ag.a.a();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, com.tencent.mm.ui.o.a aVar, String str) {
        super(context, new com.tencent.mm.ag.a.a());
        this.xIi = aVar;
        this.ynn = (MMFragmentActivity) context;
        this.kGH = str;
        this.yns = new HashMap();
        this.ynr[0] = com.tencent.mm.bv.a.Z(context, R.e.bsO);
        this.ynr[1] = com.tencent.mm.bv.a.Z(context, R.e.btl);
        this.ynr[3] = com.tencent.mm.bv.a.Z(context, R.e.btv);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[2] = com.tencent.mm.bv.a.Z(context, R.e.btj);
        this.ynr[4] = com.tencent.mm.bv.a.Z(context, R.e.btb);
        this.yno = (float) com.tencent.mm.bv.a.aa(context, R.f.bvK);
        this.ynp = (float) com.tencent.mm.bv.a.aa(context, R.f.bvs);
        this.ynq = (float) com.tencent.mm.bv.a.aa(context, R.f.bvW);
        com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
        aVar2.hDD = com.tencent.mm.ag.a.e.bZ(this.kGH);
        aVar2.hDA = true;
        aVar2.hDX = true;
        aVar2.hDP = R.k.bBB;
        this.lcT = aVar2.PK();
    }

    public final void Xy() {
        aUn();
        setCursor(y.Mi().kj(this.kGH));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
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

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.kBF != null) {
            this.kBF.aUy();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        int i2;
        com.tencent.mm.ag.a.a aVar = (com.tencent.mm.ag.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            b bVar3 = new b();
            if (com.tencent.mm.bv.a.ey(this.ynn)) {
                inflate = View.inflate(this.ynn, R.i.dfc, null);
            } else {
                inflate = View.inflate(this.ynn, R.i.dfb, null);
            }
            bVar3.iip = (ImageView) inflate.findViewById(R.h.bLL);
            bVar3.ynw = (NoMeasuredTextView) inflate.findViewById(R.h.cAn);
            bVar3.ynx = (NoMeasuredTextView) inflate.findViewById(R.h.cTR);
            bVar3.yny = (NoMeasuredTextView) inflate.findViewById(R.h.csx);
            bVar3.kBL = (TextView) inflate.findViewById(R.h.cRX);
            bVar3.kBL.setBackgroundResource(s.gd(this.ynn));
            bVar3.ynz = (ImageView) inflate.findViewById(R.h.cpt);
            bVar3.ynB = inflate.findViewById(R.h.bLO);
            bVar3.ynA = (ImageView) inflate.findViewById(R.h.cQy);
            inflate.setTag(bVar3);
            bVar3.yny.O(this.ynp);
            bVar3.ynx.O(this.ynq);
            bVar3.ynw.O(this.yno);
            bVar3.yny.setTextColor(this.ynr[0]);
            bVar3.ynx.setTextColor(this.ynr[4]);
            bVar3.ynw.setTextColor(this.ynr[3]);
            bVar3.yny.ygb = true;
            bVar3.ynx.ygb = false;
            bVar3.ynw.ygb = true;
            bVar3.ynx.Eg();
            view = inflate;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.yns.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a();
            y.Mi();
            aVar2.ynt = com.tencent.mm.ag.a.b.c(aVar);
            com.tencent.mm.ag.a.c ag = y.Mh().ag(j);
            if (ag.Mt()) {
                aVar2.htK = ag.field_chatName;
                aVar2.kTc = ag.ho(1);
                aVar2.mHp = ag.field_headImageUrl;
            } else {
                j ca = y.Mj().ca(ag.field_bizChatServId);
                if (ca != null) {
                    aVar2.htK = ca.field_userName;
                    aVar2.kTc = ca.ho(1);
                    aVar2.mHp = ca.field_headImageUrl;
                }
            }
            if (bh.ov(aVar2.htK)) {
                aVar2.htK = this.ynn.getString(R.l.eFx);
            }
            aVar2.ynu = aVar;
            this.yns.put(String.valueOf(j), aVar2);
        }
        bVar2.ynA.setVisibility(8);
        bVar2.ynx.setText(aVar2.ynu.field_status == 1 ? this.ynn.getString(R.l.euA) : n.c(this.ynn, aVar2.ynu.field_lastMsgTime, true));
        com.tencent.mm.aq.o.PA().a(aVar2.mHp, bVar2.iip, this.lcT);
        if (aVar2.kTc) {
            bVar2.ynz.setVisibility(0);
        } else {
            bVar2.ynz.setVisibility(8);
        }
        bVar2.ynw.setText(i.c(this.ynn, aVar2.htK, (int) bVar2.ynw.gu.getTextSize()));
        CharSequence a = a(aVar2.ynu, (int) bVar2.yny.gu.getTextSize(), aVar2.htK);
        switch (aVar2.ynu.field_status) {
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
        bVar2.ynw.mu(false);
        if (i2 != -1) {
            bVar2.yny.ES(i2);
            bVar2.yny.mt(true);
        } else {
            bVar2.yny.mt(false);
        }
        bVar2.yny.setText(a);
        bVar2.yny.setTextColor(com.tencent.mm.bv.a.Z(this.ynn, R.e.btk));
        if (vP(aVar2.ynu.field_msgType) == 34 && aVar2.ynu.field_isSend == 0 && !bh.ov(aVar2.ynu.field_content) && !new com.tencent.mm.modelvoice.n(aVar2.ynu.field_content).hVA) {
            bVar2.yny.setTextColor(com.tencent.mm.bv.a.Z(this.ynn, R.e.btl));
        }
        if (aVar2.kTc) {
            if (aVar2.ynu.field_unReadCount > 0) {
                bVar2.ynB.setVisibility(0);
            } else {
                bVar2.ynB.setVisibility(4);
            }
            bVar2.kBL.setVisibility(4);
        } else {
            bVar2.ynB.setVisibility(4);
            if (aVar2.ynu.field_unReadCount > 99) {
                bVar2.kBL.setText(R.l.eRP);
                bVar2.kBL.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.ynu.field_unReadCount > 0) {
                bVar2.kBL.setText(aVar2.ynu.field_unReadCount);
                bVar2.kBL.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.kBL.setVisibility(4);
                x.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.ynt) {
            view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
        } else {
            view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
        }
        return view;
    }

    private static String YW(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(str);
    }

    private CharSequence a(com.tencent.mm.ag.a.a aVar, int i, String str) {
        if (bh.ov(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2 = aVar.field_digest;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String YW = YW(aVar.field_digest);
                str2 = "";
                if (YW != null) {
                    return "[" + YW + "]";
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    YW = YW(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (YW != null) {
                        YW = "[" + YW + "]";
                        return bh.ov(str2) ? YW : str2 + ": " + YW;
                    }
                }
                YW = this.ynn.getString(R.l.dEG);
                aVar.field_digest = bh.ov(str2) ? YW : str2 + ": " + YW;
            }
            if (bh.ov(aVar.field_digest)) {
                str2 = "";
            } else if (bh.ov(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace('\n', ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                return i.c(this.ynn, replace, i);
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.ynn.getString(R.l.eud));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(i.c(this.ynn, replace, i));
            return spannableStringBuilder;
        }
        spannableStringBuilder = new SpannableStringBuilder(this.ynn.getString(R.l.euh));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(i.c(this.ynn, aVar.field_editingMsg, i));
        return spannableStringBuilder;
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

    protected final void Xz() {
        Xy();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final void fU(long j) {
        if (this.yns != null) {
            this.yns.remove(String.valueOf(j));
        }
    }
}

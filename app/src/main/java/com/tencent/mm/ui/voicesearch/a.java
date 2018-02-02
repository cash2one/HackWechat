package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.applet.b$b;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends o<ae> {
    private com.tencent.mm.ui.applet.b hvU = new com.tencent.mm.ui.applet.b(new 1(this));
    private b$b hvV = null;
    private String ilo;
    protected List<String> kiU = null;
    private boolean yWF = true;
    private ColorStateList[] ynr = new ColorStateList[2];
    private HashMap<String, a> yns;
    private b zqs;

    public interface b {
    }

    public static class c {
        public ImageView iip;
        public TextView kBH;
        public TextView kBI;
        public TextView kBJ;
        public TextView kBL;
        public ImageView ynA;
        public ImageView ynz;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
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
        } else {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
        }
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xIi = aVar;
        this.ynr[0] = com.tencent.mm.bv.a.Z(context, R.e.btk);
        this.ynr[1] = com.tencent.mm.bv.a.Z(context, R.e.btl);
        this.yns = new HashMap();
    }

    public final void dr(List<String> list) {
        this.kiU = list;
        a(null, null);
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
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
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchConversationAdapter", "block user " + string);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = ar.Hg().heA.a(this.ilo, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.zqs == null || this.ilo == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        a aVar2;
        CharSequence string;
        int textSize;
        int FW;
        String str;
        Object obj;
        int i3;
        com.tencent.mm.sdk.b.b riVar;
        if (this.hvV == null) {
            this.hvV = new b$b(this) {
                final /* synthetic */ a zqt;

                {
                    this.zqt = r1;
                }

                public final String hC(int i) {
                    if (i < 0 || i >= this.zqt.getCount()) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        return null;
                    }
                    ae aeVar = (ae) this.zqt.getItem(i);
                    return aeVar == null ? null : aeVar.field_username;
                }

                public final int NJ() {
                    return this.zqt.getCount();
                }
            };
        }
        if (this.hvU != null) {
            this.hvU.a(i, this.hvV);
        }
        ae aeVar = (ae) getItem(i);
        if (vP(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !t.ov(aeVar.field_content)) {
            String str2 = aeVar.field_content;
            if (aeVar.field_username.equals("qmessage") || aeVar.field_username.equals("floatbottle")) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str2).hVA) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, R.i.drr, null);
                    cVar.iip = (ImageView) view.findViewById(R.h.bLL);
                    cVar.kBH = (TextView) view.findViewById(R.h.cAn);
                    cVar.kBI = (TextView) view.findViewById(R.h.cTR);
                    cVar.kBJ = (TextView) view.findViewById(R.h.csx);
                    cVar.kBL = (TextView) view.findViewById(R.h.cRX);
                    cVar.kBL.setBackgroundResource(com.tencent.mm.ui.tools.s.gd(this.context));
                    cVar.ynz = (ImageView) view.findViewById(R.h.cpt);
                    cVar.ynA = (ImageView) view.findViewById(R.h.cQy);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.yns.get(aeVar.field_username + aeVar.field_content);
                if (aVar == null) {
                    aVar2 = new a(this, (byte) 0);
                    aVar2.nickName = i.b(this.context, r.gu(aeVar.field_username), cVar.kBH.getTextSize());
                    string = aeVar.field_status != 1 ? this.context.getString(R.l.euA) : aeVar.field_conversationTime != Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(this.context, aeVar.field_conversationTime, true);
                    aVar2.yXa = string;
                    textSize = (int) cVar.kBJ.getTextSize();
                    FW = q.FW();
                    str = aeVar.field_username;
                    ar.Hg();
                    obj = t.e((Integer) com.tencent.mm.z.c.CU().get(17, null)) != 1 ? 1 : null;
                    if (str.equals("qqmail") || obj != null) {
                        ar.Hg();
                        bc EY = com.tencent.mm.z.c.Fg().EY("@t.qq.com");
                        obj = (EY == null && EY.isEnable()) ? 1 : null;
                        if (str.equals("tmessage") || obj != null) {
                            string = (str.equals("qmessage") || ((FW & 64) == 0 ? 1 : null) != null) ? i.c(this.context, h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.context), textSize) : this.context.getString(R.l.eMu);
                        } else {
                            string = this.context.getString(R.l.eMu);
                        }
                    } else {
                        string = this.context.getString(R.l.eMu);
                    }
                    aVar2.yXb = string;
                    if (s.eV(aeVar.field_username) && m.gl(aeVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(R.l.dSN);
                    }
                    switch (aeVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.k.dze;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.k.dzd;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.yXc = i3;
                    this.yns.put(aeVar.field_username + aeVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.kBJ.setTextColor(this.ynr[i2]);
                cVar.kBH.setText(aVar.nickName);
                cVar.kBI.setText(aVar.yXa);
                cVar.kBJ.setText(i.b(this.context, aVar.yXb.toString(), cVar.kBJ.getTextSize()));
                if (aeVar.field_conversationTime != 0) {
                    cVar.kBI.setVisibility(8);
                } else {
                    cVar.kBI.setVisibility(0);
                }
                cVar.ynz.setVisibility(8);
                if (s.eV(aeVar.field_username)) {
                    ar.Hg();
                    af WO = com.tencent.mm.z.c.EY().WO(aeVar.field_username);
                    if (WO != null && WO.fWn == 0) {
                        cVar.ynz.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.iip, aeVar.field_username);
                if (this.yWF) {
                    if (aeVar.field_unReadCount > 100) {
                        cVar.kBL.setText("...");
                        cVar.kBL.setVisibility(0);
                    } else if (aeVar.field_unReadCount <= 0) {
                        cVar.kBL.setText(aeVar.field_unReadCount);
                        cVar.kBL.setVisibility(0);
                    } else {
                        cVar.kBL.setVisibility(4);
                    }
                }
                if (ar.Hj()) {
                    if (!s.a(aeVar)) {
                        ar.Hg();
                        if (com.tencent.mm.z.c.Fd().g(aeVar)) {
                            ar.Hg();
                            com.tencent.mm.z.c.Fd().f(aeVar);
                        }
                    }
                    ar.Hg();
                    if (com.tencent.mm.z.c.Fd().g(aeVar)) {
                        view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
                    } else {
                        view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
                    }
                }
                riVar = new ri();
                riVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(riVar.fJd.fJg))) {
                    aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().a(aeVar, aeVar.field_username);
                }
                if (q$a.vcp == null && q$a.vcp.Mr(aeVar.field_username)) {
                    cVar.ynA.setVisibility(0);
                    if (aeVar.field_username.equals(riVar.fJd.fJg)) {
                        cVar.ynA.setImageResource(R.k.dBa);
                    } else {
                        cVar.ynA.setImageResource(R.k.dAZ);
                    }
                } else {
                    cVar.ynA.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c();
            view = View.inflate(this.context, R.i.drr, null);
            cVar.iip = (ImageView) view.findViewById(R.h.bLL);
            cVar.kBH = (TextView) view.findViewById(R.h.cAn);
            cVar.kBI = (TextView) view.findViewById(R.h.cTR);
            cVar.kBJ = (TextView) view.findViewById(R.h.csx);
            cVar.kBL = (TextView) view.findViewById(R.h.cRX);
            cVar.kBL.setBackgroundResource(com.tencent.mm.ui.tools.s.gd(this.context));
            cVar.ynz = (ImageView) view.findViewById(R.h.cpt);
            cVar.ynA = (ImageView) view.findViewById(R.h.cQy);
            view.setTag(cVar);
        }
        aVar = (a) this.yns.get(aeVar.field_username + aeVar.field_content);
        if (aVar == null) {
            aVar2 = new a(this, (byte) 0);
            aVar2.nickName = i.b(this.context, r.gu(aeVar.field_username), cVar.kBH.getTextSize());
            if (aeVar.field_status != 1) {
                if (aeVar.field_conversationTime != Long.MAX_VALUE) {
                }
            }
            aVar2.yXa = string;
            textSize = (int) cVar.kBJ.getTextSize();
            FW = q.FW();
            str = aeVar.field_username;
            ar.Hg();
            if (t.e((Integer) com.tencent.mm.z.c.CU().get(17, null)) != 1) {
            }
            if (str.equals("qqmail")) {
            }
            ar.Hg();
            bc EY2 = com.tencent.mm.z.c.Fg().EY("@t.qq.com");
            if (EY2 == null) {
            }
            if (str.equals("tmessage")) {
            }
            if ((FW & 64) == 0) {
            }
            if (str.equals("qmessage")) {
            }
            aVar2.yXb = string;
            aVar2.nickName = this.context.getString(R.l.dSN);
            switch (aeVar.field_status) {
                case 0:
                    i3 = -1;
                    break;
                case 1:
                    i3 = R.k.dze;
                    break;
                case 2:
                    i3 = -1;
                    break;
                case 5:
                    i3 = R.k.dzd;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            aVar2.yXc = i3;
            this.yns.put(aeVar.field_username + aeVar.field_content, aVar2);
            aVar = aVar2;
        }
        cVar.kBJ.setTextColor(this.ynr[i2]);
        cVar.kBH.setText(aVar.nickName);
        cVar.kBI.setText(aVar.yXa);
        cVar.kBJ.setText(i.b(this.context, aVar.yXb.toString(), cVar.kBJ.getTextSize()));
        if (aeVar.field_conversationTime != 0) {
            cVar.kBI.setVisibility(0);
        } else {
            cVar.kBI.setVisibility(8);
        }
        cVar.ynz.setVisibility(8);
        if (s.eV(aeVar.field_username)) {
            ar.Hg();
            af WO2 = com.tencent.mm.z.c.EY().WO(aeVar.field_username);
            cVar.ynz.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.iip, aeVar.field_username);
        if (this.yWF) {
            if (aeVar.field_unReadCount > 100) {
                cVar.kBL.setText("...");
                cVar.kBL.setVisibility(0);
            } else if (aeVar.field_unReadCount <= 0) {
                cVar.kBL.setVisibility(4);
            } else {
                cVar.kBL.setText(aeVar.field_unReadCount);
                cVar.kBL.setVisibility(0);
            }
        }
        if (ar.Hj()) {
            if (s.a(aeVar)) {
                ar.Hg();
                if (com.tencent.mm.z.c.Fd().g(aeVar)) {
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().f(aeVar);
                }
            }
            ar.Hg();
            if (com.tencent.mm.z.c.Fd().g(aeVar)) {
                view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
            } else {
                view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
            }
        }
        riVar = new ri();
        riVar.fJc.fJe = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(aeVar, aeVar.field_username);
        if (q$a.vcp == null) {
        }
        cVar.ynA.setVisibility(8);
        return view;
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

    public final void a(String str, l lVar) {
        if (str != null && !str.equals("") && this.yns != null) {
            this.yns.remove(str);
        } else if (this.yns != null) {
            this.yns.clear();
        }
        super.a(str, lVar);
    }

    public final void CN(String str) {
        this.ilo = str;
        aUn();
        Xy();
    }
}

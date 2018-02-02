package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ag.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a extends f<String, com.tencent.mm.storage.f> implements b {
    public static final ColorStateList nPr = com.tencent.mm.bv.a.Z(ac.getContext(), R.e.bth);
    public static final ColorStateList nPs = com.tencent.mm.bv.a.Z(ac.getContext(), R.e.bsO);
    com.tencent.mm.ui.applet.b hvU = null;
    private String ilo = "";
    protected MMSlideDelView.f kBC;
    protected MMSlideDelView$c kBD;
    protected d kBF = MMSlideDelView.cpx();
    private boolean kFT = false;
    protected List<String> kiU = null;
    OnClickListener mtg = new 1(this);
    protected e oPr;
    StringBuilder sb = new StringBuilder(32);
    private int type;
    public HashMap<String, com.tencent.mm.storage.f> yPH = new HashMap();
    protected String yPI = null;
    protected String yPJ = null;
    private List<Object> yPK;
    private List<String> yPL;
    private int yPM = 0;
    protected int[] yPN;
    String[] yPO;
    protected com.tencent.mm.ui.contact.AddressUI.a yPP;
    private Set<Integer> yPQ = new HashSet();
    private int yPR = 0;
    private boolean yPS = true;
    a yPT;
    private boolean yPU = false;
    boolean yPV = false;
    private String yPW;
    LinkedList<View> yPX = new LinkedList();
    boolean yPY;
    HashMap<View, ViewStub> yPZ = new HashMap();
    private SparseArray<String> yQa = new SparseArray();
    private SparseArray<Integer> yQb = new SparseArray();
    private HashSet<String> yQc = new HashSet();
    private String[] ynf = null;

    public final /* synthetic */ com.tencent.mm.by.a.a ckX() {
        return new com.tencent.mm.storage.f();
    }

    public final /* synthetic */ void p(Object obj, int i) {
        dq((String) obj, i);
    }

    public final void dq(String str, int i) {
        if (i == 5) {
            this.yQc.add(str);
        }
        super.p(str, i);
    }

    public final void pause() {
        this.yQc.clear();
        super.pause();
    }

    public final void notifyDataSetChanged() {
        this.yPW = q.FS();
        if (this.yPN == null) {
            cvF();
        }
        if (getCount() != 0) {
            this.yPR = clW();
            x.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[]{Integer.valueOf(this.yPR)});
            super.notifyDataSetChanged();
        }
    }

    public a(Context context, String str, String str2, int i) {
        super(context);
        this.context = context;
        this.yPI = str;
        this.yPJ = str2;
        this.type = i;
        this.yPU = true;
        this.yPK = new LinkedList();
        this.yPL = new LinkedList();
        this.yPW = q.FS();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    }

    public final void l(Fragment fragment) {
        this.yPP = (com.tencent.mm.ui.contact.AddressUI.a) fragment;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.oPr = eVar;
    }

    public final void a(MMSlideDelView$c mMSlideDelView$c) {
        this.kBD = mMSlideDelView$c;
    }

    public final void dr(List<String> list) {
        if (this.type != 2) {
            list.add(q.FS());
        }
        ar.Hg();
        bc EY = c.Fg().EY("@t.qq.com");
        if (EY != null) {
            list.add(EY.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : s.GC()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.kiU = list;
    }

    public final int getPositionForSection(int i) {
        if (this.yPN != null && i >= 0 && i < this.yPN.length) {
            i = this.yPN[i];
        }
        return this.yPR + i;
    }

    private boolean cvE() {
        return this.yPI.equals("@micromsg.qq.com") || this.yPI.equals("@all.contact.without.chatroom");
    }

    protected final void cvF() {
        int count = getCount();
        if (count != 0) {
            int i;
            int i2;
            this.yPR = clW();
            if (this.ynf != null) {
                this.yPN = s.a(this.yPI, this.yPJ, this.kiU, this.ynf);
                this.yPO = s.a(this.yPI, this.yPJ, this.ynf, this.kiU);
            } else if (ckP()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashSet hashSet = new HashSet();
                this.yPN = new int[30];
                this.yPO = new String[30];
                i = this.yPR;
                int i3 = 0;
                while (i < count) {
                    com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) DC(i);
                    if (fVar != null) {
                        String b = b(fVar, i);
                        if (hashSet.add(b)) {
                            this.yPN[i3] = i - this.yPR;
                            this.yPO[i3] = b;
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    } else {
                        x.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                        i2 = i3;
                    }
                    i++;
                    i3 = i2;
                }
                x.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.yPR);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.yPN = s.b(this.yPI, this.yPJ, this.kiU, this.ilo);
                this.yPO = s.a(this.yPI, this.yPJ, this.ilo, this.kiU);
                x.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            this.yPQ.clear();
            for (int i4 : this.yPN) {
                this.yPQ.add(Integer.valueOf(i4 - 1));
            }
        }
    }

    public final void cvG() {
        this.kBF.aUz();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2 = -1;
        if (!this.yPY) {
            for (int i3 = 0; i3 < 8; i3++) {
                this.yPX.add(v.fv(this.context).inflate(R.i.dac, null));
            }
            this.yPY = true;
        }
        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) DC(i);
        if (view == null) {
            View view2;
            if (this.yPX.size() > 0) {
                View view3 = (View) this.yPX.getFirst();
                this.yPX.removeFirst();
                view2 = view3;
            } else {
                view2 = View.inflate(this.context, R.i.dac, null);
            }
            bVar = new b();
            bVar.nJd = (TextView) view2.findViewById(R.h.bYz);
            bVar.nJe = (TextView) view2.findViewById(R.h.bYE);
            bVar.nPw = (AddressView) view2.findViewById(R.h.cyz);
            bVar.yQe = (TextView) view2.findViewById(R.h.bYw);
            bVar.yQf = view2.findViewById(R.h.bYD);
            LayoutParams layoutParams = bVar.yQf.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bv.a.ab(this.context, R.f.buA)) * com.tencent.mm.bv.a.ex(this.context));
            bVar.yQf.setLayoutParams(layoutParams);
            this.yPP.kZW.a(bVar.nPw);
            view2.setTag(bVar);
            view = view2;
        } else {
            bVar = (b) view.getTag();
        }
        if (fVar != null) {
            CharSequence b;
            String gP;
            Context context;
            long longValue;
            String str;
            Object obj;
            com.tencent.mm.storage.f fVar2 = (com.tencent.mm.storage.f) DC(i - 1);
            com.tencent.mm.storage.f fVar3 = (com.tencent.mm.storage.f) DC(i + 1);
            int a = fVar2 == null ? -1 : a(fVar2, i - 1);
            int a2 = a(fVar, i);
            if (fVar3 != null) {
                i2 = a(fVar3, i + 1);
            }
            if (this.yPS) {
                if (i == 0) {
                    b = b(fVar, i);
                    if (!t.ov(b)) {
                        bVar.nJd.setVisibility(0);
                        bVar.nJd.setText(b);
                        if (!this.yPS || a2 == r3) {
                            bVar.yQf.setBackgroundResource(R.g.bDp);
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nPw, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.nPw.setMaskBitmap(null);
                        } else if (com.tencent.mm.z.ak.a.hfN != null) {
                            gP = com.tencent.mm.z.ak.a.hfN.gP(fVar.field_verifyFlag);
                            if (gP != null) {
                                bVar.nPw.setMaskBitmap(m.kf(gP));
                            } else {
                                bVar.nPw.setMaskBitmap(null);
                            }
                        } else {
                            bVar.nPw.setMaskBitmap(null);
                        }
                        bVar.nPw.updateTextColors();
                        b = fVar.xmu;
                        if (b == null) {
                            try {
                                context = this.context;
                                if (fVar.field_conRemark != null || fVar.field_conRemark.trim().equals("")) {
                                    b = com.tencent.mm.l.a.fa(fVar.field_username);
                                    if (b == null) {
                                        if (fVar.field_nickname != null || fVar.field_nickname.length() <= 0) {
                                            b = fVar.field_alias;
                                            if (bh.ov(b)) {
                                                b = fVar.field_username;
                                                if (b != null) {
                                                    b = null;
                                                } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                                    b = "@" + b.replace("@t.qq.com", "");
                                                } else if (b.toLowerCase().endsWith("@qqim")) {
                                                    b = b.replace("@qqim", "");
                                                    longValue = Long.valueOf(b).longValue();
                                                    if (longValue < 0) {
                                                        b = new o(longValue).toString();
                                                    }
                                                }
                                                if (b == null || b.length() == 0) {
                                                    b = fVar.field_username;
                                                }
                                            }
                                        } else {
                                            b = fVar.field_nickname;
                                        }
                                    }
                                } else {
                                    b = fVar.field_conRemark;
                                }
                                str = fVar.field_username;
                                if (b == null || b.length() <= 0) {
                                    obj = str;
                                }
                                str = "";
                                if (str.length() > 0 && !str.equals(b)) {
                                    this.sb.append(b);
                                    this.sb.append("(");
                                    this.sb.append(str);
                                    this.sb.append(")");
                                    b = this.sb.toString();
                                    this.sb.delete(0, this.sb.length());
                                }
                                b = i.c(context, b, com.tencent.mm.bv.a.aa(this.context, R.f.bvK));
                            } catch (Exception e) {
                                b = null;
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.nPw.setName(b);
                        } else {
                            bVar.nPw.setName(b);
                        }
                        bVar.nPw.setDescription(t.ou(fVar.field_remarkDesc));
                    }
                } else if (i > 0 && a2 != a) {
                    b = b(fVar, i);
                    if (!t.ov(b)) {
                        bVar.nJd.setVisibility(0);
                        bVar.nJd.setText(b);
                        bVar.yQf.setBackgroundResource(R.g.bDp);
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nPw, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.nPw.setMaskBitmap(null);
                        } else if (com.tencent.mm.z.ak.a.hfN != null) {
                            bVar.nPw.setMaskBitmap(null);
                        } else {
                            gP = com.tencent.mm.z.ak.a.hfN.gP(fVar.field_verifyFlag);
                            if (gP != null) {
                                bVar.nPw.setMaskBitmap(null);
                            } else {
                                bVar.nPw.setMaskBitmap(m.kf(gP));
                            }
                        }
                        bVar.nPw.updateTextColors();
                        b = fVar.xmu;
                        if (b == null) {
                            bVar.nPw.setName(b);
                        } else {
                            context = this.context;
                            if (fVar.field_conRemark != null) {
                            }
                            b = com.tencent.mm.l.a.fa(fVar.field_username);
                            if (b == null) {
                                if (fVar.field_nickname != null) {
                                }
                                b = fVar.field_alias;
                                if (bh.ov(b)) {
                                    b = fVar.field_username;
                                    if (b != null) {
                                        b = null;
                                    } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                        b = "@" + b.replace("@t.qq.com", "");
                                    } else if (b.toLowerCase().endsWith("@qqim")) {
                                        b = b.replace("@qqim", "");
                                        longValue = Long.valueOf(b).longValue();
                                        if (longValue < 0) {
                                            b = new o(longValue).toString();
                                        }
                                    }
                                    b = fVar.field_username;
                                }
                            }
                            str = fVar.field_username;
                            obj = str;
                            str = "";
                            this.sb.append(b);
                            this.sb.append("(");
                            this.sb.append(str);
                            this.sb.append(")");
                            b = this.sb.toString();
                            this.sb.delete(0, this.sb.length());
                            b = i.c(context, b, com.tencent.mm.bv.a.aa(this.context, R.f.bvK));
                            if (b == null) {
                                b = "";
                            }
                            bVar.nPw.setName(b);
                        }
                        bVar.nPw.setDescription(t.ou(fVar.field_remarkDesc));
                    }
                }
            }
            bVar.nJd.setVisibility(8);
            bVar.yQf.setBackgroundResource(R.g.bDp);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nPw, fVar.field_username);
            if (fVar.field_verifyFlag != 0) {
                bVar.nPw.setMaskBitmap(null);
            } else if (com.tencent.mm.z.ak.a.hfN != null) {
                gP = com.tencent.mm.z.ak.a.hfN.gP(fVar.field_verifyFlag);
                if (gP != null) {
                    bVar.nPw.setMaskBitmap(m.kf(gP));
                } else {
                    bVar.nPw.setMaskBitmap(null);
                }
            } else {
                bVar.nPw.setMaskBitmap(null);
            }
            bVar.nPw.updateTextColors();
            b = fVar.xmu;
            if (b == null) {
                context = this.context;
                if (fVar.field_conRemark != null) {
                }
                b = com.tencent.mm.l.a.fa(fVar.field_username);
                if (b == null) {
                    if (fVar.field_nickname != null) {
                    }
                    b = fVar.field_alias;
                    if (bh.ov(b)) {
                        b = fVar.field_username;
                        if (b != null) {
                            b = null;
                        } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                            b = "@" + b.replace("@t.qq.com", "");
                        } else if (b.toLowerCase().endsWith("@qqim")) {
                            b = b.replace("@qqim", "");
                            longValue = Long.valueOf(b).longValue();
                            if (longValue < 0) {
                                b = new o(longValue).toString();
                            }
                        }
                        b = fVar.field_username;
                    }
                }
                str = fVar.field_username;
                obj = str;
                str = "";
                this.sb.append(b);
                this.sb.append("(");
                this.sb.append(str);
                this.sb.append(")");
                b = this.sb.toString();
                this.sb.delete(0, this.sb.length());
                b = i.c(context, b, com.tencent.mm.bv.a.aa(this.context, R.f.bvK));
                if (b == null) {
                    b = "";
                }
                bVar.nPw.setName(b);
            } else {
                bVar.nPw.setName(b);
            }
            bVar.nPw.setDescription(t.ou(fVar.field_remarkDesc));
        }
        bVar.nPw.updatePositionFlag();
        bVar.nPw.setContentDescription(bVar.nPw.getNickName() == null ? "" : bVar.nPw.getNickName().toString());
        return view;
    }

    private int a(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.yPR) {
            return 32;
        }
        if (fVar != null) {
            return fVar.field_showHead;
        }
        x.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[]{Integer.valueOf(i)});
        return -1;
    }

    private String b(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.yPR) {
            return getString(R.l.dCV);
        }
        if (fVar.field_showHead == 31) {
            return "";
        }
        if (fVar.field_showHead == 123) {
            return "#";
        }
        if (fVar.field_showHead == 33) {
            return getString(R.l.dCJ);
        }
        if (fVar.field_showHead == 43) {
            return getString(R.l.eFx);
        }
        if (fVar.field_showHead == 32) {
            return getString(R.l.dCV);
        }
        String str = (String) this.yQa.get(fVar.field_showHead);
        if (str != null) {
            return str;
        }
        str = String.valueOf((char) fVar.field_showHead);
        this.yQa.put(fVar.field_showHead, str);
        return str;
    }

    public final int getCount() {
        return super.getCount();
    }

    private String getString(int i) {
        String str = (String) this.yQa.get(i);
        if (str != null) {
            return str;
        }
        str = this.context.getString(i);
        this.yQa.put(i, str);
        return str;
    }

    public final com.tencent.mm.by.a.d<String> clX() {
        long currentTimeMillis = System.currentTimeMillis();
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        ar.Hg();
        Cursor a = c.EY().a(this.yPI, this.yPJ, this.kiU, linkedList, cvE(), this.yPU);
        x.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return (com.tencent.mm.by.a.d) a;
    }

    public final ArrayList<com.tencent.mm.storage.f> ah(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add((String) arrayList.get(i));
        }
        ArrayList<com.tencent.mm.storage.f> arrayList3 = new ArrayList(arrayList2.size());
        ar.Hg();
        Cursor cJ = c.EY().cJ(arrayList2);
        while (cJ.moveToNext()) {
            com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
            fVar.b(cJ);
            arrayList3.add(fVar);
        }
        cJ.close();
        x.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        Cursor b = c.EY().b(this.yPI, this.yPJ, this.kiU, linkedList, cvE(), this.yPU);
        int i;
        if (b instanceof com.tencent.mm.by.a.e) {
            com.tencent.mm.by.a.d[] dVarArr = ((com.tencent.mm.by.a.e) b).xBR;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].DD(5000);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.yPR = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        x.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        return sparseArrayArr2;
    }

    public final void cvH() {
        super.p(null, 1);
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        ar.Hg();
        if (mVar != c.EY()) {
            return;
        }
        if (s.gD((String) obj) || this.yQc.contains((String) obj)) {
            x.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            return;
        }
        super.p((String) obj, 2);
        if (this.yPV && this.yPP != null) {
            this.yPP.yQy = true;
            x.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
        }
    }
}

package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h extends BaseAdapter {
    public static int vnG = 44;
    public static int vnH = 5;
    private List<String> fAN = new ArrayList();
    boolean fzz;
    q kZS;
    boolean lbP;
    c lcT = null;
    private Context mContext;
    String username;
    a vnI;
    private ArrayList<x> vnJ = new ArrayList();
    boolean vnK = false;
    public boolean vnL = false;
    public boolean vnM = false;
    private List<x> vnN = new ArrayList();
    private List<Object> vnO = new ArrayList();
    private Set<String> vnP = new HashSet();
    int vnQ = 0;
    int vnR = 0;
    d vnS;
    public boolean vnT = false;
    public boolean vnU = false;
    public boolean vnV = false;
    private boolean vnW = true;
    boolean vnX = false;
    int vnY = 12;
    String vnZ;
    private final int voa;
    public boolean vob = false;
    private boolean voc = true;
    private boolean vod = false;
    boolean voe = true;
    public boolean vof = false;

    public h(Context context) {
        this.mContext = context;
        this.lbP = false;
        this.voa = context.getResources().getDimensionPixelSize(a.c.buo);
    }

    public final boolean caV() {
        if (this.vnK) {
            return this.vnM;
        }
        return s.eV(this.username);
    }

    public final void bS(List<String> list) {
        this.vnW = true;
        this.fAN = list;
    }

    public final void ac(ArrayList<x> arrayList) {
        this.vnW = false;
        this.vnJ = arrayList;
    }

    private void caW() {
        if (this.vnJ != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.vnJ.size()));
            this.vnP.clear();
            this.vnN.clear();
            if (this.vnJ.size() > 0) {
                Iterator it = this.vnJ.iterator();
                while (it.hasNext()) {
                    x xVar = (x) it.next();
                    this.vnN.add(xVar);
                    this.vnP.add(xVar.field_username);
                }
            }
            this.vnR = this.vnN.size();
        }
    }

    public final boolean BZ(int i) {
        if (this.lbP) {
            return false;
        }
        if (i >= this.vnR) {
            return true;
        }
        this.lbP = true;
        bXG();
        return true;
    }

    private void bXG() {
        if (this.vnI != null) {
            this.vnI.bXG();
        }
    }

    private b db(View view) {
        b bVar = new b(this);
        bVar.vog = (ImageView) view.findViewById(e.cIk);
        bVar.iip = (ImageView) view.findViewById(e.cIt);
        bVar.qlw = (ImageView) view.findViewById(e.lnQ);
        bVar.kBH = (TextView) view.findViewById(e.lnS);
        bVar.lcV = (TextView) view.findViewById(e.cIs);
        bVar.kBK = (ImageView) view.findViewById(e.lnR);
        bVar.iip.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(bVar);
        return bVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        af afVar;
        int i2;
        b db;
        int dimensionPixelSize;
        if (i < this.vnR) {
            if (this.vnK) {
                item = getItem(i);
                afVar = null;
                i2 = 0;
            } else {
                item = null;
                afVar = (x) getItem(i);
                i2 = 0;
            }
        } else if (i == this.vnR && this.vnU) {
            item = null;
            afVar = null;
            i2 = 3;
        } else if (i == this.vnR + 1 && this.vnT) {
            item = null;
            afVar = null;
            i2 = 4;
        } else if (i == this.vnR + 1 && this.vnV && !this.vnT) {
            item = null;
            afVar = null;
            i2 = 5;
        } else if (i == this.vnR + 2 && this.vnV && this.vnT) {
            item = null;
            afVar = null;
            i2 = 5;
        } else {
            item = null;
            afVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, f.dqQ, null);
            db = db(view);
        } else {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                db = db(view);
            } else {
                db = bVar;
            }
        }
        if (vnH == 4 || this.vof) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.c.bvF);
            db.iip.getLayoutParams().height = dimensionPixelSize;
            db.iip.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.c.bvD);
            db.iip.getLayoutParams().height = dimensionPixelSize;
            db.iip.getLayoutParams().width = dimensionPixelSize;
        }
        db.vog.setVisibility(8);
        if (i2 == 0) {
            CharSequence gu;
            db.iip.setVisibility(0);
            if (this.fzz) {
                if (bh.ov(afVar.field_conRemark)) {
                    String str = afVar.field_username;
                    if (this.kZS == null) {
                        Object obj = null;
                    } else {
                        gu = this.kZS.gu(str);
                    }
                } else {
                    gu = afVar.field_conRemark;
                }
                if (bh.ov(gu)) {
                    gu = afVar.field_conRemark;
                }
                if (bh.ov(gu)) {
                    gu = afVar.AP();
                }
                gu = i.b(this.mContext, gu, db.kBH.getTextSize());
            } else if (this.vnK) {
                gu = i.b(this.mContext, n.a.vos.bP(item), db.kBH.getTextSize());
            } else {
                gu = i.b(this.mContext, afVar.AQ(), db.kBH.getTextSize());
            }
            if (gu instanceof SpannableString) {
                db.kBH.setVisibility(8);
                db.lcV.setVisibility(0);
                db.lcV.setText(gu);
            } else {
                db.kBH.setVisibility(0);
                db.lcV.setVisibility(8);
                db.kBH.setText(gu);
            }
            db.iip.setContentDescription("");
            if (this.vnK) {
                o.PA().a(n.a.vos.bQ(item), db.iip, this.lcT);
                db.iip.setBackgroundDrawable(null);
            } else {
                b.a(db.iip, afVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) db.iip.getDrawable();
                if (this.vnS != null) {
                    this.vnS.a(aVar);
                }
            }
            if (this.vnK) {
                if (!this.lbP || (this.vnZ != null && this.vnZ.equals(n.a.vos.bR(item)))) {
                    db.qlw.setVisibility(8);
                } else {
                    db.qlw.setVisibility(0);
                }
            } else if (!this.lbP || (this.vnZ != null && this.vnZ.equals(afVar.field_username))) {
                db.qlw.setVisibility(8);
            } else {
                db.qlw.setVisibility(0);
            }
        } else if (i2 == 3) {
            db.kBH.setVisibility(i == 0 ? 8 : 4);
            r6 = db.lcV;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            db.qlw.setVisibility(8);
            if (this.lbP) {
                db.iip.setVisibility(4);
            } else {
                db.iip.setVisibility(0);
                if (this.vnK) {
                    o.PA().a("", db.iip, this.lcT);
                    db.iip.setBackgroundDrawable(null);
                }
                db.iip.setImageResource(a.d.bzk);
                db.iip.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.lop));
            }
        } else if (i2 == 4) {
            db.kBH.setVisibility(1 == i ? 8 : 4);
            r6 = db.lcV;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            db.qlw.setVisibility(8);
            if (this.lbP || this.vnR == 0) {
                db.iip.setVisibility(4);
            } else {
                db.iip.setVisibility(0);
                if (this.vnK) {
                    o.PA().a("", db.iip, this.lcT);
                    db.iip.setBackgroundDrawable(null);
                }
                db.iip.setImageResource(a.d.bzl);
                db.iip.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.low));
            }
        } else if (i2 == 5) {
            r6 = db.kBH;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            r6 = db.lcV;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            db.qlw.setVisibility(8);
            if (this.lbP) {
                db.iip.setVisibility(4);
            } else {
                db.iip.setVisibility(0);
                if (this.vnK) {
                    o.PA().a("", db.iip, this.lcT);
                    db.iip.setBackgroundDrawable(null);
                }
                db.iip.setImageResource(a.d.lnK);
                db.iip.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.lpd));
            }
        } else if (i2 == 2) {
            if (this.vnK) {
                o.PA().a("", db.iip, this.lcT);
            }
            db.kBH.setVisibility(4);
            db.lcV.setVisibility(4);
            db.qlw.setVisibility(8);
            db.iip.setVisibility(4);
            db.iip.setImageResource(a.d.bDJ);
            db.iip.setBackgroundResource(a.d.bDJ);
        }
        if (!this.vnK || item == null) {
            db.kBK.setVisibility(8);
        }
        db.kTK = i2;
        return view;
    }

    public final boolean Ca(int i) {
        return i < this.vnR;
    }

    public final void notifyChanged() {
        if (this.fAN != null || this.vnJ != null) {
            if (!this.vnW) {
                caW();
            } else if (this.fAN != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.fAN.size()));
                this.vnP.clear();
                this.vnN.clear();
                this.vnO.clear();
                if (this.fAN.size() > 0) {
                    String str;
                    x xVar;
                    for (String str2 : this.fAN) {
                        if (this.vnK) {
                            this.vnO.add(n.a.vos.Sn(str2));
                        } else {
                            af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str2);
                            if (WO == null || bh.ov(WO.field_username) || !WO.field_username.equals(str2)) {
                                this.vnN.add(new x(this.username));
                            } else {
                                this.vnN.add(WO);
                            }
                        }
                        this.vnP.add(str2);
                    }
                    if (this.voc && !bh.ov(this.vnZ) && this.fAN.contains(this.vnZ)) {
                        if (!this.vnK) {
                            for (x xVar2 : this.vnN) {
                                if (this.vnZ.equals(xVar2.field_username)) {
                                    this.vnN.remove(xVar2);
                                    this.vnN.add(0, xVar2);
                                    break;
                                }
                            }
                        }
                        for (Object next : this.vnO) {
                            if (this.vnZ.equals(n.a.vos.bR(next))) {
                                this.vnO.remove(next);
                                this.vnO.add(0, next);
                                break;
                            }
                        }
                    }
                    if (this.vod && !this.vnK) {
                        String az = bh.az((String) g.Dj().CU().get(2, null), "");
                        if (this.fAN.contains(az)) {
                            this.vnP.remove(az);
                            for (x xVar22 : this.vnN) {
                                if (az.equals(xVar22.field_username)) {
                                    this.vnN.remove(xVar22);
                                    break;
                                }
                            }
                        }
                        af WO2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(az);
                        if (WO2 == null || bh.ov(WO2.field_username) || !WO2.field_username.equals(az)) {
                            this.vnN.add(1, new x(az));
                        } else {
                            this.vnN.add(1, WO2);
                        }
                        this.vnP.add(az);
                        if (this.voe && this.vnN.size() >= 3) {
                            int size = this.vnN.size();
                            LinkedList linkedList = new LinkedList();
                            for (int i = 0; i < size; i++) {
                                xVar22 = (x) this.vnN.get(i);
                                if (xVar22.field_showHead > 0) {
                                    linkedList.add(xVar22.field_showHead);
                                } else if (!bh.ov(xVar22.field_conRemark)) {
                                    linkedList.add(xVar22.field_conRemark);
                                } else if (!bh.ov(xVar22.field_conRemarkPYShort)) {
                                    linkedList.add(xVar22.field_conRemarkPYShort);
                                } else if (!bh.ov(xVar22.field_conRemarkPYFull)) {
                                    linkedList.add(xVar22.field_conRemarkPYFull);
                                } else if (!bh.ov(xVar22.vQ())) {
                                    linkedList.add(xVar22.vQ());
                                } else if (!bh.ov(xVar22.field_username)) {
                                    linkedList.add(xVar22.field_username);
                                }
                            }
                            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", linkedList.toString());
                            List arrayList = new ArrayList();
                            arrayList.add(this.vnN.get(0));
                            arrayList.add(this.vnN.get(1));
                            List linkedList2 = new LinkedList();
                            linkedList2.add(linkedList.get(0));
                            linkedList2.add(linkedList.get(0));
                            int size2 = this.vnN.size();
                            for (int i2 = 2; i2 < size2; i2++) {
                                str2 = (String) linkedList.get(i2);
                                int size3 = arrayList.size();
                                int i3 = 1;
                                while (i3 < size3 && str2.compareToIgnoreCase((String) linkedList2.get(i3)) >= 0) {
                                    i3++;
                                }
                                linkedList2.add(i3, str2);
                                arrayList.add(i3, this.vnN.get(i2));
                            }
                            this.vnN.clear();
                            this.vnN = arrayList;
                        }
                    }
                }
                if (this.vnK) {
                    this.vnR = this.vnO.size();
                } else if (!this.fzz) {
                    this.vnR = this.vnN.size();
                } else if (bh.ov(this.vnZ) || !(this.vnZ == null || this.vnZ.equals(com.tencent.mm.z.q.FS()))) {
                    this.vnR = this.vnN.size() >= vnG ? vnG : this.vnN.size();
                } else {
                    this.vnR = this.vnN.size() >= vnG + -1 ? vnG - 1 : this.vnN.size();
                }
            }
            if (this.vnR == 0) {
                this.vnQ = vnH;
            } else if (this.vnU && this.vnT && this.vnV) {
                this.vnQ = (((this.vnR + 2) / vnH) + 1) * vnH;
            } else if ((this.vnU && this.vnT && !this.vnV) || ((this.vnU && !this.vnT && this.vnV) || (!this.vnU && this.vnT && this.vnV))) {
                this.vnQ = (((this.vnR + 1) / vnH) + 1) * vnH;
            } else if ((this.vnU && !this.vnT && !this.vnV) || ((!this.vnU && this.vnT && !this.vnV) || (!this.vnU && !this.vnT && this.vnV))) {
                this.vnQ = ((this.vnR / vnH) + 1) * vnH;
            } else if (!(this.vnU || this.vnT || this.vnV)) {
                this.vnQ = (((this.vnR - 1) / vnH) + 1) * vnH;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.vnR + " realySize : " + this.vnQ);
            bXG();
        }
    }

    public final int getCount() {
        if (this.vnX) {
            return Math.min(this.vnY, this.vnQ);
        }
        return this.vnQ;
    }

    public final Object getItem(int i) {
        if (i >= this.vnR) {
            return null;
        }
        if (this.vnK) {
            return this.vnO.get(i);
        }
        return this.vnN.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}

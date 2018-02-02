package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.ui.e.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String jKk = q.FS();
    List<e> lWj;
    Map<String, String> lWk;
    String lWl;
    d lWm;
    private String lWn;
    private boolean lWo = false;
    private a lWp = new a();
    private OnClickListener lWq = new 2(this);
    private OnClickListener lWr = new 3(this);
    private OnClickListener lWs = new 4(this);
    private Context mContext;

    static final class b {
        public TextView lNv;
        public TextView lWA;
        public ExdeviceLikeView lWB;
        public View lWC;
        public View lWD;
        public View lWE;
        public TextView lWF;
        public View lWv;
        public View lWw;
        public ImageView lWx;
        public NoMeasuredTextView lWy;
        public TextView lWz;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pn(i);
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.lWn = str;
    }

    private static void c(LinkedList<c> linkedList, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                x.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[]{((c) it.next()).toString()});
                it.remove();
            }
        }
    }

    private static boolean d(LinkedList<c> linkedList, String str) {
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            return false;
        }
    }

    private List<e> a(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        a aVar;
        LinkedList linkedList = new LinkedList(arrayList);
        List arrayList3 = new ArrayList();
        d f = f(this.jKk, arrayList2);
        if (f != null) {
            a aVar2 = this.lWp;
            aVar2.lZj = f;
            aVar2.lZk = 3;
            if (f.field_score == 0) {
                ((com.tencent.mm.plugin.sport.b.b) g.h(com.tencent.mm.plugin.sport.b.b.class)).d((Activity) this.mContext, this.jKk);
            }
        } else {
            aVar = this.lWp;
            aVar.lZj = null;
            aVar.lWn = this.lWn;
            aVar.username = this.jKk;
            aVar.lZk = 7;
        }
        if (z) {
            this.lWp.aac = 2;
        } else {
            this.lWp.aac = 1;
        }
        arrayList3.add(this.lWp.aFw());
        aVar = this.lWp;
        aVar.aac = 0;
        arrayList3.add(aVar.aFw());
        c(linkedList, this.jKk);
        Collection arrayList4 = new ArrayList();
        x.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            f = (d) it.next();
            a aVar3 = this.lWp;
            aVar3.lZj = f;
            aVar3.aac = 1;
            aVar3.lZk = 4;
            arrayList4.add(aVar3.aFw());
            if (linkedList.size() > 0 && d(linkedList, f.field_username)) {
                aVar3 = this.lWp;
                aVar3.lZj = f;
                aVar3.aac = 1;
                aVar3.lZk = 2;
                arrayList3.add(aVar3.aFw());
                c(linkedList, f.field_username);
            }
        }
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                a aVar4 = this.lWp;
                aVar4.username = cVar.field_username;
                aVar4.lWn = this.lWn;
                aVar4.lZj = null;
                aVar4.aac = 1;
                aVar4.lZk = 6;
                arrayList3.add(aVar4.aFw());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).lZk = (((e) arrayList3.get(arrayList3.size() - 1)).lZk | 2) | 1;
            aVar = this.lWp;
            aVar.aac = 0;
            aVar.lZj = null;
            arrayList3.add(aVar.aFw());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).lZk = 5;
        }
        arrayList3.addAll(arrayList4);
        x.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[]{Integer.valueOf(arrayList2.size()), arrayList2.toString()});
        x.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[]{Integer.valueOf(arrayList3.size()), arrayList3.toString()});
        return arrayList3;
    }

    public final List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        if (arrayList == null) {
            try {
                arrayList = new ArrayList();
            } catch (Exception e) {
                x.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                return new ArrayList();
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        return a(arrayList, arrayList2, z);
    }

    public static d f(String str, ArrayList<d> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                return dVar;
            }
        }
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        return this.lWj == null ? 0 : this.lWj.size();
    }

    public final e pn(int i) {
        return (e) this.lWj.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return pn(i).aac;
    }

    public static void finish() {
        ((com.tencent.mm.plugin.sport.b.b) g.h(com.tencent.mm.plugin.sport.b.b.class)).bDf();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        d dVar = pn(i).lZj;
        e pn = pn(i);
        int itemViewType = getItemViewType(i);
        int i2 = pn.lZk;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(R.i.dhh, viewGroup, false);
                a aVar = new a();
                aVar.iiS = view.findViewById(R.h.cci);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(R.i.dhg, viewGroup, false);
                bVar = new b();
                bVar.lWz = (TextView) view.findViewById(R.h.cfC);
                break;
            case 2:
                view = from.inflate(R.i.dhi, viewGroup, false);
                bVar = new b();
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.lWv = view.findViewById(R.h.bYF);
            bVar.lWw = view.findViewById(R.h.crs);
            bVar.lNv = (TextView) view.findViewById(R.h.cfw);
            bVar.lWx = (ImageView) view.findViewById(R.h.cfA);
            bVar.lWy = (NoMeasuredTextView) view.findViewById(R.h.cfB);
            bVar.lWA = (TextView) view.findViewById(R.h.ceR);
            bVar.lWB = (ExdeviceLikeView) view.findViewById(R.h.cfc);
            bVar.lWC = view.findViewById(R.h.cci);
            bVar.lWE = view.findViewById(R.h.cfD);
            bVar.lWD = view.findViewById(R.h.ceV);
            bVar.lWF = (TextView) view.findViewById(R.h.cNO);
            if (bVar.lWy != null) {
                bVar.lWy.O(this.mContext.getResources().getDimension(R.f.buR));
                bVar.lWy.setTextColor(this.mContext.getResources().getColor(R.e.bsk));
                bVar.lWy.cpw();
                bVar.lWy.ygb = true;
            }
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            if (this.jKk.equalsIgnoreCase(dVar.field_username)) {
                this.lWo = true;
            } else {
                this.lWo = false;
            }
            if (itemViewType == 2) {
                bVar.lNv.setText(String.valueOf(dVar.field_ranknum));
                bVar.lWA.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.o(bVar.lWx, dVar.field_username);
                bVar.lWv.setOnClickListener(this.lWr);
                bVar.lWF.setOnClickListener(this.lWs);
            } else {
                ExdeviceLikeView exdeviceLikeView;
                CharSequence charSequence;
                if (bVar.lWz != null) {
                    if ((i2 & 4) != 4) {
                        bVar.lWz.setVisibility(0);
                        bVar.lWz.setText(this.mContext.getResources().getString(R.l.edG, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                    } else {
                        bVar.lWz.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.lWl) || this.jKk.equalsIgnoreCase(this.lWl)) {
                    bVar.lWw.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsg));
                } else {
                    bVar.lWw.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsh));
                }
                if ((i2 & 1) == 1) {
                    bVar.lWC.setVisibility(8);
                } else {
                    bVar.lWC.setVisibility(0);
                }
                if (dVar.field_ranknum >= 100) {
                    bVar.lNv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.buT));
                } else {
                    bVar.lNv.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.buS));
                }
                if ((i2 & 2) == 2) {
                    bVar.lNv.setText("");
                } else {
                    bVar.lNv.setText(dVar.field_ranknum);
                }
                if (dVar.field_score >= 10000) {
                    bVar.lWA.setTextColor(this.mContext.getResources().getColor(R.e.bsj));
                } else {
                    bVar.lWA.setTextColor(this.mContext.getResources().getColor(R.e.bsi));
                }
                bVar.lWA.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.o(bVar.lWx, dVar.field_username);
                if (!this.lWo) {
                    ar.Hg();
                    if (!(com.tencent.mm.z.c.EY().WK(dVar.field_username) || this.lWk == null || bh.ov((String) this.lWk.get(dVar.field_username)))) {
                        bVar.lWy.setText(i.b(this.mContext, (CharSequence) this.lWk.get(dVar.field_username), bVar.lWy.gu.getTextSize()));
                        exdeviceLikeView = bVar.lWB;
                        i2 = dVar.field_likecount;
                        exdeviceLikeView.lUF = i2;
                        charSequence = exdeviceLikeView.lUF;
                        if (exdeviceLikeView.lUF < 0) {
                            x.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                            charSequence = "0";
                        } else if (i2 > 999) {
                            x.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                            charSequence = "999+";
                        }
                        if (exdeviceLikeView.lUF > 0) {
                            exdeviceLikeView.lUI.setVisibility(8);
                        } else {
                            exdeviceLikeView.lUI.setVisibility(0);
                        }
                        exdeviceLikeView.lUI.setText(charSequence);
                        if (this.lWo) {
                            bVar.lWB.pk(dVar.field_selfLikeState);
                        } else if (dVar.field_likecount == 0) {
                            bVar.lWB.pk(1);
                        } else {
                            bVar.lWB.pk(0);
                        }
                        if (dVar.field_score <= 0 || this.lWo) {
                            bVar.lWB.setClickable(true);
                            bVar.lWB.lUG = new 1(this, dVar);
                        } else {
                            bVar.lWB.setClickable(false);
                        }
                        bVar.lWD.setTag(Integer.valueOf(i));
                        bVar.lWD.setOnClickListener(this.lWq);
                        bVar.lWE.setTag(Integer.valueOf(i));
                        bVar.lWE.setOnClickListener(this.lWq);
                    }
                }
                bVar.lWy.setText(i.b(this.mContext, r.gu(dVar.field_username), bVar.lWy.gu.getTextSize()));
                exdeviceLikeView = bVar.lWB;
                i2 = dVar.field_likecount;
                exdeviceLikeView.lUF = i2;
                charSequence = exdeviceLikeView.lUF;
                if (exdeviceLikeView.lUF < 0) {
                    x.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                    charSequence = "0";
                } else if (i2 > 999) {
                    x.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                    charSequence = "999+";
                }
                if (exdeviceLikeView.lUF > 0) {
                    exdeviceLikeView.lUI.setVisibility(0);
                } else {
                    exdeviceLikeView.lUI.setVisibility(8);
                }
                exdeviceLikeView.lUI.setText(charSequence);
                if (this.lWo) {
                    bVar.lWB.pk(dVar.field_selfLikeState);
                } else if (dVar.field_likecount == 0) {
                    bVar.lWB.pk(0);
                } else {
                    bVar.lWB.pk(1);
                }
                if (dVar.field_score <= 0) {
                }
                bVar.lWB.setClickable(true);
                bVar.lWB.lUG = new 1(this, dVar);
                bVar.lWD.setTag(Integer.valueOf(i));
                bVar.lWD.setOnClickListener(this.lWq);
                bVar.lWE.setTag(Integer.valueOf(i));
                bVar.lWE.setOnClickListener(this.lWq);
            }
        }
        return view;
    }
}

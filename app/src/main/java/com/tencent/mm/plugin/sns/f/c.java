package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.ui.d.n.a;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements e, com.tencent.mm.plugin.sns.model.e {
    public static final Pattern qZZ = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern raa = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    private com.tencent.mm.plugin.sns.g.c qUp;
    public final int qZR = 500;
    private List<d> qZS;
    public ListView qZT;
    public av qZU;
    public Map<Long, Integer> qZV = new HashMap();
    public HashSet<Long> qZW = new HashSet();
    public HashSet<Long> qZX = new HashSet();
    private HashMap<Long, a> qZY = new HashMap();
    public final int qZn = 14;
    private a rab = new 6(this);

    static /* synthetic */ void a(c cVar, Context context, View view, d.a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar2, d dVar) {
        x.i("MicroMsg.SnSABTestMgr", "processButtonClick");
        if (view.getTag() instanceof bjv) {
            cVar.a(context, (bjv) view.getTag(), aVar, bVar, cVar2, dVar);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        com.tencent.mm.sdk.b.a.xef.m(new km());
    }

    public final void init() {
        List arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.z.c.c.IF().Wp("10001").values()) {
            d dVar = new d();
            if (cVar == null) {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (cVar.isValid()) {
                Map chI = cVar.chI();
                if (chI != null) {
                    x.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.d(cVar.field_layerId, cVar.field_expId, chI);
                    int i = (!dVar.frp || dVar.ras == null || dVar.ras.size() <= 0) ? 0 : 1;
                    if (i != 0) {
                        arrayList.add(dVar);
                    }
                }
            } else {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            }
        }
        this.qZS = arrayList;
        this.qZV.clear();
        this.qZW.clear();
        this.qZY.clear();
        this.qUp = null;
        if (this.qZS != null && this.qZS.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            String stringBuilder2 = stringBuilder.append(g.Dj().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "filepath to list  " + stringBuilder2);
            byte[] d = FileOp.d(stringBuilder2, 0, -1);
            if (d != null) {
                try {
                    this.qUp = (com.tencent.mm.plugin.sns.g.c) new com.tencent.mm.plugin.sns.g.c().aF(d);
                    x.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.qUp == null) {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.qUp.raI.size());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
        }
    }

    private void eI(long j) {
        if (this.qUp == null) {
            this.qUp = new com.tencent.mm.plugin.sns.g.c();
        }
        if (this.qUp.raI.size() > 500) {
            this.qUp.raI.remove(0);
        }
        this.qUp.raI.add(Long.valueOf(j));
    }

    public final void clean() {
        this.qZT = null;
        this.qZU = null;
        if (this.qZW != null) {
            Iterator it = this.qZW.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                k qVar = new q(l.longValue(), 0, 0, null);
                g.Dk();
                g.Di().gPJ.a(qVar, 0);
                x.i("MicroMsg.SnSABTestMgr", "report id " + l);
            }
        }
        if (this.qZY != null) {
            for (a a : this.qZY.values()) {
                a(a);
            }
            this.qZY.clear();
        }
        if (this.qZS.size() != 0 && this.qUp != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            String stringBuilder2 = stringBuilder.append(g.Dj().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = this.qUp.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.qUp.raI.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public static void c(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.rOq = false;
        cVar.rOp = (ViewStub) view.findViewById(f.qFl);
        cVar.rOp.setVisibility(8);
        cVar.rOu = (ViewStub) view.findViewById(f.qEA);
        cVar.rOu.setVisibility(8);
    }

    public final void a(Context context, bjv com_tencent_mm_protocal_c_bjv, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (!w.cff()) {
            b(cVar);
        } else if (this.qZS == null || this.qZS.size() == 0) {
            b(cVar);
        } else if (this.qZX.contains(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
            b(cVar);
            cVar.rOM.setVisibility(8);
            cVar.iip.setVisibility(8);
            cVar.mUL.setVisibility(8);
        } else if (com_tencent_mm_protocal_c_bjv.vIy == null || com_tencent_mm_protocal_c_bjv.vIy.equals(ae.bvb())) {
            b(cVar);
        } else if (this.qUp == null || !this.qUp.raI.contains(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
            int i;
            if (com_tencent_mm_protocal_c_bjv != null) {
                try {
                    byte[] a = n.a(com_tencent_mm_protocal_c_bjv.wNn);
                    if (bh.bw(a)) {
                        i = 0;
                    } else {
                        i = ((bkd) new bkd().aF(a)).wNy;
                    }
                } catch (Exception e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i2 = 0;
            if (this.qZV.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
                i2 = ((Integer) this.qZV.get(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))).intValue();
                if (i2 == -1) {
                    b(cVar);
                    return;
                }
            }
            int i3 = i2;
            d dVar = null;
            for (d dVar2 : this.qZS) {
                if (dVar2 != null) {
                    if (dVar2.rar == i) {
                        dVar = dVar2;
                        break;
                    }
                }
                b(cVar);
                return;
            }
            if (dVar == null) {
                b(cVar);
            } else if (i3 >= dVar.ras.size()) {
                b(cVar);
            } else {
                b bVar = (b) dVar.ras.get(i3);
                int i4 = bVar.showType;
                b(cVar);
                if (i > 0) {
                    if (this.qZY.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
                        ((a) this.qZY.get(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))).dw(i4, bVar.iPw.size());
                    } else {
                        a aVar = new a(System.currentTimeMillis(), com_tencent_mm_protocal_c_bjv.vPO, i.eq(com_tencent_mm_protocal_c_bjv.vPO), dVar);
                        aVar.dw(i4, bVar.iPw.size());
                        this.qZY.put(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), aVar);
                    }
                    if (i4 == 1) {
                        CharSequence charSequence = bVar.title;
                        if (!cVar.rOq) {
                            cVar.rOr = cVar.rOp.inflate();
                            cVar.rOq = true;
                            cVar.rOt = (TextView) cVar.rOr.findViewById(f.qCY);
                            cVar.rOs = (LinearLayout) cVar.rOr.findViewById(f.qAb);
                        }
                        cVar.rOr.setVisibility(0);
                        cVar.rOt.setText(charSequence);
                        List list = bVar.iPw;
                        if (list.size() != cVar.rOs.getChildCount()) {
                            cVar.rOs.removeAllViews();
                            for (i = 0; i < list.size(); i++) {
                                d.a aVar2 = (d.a) list.get(i);
                                View textView = new TextView(cVar.rOs.getContext());
                                textView.setText(aVar2.rat);
                                textView.setPadding(0, 0, com.tencent.mm.bv.a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(context));
                                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
                                cVar.rOs.addView(textView);
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            d.a aVar3 = (d.a) list.get(i2);
                            TextView textView2 = (TextView) cVar.rOs.getChildAt(i2);
                            textView2.setText(a(context, textView2, a(f.a(aVar3), com_tencent_mm_protocal_c_bjv), com_tencent_mm_protocal_c_bjv, cVar, aVar3, bVar, dVar));
                            textView2.setTag(com_tencent_mm_protocal_c_bjv);
                            textView2.setOnClickListener(new 1(this, context, aVar3, bVar, cVar, dVar));
                        }
                        return;
                    } else if (i4 == 4) {
                        a(context, com_tencent_mm_protocal_c_bjv, cVar, bVar, dVar);
                        return;
                    } else if (i4 == 2) {
                        if (!b(context, com_tencent_mm_protocal_c_bjv, cVar, bVar, dVar)) {
                            return;
                        }
                        return;
                    }
                }
                b(cVar);
            }
        } else {
            b(cVar);
        }
    }

    private boolean a(Context context, bjv com_tencent_mm_protocal_c_bjv, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        cVar.mUL.setBackgroundDrawable(null);
        int i = cVar.position - 1;
        if (this.qZU != null) {
            WeakReference weakReference = (WeakReference) this.qZU.rHr.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!cVar.rOv) {
            cVar.rOw = cVar.rOu.inflate();
            cVar.rOv = true;
            cVar.rOx = (LinearLayout) cVar.rOw.findViewById(f.qDw);
        }
        cVar.rOw.setVisibility(0);
        cVar.rOM.setVisibility(8);
        cVar.iip.setVisibility(8);
        List list = bVar.iPw;
        if (list.size() != cVar.rOx.getChildCount()) {
            cVar.rOx.removeAllViews();
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                View textView = new TextView(context);
                textView.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qyS);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(context));
                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                cVar.rOx.addView(textView);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            d.a aVar = (d.a) list.get(i2);
            TextView textView2 = (TextView) cVar.rOx.getChildAt(i2);
            textView2.setText(aVar.rat);
            textView2.setTag(com_tencent_mm_protocal_c_bjv);
            String a = a(f.a(aVar), com_tencent_mm_protocal_c_bjv);
            textView2.setOnClickListener(new 2(this, context, aVar, bVar, cVar, dVar));
            textView2.setText(a(context, textView2, a, com_tencent_mm_protocal_c_bjv, cVar, aVar, bVar, dVar), BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.bv.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.qIx), null, null, null);
            }
        }
        return true;
    }

    private boolean b(Context context, bjv com_tencent_mm_protocal_c_bjv, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        if (bVar.iPw.size() != 2) {
            return false;
        }
        d.a aVar = (d.a) bVar.iPw.get(0);
        d.a aVar2 = (d.a) bVar.iPw.get(1);
        String a = a(f.a(aVar), com_tencent_mm_protocal_c_bjv);
        String a2 = a(f.a(aVar2), com_tencent_mm_protocal_c_bjv);
        h.a(context, a(bVar.title, com_tencent_mm_protocal_c_bjv), context.getString(j.dGO), a, a2, new 3(this, context, com_tencent_mm_protocal_c_bjv, aVar, bVar, cVar, dVar), new 4(this, context, com_tencent_mm_protocal_c_bjv, aVar2, bVar, cVar, dVar));
        return true;
    }

    private void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            Context context = cVar.mUL.getContext();
            if (context != null) {
                if (cVar.mUL.getBackground() == null) {
                    cVar.mUL.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.bBx);
                    cVar.mUL.setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 8));
                }
                int i = cVar.position - 1;
                if (this.qZU != null) {
                    WeakReference weakReference = (WeakReference) this.qZU.rHr.get(Integer.valueOf(i));
                    if (weakReference != null && weakReference.get() != null) {
                        ((View) weakReference.get()).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.bBx);
                        ((View) weakReference.get()).setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 12), com.tencent.mm.bv.a.fromDPToPix(context, 8));
                    }
                }
            }
        }
    }

    private void a(Context context, bjv com_tencent_mm_protocal_c_bjv, d.a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        x.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + com_tencent_mm_protocal_c_bjv.vIy + " " + com_tencent_mm_protocal_c_bjv.vPO);
        int i = aVar.rav - 1;
        a aVar2 = (a) this.qZY.get(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO));
        if (aVar2 != null) {
            aVar2.q(bVar.showType, bVar.iPw.size(), aVar.index, aVar.actionType);
            aVar2.ram = -1;
            aVar2.ran = -1;
        }
        if (aVar.actionType == 3) {
            this.qZW.add(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO));
            this.qZV.put(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.qZV.put(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(i));
            eI(com_tencent_mm_protocal_c_bjv.vPO);
            b(cVar);
        } else if (aVar.actionType == 5) {
            if (this.qZW.contains(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
                this.qZW.remove(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO));
                eI(com_tencent_mm_protocal_c_bjv.vPO);
                b(cVar);
                if (this.qZY.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO))) {
                    a((a) this.qZY.remove(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO)));
                }
            }
            this.qZV.put(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(-1));
            a(cVar);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.ras.size()) {
                b bVar2 = (b) dVar.ras.get(i);
                if (bVar2.showType == 2) {
                    b(context, com_tencent_mm_protocal_c_bjv, cVar, bVar2, dVar);
                    return;
                } else if (bVar2.showType == 5) {
                    u.makeText(context, bh.az(bVar2.title, ""), 0).show();
                    eI(com_tencent_mm_protocal_c_bjv.vPO);
                    b(cVar);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            u.makeText(context, bh.az(context.getString(j.qJR), ""), 0).show();
            this.qZX.add(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO));
            b(cVar);
            com.tencent.mm.sdk.b.a.xef.m(new kn());
            a(cVar);
            return;
        } else if (aVar.actionType == 2) {
            r0 = aVar.jumpUrl;
            x.i("MicroMsg.SnSABTestMgr", "jump url " + r0);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.ifs.j(intent, context);
            eI(com_tencent_mm_protocal_c_bjv.vPO);
            b(cVar);
            a(cVar);
            return;
        } else if (aVar.actionType == 8) {
            return;
        } else {
            if (aVar.actionType == 4) {
                r0 = com_tencent_mm_protocal_c_bjv.vIy;
                List linkedList = new LinkedList();
                linkedList.add(r0);
                k vVar = new v(1, 5, "", linkedList.size(), linkedList, 0);
                g.Dk();
                g.Di().gPJ.a(vVar, 0);
            }
        }
        if (i == 4 || i == 1) {
            a(context, com_tencent_mm_protocal_c_bjv, cVar);
        }
    }

    private static void b(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            if (cVar.rOp != null) {
                cVar.rOp.setVisibility(8);
            }
            if (cVar.rOr != null) {
                cVar.rOr.setVisibility(8);
            }
            if (cVar.rOu != null) {
                cVar.rOu.setVisibility(8);
            }
            if (cVar.rOw != null) {
                cVar.rOw.setVisibility(8);
            }
            if (cVar.rOM.getVisibility() == 8) {
                cVar.rOM.setVisibility(0);
            }
            if (cVar.iip.getVisibility() == 8) {
                cVar.iip.setVisibility(0);
            }
            if (cVar.mUL.getVisibility() == 8) {
                cVar.mUL.setVisibility(0);
            }
        }
    }

    private static String a(String str, bjv com_tencent_mm_protocal_c_bjv) {
        Throwable e;
        String str2;
        try {
            if (bh.ov(str)) {
                return "";
            }
            int i;
            String str3 = com_tencent_mm_protocal_c_bjv.vIy;
            g.Dk();
            af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str3);
            if (str.contains("{username}")) {
                str = str.replace("{username}", WO.AQ());
            }
            if (WO.fWf == 1) {
                i = 0;
                str2 = str;
            } else if (WO.fWf == 2) {
                i = 1;
                str2 = str;
            } else {
                i = 2;
                str2 = str;
            }
            while (true) {
                Matcher matcher = raa.matcher(str2);
                if (!matcher.find() || matcher.groupCount() != 3) {
                    return str2;
                }
                CharSequence group;
                CharSequence group2 = matcher.group();
                if (i == 0) {
                    group = matcher.group(1);
                } else if (i == 1) {
                    try {
                        group = matcher.group(2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    group = matcher.group(3);
                }
                str2 = str2.replace(group2, group);
            }
        } catch (Throwable e3) {
            e = e3;
            str2 = str;
            x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            return str2;
        }
    }

    private SpannableString a(Context context, TextView textView, String str, bjv com_tencent_mm_protocal_c_bjv, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d.a aVar, b bVar, d dVar) {
        Matcher matcher = qZZ.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return com.tencent.mm.pluginsdk.ui.d.i.a(context, str);
        }
        CharSequence group = matcher.group();
        Object group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        CharSequence replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new ab());
        spannableString.setSpan(new com.tencent.mm.pluginsdk.ui.d.n(com_tencent_mm_protocal_c_bjv.vIy, new 5(this, context, com_tencent_mm_protocal_c_bjv, aVar, bVar, cVar, dVar)), indexOf, group2.length() + indexOf, 33);
        return spannableString;
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z, bf bfVar) {
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z) {
        if (this.qZY.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.qZY.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.q(aVar.ram, aVar.ran, 0, 0);
        }
    }

    private static void a(a aVar) {
        d dVar = aVar.ral;
        if (dVar != null) {
            String str = dVar.qZQ;
            String str2 = dVar.qZP;
            String str3 = aVar.raq;
            aVar.q(aVar.ram, aVar.ran, 0, 0);
            String str4 = aVar.rap;
            if (bh.ov(str4)) {
                str4 = aVar.ram + ":" + aVar.ran + ":0:0";
            }
            String str5 = "";
            long j = aVar.mStartTime / 1000;
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            long j2 = aVar.mEndTime / 1000;
            if (aVar != null) {
                x.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
                com.tencent.mm.plugin.report.service.g.pQN.h(11917, new Object[]{str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2)});
            }
        }
    }
}

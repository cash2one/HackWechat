package com.tencent.mm.plugin.label;

import com.tencent.mm.ae.e;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements com.tencent.mm.plugin.label.a.b {
    ArrayList<String> nOw;
    ArrayList<String> nOx;
    private e nOy = new 1(this);
    String username;

    public final /* synthetic */ List Dq(String str) {
        if (bh.ov(str)) {
            x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        return e.aUW().H(str.split(","));
    }

    public final /* synthetic */ List Dr(String str) {
        return e.aUW().WE(str);
    }

    public final /* synthetic */ List aUU() {
        return e.aUW().cih();
    }

    public final void aUR() {
        e.aUW().aUR();
    }

    public final String Dn(String str) {
        return e.aUW().Dn(str);
    }

    public final String Do(String str) {
        return e.aUW().Do(str);
    }

    public final void a(a aVar) {
        e.aUW().c(aVar);
    }

    public final void b(a aVar) {
        e.aUW().j(aVar);
    }

    public final List<String> aUS() {
        ac aUW = e.aUW();
        long Wp = bh.Wp();
        ArrayList cii = aUW.cii();
        if (cii == null) {
            return null;
        }
        aUW.cij();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cii.size(); i++) {
            ArrayList arrayList2 = (ArrayList) aUW.xxS.get(Integer.valueOf(((z) cii.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((z) cii.get(i)).field_labelName);
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[]{Long.valueOf(bh.bz(Wp)), Integer.valueOf(cii.size()), Integer.valueOf(arrayList.size()), bh.cgy()});
        return arrayList;
    }

    public final List<String> Dp(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public final String aW(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized void db(String str, String str2) {
        x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[]{str, str2});
        if (bh.ov(str2)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        } else {
            ArrayList arrayList = (ArrayList) Dp(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
            } else {
                this.username = str;
                this.nOw = arrayList;
                int size = arrayList.size();
                this.nOx = new ArrayList();
                for (int i = 0; i < size; i++) {
                    z WF = e.aUW().WF((String) arrayList.get(i));
                    if (WF != null && WF.field_isTemporary) {
                        this.nOx.add(arrayList.get(i));
                    }
                }
                ar.CG().a(635, this.nOy);
                ar.CG().a(638, this.nOy);
                if (this.nOx == null || this.nOx.isEmpty()) {
                    g(str, arrayList);
                    aUT();
                } else {
                    x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[]{this.nOx.toString()});
                    ar.CG().a(new com.tencent.mm.plugin.label.b.a(this.nOx), 0);
                }
            }
        }
    }

    final void aUT() {
        this.username = null;
        this.nOw = null;
        this.nOx = null;
        ar.CG().b(635, this.nOy);
        ar.CG().b(638, this.nOy);
    }

    static void g(String str, ArrayList<String> arrayList) {
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        x.d(str2, str3, objArr);
        if (bh.ov(str) || arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.aY(e.aUW().ae(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        brp com_tencent_mm_protocal_c_brp = new brp();
        com_tencent_mm_protocal_c_brp.vYL = str4;
        com_tencent_mm_protocal_c_brp.ksU = str;
        linkedList.add(com_tencent_mm_protocal_c_brp);
        ar.CG().a(new d(linkedList), 0);
    }

    public final void aX(List<String> list) {
        ar.CG().a(new com.tencent.mm.plugin.label.b.a((List) list), 0);
    }

    public final void h(List<String> list, List<String> list2) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                List<String> F = bh.F(((String) it.next()).split(","));
                if (F != null && F.size() > 0) {
                    for (String str3 : F) {
                        String str4;
                        String dc;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            dc = c.dc(str4, str22);
                            if (!dc.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, dc);
                            }
                        } else {
                            ar.Hg();
                            af WO = c.EY().WO(str3);
                            if (WO != null) {
                                str4 = WO.field_contactLabelIds;
                                dc = c.dc(str4, str22);
                                if (!dc.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, dc);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            brp com_tencent_mm_protocal_c_brp = new brp();
            com_tencent_mm_protocal_c_brp.ksU = str3;
            com_tencent_mm_protocal_c_brp.vYL = str22;
            linkedList.add(com_tencent_mm_protocal_c_brp);
        }
        if (linkedList.size() > 0) {
            ar.CG().a(new d(linkedList), 0);
        }
    }
}

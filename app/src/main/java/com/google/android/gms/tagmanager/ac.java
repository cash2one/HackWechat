package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import com.google.android.gms.c.at$b;
import com.google.android.gms.c.b.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ac {
    private static final v<a> bbV = new v(ai.rd(), true);
    private final f bbW;
    private final Map<String, g> bbX;
    private final Map<String, g> bbY;
    private final Map<String, g> bbZ;
    private final c bbz;
    private final al<at.a, v<a>> bca;
    private final al<String, b> bcb;
    private final Set<at$b> bcc;
    private final Map<String, c> bcd;
    private volatile String bce;
    private int bcf;

    private v<Boolean> a(at.a aVar, Set<String> set, x xVar) {
        v a = a(this.bbY, aVar, (Set) set, xVar);
        Boolean c = ai.c((a) a.bbL);
        ai.an(c);
        return new v(c, a.bbM);
    }

    private v<Boolean> a(at$b com_google_android_gms_c_at_b, Set<String> set, aa aaVar) {
        boolean z = true;
        for (at.a a : com_google_android_gms_c_at_b.aZp) {
            v a2 = a(a, (Set) set, aaVar.qL());
            if (((Boolean) a2.bbL).booleanValue()) {
                ai.an(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.bbM);
            }
            boolean z2 = z && a2.bbM;
            z = z2;
        }
        for (at.a a3 : com_google_android_gms_c_at_b.aZo) {
            a2 = a(a3, (Set) set, aaVar.qM());
            if (((Boolean) a2.bbL).booleanValue()) {
                z = z && a2.bbM;
            } else {
                ai.an(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a2.bbM);
            }
        }
        ai.an(Boolean.valueOf(true));
        return new v(Boolean.valueOf(true), z);
    }

    private v<a> a(a aVar, Set<String> set, aj ajVar) {
        if (!aVar.aWl) {
            return new v(aVar, true);
        }
        a a;
        int i;
        v a2;
        switch (aVar.type) {
            case 2:
                a = at.a(aVar);
                a.aWc = new a[aVar.aWc.length];
                for (i = 0; i < aVar.aWc.length; i++) {
                    a2 = a(aVar.aWc[i], (Set) set, ajVar.qS());
                    if (a2 == bbV) {
                        return bbV;
                    }
                    a.aWc[i] = (a) a2.bbL;
                }
                return new v(a, false);
            case 3:
                a = at.a(aVar);
                if (aVar.aWd.length != aVar.aWe.length) {
                    new StringBuilder("Invalid serving value: ").append(aVar.toString());
                    m.qC();
                    return bbV;
                }
                a.aWd = new a[aVar.aWd.length];
                a.aWe = new a[aVar.aWd.length];
                for (i = 0; i < aVar.aWd.length; i++) {
                    a2 = a(aVar.aWd[i], (Set) set, ajVar.qT());
                    v a3 = a(aVar.aWe[i], (Set) set, ajVar.qU());
                    if (a2 == bbV || a3 == bbV) {
                        return bbV;
                    }
                    a.aWd[i] = (a) a2.bbL;
                    a.aWe[i] = (a) a3.bbL;
                }
                return new v(a, false);
            case 4:
                if (set.contains(aVar.aWf)) {
                    new StringBuilder("Macro cycle detected.  Current macro reference: ").append(aVar.aWf).append(".  Previous macro references: ").append(set.toString()).append(".");
                    m.qC();
                    return bbV;
                }
                set.add(aVar.aWf);
                v<a> a4 = ak.a(a(aVar.aWf, (Set) set, ajVar.qW()), aVar.aWk);
                set.remove(aVar.aWf);
                return a4;
            case 7:
                a = at.a(aVar);
                a.aWj = new a[aVar.aWj.length];
                for (i = 0; i < aVar.aWj.length; i++) {
                    a2 = a(aVar.aWj[i], (Set) set, ajVar.qV());
                    if (a2 == bbV) {
                        return bbV;
                    }
                    a.aWj[i] = (a) a2.bbL;
                }
                return new v(a, false);
            default:
                new StringBuilder("Unknown type: ").append(aVar.type);
                m.qC();
                return bbV;
        }
    }

    private v<a> a(String str, Set<String> set, o oVar) {
        this.bcf++;
        b bVar = (b) this.bcb.re();
        if (bVar == null || this.bbW.qz()) {
            c cVar = (c) this.bcd.get(str);
            if (cVar == null) {
                new StringBuilder().append(qZ()).append("Invalid macro: ").append(str);
                m.qC();
                this.bcf--;
                return bbV;
            }
            at.a aVar;
            v a = a(cVar.bcc, cVar.bcm, cVar.bco, cVar.bcn, cVar.bcp, set, oVar.qI());
            if (((Set) a.bbL).isEmpty()) {
                aVar = cVar.bcq;
            } else {
                if (((Set) a.bbL).size() > 1) {
                    new StringBuilder().append(qZ()).append("Multiple macros active for macroName ").append(str);
                    m.qE();
                }
                aVar = (at.a) ((Set) a.bbL).iterator().next();
            }
            if (aVar == null) {
                this.bcf--;
                return bbV;
            }
            v a2 = a(this.bbZ, aVar, (Set) set, oVar.qH());
            boolean z = a.bbM && a2.bbM;
            v<a> vVar = a2 == bbV ? bbV : new v(a2.bbL, z);
            a aVar2 = aVar.aZn;
            if (vVar.bbM) {
                b bVar2 = new b(vVar, aVar2);
            }
            a(aVar2, set);
            this.bcf--;
            return vVar;
        }
        a(bVar.aZn, set);
        this.bcf--;
        return bVar.bcl;
    }

    private v<a> a(Map<String, g> map, at.a aVar, Set<String> set, x xVar) {
        a aVar2 = (a) Collections.unmodifiableMap(aVar.aZm).get(com.google.android.gms.c.a.aTw.toString());
        if (aVar2 == null) {
            m.qC();
            return bbV;
        }
        String str = aVar2.aWg;
        g gVar = (g) map.get(str);
        if (gVar == null) {
            new StringBuilder().append(str).append(" has no backing implementation.");
            m.qC();
            return bbV;
        }
        v<a> vVar = (v) this.bca.re();
        if (vVar != null && !this.bbW.qz()) {
            return vVar;
        }
        Map hashMap = new HashMap();
        Object obj = 1;
        for (Entry entry : Collections.unmodifiableMap(aVar.aZm).entrySet()) {
            entry.getKey();
            z qJ = xVar.qJ();
            a aVar3 = (a) entry.getValue();
            entry.getValue();
            v a = a(aVar3, (Set) set, qJ.qK());
            if (a == bbV) {
                return bbV;
            }
            Object obj2;
            if (a.bbM) {
                aVar.aZm.put((String) entry.getKey(), (a) a.bbL);
                obj2 = obj;
            } else {
                obj2 = null;
            }
            hashMap.put(entry.getKey(), a.bbL);
            obj = obj2;
        }
        if (hashMap.keySet().containsAll(gVar.bbG)) {
            boolean z = obj != null && gVar.qA();
            return new v(gVar.qB(), z);
        }
        new StringBuilder("Incorrect keys for function ").append(str).append(" required ").append(gVar.bbG).append(" had ").append(hashMap.keySet());
        m.qC();
        return bbV;
    }

    private v<Set<at.a>> a(Set<at$b> set, Map<at$b, List<at.a>> map, Map<at$b, List<String>> map2, Map<at$b, List<at.a>> map3, Map<at$b, List<String>> map4, Set<String> set2, ab abVar) {
        return a((Set) set, (Set) set2, new 1(this, map, map2, map3, map4), abVar);
    }

    private v<Set<at.a>> a(Set<at$b> set, Set<String> set2, a aVar, ab abVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (at$b com_google_android_gms_c_at_b : set) {
            aa qR = abVar.qR();
            v a = a(com_google_android_gms_c_at_b, (Set) set2, qR);
            if (((Boolean) a.bbL).booleanValue()) {
                aVar.a(com_google_android_gms_c_at_b, hashSet, hashSet2, qR);
            }
            boolean z2 = z && a.bbM;
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new v(hashSet, z);
    }

    private void a(a aVar, Set<String> set) {
        if (aVar != null) {
            v a = a(aVar, (Set) set, new u());
            if (a != bbV) {
                Object d = ai.d((a) a.bbL);
                if (d instanceof Map) {
                    this.bbz.d((Map) d);
                } else if (d instanceof List) {
                    for (Object d2 : (List) d2) {
                        if (d2 instanceof Map) {
                            this.bbz.d((Map) d2);
                        } else {
                            m.qE();
                        }
                    }
                } else {
                    m.qE();
                }
            }
        }
    }

    private synchronized void bh(String str) {
        this.bce = str;
    }

    private String qZ() {
        if (this.bcf <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.bcf));
        for (int i = 2; i < this.bcf; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    public final synchronized void bg(String str) {
        bh(str);
        ao qx = this.bbW.qy().qx();
        for (at.a a : (Set) a(this.bcc, new HashSet(), new a(this) {
            final /* synthetic */ ac bck;

            {
                this.bck = r1;
            }

            public final void a(at$b com_google_android_gms_c_at_b, Set<at.a> set, Set<at.a> set2, aa aaVar) {
                set.addAll(com_google_android_gms_c_at_b.aZq);
                set2.addAll(com_google_android_gms_c_at_b.aZr);
                aaVar.qP();
                aaVar.qQ();
            }
        }, qx.qI()).bbL) {
            a(this.bbX, a, new HashSet(), qx.ri());
        }
        bh(null);
    }
}

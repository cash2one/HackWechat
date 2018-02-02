package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static final a mLF = new 1();
    public String mLA;
    public String mLB;
    public String[] mLC;
    public String[] mLD;
    public List<c> mLE = new ArrayList();

    public static class c {
        public List<b> mLI = new ArrayList();

        public final String aMX() {
            List arrayList = new ArrayList();
            for (b bVar : this.mLI) {
                if (!arrayList.contains(bVar.content)) {
                    arrayList.add(bVar.content);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                stringBuilder.append("\"");
                stringBuilder.append(str);
                char charAt = str.charAt(str.length() - 1);
                if (f.j(charAt) || f.k(charAt)) {
                    stringBuilder.append("\"*");
                } else {
                    stringBuilder.append("\"");
                }
                if (i != arrayList.size() - 1) {
                    stringBuilder.append(" OR ");
                }
            }
            return stringBuilder.toString();
        }
    }

    private e() {
    }

    public final String aMX() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.mLE.size(); i++) {
            stringBuffer.append("(");
            stringBuffer.append(((c) this.mLE.get(i)).aMX());
            stringBuffer.append(")");
            if (i != this.mLE.size() - 1) {
                stringBuffer.append(" AND ");
            }
        }
        return stringBuffer.toString();
    }

    public static e an(String str, boolean z) {
        return a(str, z, mLF);
    }

    public static e a(String str, boolean z, a aVar) {
        e eVar = new e();
        eVar.mLA = str;
        eVar.mLB = d.Bd(str);
        eVar.mLC = aVar.split(eVar.mLB);
        eVar.mLD = aVar.Bh(eVar.mLB);
        for (String str2 : eVar.mLC) {
            int i;
            boolean z2;
            List list = eVar.mLE;
            if (z) {
                for (i = 0; i < str2.length(); i++) {
                    if (!f.j(str2.charAt(i))) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = z;
            c cVar = new c();
            b bVar;
            if (z2) {
                b bVar2 = f.mLi;
                List arrayList = new ArrayList();
                char[] toCharArray = str2.toLowerCase().toCharArray();
                for (i = 0; i < toCharArray.length; i++) {
                    if (bVar2.mMv.mMw[toCharArray[i] - 97] == null) {
                        arrayList.clear();
                        break;
                    }
                    arrayList.add(String.valueOf(toCharArray[i]));
                }
                if (arrayList.size() > 0) {
                    bVar = new b();
                    bVar.mLG = d.mLK;
                    bVar.content = bh.d(arrayList, "​");
                    bVar.mLH = arrayList;
                    cVar.mLI.add(bVar);
                }
                List<List> Bj = f.mLi.Bj(str2);
                if (Bj.size() > 0) {
                    for (List list2 : Bj) {
                        if (list2.size() > 0) {
                            b bVar3 = new b();
                            bVar3.mLG = d.mLJ;
                            bVar3.content = bh.d(list2, "​");
                            bVar3.mLH = list2;
                            cVar.mLI.add(bVar3);
                        }
                    }
                }
                bVar = new b();
                bVar.mLG = d.mLL;
                bVar.content = str2;
                cVar.mLI.add(bVar);
            } else {
                bVar = new b();
                bVar.mLG = d.mLL;
                bVar.content = str2;
                cVar.mLI.add(bVar);
            }
            list.add(cVar);
        }
        return eVar;
    }
}

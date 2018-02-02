package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ak;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static void a(c cVar, a aVar) {
        if (q.Ge() && cVar != null && cVar.size() > 0 && aVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.luM == f.a.luV)) {
                    so soVar = fVar.luN;
                    boolean b = e.b(soVar);
                    boolean a = e.a(soVar);
                    if (!(b || a)) {
                        arrayList.add(soVar.vIR);
                        ak xX = cVar.xX(soVar.vIR);
                        if (xX != null) {
                            xX.xyD = 11;
                        }
                    }
                }
            }
            Context context = ac.getContext();
            if (arrayList.size() > 0) {
                i.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
        }
    }

    public static void a(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList, c cVar) {
        if (q.Ge() && cVar != null && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.pluginsdk.model.q qVar = (com.tencent.mm.pluginsdk.model.q) it.next();
                if (qVar != null) {
                    ak xX = cVar.xX(qVar.fqV);
                    if (xX != null) {
                        int i;
                        if (qVar.vdH == 10232) {
                            xX.xyF = qVar.vdE;
                            xX.xyD = 12;
                            i = xX.xyB;
                            if (!(oH(i) || oI(i))) {
                                xX.Do(4);
                            }
                        } else {
                            xX.xyD = 10;
                            xX.xyE = qVar.vdH;
                            i = xX.xyB;
                            if (!(oH(i) || oI(i))) {
                                if ((i == 3 ? 1 : null) == null) {
                                    xX.Do(10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean oH(int i) {
        return i == 7;
    }

    private static boolean oI(int i) {
        return i == 6;
    }
}

package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class l {
    private static LinkedList<WeakReference<a>> zwn = new LinkedList();

    public interface a {
        boolean forceRemoveNoMatchOnPath();

        void onSettle(boolean z, int i);

        void onSwipe(float f);
    }

    public static void a(a aVar) {
        x.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(zwn.size()), aVar);
        zwn.add(0, new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        x.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(zwn.size()), aVar);
        if (aVar == null) {
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < zwn.size(); i++) {
            if (aVar == ((WeakReference) zwn.get(i)).get()) {
                zwn.remove(i);
                x.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i));
                break;
            }
            linkedList.add(0, Integer.valueOf(i));
        }
        if (aVar.forceRemoveNoMatchOnPath() || linkedList.size() != r4) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) zwn.remove(((Integer) it.next()).intValue());
                String str = "MicroMsg.SwipeBackHelper";
                String str2 = "popCallback, popup %s";
                Object[] objArr = new Object[1];
                objArr[0] = weakReference != null ? weakReference.get() : "NULL-CALLBACK";
                x.d(str, str2, objArr);
            }
            return linkedList.isEmpty();
        }
        x.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        return false;
    }

    public static void aI(float f) {
        if (zwn.size() <= 0) {
            x.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f));
            return;
        }
        a aVar = (a) ((WeakReference) zwn.get(0)).get();
        if (aVar == null) {
            x.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f));
            return;
        }
        aVar.onSwipe(f);
        x.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f), aVar);
    }

    public static void B(boolean z, int i) {
        if (zwn.size() <= 0) {
            x.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        a aVar = (a) ((WeakReference) zwn.get(0)).get();
        if (aVar == null) {
            x.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        aVar.onSettle(z, i);
        x.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i), aVar);
    }
}

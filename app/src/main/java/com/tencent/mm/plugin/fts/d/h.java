package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static a mOO = new a();

    public static class a {
        boolean isReady;
        g mOP;
        SparseArray<b> mOQ = new SparseArray();

        public final synchronized void a(b bVar) {
            this.mOQ.put(bVar.getType(), bVar);
        }

        public final synchronized void qh(int i) {
            this.mOQ.remove(i);
        }
    }

    public interface b extends Comparable<b> {
        i a(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i);

        int getPriority();

        int getType();
    }

    public static void a(b bVar) {
        mOO.a(bVar);
    }

    public static void qh(int i) {
        mOO.qh(i);
    }

    public static void a(g gVar) {
        a aVar = mOO;
        aVar.mOP = gVar;
        aVar.isReady = true;
    }

    public static void aNw() {
        a aVar = mOO;
        if (aVar.mOP != null) {
            aVar.mOP.aNv();
            aVar.mOP = null;
        }
        aVar.isReady = false;
    }

    public static g aNx() {
        return mOO.mOP;
    }

    public static LinkedList<i> a(HashSet<Integer> hashSet, Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        LinkedList<i> linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            b bVar = (b) mOO.mOQ.get(((Integer) it.next()).intValue());
            if (bVar != null) {
                linkedList2.add(bVar);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((b) it2.next()).a(context, com_tencent_mm_plugin_fts_d_i_b, i));
        }
        return linkedList;
    }

    public static i a(int i, Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i2) {
        b bVar = (b) mOO.mOQ.get(i);
        if (bVar != null) {
            return bVar.a(context, com_tencent_mm_plugin_fts_d_i_b, i2);
        }
        return null;
    }
}

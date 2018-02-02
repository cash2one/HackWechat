package com.tencent.mm.plugin.backup.a;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<a> kiq = new LinkedList();

    public abstract void aog();

    public static void a(a aVar) {
        kiq.add(aVar);
    }

    public static void aof() {
        Iterator it = kiq.iterator();
        while (it.hasNext()) {
            ((a) it.next()).aog();
        }
        kiq.clear();
    }
}

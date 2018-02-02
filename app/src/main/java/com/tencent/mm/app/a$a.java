package com.tencent.mm.app;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class a$a extends Error {
    LinkedList<Pair<Thread, StackTraceElement[]>> feB;

    static class a implements Serializable {
        final StackTraceElement[] feD;
        final String name;

        private a(String str, StackTraceElement[] stackTraceElementArr) {
            this.name = str;
            this.feD = stackTraceElementArr;
        }
    }

    private a$a(a aVar, LinkedList<Pair<Thread, StackTraceElement[]>> linkedList) {
        super("Application Not Responding", aVar);
        this.feB = linkedList;
    }

    public final Throwable fillInStackTrace() {
        super.fillInStackTrace();
        return this;
    }

    static a$a j(String str, boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        LinkedList linkedList = new LinkedList();
        Map treeMap = new TreeMap(new Comparator<Thread>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                Thread thread = (Thread) obj;
                Thread thread2 = (Thread) obj2;
                if (thread == thread2) {
                    return 0;
                }
                if (thread == thread) {
                    return 1;
                }
                return thread2 == thread ? -1 : thread2.getName().compareTo(thread.getName());
            }
        });
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            if ((entry.getKey() == thread || (((Thread) entry.getKey()).getName().startsWith(str) && (z || ((StackTraceElement[]) entry.getValue()).length > 0))) && entry.getValue() != null && ((StackTraceElement[]) entry.getValue()).length > 0) {
                treeMap.put(entry.getKey(), entry.getValue());
                if (entry.getKey() == thread) {
                    linkedList.addFirst(new Pair(thread, entry.getValue()));
                } else {
                    linkedList.addLast(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }
        if (!treeMap.containsKey(thread)) {
            x.i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", new Object[]{thread.getName(), Long.valueOf(thread.getId())});
            treeMap.put(thread, thread.getStackTrace());
            linkedList.addFirst(new Pair(thread, thread.getStackTrace()));
        }
        a aVar = null;
        for (Entry entry2 : treeMap.entrySet()) {
            a aVar2 = new a(a((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue());
            aVar2.getClass();
            aVar = new a(aVar2, aVar, (byte) 0);
        }
        return new a$a(aVar, linkedList);
    }

    static a$a tG() {
        Thread thread = Looper.getMainLooper().getThread();
        Object stackTrace = thread.getStackTrace();
        int length = stackTrace == null ? -1 : stackTrace.length;
        x.i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", new Object[]{Integer.valueOf(length)});
        new TreeMap().put(thread, stackTrace);
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Pair(thread, stackTrace));
        a aVar = new a(a(thread), stackTrace);
        aVar.getClass();
        return new a$a(new a(aVar, null, (byte) 0), linkedList);
    }

    private static String a(Thread thread) {
        return thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
    }
}

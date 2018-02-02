package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static final HashMap<String, MMToClientEvent> jbA = new HashMap();

    public static void a(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[]{mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode())});
        if (mMToClientEvent.appId == null) {
            x.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            return;
        }
        synchronized (jbA) {
            if (jbA.get(mMToClientEvent.appId) == null) {
                jbA.put(mMToClientEvent.appId, mMToClientEvent);
            } else {
                x.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                jbA.remove(mMToClientEvent.appId);
                jbA.put(mMToClientEvent.appId, mMToClientEvent);
            }
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[]{mMToClientEvent.appId});
        synchronized (jbA) {
            jbA.remove(mMToClientEvent.appId);
        }
    }

    public static void j(String str, int i, String str2) {
        x.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[]{str, Integer.valueOf(i), str2});
        synchronized (jbA) {
            MMToClientEvent mMToClientEvent = (MMToClientEvent) jbA.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.jbs = 3;
                mMToClientEvent.appId = str;
                mMToClientEvent.type = i;
                mMToClientEvent.fun = str2;
                mMToClientEvent.afp();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static void ay(String str, int i) {
        x.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[]{Integer.valueOf(i)});
        synchronized (jbA) {
            MMToClientEvent mMToClientEvent = (MMToClientEvent) jbA.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.jbs = 4;
                mMToClientEvent.fnm = i;
                mMToClientEvent.afp();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static <T extends Parcelable> void a(T t) {
        if (t != null) {
            MMToClientEvent mMToClientEvent;
            LinkedList linkedList = new LinkedList();
            synchronized (jbA) {
                for (MMToClientEvent mMToClientEvent2 : jbA.values()) {
                    linkedList.add(mMToClientEvent2);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                mMToClientEvent2 = (MMToClientEvent) it.next();
                if (t != null) {
                    synchronized (mMToClientEvent2) {
                        mMToClientEvent2.jbs = 5;
                        mMToClientEvent2.jbt = t.getClass().getName();
                        mMToClientEvent2.jbu = t;
                        mMToClientEvent2.afp();
                    }
                }
            }
        }
    }
}

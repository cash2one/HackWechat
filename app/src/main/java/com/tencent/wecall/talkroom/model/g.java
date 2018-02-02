package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> gxL = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    class AnonymousClass20 implements Runnable {
        final /* synthetic */ g AoK;
        final /* synthetic */ MultiTalkGroup oGC;

        AnonymousClass20(g gVar, MultiTalkGroup multiTalkGroup) {
            this.AoK = gVar;
            this.oGC = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.AoK.gxL) {
                for (a b : this.AoK.gxL) {
                    b.b(this.oGC);
                }
            }
        }
    }

    public final void dK(List<MultiTalkGroup> list) {
        Runnable 19 = new 19(this, list);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            19.run();
        } else {
            this.handler.post(19);
        }
    }

    public final void a(final int i, final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass21 = new Runnable(this) {
            final /* synthetic */ g AoK;

            public final void run() {
                synchronized (this.AoK.gxL) {
                    for (a a : this.AoK.gxL) {
                        a.a(i, multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass21.run();
        } else {
            this.handler.post(anonymousClass21);
        }
    }

    public final void g(int i, Object obj) {
        Runnable 4 = new 4(this, i, obj);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            4.run();
        } else {
            this.handler.post(4);
        }
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        Runnable 5 = new 5(this, multiTalkGroup);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            5.run();
        } else {
            this.handler.post(5);
        }
    }

    public final void dK(String str, int i) {
        h.ad(new 13(this, str, i));
    }
}

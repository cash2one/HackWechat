package com.tencent.mm.sdk.d;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class d {
    public String mName;
    public volatile c xiR;
    volatile HandlerThread xiS;

    public d(String str, Looper looper) {
        this.mName = str;
        this.xiR = new c(looper, this, (byte) 0);
    }

    public final void a(c cVar) {
        c.a(this.xiR, cVar);
    }

    public final void b(c cVar) {
        c.b(this.xiR, cVar);
    }

    public final Message cgG() {
        c cVar = this.xiR;
        if (cVar == null) {
            return null;
        }
        return c.b(cVar);
    }

    public final a cgH() {
        c cVar = this.xiR;
        if (cVar == null) {
            return null;
        }
        return c.c(cVar);
    }

    public final void b(a aVar) {
        c.a(this.xiR, aVar);
    }

    public void i(Message message) {
        if (c.d(this.xiR)) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
    }

    public void ZF() {
    }

    public boolean h(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        return Message.obtain(this.xiR, i);
    }

    public final void Dh(int i) {
        c cVar = this.xiR;
        if (cVar != null) {
            cVar.sendMessage(obtainMessage(i));
        }
    }

    public final void Di(int i) {
        c cVar = this.xiR;
        if (cVar != null) {
            cVar.sendMessageAtFrontOfQueue(obtainMessage(i));
        }
    }

    public final void quit() {
        c cVar = this.xiR;
        if (cVar != null) {
            c.e(cVar);
        }
    }

    public void start() {
        c cVar = this.xiR;
        if (cVar != null) {
            c.f(cVar);
        }
    }
}

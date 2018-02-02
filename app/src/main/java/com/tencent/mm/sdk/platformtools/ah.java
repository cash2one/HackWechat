package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class ah extends Handler implements com.tencent.mm.sdk.platformtools.al.a {
    private String toStringResult = null;
    private Looper xfE = getLooper();
    private Callback xfF;
    a xfG;

    public interface a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f);

        void onTaskAdded(Runnable runnable, al alVar);

        void onTaskRunEnd(Runnable runnable, al alVar);
    }

    ah(a aVar) {
        this.xfG = aVar;
    }

    ah(Looper looper, a aVar) {
        super(looper);
        this.xfG = aVar;
    }

    ah(Callback callback, a aVar) {
        super(callback);
        this.xfF = callback;
        this.xfG = aVar;
    }

    ah(Looper looper, Callback callback, a aVar) {
        super(looper, callback);
        this.xfF = callback;
        this.xfG = aVar;
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        al alVar = new al(this.xfE.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            alVar.xfZ = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), alVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.xfG != null) {
                this.xfG.onTaskAdded(callback, alVar);
            }
            boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
            if (sendMessageAtTime || this.xfG == null) {
                return sendMessageAtTime;
            }
            this.xfG.onTaskRunEnd(callback, alVar);
            return sendMessageAtTime;
        }
        x.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        return false;
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.xfF == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.xfG != null) {
                this.xfG.onLog(message, null, this.xfE.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, -1.0f);
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
        if (this.xfG != null) {
            this.xfG.handleMessage(message);
        }
    }

    public final String toString() {
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.xfG + "}";
        }
        return this.toStringResult;
    }

    public final void a(Runnable runnable, al alVar) {
        if (this.xfG != null) {
            this.xfG.onTaskRunEnd(runnable, alVar);
        }
    }

    public final void a(Runnable runnable, Thread thread, long j, long j2, float f) {
        if (this.xfG != null) {
            this.xfG.onLog(null, runnable, thread, j, j2, f);
        }
    }
}

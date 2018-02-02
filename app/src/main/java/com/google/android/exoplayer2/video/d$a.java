package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class d$a implements Callback, FrameCallback {
    private static final d$a aDW = new d$a();
    public volatile long aDV;
    private final HandlerThread aDX = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer aDY;
    private int aDZ;
    final Handler handler;

    public static d$a lZ() {
        return aDW;
    }

    private d$a() {
        this.aDX.start();
        this.handler = new Handler(this.aDX.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public final void doFrame(long j) {
        this.aDV = j;
        this.aDY.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aDY = Choreographer.getInstance();
                return true;
            case 1:
                this.aDZ++;
                if (this.aDZ != 1) {
                    return true;
                }
                this.aDY.postFrameCallback(this);
                return true;
            case 2:
                this.aDZ--;
                if (this.aDZ != 0) {
                    return true;
                }
                this.aDY.removeFrameCallback(this);
                this.aDV = 0;
                return true;
            default:
                return false;
        }
    }
}

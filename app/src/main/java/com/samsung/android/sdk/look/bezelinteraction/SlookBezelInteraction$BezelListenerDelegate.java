package com.samsung.android.sdk.look.bezelinteraction;

import android.os.Handler;
import android.os.Message;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;
import com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction.BezelListener;

class SlookBezelInteraction$BezelListenerDelegate extends Stub {
    public Handler mHandler;
    public BezelListener mListener;

    SlookBezelInteraction$BezelListenerDelegate(BezelListener bezelListener, Handler handler) {
        this.mListener = bezelListener;
        this.mHandler = new ListenerHandler(handler == null ? SlookBezelInteraction.access$000().getMainLooper() : handler.getLooper(), this.mListener);
    }

    public BezelListener getListener() {
        return this.mListener;
    }

    public void onBezelCallback(BezelEvent bezelEvent) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bezelEvent;
        this.mHandler.sendMessage(obtain);
    }

    public String getListenerInfo() {
        return this.mListener.toString();
    }
}

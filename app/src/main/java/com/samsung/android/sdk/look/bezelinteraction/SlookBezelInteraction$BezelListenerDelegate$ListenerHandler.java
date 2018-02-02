package com.samsung.android.sdk.look.bezelinteraction;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction.BezelListener;

class SlookBezelInteraction$BezelListenerDelegate$ListenerHandler extends Handler {
    public BezelListener mListener = null;

    public SlookBezelInteraction$BezelListenerDelegate$ListenerHandler(Looper looper, BezelListener bezelListener) {
        super(looper);
        this.mListener = bezelListener;
    }

    public void handleMessage(Message message) {
        if (this.mListener != null) {
            BezelEvent bezelEvent = (BezelEvent) message.obj;
            if (bezelEvent != null) {
                this.mListener.onItemSelected(bezelEvent);
            }
        }
    }
}

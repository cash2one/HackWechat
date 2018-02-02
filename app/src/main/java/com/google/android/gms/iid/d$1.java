package com.google.android.gms.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;

class d$1 extends Handler {
    final /* synthetic */ d aRv;

    d$1(d dVar, Looper looper) {
        this.aRv = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        d dVar = this.aRv;
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    dVar.aRp = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    dVar.aRo = (Messenger) parcelableExtra;
                }
            }
            dVar.h((Intent) message.obj);
        }
    }
}

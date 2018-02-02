package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.iid.c.a;

final class MessengerCompat$a extends a {
    final /* synthetic */ MessengerCompat aRi;
    Handler handler;

    MessengerCompat$a(MessengerCompat messengerCompat, Handler handler) {
        this.aRi = messengerCompat;
        this.handler = handler;
    }

    public final void send(Message message) {
        message.arg2 = Binder.getCallingUid();
        this.handler.dispatchMessage(message);
    }
}

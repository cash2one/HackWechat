package com.tencent.mm.plugin.accountsync.model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class AccountAuthenticatorService extends Service {
    private static a ikT = null;

    public IBinder onBind(Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        if (ikT == null) {
            ikT = new a(this);
        }
        return ikT.getIBinder();
    }
}

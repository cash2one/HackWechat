package com.tencent.mm.plugin.ipcall.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    private static a nCm = null;
    private boolean acS = false;
    private long endTime = -1;
    af handler = new 1(this, Looper.getMainLooper());
    public ArrayList<a> nCl = new ArrayList();
    private long startTime = -1;

    private a() {
    }

    public static a aTi() {
        if (nCm == null) {
            nCm = new a();
        }
        return nCm;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.nCl.add(aVar);
        }
        if (this.acS) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.aUe().size() == 0 || !z) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList aUd = b.aUd();
            x.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = aUd;
            this.handler.sendMessage(obtainMessage);
            this.acS = true;
        }
    }
}

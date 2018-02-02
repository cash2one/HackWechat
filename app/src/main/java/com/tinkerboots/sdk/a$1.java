package com.tinkerboots.sdk;

import android.content.SharedPreferences;
import android.os.MessageQueue.IdleHandler;
import com.tinkerboots.sdk.a.a;
import com.tinkerboots.sdk.b.b;

class a$1 implements IdleHandler {
    final /* synthetic */ boolean Auf;
    final /* synthetic */ a Aug;

    a$1(a aVar, boolean z) {
        this.Aug = aVar;
        this.Auf = z;
    }

    public final boolean queueIdle() {
        a aVar = this.Aug.Aue;
        boolean z = this.Auf;
        SharedPreferences sharedPreferences = b.getContext().getSharedPreferences("patch_server_config", 0);
        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
        if (j == -1) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
        } else {
            j = System.currentTimeMillis() - j;
            if (z || aVar.Aun || j >= aVar.Aul) {
                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                com.tinkerboots.sdk.a.b.a aVar2 = aVar.Aum;
                com.tinkerboots.sdk.a.a.b bVar = aVar.Auj;
                if (bVar == null) {
                    throw new RuntimeException("callback can't be null");
                } else if (bVar.aSF()) {
                    bVar.aSG();
                    bVar.C(aVar2.Auo.Aup);
                }
            } else {
                com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[]{Long.valueOf((aVar.Aul - j) / 1000)});
            }
        }
        return false;
    }
}

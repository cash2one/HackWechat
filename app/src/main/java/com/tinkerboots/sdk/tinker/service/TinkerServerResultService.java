package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.tinker.a.a;
import java.io.File;

public class TinkerServerResultService extends DefaultTinkerResultService {
    private static boolean Aur = false;
    private static a Aus = null;

    public final void a(com.tencent.tinker.lib.service.a aVar) {
        if (aVar == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "receive result: %s", new Object[]{aVar.toString()});
        b.iq(getApplicationContext());
        if (aVar.fsH) {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
            DefaultTinkerResultService.Y(new File(aVar.Ait));
            if (!b(aVar)) {
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
                return;
            } else if (Aur) {
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
                c.b bVar = new c.b(getApplicationContext(), new 1(this));
                return;
            } else {
                return;
            }
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
    }

    static void restartProcess() {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
    }
}

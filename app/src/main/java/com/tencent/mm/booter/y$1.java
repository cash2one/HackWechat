package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class y$1 implements Runnable {
    final /* synthetic */ y gyT;

    public y$1(y yVar) {
        this.gyT = yVar;
    }

    public final void run() {
        String str;
        u uVar;
        long Wp = t.Wp();
        Process.setThreadPriority(10);
        y yVar = this.gyT;
        int i = f.fdS;
        String yF = q.yF();
        int i2 = d.vAz;
        String str2 = "0";
        String cfi = w.cfi();
        int i3 = yVar.context.getSharedPreferences(ac.cfs(), 0).getInt("last_reportdevice_channel", 0);
        int i4 = yVar.context.getSharedPreferences(ac.cfs(), 0).getInt("last_reportdevice_clientversion", 0);
        if (i3 == 0 && i4 == 0) {
            i4 = 0;
        } else if (i3 == i && i4 == i2) {
            str = null;
            x.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str});
            if (t.ov(str)) {
                uVar = null;
                try {
                    uVar = b.a(str, null);
                    uVar.setConnectTimeout(10000);
                    uVar.setReadTimeout(10000);
                    uVar.connect();
                    if (uVar.getResponseCode() == 200) {
                        y yVar2 = this.gyT;
                        int i5 = f.fdS;
                        int i6 = d.vAz;
                        SharedPreferences sharedPreferences = yVar2.context.getSharedPreferences(ac.cfs(), 0);
                        sharedPreferences.edit().putInt("last_reportdevice_channel", i5).commit();
                        sharedPreferences.edit().putInt("last_reportdevice_clientversion", i6).commit();
                    }
                    x.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[]{Long.valueOf(t.bz(Wp)), Integer.valueOf(i), str});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                    x.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[]{str});
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
            }
        } else {
            i4 = 1;
        }
        str = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + f.fdS + "&deviceid=" + yF + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + cfi + "&installtype=" + i4;
        x.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str});
        if (t.ov(str)) {
            uVar = null;
            uVar = b.a(str, null);
            uVar.setConnectTimeout(10000);
            uVar.setReadTimeout(10000);
            uVar.connect();
            if (uVar.getResponseCode() == 200) {
                y yVar22 = this.gyT;
                int i52 = f.fdS;
                int i62 = d.vAz;
                SharedPreferences sharedPreferences2 = yVar22.context.getSharedPreferences(ac.cfs(), 0);
                sharedPreferences2.edit().putInt("last_reportdevice_channel", i52).commit();
                sharedPreferences2.edit().putInt("last_reportdevice_clientversion", i62).commit();
            }
            x.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[]{Long.valueOf(t.bz(Wp)), Integer.valueOf(i), str});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
        }
    }
}

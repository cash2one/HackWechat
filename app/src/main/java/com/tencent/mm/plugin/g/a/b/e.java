package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public final HashMap<Long, f> kwL;
    public c kwN;
    public a kwQ;
    a kxu;
    public HashSet<Long> kxv;
    final HashMap<Long, Boolean> kxw;
    public f.a kxx;
    public af mHandler;
    private ReentrantLock mLock;
    public Runnable mRunnable;
    public Context tI;

    public e(a aVar) {
        this.tI = null;
        this.mLock = new ReentrantLock();
        this.mHandler = null;
        this.mRunnable = null;
        this.kwQ = new 1(this);
        this.kxv = new HashSet();
        this.kwL = new HashMap();
        this.kxw = new HashMap();
        this.kxx = new f.a(this) {
            final /* synthetic */ e kxy;

            {
                this.kxy = r1;
            }

            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onConnected. mac = %s, connected = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.cK(j);
                objArr[1] = z ? "true" : "false";
                x.d(str, str2, objArr);
                final long j3 = j;
                final boolean z2 = z;
                final long j4 = j2;
                this.kxy.t(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 kxC;

                    public final void run() {
                        f fVar = (f) this.kxC.kxy.kwL.get(Long.valueOf(j3));
                        Boolean.valueOf(false);
                        if (z2) {
                            boolean z = false;
                        } else {
                            int i = 1;
                        }
                        if (fVar == null && i == 0) {
                            x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[]{b.cK(j3)});
                            return;
                        }
                        if (this.kxC.kxy.kxu != null) {
                            this.kxC.kxy.kxu.a(j3, z2, j4);
                            if (i != 0) {
                                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[]{b.cK(j3)});
                            }
                        }
                        if (i != 0) {
                            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[]{b.cK(j3)});
                            this.kxC.kxy.kwL.remove(Long.valueOf(j3));
                            this.kxC.kxy.kxw.remove(Long.valueOf(j3));
                        }
                    }
                });
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[]{Integer.valueOf(this.kxy.kwL.size())});
            }

            public final void b(long j, byte[] bArr) {
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[]{b.cK(j)});
                if (this.kxy.kxu != null) {
                    this.kxy.kxu.b(j, bArr);
                } else {
                    x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
                }
            }

            public final void h(long j, boolean z) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onSend. mac = %s, success = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.cK(j);
                objArr[1] = z ? "true" : "false";
                x.d(str, str2, objArr);
                if (this.kxy.kxu != null) {
                    this.kxy.kxu.h(j, z);
                }
            }
        };
        this.tI = ac.getContext();
        this.kxu = aVar;
        this.kwN = c.arm();
        this.mRunnable = new 3(this);
        this.mHandler = new af(new ag("BluetoothLESimpleManagerThread").oAt.getLooper());
    }

    public final void t(Runnable runnable) {
        this.mLock.lock();
        runnable.run();
        this.mLock.unlock();
    }

    @TargetApi(18)
    public final boolean ark() {
        return this.tI.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}

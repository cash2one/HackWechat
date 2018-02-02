package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.QbSdk;

class g extends a$a {
    private final af handler = new af(Looper.getMainLooper());
    private final v2engine sar = new v2engine();

    static {
        int yp = m.yp();
        x.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(yp)});
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec_v7a.so");
        } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec.so");
        } else {
            d.t(ac.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", g.class.getClassLoader());
    }

    public final int uninitLive() {
        return ((Integer) new 1(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)).b(this.handler)).intValue();
    }

    public final int SetCurrentMicId(final int i) {
        return ((Integer) new bc<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g sav;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.sav.sar.SetCurrentMicId(i));
            }
        }.b(this.handler)).intValue();
    }

    public final int Close() {
        return ((Integer) new bc<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g sav;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.sav.sar.Close());
            }
        }.b(this.handler)).intValue();
    }

    public final int bEv() {
        return ((Integer) new bc<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g sav;

            protected final /* synthetic */ Object run() {
                x.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(m.yp())});
                x.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", new Object[]{Integer.valueOf(this.sav.sar.initLive(r0, e.gZJ + "app_lib/"))});
                return Integer.valueOf(this.sav.sar.initLive(r0, e.gZJ + "app_lib/"));
            }
        }.b(this.handler)).intValue();
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        short[] sArr = new short[iArr2.length];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        return ((Integer) new 5(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE), bVar, i, i2, i3, j, iArr, sArr, i4).b(this.handler)).intValue();
    }

    public final byte[] d(int[] iArr, String str) {
        return (byte[]) new 6(this, iArr, str).b(this.handler);
    }

    public final e a(c cVar) {
        return (e) new 7(this, cVar).b(this.handler);
    }

    public final d bEw() {
        return (d) new 8(this).b(this.handler);
    }
}

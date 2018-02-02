package com.tencent.mm.plugin.api;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.plugin.mmsight.api.a.a {
    public final com.tencent.mm.plugin.mmsight.api.a a(String str, String str2, int i, int i2, int i3, int i4) {
        int i5 = q.gGb.gGs;
        x.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[]{Integer.valueOf(i5)});
        if (i5 != -1) {
            if (i5 == 1) {
                return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i, i2, i3, i4);
            }
            if (i5 == 2) {
                return new b(str, str2, i, i2, i3, i4);
            }
        }
        if (d.fM(19)) {
            return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i, i2, i3, i4);
        }
        return new b(str, str2, i, i2, i3, i4);
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        int i5 = q.gGb.gGs;
        x.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[]{Integer.valueOf(i5)});
        if (i5 != -1) {
            if (i5 == 1) {
                return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i, i2, i3, i4, j, j2);
            }
            if (i5 == 2) {
                return new b(str, str2, i, i2, i3, i4, j, j2);
            }
        }
        if (d.fM(19)) {
            return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i, i2, i3, i4, j, j2);
        }
        return new b(str, str2, i, i2, i3, i4, j, j2);
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(int i, String str, String str2, int i2, int i3, int i4, int i5) {
        if (i == 1) {
            return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i2, i3, i4, i5);
        }
        if (i == 2) {
            return new b(str, str2, i2, i3, i4, i5);
        }
        return null;
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(int i, String str, String str2, int i2, int i3, int i4, int i5, long j, long j2) {
        if (i == 1) {
            return new com.tencent.mm.plugin.mmsight.model.b.a(str, str2, i2, i3, i4, i5, j, j2);
        }
        if (i == 2) {
            return new b(str, str2, i2, i3, i4, i5, j, j2);
        }
        return null;
    }
}

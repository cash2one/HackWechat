package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.handler.image.a$a;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b {

    private static final class d extends a$a {
        private final e irF;

        private d(e eVar) {
            this.irF = eVar;
        }

        public final boolean bE(String str) {
            return true;
        }

        public final InputStream bF(String str) {
            if (this.irF == null) {
                x.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", new Object[]{str});
                return null;
            }
            h hVar = new h();
            if (this.irF.iqz.a(str, hVar) == j.OK && hVar.jRK != null) {
                return new a((ByteBuffer) hVar.jRK);
            }
            x.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", new Object[]{str, r1.name()});
            return null;
        }
    }
}

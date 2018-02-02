package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ah extends ad {
    private br ndC;

    public ah(a aVar) {
        if (aVar == null) {
            this.ndC = new br();
        } else {
            this.ndC = (br) aVar;
        }
    }

    public ah(byte[] bArr) {
        this.ndC = new br();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndC.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final q aQJ() {
        return this.ndC != null ? this.ndC.nip : null;
    }

    public final ay aQK() {
        return this.ndC != null ? this.ndC.nih : null;
    }
}

package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements d {
    private IsoDep oRY;

    public b(Tag tag) {
        if (tag == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            throw new IllegalStateException("tag is null");
        } else {
            this.oRY = IsoDep.get(tag);
        }
    }

    public final boolean connect() {
        if (!this.oRY.isConnected()) {
            this.oRY.connect();
        }
        return true;
    }

    public final void close() {
        if (this.oRY.isConnected()) {
            this.oRY.close();
        }
    }

    public final boolean isConnected() {
        return this.oRY.isConnected();
    }

    public final boolean bfw() {
        close();
        connect();
        return true;
    }

    public final c a(a aVar) {
        if (this.oRY == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            throw new IllegalStateException("IsoDep is null");
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.oRY.transceive(aVar.getBytes()));
            if (cVar2.oRI.length == 0) {
                return cVar;
            }
            if (cVar2.oRI.length - 2 <= 0) {
                return cVar2;
            }
            if (cVar2.bft() == (short) 108) {
                aVar.tV(cVar2.bfu());
            } else {
                if (cVar == null) {
                    cVar = cVar2;
                } else {
                    cVar.a(cVar2);
                }
                if (cVar2.bft() != (short) 97) {
                    return cVar;
                }
                aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.oRQ.clone());
            }
        }
    }
}

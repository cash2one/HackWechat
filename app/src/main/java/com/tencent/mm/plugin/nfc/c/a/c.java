package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements d {
    private NfcA oRZ;

    public c(Tag tag) {
        this.oRZ = NfcA.get(tag);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        if (this.oRZ == null) {
            x.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            throw new IllegalStateException("NfcA is null");
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.oRZ.transceive(aVar.getBytes()));
            if (cVar2.oRI.length == 0) {
                return cVar;
            }
            if (cVar2.oRI.length - 2 < 0) {
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
                if (cVar2.bfu() != (short) 0) {
                    aVar = new a((byte[]) b.oRQ.clone());
                } else {
                    cVar.oRI[cVar.oRI.length - 1] = (byte) -112;
                    return cVar;
                }
            }
        }
    }

    public final boolean connect() {
        if (!this.oRZ.isConnected()) {
            this.oRZ.connect();
        }
        return true;
    }

    public final void close() {
        if (this.oRZ.isConnected()) {
            this.oRZ.close();
        }
    }

    public final boolean isConnected() {
        return this.oRZ.isConnected();
    }

    public final boolean bfw() {
        close();
        connect();
        return true;
    }
}

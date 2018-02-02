package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.ar;
import com.tencent.mm.plugin.game.c.bn;
import com.tencent.mm.plugin.game.c.ch;
import com.tencent.mm.plugin.game.c.ec;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class aj extends ad {
    private bn ndM;
    public ch ndN;
    public a ndO;
    public ak ndP;
    public ec ndQ;
    public ar ndR;

    public aj(bn bnVar) {
        if (bnVar == null) {
            this.ndM = new bn();
            return;
        }
        this.ndM = bnVar;
        fC(true);
    }

    public aj(byte[] bArr) {
        this.ndM = new bn();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndM.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", e.getMessage());
            }
            fC(false);
        }
    }

    private void fC(boolean z) {
        if (this.ndM != null) {
            this.ndN = this.ndM.niB;
            if (!(this.ndM.niy == null || this.ndM.niy.nfh == null)) {
                this.ndO = new a();
                this.ndO.ndK = a(this.ndM.niy.nfh);
                if (this.ndO.ndK != null) {
                    this.ndO.ndK.naQ = this.ndM.niy.nfe;
                    this.ndO.ndK.scene = 10;
                    this.ndO.ndK.fFj = 1002;
                    this.ndO.ndK.position = 1;
                }
                this.ndO.ndS = this.ndM.niy.ngR;
                this.ndO.ndT = this.ndM.niy.ngQ;
                this.ndO.desc = this.ndM.niy.nfe;
                this.ndO.ndU = this.ndM.niA;
            }
            this.ndP = this.ndM.niz;
            this.ndQ = this.ndM.nik;
            this.ndR = this.ndM.niC;
        }
        if (this.ndM != null && z) {
            if (!(this.ndM.niy == null || this.ndM.niy.nfh == null)) {
                d.a(a(this.ndM.niy.nfh));
            }
            SubCoreGameCenter.aRj().init(ac.getContext());
        }
    }
}

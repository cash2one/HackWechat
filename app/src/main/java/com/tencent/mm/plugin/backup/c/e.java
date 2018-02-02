package com.tencent.mm.plugin.backup.c;

import android.os.Looper;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.a.1;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class e {
    com.tencent.mm.plugin.backup.a.e kiE;
    LinkedList<ov> klN;
    String klO;
    private String klP = "";
    private boolean klQ = false;
    a klR;
    private ak klS = new ak(Looper.getMainLooper(), new 1(this), true);
    final com.tencent.mm.ae.e klT = new 2(this);
    final com.tencent.mm.ae.e klU = new 3(this);

    public e(a aVar, com.tencent.mm.plugin.backup.a.e eVar) {
        this.klR = aVar;
        this.kiE = eVar;
    }

    public final void start() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", Boolean.valueOf(this.klQ), Boolean.valueOf(this.klS.cfK()), this, bh.cgy());
        if (!this.klQ) {
            this.klQ = true;
            if (apj()) {
                this.klP = null;
                api();
            } else {
                this.kiE.kiJ = -4;
                this.klR.k(-4, null);
            }
            this.klS.J(500, 500);
        }
    }

    public final void stop() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.klQ = false;
        ar.CG().b(704, this.klT);
        ar.CG().b(1000, this.klU);
        this.klS.TG();
    }

    final void api() {
        String cl = g.cl(ac.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", cl, this.klP, Boolean.valueOf(ar.Hj()), Boolean.valueOf(ar.Cs()));
        if (!cl.equals(this.klP) && ar.Hj()) {
            this.klP = cl;
            if (apj()) {
                this.klQ = false;
                if (ar.Cs()) {
                    x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                    ar.CG().a(1000, this.klU);
                    ar.CG().a(new a(this.klN, this.klO, b.aoR().kkO), 0);
                    return;
                }
                x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                ar.CG().a(704, this.klT);
                ar.CG().a(new b(this.klN, this.klO), 0);
                return;
            }
            this.klQ = false;
        }
    }

    private boolean apj() {
        this.klN = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.klO = g.cl(ac.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", this.klO);
        if (bh.ov(this.klO)) {
            this.kiE.kiJ = -4;
            this.klR.k(-4, null);
            this.klP = "";
            return false;
        }
        int i;
        com.tencent.mm.plugin.backup.b.a aoS = b.aoR().aoS();
        aoS.mode = 0;
        x.i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Java2C.stop();
        x.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.gUo = new 1(aoS);
        Object[] access$000 = Java2C.start();
        if (access$000 == null || access$000.length != 3) {
            x.e("MicroMsg.BackupCEngine", "listen error");
            i = 0;
        } else {
            x.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", access$000[0], access$000[1], access$000[2]);
            if (((Integer) access$000[0]).intValue() != 1) {
                i = 0;
            } else {
                pString.value = (String) access$000[1];
                pInt.value = ((Integer) access$000[2]).intValue();
                aoS.mode = 1;
                i = 1;
            }
        }
        if (i == 0) {
            this.kiE.kiJ = -4;
            this.klR.k(-4, null);
            this.klP = "";
            return false;
        }
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
        ov ovVar = new ov();
        ovVar.vXG = pString.value;
        ovVar.vXH = new LinkedList();
        ovVar.vXH.add(Integer.valueOf(pInt.value));
        this.klN.add(ovVar);
        return true;
    }
}

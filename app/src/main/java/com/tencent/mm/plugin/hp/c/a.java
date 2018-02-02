package com.tencent.mm.plugin.hp.c;

import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    String nAW;
    String nAX;
    private LinkedList<bnr> nAY;
    private boolean nAZ;
    com.tencent.mm.plugin.hp.d.b nBa;

    public a() {
        this("", "", null, false);
    }

    public a(String str, String str2, List<bnr> list) {
        this(str, str2, list, true);
    }

    private a(String str, String str2, List<bnr> list, boolean z) {
        String str3;
        int i = 3;
        this.nAY = new LinkedList();
        this.nAZ = true;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new nn();
        aVar.hmk = new no();
        aVar.uri = "/cgi-bin/micromsg-bin/checktinkerupdate";
        aVar.hmi = 922;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        if (z) {
            str3 = str2;
        } else {
            int i2;
            str = "tinker_id_" + BaseBuildInfo.baseRevision();
            str3 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
            list = new LinkedList();
            long j = 0;
            try {
                j = ((long) com.tencent.mm.kernel.a.CA()) & 4294967295L;
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "uin is %s", new Object[]{bh.VT(String.valueOf(j))});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
            }
            list.add(cT("code-version", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION));
            list.add(cT("code-reversion", com.tencent.mm.sdk.platformtools.e.REV));
            String str4 = TencentLocation.NETWORK_PROVIDER;
            if (an.isWifi(ac.getContext())) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            list.add(cT(str4, String.valueOf(i2)));
            list.add(cT("sdk", String.valueOf(VERSION.SDK_INT)));
            list.add(cT("os-name", d.vAv));
            list.add(cT("device-brand", d.vAs));
            list.add(cT("device-name", d.vAx));
            list.add(cT(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)));
            String str5 = TencentLocation.NETWORK_PROVIDER;
            if (!an.isWifi(ac.getContext())) {
                i = 2;
            }
            list.add(cT(str5, String.valueOf(i)));
        }
        this.nAW = str;
        this.nAX = str3;
        this.nAY.addAll(list);
        this.nAZ = z;
    }

    public final int getType() {
        return 922;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "doScene");
        this.gJT = eVar2;
        nn nnVar = (nn) this.gJQ.hmg.hmo;
        nnVar.vWs = this.nAW;
        nnVar.vWt = this.nAX;
        nnVar.vWu = this.nAY;
        c.a(new 1(this, nnVar));
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            no noVar = (no) ((b) qVar).hmh.hmo;
            bnv com_tencent_mm_protocal_c_bnv = noVar.vWv;
            if (com_tencent_mm_protocal_c_bnv == null) {
                if (str.equalsIgnoreCase("no baseid matched")) {
                    com.tencent.mm.plugin.hp.b.a.cH(1, 0);
                } else if (str.equalsIgnoreCase("no update for this patch")) {
                    com.tencent.mm.plugin.hp.b.a.cH(2, 0);
                } else if (str.equalsIgnoreCase("no sutable patch available")) {
                    com.tencent.mm.plugin.hp.b.a.cH(3, 0);
                } else {
                    com.tencent.mm.plugin.hp.b.a.cH(5, 0);
                }
                if (this.nBa != null) {
                    String str2 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
                    if (!(bh.ov(this.nBa.nBq) || this.nBa.nBq.equalsIgnoreCase(str2))) {
                        int i4 = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i4 >= 4) {
                            g.ai(ac.getContext(), "");
                            g.E(ac.getContext(), 0);
                            x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[]{Integer.valueOf(i4)});
                            com.tencent.mm.plugin.report.service.g.pQN.a(614, 74, 1, false);
                        } else {
                            new com.tencent.mm.plugin.hp.b.e(this.nBa).fN(true);
                            com.tencent.mm.plugin.report.service.g.pQN.a(614, 70, 1, false);
                            g.E(ac.getContext(), i4 + 1);
                            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[]{Integer.valueOf(i4)});
                        }
                    }
                }
            } else if (this.nAZ) {
                try {
                    g.ai(ac.getContext(), new String(Base64.encode(noVar.toByteArray(), 0)));
                    g.E(ac.getContext(), 0);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "save node failed.", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.pQN.a(614, 72, 1, false);
                }
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(com_tencent_mm_protocal_c_bnv);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new com.tencent.mm.plugin.hp.b.e(bVar).fN(false);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                com.tencent.mm.plugin.hp.b.a.cH(4, 0);
            } else {
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
            }
        } else {
            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.cH(5, i2);
        }
        this.gJT.a(i2, i3, str, this);
    }

    private static bnr cT(String str, String str2) {
        bnr com_tencent_mm_protocal_c_bnr = new bnr();
        com_tencent_mm_protocal_c_bnr.aAM = str;
        com_tencent_mm_protocal_c_bnr.value = str2;
        return com_tencent_mm_protocal_c_bnr;
    }
}

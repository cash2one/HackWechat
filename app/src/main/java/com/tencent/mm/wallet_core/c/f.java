package com.tencent.mm.wallet_core.c;

import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public boolean fHt = true;
    private int zHm = 0;
    private a zHn = null;

    public interface a {
        void bMW();
    }

    private static void az(Map<String, String> map) {
        int i;
        int i2 = 1;
        g.Dk();
        g.Dh();
        String string = o.getString(com.tencent.mm.kernel.a.Cg());
        String deviceID = q.getDeviceID(ac.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = n.cBr().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i3 = 0;
        int i4 = 0;
        do {
            bArr[i4] = bytes[i3];
            i4++;
            i3++;
            if (i3 >= bytes.length) {
                i3 = 0;
                continue;
            }
        } while (i4 < 16);
        String str = new String(bArr);
        String UZ = ab.UZ(string + deviceID);
        String UZ2 = ab.UZ(string + UZ + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[]{string, deviceID, UZ2});
        a cBn = a.cBn();
        b.cBf();
        c fn = com.tencent.mm.z.c.c.IF().fn("100369");
        if (fn.isValid() && "1".equals(fn.chI().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if ((i > 0 ? 1 : 0) == 0) {
            i2 = 0;
        }
        String dB = cBn.dB(UZ2, i2);
        try {
            map.put("sn_salt", p.encode(str));
            map.put("crt_csr", p.encode(dB));
            map.put("crt_device_id", UZ);
            map.put("device_os", d.DEVICE_TYPE);
            map.put("device_name", d.vAv);
        } catch (Exception e) {
        }
    }

    public f(String str, int i, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.zHm = 1;
        az(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("1"));
        hashMap.put("true_name", p.encode(str2));
        hashMap.put("id_no", p.encode(str));
        hashMap.put("id_type", p.encode(String.valueOf(i)));
        D(hashMap);
        aB(hashMap2);
    }

    public f(String str, String str2, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.fHt = z;
        this.zHm = 2;
        az(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("2"));
        hashMap.put("crt_sms", p.encode(str));
        hashMap.put("reqkey", p.encode(str2));
        this.zHn = aVar;
        D(hashMap);
        aB(hashMap2);
    }

    public f(String str, String str2, String str3, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.zHm = 4;
        this.zHn = aVar;
        this.fHt = z;
        az(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("4"));
        hashMap.put("id_type", p.encode(str));
        hashMap.put("cre_tail", p.encode(str2));
        hashMap.put("reqkey", p.encode(str3));
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 1580;
    }

    public final int Hr() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[]{Integer.valueOf(i), str});
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            com.tencent.mm.plugin.report.service.g.pQN.a(414, 0, 1, true);
            boolean importCert = a.cBn().importCert(optString2, optString);
            r.aav(optString2);
            if (importCert) {
                com.tencent.mm.plugin.report.service.g.pQN.a(414, 1, 1, true);
                x.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(414, 2, 1, true);
                x.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.zHm == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13731, new Object[]{Integer.valueOf(3)});
            } else if (this.zHm == 2) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13731, new Object[]{Integer.valueOf(7)});
            }
            x.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[]{ab.UZ(optString), optString2});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
        }
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cBn().cBo();
        if (cVar.errCode != 0) {
            if (this.zHm == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13731, new Object[]{Integer.valueOf(4)});
            } else if (this.zHm == 2) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13731, new Object[]{Integer.valueOf(8)});
            }
        }
        if (this.zHn == null) {
            return;
        }
        if (!this.fHt || cVar.errCode == 0) {
            this.zHn.bMW();
        }
    }

    public final boolean bhd() {
        return this.fHt;
    }
}

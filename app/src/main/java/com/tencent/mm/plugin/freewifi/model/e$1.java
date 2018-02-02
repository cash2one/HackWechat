package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class e$1 implements e {
    final /* synthetic */ bw kvv;
    final /* synthetic */ e mEf;

    e$1(e eVar, bw bwVar) {
        this.mEf = eVar;
        this.kvv = bwVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (m.cz(i, i2)) {
            long j = ((d) kVar).aMd().vVU;
            if (j == 0) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                return;
            }
            e eVar = this.mEf;
            bw bwVar = this.kvv;
            nb aMd = ((d) kVar).aMd();
            if (bwVar == null || bwVar.vGZ == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                return;
            }
            String a = n.a(bwVar.vGZ);
            x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(bwVar.vHe), a});
            if (m.AA(a)) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                return;
            }
            a AH = a.AH(a);
            if (AH == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                return;
            }
            Matcher matcher;
            com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
            aVar.mFJ = AH.mDO;
            aVar.mFL = AH.mDP;
            aVar.mFK = AH.bssid;
            aVar.mFP = AH.ssid;
            aVar.mFT = AH.mDR;
            aVar.mFN = AH.mDN;
            aVar.mFM = AH.mDQ;
            String AF = m.AF("MicroMsg.FreeWifi.FreeWifiMessageService");
            aVar.fpA = AF;
            aVar.mFO = AF.equals(AH.mDN) ? 0 : 1;
            String AD = m.AD("MicroMsg.FreeWifi.FreeWifiMessageService");
            aVar.mFQ = AD;
            aVar.mFR = AD.equals(AH.ssid) ? 0 : 1;
            aVar.mFS = j;
            aVar.mFT = AH.mDR;
            int i3 = j > AH.mDR ? 1 : 0;
            aVar.mFU = i3 == 1 ? 1 : 0;
            aVar.mFY = aMd.vVL;
            aVar.mFZ = AD;
            boolean equals = AD.equals(aMd.vVL);
            aVar.mGa = equals ? 1 : 0;
            aVar.mFV = 1;
            aVar.mFW = aMd.vVT;
            CharSequence charSequence = AH.mDQ;
            if (!m.AA(charSequence)) {
                matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                if (matcher.find()) {
                    aVar.mFX = matcher.group(2);
                }
            }
            e.a(aVar);
            if (!equals) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                return;
            } else if (i3 != 0) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                return;
            } else if (aMd.vVT == 0 && !m.AA(charSequence)) {
                matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                if (matcher.find()) {
                    Object group = matcher.group(1);
                    try {
                        a = URLDecoder.decode(group, "utf8");
                        AF = matcher.group(2);
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ap_key", a);
                        intent.putExtra("free_wifi_source", 5);
                        intent.putExtra("free_wifi_threeone_startup_type", 3);
                        intent.putExtra("free_wifi_schema_ticket", AF);
                        intent.putExtra("free_wifi_sessionkey", AF);
                        if (!eVar.mEe.equals(AF)) {
                            eVar.mEe = AF;
                            b.aMk();
                            b.I(intent);
                            return;
                        }
                        return;
                    } catch (UnsupportedEncodingException e) {
                        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[]{"", Integer.valueOf(0), charSequence, group, e.getMessage()});
                        return;
                    }
                }
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
        aVar2.mFI = i2;
        aVar2.mFH = i;
        e.a(aVar2);
    }
}

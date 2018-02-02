package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bi;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    int action;
    private e gJT;
    final b hFi;
    private long qpF;

    public d(Collection<a> collection, float f, float f2, int i) {
        this.action = 1;
        this.qpF = 0;
        this.action = 1;
        b.a aVar = new b.a();
        aVar.hmj = new akr();
        aVar.hmk = new aks();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.hmi = 658;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        bi HQ = bi.HQ();
        String ou = bh.ou(HQ.hhx);
        String ou2 = bh.ou(HQ.hhw);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        akr com_tencent_mm_protocal_c_akr = (akr) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_akr.wrU = bh.ou(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Beacons\":[");
        if (collection != null) {
            int size = collection.size();
            int i2 = 0;
            for (a aVar2 : collection) {
                stringBuilder.append("{\"UUID\":\"" + aVar2.ned + "\",\"Location\":{\"Major\":" + aVar2.major + ",\"Minor\":" + aVar2.minor + "},\"Distance\":" + aVar2.hLU + ",\"Extra\":\"\",\"MacAddress\":\"" + aVar2.qpP + "\",\"Rssi\":\"" + aVar2.qpQ + "\",\"MeasurePower\":\"" + aVar2.qpR + "\"}");
                if (i2 < size - 1) {
                    stringBuilder.append(",");
                }
                i2++;
            }
        }
        int i3 = 1;
        boolean hasSystemFeature = ac.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i3 = 0;
        }
        stringBuilder.append("],\"Action\":1" + ",\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + ou + "\",\"City\":\"" + ou2 + "\"},\"MachineID\":\"" + q.yF() + "\",\"ZBBeaconState\":\"" + i3 + "\"}");
        com_tencent_mm_protocal_c_akr.nje = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        ou = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = com_tencent_mm_protocal_c_akr.nje;
        x.i(str, ou, objArr);
        o.a(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER, f2, f, i);
    }

    public final int getType() {
        return 658;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.qpF = System.currentTimeMillis();
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
        this.qpF = System.currentTimeMillis() - this.qpF;
        g.pQN.h(11497, new Object[]{String.valueOf((int) (((double) (this.qpF / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.qpF)});
        int i4;
        String string;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            aks com_tencent_mm_protocal_c_aks = (aks) this.hFi.hmh.hmo;
            try {
                JSONObject jSONObject = new JSONObject(((akr) this.hFi.hmg.hmo).nje);
                JSONArray jSONArray = jSONObject.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject2 = jSONObject.getJSONObject("LBS");
                i4 = jSONObject.getInt("Action");
                String string2 = jSONObject2.getString("Latitude");
                string = jSONObject2.getString("Longitude");
                if (length > 0) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                    String string3 = jSONObject3.getString("UUID");
                    jSONObject3 = jSONObject3.getJSONObject("Location");
                    int i5 = jSONObject3.getInt("Major");
                    int i6 = jSONObject3.getInt("Minor");
                    if (com_tencent_mm_protocal_c_aks.wrV.vVT == 0) {
                        String str2 = com_tencent_mm_protocal_c_aks.wrV.nfU;
                        if (i4 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                            g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_aks.wrV.vVT)});
                            return;
                        }
                        return;
                    }
                    g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_aks.wrV.vVT)});
                    return;
                }
                g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_aks.wrV.vVT)});
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                return;
            }
        }
        x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
        try {
            jSONObject3 = new JSONObject(((akr) this.hFi.hmg.hmo).nje);
            JSONArray jSONArray2 = jSONObject3.getJSONArray("Beacons");
            i4 = jSONArray2.length();
            jSONObject3 = jSONObject3.getJSONObject("LBS");
            String string4 = jSONObject3.getString("Latitude");
            String string5 = jSONObject3.getString("Longitude");
            if (i4 > 0) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                string = jSONObject4.getString("UUID");
                jSONObject4 = jSONObject4.getJSONObject("Location");
                int i7 = jSONObject4.getInt("Major");
                int i8 = jSONObject4.getInt("Minor");
                g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
                return;
            }
            g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
        } catch (JSONException e2) {
            x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        }
    }
}

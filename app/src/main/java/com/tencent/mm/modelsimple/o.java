package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

public final class o extends k implements com.tencent.mm.network.k {
    private static Map<String, Long> hMW = new HashMap();
    private static Map<String, String> hMX;
    private boolean fxo = false;
    private e gJT;
    private final b hMV;
    private c<a> hMY;

    static /* synthetic */ void av(String str, String str2) {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("disaster_pref", 4);
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!bh.ov(string)) {
            string = string + ";";
        }
        string = string + str + "," + bh.Wo();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        hMX.put(str, str2);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", new Object[]{sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, "")});
    }

    public o(int i, boolean z) {
        b.a aVar = new b.a();
        aVar.hmj = new abm();
        aVar.hmk = new abn();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.hmi = 775;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hMV = aVar.JZ();
        this.hMV.fJZ = 1;
        ((abm) this.hMV.hmg.hmo).fxn = i;
        this.fxo = z;
        RO();
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.fxo), bh.cgy()});
    }

    public final int getType() {
        return 775;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        abm com_tencent_mm_protocal_c_abm = (abm) this.hMV.hmg.hmo;
        long a = bh.a((Long) hMW.get(com_tencent_mm_protocal_c_abm.fxn), 0);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_abm.fxn), Long.valueOf(a), hMW});
        if (a == 0 || bh.bA(a) >= 1800000) {
            String az = bh.az((String) hMX.get(com_tencent_mm_protocal_c_abm.fxn), "");
            if (bh.ov(az)) {
                this.gJT = eVar2;
                return a(eVar, this.hMV, this);
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_abm.fxn), az});
            H(az, false);
            return -1;
        }
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_abm.fxn)});
        return -1;
    }

    private void H(String str, boolean z) {
        ar.Dm().F(new 1(this, str, z));
    }

    private synchronized void RO() {
        if (hMX == null) {
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            hMX = new HashMap();
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("disaster_pref", 4);
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!bh.ov(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    String str = "";
                    for (String string2 : split) {
                        String[] split2 = string2.split(",");
                        try {
                            if (bh.getLong(split2[0], 0) > 0) {
                                if (bh.by(bh.getLong(split2[1], 0)) < 86400) {
                                    String string3 = sharedPreferences.getString(split2[0], "");
                                    if (!bh.ov(string3)) {
                                        str = str + split2[0] + "," + split2[1] + ";";
                                        hMX.put(split2[0], string3);
                                    }
                                } else {
                                    edit.remove(split2[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[]{e.getMessage()});
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", str).commit();
                    x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[]{str, hMW});
                }
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[]{hMX});
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            H(((abn) this.hMV.hmh.hmo).content, true);
        }
        this.gJT.a(i2, i3, str, this);
    }
}

package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public final class g {
    private static e hnN = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof e) {
                com.tencent.mm.kernel.g.CG().b(1947, g.hnN);
                if (i == 0 && i2 == 0) {
                    bxu com_tencent_mm_protocal_c_bxu = ((e) kVar).rTS;
                    x.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[]{com_tencent_mm_protocal_c_bxu.vHJ});
                    String str2 = com_tencent_mm_protocal_c_bxu.vHJ;
                    if (ac.cfw()) {
                        ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().setString(2, str2);
                        g.Mh(com_tencent_mm_protocal_c_bxu.vHJ);
                        a aVar = ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getDeviceStepManager().rTI;
                        if (aVar != null) {
                            try {
                                aVar.Mg(com_tencent_mm_protocal_c_bxu.vHJ);
                            } catch (RemoteException e) {
                            }
                        }
                        if (g.rTW != null) {
                            g.rTW.bDb();
                            return;
                        }
                        return;
                    }
                    throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ac.Br()}));
                }
            }
        }
    };
    private static long rTU;
    private static JSONObject rTV;
    private static a rTW;

    public static boolean bDq() {
        if (rTU == 0) {
            rTU = i.K(1, 0);
        }
        if (System.currentTimeMillis() - rTU > 86400000) {
            rTU = System.currentTimeMillis();
            i.L(1, rTU);
            x.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            com.tencent.mm.kernel.g.CG().a(1947, hnN);
            com.tencent.mm.kernel.g.CG().a(new e(), 0);
            return true;
        }
        x.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[]{n.bp(rTU)});
        return false;
    }

    public static void Mh(String str) {
        if (!bh.ov(str)) {
            try {
                rTV = new JSONObject(str);
            } catch (Exception e) {
                rTV = null;
            }
        }
    }

    public static JSONObject bDr() {
        if (rTV == null) {
            String str = "";
            String string = ac.cfw() ? ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().getString(2, str) : new h(com.tencent.mm.plugin.sport.b.a.rTD).getString(2, str);
            str = "";
            if (!bh.ov(string)) {
                try {
                    rTV = new JSONObject(string);
                    string = "server config";
                } catch (Exception e) {
                }
                if (rTV == null) {
                    rTV = bDs();
                    string = "asset";
                }
                if (rTV == null) {
                    rTV = new JSONObject();
                    string = "new";
                }
                x.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{string, rTV.toString()});
            }
            string = str;
            if (rTV == null) {
                rTV = bDs();
                string = "asset";
            }
            if (rTV == null) {
                rTV = new JSONObject();
                string = "new";
            }
            x.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{string, rTV.toString()});
        }
        return rTV;
    }

    private static JSONObject bDs() {
        JSONObject jSONObject;
        InputStream inputStream = null;
        try {
            inputStream = ac.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(b.d(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e2, "get assets sport config json", new Object[0]);
            jSONObject = new JSONObject();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return jSONObject;
    }

    public static void a(a aVar) {
        rTW = aVar;
    }
}

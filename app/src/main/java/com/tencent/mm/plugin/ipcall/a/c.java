package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.ipcall.a.g.i;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c nCq;
    public boolean isInit = false;
    private ArrayList<Integer> nCr = new ArrayList();
    ArrayList<Integer> nCs = new ArrayList();

    private c() {
    }

    public static c aTj() {
        if (nCq == null) {
            nCq = new c();
        }
        return nCq;
    }

    public final void fP(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        if (!this.isInit || z) {
            aTl();
            try {
                File file = new File(e.gZK + "ipcallCountryCodeConfig.cfg");
                String str;
                if (file.exists()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                x.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[]{str});
                                CA(str);
                                this.isInit = true;
                                com.tencent.mm.a.e.c(fileInputStream);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            x.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                            com.tencent.mm.a.e.c(inputStream);
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.mm.a.e.c(inputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        com.tencent.mm.a.e.c(inputStream);
                        throw e;
                    }
                }
                x.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[]{str});
                this.isInit = true;
                com.tencent.mm.a.e.c(null);
            } catch (Exception e3) {
                e = e3;
                x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                x.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                com.tencent.mm.a.e.c(inputStream);
            }
        }
    }

    private void CA(String str) {
        if (!bh.ov(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
                x.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[]{Integer.valueOf(jSONArray.length())});
                this.nCs.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.nCs.add(Integer.valueOf(jSONArray.getInt(i)));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                x.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void aTk() {
        this.nCr.clear();
        String value = g.zY().getValue("WeChatOutTopCountryCode");
        x.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[]{value});
        if (!bh.ov(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                int i = length;
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(bh.getInt(str, 0));
                    this.nCr.add(valueOf);
                    i.aTF().x(valueOf.intValue(), (long) i);
                    i--;
                }
            } catch (NumberFormatException e) {
                x.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aTl() {
        j aTF = i.aTF();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor a = aTF.gJP.a("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            if (arrayList.size() <= 0) {
                this.nCr = arrayList;
            } else {
                aTk();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        do {
            i iVar = new i();
            iVar.b(a);
            arrayList.add(Integer.valueOf(iVar.field_countryCode));
        } while (a.moveToNext());
        if (a != null) {
            a.close();
        }
        if (arrayList.size() <= 0) {
            aTk();
        } else {
            this.nCr = arrayList;
        }
    }

    public final List<Integer> aTm() {
        if (!this.isInit) {
            fP(false);
        }
        return this.nCr;
    }

    public final boolean rq(int i) {
        if (!this.isInit) {
            fP(false);
        }
        if (this.nCs == null || this.nCs.size() <= 0) {
            return false;
        }
        return this.nCs.contains(Integer.valueOf(i));
    }
}

package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class aa$a extends l<String, String, Boolean> {
    private String aAM;
    private SharedPreferences gZO;
    final /* synthetic */ aa qUY;
    private String qUZ;
    PInt qVa;
    PInt qVb;
    private String qVc;
    private String username;

    public final /* synthetic */ Object buP() {
        return buU();
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        x.d("MicroMsg.RemoveSnsTask", "onPostExecute " + bool);
        aa.d(this.qUY);
        if (bool.booleanValue()) {
            aa.b(this.qVa, this.qVb);
            if (this.gZO != null) {
                this.gZO.edit().putInt(this.qUZ, this.qVa.value).commit();
                this.gZO.edit().putInt(this.aAM, this.qVb.value).commit();
                x.d("MicroMsg.RemoveSnsTask", "update dir " + this.qVa.value + " " + this.qVb.value + " cleanCount: " + aa.a(this.qUY));
            }
            aa.e(this.qUY).sendEmptyMessageDelayed(0, 20000);
        }
        aa.a(this.qUY, false);
    }

    public aa$a(aa aaVar) {
        this.qUY = aaVar;
        this.gZO = null;
        this.qUZ = "";
        this.aAM = "";
        this.qVa = new PInt();
        this.qVb = new PInt();
        this.gZO = ac.getContext().getSharedPreferences("preferences_remove_task", 0);
        g.Dk();
        if (g.Dh().Cy()) {
            this.username = q.FS();
            this.qUZ = "remove_key_base" + this.username;
            this.aAM = "remove_key" + this.username;
            g.Dk();
            if (g.Dh().Cy() && !ae.bve() && ae.EV() != null && ae.bvz() != null) {
                k Lq = ae.bvz().Lq(this.username);
                if (Lq != null) {
                    this.qVc = Lq.field_bgId;
                }
                x.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[]{this.qVc});
                aa.a(aaVar, true);
            }
        }
    }

    private Boolean buU() {
        x.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
        if (!aa.nSI) {
            return Boolean.valueOf(false);
        }
        if (!aa.c(this.qUY)) {
            return Boolean.valueOf(false);
        }
        if (ae.bve()) {
            aa.nSI = false;
            return Boolean.valueOf(false);
        }
        this.qVa.value = this.gZO.getInt(this.qUZ, 0);
        this.qVb.value = this.gZO.getInt(this.aAM, 0);
        String accSnsPath = ae.getAccSnsPath();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!aa.S(accSnsPath + aa.qUX[this.qVa.value % 36] + "/" + aa.qUX[this.qVb.value % 36], this.qVc, this.username)) {
                return Boolean.valueOf(false);
            }
            x.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.qVa.value + " " + this.qVb.value);
            return Boolean.valueOf(true);
        } catch (Exception e) {
        }
    }

    public final af buO() {
        return ae.bvh();
    }
}

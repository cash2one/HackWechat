package com.tencent.mm.plugin.backup.a;

import android.content.SharedPreferences;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean gPh = false;
    private static int kiF = 0;
    private static byte[] kiG = "key".getBytes();
    private static SharedPreferences kiI;
    public String kiB = SlookAirButtonFrequentContactAdapter.ID;
    public String kiC = "hello";
    public String kiD = "ok";
    public e kiE;
    public byte[] kiH;

    public abstract void aom();

    public abstract void aon();

    public abstract void j(Object... objArr);

    public final e aol() {
        if (this.kiE == null) {
            this.kiE = new e();
        }
        return this.kiE;
    }

    public static int aoo() {
        return kiF;
    }

    public static void mA(int i) {
        kiF = i;
    }

    public static byte[] aop() {
        return kiG;
    }

    public static void X(byte[] bArr) {
        kiG = bArr;
    }

    public static SharedPreferences aoq() {
        if (kiI == null) {
            kiI = ac.getContext().getSharedPreferences("BACKUP_CONFIG", 4);
        }
        return kiI;
    }

    public static void aor() {
        x.i(TAG, "holdReset");
        gPh = true;
    }

    public static boolean aos() {
        return gPh;
    }

    public static void aot() {
        kiG = "key".getBytes();
        kiF = 0;
        kiI = null;
        gPh = false;
    }
}

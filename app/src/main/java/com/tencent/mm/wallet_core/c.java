package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class c {
    public Bundle msB = new Bundle();
    protected a zHe;

    public abstract void a(Activity activity, int i, Bundle bundle);

    public abstract String aKG();

    public abstract void b(Activity activity, Bundle bundle);

    public abstract boolean c(Activity activity, Bundle bundle);

    public abstract void d(Activity activity, int i);

    public final c al(Bundle bundle) {
        this.msB.putAll(bundle);
        return this;
    }

    private static String cs(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", new Object[]{((Class) obj).getSimpleName()});
        } else {
            return String.format("Value: %s, ", new Object[]{obj.toString()});
        }
    }

    public final void w(Object... objArr) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("this %s, procname %s", new Object[]{this, aKG()}));
        if (objArr.length <= 0) {
            x.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            stringBuilder = stringBuilder2.toString();
        } else {
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder2.append(cs(objArr[i])).append(',');
            }
            stringBuilder2.append(cs(objArr[length]));
            stringBuilder = stringBuilder2.toString();
        }
        x.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[]{stringBuilder});
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        w("startActivity1", activity, cls, null);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        if (bundle != null) {
            intent.putExtras(bundle);
            x.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[]{intent.getExtras().toString()});
        }
        activity.startActivity(intent);
        x.d("MicroMsg.ProcessManager", "bankcard tag :" + cBi());
    }

    public final void c(Activity activity, Class<?> cls, Bundle bundle) {
        w("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.msB.putAll(bundle);
        }
        x.d("MicroMsg.ProcessManager", "bankcard tag :" + cBi());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        w("startActivity3", activity, str, str2, bundle);
        Class fk = d.fk(str, str2);
        if (fk != null) {
            c(activity, fk, bundle);
        } else {
            x.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        w("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.msB.putAll(bundle);
        }
    }

    public void C(Activity activity) {
        w("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    public final void a(Activity activity, Class<?> cls, int i) {
        w("finishActivity", activity, cls, "errCode " + i);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivity(intent);
        this.msB.putInt("key_err_code", i);
    }

    public c a(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar) {
        this.zHe = aVar;
    }

    public final void ah(Activity activity) {
        w("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.msB != null) {
            this.msB.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void l(Activity activity, Bundle bundle) {
        w("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.zHe != null) {
            this.zHe.l(0, bundle);
        }
        bundle.clear();
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent l;
        w("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.zHe != null) {
            l = this.zHe.l(i, this.msB);
        } else {
            l = intent;
        }
        if (l == null) {
            l = new Intent(activity, cls);
            l.putExtra("key_process_is_stay", z);
        } else if (!(l.getExtras() == null || l.getExtras().containsKey("key_process_is_stay"))) {
            l.putExtra("key_process_is_stay", true);
        }
        l.addFlags(67108864);
        l.putExtra("key_process_is_end", true);
        activity.startActivity(l);
        if (this.msB != null) {
            this.msB.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, String str, String str2, int i, boolean z) {
        a(activity, str, str2, i, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        Intent l;
        w("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.zHe != null) {
            l = this.zHe.l(i, this.msB);
        } else {
            l = intent;
        }
        if (l == null) {
            l = new Intent();
            l.putExtra("key_process_is_stay", z);
        } else if (!(l.getExtras() == null || l.getExtras().containsKey("key_process_is_stay"))) {
            l.putExtra("key_process_is_stay", true);
        }
        l.addFlags(67108864);
        l.putExtra("key_process_is_end", true);
        d.b(activity, str, str2, l);
        if (this.msB != null) {
            this.msB.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, Intent intent) {
        a(activity, (Class) cls, -1, intent, true);
    }

    public final void a(Activity activity, Class<?> cls, int i, boolean z) {
        a(activity, (Class) cls, i, null, z);
    }

    public final void c(Activity activity, Class<?> cls) {
        a(activity, (Class) cls, -1, null, true);
    }

    public final void d(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int cBi() {
        return this.msB.getInt("key_support_bankcard", 1);
    }

    public final boolean bMX() {
        return this.msB.getBoolean("key_is_oversea", false);
    }

    public final boolean cBj() {
        return this.msB.getInt("key_pay_flag", 0) == 2;
    }

    public final boolean cBk() {
        return this.msB.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean cBl() {
        return this.msB.getInt("key_pay_flag", 0) == 3;
    }

    public e a(MMActivity mMActivity, g gVar) {
        return null;
    }

    public boolean h(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean cBm() {
        String string = this.msB.getString("key_bank_username");
        x.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.msB.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.msB.getBoolean("key_is_follow_bank_username", false) || bh.ov(string)) {
            return false;
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(new i(string), 0);
        return true;
    }

    public int b(MMActivity mMActivity, int i) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }
}

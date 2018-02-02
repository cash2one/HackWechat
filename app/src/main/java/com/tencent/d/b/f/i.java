package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.d.a.a;
import com.tencent.d.a.c.b;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.b.e.d;
import java.nio.charset.Charset;

public class i extends d {
    private static final String AdI = ("soter_triggered_oom" + f.s(a.cFO().getBytes(Charset.forName("UTF-8"))));
    private boolean AdJ = false;
    private String AdK = "";
    private g.a AdL = new 1(this);
    private d Add;
    private String Ade = "";
    private int[] Adf;

    static /* synthetic */ void c(i iVar) {
        SharedPreferences cGa = com.tencent.d.b.b.a.cFX().cGa();
        c.d("Soter.TaskInit", "soter: ask status: %d", new Object[]{Integer.valueOf(cGa.getInt(com.tencent.d.a.c.d.cFS().Acm, 0))});
        if (Ic(cGa.getInt(com.tencent.d.a.c.d.cFS().Acm, 0)) && a.cFL()) {
            a.cFK();
        }
        for (int i : iVar.Adf) {
            String str = (String) com.tencent.d.b.b.a.cFX().cFZ().get(i, "");
            if (!f.ov(str)) {
                c.d("Soter.TaskInit", "soter: %s status: %d", new Object[]{str, Integer.valueOf(cGa.getInt(str, 0))});
                if (Ic(cGa.getInt(str, 0)) && a.abt(str)) {
                    a.bs(str, false);
                }
            }
        }
    }

    public i(Context context, e eVar) {
        boolean z = false;
        b bVar = eVar.Adg;
        if (bVar != null) {
            c.a(bVar);
        }
        com.tencent.d.b.b.a cFX = com.tencent.d.b.b.a.cFX();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (com.tencent.d.b.b.a.class) {
            cFX.AcE = sharedPreferences;
        }
        g.a(this.AdL);
        a.setUp();
        if (a.cFI() && a.ic(context)) {
            z = true;
        }
        this.AdJ = z;
        this.Add = eVar.Add;
        this.Adf = eVar.Adf;
        this.Ade = eVar.Ade;
        this.AdK = eVar.Adh;
    }

    final boolean cGg() {
        int[] iArr = this.Adf;
        int i = (iArr == null || iArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.d.b.a.d(27, "no business scene provided"));
            return true;
        }
        if (f.ou(this.Ade).length() > 16) {
            c.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String s = f.s(this.Ade.getBytes(Charset.forName("UTF-8")));
            s = (f.ov(s) || s.length() < 16) ? null : s.substring(0, 16);
            if (f.ov(s)) {
                c.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                b(new com.tencent.d.b.a.d(28, "the account salt length is too long"));
                return true;
            }
            this.Ade = s;
        }
        if (f.ov(this.AdK) || this.AdK.length() <= 24) {
            if (this.Add == null) {
                c.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!f.ov(this.AdK)) {
                c.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                com.tencent.d.a.c.d.cFS().Acm = this.AdK;
            }
            g.cGk().A(new 2(this));
            return false;
        }
        c.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        b(new com.tencent.d.b.a.d(29, "the passed ask name is too long (larger than 24)"));
        return true;
    }

    final void cGh() {
    }

    final void execute() {
        if (!this.AdJ) {
            b(new com.tencent.d.b.a.d(2));
            synchronized (com.tencent.d.b.b.a.class) {
                com.tencent.d.b.b.a.cFX().nU(false);
                com.tencent.d.b.b.a.cFX().cFY();
            }
        } else if (this.Add == null) {
            com.tencent.d.b.b.a.cFX().nU(true);
            com.tencent.d.b.b.a.cFX().cFY();
            b(new com.tencent.d.b.a.d(0));
        } else {
            this.Add.bq(new d.a(a.cFO()));
            this.Add.a(new 3(this));
            this.Add.execute();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void b(String str, int[] iArr) {
        for (int put : iArr) {
            com.tencent.d.b.b.a.cFX().cFZ().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), f.ou(str), Integer.valueOf(iArr[r0])}));
        }
    }

    private static boolean Ic(int i) {
        return i == 2 || i == 1;
    }
}

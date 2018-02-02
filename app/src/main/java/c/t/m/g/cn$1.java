package c.t.m.g;

import android.os.Bundle;
import java.io.File;

class cn$1 implements Runnable {
    private /* synthetic */ cn a;

    cn$1(cn cnVar) {
        this.a = cnVar;
    }

    public final void run() {
        try {
            File file = new File(this.a.a);
            if (file.exists() && file.isFile()) {
                byte[] a = j.a(file);
                if (a != null && a.length > 0) {
                    Bundle a2 = this.a.c.a("http://analytics.map.qq.com/?sf3", a);
                    if (a2 != null && !a2.isEmpty()) {
                        file.delete();
                        new StringBuilder("upload ").append(file.getName()).append(" succeed and deleted.");
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}

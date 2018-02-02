package com.tencent.d.b.d;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;

class b$1 implements Runnable {
    final /* synthetic */ b AcO;

    b$1(b bVar) {
        this.AcO = bVar;
    }

    public final void run() {
        e cVar;
        b bVar = this.AcO;
        if ((bVar.AcI & 1) != 1) {
            if ((bVar.AcI & 2) != 2) {
                c.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                cVar = new com.tencent.d.b.a.c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
            } else if (f.ov(bVar.AcJ)) {
                c.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                cVar = new com.tencent.d.b.a.c(1, "auth key name not specified");
            }
            if (!cVar.isSuccess()) {
                b.a(this.AcO, cVar);
            } else if (a.cFI()) {
                c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                b.a(this.AcO, new com.tencent.d.b.a.c(2));
            } else {
                if ((this.AcO.AcI & 1) == 1) {
                    c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                    if (this.AcO.AcK && a.cFL()) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                        cVar = a.cFK();
                        if (!cVar.isSuccess()) {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cVar.fnL});
                            b.a(this.AcO, cVar);
                            return;
                        }
                    }
                    cVar = a.cFJ();
                    if (cVar.isSuccess()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cVar.fnL});
                        a.cFK();
                        b.a(this.AcO, cVar);
                        return;
                    }
                    c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                    b.a(this.AcO, cVar);
                }
                if ((this.AcO.AcI & 2) == 2) {
                    c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.AcO.AcJ});
                    if (a.cFM()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                        b.a(this.AcO, new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
                    }
                    if (this.AcO.AcL && a.abt(this.AcO.AcJ)) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                        cVar = a.bs(this.AcO.AcJ, false);
                        if (!cVar.isSuccess()) {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.AcO.AcJ, cVar.fnL});
                            b.a(this.AcO, cVar);
                            return;
                        }
                    }
                    cVar = a.abs(this.AcO.AcJ);
                    if (cVar.isSuccess()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.AcO.AcJ, cVar.fnL});
                        a.bs(this.AcO.AcJ, true);
                        b.a(this.AcO, cVar);
                        return;
                    }
                    c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                    b.a(this.AcO, cVar);
                    return;
                }
            }
        }
        cVar = new com.tencent.d.b.a.c(0);
        if (!cVar.isSuccess()) {
            b.a(this.AcO, cVar);
        } else if (a.cFI()) {
            if ((this.AcO.AcI & 1) == 1) {
                c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                cVar = a.cFK();
                if (cVar.isSuccess()) {
                    c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cVar.fnL});
                    b.a(this.AcO, cVar);
                    return;
                }
                cVar = a.cFJ();
                if (cVar.isSuccess()) {
                    c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                    b.a(this.AcO, cVar);
                } else {
                    c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cVar.fnL});
                    a.cFK();
                    b.a(this.AcO, cVar);
                    return;
                }
            }
            if ((this.AcO.AcI & 2) == 2) {
                c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.AcO.AcJ});
                if (a.cFM()) {
                    c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                    cVar = a.bs(this.AcO.AcJ, false);
                    if (cVar.isSuccess()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.AcO.AcJ, cVar.fnL});
                        b.a(this.AcO, cVar);
                        return;
                    }
                    cVar = a.abs(this.AcO.AcJ);
                    if (cVar.isSuccess()) {
                        c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                        b.a(this.AcO, cVar);
                        return;
                    }
                    c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.AcO.AcJ, cVar.fnL});
                    a.bs(this.AcO.AcJ, true);
                    b.a(this.AcO, cVar);
                    return;
                }
                c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                b.a(this.AcO, new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
            }
        } else {
            c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
            b.a(this.AcO, new com.tencent.d.b.a.c(2));
        }
    }
}

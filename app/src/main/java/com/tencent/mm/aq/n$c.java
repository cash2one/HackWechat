package com.tencent.mm.aq;

import com.tencent.mm.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class n$c {
    public LinkedList<n$b> hCl = new LinkedList();
    public LinkedList<n$b> hCm = new LinkedList();

    public final synchronized void Pq() {
        int i = 0;
        synchronized (this) {
            int size = this.hCl.size();
            if (size <= 0) {
                int i2 = 5 - size;
                for (size = 0; size < i2; size++) {
                    this.hCl.add(lr(null));
                }
                x.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.hCl.size())});
                Pr();
            }
            size = this.hCm.size();
            if (size <= 0) {
                size = 5 - size;
                while (i < size) {
                    this.hCm.add(ls(null));
                    i++;
                }
                Ps();
                x.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[]{Integer.valueOf(size), Integer.valueOf(this.hCm.size())});
            }
        }
    }

    public static n$b lr(String str) {
        n$b com_tencent_mm_aq_n_b = new n$b();
        if (bh.ov(str)) {
            com_tencent_mm_aq_n_b.hCk = g.Ph();
        } else {
            com_tencent_mm_aq_n_b.hCk = str;
        }
        String a = o.Pw().a(com_tencent_mm_aq_n_b.hCk, "", ".jpg", false);
        if (!lt(a)) {
            return null;
        }
        com_tencent_mm_aq_n_b.hCj = new b(a);
        return com_tencent_mm_aq_n_b;
    }

    public static n$b ls(String str) {
        n$b com_tencent_mm_aq_n_b = new n$b();
        if (bh.ov(str)) {
            com_tencent_mm_aq_n_b.hCk = g.Ph();
        } else {
            com_tencent_mm_aq_n_b.hCk = str;
        }
        String a = o.Pw().a("THUMBNAIL_DIRPATH://th_" + com_tencent_mm_aq_n_b.hCk, "th_", "", false);
        if (!lt(a)) {
            return null;
        }
        com_tencent_mm_aq_n_b.hCj = new b(a);
        return com_tencent_mm_aq_n_b;
    }

    private static boolean lt(String str) {
        if (FileOp.me(str) <= 0) {
            return true;
        }
        x.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[]{str});
        return false;
    }

    public final synchronized n$b hX(int i) {
        n$b com_tencent_mm_aq_n_b = null;
        synchronized (this) {
            if (i == 1) {
                if (this.hCl.size() > 0) {
                    com_tencent_mm_aq_n_b = (n$b) this.hCl.remove();
                    Pr();
                } else {
                    com_tencent_mm_aq_n_b = lr(null);
                }
            } else if (i == 2) {
                if (this.hCm.size() > 0) {
                    com_tencent_mm_aq_n_b = (n$b) this.hCm.remove();
                    Ps();
                } else {
                    com_tencent_mm_aq_n_b = ls(null);
                }
            }
            Pq();
        }
        return com_tencent_mm_aq_n_b;
    }

    private synchronized void Pr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.hCl.size(); i++) {
            stringBuilder.append(((n$b) this.hCl.get(i)).hCk);
            if (i != this.hCl.size() - 1) {
                stringBuilder.append("-");
            }
        }
        x.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[]{stringBuilder.toString()});
        g.Dj().CU().set(348176, stringBuilder.toString());
    }

    private synchronized void Ps() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.hCm.size(); i++) {
            stringBuilder.append(((n$b) this.hCm.get(i)).hCk);
            if (i != this.hCm.size() - 1) {
                stringBuilder.append("-");
            }
        }
        x.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[]{stringBuilder.toString()});
        g.Dj().CU().set(348177, stringBuilder.toString());
    }
}

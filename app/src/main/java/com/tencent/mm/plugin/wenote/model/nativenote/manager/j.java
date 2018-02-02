package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j implements Serializable {
    private static final Pattern tTY = Pattern.compile("\\r\\n|\\r|\\n");
    int tTZ = 0;
    public final ArrayList<n> tUa = new ArrayList();

    public j(Spanned spanned) {
        boolean z = false;
        if (spanned != null) {
            Object obj = spanned.toString();
            this.tTZ = 1;
            Matcher matcher = tTY.matcher(obj);
            int i = 0;
            while (matcher.find()) {
                boolean z2;
                int end = matcher.end();
                if (this.tTZ == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.tUa.add(new n(i, end, z2, false));
                i = matcher.end();
                this.tTZ++;
            }
            if (this.tUa.size() < this.tTZ) {
                int length = obj.length();
                if (this.tTZ == 1) {
                    z = true;
                }
                this.tUa.add(new n(i, length, z, true));
            }
        }
    }

    public final int getLineForOffset(int i) {
        int i2 = 0;
        while (i2 < this.tTZ && i >= ((n) this.tUa.get(i2)).wq) {
            i2++;
        }
        return Math.min(Math.max(0, i2), this.tUa.size() - 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.tUa.iterator();
        int i = 1;
        while (it.hasNext()) {
            n nVar = (n) it.next();
            int i2 = i + 1;
            stringBuilder.append(i).append(": ").append(nVar.Ww).append("-").append(nVar.wq).append(nVar.tVH ? "" : ", ");
            i = i2;
        }
        return stringBuilder.toString();
    }
}

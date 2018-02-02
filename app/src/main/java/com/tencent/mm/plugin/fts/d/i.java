package com.tencent.mm.plugin.fts.d;

import android.view.View;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface i {

    public static class a {
        public int hKY = 0;
        public e mMb = null;
        public int mOR = Integer.MAX_VALUE;
        public boolean mOS = true;
        public int mOT = Integer.MAX_VALUE;
        public boolean mOU = false;
        public List<j> mOV = null;
        public boolean mOW = true;
        public j mOX;
        public int mOY = 0;

        public final String toString() {
            int i = 0;
            String str = "{%d, %b, %d, %b, %d, %d, %d}";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.mOR);
            objArr[1] = Boolean.valueOf(this.mOS);
            objArr[2] = Integer.valueOf(this.mOT);
            objArr[3] = Boolean.valueOf(this.mOU);
            objArr[4] = Integer.valueOf(this.hKY);
            if (this.mOV != null) {
                i = this.mOV.size();
            }
            objArr[5] = Integer.valueOf(i);
            objArr[6] = Integer.valueOf(this.mOY);
            return String.format(str, objArr);
        }
    }

    void a(String str, af afVar, HashSet<String> hashSet);

    boolean a(View view, b bVar, boolean z);

    void aNm();

    LinkedList<Integer> aNn();

    int aNp();

    void aaS();

    int getType();

    int qe(int i);

    b qf(int i);
}

package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean iu = false;
    public long mLk = 0;
    public long mLl = 0;
    public List<a> mLm;
    public Object mLn;
    public int mPriority = Integer.MAX_VALUE;

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((a) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.iu;
    }

    public int getId() {
        return -1;
    }

    public final void Bg(String str) {
        if (this.mLm == null) {
            this.mLm = new ArrayList();
        }
        a aVar = new a(this);
        aVar.mLo = str;
        aVar.timestamp = System.currentTimeMillis();
        this.mLm.add(aVar);
    }

    public String getName() {
        return "";
    }

    public String ado() {
        return "";
    }
}

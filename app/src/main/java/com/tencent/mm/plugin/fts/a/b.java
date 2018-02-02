package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public abstract class b implements j {
    private boolean fic;
    public boolean mJP;

    public abstract boolean AZ();

    public abstract boolean onCreate();

    public b() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[]{getName()});
    }

    public final boolean aMU() {
        return this.fic;
    }

    public final synchronized void create() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.fic)});
        if (!this.fic && onCreate()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.fic = true;
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.mJP), Boolean.valueOf(this.fic)});
        if (!this.mJP && this.fic && AZ()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.mJP = true;
        }
    }

    public void a(String str, j jVar, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public void deleteSOSHistory() {
    }

    public a a(g gVar) {
        return null;
    }
}

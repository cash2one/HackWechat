package com.tencent.mm.plugin.location.model;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class k$a implements a {
    private byte[] data;
    private String mFilePath;
    boolean nRh = true;
    private int nRi;
    private int nRj;
    final /* synthetic */ k nRk;
    String url = "";

    public k$a(k kVar, boolean z, String str, String str2) {
        this.nRk = kVar;
        this.nRh = z;
        this.nRi = kVar.w;
        this.nRj = kVar.h;
        this.url = str;
        while (this.nRi * this.nRj > 270000) {
            this.nRi = (int) (((double) this.nRi) / 1.2d);
            this.nRj = (int) (((double) this.nRj) / 1.2d);
        }
        this.mFilePath = str2;
        x.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[]{str, bh.az(this.mFilePath, "")});
    }

    public final boolean JB() {
        this.data = bh.VM(this.url);
        if (this.data != null) {
            e.b(this.mFilePath, this.data, this.data.length);
        }
        return true;
    }

    public final boolean JC() {
        x.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.nRh);
        if (this.data != null) {
            k.a(this.nRk, true);
        } else if (!this.nRh) {
            k.a(this.nRk, false);
        } else if (this.nRk.nRg == null) {
            k.a(this.nRk, false);
        } else {
            this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.nRi), Integer.valueOf(this.nRj), Float.valueOf(this.nRk.nRg.hxG), Float.valueOf(this.nRk.nRg.hxF), Integer.valueOf(this.nRk.nRg.fzv)});
            this.nRk.hxL.c(new k$a(this.nRk, false, this.url, k.b(this.nRk.nRg)));
        }
        return false;
    }
}

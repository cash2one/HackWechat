package com.tencent.mm.ui.f.a;

import android.os.Bundle;
import com.tencent.mm.ui.f.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

class a$1 implements Runnable {
    final /* synthetic */ String zbI;
    final /* synthetic */ Bundle zbJ;
    final /* synthetic */ String zbK;
    final /* synthetic */ a zbL;
    final /* synthetic */ Object zbM = null;
    final /* synthetic */ a zbN;

    public a$1(a aVar, String str, Bundle bundle, String str2, a aVar2, Object obj) {
        this.zbN = aVar;
        this.zbI = str;
        this.zbJ = bundle;
        this.zbK = str2;
        this.zbL = aVar2;
    }

    public final void run() {
        try {
            this.zbL.Yv(this.zbN.zbH.a(this.zbI, this.zbJ, this.zbK));
        } catch (FileNotFoundException e) {
            this.zbL.a(e);
        } catch (MalformedURLException e2) {
            this.zbL.a(e2);
        } catch (IOException e3) {
            this.zbL.b(e3);
        }
    }
}

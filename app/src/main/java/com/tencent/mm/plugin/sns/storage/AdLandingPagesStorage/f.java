package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mm.k.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private static f roe = new f();
    ConcurrentLinkedQueue<String> rod = new ConcurrentLinkedQueue();

    public static f bxO() {
        return roe;
    }

    private f() {
    }

    private boolean Lh(String str) {
        return this.rod.contains(str);
    }

    private void a(String str, s sVar) {
        if (sVar.rgL == 101) {
            Iterator it = ((n) sVar).rgv.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((m) it.next()).rgv.iterator();
                while (it2.hasNext()) {
                    a(str, (s) it2.next());
                }
            }
        } else if (sVar.rgL == 41) {
            r0 = (p) sVar;
            if (!Lh(r0.rgz)) {
                this.rod.add(r0.rgz);
                d.a(str, r0.rgz, true, sVar.rgL, 0, new 1(this, r0));
            }
        } else if (sVar.rgL == 44) {
            o oVar = (o) sVar;
            if (!Lh(oVar.rgz)) {
                this.rod.add(oVar.rgz);
                d.a(str, oVar.rgz, true, sVar.rgL, 0, new 3(this, oVar));
            }
        } else if (sVar.rgL == 45) {
            r0 = (p) sVar;
            if (!Lh(r0.rgz)) {
                this.rod.add(r0.rgz);
                d.a(str, r0.rgz, true, sVar.rgL, 0, new 4(this, r0));
            }
        } else if (sVar.rgL == 61) {
            q qVar = (q) sVar;
            if (!Lh(qVar.rgB)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.MR();
                if (c.a(pInt, pInt2)) {
                    this.rod.add(qVar.rgB);
                    d.a(str, qVar.rgB, true, 61, new 5(this, qVar));
                }
            }
            if (!Lh(qVar.rgC)) {
                this.rod.add(qVar.rgC);
                d.a(str, qVar.rgC, true, 1000000001, 0, new 6(this, qVar));
            }
        } else if (sVar.rgL == 62) {
            boolean z = g.zY().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            x.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + z);
            w wVar = (w) sVar;
            if (z && !Lh(wVar.rgD)) {
                this.rod.add(wVar.rgD);
                d.a(str, wVar.rgD, true, sVar.rgL, new 7(this, wVar));
            }
            if (!Lh(wVar.rhn)) {
                this.rod.add(wVar.rhn);
                d.a("adId", wVar.rhn, true, sVar.rgL, 0, new 8(this, wVar));
            }
        }
    }

    private void Li(String str) {
        if (!TextUtils.isEmpty(str) && !Lh(str)) {
            this.rod.add(str);
            d.a("adId", str, true, 0, 0, new 9(this, str));
        }
    }

    public final void d(final String str, String str2, String str3, int i) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList m = e.m(str2, str3, "", "");
        int i2;
        int i3;
        Iterator it;
        int i4;
        c cVar;
        Iterator it2;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = g.zY().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = g.zY().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (m.size() > 0) {
                    it = m.iterator();
                    i4 = i2;
                    while (it.hasNext()) {
                        cVar = (c) it.next();
                        Li(cVar.rnN);
                        if (i3 > 0 && i4 > 0) {
                            it2 = cVar.rnP.iterator();
                            while (it2.hasNext()) {
                                final s sVar = (s) it2.next();
                                ag.y(new Runnable(this) {
                                    final /* synthetic */ f rog;

                                    public final void run() {
                                        this.rog.a(str, sVar);
                                    }
                                });
                                i2 = i3 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                i3 = i2;
                            }
                            i2 = i3;
                            i4--;
                            i3 = i2;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = m.iterator();
            while (it3.hasNext()) {
                c cVar2 = (c) it3.next();
                it = cVar2.rnP.iterator();
                while (it.hasNext()) {
                    a(str, (s) it.next());
                }
                Li(cVar2.rnN);
            }
        } else if (i == 1) {
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                Iterator it4 = m.iterator();
                while (it4.hasNext()) {
                    Li(((c) it4.next()).rnN);
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = g.zY().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = g.zY().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (m.size() > 0) {
                it = m.iterator();
                i4 = i2;
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    Li(cVar.rnN);
                    if (i3 > 0 && i4 > 0) {
                        it2 = cVar.rnP.iterator();
                        while (it2.hasNext()) {
                            ag.y(new 2(this, str, (s) it2.next()));
                            i2 = i3 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            i3 = i2;
                        }
                        i2 = i3;
                        i4--;
                        i3 = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            x.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
    }
}

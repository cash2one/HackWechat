package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    ArrayList<a> sYt = new ArrayList();
    private c sYu = new c<ac>(this) {
        final /* synthetic */ a sYx;

        {
            this.sYx = r2;
            this.xen = ac.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            while (this.sYx.sYt != null && this.sYx.sYt.size() > 0) {
                a aVar = (a) this.sYx.sYt.remove(0);
                if (aVar == null) {
                    break;
                }
                Bankcard bankcard = aVar.sAg;
                ImageView imageView = (ImageView) aVar.sYC.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(f.uyA);
                    if (!bh.ov(str) && ((!q.Gf() && str.equals(bankcard.field_bankcardType)) || (q.Gf() && str.equals(bankcard.field_bankName)))) {
                        e h = bankcard.sLn == null ? q.Gf() ? com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankName, false) : com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankcardType, bankcard.bKO()) : bankcard.sLn;
                        a aVar2 = this.sYx;
                        if (h == null || aVar == null || aVar.sYC == null || aVar.sYC.get() == null) {
                            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            x.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + h.oPH);
                            imageView = (ImageView) aVar.sYC.get();
                            if (!bh.ov(h.oPH)) {
                                imageView.post(new AnonymousClass2(aVar2, aVar, imageView, j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(h.oPH))));
                                aVar.sVR = h.oPH;
                                j.a(aVar);
                            } else if (h.sLw > 0) {
                                imageView.post(new AnonymousClass3(aVar2, imageView, h));
                            } else {
                                x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar2 = this.sYx;
                        if (!(h == null || aVar == null || aVar.sYD == null || aVar.sYD.get() == null)) {
                            View view = (View) aVar.sYD.get();
                            view.post(new 4(aVar2, view, h, aVar));
                        }
                        aVar2 = this.sYx;
                        if (!(h == null || aVar == null || aVar.sYD == null || aVar.sYD.get() == null)) {
                            imageView = (ImageView) aVar.sYE.get();
                            if (imageView != null) {
                                imageView.post(new 5(aVar2, h, imageView, aVar));
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    public LinkedList<String> sYv;
    public LinkedList<Bankcard> sYw;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView lOQ;
        final /* synthetic */ a sYx;
        final /* synthetic */ a sYy;
        final /* synthetic */ Bitmap sYz;

        AnonymousClass2(a aVar, a aVar2, ImageView imageView, Bitmap bitmap) {
            this.sYx = aVar;
            this.sYy = aVar2;
            this.lOQ = imageView;
            this.sYz = bitmap;
        }

        public final void run() {
            Bankcard bankcard = this.sYy.sAg;
            String str = (String) this.lOQ.getTag(f.uyA);
            if (bh.ov(str) || ((q.Gf() || !str.equals(bankcard.field_bankcardType)) && !(q.Gf() && str.equals(bankcard.field_bankName)))) {
                x.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", new Object[]{str, bankcard.field_bankcardType, this.lOQ});
                return;
            }
            this.lOQ.setImageBitmap(this.sYz);
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView lOQ;
        final /* synthetic */ e sYA;
        final /* synthetic */ a sYx;

        AnonymousClass3(a aVar, ImageView imageView, e eVar) {
            this.sYx = aVar;
            this.lOQ = imageView;
            this.sYA = eVar;
        }

        public final void run() {
            this.lOQ.setImageResource(this.sYA.sLw);
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.xef.b(this.sYu);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        a(context, bankcard, imageView, null, null);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        com.tencent.mm.platformtools.j.a aVar = new a();
        aVar.sAg = bankcard;
        if (imageView != null) {
            imageView.setTag(f.uyA, bankcard.field_bankcardType);
            aVar.sYC = new WeakReference(imageView);
        }
        e eVar = bankcard.sLn;
        if (eVar == null || aVar.sYC == null || aVar.sYC.get() == null) {
            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            return;
        }
        x.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.oPH);
        ImageView imageView2 = (ImageView) aVar.sYC.get();
        if (!bh.ov(eVar.oPH)) {
            aVar.sVR = eVar.oPH;
            aVar.sYF = true;
            Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.oPH));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            j.a(aVar);
        } else if (eVar.sLw > 0) {
            imageView2.post(new 6(this, imageView2, eVar));
        } else {
            x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2) {
        a aVar = new a();
        aVar.sYF = false;
        aVar.sAg = bankcard;
        if (imageView != null) {
            imageView.setTag(f.uyA, bankcard.field_bankcardType);
            aVar.sYC = new WeakReference(imageView);
        }
        if (view != null) {
            aVar.sYD = new WeakReference(view);
        }
        if (imageView2 != null) {
            aVar.sYE = new WeakReference(imageView2);
        }
        this.sYt.add(aVar);
        String str = q.Gf() ? bankcard.field_bankName : bankcard.field_bankcardType;
        if (this.sYv != null && this.sYv.contains(str)) {
            x.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + str);
        } else if (a(context, bankcard)) {
            com.tencent.mm.sdk.b.a.xef.m(new ac());
        } else {
            if (this.sYw == null) {
                this.sYw = new LinkedList();
            }
            this.sYw.add(bankcard);
            if (this.sYv == null) {
                b(context, this.sYw);
            }
        }
    }

    public final void destory() {
        com.tencent.mm.sdk.b.a.xef.c(this.sYu);
        if (this.sYt != null) {
            this.sYt.clear();
            this.sYt = null;
        }
    }

    private static boolean a(Context context, Bankcard bankcard) {
        e h;
        if (q.Gf()) {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankName, false);
        } else {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankcardType, bankcard.bKO());
        }
        if (h == null || h.sLz) {
            return false;
        }
        return true;
    }

    public final void b(Context context, List<Bankcard> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.sYv = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (bankcard.bKP()) {
                    x.i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!a(context, bankcard)) {
                    x.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.sYv.add(bankcard.field_bankcardType);
                }
            }
            if (this.sYv.size() > 0) {
                x.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                k cVar = new com.tencent.mm.plugin.wallet_core.c.c(this.sYv);
                g.Dk();
                g.Di().gPJ.a(1650, new 7(this, context));
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
                return;
            }
            x.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.b.a.xef.m(new ac());
        }
    }
}

package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bf;
import java.util.List;

public final class d extends c<mh> {
    public d() {
        this.xen = mh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mh mhVar = (mh) bVar;
        switch (mhVar.fEe.opType) {
            case 3:
                boolean a;
                mh.b bVar2 = mhVar.fEf;
                cf cfVar = mhVar.fEe.fEg;
                int i = mhVar.fEe.fEh;
                x.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", new Object[]{Integer.valueOf(i), mhVar.fEe.fEi});
                List a2 = g.bmp().a((long) i, 20);
                if (!a2.isEmpty()) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String az = bh.az(r1, "");
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (az.equals(((bf) a2.get(i2)).HH())) {
                            a = b.a(cfVar, (bf) a2.get(i2), i2);
                            bVar2.fpW = a;
                            break;
                        }
                    }
                }
                cfVar.fqp.fqv = R.l.efh;
                a = false;
                bVar2.fpW = a;
            case 4:
                g.bmp().gW(mhVar.fEe.fEj);
                break;
        }
        return false;
    }
}

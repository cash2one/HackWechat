package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.by.e;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements a {
    private static final UriMatcher maK;
    private static boolean maM = false;
    private static ak maN = new ak(new ak.a() {
        public final boolean uF() {
            ExtControlProviderNearBy.maM = false;
            return false;
        }
    }, false);
    private static final String[] tv = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private boolean bgN;
    private com.tencent.mm.modelgeo.a.a gyF = new 4(this);
    private c hpO;
    private b lak = new 3(this);
    private int maD;
    private List<aoe> maE;
    private e maF;
    private Set<String> maG;
    private CountDownLatch maH;
    private CountDownLatch maI;
    private aoe maJ;
    private boolean maL = false;

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        n.Jz().a((a) extControlProviderNearBy);
        if (extControlProviderNearBy.maF == null) {
            extControlProviderNearBy.maF = new e(tv, (byte) 0);
        }
        for (aoe a : extControlProviderNearBy.maE) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.maI.countDown();
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        x.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (ar.Hj()) {
            b.b(jy.class.getName(), extControlProviderNearBy.lak);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.hpO != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str, str2, objArr);
            if (extControlProviderNearBy.hpO != null) {
                extControlProviderNearBy.hpO.c(extControlProviderNearBy.gyF);
                return;
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        maK = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        maK.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        maK.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    }

    private static void cu(boolean z) {
        if (z) {
            maM = true;
            maN.J(15000, 15000);
            return;
        }
        maN.J(0, 0);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderNearBy", "query() " + uri);
        a(uri, getContext(), 15);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (maM) {
            x.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            pp(5);
            return null;
        } else {
            cu(true);
            if (!aqY()) {
                cu(false);
                pp(1);
                return this.kuZ;
            } else if (cz(getContext())) {
                x.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.maD);
                getType(uri);
                if (this.maD < 0) {
                    x.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    cu(false);
                    pp(3);
                    return null;
                }
                try {
                    this.maE = new ArrayList();
                    this.maF = new e(tv, (byte) 0);
                    this.maH = new CountDownLatch(1);
                    this.maI = null;
                    this.maG = new HashSet();
                    this.maE = new ArrayList();
                    this.bgN = false;
                    x.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (ar.Hj()) {
                        b.a(jy.class.getName(), this.lak);
                        ag.y(new 2(this));
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    x.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.maH.await(15000, TimeUnit.MILLISECONDS)) {
                        x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.maI != null) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.maI.await(15000, TimeUnit.MILLISECONDS)) {
                            x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    pp(4);
                }
                cu(false);
                n.Jz().b(this);
                this.bgN = true;
                aFQ();
                if (this.maF == null || this.maF.getCount() <= 0) {
                    pp(4);
                } else {
                    pp(0);
                }
                x.i("MicroMsg.ExtControlProviderNearBy", "return now");
                return this.maF;
            } else {
                x.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                cu(false);
                pp(2);
                return null;
            }
        }
    }

    private aoe zz(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            return null;
        }
        for (aoe com_tencent_mm_protocal_c_aoe : this.maE) {
            if (com_tencent_mm_protocal_c_aoe.ksU.equals(str)) {
                return com_tencent_mm_protocal_c_aoe;
            }
        }
        return null;
    }

    private void a(aoe com_tencent_mm_protocal_c_aoe) {
        if (com_tencent_mm_protocal_c_aoe == null || com_tencent_mm_protocal_c_aoe.ksU == null) {
            x.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            return;
        }
        this.maG.add(com_tencent_mm_protocal_c_aoe.ksU);
        Bitmap a = com.tencent.mm.ad.b.a(com_tencent_mm_protocal_c_aoe.ksU, false, -1);
        x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.maI.getCount());
        if (a != null) {
            x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.maG.remove(com_tencent_mm_protocal_c_aoe.ksU);
            this.maF.addRow(new Object[]{com_tencent_mm_protocal_c_aoe.kub, bArr, com_tencent_mm_protocal_c_aoe.wve, com_tencent_mm_protocal_c_aoe.hvw, Integer.valueOf(com_tencent_mm_protocal_c_aoe.hvt)});
            x.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
    }

    public final void jh(String str) {
        x.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + str);
        if (this.bgN) {
            x.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            return;
        }
        a(zz(str));
        this.maI.countDown();
    }

    private void aFQ() {
        if (this.maG.size() > 0) {
            for (String str : this.maG) {
                x.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
                this.maJ = zz(str);
                if (!(this.maJ == null || this.maJ.ksU == null)) {
                    this.maF.addRow(new Object[]{this.maJ.kub, null, this.maJ.wve, this.maJ.hvw, Integer.valueOf(this.maJ.hvt)});
                }
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    }

    public final String getType(Uri uri) {
        this.maD = -1;
        switch (maK.match(uri)) {
            case 0:
                this.maD = 1;
                break;
            case 1:
                this.maD = 3;
                break;
            case 2:
                this.maD = 4;
                break;
            default:
                this.maD = -1;
                break;
        }
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

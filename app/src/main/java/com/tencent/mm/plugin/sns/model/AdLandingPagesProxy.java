package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdLandingPagesProxy extends a {
    private static AdLandingPagesProxy qSk;
    private e hnN = new 1(this);
    private Map<Long, a> qSl = new HashMap();
    private Map<k, Long> qSm = new HashMap();
    private d qSn;
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> qSo = new HashMap();
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> qSp = new HashMap();

    static /* synthetic */ void a(AdLandingPagesProxy adLandingPagesProxy, String str) {
        long VI;
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                VI = (long) bh.VI(str.substring(indexOf + 10, indexOf2));
                if (VI > 0) {
                    x.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(VI)});
                    i.bxQ().o(VI, str);
                }
            }
        }
        VI = 0;
        if (VI > 0) {
            x.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(VI)});
            i.bxQ().o(VI, str);
        }
    }

    public static void create(d dVar) {
        qSk = new AdLandingPagesProxy(dVar);
    }

    public AdLandingPagesProxy(d dVar) {
        super(dVar);
        if (dVar == null) {
            g.Dk();
            g.Di().gPJ.a(1337, this.hnN);
            g.Dk();
            g.Di().gPJ.a(1210, this.hnN);
            g.Dk();
            g.Di().gPJ.a(2874, this.hnN);
            g.Dk();
            g.Di().gPJ.a(2721, this.hnN);
            g.Dk();
            g.Di().gPJ.a(1802, this.hnN);
        }
        this.qSn = dVar;
    }

    public static AdLandingPagesProxy getInstance() {
        if (qSk != null) {
            return qSk;
        }
        throw new IllegalStateException("init first");
    }

    public boolean isConnected() {
        return this.qSn == null ? false : this.qSn.isConnected();
    }

    public void onRelease() {
        g.Dk();
        g.Di().gPJ.b(1337, this.hnN);
        g.Dk();
        g.Di().gPJ.b(1210, this.hnN);
        g.Dk();
        g.Di().gPJ.b(2874, this.hnN);
        g.Dk();
        g.Di().gPJ.b(2721, this.hnN);
        g.Dk();
        g.Di().gPJ.b(1802, this.hnN);
    }

    public Object getCfg(int i, Object obj) {
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", new Object[]{Integer.valueOf(i), obj});
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    @f
    public Object getCfgMM(int i, Object obj) {
        g.Dk();
        return g.Dj().CU().get(i, obj);
    }

    public int contactGetTypeTextFromUserName(String str) {
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", new Object[]{str});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int contactGetTypeTextFromUserNameMM(String str) {
        return s.hp(str);
    }

    public String getSnsStatExtBySnsId(long j) {
        return (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", new Object[]{Long.valueOf(j)});
    }

    @f
    public String getSnsStatExtBySnsIdMM(long j) {
        com.tencent.mm.plugin.sns.storage.e eK = ae.bvy().eK(j);
        if (eK != null) {
            return com.tencent.mm.plugin.sns.a.b.f.a(eK.bxV());
        }
        x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{Long.valueOf(j)});
        return "";
    }

    public String getAccSnsPath() {
        return (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    }

    @f
    public String getAccSnsPathMM() {
        return ae.getAccSnsPath();
    }

    public String getSnsAid(String str) {
        return (String) REMOTE_CALL("getSnsAidMM", new Object[]{str});
    }

    @f
    public String getSnsAidMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            return Ll.byv();
        }
        return "";
    }

    public int getSnsAdType(String str) {
        return ((Integer) REMOTE_CALL("getSnsAdTypeMM", new Object[]{str})).intValue();
    }

    @f
    public int getSnsAdTypeMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            return Ll.byD();
        }
        return 0;
    }

    public void doOpenAppBrand(String str, String str2, String str3) {
        REMOTE_CALL("doOpenAppBrandMM", new Object[]{str, str2, str3});
    }

    @f
    public void doOpenAppBrandMM(String str, String str2, String str3) {
        b qpVar = new qp();
        qpVar.fIi.userName = str;
        qpVar.fIi.fIk = str2;
        qpVar.fIi.scene = 1084;
        qpVar.fIi.fnp = str3;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(ac.getContext(), SnsTransparentUI.class);
            intent.putExtra("phoneNum", str);
            intent.putExtra("op", 4);
            activity.startActivity(intent);
        }
    }

    public String getSnsTraceid(String str) {
        return (String) REMOTE_CALL("getSnsTraceidMM", new Object[]{str});
    }

    @f
    public String getSnsTraceidMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            return Ll.byw();
        }
        return "";
    }

    public boolean isRecExpAd(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isRecExpAdMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll == null) {
            return false;
        }
        return Ll.bwE();
    }

    public m getSnsInfo(String str) {
        Bundle bundle = (Bundle) REMOTE_CALL("getSnsInfoMM", new Object[]{str});
        if (bundle == null) {
            return null;
        }
        m mVar = new m();
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            mVar.field_snsId = contentValues.getAsLong("snsId").longValue();
            mVar.field_userName = contentValues.getAsString("userName");
            mVar.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            mVar.field_createTime = contentValues.getAsInteger("createTime").intValue();
            mVar.field_head = contentValues.getAsInteger("head").intValue();
            mVar.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            mVar.field_type = contentValues.getAsInteger(DownloadSettingTable$Columns.TYPE).intValue();
            mVar.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            mVar.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            mVar.field_pravited = contentValues.getAsInteger("pravited").intValue();
            mVar.field_stringSeq = contentValues.getAsString("stringSeq");
            mVar.field_content = contentValues.getAsByteArray("content");
            mVar.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            mVar.field_postBuf = contentValues.getAsByteArray("postBuf");
            mVar.field_subType = contentValues.getAsInteger("subType").intValue();
            if (contentValues.containsKey("rowid")) {
                mVar.xjy = contentValues.getAsLong("rowid").longValue();
            }
            mVar.roJ = bundle.getInt("localid");
            bundle = bundle.getBundle("adValues");
            if (bundle != null) {
                com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                eVar.E(bundle);
                mVar.roT = eVar;
            }
        }
        return mVar;
    }

    @f
    public Bundle getSnsInfoMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll == null) {
            return null;
        }
        return Ll.bxY();
    }

    public String getUin() {
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        return REMOTE_CALL == null ? "" : (String) REMOTE_CALL;
    }

    @f
    public String getUinMM() {
        g.Dh();
        return com.tencent.mm.kernel.a.Ch();
    }

    public boolean useOnlineStreamPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean useOnlineStreamPlayerMM() {
        c fn = com.tencent.mm.z.c.c.IF().fn("100208");
        if (!fn.isValid()) {
            return false;
        }
        int i = bh.getInt((String) fn.chI().get("useOnlineVideoPlayer"), 0);
        x.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @f
    public int getExpValueByKeyMM(String str, int i) {
        return com.tencent.mm.z.c.c.IG().da(str, i);
    }

    public int getExpValueByKey(String str, int i) {
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", new Object[]{str, Integer.valueOf(i)});
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public String getExpIdByKeyMM(String str) {
        return com.tencent.mm.z.c.c.IG().getExpIdByKey(str);
    }

    public String getExpIdByKey(String str) {
        return (String) REMOTE_CALL("getExpIdByKeyMM", new Object[]{str});
    }

    public int isAutoAdDownload() {
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    public void favEditTag() {
        REMOTE_CALL("favEditTagMM", new Object[0]);
    }

    @f
    public void favEditTagMM() {
        b fvVar = new fv();
        fvVar.fvq.type = 35;
        com.tencent.mm.sdk.b.a.xef.m(fvVar);
    }

    @f
    public int isAutoAdDownloadMM() {
        return ae.bvs().b(null, null);
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", new Object[]{Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7, str8});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        boolean z = false;
        b cfVar = new cf();
        if ((i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) && !bh.ov(str)) {
            b qnVar = new qn();
            qnVar.fIc.fIf = str;
            qnVar.fIc.fIg = cfVar;
            qnVar.fIc.url = str2;
            com.tencent.mm.sdk.b.a.xef.m(qnVar);
            z = qnVar.fId.fpW;
        } else if ((i == 5 || i == 6) && j != -2147483648L) {
            z = ((q) g.h(q.class)).a(cfVar, j);
        } else if (i == 13 || i == 14 || i == 15) {
            z = ((q) g.h(q.class)).a(cfVar, str4.hashCode(), com.tencent.mm.z.q.FS(), str4, str5, str6, str7);
        }
        if (z) {
            cfVar.fqp.fqu = u.hz(str3);
            cfVar.fqp.title = str4;
            cfVar.fqp.desc = str5;
            ve veVar = cfVar.fqp.fqr;
            if (!(veVar == null || veVar.weU == null || veVar.weU.size() <= 0 || veVar.weU.get(0) == null)) {
                ((uq) veVar.weU.get(0)).TP(str6);
                ((uq) veVar.weU.get(0)).Tq(str4);
                ((uq) veVar.weU.get(0)).Tr(str5);
                ((uq) veVar.weU.get(0)).TO(str8);
            }
            if (veVar != null) {
                veVar.Ug(str4);
                veVar.Uh(str5);
            }
            cfVar.fqp.fqw = i2;
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
            return cfVar.fqp.fqv;
        }
        if (cfVar.fqp.fqv == 0) {
            cfVar.fqp.fqv = j.efp;
        }
        return cfVar.fqp.fqv;
    }

    public int doFav(Intent intent, int i) {
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", new Object[]{intent, Integer.valueOf(i)});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavMM(Intent intent, int i) {
        b cfVar = new cf();
        ((q) g.h(q.class)).a(cfVar, intent);
        cfVar.fqp.fqw = i;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        return cfVar.fqp.fqv;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(ac.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
    }

    @f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, a aVar) {
        this.qSl.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", new Object[]{Long.valueOf(r0), str, str2, str3});
    }

    @f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        k cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str, str2, str3);
        this.qSm.put(cVar, Long.valueOf(j));
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j, String str) {
        a aVar = (a) this.qSl.remove(Long.valueOf(j));
        if (aVar != null && !bh.ov(str)) {
            aVar.as(str);
        }
    }

    public void doSearchDynamicUpdateScene(String str, a aVar) {
        this.qSl.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[]{Long.valueOf(r0), str});
    }

    @f
    public void doSearchDynamicUpdateSceneMM(long j, String str) {
        k cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str);
        this.qSm.put(cVar, Long.valueOf(j));
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        a aVar = (a) this.qSl.remove(Long.valueOf(j));
        if (aVar != null) {
            aVar.e(i, i2, obj);
        }
    }

    public void doAdChannelScene(String str, String str2, a aVar) {
        this.qSl.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doAdChannelSceneMM", new Object[]{Long.valueOf(r0), str, str2});
    }

    @f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        k aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2);
        this.qSm.put(aVar, Long.valueOf(j));
        g.Dk();
        g.Di().gPJ.a(aVar, 0);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            x.e("AdLandingPagesProxy", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isApkExistMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        return (xI == null || TextUtils.isEmpty(xI.path) || !new File(xI.path).exists()) ? false : true;
    }

    @f
    public boolean isDownloadingMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        return xI != null && xI.status == 1;
    }

    public boolean isDownloading(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPkgInstalledMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        Context context = ac.getContext();
        return (context == null || TextUtils.isEmpty(str)) ? false : p.m(context, str);
    }

    public boolean isPkgInstalled(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPausedMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        return xI != null && xI.status == 2;
    }

    public boolean isPaused(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.start();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j, int i) {
        x.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.wy(i);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bus();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.but();
            this.qSp.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.buu();
            this.qSp.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.buv();
            this.qSp.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qSp.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.buw();
        }
    }

    @f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        b bVar = new b(this, (byte) 0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        com.tencent.mm.plugin.downloader.model.g.a aVar2 = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar2.setAppId(str);
        aVar2.cu(str2);
        aVar2.xO(str3);
        aVar2.xL(str4);
        aVar2.xN(str5);
        aVar2.ep(z);
        long a = com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar2.lsE);
        aVar.rfy.put(Long.valueOf(a), new WeakReference(bVar));
        aVar.rfz.put(str, new a$b(str6, str7));
        this.qSo.put(Long.valueOf(a), bVar);
        x.v("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[]{Long.valueOf(a)});
        bVar.id = a;
        return a;
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str6, String str7) {
        x.v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7});
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.qSp.put(Long.valueOf(longValue), aVar);
        return longValue;
    }

    @f
    public void stopTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        if (xI != null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(xI.id);
        }
    }

    public void stopTask(String str) {
        REMOTE_CALL("stopTaskMM", new Object[]{str});
    }

    public void stopTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(j);
    }

    public void stopTask(long j) {
        REMOTE_CALL("stopTaskMM", new Object[]{Long.valueOf(j)});
    }

    @f
    public long queryIdByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        return com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
    }

    public long queryIdByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", new Object[]{str});
        return REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
    }

    @f
    public boolean pauseTaskByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        return com.tencent.mm.plugin.downloader.model.f.aAd().bZ(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTaskByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskByAppidMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        return com.tencent.mm.plugin.downloader.model.f.aAd().bZ(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTask(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        return com.tencent.mm.plugin.downloader.model.f.aAd().bZ(j);
    }

    public boolean pauseTask(long j) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", new Object[]{Long.valueOf(j)});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public int getTaskProgressMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        return xI.fwg != 0 ? (int) ((xI.fwf * 100) / xI.fwg) : 0;
    }

    public int getTaskProgress(String str) {
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", new Object[]{str});
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        b bVar = new b(this, (byte) 0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        this.qSo.put(Long.valueOf(queryIdByAppid), bVar);
        bVar.id = queryIdByAppid;
        aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        if (xI == null) {
            return false;
        }
        aVar.rfy.put(Long.valueOf(xI.id), new WeakReference(bVar));
        aVar.rfz.put(str, new a$b(str2, str3));
        return com.tencent.mm.plugin.downloader.model.f.aAd().ca(xI.id);
    }

    public boolean resumeTask(String str, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str2, String str3) {
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", new Object[]{str, str2, str3});
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.qSp.put(Long.valueOf(queryIdByAppid(str)), aVar);
        }
        return booleanValue;
    }

    @f
    public boolean installAppMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        Context context = ac.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        if (xI == null || xI.status != 3 || TextUtils.isEmpty(xI.path)) {
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(xI.path));
        aVar.H(4, xI.id);
        return com.tencent.mm.pluginsdk.model.app.q.e(context, fromFile);
    }

    public boolean installApp(Context context, String str) {
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public void reportDownloadInfoMM(int i, String str, String str2, String str3, String str4) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB.d(i, str, str2, str4);
    }

    public void reportDownloadInfo(int i, String str, String str2, String str3, String str4) {
        REMOTE_CALL("reportDownloadInfoMM", new Object[]{Integer.valueOf(i), str, str2, str3, str4});
    }

    @f
    public void addReportInfoMM(String str, String str2, String str3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.rfB;
        if (str != null && str.length() != 0) {
            aVar.rfz.put(str, new a$b(str2, str3));
        }
    }

    public void addReportInfo(String str, String str2, String str3) {
        REMOTE_CALL("addReportInfoMM", new Object[]{str, str2, str3});
    }

    public void writeDeferredDeepLink(String str, String str2) {
        REMOTE_CALL("writeDeferredDeepLinkMM", new Object[]{str, str2});
    }

    @f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        bur().edit().putString(str, str2).commit();
    }

    public void deleteDeferredDeepLink(String str) {
        REMOTE_CALL("deleteDeferredDeepLinkMM", new Object[]{str});
    }

    @f
    public void deleteDeferredDeepLinkMM(String str) {
        bur().edit().remove(str).commit();
    }

    private static SharedPreferences bur() {
        return ac.getContext().getSharedPreferences(ac.getPackageName() + "_comm_preferences", 0);
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j, String str) {
        REMOTE_CALL("addCanvasCacheMM", new Object[]{Long.valueOf(j), str});
    }

    @f
    public void addCanvasCacheMM(long j, String str) {
        i.bxQ().o(j, str);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        REMOTE_CALL("asyncCacheXmlMM", new Object[]{str});
    }

    @f
    public void asyncCacheXmlMM(String str) {
        g.Dk();
        g.Dm().g(new 2(this, str), 5000);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        return ((Integer) REMOTE_CALL("getAdVoteIndexMM", new Object[]{str, str2, str3})).intValue();
    }

    @f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        return com.tencent.mm.plugin.sns.storage.u.Y(str, str2, str3);
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        return (String) REMOTE_CALL("getAdVoteInfoMM", new Object[]{str, str2, str3});
    }

    @f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        return com.tencent.mm.plugin.sns.storage.u.Z(str, str2, str3);
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i, int i2) {
        REMOTE_CALL("saveAdVoteInfoMM", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i, int i2) {
        com.tencent.mm.plugin.sns.storage.u.f(str, str2, str3, i, i2);
    }

    public void doFavOfficialItemScene(String str, a aVar) {
        if (bh.ov(str)) {
            x.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            return;
        }
        this.qSl.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doFavOfficialItemSceneMM", new Object[]{Long.valueOf(r0), str});
    }

    @f
    public void doFavOfficialItemSceneMM(long j, String str) {
        k bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str);
        this.qSm.put(bVar, Long.valueOf(j));
        g.Dk();
        g.Di().gPJ.a(bVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onFavOfficialItemEnd(long j, String str, int i, int i2) {
        a aVar = (a) this.qSl.remove(Long.valueOf(j));
        if (i == 0 && i2 == 0) {
            x.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[]{str});
        } else {
            x.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        if (aVar != null) {
            aVar.e(i, i2, null);
        }
    }

    public String getSnsAdCanvasExtXml(String str) {
        return (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", new Object[]{str});
    }

    @f
    public String getSnsAdCanvasExtXmlMM(String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            return Ll.bxT().rec;
        }
        return "";
    }

    public void doCgiReportCanvasBrowseInfo(int i, String str) {
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", new Object[]{Integer.valueOf(i), str});
    }

    @f
    public void doCgiReportCanvasBrowseInfoMM(int i, String str) {
        ano com_tencent_mm_protocal_c_ano = new ano();
        com_tencent_mm_protocal_c_ano.wuu = i;
        com_tencent_mm_protocal_c_ano.wuC = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_ano.ksO = 1;
        com_tencent_mm_protocal_c_ano.wuv = new com.tencent.mm.bq.b(str.getBytes());
        List arrayList = new ArrayList();
        arrayList.add(com_tencent_mm_protocal_c_ano);
        k eVar = new com.tencent.mm.plugin.sns.a.b.e(arrayList);
        g.Dk();
        g.Di().gPJ.a(eVar, 0);
    }
}

package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class d implements b {
    private static d fgZ = null;
    URISpanHandlerSet fha;
    ArrayList<BaseUriSpanHandler> fhb = new ArrayList();
    ArrayList<BaseUriSpanHandler> fhc = new ArrayList();
    ArrayList<BaseUriSpanHandler> fhd = new ArrayList();
    Context mContext = null;

    public static d uB() {
        if (fgZ == null) {
            fgZ = new d();
        }
        return fgZ;
    }

    private d() {
        long Wp = bh.Wp();
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = ac.getContext();
        this.fha = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(URISpanHandlerSet$a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    URISpanHandlerSet$a uRISpanHandlerSet$a = (URISpanHandlerSet$a) cls.getAnnotation(URISpanHandlerSet$a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.fha}));
                        URISpanHandlerSet$PRIORITY uD = uRISpanHandlerSet$a.uD();
                        if (uD == URISpanHandlerSet$PRIORITY.LOW) {
                            this.fhd.add(baseUriSpanHandler);
                        } else if (uD == URISpanHandlerSet$PRIORITY.NORMAL) {
                            this.fhc.add(baseUriSpanHandler);
                        } else if (uD == URISpanHandlerSet$PRIORITY.HIGH) {
                            this.fhb.add(baseUriSpanHandler);
                        }
                        x.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        x.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    x.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(bh.Wp() - Wp));
    }

    public final k p(Context context, String str) {
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.fhb.size()), Integer.valueOf(this.fhc.size()), Integer.valueOf(this.fhd.size()));
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.fha.mContext = null;
            return null;
        }
        this.mContext = context;
        this.fha.mContext = this.mContext;
        if (bh.ov(str)) {
            x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.fha.mContext = null;
            return null;
        }
        Iterator it = this.fhb.iterator();
        while (it.hasNext()) {
            k cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fha.mContext = null;
                return cH;
            }
        }
        it = this.fhc.iterator();
        while (it.hasNext()) {
            cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fha.mContext = null;
                return cH;
            }
        }
        it = this.fhd.iterator();
        while (it.hasNext()) {
            cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fha.mContext = null;
                return cH;
            }
        }
        this.mContext = null;
        this.fha.mContext = null;
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        return null;
    }

    public final boolean a(Context context, k kVar, f fVar) {
        if (kVar == null) {
            x.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            return false;
        }
        boolean z;
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(kVar.type);
        if (fVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.fhb.size());
        objArr[3] = Integer.valueOf(this.fhc.size());
        objArr[4] = Integer.valueOf(this.fhd.size());
        x.d(str, str2, objArr);
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.fha.mContext = null;
            return false;
        }
        this.mContext = context;
        this.fha.mContext = this.mContext;
        Iterator it = this.fhb.iterator();
        while (it.hasNext()) {
            BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uC(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fha.mContext = null;
                return true;
            }
        }
        it = this.fhc.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uC(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fha.mContext = null;
                return true;
            }
        }
        it = this.fhd.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uC(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fha.mContext = null;
                return true;
            }
        }
        this.mContext = null;
        this.fha.mContext = null;
        x.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        return false;
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}

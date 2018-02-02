package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.d.a.4;
import com.tencent.mm.z.d.b;
import com.tencent.mm.z.d.b.1;
import com.tencent.mm.z.d.c;
import com.tencent.mm.z.d.c.a;
import java.lang.reflect.Field;

class k$1 extends af {
    final /* synthetic */ k ffE;

    k$1(k kVar, Looper looper) {
        this.ffE = kVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == -1999) {
            if (!this.ffE.ffC) {
                LauncherUI cmG = LauncherUI.cmG();
                if (cmG != null && cmG.xGV) {
                    Resources resources;
                    Field declaredField;
                    cmG.xGS.xGh.Yp("tab_main");
                    HomeUI homeUI = cmG.xGS;
                    if (homeUI.xFW) {
                        homeUI.xFY = true;
                        homeUI.xGp.setBackgroundDrawable(null);
                        VoiceSearchLayout voiceSearchLayout = homeUI.xGp;
                        voiceSearchLayout.vmy.setBackgroundDrawable(null);
                        voiceSearchLayout.vmC.setBackgroundDrawable(null);
                        voiceSearchLayout.vmD = null;
                    }
                    try {
                        resources = ac.getContext().getResources();
                        if (resources != null) {
                            declaredField = resources.getClass().getDeclaredField("mDrawableCache");
                            declaredField.setAccessible(true);
                            ((LongSparseArray) declaredField.get(resources)).clear();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e, "", new Object[0]);
                    }
                    try {
                        resources = ac.getContext().getResources();
                        if (resources != null) {
                            declaredField = resources.getClass().getDeclaredField("mColorStateListCache");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(resources);
                            if (obj instanceof SparseArray) {
                                ((SparseArray) obj).clear();
                            } else {
                                ((LongSparseArray) obj).clear();
                            }
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e2, "", new Object[0]);
                    }
                    try {
                        if (VERSION.SDK_INT >= 16) {
                            Resources resources2 = ac.getContext().getResources();
                            if (resources2 != null) {
                                Field declaredField2 = resources2.getClass().getDeclaredField("mColorDrawableCache");
                                declaredField2.setAccessible(true);
                                ((LongSparseArray) declaredField2.get(resources2)).clear();
                                declaredField2 = resources2.getClass().getDeclaredField("sPreloadedColorDrawables");
                                declaredField2.setAccessible(true);
                                ((LongSparseArray) declaredField2.get(resources2)).clear();
                            }
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e22, "", new Object[0]);
                    }
                    f fVar = n.qQy;
                    if (fVar != null) {
                        fVar.bug();
                    }
                    for (Fragment fragment : cmG.xGS.xGh.xKH.values()) {
                        if (!(fragment instanceof j)) {
                            ((l) fragment).clC();
                        }
                    }
                }
                System.gc();
            }
        } else if (message.what == -2999 && !this.ffE.ffC) {
            LauncherUI cmG2 = LauncherUI.cmG();
            if (cmG2 != null) {
                w wVar = cmG2.xGS.xGh;
                if (wVar.xKH.containsKey(Integer.valueOf(0))) {
                    ((l) wVar.xKH.get(Integer.valueOf(0))).clC();
                }
            }
            if (g.Dh().Cy()) {
                ar.Ha();
                ap hY = bp.hY("plugin.emoji");
                if (hY != null) {
                    hY.gd(0);
                }
                ar.Ha();
                if (((o) bp.hY(o.class.getName())) != null) {
                    o.PC();
                }
                a IP = b.IP();
                a II = com.tencent.mm.z.d.a.II();
                c IR = c.IR();
                ar.Dm().F(new 1(IP));
                ar.Dm().F(new 4(II));
                IR.a(IP);
                IR.a(II);
                ar.Dm().F(new c$1(IR));
            }
            System.gc();
        }
    }
}

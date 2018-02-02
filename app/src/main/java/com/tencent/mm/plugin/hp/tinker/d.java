package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.c.f;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a;
import com.tinkerboots.sdk.a$a;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class d {
    private static boolean nBi = false;

    public static void a(ApplicationLike applicationLike) {
        long CA;
        long j;
        Throwable e;
        a$a com_tinkerboots_sdk_a_a;
        com.tencent.tinker.lib.d.d eVar;
        b bVar;
        Class cls;
        a aVar;
        x.i("Tinker.TinkerPatchManager", "try installing tinker");
        if (nBi) {
            x.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            return;
        }
        c cVar;
        boolean ceK;
        com.tinkerboots.sdk.a.a.b fVar;
        try {
            CA = ((long) com.tencent.mm.kernel.a.CA()) & 4294967295L;
            try {
                x.i("Tinker.TinkerPatchManager", "uin is %s", new Object[]{bh.VT(String.valueOf(CA))});
                j = CA;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
                j = CA;
                com_tinkerboots_sdk_a_a = new a$a(applicationLike);
                cVar = new c(applicationLike.getApplication());
                if (com_tinkerboots_sdk_a_a.AiB != null) {
                    throw new TinkerRuntimeException("loadReporter is already set.");
                }
                com_tinkerboots_sdk_a_a.AiB = cVar;
                eVar = new e(applicationLike.getApplication());
                if (com_tinkerboots_sdk_a_a.AiC != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                }
                com_tinkerboots_sdk_a_a.AiC = eVar;
                bVar = new b(applicationLike.getApplication());
                if (com_tinkerboots_sdk_a_a.AiA != null) {
                    throw new TinkerRuntimeException("listener is already set.");
                }
                com_tinkerboots_sdk_a_a.AiA = bVar;
                cls = TinkerPatchResultService.class;
                if (com_tinkerboots_sdk_a_a.Aui != null) {
                    throw new TinkerRuntimeException("resultServiceClass is already set.");
                }
                com_tinkerboots_sdk_a_a.Aui = cls;
                if (com_tinkerboots_sdk_a_a.AiB == null) {
                    com_tinkerboots_sdk_a_a.AiB = new com.tinkerboots.sdk.tinker.b.a(com_tinkerboots_sdk_a_a.context);
                }
                if (com_tinkerboots_sdk_a_a.AiC == null) {
                    com_tinkerboots_sdk_a_a.AiC = new com.tinkerboots.sdk.tinker.b.c(com_tinkerboots_sdk_a_a.context);
                }
                if (com_tinkerboots_sdk_a_a.AiA == null) {
                    com_tinkerboots_sdk_a_a.AiA = new com.tinkerboots.sdk.tinker.b.b(com_tinkerboots_sdk_a_a.context);
                }
                if (com_tinkerboots_sdk_a_a.Auh == null) {
                    com_tinkerboots_sdk_a_a.Auh = new f();
                }
                if (com_tinkerboots_sdk_a_a.Aui == null) {
                    com_tinkerboots_sdk_a_a.Aui = TinkerServerResultService.class;
                }
                if (com_tinkerboots_sdk_a_a.Auj == null) {
                    com_tinkerboots_sdk_a_a.Auj = new com.tinkerboots.sdk.a.a.a();
                }
                aVar = new a(com_tinkerboots_sdk_a_a.context, com_tinkerboots_sdk_a_a.applicationLike, com_tinkerboots_sdk_a_a.AiB, com_tinkerboots_sdk_a_a.AiC, com_tinkerboots_sdk_a_a.AiA, com_tinkerboots_sdk_a_a.Auh, com_tinkerboots_sdk_a_a.Aui, com_tinkerboots_sdk_a_a.Auj);
                if (a.Auc != null) {
                    throw new TinkerRuntimeException("TinkerClient instance is already set.");
                }
                a.Auc = aVar;
                aVar = a.cJn().Jj(g.cW(ac.getContext()));
                ceK = com.tencent.mm.sdk.a.b.ceK();
                if (aVar.Aue != null) {
                }
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                aVar = a.Auc;
                aVar = aVar.gi(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).gi("code-version", e.CLIENT_VERSION).gi("code-reversion", e.REV).gi(TencentLocation.NETWORK_PROVIDER, String.valueOf(an.isWifi(ac.getContext()) ? 3 : 2)).gi("sdk", String.valueOf(VERSION.SDK_INT)).gi("os-name", com.tencent.mm.protocal.d.vAv).gi("device-brand", com.tencent.mm.protocal.d.vAs).gi("device-name", com.tencent.mm.protocal.d.vAx);
                fVar = new f();
                if (aVar.Aue != null) {
                }
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                x.i("Tinker.TinkerPatchManager", "try installing end");
                nBi = true;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            CA = 0;
            e = th;
            x.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
            j = CA;
            com_tinkerboots_sdk_a_a = new a$a(applicationLike);
            cVar = new c(applicationLike.getApplication());
            if (com_tinkerboots_sdk_a_a.AiB != null) {
                com_tinkerboots_sdk_a_a.AiB = cVar;
                eVar = new e(applicationLike.getApplication());
                if (com_tinkerboots_sdk_a_a.AiC != null) {
                    com_tinkerboots_sdk_a_a.AiC = eVar;
                    bVar = new b(applicationLike.getApplication());
                    if (com_tinkerboots_sdk_a_a.AiA != null) {
                        com_tinkerboots_sdk_a_a.AiA = bVar;
                        cls = TinkerPatchResultService.class;
                        if (com_tinkerboots_sdk_a_a.Aui != null) {
                            com_tinkerboots_sdk_a_a.Aui = cls;
                            if (com_tinkerboots_sdk_a_a.AiB == null) {
                                com_tinkerboots_sdk_a_a.AiB = new com.tinkerboots.sdk.tinker.b.a(com_tinkerboots_sdk_a_a.context);
                            }
                            if (com_tinkerboots_sdk_a_a.AiC == null) {
                                com_tinkerboots_sdk_a_a.AiC = new com.tinkerboots.sdk.tinker.b.c(com_tinkerboots_sdk_a_a.context);
                            }
                            if (com_tinkerboots_sdk_a_a.AiA == null) {
                                com_tinkerboots_sdk_a_a.AiA = new com.tinkerboots.sdk.tinker.b.b(com_tinkerboots_sdk_a_a.context);
                            }
                            if (com_tinkerboots_sdk_a_a.Auh == null) {
                                com_tinkerboots_sdk_a_a.Auh = new f();
                            }
                            if (com_tinkerboots_sdk_a_a.Aui == null) {
                                com_tinkerboots_sdk_a_a.Aui = TinkerServerResultService.class;
                            }
                            if (com_tinkerboots_sdk_a_a.Auj == null) {
                                com_tinkerboots_sdk_a_a.Auj = new com.tinkerboots.sdk.a.a.a();
                            }
                            aVar = new a(com_tinkerboots_sdk_a_a.context, com_tinkerboots_sdk_a_a.applicationLike, com_tinkerboots_sdk_a_a.AiB, com_tinkerboots_sdk_a_a.AiC, com_tinkerboots_sdk_a_a.AiA, com_tinkerboots_sdk_a_a.Auh, com_tinkerboots_sdk_a_a.Aui, com_tinkerboots_sdk_a_a.Auj);
                            if (a.Auc != null) {
                                a.Auc = aVar;
                                aVar = a.cJn().Jj(g.cW(ac.getContext()));
                                ceK = com.tencent.mm.sdk.a.b.ceK();
                                if (aVar.Aue != null) {
                                }
                                com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                                aVar = a.Auc;
                                if (an.isWifi(ac.getContext())) {
                                }
                                aVar = aVar.gi(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).gi("code-version", e.CLIENT_VERSION).gi("code-reversion", e.REV).gi(TencentLocation.NETWORK_PROVIDER, String.valueOf(an.isWifi(ac.getContext()) ? 3 : 2)).gi("sdk", String.valueOf(VERSION.SDK_INT)).gi("os-name", com.tencent.mm.protocal.d.vAv).gi("device-brand", com.tencent.mm.protocal.d.vAs).gi("device-name", com.tencent.mm.protocal.d.vAx);
                                fVar = new f();
                                if (aVar.Aue != null) {
                                }
                                com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                                x.i("Tinker.TinkerPatchManager", "try installing end");
                                nBi = true;
                            }
                            throw new TinkerRuntimeException("TinkerClient instance is already set.");
                        }
                        throw new TinkerRuntimeException("resultServiceClass is already set.");
                    }
                    throw new TinkerRuntimeException("listener is already set.");
                }
                throw new TinkerRuntimeException("patchReporter is already set.");
            }
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        com_tinkerboots_sdk_a_a = new a$a(applicationLike);
        cVar = new c(applicationLike.getApplication());
        if (com_tinkerboots_sdk_a_a.AiB != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        com_tinkerboots_sdk_a_a.AiB = cVar;
        eVar = new e(applicationLike.getApplication());
        if (com_tinkerboots_sdk_a_a.AiC != null) {
            throw new TinkerRuntimeException("patchReporter is already set.");
        }
        com_tinkerboots_sdk_a_a.AiC = eVar;
        bVar = new b(applicationLike.getApplication());
        if (com_tinkerboots_sdk_a_a.AiA != null) {
            throw new TinkerRuntimeException("listener is already set.");
        }
        com_tinkerboots_sdk_a_a.AiA = bVar;
        cls = TinkerPatchResultService.class;
        if (com_tinkerboots_sdk_a_a.Aui != null) {
            throw new TinkerRuntimeException("resultServiceClass is already set.");
        }
        com_tinkerboots_sdk_a_a.Aui = cls;
        if (com_tinkerboots_sdk_a_a.AiB == null) {
            com_tinkerboots_sdk_a_a.AiB = new com.tinkerboots.sdk.tinker.b.a(com_tinkerboots_sdk_a_a.context);
        }
        if (com_tinkerboots_sdk_a_a.AiC == null) {
            com_tinkerboots_sdk_a_a.AiC = new com.tinkerboots.sdk.tinker.b.c(com_tinkerboots_sdk_a_a.context);
        }
        if (com_tinkerboots_sdk_a_a.AiA == null) {
            com_tinkerboots_sdk_a_a.AiA = new com.tinkerboots.sdk.tinker.b.b(com_tinkerboots_sdk_a_a.context);
        }
        if (com_tinkerboots_sdk_a_a.Auh == null) {
            com_tinkerboots_sdk_a_a.Auh = new f();
        }
        if (com_tinkerboots_sdk_a_a.Aui == null) {
            com_tinkerboots_sdk_a_a.Aui = TinkerServerResultService.class;
        }
        if (com_tinkerboots_sdk_a_a.Auj == null) {
            com_tinkerboots_sdk_a_a.Auj = new com.tinkerboots.sdk.a.a.a();
        }
        aVar = new a(com_tinkerboots_sdk_a_a.context, com_tinkerboots_sdk_a_a.applicationLike, com_tinkerboots_sdk_a_a.AiB, com_tinkerboots_sdk_a_a.AiC, com_tinkerboots_sdk_a_a.AiA, com_tinkerboots_sdk_a_a.Auh, com_tinkerboots_sdk_a_a.Aui, com_tinkerboots_sdk_a_a.Auj);
        if (a.Auc != null) {
            throw new TinkerRuntimeException("TinkerClient instance is already set.");
        }
        a.Auc = aVar;
        aVar = a.cJn().Jj(g.cW(ac.getContext()));
        ceK = com.tencent.mm.sdk.a.b.ceK();
        if (aVar.Aue != null || aVar.Aud == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar = a.Auc;
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[]{Boolean.valueOf(ceK)});
            aVar.Aue.Aun = ceK;
            aVar = a.Auc;
        }
        if (an.isWifi(ac.getContext())) {
        }
        aVar = aVar.gi(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).gi("code-version", e.CLIENT_VERSION).gi("code-reversion", e.REV).gi(TencentLocation.NETWORK_PROVIDER, String.valueOf(an.isWifi(ac.getContext()) ? 3 : 2)).gi("sdk", String.valueOf(VERSION.SDK_INT)).gi("os-name", com.tencent.mm.protocal.d.vAv).gi("device-brand", com.tencent.mm.protocal.d.vAs).gi("device-name", com.tencent.mm.protocal.d.vAx);
        fVar = new f();
        if (aVar.Aue != null || aVar.Aud == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[]{Integer.valueOf(fVar.hashCode())});
            aVar.Aue.Auj = fVar;
        }
        x.i("Tinker.TinkerPatchManager", "try installing end");
        nBi = true;
    }

    public static void aSD() {
        com.tencent.tinker.lib.f.a.a(new 1());
    }

    public static void aSE() {
        if (nBi) {
            com.tencent.tinker.lib.e.a.ip(MMApplicationLike.getTinkerApplicationLike().getApplication()).aSE();
            return;
        }
        throw new RuntimeException("cleanPatch but tinker is not installed");
    }

    public static void Cx(String str) {
        if (nBi) {
            com.tencent.tinker.lib.e.c.bU(MMApplicationLike.getTinkerApplicationLike().getApplication(), str);
            return;
        }
        throw new RuntimeException("upgrade patch but tinker is not installed");
    }
}

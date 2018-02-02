package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class i {
    public static h bDv() {
        if (ac.cfw()) {
            return new h(a.rTD);
        }
        if (ac.cfz()) {
            return new h(a.rTC);
        }
        return null;
    }

    public static long K(int i, long j) {
        if (ac.cfw()) {
            return ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }
        return new h(a.rTD).getLong(i, j);
    }

    public static void L(int i, long j) {
        if (ac.cfw()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else {
            throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ac.Br()}));
        }
    }

    public static long yd(int i) {
        if (ac.cfz()) {
            return ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().getLong(i, 0);
        }
        if (ac.cfw()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rTI;
            if (aVar != null) {
                try {
                    return aVar.getLong(i, 0);
                } catch (RemoteException e) {
                }
            }
        }
        return new h(a.rTC).getLong(i, 0);
    }

    public static void M(int i, long j) {
        if (ac.cfz()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else if (ac.cfw()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rTI;
            if (aVar != null) {
                try {
                    aVar.J(i, j);
                } catch (RemoteException e) {
                }
            }
        }
    }
}

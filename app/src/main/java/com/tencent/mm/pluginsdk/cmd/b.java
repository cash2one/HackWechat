package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    private static final HashMap<String, a> vcJ = new HashMap();
    private static final HashMap<String, a> vcK = new HashMap();
    private static final Pattern vcL = Pattern.compile(" +");

    public static void a(a aVar, String... strArr) {
        synchronized (vcJ) {
            for (Object put : strArr) {
                vcJ.put(put, aVar);
                x.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[]{put});
            }
        }
    }

    public static void D(String... strArr) {
        synchronized (vcJ) {
            for (Object remove : strArr) {
                vcJ.remove(remove);
                x.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[]{remove});
            }
        }
    }

    public static boolean aU(Context context, String str) {
        String[] split = vcL.split(str);
        synchronized (vcJ) {
            a aVar = (a) vcJ.get(split[0]);
        }
        if (aVar == null) {
            return false;
        }
        x.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[]{split[0]});
        return aVar.a(context, split);
    }

    static List<a> bYi() {
        List arrayList;
        synchronized (vcK) {
            arrayList = new ArrayList(vcK.values());
        }
        return arrayList;
    }
}

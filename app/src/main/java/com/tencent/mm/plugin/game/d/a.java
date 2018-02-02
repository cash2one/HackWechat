package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> nuF;
    public boolean nwU;
    private Map<String, Boolean> nwV;

    private a() {
        this.nwU = false;
        this.nwV = new ConcurrentHashMap();
    }

    public final synchronized void clearCache() {
        if (this.nuF != null) {
            this.nuF.clear();
        }
        this.nwU = false;
    }

    public final synchronized void aRQ() {
        if (this.nuF != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.nuF.values()) {
                aVar.nuE = false;
            }
        }
    }

    public final synchronized void aRR() {
        if (this.nuF == null) {
            this.nuF = new LinkedHashMap();
        }
        if (this.nuF.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = ac.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bh.i(e));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.GameCacheUtil", "exception:%s", bh.i(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bh.i(e22));
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bh.i(e3));
                    }
                }
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    x.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", split[r0]);
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.nuB = split2[0];
                    aVar.nuC = split2[1];
                    aVar.nuD = split2[2];
                    aVar.fWv = split2[3];
                    aVar.nuE = false;
                    aVar.isDefault = false;
                    this.nuF.put(aVar.fWv, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.nuF.get(g.aPY());
            if (aVar2 != null) {
                com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.aRT().aRS().get(g.aPY());
                StringBuffer stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nuB);
                    stringBuffer.append(g.BV("zh_CN"));
                }
                aVar2.nuB = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.aRT().aRS().get(g.aPY());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nuC);
                    stringBuffer.append(g.BV("zh_TW"));
                }
                aVar2.nuC = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.aRT().aRS().get(g.aPY());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nuD);
                    stringBuffer.append(g.BV("en"));
                }
                aVar2.nuD = stringBuffer.toString();
                aVar2.isDefault = true;
            }
        }
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> aRS() {
        aRR();
        return this.nuF;
    }

    public final synchronized boolean Cj(String str) {
        boolean z;
        if (bh.ov(str)) {
            z = false;
        } else if (this.nwV.containsKey(str) && ((Boolean) this.nwV.get(str)).booleanValue()) {
            z = false;
        } else {
            x.i("MicroMsg.GameCacheUtil", "download entrance image start : %s", str);
            this.nwV.put(str, Boolean.valueOf(true));
            z = true;
        }
        return z;
    }

    public final synchronized void Ck(String str) {
        if (!bh.ov(str) && this.nwV.containsKey(str)) {
            x.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", str);
            this.nwV.remove(str);
        }
    }
}

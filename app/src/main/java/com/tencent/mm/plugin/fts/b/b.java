package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    private c mMO = new 1(this);
    com.tencent.mm.plugin.fts.c.b mNt;
    private c<bc> mNu = new 2(this);

    static /* synthetic */ List a(b bVar, String str) {
        String str2 = "%s/feature_%s.conf";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String eL = w.eL(ac.getContext());
        eL = eL.equalsIgnoreCase("zh_CN") ? "zh_CN".toLowerCase() : (eL.equalsIgnoreCase("zh_TW") || eL.equalsIgnoreCase("zh_HK")) ? "zh_TW".toLowerCase() : "en".toLowerCase();
        objArr[1] = eL;
        eL = String.format(str2, objArr);
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "decodeToFeatureList %s", new Object[]{eL});
        long lastModified = new File(eL).lastModified();
        int bN = e.bN(eL);
        List arrayList = new ArrayList();
        if (bN == 0) {
            throw new com.tencent.mm.plugin.fts.a.a.l("data file no exist error");
        }
        String[] split = new String(e.e(eL, 0, bN)).split("\n");
        com.tencent.mm.plugin.fts.a.a.c cVar = null;
        for (String str3 : split) {
            String str32;
            if (str32 != null) {
                str32 = str32.trim();
                if (str32.length() != 0) {
                    int indexOf = str32.indexOf("=");
                    if (indexOf >= 0) {
                        String substring = str32.substring(0, indexOf);
                        str32 = str32.substring(indexOf + 1);
                        if (substring.equals("FeatureID")) {
                            if (cVar != null) {
                                cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
                                arrayList.add(cVar);
                            }
                            cVar = new com.tencent.mm.plugin.fts.a.a.c();
                            cVar.field_featureId = Integer.valueOf(str32).intValue();
                            cVar.field_timestamp = lastModified;
                        }
                        if (cVar != null) {
                            if (substring.equals("Title")) {
                                cVar.field_title = str32;
                            } else if (substring.equals("TitlePY")) {
                                cVar.field_titlePY = str32;
                            } else if (substring.equals("TitleShortPY")) {
                                cVar.field_titleShortPY = str32;
                            } else if (substring.equals("Tag")) {
                                cVar.field_tag = str32;
                            } else if (substring.equals("ActionType")) {
                                if (str32.equals("H5")) {
                                    cVar.field_actionType = 2;
                                } else if (str32.equals("Native")) {
                                    cVar.field_actionType = 1;
                                }
                            } else if (substring.equals("Url")) {
                                cVar.field_url = str32;
                            } else if (substring.equals("HelpUrl")) {
                                cVar.field_helpUrl = str32;
                            } else if (substring.equals("UpdateUrl")) {
                                cVar.field_updateUrl = str32;
                            } else if (substring.equals("AndroidUrl")) {
                                cVar.field_androidUrl = str32;
                            }
                        }
                    }
                }
            }
        }
        if (cVar != null) {
            cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
            cVar.field_timestamp = lastModified;
            arrayList.add(cVar);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw new com.tencent.mm.plugin.fts.a.a.l("no data error");
    }

    public final a a(g gVar) {
        return this.gJk.a(-65536, new c(this, gVar, (byte) 0));
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.mNt = (com.tencent.mm.plugin.fts.c.b) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(17);
            this.mMO.ceO();
            this.mNu.ceO();
            this.gJk.a(131132, new b(this, (byte) 0));
            this.gJk.a(131133, new a(this, (byte) 0));
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        this.mMO.dead();
        this.mNu.dead();
        this.mNt = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    public static File aNa() {
        File file = new File(new File(com.tencent.mm.compatible.util.e.gZL, "fts"), "feature");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aNb() {
        File file = new File(aNa(), "fts_feature");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static int D(File file) {
        File file2 = new File(file, "version.info");
        try {
            if (file2.exists()) {
                return Integer.parseInt(FileOp.bT(file2.getAbsolutePath()), 10);
            }
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[]{file2.getAbsolutePath()});
            return -1;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "getFeatureVersion", new Object[0]);
            return -1;
        }
    }
}

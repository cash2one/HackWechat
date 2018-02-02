package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i {
    public static final i syp = new i();
    private static final String syq = (a.bnF + "wallet/lqt");
    private static final String syr = (syq + "/save/");
    private static final String sys = (syq + "/fetch/");
    public ape syj;
    public ape syk;
    private long syl;
    private long sym;
    private List<Bankcard> syn;
    private List<Bankcard> syo;

    public final void a(ape com_tencent_mm_protocal_c_ape, final boolean z) {
        if (com_tencent_mm_protocal_c_ape != null) {
            if (z) {
                this.syj = com_tencent_mm_protocal_c_ape;
                this.syn = null;
                this.syl = System.currentTimeMillis();
            } else {
                this.syk = com_tencent_mm_protocal_c_ape;
                this.syo = null;
                this.sym = System.currentTimeMillis();
            }
            x.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[]{com_tencent_mm_protocal_c_ape, Boolean.valueOf(z)});
            try {
                final byte[] toByteArray = com_tencent_mm_protocal_c_ape.toByteArray();
                e.post(new Runnable(this) {
                    final /* synthetic */ i syu;

                    public final void run() {
                        if (toByteArray != null) {
                            if (z) {
                                if (FileOp.bO(i.syr)) {
                                    FileOp.G(i.syr, true);
                                }
                                FileOp.mh(i.syr);
                                this.syu.syn = null;
                            } else {
                                if (FileOp.bO(i.sys)) {
                                    FileOp.G(i.sys, true);
                                }
                                FileOp.mh(i.sys);
                                this.syu.syo = null;
                            }
                            try {
                                String str = System.currentTimeMillis();
                                String str2 = "MicroMsg.LqtBindQueryInfoCache";
                                String str3 = "saveCacheToDisk, dir: %s, name: %s, save: %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = z ? i.syr : i.sys;
                                objArr[1] = str;
                                objArr[2] = Boolean.valueOf(z);
                                x.i(str2, str3, objArr);
                                long Wq = bh.Wq();
                                FileOp.j((z ? i.syr : i.sys) + str, toByteArray);
                                x.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", new Object[]{e.getMessage()});
                            }
                        }
                    }
                }, "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final Bankcard js(boolean z) {
        jw(z);
        ape com_tencent_mm_protocal_c_ape = z ? this.syj : this.syk;
        if (!(com_tencent_mm_protocal_c_ape == null || bh.ov(com_tencent_mm_protocal_c_ape.wvR))) {
            List<Bankcard> jv = jv(z);
            if (jv != null && jv.size() > 0) {
                String str = com_tencent_mm_protocal_c_ape.wvR;
                if (!bh.ov(str)) {
                    for (Bankcard bankcard : jv) {
                        if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                            return bankcard;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final List<Bankcard> jt(boolean z) {
        jw(z);
        if ((z ? this.syj : this.syk) != null) {
            return jv(z);
        }
        return null;
    }

    public final String ju(boolean z) {
        jw(z);
        ape com_tencent_mm_protocal_c_ape = z ? this.syj : this.syk;
        if (com_tencent_mm_protocal_c_ape != null) {
            return com_tencent_mm_protocal_c_ape.wvU;
        }
        return null;
    }

    private List<Bankcard> jv(boolean z) {
        if ((z ? this.syj : this.syk) != null) {
            if (z) {
                if (this.syn != null && this.syn.size() > 0) {
                    return this.syn;
                }
            } else if (this.syo != null && this.syo.size() > 0) {
                return this.syo;
            }
            Bankcard a;
            Iterator it;
            if (z) {
                this.syn = new ArrayList();
                if (this.syj.wvT != null) {
                    a = ab.a(this.syj.wvT);
                    if (a != null) {
                        this.syn.add(a);
                    }
                }
                if (this.syj.wiJ != null && this.syj.wiJ.size() > 0) {
                    it = this.syj.wiJ.iterator();
                    while (it.hasNext()) {
                        a = d.a((ku) it.next());
                        if (a != null) {
                            this.syn.add(a);
                        }
                    }
                }
                return this.syn;
            }
            this.syo = new ArrayList();
            if (this.syk.wvT != null) {
                a = ab.a(this.syk.wvT);
                if (a != null) {
                    this.syo.add(a);
                }
            }
            if (this.syk.wiJ != null && this.syk.wiJ.size() > 0) {
                it = this.syk.wiJ.iterator();
                while (it.hasNext()) {
                    a = d.a((ku) it.next());
                    if (a != null) {
                        this.syo.add(a);
                    }
                }
            }
            return this.syo;
        } else if (z) {
            this.syn = null;
            return null;
        } else {
            this.syo = null;
            return null;
        }
    }

    public final void jw(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ape com_tencent_mm_protocal_c_ape = z ? this.syj : this.syk;
        long j = z ? this.syl : this.sym;
        if (com_tencent_mm_protocal_c_ape != null) {
            if (currentTimeMillis - j > 3600000) {
                x.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
                this.syj = null;
                if (z) {
                    this.syl = 0;
                } else {
                    this.sym = 0;
                }
            } else {
                return;
            }
        }
        String str = z ? syr : sys;
        List<FileEntry> F = FileOp.F(str, false);
        if (F != null && F.size() != 0) {
            x.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[]{F, Boolean.valueOf(z)});
            long currentTimeMillis2 = System.currentTimeMillis();
            for (FileEntry fileEntry : F) {
                String name = new File(fileEntry.name).getName();
                String str2 = str + name;
                long j2 = bh.getLong(name, 0);
                x.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[]{Long.valueOf(j2)});
                if (j2 <= 0) {
                    FileOp.deleteFile(str2);
                } else if (currentTimeMillis2 - j2 < 3600000) {
                    byte[] d = FileOp.d(str2, 0, (int) FileOp.me(str2));
                    ape com_tencent_mm_protocal_c_ape2 = new ape();
                    try {
                        com_tencent_mm_protocal_c_ape2.aF(d);
                    } catch (Throwable e) {
                        com_tencent_mm_protocal_c_ape2 = null;
                        x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "parse bindquery from cache error: %s", new Object[]{e.getMessage()});
                    }
                    if (com_tencent_mm_protocal_c_ape2 != null) {
                        if (z) {
                            this.syj = com_tencent_mm_protocal_c_ape2;
                            this.syn = null;
                            this.syl = j2;
                        } else {
                            this.syk = com_tencent_mm_protocal_c_ape2;
                            this.syo = null;
                            this.sym = j2;
                        }
                        x.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[]{com_tencent_mm_protocal_c_ape2, Long.valueOf(j2)});
                        return;
                    }
                } else {
                    FileOp.deleteFile(str2);
                }
            }
        }
    }
}

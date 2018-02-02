package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class p extends i<o> implements a {
    public static final String[] gJN = new String[]{i.a(o.gJc, "GetEmotionListCache")};
    private e gJP;

    public p(e eVar) {
        this(eVar, o.gJc, "GetEmotionListCache");
    }

    private p(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    private boolean Yc(String str) {
        if (this.gJP.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(int i, abz com_tencent_mm_protocal_c_abz) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_abz != null) {
            try {
                this.gJP.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
                c oVar = new o(String.valueOf(i), com_tencent_mm_protocal_c_abz.toByteArray());
                x.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[]{Integer.valueOf(i)});
                z = b(oVar);
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return z;
    }

    public final abz DA(int i) {
        abz com_tencent_mm_protocal_c_abz = null;
        Cursor a = this.gJP.a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                abz com_tencent_mm_protocal_c_abz2 = new abz();
                com_tencent_mm_protocal_c_abz2.aF(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[]{Integer.valueOf(i)});
                com_tencent_mm_protocal_c_abz = com_tencent_mm_protocal_c_abz2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return com_tencent_mm_protocal_c_abz;
    }

    public final boolean a(String str, aep com_tencent_mm_protocal_c_aep) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_aep != null) {
            try {
                Yc(str);
                z = b(new o(str, com_tencent_mm_protocal_c_aep.toByteArray()));
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return z;
    }

    public final aep Yd(String str) {
        aep com_tencent_mm_protocal_c_aep = null;
        Cursor a = this.gJP.a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                aep com_tencent_mm_protocal_c_aep2 = new aep();
                com_tencent_mm_protocal_c_aep2.aF(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[]{str});
                com_tencent_mm_protocal_c_aep = com_tencent_mm_protocal_c_aep2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return com_tencent_mm_protocal_c_aep;
    }

    public final bis aAZ() {
        Cursor query;
        Throwable e;
        try {
            bis com_tencent_mm_protocal_c_bis;
            query = this.gJP.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        com_tencent_mm_protocal_c_bis = new bis();
                        com_tencent_mm_protocal_c_bis.aF(oVar.field_cache);
                        if (query != null) {
                            return com_tencent_mm_protocal_c_bis;
                        }
                        query.close();
                        return com_tencent_mm_protocal_c_bis;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
                        if (query != null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            com_tencent_mm_protocal_c_bis = null;
            if (query != null) {
                return com_tencent_mm_protocal_c_bis;
            }
            query.close();
            return com_tencent_mm_protocal_c_bis;
        } catch (Exception e3) {
            e = e3;
            query = null;
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final boolean b(bis com_tencent_mm_protocal_c_bis) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_bis != null) {
            try {
                Yc("Smiley_panel_req_type");
                z = b(new o("Smiley_panel_req_type", com_tencent_mm_protocal_c_bis.toByteArray()));
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return z;
    }

    public final abr Ye(String str) {
        Cursor query;
        abr com_tencent_mm_protocal_c_abr;
        Throwable e;
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            return null;
        }
        try {
            query = this.gJP.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        com_tencent_mm_protocal_c_abr = new abr();
                        com_tencent_mm_protocal_c_abr.aF(oVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        return com_tencent_mm_protocal_c_abr;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
                        if (query == null) {
                            query.close();
                            com_tencent_mm_protocal_c_abr = null;
                        } else {
                            com_tencent_mm_protocal_c_abr = null;
                        }
                        return com_tencent_mm_protocal_c_abr;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            com_tencent_mm_protocal_c_abr = null;
            if (query != null) {
                query.close();
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            if (query == null) {
                com_tencent_mm_protocal_c_abr = null;
            } else {
                query.close();
                com_tencent_mm_protocal_c_abr = null;
            }
            return com_tencent_mm_protocal_c_abr;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return com_tencent_mm_protocal_c_abr;
    }

    public final boolean a(String str, abr com_tencent_mm_protocal_c_abr) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_abr != null) {
            try {
                Yc(str);
                z = b(new o(str, com_tencent_mm_protocal_c_abr.toByteArray()));
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return z;
    }
}

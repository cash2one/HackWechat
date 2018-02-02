package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class h extends i<g> implements a {
    public static final String[] gJN = new String[]{i.a(g.gJc, "EmotionDesignerInfo")};
    public e gJP;

    public h(e eVar) {
        super(eVar, g.gJc, "EmotionDesignerInfo", null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final abl XY(String str) {
        abl com_tencent_mm_protocal_c_abl;
        Throwable e;
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            return null;
        }
        Cursor a;
        try {
            a = this.gJP.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.xAC.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com_tencent_mm_protocal_c_abl = new abl();
                        com_tencent_mm_protocal_c_abl.aF(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return com_tencent_mm_protocal_c_abl;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bh.i(e)});
                        if (a == null) {
                            com_tencent_mm_protocal_c_abl = null;
                        } else {
                            a.close();
                            com_tencent_mm_protocal_c_abl = null;
                        }
                        return com_tencent_mm_protocal_c_abl;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            com_tencent_mm_protocal_c_abl = null;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bh.i(e)});
            if (a == null) {
                a.close();
                com_tencent_mm_protocal_c_abl = null;
            } else {
                com_tencent_mm_protocal_c_abl = null;
            }
            return com_tencent_mm_protocal_c_abl;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return com_tencent_mm_protocal_c_abl;
    }

    public final abj XZ(String str) {
        Throwable e;
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            return null;
        }
        abj com_tencent_mm_protocal_c_abj;
        Cursor a;
        try {
            a = this.gJP.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.xAE.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com_tencent_mm_protocal_c_abj = new abj();
                        com_tencent_mm_protocal_c_abj.aF(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return com_tencent_mm_protocal_c_abj;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bh.i(e)});
                        if (a == null) {
                            a.close();
                            com_tencent_mm_protocal_c_abj = null;
                        } else {
                            com_tencent_mm_protocal_c_abj = null;
                        }
                        return com_tencent_mm_protocal_c_abj;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            com_tencent_mm_protocal_c_abj = null;
            if (a != null) {
                a.close();
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bh.i(e)});
            if (a == null) {
                com_tencent_mm_protocal_c_abj = null;
            } else {
                a.close();
                com_tencent_mm_protocal_c_abj = null;
            }
            return com_tencent_mm_protocal_c_abj;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return com_tencent_mm_protocal_c_abj;
    }
}

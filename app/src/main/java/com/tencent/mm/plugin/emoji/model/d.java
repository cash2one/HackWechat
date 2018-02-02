package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.c.c;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.z.am;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d implements e {
    private c lxp = new c(this) {
        final /* synthetic */ d lxy;

        {
            this.lxy = r1;
        }

        public final void a(boolean z, Object... objArr) {
            boolean f;
            Throwable e;
            File file;
            String Nr;
            String str;
            String str2;
            Object[] objArr2;
            if (objArr == null || objArr.length < 4) {
                x.w("MicroMsg.emoji.EmojiService", "extra obj error");
                return;
            }
            al alVar;
            EmojiInfo emojiInfo;
            int intValue = ((Integer) objArr[2]).intValue();
            if (objArr[0] instanceof al) {
                alVar = (al) objArr[0];
            } else {
                alVar = null;
            }
            if (objArr[1] instanceof EmojiInfo) {
                emojiInfo = (EmojiInfo) objArr[1];
            } else {
                emojiInfo = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (alVar == null || emojiInfo == null) {
                x.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                return;
            }
            this.lxy.lxx.remove(alVar.fqR);
            if (emojiInfo.field_state == EmojiInfo.xAu) {
                x.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                emojiInfo.field_state = EmojiInfo.xAs;
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(emojiInfo);
            }
            if (z) {
                String str3;
                Object[] objArr3;
                String ckB = emojiInfo.ckB();
                if (intValue == 102 || intValue == 101) {
                    String str4;
                    if (intValue == 101) {
                        str4 = ckB + "_extern";
                    } else {
                        str4 = ckB + "_encrypt";
                    }
                    if (com.tencent.mm.a.e.bN(str4) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            f = a.f(Base64.encodeToString(bh.VD(alVar.aeskey), 0), str4, ckB);
                            if (!f) {
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.cm(12);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.cm(8);
                                }
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ckB});
                                if (f) {
                                    b.deleteFile(str4);
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    ckB = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str4));
                                    if (com.tencent.mm.a.g.bV(str4) == null) {
                                    }
                                    objArr3[2] = com.tencent.mm.a.g.bV(str4) == null ? com.tencent.mm.a.g.bV(str4) : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[3] = emojiInfo == null ? emojiInfo.field_aeskey : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[4] = emojiInfo == null ? emojiInfo.field_encrypturl : "";
                                    if (alVar == null) {
                                    }
                                    objArr3[5] = alVar == null ? alVar.xyK : "";
                                    x.i(str3, ckB, objArr3);
                                    if (intValue == 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    }
                                    b.deleteFile(str4);
                                    d.a(alVar);
                                    return;
                                }
                            } else if (intValue == 101) {
                                try {
                                    com.tencent.mm.plugin.emoji.c.cm(11);
                                } catch (Exception e2) {
                                    e = e2;
                                    x.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{bh.i(e)});
                                    if (intValue != 101) {
                                        com.tencent.mm.plugin.emoji.c.cm(12);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.cm(8);
                                    }
                                    x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ckB});
                                    if (f) {
                                        b.deleteFile(str4);
                                        file = new File(ckB);
                                        if (com.tencent.mm.a.e.bN(ckB) > 0) {
                                            str3 = "MicroMsg.emoji.EmojiService";
                                            ckB = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                                            objArr3 = new Object[2];
                                            objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                            objArr3[1] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                                            x.i(str3, ckB, objArr3);
                                            if (intValue == 101) {
                                                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 1, 1, alVar.fqV, 1, alVar.xyL);
                                                com.tencent.mm.plugin.emoji.c.cm(3);
                                            } else {
                                                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 1, 1, alVar.fqV, 1, alVar.xyL);
                                                com.tencent.mm.plugin.emoji.c.cm(3);
                                            }
                                            d.a(alVar);
                                            return;
                                        }
                                        ckB = com.tencent.mm.a.g.i(file);
                                        Nr = emojiInfo.Nr();
                                        if (intValue == 101) {
                                            Nr = emojiInfo.field_externMd5;
                                        }
                                        if (!bh.ov(ckB)) {
                                        }
                                        str = "MicroMsg.emoji.EmojiService";
                                        str2 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                                        objArr2 = new Object[3];
                                        objArr2[0] = ckB;
                                        objArr2[1] = emojiInfo == null ? emojiInfo.Nr() : "";
                                        objArr2[2] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                                        x.i(str, str2, objArr2);
                                        file.delete();
                                        d.a(alVar);
                                        if (intValue != 101) {
                                            com.tencent.mm.plugin.emoji.c.cm(14);
                                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 0, alVar.xyL);
                                            return;
                                        } else if (intValue == 102) {
                                            com.tencent.mm.plugin.emoji.c.cm(5);
                                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 0, 1, alVar.fqV, 1, alVar.xyL);
                                            return;
                                        } else {
                                            com.tencent.mm.plugin.emoji.c.cm(5);
                                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                            return;
                                        }
                                    }
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    ckB = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str4));
                                    objArr3[2] = com.tencent.mm.a.g.bV(str4) == null ? com.tencent.mm.a.g.bV(str4) : "";
                                    objArr3[3] = emojiInfo == null ? emojiInfo.field_aeskey : "";
                                    objArr3[4] = emojiInfo == null ? emojiInfo.field_encrypturl : "";
                                    objArr3[5] = alVar == null ? alVar.xyK : "";
                                    x.i(str3, ckB, objArr3);
                                    if (intValue == 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    }
                                    b.deleteFile(str4);
                                    d.a(alVar);
                                    return;
                                }
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ckB});
                                if (f) {
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    ckB = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str4));
                                    if (com.tencent.mm.a.g.bV(str4) == null) {
                                    }
                                    objArr3[2] = com.tencent.mm.a.g.bV(str4) == null ? com.tencent.mm.a.g.bV(str4) : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[3] = emojiInfo == null ? emojiInfo.field_aeskey : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[4] = emojiInfo == null ? emojiInfo.field_encrypturl : "";
                                    if (alVar == null) {
                                    }
                                    objArr3[5] = alVar == null ? alVar.xyK : "";
                                    x.i(str3, ckB, objArr3);
                                    if (intValue == 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    }
                                    b.deleteFile(str4);
                                    d.a(alVar);
                                    return;
                                }
                                b.deleteFile(str4);
                            } else {
                                com.tencent.mm.plugin.emoji.c.cm(7);
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ckB});
                                if (f) {
                                    b.deleteFile(str4);
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    ckB = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str4));
                                    if (com.tencent.mm.a.g.bV(str4) == null) {
                                    }
                                    objArr3[2] = com.tencent.mm.a.g.bV(str4) == null ? com.tencent.mm.a.g.bV(str4) : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[3] = emojiInfo == null ? emojiInfo.field_aeskey : "";
                                    if (emojiInfo == null) {
                                    }
                                    objArr3[4] = emojiInfo == null ? emojiInfo.field_encrypturl : "";
                                    if (alVar == null) {
                                    }
                                    objArr3[5] = alVar == null ? alVar.xyK : "";
                                    x.i(str3, ckB, objArr3);
                                    if (intValue == 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    }
                                    b.deleteFile(str4);
                                    d.a(alVar);
                                    return;
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            f = false;
                            e = th;
                            x.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{bh.i(e)});
                            if (intValue != 101) {
                                com.tencent.mm.plugin.emoji.c.cm(8);
                            } else {
                                com.tencent.mm.plugin.emoji.c.cm(12);
                            }
                            x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ckB});
                            if (f) {
                                str3 = "MicroMsg.emoji.EmojiService";
                                ckB = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                objArr3 = new Object[6];
                                if (emojiInfo == null) {
                                }
                                objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                                objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str4));
                                if (com.tencent.mm.a.g.bV(str4) == null) {
                                }
                                objArr3[2] = com.tencent.mm.a.g.bV(str4) == null ? com.tencent.mm.a.g.bV(str4) : "";
                                if (emojiInfo == null) {
                                }
                                objArr3[3] = emojiInfo == null ? emojiInfo.field_aeskey : "";
                                if (emojiInfo == null) {
                                }
                                objArr3[4] = emojiInfo == null ? emojiInfo.field_encrypturl : "";
                                if (alVar == null) {
                                }
                                objArr3[5] = alVar == null ? alVar.xyK : "";
                                x.i(str3, ckB, objArr3);
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 1, alVar.xyL);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                }
                                b.deleteFile(str4);
                                d.a(alVar);
                                return;
                            }
                            b.deleteFile(str4);
                            file = new File(ckB);
                            if (com.tencent.mm.a.e.bN(ckB) > 0) {
                                ckB = com.tencent.mm.a.g.i(file);
                                Nr = emojiInfo.Nr();
                                if (intValue == 101) {
                                    Nr = emojiInfo.field_externMd5;
                                }
                                if (bh.ov(ckB)) {
                                }
                                str = "MicroMsg.emoji.EmojiService";
                                str2 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                                objArr2 = new Object[3];
                                objArr2[0] = ckB;
                                if (emojiInfo == null) {
                                }
                                objArr2[1] = emojiInfo == null ? emojiInfo.Nr() : "";
                                if (emojiInfo == null) {
                                }
                                objArr2[2] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                                x.i(str, str2, objArr2);
                                file.delete();
                                d.a(alVar);
                                if (intValue != 101) {
                                    com.tencent.mm.plugin.emoji.c.cm(14);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 0, alVar.xyL);
                                    return;
                                } else if (intValue == 102) {
                                    com.tencent.mm.plugin.emoji.c.cm(5);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    return;
                                } else {
                                    com.tencent.mm.plugin.emoji.c.cm(5);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 0, 1, alVar.fqV, 1, alVar.xyL);
                                    return;
                                }
                            }
                            str3 = "MicroMsg.emoji.EmojiService";
                            ckB = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                            objArr3 = new Object[2];
                            if (emojiInfo == null) {
                            }
                            objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                            if (emojiInfo == null) {
                            }
                            objArr3[1] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                            x.i(str3, ckB, objArr3);
                            if (intValue == 101) {
                                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 1, 1, alVar.fqV, 1, alVar.xyL);
                                com.tencent.mm.plugin.emoji.c.cm(3);
                            } else {
                                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 1, 1, alVar.fqV, 1, alVar.xyL);
                                com.tencent.mm.plugin.emoji.c.cm(3);
                            }
                            d.a(alVar);
                            return;
                        }
                    }
                    x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{emojiInfo.Nr()});
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 1, 1, alVar.fqV, 1, alVar.xyL);
                    } else {
                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 1, 1, alVar.fqV, 1, alVar.xyL);
                    }
                    d.a(alVar);
                    return;
                }
                file = new File(ckB);
                if (com.tencent.mm.a.e.bN(ckB) > 0) {
                    ckB = com.tencent.mm.a.g.i(file);
                    Nr = emojiInfo.Nr();
                    if (intValue == 101) {
                        Nr = emojiInfo.field_externMd5;
                    }
                    if (bh.ov(ckB) || !ckB.equalsIgnoreCase(r2)) {
                        str = "MicroMsg.emoji.EmojiService";
                        str2 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                        objArr2 = new Object[3];
                        objArr2[0] = ckB;
                        if (emojiInfo == null) {
                        }
                        objArr2[1] = emojiInfo == null ? emojiInfo.Nr() : "";
                        if (emojiInfo == null) {
                        }
                        objArr2[2] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                        x.i(str, str2, objArr2);
                        file.delete();
                        d.a(alVar);
                        if (intValue != 101) {
                            com.tencent.mm.plugin.emoji.c.cm(14);
                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 1, alVar.fqV, 0, alVar.xyL);
                            return;
                        } else if (intValue == 102) {
                            com.tencent.mm.plugin.emoji.c.cm(5);
                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 1, alVar.fqV, 1, alVar.xyL);
                            return;
                        } else {
                            com.tencent.mm.plugin.emoji.c.cm(5);
                            com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 0, 1, alVar.fqV, 1, alVar.xyL);
                            return;
                        }
                    }
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.cm(13);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 0, 0, alVar.fqV, 0, alVar.xyL);
                    } else if (intValue == 102) {
                        com.tencent.mm.plugin.emoji.c.cm(4);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 3, 0, 0, alVar.fqV, 0, alVar.xyL);
                    } else {
                        com.tencent.mm.plugin.emoji.c.cm(4);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 0, 0, alVar.fqV, 1, alVar.xyL);
                    }
                    com.tencent.mm.plugin.emoji.e.e.aAR().c(emojiInfo, true);
                    if (this.lxy.lxw != null) {
                        this.lxy.lxw.h(emojiInfo);
                    }
                    d.a(alVar);
                    return;
                }
                str3 = "MicroMsg.emoji.EmojiService";
                ckB = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                objArr3 = new Object[2];
                if (emojiInfo == null) {
                }
                objArr3[0] = emojiInfo == null ? emojiInfo.Nr() : "";
                if (emojiInfo == null) {
                }
                objArr3[1] = emojiInfo == null ? emojiInfo.field_cdnUrl : "";
                x.i(str3, ckB, objArr3);
                if (intValue == 101) {
                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 1, 1, alVar.fqV, 1, alVar.xyL);
                    com.tencent.mm.plugin.emoji.c.cm(3);
                } else {
                    com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 1, 1, alVar.fqV, 1, alVar.xyL);
                    com.tencent.mm.plugin.emoji.c.cm(3);
                }
                d.a(alVar);
                return;
            }
            x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", new Object[]{emojiInfo.Nr()});
            if (intValue == 101) {
                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 4, 1, 1, alVar.fqV, 1, alVar.xyL);
                com.tencent.mm.plugin.emoji.c.cm(3);
            } else {
                com.tencent.mm.plugin.emoji.c.a(alVar.fqR, 2, 1, 1, alVar.fqV, 1, alVar.xyL);
                com.tencent.mm.plugin.emoji.c.cm(3);
            }
            d.a(alVar);
        }
    };
    public HashMap<Long, String> lxs = new HashMap();
    private boolean lxt = false;
    List<b> lxu = new LinkedList();
    private qz lxv;
    public a lxw;
    List lxx = Collections.synchronizedList(new ArrayList());

    public d() {
        ar.CG().a(ac.CTRL_BYTE, this);
    }

    public final void a(String str, EmojiInfo emojiInfo, au auVar) {
        if (!bh.ov(str) && emojiInfo != null) {
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (emojiInfo == null || bh.ov(emojiInfo.field_groupId)) {
                i.aBF().aBi();
            } else {
                boolean z2;
                j aBF = i.aBF();
                String str2 = emojiInfo.field_groupId;
                if (bh.ov(str2)) {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
                    z2 = false;
                } else if (aBF.lwq || q.Gb()) {
                    m mVar;
                    if (aBF.lwu == null || !aBF.lwu.containsKey(str2)) {
                        mVar = new m();
                        mVar.field_prodcutID = str2;
                    } else {
                        mVar = (m) aBF.lwu.get(str2);
                    }
                    if (System.currentTimeMillis() - mVar.field_showTipsTime < aBF.lwr) {
                        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                        aBF.aBi();
                        z2 = false;
                    } else {
                        String str3;
                        String str4;
                        Object[] objArr;
                        String str5;
                        Object[] objArr2;
                        int i;
                        String str6;
                        int i2;
                        Object[] objArr3;
                        if (mVar == null || System.currentTimeMillis() - mVar.field_setFlagTime <= 86400000) {
                            str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str4 = "no need to get reward today. continue count:%d total count:%d";
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(aBF.lwt == null ? 0 : aBF.lwt.field_continuCount);
                            objArr[1] = Integer.valueOf(aBF.lwt == null ? 0 : aBF.lwt.field_totalCount);
                            x.d(str3, str4, objArr);
                        } else if (aBF.lwt != null && str2.equalsIgnoreCase(aBF.lwt.field_prodcutID) && aBF.lwt.field_continuCount >= aBF.lws - 1 && aBF.lwt.field_continuCount <= (aBF.lws + 5) - 1) {
                            ar.CG().a(new o(str2, o.lzf), 0);
                        } else if (mVar.field_totalCount >= aBF.kFr - 1 && mVar.field_totalCount <= (aBF.kFr + 5) - 1) {
                            ar.CG().a(new o(str2, o.lzf), 0);
                        }
                        if (aBF.lwt == null || !str2.equalsIgnoreCase(aBF.lwt.field_prodcutID) || aBF.lwt.field_continuCount < aBF.lws) {
                            if (mVar != null && mVar.field_totalCount >= aBF.kFr) {
                                if ((mVar.field_flag & o.lzg) != o.lzg || (mVar.field_flag & o.lzh) == o.lzh) {
                                    str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                                    objArr2 = new Object[4];
                                    objArr2[0] = Boolean.valueOf(false);
                                    objArr2[1] = str2;
                                    objArr2[2] = Integer.valueOf(aBF.lwt == null ? 0 : aBF.lwt.field_totalCount);
                                    i = 3;
                                    if (aBF.lwt == null) {
                                        str6 = str5;
                                        objArr = objArr2;
                                        Object[] objArr4 = objArr2;
                                        i2 = 3;
                                        i = 0;
                                        str2 = str4;
                                        objArr3 = objArr4;
                                        objArr3[i2] = Integer.valueOf(i);
                                        x.i(str6, str2, objArr);
                                    } else {
                                        str2 = str5;
                                        str5 = str4;
                                        objArr3 = objArr2;
                                    }
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d";
                                    objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(true);
                                    objArr[1] = str2;
                                    objArr[2] = Integer.valueOf(aBF.lwt == null ? 0 : aBF.lwt.field_totalCount);
                                    x.i(str3, str4, objArr);
                                    aBF.a(mVar, true);
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                    objArr3 = new Object[2];
                                    objArr3[0] = Integer.valueOf(0);
                                    objArr3[1] = aBF.lwt == null ? "" : aBF.lwt.field_prodcutID;
                                    gVar.h(12953, objArr3);
                                    z2 = true;
                                }
                            }
                            aBF.a(mVar, false);
                            z2 = false;
                        } else if ((aBF.lwt.field_flag & o.lzg) != o.lzg || (aBF.lwt.field_flag & o.lzh) == o.lzh) {
                            objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(false);
                            objArr2[1] = str2;
                            objArr2[2] = Integer.valueOf(aBF.lwt.field_continuCount);
                            i = 3;
                            str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str5 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
                            objArr3 = objArr2;
                        } else {
                            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[]{Boolean.valueOf(true), str2, Integer.valueOf(aBF.lwt.field_continuCount)});
                            aBF.a(mVar, true);
                            com.tencent.mm.plugin.report.service.g.pQN.h(12953, new Object[]{Integer.valueOf(0), aBF.lwt.field_prodcutID});
                            z2 = true;
                        }
                        str6 = str2;
                        str2 = str5;
                        objArr = objArr3;
                        objArr3 = objArr2;
                        i2 = i;
                        i = aBF.lwt.field_flag;
                        objArr3[i2] = Integer.valueOf(i);
                        x.i(str6, str2, objArr);
                        aBF.a(mVar, false);
                        z2 = false;
                    }
                } else {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[]{Boolean.valueOf(aBF.lwq), Boolean.valueOf(q.Gb())});
                    z2 = false;
                }
                x.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[]{Boolean.valueOf(z2)});
                z = z2;
            }
            if (auVar == null) {
                cf auVar2 = new au();
                if (emojiInfo.field_type == EmojiInfo.xAo || emojiInfo.field_type == EmojiInfo.xAp) {
                    auVar2.setType(1048625);
                } else {
                    auVar2.setType(47);
                }
                auVar2.dS(str);
                auVar2.eR(1);
                String FS = q.FS();
                boolean z3 = (emojiInfo.Yz() || emojiInfo.isGif()) ? false : true;
                auVar2.setContent(aj.a(FS, currentTimeMillis, z3, emojiInfo.Nr(), z, ""));
                auVar2.dT(emojiInfo.Nr());
                auVar2.aq(ba.hR(auVar2.field_talker));
                ar.Hg();
                j = currentTimeMillis;
                currentTimeMillis = com.tencent.mm.z.c.Fa().Q(auVar2);
            } else {
                long j2 = auVar.field_msgId;
                aj Xp = aj.Xp(auVar.field_content);
                if (Xp.time != 0) {
                    j = Xp.time;
                    currentTimeMillis = j2;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + currentTimeMillis);
            this.lxu.add(new b(this, currentTimeMillis, str, emojiInfo, String.valueOf(j)));
            if (!this.lxt || this.lxu.size() == 1) {
                this.lxt = true;
                ar.CG().a(new r(String.valueOf(j), str, emojiInfo, currentTimeMillis), 0);
            }
            String str7 = emojiInfo.field_md5;
            yx(emojiInfo.field_groupId);
        }
    }

    public final void yx(String str) {
        ag.y(new 1(this, str));
    }

    public final boolean g(EmojiInfo emojiInfo) {
        al alVar;
        String str = null;
        if (emojiInfo == null) {
            x.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            alVar = null;
        } else {
            alVar = new al();
            alVar.fqR = emojiInfo.field_md5;
            alVar.xyG = emojiInfo.field_type;
            alVar.xyH = emojiInfo.field_size;
            alVar.fqV = emojiInfo.field_groupId;
            alVar.xyL = emojiInfo.field_designerID;
            alVar.thumbUrl = emojiInfo.field_thumbUrl;
            alVar.fuY = emojiInfo.field_encrypturl;
            alVar.aeskey = emojiInfo.field_aeskey;
            alVar.width = emojiInfo.field_width;
            alVar.height = emojiInfo.field_height;
            alVar.nBo = emojiInfo.field_cdnUrl;
            alVar.xyM = emojiInfo.field_externUrl;
            alVar.xyN = emojiInfo.field_externMd5;
            alVar.xyP = emojiInfo.field_activityid;
        }
        alVar.talker = emojiInfo.talker;
        if (alVar == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            alVar.xyO = false;
            a(alVar, null, true);
            if (emojiInfo != null) {
                str = emojiInfo.field_groupId;
            }
            yx(str);
        }
        return true;
    }

    public final void a(al alVar, com.tencent.mm.ae.d.a aVar, boolean z) {
        if (alVar == null) {
            x.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            return;
        }
        EmojiInfo emojiInfo;
        if (!(aVar == null || aVar.hmq == null || aVar.hmq.vHe != alVar.fFo)) {
            alVar.gjE = ba.c(aVar);
            alVar.hEK = aVar.hmq.vHf;
            alVar.hVE = (long) aVar.hmq.pbl;
        }
        EmojiInfo XU = i.aBE().lwL.XU(alVar.fqR);
        if (XU != null) {
            Object obj = null;
            if (!(bh.ov(alVar.fqV) || alVar.fqV.equals(XU.field_groupId))) {
                XU.field_groupId = alVar.fqV;
                obj = 1;
            }
            if (!(bh.ov(alVar.xyL) || alVar.xyL.equals(XU.field_designerID))) {
                XU.field_designerID = alVar.xyL;
                obj = 1;
            }
            if (!(bh.ov(alVar.thumbUrl) || alVar.thumbUrl.equals(XU.field_thumbUrl))) {
                XU.field_thumbUrl = alVar.thumbUrl;
                obj = 1;
            }
            if (!(bh.ov(alVar.fuY) || alVar.fuY.equals(XU.field_encrypturl))) {
                XU.field_encrypturl = alVar.fuY;
                obj = 1;
            }
            if (!(bh.ov(alVar.aeskey) || alVar.aeskey.equals(XU.field_aeskey))) {
                XU.field_aeskey = alVar.aeskey;
                obj = 1;
            }
            if (!(bh.ov(alVar.nBo) || alVar.nBo.equals(XU.field_cdnUrl))) {
                XU.field_cdnUrl = alVar.nBo;
                obj = 1;
            }
            if (alVar.width > 0 && alVar.width != XU.field_width) {
                XU.field_width = alVar.width;
                obj = 1;
            }
            if (alVar.height > 0 && alVar.height != XU.field_height) {
                XU.field_height = alVar.height;
                obj = 1;
            }
            if (!(bh.ov(alVar.xyM) || alVar.xyM.equals(XU.field_externUrl))) {
                XU.field_externUrl = alVar.xyM;
                obj = 1;
            }
            if (!(bh.ov(alVar.xyN) || alVar.xyN.equals(XU.field_externMd5))) {
                XU.field_externMd5 = alVar.xyN;
                obj = 1;
            }
            if (!(bh.ov(alVar.xyP) || alVar.xyP.equalsIgnoreCase(XU.field_activityid))) {
                XU.field_activityid = alVar.xyP;
                obj = 1;
            }
            if (obj != null) {
                i.aBE().lwL.p(XU);
                x.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", new Object[]{XU.field_designerID, XU.field_thumbUrl});
            }
            emojiInfo = XU;
        } else {
            x.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
            EmojiInfo emojiInfo2 = new EmojiInfo();
            emojiInfo2.field_md5 = alVar.fqR;
            emojiInfo2.field_svrid = alVar.id;
            emojiInfo2.field_catalog = EmojiInfo.xAe;
            emojiInfo2.field_type = alVar.xyG;
            emojiInfo2.field_size = alVar.xyH;
            emojiInfo2.field_groupId = alVar.fqV;
            emojiInfo2.field_designerID = alVar.xyL;
            emojiInfo2.field_thumbUrl = alVar.thumbUrl;
            emojiInfo2.field_cdnUrl = alVar.nBo;
            emojiInfo2.field_temp = 1;
            emojiInfo2.field_encrypturl = alVar.fuY;
            emojiInfo2.field_aeskey = alVar.aeskey;
            emojiInfo2.field_designerID = alVar.xyL;
            emojiInfo2.field_thumbUrl = alVar.thumbUrl;
            emojiInfo2.field_state = EmojiInfo.xAu;
            emojiInfo2.field_width = alVar.width;
            emojiInfo2.field_height = alVar.height;
            emojiInfo2.field_externUrl = alVar.xyM;
            emojiInfo2.field_externMd5 = alVar.xyN;
            emojiInfo2.field_activityid = alVar.xyP;
            i.aBE().lwL.n(emojiInfo2);
            emojiInfo = emojiInfo2;
        }
        long j = 0;
        if (alVar.xyO) {
            emojiInfo.cks();
            if (alVar.fFo != 0) {
                ar.Hg();
                cf F = com.tencent.mm.z.c.Fa().F(alVar.talker, alVar.fFo);
                if (F.field_msgSvrId == alVar.fFo) {
                    j = F.field_msgId;
                }
            }
            ar.Hg();
            com.tencent.mm.l.a WO = com.tencent.mm.z.c.EY().WO(alVar.talker);
            if (WO == null || ((int) WO.gJd) == 0) {
                com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(alVar.talker);
                xVar.setType(2);
                ar.Hg();
                com.tencent.mm.z.c.EY().R(xVar);
            }
            cf auVar = new au();
            auVar.setType(47);
            auVar.dS(alVar.talker);
            auVar.eR(q.gr(alVar.hVz) ? 1 : 0);
            auVar.dT(emojiInfo.Nr());
            auVar.ap(alVar.fFo);
            String str = alVar.hVz;
            boolean z2 = (emojiInfo.Yz() || emojiInfo.isGif()) ? false : true;
            auVar.setContent(aj.a(str, 0, z2, emojiInfo.Nr(), false, alVar.xyK));
            auVar.aq(ba.n(auVar.field_talker, alVar.hVE));
            auVar.eQ(3);
            if (!bh.ov(alVar.gjF)) {
                auVar.dY(alVar.gjF);
            }
            if (aVar == null) {
                int i = alVar.gjE;
                if (i != 0) {
                    auVar.fa(i);
                    if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i & 2) != 0) {
                        auVar.aq(ba.a(auVar.field_talker, alVar.hVE, true, auVar.field_msgSeq));
                    }
                }
                if (alVar.hEK != 0) {
                    auVar.as((long) alVar.hEK);
                }
                x.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(alVar.hEK)});
            } else {
                ba.a(auVar, aVar);
            }
            if (this.lxs != null && this.lxs.containsKey(Long.valueOf(auVar.field_msgSvrId))) {
                x.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
                auVar.setContent((String) this.lxs.get(Long.valueOf(auVar.field_msgSvrId)));
                auVar.setType(10000);
                this.lxs.remove(Long.valueOf(auVar.field_msgSvrId));
            }
            long i2 = ba.i(auVar);
            if (!q.gr(alVar.hVz)) {
                ar.Hg();
                ((am) ar.getNotification()).a(com.tencent.mm.z.c.Fa().dH(i2));
            }
            j = i2;
        }
        if (!emojiInfo.cks()) {
            if (!z) {
                x.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[]{Boolean.valueOf(z)});
                this.lxx.remove(alVar.fqR);
                a(alVar);
            } else if (this.lxx == null || !this.lxx.contains(alVar.fqR)) {
                this.lxx.add(alVar.fqR);
                String ckB = emojiInfo.ckB();
                if (n.aBq() && n.aBr() && !bh.ov(emojiInfo.field_externUrl) && !bh.ov(emojiInfo.field_externMd5)) {
                    i.aBe().a(alVar.xyM, f.i(ckB + "_extern", new Object[]{alVar, emojiInfo, Integer.valueOf(101), Long.valueOf(j)}), this.lxp);
                    com.tencent.mm.plugin.emoji.c.cm(10);
                } else if (!bh.ov(alVar.fuY) && !bh.ov(alVar.aeskey)) {
                    i.aBe().a(alVar.fuY, f.i(ckB + "_encrypt", new Object[]{alVar, emojiInfo, Integer.valueOf(102), Long.valueOf(j)}), this.lxp);
                    com.tencent.mm.plugin.emoji.c.cm(6);
                } else if (bh.ov(alVar.nBo)) {
                    this.lxx.remove(alVar.fqR);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(alVar.fqR);
                    ar.CG().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                    x.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", new Object[]{alVar.fqR});
                    com.tencent.mm.plugin.emoji.c.cm(9);
                } else {
                    i.aBe().a(alVar.nBo, f.h(ckB, new Object[]{alVar, emojiInfo, Integer.valueOf(100), Long.valueOf(j)}), this.lxp);
                    com.tencent.mm.plugin.emoji.c.cm(1);
                }
            } else {
                x.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", new Object[]{alVar.fqR});
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 2;
        x.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof r)) {
            return;
        }
        if (this.lxu.size() <= 0) {
            this.lxt = false;
            return;
        }
        b bVar;
        b bVar2 = (b) this.lxu.remove(0);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.d.pPH.a(111, 35, 1, true);
            i3 = 5;
        }
        ar.Hg();
        au dH = com.tencent.mm.z.c.Fa().dH(bVar2.fqm);
        dH.eQ(i3);
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(bVar2.fqm, dH);
        if (this.lxu.size() > 0) {
            bVar = (b) this.lxu.get(0);
            ar.CG().a(new r(bVar.fus, bVar.toUserName, bVar.foU, bVar.fqm), 0);
        } else {
            this.lxt = false;
            bVar = bVar2;
        }
        if (this.lxv == null) {
            this.lxv = new qz();
        }
        this.lxv.fIN.fqV = bVar.foU.field_groupId;
        com.tencent.mm.sdk.b.a.xef.m(this.lxv);
    }

    static void a(al alVar) {
        if (alVar != null) {
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(alVar.talker, "update", null));
        }
    }
}

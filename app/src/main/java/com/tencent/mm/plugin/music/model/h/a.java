package com.tencent.mm.plugin.music.model.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends i<com.tencent.mm.av.a> {
    public e gJP;
    public f<String, com.tencent.mm.av.a> oMR = new f(20);
    public f<String, com.tencent.mm.plugin.music.model.a> oMS = new f(10);

    public a(e eVar) {
        super(eVar, com.tencent.mm.av.a.gJc, "Music", null);
        this.gJP = eVar;
    }

    public final com.tencent.mm.av.a Gx(String str) {
        if (this.oMR.get(str) != null) {
            return (com.tencent.mm.av.a) this.oMR.get(str);
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor a = this.gJP.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return null;
        }
        com.tencent.mm.av.a aVar = new com.tencent.mm.av.a();
        aVar.b(a);
        a.close();
        this.oMR.put(str, aVar);
        return aVar;
    }

    public final com.tencent.mm.plugin.music.model.a g(com.tencent.mm.av.a aVar, boolean z) {
        com.tencent.mm.plugin.music.model.a.a aVar2;
        String str = aVar.field_songLyric;
        String string = ac.getContext().getString(R.l.ewR);
        String str2 = aVar.field_songSnsShareUser;
        boolean d = g.d(aVar);
        String str3 = aVar.field_songSinger;
        com.tencent.mm.plugin.music.model.a aVar3 = new com.tencent.mm.plugin.music.model.a();
        long Wq = bh.Wq();
        if (bh.ov(str)) {
            com.tencent.mm.plugin.music.model.a.a aVar4 = new com.tencent.mm.plugin.music.model.a.a();
            aVar4.timestamp = 0;
            if (z) {
                aVar4.content = str3;
            } else if (d) {
                aVar4.content = ac.getContext().getString(R.l.eyc);
            } else {
                aVar4.content = ac.getContext().getString(R.l.eyb);
            }
            if (aVar4.content != null) {
                aVar3.oJl.add(aVar4);
            }
        } else {
            if (str == null) {
                x.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            } else {
                int i;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    CharSequence group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        x.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar3.title = com.tencent.mm.plugin.music.model.a.dt(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar3.jeC = com.tencent.mm.plugin.music.model.a.dt(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar3.album = com.tencent.mm.plugin.music.model.a.dt(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar3.oJn = com.tencent.mm.plugin.music.model.a.dt(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar3.oJ = bh.getLong(com.tencent.mm.plugin.music.model.a.dt(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar3.oJo = com.tencent.mm.plugin.music.model.a.dt(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar3.oJp = com.tencent.mm.plugin.music.model.a.dt(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        com.tencent.mm.plugin.music.model.a.a aVar5 = new com.tencent.mm.plugin.music.model.a.a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar5.timestamp = com.tencent.mm.plugin.music.model.a.FJ(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar3.oJm.add(Long.valueOf(aVar5.timestamp));
                                break;
                            }
                            String str4 = split[split.length - 1];
                            if (str4 != null) {
                                str4 = str4.trim();
                            }
                            if (bh.ov(str4)) {
                                str4 = " ";
                            }
                            aVar5.content = str4;
                            for (i = 0; i < aVar3.oJm.size(); i++) {
                                com.tencent.mm.plugin.music.model.a.a aVar6 = new com.tencent.mm.plugin.music.model.a.a();
                                aVar6.timestamp = ((Long) aVar3.oJm.get(i)).longValue();
                                aVar6.content = aVar5.content;
                                aVar6.oJr = true;
                            }
                            aVar3.oJm.clear();
                            i = aVar3.oJl.size() - 1;
                            while (i >= 0 && ((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(i)).timestamp != aVar5.timestamp) {
                                if (((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(i)).timestamp < aVar5.timestamp) {
                                    aVar3.oJl.add(i + 1, aVar5);
                                    break;
                                }
                                i--;
                            }
                            if (i < 0) {
                                aVar3.oJl.add(0, aVar5);
                            }
                        }
                    }
                }
                x.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[]{Long.valueOf(aVar3.oJ)});
                if (aVar3.oJ != 0) {
                    for (i = 0; i < aVar3.oJl.size(); i++) {
                        aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(i);
                        aVar2.timestamp += aVar3.oJ;
                    }
                    aVar3.oJ = 0;
                }
                int i2 = 0;
                while (i2 < aVar3.oJl.size() - 1) {
                    aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(i2);
                    if (aVar2.oJr && aVar2.content.equals(((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(i2 + 1)).content)) {
                        aVar2.content = " ";
                    }
                    i2++;
                }
            }
            x.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[]{str});
            x.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[]{Integer.valueOf(aVar3.oJl.size())});
        }
        if (bh.ov(str2)) {
            x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar2 = new com.tencent.mm.plugin.music.model.a.a();
            aVar2.timestamp = 0;
            aVar2.content = ac.getContext().getString(R.l.eSo, new Object[]{r.gu(str2)});
            if (aVar3.oJl.isEmpty()) {
                aVar3.oJl.add(aVar2);
            } else if (aVar3.oJl.size() == 1) {
                aVar3.oJl.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(1)).timestamp = 5000;
            } else {
                aVar3.oJl.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(2)).timestamp >> 2);
            }
        }
        if (!bh.ov(str)) {
            if (bh.ov(string)) {
                x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar2 = new com.tencent.mm.plugin.music.model.a.a();
                aVar2.timestamp = 0;
                aVar2.content = string;
                if (aVar3.oJl.isEmpty()) {
                    aVar3.oJl.add(aVar2);
                } else if (aVar3.oJl.size() == 1) {
                    aVar3.oJl.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(1)).timestamp = 5000;
                } else {
                    aVar3.oJl.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.oJl.get(2)).timestamp >> 2);
                }
            }
        }
        x.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
        this.oMS.put(aVar.field_musicId, aVar3);
        return aVar3;
    }

    public final com.tencent.mm.av.a M(String str, int i, int i2) {
        x.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.av.a Gx = Gx(str);
        if (Gx == null) {
            x.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[]{str});
            return null;
        }
        Gx.field_songBgColor = i;
        Gx.field_songLyricColor = i2;
        c(Gx, new String[]{"songBgColor", "songLyricColor"});
        this.oMR.put(str, Gx);
        return Gx;
    }

    public final com.tencent.mm.av.a x(asv com_tencent_mm_protocal_c_asv) {
        c aVar;
        int i;
        String i2 = g.i(com_tencent_mm_protocal_c_asv);
        c Gx = Gx(i2);
        if (Gx == null) {
            aVar = new com.tencent.mm.av.a();
            i = 0;
        } else {
            aVar = Gx;
            i = 1;
        }
        aVar.field_musicId = i2;
        aVar.field_originMusicId = com_tencent_mm_protocal_c_asv.vVZ;
        aVar.field_musicType = com_tencent_mm_protocal_c_asv.wAi;
        aVar.field_appId = com_tencent_mm_protocal_c_asv.ngo;
        if (bh.ov(aVar.field_appId)) {
            aVar.field_appId = g.k(com_tencent_mm_protocal_c_asv);
        }
        aVar.field_songAlbum = com_tencent_mm_protocal_c_asv.wAm;
        aVar.field_songAlbumType = com_tencent_mm_protocal_c_asv.wAu;
        aVar.field_songWifiUrl = com_tencent_mm_protocal_c_asv.wAo;
        aVar.field_songName = com_tencent_mm_protocal_c_asv.wAk;
        aVar.field_songSinger = com_tencent_mm_protocal_c_asv.wAl;
        aVar.field_songWapLinkUrl = com_tencent_mm_protocal_c_asv.wAp;
        aVar.field_songWebUrl = com_tencent_mm_protocal_c_asv.wAq;
        aVar.field_songAlbumLocalPath = com_tencent_mm_protocal_c_asv.wAs;
        aVar.field_songMediaId = com_tencent_mm_protocal_c_asv.vZq;
        aVar.field_songSnsAlbumUser = com_tencent_mm_protocal_c_asv.wAy;
        aVar.field_songAlbumUrl = com_tencent_mm_protocal_c_asv.wAn;
        aVar.field_songSnsShareUser = com_tencent_mm_protocal_c_asv.wAz;
        if (!bh.ov(com_tencent_mm_protocal_c_asv.wAv)) {
            aVar.field_songHAlbumUrl = com_tencent_mm_protocal_c_asv.wAv;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        if (aVar.field_songId == 0) {
            g.h(com_tencent_mm_protocal_c_asv);
            aVar.field_songId = com_tencent_mm_protocal_c_asv.wmR;
        }
        if ((bh.ov(aVar.field_songWapLinkUrl) || aVar.field_songWapLinkUrl.equals(aVar.field_songWebUrl)) && !bh.ov(aVar.field_songWifiUrl)) {
            aVar.field_songWapLinkUrl = aVar.field_songWifiUrl;
        }
        if (aVar.field_songId == 0 && com_tencent_mm_protocal_c_asv.wAi == 4) {
            try {
                aVar.field_songId = Integer.valueOf(com_tencent_mm_protocal_c_asv.vVZ).intValue();
            } catch (Exception e) {
            }
        }
        aVar.field_hideBanner = com_tencent_mm_protocal_c_asv.wAB;
        aVar.field_jsWebUrlDomain = com_tencent_mm_protocal_c_asv.wAC;
        aVar.field_startTime = com_tencent_mm_protocal_c_asv.hkt;
        aVar.hHP = com_tencent_mm_protocal_c_asv.hHP;
        aVar.field_protocol = com_tencent_mm_protocal_c_asv.protocol;
        aVar.field_barBackToWebView = com_tencent_mm_protocal_c_asv.wAD;
        aVar.field_musicbar_url = com_tencent_mm_protocal_c_asv.wAE;
        if (i != 0) {
            x.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[]{i2});
            c(aVar, new String[0]);
        } else {
            x.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[]{i2});
            b(aVar);
        }
        this.oMR.put(i2, aVar);
        return aVar;
    }

    public final void U(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_wifiDownloadedLength = j;
        }
    }

    public final void V(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_songWifiFileLength = j;
        }
    }

    public final void bL(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiEndFlag", Integer.valueOf(i));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_wifiEndFlag = i;
        }
    }

    public final void W(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_downloadedLength = j;
        }
    }

    public final void bM(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endFlag", Integer.valueOf(i));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_endFlag = i;
        }
    }

    public final void X(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        int update = this.gJP.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) this.oMR.get(str);
        if (aVar != null) {
            aVar.field_songFileLength = j;
        }
    }
}

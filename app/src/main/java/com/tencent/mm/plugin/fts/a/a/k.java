package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public final class k extends j {
    public final k f(Cursor cursor) {
        this.mMd = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mLr = cursor.getInt(2);
        this.mMf = cursor.getLong(3);
        this.mLs = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.talker = cursor.getString(6);
        return this;
    }

    public final k g(Cursor cursor) {
        this.mMd = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mLr = cursor.getInt(2);
        this.mMf = cursor.getLong(3);
        this.mLs = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.content = cursor.getString(6);
        this.mMh = cursor.getString(7);
        this.mMn = cursor.getLong(8);
        return this;
    }

    public final k h(Cursor cursor) {
        this.mMd = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mLr = cursor.getInt(2);
        this.mMf = cursor.getLong(3);
        this.mLs = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.mMh = cursor.getString(7);
        }
        return this;
    }

    private void a(Pattern pattern) {
        int i = 0;
        this.mMk = pattern.split(this.content);
        this.mMl = new int[this.mMk.length];
        int i2 = 0;
        while (i < this.mMl.length) {
            this.mMl[i] = i2;
            i2 += this.mMk[i].length() + 1;
            i++;
        }
    }

    public final void aMY() {
        if (!bh.ov(this.mMh)) {
            switch (this.type) {
                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                case 131073:
                case 131074:
                case 131076:
                case 262144:
                case 327680:
                    switch (this.mLr) {
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                            try {
                                String[] split = a.mKx.split(this.mMh);
                                a(a.mKB);
                                this.mMi = Arrays.binarySearch(this.mMl, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                                if (this.mMi < 0) {
                                    this.mMi = (-this.mMi) - 2;
                                }
                                this.mMj = this.mMk[this.mMi];
                                return;
                            } catch (Exception e) {
                                this.mMi = Integer.MAX_VALUE;
                                this.mMj = "";
                                return;
                            }
                        case 11:
                            this.mMi = Integer.MAX_VALUE;
                            this.mMj = "";
                            return;
                        default:
                            try {
                                this.mMi = new String(this.content.getBytes(), 0, Integer.valueOf(a.mKx.split(this.mMh)[1]).intValue()).length();
                                this.mMj = this.content;
                                return;
                            } catch (Exception e2) {
                                this.mMi = Integer.MAX_VALUE;
                                this.mMj = "";
                                return;
                            }
                    }
                case 131075:
                    aMZ();
                    return;
                default:
                    return;
            }
        }
    }

    private void aMZ() {
        switch (this.mLr) {
            case 38:
                List arrayList = new ArrayList();
                a(a.mKy);
                String[] split = a.mKx.split(this.mMh);
                byte[] bytes = this.content.getBytes();
                for (int i = 0; i < split.length; i += 2) {
                    String str;
                    int intValue = Integer.valueOf(split[i]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.mMl, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String[] split2 = a.mKz.split(this.mMk[binarySearch]);
                    int i2 = length - this.mMl[binarySearch];
                    length = 0;
                    while (length < split2.length) {
                        i2 = (i2 - split2[length].length()) - 1;
                        if (i2 < 0) {
                            str = split2[length];
                            i2 = c.mKq[length];
                            if (i2 > 0) {
                                arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                            }
                        } else {
                            length++;
                        }
                    }
                    i2 = -1;
                    str = null;
                    if (i2 > 0) {
                        arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                    }
                }
                this.mMm = arrayList;
                return;
            default:
                return;
        }
    }

    public final void a(e eVar) {
        if (eVar.mLC.length > 1) {
            this.mMo = 1;
        } else {
            this.mMo = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.mLx += 50;
                String FS = q.FS();
                if (this.mLr == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.mMm != null) {
                        for (d dVar : this.mMm) {
                            if (!FS.equals(dVar.gfN)) {
                                hashSet.add(Integer.valueOf(dVar.mLt));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.mMf - 1) {
                        this.mLx += 20;
                        this.mMp = true;
                    }
                    if (eVar.mLC.length > 1 && this.content.contains(eVar.mLA)) {
                        this.mMo = 2;
                        this.mLx += 5;
                    }
                    if (this.mMf <= 15) {
                        this.mMr = 1;
                    }
                }
                if ((this.mLr == 5 || this.mLr == 1) && this.content.contains(eVar.mLA)) {
                    if (eVar.mLC.length > 1) {
                        this.mMo = 2;
                    }
                    this.mLx += 10;
                }
            }
        } else if (this.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.mLx += 50;
            }
            if ((this.mLr == 5 || this.mLr == 1) && this.content.contains(eVar.mLA)) {
                if (eVar.mLC.length > 1) {
                    this.mMo = 2;
                }
                this.mLx += 10;
            }
        }
    }
}

package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.gallery.stub.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class c {
    private static int bkq = 0;
    private static c mQJ = null;
    public static boolean mQK = false;
    public static boolean mQL = false;
    public static boolean mQM = false;
    public static boolean mQN = false;
    private l mQE;
    private a mQF;
    private e mQG;
    private ArrayList<GalleryItem$MediaItem> mQH = null;
    private LinkedHashSet<GalleryItem$MediaItem> mQI = new LinkedHashSet();
    private HashSet<GalleryItem$MediaItem> mQO = new HashSet();
    private ArrayList<Bundle> mQP = new ArrayList();
    private HashMap<Integer, Boolean> mQQ = new HashMap();

    public static GalleryItem$MediaItem Bt(String str) {
        GalleryItem$MediaItem a = GalleryItem$MediaItem.a(0, 0, str, "", "");
        if (aNC().mQH != null) {
            int indexOf = aNC().mQH.indexOf(a);
            if (indexOf >= 0) {
                return (GalleryItem$MediaItem) aNC().mQH.get(indexOf);
            }
        }
        return null;
    }

    private c() {
        if (this.mQF == null) {
            this.mQF = new a();
        }
        if (this.mQE == null) {
            this.mQE = new l();
        }
        if (this.mQG == null) {
            this.mQG = new e();
        }
    }

    private static c aNC() {
        if (mQJ == null) {
            mQJ = new c();
        }
        return mQJ;
    }

    public static a aND() {
        return aNC().mQF;
    }

    public static l aNE() {
        return aNC().mQE;
    }

    public static e aNF() {
        return aNC().mQG;
    }

    public static void initialize() {
        synchronized (c.class) {
            bkq++;
        }
    }

    public static void release(boolean z) {
        synchronized (c.class) {
            if (bkq > 0) {
                bkq--;
            }
            if (z && bkq == 0) {
                aNC().mQE = null;
                if (aNC().mQF != null) {
                    b bVar = aNC().mQF.mQp;
                    if (bVar.mQA != null) {
                        bVar.mQA.a(new b$4(bVar));
                        bVar.mQA = null;
                    }
                    if (bVar.mQB != null) {
                        d dVar = bVar.mQB;
                        dVar.aNN();
                        dVar.aNO();
                        dVar.aNQ();
                        bVar.mQB = null;
                    }
                    aNC().mQF = null;
                }
                e eVar = aNC().mQG;
                if (eVar.mQV != null) {
                    eVar.mQV.quit();
                    eVar.mQV = null;
                }
                eVar.mQY = null;
                if (eVar.mQW != null) {
                    eVar.mQW.quit();
                    eVar.mQW = null;
                }
                eVar.mQZ = null;
                if (eVar.mQX != null) {
                    eVar.mQX.quit();
                    eVar.mQX = null;
                }
                eVar.mRa = null;
                aNC().mQG = null;
                mQJ = null;
            }
        }
    }

    public static ArrayList<GalleryItem$MediaItem> aNG() {
        return aNC().mQH;
    }

    public static HashSet<GalleryItem$MediaItem> aNH() {
        return aNC().mQO;
    }

    public static ArrayList<Bundle> aNI() {
        return aNC().mQP;
    }

    public static LinkedHashSet<GalleryItem$MediaItem> aNJ() {
        return aNC().mQI;
    }

    public static void w(ArrayList<GalleryItem$MediaItem> arrayList) {
        aNC().mQH = arrayList;
    }

    public static void qi(int i) {
        aNC().mQQ.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public static void aNK() {
        aNC().mQQ.clear();
    }

    public static int aNL() {
        return aNC().mQQ.size();
    }

    public static void a(a aVar, int i, boolean z) {
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        int i2;
        int size;
        if (aNC().mQE.aOh() == 3) {
            i2 = 1;
        } else if (aNC().mQE.aOh() == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (aNC().mQO != null) {
            size = aNC().mQO.size();
        } else {
            size = 0;
        }
        x.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size)});
        if (size > 0) {
            aVar.aj(13858, i2 + "," + i + "," + size + ",0");
        }
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[]{Boolean.valueOf(aVar.fp(true))});
        Iterator it = aNC().mQP.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!r4) {
                x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[]{string});
                FileOp.deleteFile(string);
                d.b(string, ac.getContext());
            }
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z2 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z3 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.GalleryCore";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z2 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(z3 ? 1 : 0);
            x.i(str, str2, objArr);
            if (size > 0) {
                try {
                    aVar.aj(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z2 ? 1 : 0) + "," + i7 + ",2" + (z3 ? 1 : 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
    }

    public static void a(a aVar, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        switch (aNC().mQE.aOh()) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!bh.ov(str) && str.equals(ac.getContext().getString(R.l.eeE))) {
                    i = 6;
                    break;
                }
            case 7:
            case 8:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        x.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[]{Integer.valueOf(r4)});
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        try {
            aVar.aj(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + mQK + "," + mQL + "," + mQM + "," + mQN);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        mQK = false;
        mQL = false;
        mQM = false;
        mQN = false;
    }
}

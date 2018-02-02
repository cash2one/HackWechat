package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;

public final class BackwardSupportUtil {

    public static class ExifHelper {

        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new Creator<LatLongData>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.fzt = parcel.readFloat();
                    latLongData.hBL = parcel.readFloat();
                    return latLongData;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }
            };
            public float fzt;
            public float hBL;

            public LatLongData() {
                this.fzt = 0.0f;
                this.hBL = 0.0f;
            }

            public LatLongData(float f, float f2) {
                this.fzt = f;
                this.hBL = f2;
            }

            public int hashCode() {
                return ((int) (this.fzt * 10000.0f)) + ((int) (this.hBL * 10000.0f));
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof LatLongData)) {
                    return false;
                }
                LatLongData latLongData = (LatLongData) obj;
                if (Math.abs(this.fzt - latLongData.fzt) >= 1.0E-6f || Math.abs(this.hBL - latLongData.hBL) >= 1.0E-6f) {
                    return false;
                }
                return true;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeFloat(this.fzt);
                parcel.writeFloat(this.hBL);
            }
        }

        public static int UJ(String str) {
            if (bh.ov(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return 0;
            } else if (FileOp.bO(str)) {
                return Exif.fromFile(str).getOrientationInDegree();
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return 0;
            }
        }

        public static LatLongData UK(String str) {
            if (bh.ov(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return null;
            } else if (FileOp.bO(str)) {
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                if (location == null) {
                    return null;
                }
                LatLongData latLongData = new LatLongData();
                latLongData.fzt = (float) location.latitude;
                latLongData.hBL = (float) location.longitude;
                return latLongData;
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return null;
            }
        }
    }

    public static class a {
        public static void c(View view, Animation animation) {
            if (VERSION.SDK_INT >= 8) {
                c cVar = new c();
                animation.cancel();
                return;
            }
            b bVar = new b();
            if (view != null) {
                view.setAnimation(null);
            }
        }
    }

    public static class b {
        public static Bitmap b(String str, float f) {
            float f2 = 160.0f * f;
            Bitmap c = d.c(str, f);
            if (c != null) {
                c.setDensity((int) f2);
            }
            return c;
        }

        public static int b(Context context, float f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return Math.round((((float) displayMetrics.densityDpi) * f) / 160.0f);
        }

        public static Bitmap a(InputStream inputStream, float f) {
            float f2 = 160.0f * f;
            Bitmap a = d.a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            return a;
        }

        public static String eG(Context context) {
            String str;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= DownloadHelper.SAVE_FATOR) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            return str + (configuration.orientation == 2 ? "_L" : "_P");
        }
    }

    public static class c {
        public static void a(ListView listView) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bb bbVar = new bb();
                    if (listView.getFirstVisiblePosition() > 10) {
                        listView.setSelection(10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                }
                ba baVar = new ba();
                listView.setSelection(0);
            }
        }

        public static void b(ListView listView, int i) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bb bbVar = new bb();
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
                        listView.setSelection(i + 10);
                    } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
                        listView.setSelection(i - 10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(i);
                        return;
                    }
                    return;
                }
                ba baVar = new ba();
                listView.setSelection(i);
            }
        }
    }
}

package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.g(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final Bundle mExtras;
    private final String uT;
    private final CharSequence uU;
    private final CharSequence uV;
    private final CharSequence uW;
    private final Bitmap uX;
    private final Uri uY;
    private final Uri uZ;
    private Object va;

    public static final class a {
        Bundle mExtras;
        String uT;
        CharSequence uU;
        CharSequence uV;
        CharSequence uW;
        Bitmap uX;
        Uri uY;
        Uri uZ;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.uT = str;
        this.uU = charSequence;
        this.uV = charSequence2;
        this.uW = charSequence3;
        this.uX = bitmap;
        this.uY = uri;
        this.mExtras = bundle;
        this.uZ = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.uT = parcel.readString();
        this.uU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uW = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uX = (Bitmap) parcel.readParcelable(null);
        this.uY = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.uZ = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.uT);
            TextUtils.writeToParcel(this.uU, parcel, i);
            TextUtils.writeToParcel(this.uV, parcel, i);
            TextUtils.writeToParcel(this.uW, parcel, i);
            parcel.writeParcelable(this.uX, i);
            parcel.writeParcelable(this.uY, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.uZ, i);
            return;
        }
        Object obj;
        if (this.va != null || VERSION.SDK_INT < 21) {
            obj = this.va;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.uT);
            builder.setTitle(this.uU);
            builder.setSubtitle(this.uV);
            builder.setDescription(this.uW);
            builder.setIconBitmap(this.uX);
            builder.setIconUri(this.uY);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.uZ == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.uZ);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.uZ);
            }
            this.va = builder.build();
            obj = this.va;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.uU + ", " + this.uV + ", " + this.uW;
    }

    public static MediaDescriptionCompat g(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        a aVar = new a();
        aVar.uT = ((MediaDescription) obj).getMediaId();
        aVar.uU = ((MediaDescription) obj).getTitle();
        aVar.uV = ((MediaDescription) obj).getSubtitle();
        aVar.uW = ((MediaDescription) obj).getDescription();
        aVar.uX = ((MediaDescription) obj).getIconBitmap();
        aVar.uY = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                aVar.mExtras = bundle;
                if (uri != null) {
                    aVar.uZ = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    aVar.uZ = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uT, aVar.uU, aVar.uV, aVar.uW, aVar.uX, aVar.uY, aVar.mExtras, aVar.uZ);
                mediaDescriptionCompat.va = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        aVar.mExtras = bundle;
        if (uri != null) {
            aVar.uZ = uri;
        } else if (VERSION.SDK_INT >= 23) {
            aVar.uZ = ((MediaDescription) obj).getMediaUri();
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uT, aVar.uU, aVar.uV, aVar.uW, aVar.uX, aVar.uY, aVar.mExtras, aVar.uZ);
        mediaDescriptionCompat.va = obj;
        return mediaDescriptionCompat;
    }
}

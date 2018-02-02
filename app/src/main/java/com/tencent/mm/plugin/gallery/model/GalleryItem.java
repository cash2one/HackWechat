package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;

public final class GalleryItem {

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new 1();
        public String hOp;
        public String hOq;
        public int hOr = -1;
        public int hOs = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String aNV() {
            if (bh.ov(this.mld)) {
                return this.hOo;
            }
            return this.mld;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hOo);
            parcel.writeString(this.mld);
            parcel.writeLong(this.mRf);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.hOr);
            parcel.writeString(this.hOp);
            parcel.writeString(this.hOq);
            parcel.writeInt(this.hOs);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
        }

        public String toString() {
            return "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.hOp + '\'' + ", audioTrackMime='" + this.hOq + '\'' + ", durationMs=" + this.hOr + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hOs + ", videoFrameRate=" + this.videoFrameRate + '}';
        }
    }
}

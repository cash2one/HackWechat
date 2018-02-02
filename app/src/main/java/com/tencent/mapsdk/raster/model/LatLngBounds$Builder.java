package com.tencent.mapsdk.raster.model;

public final class LatLngBounds$Builder {
    private double mEast = Double.NaN;
    private double mNorth = Double.NEGATIVE_INFINITY;
    private double mSouth = Double.POSITIVE_INFINITY;
    private double mWest = Double.NaN;

    private boolean containsLongitude(double d) {
        return this.mWest <= this.mEast ? this.mWest <= d && d <= this.mEast : this.mWest <= d || d <= this.mEast;
    }

    public final LatLngBounds build() {
        return new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
    }

    public final LatLngBounds$Builder include(LatLng latLng) {
        this.mSouth = Math.min(this.mSouth, latLng.getLatitude());
        this.mNorth = Math.max(this.mNorth, latLng.getLatitude());
        double longitude = latLng.getLongitude();
        if (Double.isNaN(this.mWest)) {
            this.mWest = longitude;
        } else {
            if (!containsLongitude(longitude)) {
                if (LatLngBounds.access$400(this.mWest, longitude) < LatLngBounds.access$500(this.mEast, longitude)) {
                    this.mWest = longitude;
                }
            }
            return this;
        }
        this.mEast = longitude;
        return this;
    }

    public final LatLngBounds$Builder include(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng include : iterable) {
                include(include);
            }
        }
        return this;
    }
}

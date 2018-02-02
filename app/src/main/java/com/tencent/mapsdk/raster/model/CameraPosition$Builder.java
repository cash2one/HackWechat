package com.tencent.mapsdk.raster.model;

public final class CameraPosition$Builder {
    private LatLng target;
    private float zoom = -1.0f;

    public CameraPosition$Builder(CameraPosition cameraPosition) {
        target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
    }

    public final CameraPosition build() {
        return new CameraPosition(this.target, this.zoom);
    }

    public final CameraPosition$Builder target(LatLng latLng) {
        this.target = latLng;
        return this;
    }

    public final CameraPosition$Builder zoom(float f) {
        this.zoom = f;
        return this;
    }
}

package com.example.map;

/**
 * MapMarker now stores only extrinsic state.
 *
 * Self note:
 * pehle yaha new MarkerStyle ban raha tha.
 * ab style factory se milega aur shared hoga.
 */
public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;

    // intrinsic shared object
    private final MarkerStyle style;

    public MapMarker(double lat, double lng, String label, MarkerStyle style) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.style = style;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getLabel() {
        return label;
    }

    public MarkerStyle getStyle() {
        return style;
    }
}
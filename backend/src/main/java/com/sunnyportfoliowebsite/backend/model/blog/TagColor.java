package com.sunnyportfoliowebsite.backend.model.blog;

public enum TagColor {
    BLUE("#253571"),
    YELLOW("#fac84c"),
    RED("#e3273d"),
    DEFAULT("#D3D3D3");

    public final String hexCode;

    TagColor(String hexCode) {
        this.hexCode = hexCode;
    }
}

package com.anything.reflection.reflection_with_field.data;

import java.util.Arrays;

public class UserInterfaceConfig {

    private String titleColor;
    private String footerSize;
//    private short titleFontSize;
//    private short footerFontSize;

    private String[] titleFonts;
    private short[] titleTextSizes;

    public String getTitleColor() {
        return titleColor;
    }

    public String getFooterSize() {
        return footerSize;
    }

    public String[] getTitleFonts() {
        return titleFonts;
    }

    public short[] getTitleTextSizes() {
        return titleTextSizes;
    }

    @Override
    public String toString() {
        return "UserInterfaceConfig{" +
                "titleColor='" + titleColor + '\'' +
                ", footerSize='" + footerSize + '\'' +
                ", titleFonts=" + Arrays.toString(titleFonts) +
                ", titleTextSizes=" + Arrays.toString(titleTextSizes) +
                '}';
    }
}

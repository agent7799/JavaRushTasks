package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageType) {
        if (imageType == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");}
        switch (imageType) {
            case BMP:
                return new BmpReader();
            case PNG:
                return new PngReader();
            case JPG:
                return new JpgReader();
            default:
                    throw new IllegalStateException("Unexpected value: " + imageType);

                        }


    }
}

package com.example.watershed;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Created by changliu on 5/16/16.
 */
public class WatershedSegmenter {
    private Mat markers = new Mat();

    public void setMarkers(Mat markerImage) {
        markerImage.convertTo(markers, CvType.CV_32SC1);
    }

    public Mat process(Mat image) {
        Imgproc.watershed(image, markers);
        markers.convertTo(markers, CvType.CV_8U);
        return markers;
    }
}
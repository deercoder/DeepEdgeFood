README
====

Author: Chang Liu

##Overview

This project is for the image preprocessing running on android device,
we prototype some traditional image segmentation algorithms(for example,
watershed, OSTU) running on the PC devices using C++ or python.

Then we build Android application using Java, NDK with OpenCV support for
implementing on smart phone device. This segmentation algorithm is useful
for reducing abundant information and thus reducing the reponse time due
to less transmission data size


##Structure

* prototype: segmentation algorithm implementation running on PC
* watershed: Android application for watershed segmentation algorithm(**)
* OpenCVDemo-native: native watershed algorithm implementation

(**): use this as our app for the DeepFood system.

##Guide

The android project adds FULL suport of OpenCV for Java, I ported the WHOLE
java sdk to our project and set the build rules. In this way, not only
OpenCV4Android is supported(as Java sdk includes the android classes), but
also some very common image processing classes written in Java(imagecodes, imgproc...).

There is also a related trial of OpenCV native project, but it's not FULLY
support due to the native compatibility(and some native build path problem)

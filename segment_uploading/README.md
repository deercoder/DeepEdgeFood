README
====

Author: Chang Liu

##Overview

This project is for the image uploading, after the image preprocessing, we got the segments
and the next step is to upload the segments into the cloud server.

In the server side, we deployed using Django(check [here](https://github.com/csuml/csr/tree/master/3_Cloud_Servers/2016_04_RESTful_Server_django)).
In the client side, we can use HTTP POST request to send image when setting the url and image file.


##Structure

* ImageUploadSample: This project use two methods for uploading image into our cloud server.
* Workaround: This guide gives another way for running python on android and uploading image to cloud server. (**)

(**): use this as our method for image uploading in DeepFood system.

##Guide

This function depends heavily on the server deployment. We need to first make sure that server is running well.

By default, there is some problem for the Django web service [here](https://github.com/csuml/csr/tree/master/3_Cloud_Servers/2016_04_RESTful_Server_django),
as it hard-coded some path, and also the deepnet model(which is not applicable in other servers if we deployed in another server/machine).

Fix the deployment issue and then use the test code here to make sure it works(otherwise it never communciates!):

```
#!/usr/bin/env python
import requests
url = 'http://129.63.16.66:8000/image/'
headers = {'Content-type': 'multipart/form-data'}
files = {'image': open(YOUR_IMAGE_PATH, 'rb')}
r = requests.post(url, files=files, data=headers)
# check Response
print r.status_code
```

**NOTE**: the above code's post request should be `data=headers`, pay attention to the README of the project, as it contains some slight error.(for example, `header=header`
in that README).


###Method1
After that, build the android application for uploading image using HttpClient, HttpCore, HttpMime(Apache), download the `jar` and add dependance and use those API. It's
deprecated by default in android to use some of the main interface of HttpClient, so use Apache jar libs.


    /**
     *  Upload image using the HTTP Post request, some problems here
     *  See another project for detailed debugging version, but still our Django project
     *  Kicks the POST request with ERROR_CODE = 400.
     *
     *  For another project##Image_Upload, I used some project the works well for other server,
     *  but it failed in our Django server deployed(this server can work for python version)
     *  I think the interface is more python-friendly, for demo check upload_demo folder's python code
     *
     *
     *  There is a workaround, we can use python on our android device. Install **Qpython** on android,
     *  and also **pip install requests** using Qpython, which will include necessary python packages.
     *  Then, we can excute the python script, and our server will receive the image(check aaa.py for
     *  details that will work.
     *
     */


However it failed with strange error(the same problem works for other server). It should be related with python and Django environment. I used same post request but in Android Java libs it's have different result. The RESTful api and server deployment is more friendly to Python calling.

###Method2

Install **Qpython** on android, and also **pip install requests** using Qpython, which will include necessary python packages.
Then, we can excute the python script, and our server will receive the image(check aaa.py for details that will work)




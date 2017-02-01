#!/usr/bin/env python
import requests
url = 'http://129.63.16.64:8000/image/'
headers = {'Content-type': 'multipart/form-data'}
files = {'image': open("/storage/emulated/0/DCIM/Camera/IMG_20160516_213630.jpg", 'rb')}
r = requests.post(url, files=files, data=headers)
#r = requests.post(url, files=files, headers=headers) # bug, for error 400
# check Response
print r.status_code

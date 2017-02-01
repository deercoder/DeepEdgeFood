#!/usr/bin/env python
import requests
url = 'http://129.63.16.64:8000/image/'
headers = {'Content-type': 'multipart/form-data'}
files = {'image': open("/home/changliu/workspace/watershed/upload_demo/ic_launcher.png", 'rb')}
r = requests.post(url, files=files, data=headers)
#r = requests.post(url, files=files, headers=headers) # bug, for error 400
# check Response
print r.status_code

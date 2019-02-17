# -*- coding: utf-8 -*-
# @Time    : 2019-02-17 17:44
# @Author  : Zicco1
# @Email   : zhigesayhi@gmail.com
# @File    : urls.py
# @Software: PyCharm

import os

from django.conf.urls import url
from django.views.static import serve

from .controller import handler

ueditor_path = os.path.join(os.path.dirname(__file__), "static")

urlpatterns = [
    url(r'^$', handler),
    url(r'^static/(?P<path>.*)$', serve, {'document_root': ueditor_path}),
]

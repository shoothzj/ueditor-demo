# -*- coding: utf-8 -*-
# @Time    : 2019-02-17 17:30
# @Author  : Zicco1
# @Email   : zhigesayhi@gmail.com
# @File    : view.py
# @Software: PyCharm

from django.shortcuts import render_to_response


def index(request):
    return render_to_response('index.html')

# -*- coding: utf-8 -*-
# @Time    : 2019-02-17 17:30
# @Author  : Zicco1
# @Email   : zhigesayhi@gmail.com
# @File    : view.py
# @Software: PyCharm

from django.shortcuts import render


def index(request):
    return render(request, 'index.html', context={})

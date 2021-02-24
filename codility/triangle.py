# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:47:43 2018

@author: daniels
"""

def triplet_triangle(arr):
    arr.sort()
    for i in range(0, (len(arr)-2)):
        if((arr[i]+arr[i+1])>arr[i+2]):
            return 1
    return 0
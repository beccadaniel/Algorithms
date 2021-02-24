# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:48:08 2018

@author: daniels
"""

def distinct(arr):
    arr.sort()
    distinct_counter = 1
    if(len(arr) == 0):
        return 0
    for k in range(1, len(arr)):
        if(arr[k-1]!=arr[k]):
            distinct_counter += 1
    return distinct_counter
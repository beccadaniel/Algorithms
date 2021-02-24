# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:45:46 2018

@author: daniels
"""

def count_div(x,y,z):
    import math
    if (x % z == 0):
        return math.floor((y - x) / z + 1);
    else:
        return math.floor((y - (x - x % z )) / z);
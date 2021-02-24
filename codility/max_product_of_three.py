# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:48:32 2018

@author: daniels
"""

def max_product_of_three(arr):
    arr.sort()
    max_product = 0
    
    if((arr[-1]*arr[0]*arr[1])>(arr[-1]*arr[-2]*arr[-3])):
        return (arr[-1]*arr[0]*arr[1])
    else:
        return (arr[-1]*arr[-2]*arr[-3])
        
    return max_product
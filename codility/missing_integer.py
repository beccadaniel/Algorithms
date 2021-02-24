# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:46:24 2018

@author: daniels
"""

def missing_integer(list_a):
    count_arr = [0]*(max(list_a)+5) # just to make sure my array is large enough
    for i in range(0,len(list_a)):
        if list_a[i] >= 0:
            count_arr[list_a[i]] += 1
            
    for j in range(1, len(count_arr)):
        if count_arr[j] is 0:
            ans = j
            break;
    return ans
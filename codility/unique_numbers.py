# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:47:10 2018

@author: daniels
"""

def unique_numbers(array):          # O(n+m)
    count = [0]*(max(array)+1)
    for i in range(0, len(array)):  # O(n)
        count[array[i]] += 1
    p = 0
    for j in range(0, len(count)):  # O(m)
        if count[j] is 1:
            p += 1
    return p
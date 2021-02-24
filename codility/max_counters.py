# -*- coding: utf-8 -*-
"""
Created on Fri Mar 16 23:46:46 2018

@author: daniels
"""

def max_counters(array, N):
    counter = [0]*N
    max_element = 0
    current_max_element = 0
    for i in range(0, len(array)):
        if 1 <= array[i] and array[i] < (N+1):
            if max_element > counter[array[i]-1]:
                counter[array[i]-1] = max_element
            counter[array[i]-1] += 1
            if counter[array[i]-1] > current_max_element:
                current_max_element = counter[array[i]-1]
        else:
            max_element = current_max_element
            #counter = [max_element] * N
            
    for j in range(0, len(counter)):
        if counter[j] < max_element:
            counter[j] = max_element
            
    return counter
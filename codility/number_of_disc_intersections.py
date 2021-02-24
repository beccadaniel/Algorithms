# -*- coding: utf-8 -*-
"""
Created on Fri Mar  9 00:27:06 2018

@author: daniels
"""

def number_of_disc_intersection(arr):
    n = len(arr)
    add_array = [0] * n
    sub_array = [0] * n
    count = 0
    no_of_iterations = 0
    no_of_intersections = 0
    for i in range(0, n):
        add_array[i] = i + arr[i]
        sub_array[i] = i - arr[i]
    add_array.sort()
    sub_array.sort()
    
    for r in range(0,n):
        if(add_array[0] >= sub_array[r]):
            count += 1
        else:
            break
    for j in range(0, n):
        for k in range(count,n):
            if add_array[j] >= sub_array[k]:
                count += 1 
            else:
                break
        no_of_intersections += count - 1 - no_of_iterations
        no_of_iterations += 1    
    if (no_of_intersections > 10000000):
        return -1
    return no_of_intersections

# Watersheds
Problem B. Watersheds from the Qualification Round of the 2009 Google Code Jam

https://code.google.com/codejam/contest/90101/dashboard#s=p1

## Problem

Geologists sometimes divide an area of land into different regions based on where rainfall flows down to. These regions are called drainage basins.

Given an elevation map (a 2-dimensional array of altitudes), label the map such that locations in the same drainage basin have the same label, subject to the following rules.

From each cell, water flows down to at most one of its 4 neighboring cells.
For each cell, if none of its 4 neighboring cells has a lower altitude than the current cell's, then the water does not flow, and the current cell is called a sink.
Otherwise, water flows from the current cell to the neighbor with the lowest altitude.
In case of a tie, water will choose the first direction with the lowest altitude from this list: North, West, East, South.
Every cell that drains directly or indirectly to the same sink is part of the same drainage basin. Each basin is labeled by a unique lower-case letter, in such a way that, when the rows of the map are concatenated from top to bottom, the resulting string is lexicographically smallest. (In particular, the basin of the most North-Western cell is always labeled 'a'.)

## Input

The first line of the input file will contain the number of maps, T. T maps will follow, each starting with two integers on a line -- H and W -- the height and width of the map, in cells. The next H lines will each contain a row of the map, from north to south, each containing W integers, from west to east, specifying the altitudes of the cells.

## Output

For each test case, output 1+H lines. The first line must be of the form

Case #X:
where X is the test case number, starting from 1. The next H lines must list the basin labels for each of the cells, in the same order as they appear in the input.

## Limits

T ≤ 100;
Small dataset

1 ≤ H, W ≤ 10;
0 ≤ altitudes < 10.
There will be at most two basins.

Large dataset

1 ≤ H, W ≤ 100;
0 ≤ altitudes < 10,000.
There will be at most 26 basins.

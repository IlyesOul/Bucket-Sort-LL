# Bucket-Sort-LL
This program is essentially bucket sort but with an array and several linked lists, as opposed to a 2D array

So the original 0-9 array is retained, but when numbers are distributed to each of these indexes, they're appended in the form of several linked lists.
This ensures that only the base necessity of space is used, and also that the lists can grow to an arbitrary length without having to duplicate themselves.

This programs average runtime is O(n), and only O(n^2) in certain circumstances

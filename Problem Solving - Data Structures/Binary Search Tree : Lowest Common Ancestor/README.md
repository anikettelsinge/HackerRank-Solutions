# Link to the problem:
https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

# Solution explained:
- Tree is traversed using Breadth First Search technique
- For each node traversed, whether given two values appear in child subtrees or not is checked.
- Because tree is traversed in BFS manner, ancestor of lowest depth is returned as result as root can also be considered as ancestor for any two subtree values.

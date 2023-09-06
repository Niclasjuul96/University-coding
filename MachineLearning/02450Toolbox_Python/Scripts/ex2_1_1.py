# exercise 2.1.1
import numpy as np
import xlrd

# Load xls sheet with data

doc = xlrd.open_workbook('/Users/niclasjuulschaeffer/University-coding/MachineLearning/02450Toolbox_Python/Data/nanonose.xls').sheet_by_index(0)

# Extract attribute names (1st row, column 4 to 12)
attributeNames = doc.row_values(0, 3, 11)

# Extract class names to python list,
# then encode with integers (dict)
classLabels = doc.col_values(0, 2, 92)
classNames = sorted(set(classLabels))
classDict = dict(zip(classNames, range(5)))

# Extract vector y, convert to NumPy array
y = np.asarray([classDict[value] for value in classLabels])

# Preallocate memory, then extract excel data to matrix X
X = np.empty((90, 8))
for i, col_id in enumerate(range(3, 11)):
    X[:, i] = np.asarray(doc.col_values(col_id, 2, 92))

# Compute values of N, M and C.
N = len(y) #objects
M = len(attributeNames) #Atributes A-H
C = len(classNames) # Different sample types

print(N)
print(M)
print(C)
print('Outputs 90 objects and 8 atributes of each object, that means we have a 90x8 matrix')
print('Ran Exercise 2.1.1')
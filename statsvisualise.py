import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

data = {
    'ID': [1, 2, 3, 4, 5],
    'Name': ['John Doe', 'Jane Smith', 'John Doe', 'Emily Wong', np.nan],
    'Age': [28, np.nan, 28, 45, 35],
    'Salary': [50000, 55000, 50000, np.nan, 60000],
    'City': ['New York', 'San Francisco', 'New York', 'Los Angeles', 'Chicago']
}

df = pd.DataFrame(data)
df['Age'].fillna(df['Age'].mean(), inplace=True)
df['Salary'].fillna(df['Salary'].mean(), inplace=True)
df['Name'].fillna('Unknown', inplace=True)
df.drop_duplicates(inplace=True)

summary = df.describe()
print("Statistical Summary:\n", summary)

plt.plot(df['Age'], df['Salary'], color='green')
plt.xlabel('Age')
plt.ylabel('Salary')
plt.title('Line Plot: Age vs Salary')
plt.show()

plt.scatter(df['Age'], df['Salary'])
plt.xlabel('Age')
plt.ylabel('Salary')
plt.title('Scatter Plot: Age vs Salary')
plt.show()

plt.hist(df['Age'])
plt.xlabel('Age')
plt.ylabel('Frequency')
plt.title('Histogram of Age')
plt.show()

plt.hist(df['Salary'], bins=10, edgecolor='black')
plt.xlabel('Salary')
plt.ylabel('Frequency')
plt.title('Histogram of Salary')
plt.show()

plt.figure(figsize=(8, 6))
sns.boxplot(data=df, y='Age', color='lightblue')
plt.title('Box Plot of Age')
plt.ylabel('Age')
plt.show()

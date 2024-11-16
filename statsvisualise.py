import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv('sample.csv')

df['M1'].fillna(df['M1'].mean(), inplace=True)
df['PHY'].fillna(df['PHY'].mean(), inplace=True)

df.drop_duplicates(inplace=True)

metadata = {
    "Total Rows": df.shape[0],
    "Total Columns": df.shape[1],
    "Columns Info": df.dtypes.to_dict(),
    "Missing Values": df.isnull().sum().to_dict()
}
print("\nDataset Metadata:\n", metadata)

stat_summary = df.describe(include='all')
print("\nStatistical Summary:\n", stat_summary)

plt.figure(figsize=(8, 6))
sns.boxplot(data=df[['M1', 'PHY']])
plt.title("Box Plot of M1 and PHY")
plt.ylabel("Values")
plt.xlabel("Fields")
plt.show()

plt.hist(df['M1'], bins=10, edgecolor='black', color='blue')
plt.title("Histogram of M1")
plt.xlabel('M1')
plt.ylabel('Frequency')
plt.show()

plt.plot(df['M1'], df['PHY'], color='green', marker='o')
plt.title("Line Plot: M1 vs PHY")
plt.xlabel("M1")
plt.ylabel("PHY")
plt.show()

plt.scatter(df['M1'], df['PHY'], color='red')
plt.title("Scatter Plot: M1 vs PHY")
plt.xlabel("M1")
plt.ylabel("PHY")
plt.show()

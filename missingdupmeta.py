import pandas as pd
data = {
    'Age': [25, 30, None, 28, 30, None],
    'Salary': [50000, 54000, 58000, None, 54000, 58000],
    'Department': ['HR', 'Finance', None, 'IT', 'Finance', 'IT']
}
df = pd.DataFrame(data)
df['Age'].fillna(df['Age'].mean(), inplace=True)
df['Salary'].fillna(df['Salary'].median(), inplace=True)
df['Department'].fillna(df['Department'].mode()[0], inplace=True)
df.drop_duplicates(inplace=True)
metadata = {
    "Rows": df.shape[0],
    "Columns": df.shape[1],
    "Columns Info": df.dtypes,
    "Null Values": df.isnull().sum()
}

print("Processed Data:\n", df)
print("\nDataset Metadata:\n", metadata)

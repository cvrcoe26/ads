import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
data = {
    'Forehead Wrinkle Count': [5, 1, 8, 3, 6, 7, 2, 10, 4, 5],
    'Skin Elasticity': [7, 9, 5, 8, 6, 4, 8, 3, 7, 6],
    'Hair Grayness': [2, 0, 8, 1, 4, 6, 1, 9, 3, 5],
    'Age': [45, 25, 60, 35, 50, 55, 30, 70, 40, 45]
}
df = pd.DataFrame(data)

X = df[['Forehead Wrinkle Count', 'Skin Elasticity', 'Hair Grayness']]
y = df['Age']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
mse = mean_squared_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)
print(f"Mean Squared Error: {mse}")
print(f"R² Score: {r2}")
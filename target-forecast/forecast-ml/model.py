from autogluon.tabular import TabularPredictor
import pandas as pd
import os

DATA_PATH = "data/product_data.csv"
MODEL_PATH = "model_store"

def train_model():
    df = pd.read_csv(DATA_PATH)
    predictor = TabularPredictor(label="sales_quantity", path=MODEL_PATH).fit(df)
    return predictor

def predict_sales(product_dict):
    df = pd.DataFrame([product_dict])
    predictor = TabularPredictor.load(MODEL_PATH)
    prediction = predictor.predict(df)
    return float(prediction.iloc[0])

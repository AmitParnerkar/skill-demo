from flask import Flask, request, jsonify
import pandas as pd
import os
from datetime import datetime
from model import train_model, predict_sales

app = Flask(__name__)
DATA_PATH = "data/product_data.csv"

@app.route("/fine-tune", methods=["POST"])
def fine_tune():
    if request.is_json:
        new_product = request.get_json()
        new_product["sales_quantity"] = new_product.get("sales_quantity", 0)
        df = pd.read_csv(DATA_PATH) if os.path.exists(DATA_PATH) else pd.DataFrame()
        df = pd.concat([df, pd.DataFrame([new_product])], ignore_index=True)
        df.to_csv(DATA_PATH, index=False)
        message = "Model retrained with new product."
    else:
        if not os.path.exists(DATA_PATH):
            return jsonify({"error": "No input provided and no product_data.csv found."}), 400
        message = "Model retrained using existing product_data.csv."

    train_model()
    return jsonify({"message": message})


@app.route("/predict", methods=["POST"])
def predict():
    product = request.json
    result = predict_sales(product)
    return jsonify({"predicted_sales_quantity": result})


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)

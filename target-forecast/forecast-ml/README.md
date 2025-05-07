docker run -it -v $pwd:/app -p 5080:5000 python:3.10 bash

docker buildx build --platform linux/amd64,linux/arm64 -t paam0101/target-forecast-ml --push .
pip freeze > requirements.txt
docker system prune -f

Suggested Model: AutoGluon TabularPredictor
Why?

Excellent for tabular data.

Automatically ensembles LightGBM, CatBoost, and neural nets.

Easy to train and incrementally update (pseudo fine-tuning).

Runs fast locally and supports saving/loading models.

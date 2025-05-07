# skill-demo

Target-forecasting application

## Getting Started Locally

### 1. Clone the Repository

```bash
git clone https://github.com/AmitParnerkar/skill-demo.git
```
### 2. Start Target-demo app

```bash
cd target-demo
./gradlew clean
./gradlew build
docker compose up -d
```
### 3. Start Target-forecast app

```bash
cd target-forecast
./gradlew clean
./gradlew build
docker compose up -d
```
### 3. Testing the app
- Target-demo URL: `http://<your-machine>:8080`
- kafka URL: `http://<your-machine>:8081`
- Target-forecast: `http://<your-machine>:8082/products`

### 4. upload a file to see events flowing
```code
curl --location 'localhost:8080/products' \
--form 'file=@"/Users/amitparnerkar/Downloads/sample_products.xlsx"'
```

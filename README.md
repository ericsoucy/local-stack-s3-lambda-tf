# Localstack S3 and Java Lambda Example
Based on <https://codetinkering.com/localstack-s3-lambda-example-docker/>

```bash
## debug
aws lambda list-functions --endpoint-url http://localhost:4566 --profile local

aws lambda get-function --function-name examplelambda --endpoint-url http://localhost:4566 --profile local


aws s3 cp samplefile.txt s3://my-event-bucket-terraform/samplefile.txt --endpoint-url http://localhost:4566 --profile local

aws lambda delete-function --function-name examplelambda --endpoint-url http://localhost:4566 --profile local
```

terraform apply -auto-approve
resource "aws_lambda_function" "example_lambda" {
  function_name = "examplelambda"
  role          = "arn:aws:iam::12345:role/ignoreme"
  runtime       = "java11"
  handler       = "com.example.localstacks3lambda.BucketHandler"
  filename      = "../target/localstack-s3-lambda-0.0.1-SNAPSHOT-aws.jar"

}
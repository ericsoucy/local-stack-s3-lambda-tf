# Create Bucket
resource "aws_s3_bucket" "event_bucket" {
  bucket = "my-event-bucket-terraform"
  acl    = "public-read"
}
resource "aws_s3_bucket_notification" "bucket_notification" {
  #bucket = "aws_s3_bucket.event_bucket"
  bucket = "my-event-bucket-terraform"

  lambda_function {
    id                  = "1234567890123"
    lambda_function_arn = "arn:aws:lambda:ca-central-1:000000000000:function:examplelambda"
    events              = ["s3:ObjectCreated:*"]

  }

  #depends_on = [aws_lambda_permission.allow_bucket]
}
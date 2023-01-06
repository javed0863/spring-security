# spring-security-jwt

This sample shows:
* Create a custom Authentication filter for JWT operations
* Create and Validate the JWT token
* Secure API using JWT Bearer token.

```
Authentication Request:

curl --location --request POST 'http://localhost:8080/api/v1/auth/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "john@gmail.com",
    "password": "pass"
}'

Response:
{
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGdtYWlsLmNvbSIsImNsYWltcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiZXhwIjoxNjczMDUyNTIwLCJpYXQiOjE2NzMwMTY1MjB9.LxZk-RhodBR2DpdfpwyUlXtPPA7P88pAiTucDbakRlg"
}

Accessing Secured API:
curl --location --request GET 'http://localhost:8080/api/v1/greet' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGdtYWlsLmNvbSIsImNsYWltcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiZXhwIjoxNjczMDUyNTIwLCJpYXQiOjE2NzMwMTY1MjB9.LxZk-RhodBR2DpdfpwyUlXtPPA7P88pAiTucDbakRlg'

Response: Hello from our API

```
